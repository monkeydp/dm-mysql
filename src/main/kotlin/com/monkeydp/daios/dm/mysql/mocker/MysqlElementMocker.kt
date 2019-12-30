package com.monkeydp.daios.dm.mysql.mocker

import com.monkeydp.daios.dm.mysql.ui.element.MysqlColumn
import com.monkeydp.daios.dm.mysql.ui.element.MysqlTable

/**
 * @author iPotato
 * @date 2019/11/5
 */
object MysqlElementMocker {
    
    const val DB_NAME = "test_db"
    const val TABLE_NAME = "test_table"
    
    private val idColumn =
            MysqlColumn("id", "int", 11, constraints = listOf("NOT NULL", "PRIMARY KEY"))
    private val nameColumn = MysqlColumn("name", "varchar", 64, constraints = listOf("NOT NULL"))
    private val ageColumn = MysqlColumn("age", "tinyint", 4, constraints = listOf("NOT NULL"))
    
    val table = MysqlTable(
            name = TABLE_NAME,
            dbName = DB_NAME,
            columns = listOf(idColumn, nameColumn, ageColumn)
    )
}