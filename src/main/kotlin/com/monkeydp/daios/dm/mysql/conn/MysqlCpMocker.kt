package com.monkeydp.daios.dm.mysql.conn

import com.monkeydp.daios.dm.mysql.MysqlDefs.Mysql57
import com.monkeydp.daios.dm.mysql.MysqlDefs.Mysql80
import com.monkeydp.daios.dms.sdk.datasource.Datasource.MYSQL
import com.monkeydp.daios.dms.sdk.entity.ConnProfile
import com.monkeydp.daios.dms.sdk.useful.UserInput

/**
 * @author iPotato
 * @date 2019/10/27
 */
object MysqlCpMocker {
    
    private val mysql57cp = ConnProfile(
            datasource = MYSQL,
            dsVersionId = Mysql57.version.id,
            dsDriverClassname = Mysql57.driver.classname,
            userInput = UserInput(MysqlCpFrom(connName = "MySQL 5.7 Conn"))
    )
    
    private val mysql80cp = ConnProfile(
            datasource = MYSQL,
            dsVersionId = Mysql80.version.id,
            dsDriverClassname = Mysql80.driver.classname,
            userInput = UserInput(MysqlCpFrom(connName = "MySQL 8.0 Conn", port = "3307"))
    )
    
    val cp = mysql57cp
    val cps = listOf(mysql57cp, mysql80cp)
}