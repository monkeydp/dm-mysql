package com.monkeydp.daios.dm.mysql

import com.monkeydp.daios.dm.base.AbstractDm
import com.monkeydp.daios.dm.base.LocalConfig
import com.monkeydp.daios.dm.mysql.api.MysqlMenuApi
import com.monkeydp.daios.dm.mysql.api.MysqlNodeApi
import com.monkeydp.daios.dm.mysql.config.MysqlMenuConfig
import com.monkeydp.daios.dm.mysql.config.MysqlNodeConfig
import com.monkeydp.daios.dm.mysql.conn.MysqlConnApi
import com.monkeydp.daios.dm.mysql.conn.MysqlCpFrom
import com.monkeydp.daios.dm.mysql.ext.distDirpath
import com.monkeydp.daios.dm.mysql.metadata.icon.MysqlIcon
import com.monkeydp.daios.dm.mysql.metadata.instruction.MysqlAction
import com.monkeydp.daios.dm.mysql.metadata.instruction.MysqlTarget
import com.monkeydp.daios.dm.mysql.mocker.MysqlCpMocker
import com.monkeydp.daios.dms.sdk.datasource.Datasource.MYSQL
import com.monkeydp.daios.dms.sdk.dm.DmImpl
import com.monkeydp.daios.dms.sdk.dm.DmShareConfig
import com.monkeydp.daios.dms.sdk.dm.DmTestdata
import com.monkeydp.tools.ext.notNullSingleton
import org.reflections.Reflections
import org.reflections.util.ClasspathHelper
import org.reflections.util.ConfigurationBuilder
import kotlin.properties.Delegates

/**
 * @author iPotato
 * @date 2019/10/8
 */
class MysqlDm(config: DmShareConfig? = null) : AbstractDm(config) {
    
    companion object {
        @Volatile
        private var isInitialized = false
        var INSTANCE by Delegates.notNullSingleton<MysqlDm>()
            private set
    }
    
    override val datasource = MYSQL
    override val dsDefs = listOf(MysqlDefs.Mysql57, MysqlDefs.Mysql80)
    override val impl = object : DmImpl {
        override val apis = object : DmImpl.Apis {
            override val connApi = MysqlConnApi
            override val nodeApi = MysqlNodeApi
            override val menuApi = MysqlMenuApi
        }
        override val classes = object : DmImpl.Classes {
            override val cpFormClass = MysqlCpFrom::class
        }
        override val enumClasses = object : DmImpl.EnumClasses {
            override val dsVersionClass = MysqlVersion::class
            override val actionClass = MysqlAction::class
            override val targetClass = MysqlTarget::class
            override val iconClass = MysqlIcon::class
        }
    }
    override val testdata = object : DmTestdata {
        override val cps = MysqlCpMocker.cps
    }
    
    override val config = object : LocalConfig() {
        private val packageName = this.javaClass.`package`.name
        private val classLoader = this.javaClass.classLoader
        override val nodeConfig = object : NodeConfig() {
            override val struct by lazy { MysqlNodeConfig.structure }
            private val urls =
                    ClasspathHelper.forPackage(packageName, classLoader)
            override val reflections = Reflections(ConfigurationBuilder()
                    .setUrls(urls)
                    .addClassLoader(classLoader)
            )
        }
        override val menuConfig = object : MenuConfig() {
            override val struct by lazy { MysqlMenuConfig.structure }
            private val urls =
                    ClasspathHelper.forPackage(packageName, classLoader)
            override val reflections = Reflections(ConfigurationBuilder()
                    .setUrls(urls)
                    .addClassLoader(classLoader)
            )
        }
    }
    
    init {
        if (!isInitialized) {
            synchronized(MysqlDm::class) {
                if (!isInitialized) {
                    initialize()
                    INSTANCE = this
                }
            }
        }
    }
    
    override fun updateConfig(config: DmShareConfig) {
        distDirpath = config.deployDir.path
    }
}