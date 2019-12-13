package com.monkeydp.daios.dm.mysql.config

import com.monkeydp.daios.dm.mysql.config.MysqlComponentConfig.componentsMap
import com.monkeydp.tools.ext.java.singletonX
import com.monkeydp.tools.ext.kodein.bindKClass
import com.monkeydp.tools.ext.kodein.bindX
import com.monkeydp.tools.ext.kodein.component.KodeinComponent
import com.monkeydp.tools.ext.kodein.component.KodeinComponent.RegisterItem.*
import com.monkeydp.tools.ext.kotlin.classX
import com.monkeydp.tools.ext.kotlin.linesln
import com.monkeydp.tools.ext.main.ierror
import org.kodein.di.Kodein
import org.kodein.di.LateInitKodein
import org.kodein.di.generic.singleton
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation

/**
 * @author iPotato
 * @date 2019/12/4
 */
internal val kodein = LateInitKodein()