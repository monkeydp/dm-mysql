package com.monkeydp.daios.dm.mysql

import com.monkeydp.daios.dm.mysql.MysqlVersion.MYSQL_5_7
import com.monkeydp.daios.dm.mysql.MysqlVersion.MYSQL_8_0
import com.monkeydp.daios.dms.sdk.datasource.DsDef
import com.monkeydp.daios.dms.sdk.datasource.DsDriver

/**
 * @author iPotato
 * @date 2019/10/27
 */
object MysqlDefs {
    object Mysql57 : DsDef {
        override val version = MYSQL_5_7
        override val driver = DsDriver(
                id = "5.1",
                classname = "com.mysql.jdbc.Driver"
        )
    }
    
    object Mysql80 : DsDef {
        override val version = MYSQL_8_0
        override val driver = DsDriver(
                id = "8.0",
                classname = "com.mysql.cj.jdbc.Driver"
        )
    }
}