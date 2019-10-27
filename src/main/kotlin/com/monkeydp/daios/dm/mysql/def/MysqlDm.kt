package com.monkeydp.daios.dm.mysql.def

import com.monkeydp.daios.dm.mysql.conn.MysqlConnFactory
import com.monkeydp.daios.dm.mysql.conn.MysqlCpFrom
import com.monkeydp.daios.dm.mysql.metadata.instruction.MysqlActionType
import com.monkeydp.daios.dm.mysql.metadata.instruction.MysqlTargetType
import com.monkeydp.daios.dms.sdk.datasource.Datasource.DsVersion.MYSQL_5_7
import com.monkeydp.daios.dms.sdk.datasource.Datasource.DsVersion.MYSQL_8_0
import com.monkeydp.daios.dms.sdk.datasource.Datasource.MYSQL
import com.monkeydp.daios.dms.sdk.dm.Dm
import com.monkeydp.daios.dms.sdk.dm.Dm.*

/**
 * @author iPotato
 * @date 2019/10/8
 */
class MysqlDm : Dm {
    
    override val datasource = MYSQL
    override val dsDefs = listOf(Mysql57, Mysql80)
    override val impl = object : Impl {
        override val apis = object : Impl.Apis {
            override val connFactory = MysqlConnFactory()
        }
        override val classes = object : Impl.Classes {
            override val cpFormClass = MysqlCpFrom::class.java
        }
        override val enumClasses = object : Impl.EnumClasses {
            override val actionTypeClass = MysqlActionType::class.java
            override val targetTypeClass = MysqlTargetType::class.java
        }
    }
    
    private object Mysql57 : DsDef {
        override val version = MYSQL_5_7
        override val driver = DsDriver(
                id = "5.1",
                classname = "com.mysql.jdbc.Driver"
        )
    }
    
    private object Mysql80 : DsDef {
        override val version = MYSQL_8_0
        override val driver = DsDriver(
                id = "8.0",
                classname = "com.mysql.cj.jdbc.Driver"
        )
    }
}