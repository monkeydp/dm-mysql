package com.monkeydp.daios.dm.mysql

import com.monkeydp.daios.dm.base.jdbc.datasource.SdkJdbcDsDef
import com.monkeydp.daios.dm.base.jdbc.datasource.jdbcDsDef
import com.monkeydp.daios.dms.sdk.datasource.DsDriver

/**
 * @author iPotato
 * @date 2019/10/27
 */
object MysqlDefs {
    @SdkJdbcDsDef
    val mysql57def = jdbcDsDef {
        version = MysqlVersion.MYSQL_5_7
        driver = DsDriver(
                id = "5.1",
                classname = "com.mysql.jdbc.Driver"
        )
    }
    
    @SdkJdbcDsDef
    val mysql80def = jdbcDsDef {
        version = MysqlVersion.MYSQL_8_0
        driver = DsDriver(
                id = "8.0",
                classname = "com.mysql.cj.jdbc.Driver"
        )
    }
}