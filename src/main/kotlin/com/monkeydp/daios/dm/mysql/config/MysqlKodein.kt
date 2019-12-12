package com.monkeydp.daios.dm.mysql.config

import com.monkeydp.daios.dm.base.LocalConfig
import com.monkeydp.daios.dm.base.jdbc.datasource.JdbcDsDefs
import com.monkeydp.daios.dm.mysql.MysqlConfig
import com.monkeydp.daios.dm.mysql.MysqlDefs
import com.monkeydp.daios.dm.mysql.mocker.MysqlCpMocker
import com.monkeydp.daios.dms.sdk.conn.ConnProfile
import com.monkeydp.daios.dms.sdk.datasource.DsDef
import com.monkeydp.tools.kodein.KodeinTag.TEST
import com.monkeydp.tools.kodein.bindKClass
import com.monkeydp.tools.kodein.bindX
import org.kodein.di.Kodein
import org.kodein.di.LateInitKodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton
import kotlin.reflect.KClass

/**
 * @author iPotato
 * @date 2019/12/4
 */
internal val kodein = LateInitKodein()

internal fun initKodein(vararg modules: Kodein.Module) =
        Kodein {
            modules.forEach { import(it) }
            
            val components = MysqlConfig.components
            components.forEach {
                when (it) {
                    is KClass<*> -> bindKClass(it) with singleton { it as KClass<out Any> }
                    else -> bindX(it.javaClass.kotlin) with singleton { it }
                }
            }
            
            bind<LocalConfig>() with singleton { MysqlConfig }
            
            // ==== ds def ====
            val dsDefs: JdbcDsDefs = MysqlDefs
            bind<JdbcDsDefs>() with singleton { dsDefs }
            bind<Set<DsDef>>() with singleton { dsDefs.toSet() }
            
            // ==== test data ====
            bind<Set<ConnProfile>>(TEST) with singleton { MysqlCpMocker.cpSet }
        }