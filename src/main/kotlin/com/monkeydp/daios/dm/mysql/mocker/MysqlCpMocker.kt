package com.monkeydp.daios.dm.mysql.mocker

import com.monkeydp.daios.dm.mysql.MysqlDefs.mysql57def
import com.monkeydp.daios.dm.mysql.MysqlDefs.mysql80def
import com.monkeydp.daios.dm.mysql.conn.MysqlNewConnFrom
import com.monkeydp.daios.dms.sdk.conn.ConnProfile
import com.monkeydp.daios.dms.sdk.datasource.Datasource.MYSQL
import com.monkeydp.tools.ext.convertTo

/**
 * @author iPotato
 * @date 2019/10/27
 */
object MysqlCpMocker {
    
    private val mysql57cp = ConnProfile(
            datasource = MYSQL,
            dsVersionId = mysql57def.version.id,
            userInput = MysqlNewConnFrom(connName = "MySQL 5.7 Conn").convertTo()
    )
    
    private val mysql80cp = ConnProfile(
            datasource = MYSQL,
            dsVersionId = mysql80def.version.id,
            userInput = MysqlNewConnFrom(connName = "MySQL 8.0 Conn", port = "3307").convertTo()
    )
    
    val cp = mysql57cp
    val cps = listOf(mysql57cp, mysql80cp)
}