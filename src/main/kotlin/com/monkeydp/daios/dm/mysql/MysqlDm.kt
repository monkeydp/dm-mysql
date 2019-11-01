package com.monkeydp.daios.dm.mysql

import com.monkeydp.daios.dm.base.dm.AbstractDm
import com.monkeydp.daios.dm.mysql.conn.MysqlConnApi
import com.monkeydp.daios.dm.mysql.conn.MysqlCpFrom
import com.monkeydp.daios.dm.mysql.ext.distDirpath
import com.monkeydp.daios.dm.mysql.metadata.icon.MysqlIcon
import com.monkeydp.daios.dm.mysql.metadata.instruction.MysqlAction
import com.monkeydp.daios.dm.mysql.metadata.instruction.MysqlTarget
import com.monkeydp.daios.dm.mysql.metadata.node.MysqlNodeApi
import com.monkeydp.daios.dm.mysql.metadata.node.MysqlNodeStructWrapper
import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlConnNd
import com.monkeydp.daios.dm.mysql.mocker.MysqlCpMocker
import com.monkeydp.daios.dms.sdk.datasource.Datasource.MYSQL
import com.monkeydp.daios.dms.sdk.dm.DmImpl
import com.monkeydp.daios.dms.sdk.dm.DmShareConfig
import com.monkeydp.daios.dms.sdk.dm.DmTestdata
import org.reflections.Reflections
import org.reflections.util.ClasspathHelper
import org.reflections.util.ConfigurationBuilder

/**
 * @author iPotato
 * @date 2019/10/8
 */
class MysqlDm(config: DmShareConfig? = null) : AbstractDm(config) {
    
    override val datasource = MYSQL
    override val connNd = MysqlConnNd
    override val dsDefs = listOf(MysqlDefs.Mysql57, MysqlDefs.Mysql80)
    override val impl = object : DmImpl {
        override val apis = object : DmImpl.Apis {
            override val connApi = MysqlConnApi
            override val nodeApi = MysqlNodeApi
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
        override val node = object : Node() {
            override val structWrapper by lazy { MysqlNodeStructWrapper }
            private val urls =
                    ClasspathHelper.forPackage(this.javaClass.`package`.name, this.javaClass.classLoader)
            override val reflections = Reflections(ConfigurationBuilder()
                    .setUrls(urls)
                    .addClassLoader(this.javaClass.classLoader)
            )
        }
    }
    
    init {
        initialize()
    }
    
    override fun updateConfig(config: DmShareConfig) {
        distDirpath = config.deployDir.path
    }
}