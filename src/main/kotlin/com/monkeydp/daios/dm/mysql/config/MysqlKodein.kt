package com.monkeydp.daios.dm.mysql.config

import com.monkeydp.daios.dm.base.jdbc.datasource.JdbcDsDefs
import com.monkeydp.daios.dm.mysql.MysqlDefs
import com.monkeydp.daios.dm.mysql.mocker.MysqlCpMocker
import com.monkeydp.daios.dms.sdk.conn.ConnProfile
import com.monkeydp.daios.dms.sdk.datasource.DsDef
import com.monkeydp.tools.ext.java.singletonX
import com.monkeydp.tools.ext.kodein.KodeinTag.TEST
import com.monkeydp.tools.ext.kodein.bindKClass
import com.monkeydp.tools.ext.kodein.bindX
import com.monkeydp.tools.ext.kodein.component.KodeinComponent
import com.monkeydp.tools.ext.kodein.component.KodeinComponent.RegisterItem.*
import com.monkeydp.tools.ext.kotlin.classX
import com.monkeydp.tools.ext.kotlin.kClassX
import com.monkeydp.tools.ext.kotlin.linesln
import com.monkeydp.tools.ext.main.ierror
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
            
            MysqlComponentConfig.componentsMap.forEach { (annotKClass, components) ->
                registerAll(annotKClass, components)
            }
            
            // ==== ds def ====
            val dsDefs: JdbcDsDefs = MysqlDefs
            bind<JdbcDsDefs>() with singleton { dsDefs }
            bind<Set<DsDef>>() with singleton { dsDefs.toSet() }
            
            // ==== test data ====
            bind<Set<ConnProfile>>(TEST) with singleton { MysqlCpMocker.cpSet }
        }


private fun Kodein.MainBuilder.registerAll(annotKClass: KClass<out Annotation>, components: Collection<Any>) {
    val kodeinComponent = annotKClass.findAnnotation<KodeinComponent<Any>>()!!
    kodeinComponent.registerItems.forEach {
        when (it) {
            COMPONENT -> registerComponents(components)
            LIST -> registerList(annotKClass, components)
            SET -> registerSet(annotKClass, components)
            MAP -> registerMap(annotKClass, components)
            else -> return@forEach
        }
    }
}

private fun Kodein.MainBuilder.registerComponents(components: Collection<Any>) {
    components.forEach { registerComponent(it) }
}

private fun Kodein.MainBuilder.registerComponent(component: Any) {
    when (component) {
        is KClass<*> -> bindKClass(component) with singleton { component as KClass<out Any> }
        else -> bindX(component) with singleton { component }
    }
}

private fun Kodein.MainBuilder.registerList(annotKClass: KClass<out Annotation>, components: Collection<Any>) {
    checkIfComponentsHaveSameGenericSuperclass(components)
    val parameterizedType = getParameterizedTyp<Set<*>>(components.first())
    bindX<List<*>>(parameterizedType, annotKClass) with singleton { components.toList() }
}

private fun Kodein.MainBuilder.registerSet(annotKClass: KClass<out Annotation>, components: Collection<Any>) {
    checkIfComponentsHaveSameGenericSuperclass(components)
    val parameterizedType = getParameterizedTyp<Set<*>>(components.first())
    bindX<Set<*>>(parameterizedType, annotKClass) with singleton { components.toSet() }
}

private fun Kodein.MainBuilder.registerMap(annotKClass: KClass<out Annotation>, components: Collection<Any>) {
    val kodeinComponent = annotKClass.findAnnotation<KodeinComponent<Any>>()!!
    val mapGeneratorKClass = kodeinComponent.mapGeneratorKClass
    if (mapGeneratorKClass == Nothing::class) ierror("Map generator kClass must not be Nothing::class!")
    
    val parameterizedType = getParameterizedTyp<Map<*, *>>(mapGeneratorKClass)
    val mapGenerator = mapGeneratorKClass.java.singletonX()
    val map = mapGenerator.generate(components)
    bindX<Map<*, *>>(parameterizedType, annotKClass) with singleton { map }
}

private fun checkIfComponentsHaveSameGenericSuperclass(components: Collection<Any>) {
    if (components.isEmpty()) return
    val genericSuperclass = components.first().classX.genericSuperclass
    components.forEach { component ->
        if (component.classX.genericSuperclass != genericSuperclass) {
            val superclasses = components.map { it.classX.genericSuperclass }
            ierror("Components must have same generic superclass, following generic superclasses are found: ${superclasses.linesln()}")
        }
    }
}

private inline fun <reified T> getParameterizedTyp(any: Any): ParameterizedType {
    val kClass = any.kClassX
    val type = kClass.java.genericSuperclass as ParameterizedType
    return ParameterizedTypeImpl.make(T::class.java, type.actualTypeArguments, null)
}