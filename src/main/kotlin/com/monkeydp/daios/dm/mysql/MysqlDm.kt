package com.monkeydp.daios.dm.mysql

import com.monkeydp.daios.dm.mysql.conn.MysqlConnApi
import com.monkeydp.daios.dm.mysql.conn.MysqlCpFrom
import com.monkeydp.daios.dm.mysql.conn.MysqlCpMocker
import com.monkeydp.daios.dm.mysql.metadata.icon.MysqlIcon
import com.monkeydp.daios.dm.mysql.metadata.instruction.MysqlAction
import com.monkeydp.daios.dm.mysql.metadata.instruction.MysqlTarget
import com.monkeydp.daios.dm.mysql.metadata.node.MysqlNodeApi
import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlConnNd
import com.monkeydp.daios.dms.sdk.datasource.Datasource.MYSQL
import com.monkeydp.daios.dms.sdk.dm.AbstractDm
import com.monkeydp.daios.dms.sdk.dm.Dm.Impl
import com.monkeydp.daios.dms.sdk.dm.Dm.Testdata

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
            override val dsVersionClass = MysqlVersion::class.java
            override val actionClass = MysqlAction::class.java
            override val targetClass = MysqlTarget::class.java
            override val iconClass = MysqlIcon::class.java
        }
    }
    override val testdata = object : Testdata {
        override val cps = MysqlCpMocker.cps
    }
}