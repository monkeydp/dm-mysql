package com.monkeydp.daios.dm.mysql

/**
 * @author iPotato
 * @date 2019/10/29
 */
object MysqlSql {
    const val SHOW_DBS = "SHOW DATABASES"
    const val SHOW_TABLES_TPL =
            "SELECT TABLE_NAME FROM information_schema.TABLES WHERE TABLE_SCHEMA = '%s' AND TABLE_TYPE != 'VIEW'  ORDER BY TABLE_SCHEMA"
}