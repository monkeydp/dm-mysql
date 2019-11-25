package com.monkeydp.daios.dm.mysql

/**
 * @author iPotato
 * @date 2019/10/29
 */
object MysqlSql {
    const val SHOW_DBS = "SHOW DATABASES;"
    const val SHOW_TABLES = "SHOW FULL TABLES WHERE Table_type != 'VIEW';"
}