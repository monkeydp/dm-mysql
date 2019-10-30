package com.monkeydp.daios.dm.mysql

import com.monkeydp.daios.dm.mysql.conn.MysqlConnApi
import com.monkeydp.daios.dm.mysql.conn.MysqlCpFrom
import com.monkeydp.daios.dm.mysql.conn.MysqlCpMocker
import com.monkeydp.daios.dm.mysql.ext.classLoader
import com.monkeydp.daios.dm.mysql.ext.distDirpath
import com.monkeydp.daios.dm.mysql.ext.kotlinDirpath
import com.monkeydp.daios.dm.mysql.ext.packageDirpath
import com.monkeydp.daios.dm.mysql.metadata.icon.MysqlIcon
import com.monkeydp.daios.dm.mysql.metadata.instruction.MysqlAction
import com.monkeydp.daios.dm.mysql.metadata.instruction.MysqlTarget
import com.monkeydp.daios.dm.mysql.metadata.node.MysqlNodeApi
import com.monkeydp.daios.dm.mysql.metadata.node.MysqlNodeStructWrapper
import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlConnNd
import com.monkeydp.daios.dms.sdk.datasource.Datasource.MYSQL
import com.monkeydp.daios.dms.sdk.dm.AbstractDm
import com.monkeydp.daios.dms.sdk.dm.Dm.Impl
import com.monkeydp.daios.dms.sdk.dm.Dm.Testdata
import com.monkeydp.daios.dms.sdk.dm.DmNewConfig
import com.monkeydp.daios.dms.sdk.metadata.node.def.NodeDef
import com.monkeydp.tools.ext.getClassname
import com.monkeydp.tools.ext.singletonInstance
import com.monkeydp.tools.util.FileUtil

/**
 * @author iPotato
 * @date 2019/10/8
 */
object MysqlDm : AbstractDm() {
    
    override val datasource = MYSQL
    override val connNd = MysqlConnNd
    override val dsDefs = listOf(MysqlDefs.Mysql57, MysqlDefs.Mysql80)
    override val impl = object : Impl {
        override val apis = object : Impl.Apis {
            override val connApi = MysqlConnApi
            override val nodeApi = MysqlNodeApi
        }
        override val classes = object : Impl.Classes {
            override val cpFormClass = MysqlCpFrom::class
        }
        override val enumClasses = object : Impl.EnumClasses {
            override val dsVersionClass = MysqlVersion::class
            override val actionClass = MysqlAction::class
            override val targetClass = MysqlTarget::class
            override val iconClass = MysqlIcon::class
        }
    }
    override val testdata = object : Testdata {
        override val cps = MysqlCpMocker.cps
    }
    
    override val nodeData = object : NodeData {
        override fun structWrapper() = MysqlNodeStructWrapper
        override fun defMap() = nodeDefMap()
    }
    
    override fun updateConfig(config: DmNewConfig) {
        distDirpath = config.deployedDirpath
        kotlinDirpath = config.classesDirpath
        classLoader = config.classLoader
    }
    
    private fun nodeDefMap(): Map<String, NodeDef> {
        val files = FileUtil.listFiles("$packageDirpath/metadata/node/def")
        return files.map { file ->
            val classname = file.getClassname(kotlinDirpath)
            val nd = classLoader.loadClass(classname).singletonInstance() as NodeDef
            nd.structName to nd
        }.toMap()
    }
}