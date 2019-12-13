package com.monkeydp.daios.dm.mysql.config

import com.monkeydp.daios.dm.base.LocalConfig
import com.monkeydp.daios.dm.base.jdbc.datasource.JdbcDsDefs
import com.monkeydp.daios.dm.mysql.MysqlConfig
import com.monkeydp.daios.dm.mysql.MysqlDefs
import com.monkeydp.daios.dm.mysql.mocker.MysqlCpMocker
import com.monkeydp.daios.dms.sdk.conn.ConnProfile
import com.monkeydp.daios.dms.sdk.datasource.DsDef
import com.monkeydp.tools.ext.java.singletonX
import com.monkeydp.tools.ext.kodein.KodeinTag.TEST
import com.monkeydp.tools.ext.kodein.bindKClass
import com.monkeydp.tools.ext.kodein.bindMapX
import com.monkeydp.tools.ext.kodein.bindX
import com.monkeydp.tools.ext.kodein.component.KodeinComponent
import org.kodein.di.Kodein
import org.kodein.di.LateInitKodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation

/**
 * @author iPotato
 * @date 2019/12/4
 */
internal val kodein = LateInitKodein()

internal fun initKodein(vararg modules: Kodein.Module) =
        Kodein {
            modules.forEach { import(it) }
            
            MysqlConfig.components.forEach {
                when (it) {
                    is KClass<*> -> bindKClass(it) with singleton { it as KClass<out Any> }
                    else -> bindX(it) with singleton { it }
                }
            }
            
            MysqlConfig.componentsMap.forEach { (annotKClass, components) ->
                val kodeinComponent = annotKClass.findAnnotation<KodeinComponent<Any>>()!!
                val mapGeneratorKClass = kodeinComponent.mapGeneratorKClass
                if (mapGeneratorKClass == Nothing::class) return@forEach
                
                val genType = mapGeneratorKClass.java.genericSuperclass as ParameterizedType
                val mapType = ParameterizedTypeImpl.make(Map::class.java, genType.actualTypeArguments, null)
                val mapGenerator = mapGeneratorKClass.java.singletonX()
                val map = mapGenerator.generate(components)
                bindMapX(mapType, annotKClass) with singleton { map }
            }
            
            bind<LocalConfig>() with singleton { MysqlConfig }
            
            // ==== ds def ====
            val dsDefs: JdbcDsDefs = MysqlDefs
            bind<JdbcDsDefs>() with singleton { dsDefs }
            bind<Set<DsDef>>() with singleton { dsDefs.toSet() }
            
            // ==== test data ====
            bind<Set<ConnProfile>>(TEST) with singleton { MysqlCpMocker.cpSet }
        }