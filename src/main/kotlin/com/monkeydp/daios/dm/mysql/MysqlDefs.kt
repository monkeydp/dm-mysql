package com.monkeydp.daios.dm.mysql

import com.monkeydp.daios.dm.base.datasource.AbstractDsDefs
import com.monkeydp.daios.dm.base.datasource.dsDef
import com.monkeydp.daios.dm.mysql.MysqlVersion.MYSQL_5_7
import com.monkeydp.daios.dm.mysql.MysqlVersion.MYSQL_8_0
import com.monkeydp.daios.dms.sdk.datasource.DsDriver

/**
 * @author iPotato
 * @date 2019/10/27
 */
object MysqlDefs : AbstractDsDefs() {
    val mysql57dsDef = dsDef {
        version = MYSQL_5_7
        driver = DsDriver(
                id = "5.1",
                classname = "com.mysql.jdbc.Driver"
        )
    }
    val mysql80dsDef = dsDef {
        version = MYSQL_8_0
        driver = DsDriver(
                id = "8.0",
                classname = "com.mysql.cj.jdbc.Driver"
        )
    }
}