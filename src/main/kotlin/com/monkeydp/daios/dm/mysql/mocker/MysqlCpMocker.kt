package com.monkeydp.daios.dm.mysql.mocker

import com.monkeydp.daios.dm.mysql.MysqlDefRepo.mysql57def
import com.monkeydp.daios.dm.mysql.MysqlDefRepo.mysql80def
import com.monkeydp.daios.dm.mysql.conn.MysqlNewConnFrom
import com.monkeydp.daios.dms.sdk.conn.ConnProfile
import com.monkeydp.daios.dms.sdk.conn.SdkTestCp
import com.monkeydp.daios.dms.sdk.datasource.Datasource.MYSQL
import com.monkeydp.tools.ext.kotlin.convertTo

/**
 * @author iPotato
 * @date 2019/10/27
 */
object MysqlCpMocker {
    
    @SdkTestCp
    private val mysql57cp = ConnProfile(
            datasource = MYSQL,
            dsVersionId = mysql57def.version.id,
            userInput = MysqlNewConnFrom(connName = "MySQL 5.7 Conn").convertTo()
    )
    
    @SdkTestCp
    private val mysql80cp = ConnProfile(
            datasource = MYSQL,
            dsVersionId = mysql80def.version.id,
            userInput = MysqlNewConnFrom(connName = "MySQL 8.0 Conn", port = "3307").convertTo()
    )
    
    val cp = mysql57cp
}