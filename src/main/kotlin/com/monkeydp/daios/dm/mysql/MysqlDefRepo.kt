package com.monkeydp.daios.dm.mysql

import com.monkeydp.daios.dm.base.AbstractDsDefRepo
import com.monkeydp.daios.dm.mysql.MysqlVersion.MYSQL_5_7
import com.monkeydp.daios.dm.mysql.MysqlVersion.MYSQL_8_0
import com.monkeydp.daios.dms.sdk.datasource.DsDriver
import com.monkeydp.daios.dms.sdk.datasource.SdkDsDef

/**
 * @author iPotato
 * @date 2019/10/27
 */
object MysqlDefRepo : AbstractDsDefRepo<MysqlDef>() {
    
    @SdkDsDef
    val mysql57def = MysqlDef(
            version = MYSQL_5_7,
            driver = DsDriver(
                    id = "5.1",
                    classname = "com.mysql.jdbc.Driver"
            )
    )
    
    @SdkDsDef
    val mysql80def = MysqlDef(
            version = MYSQL_8_0,
            driver = DsDriver(
                    id = "8.0",
                    classname = "com.mysql.cj.jdbc.Driver"
            )
    )
}