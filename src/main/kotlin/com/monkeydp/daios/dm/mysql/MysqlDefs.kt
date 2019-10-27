package com.monkeydp.daios.dm.mysql

import com.monkeydp.daios.dm.mysql.MysqlVersion.MYSQL_5_7
import com.monkeydp.daios.dm.mysql.MysqlVersion.MYSQL_8_0
import com.monkeydp.daios.dms.sdk.dm.Dm

/**
 * @author iPotato
 * @date 2019/10/27
 */
object MysqlDefs {
    object Mysql57 : Dm.DsDef {
        override val version = MYSQL_5_7
        override val driver = Dm.DsDriver(
                id = "5.1",
                classname = "com.mysql.jdbc.Driver"
        )
    }
    
    object Mysql80 : Dm.DsDef {
        override val version = MYSQL_8_0
        override val driver = Dm.DsDriver(
                id = "8.0",
                classname = "com.mysql.cj.jdbc.Driver"
        )
    }
}