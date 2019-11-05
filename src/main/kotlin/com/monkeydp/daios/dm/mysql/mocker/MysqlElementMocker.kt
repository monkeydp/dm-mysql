package com.monkeydp.daios.dm.mysql.mocker

import com.monkeydp.daios.dm.mysql.metadata.element.MysqlColumn
import com.monkeydp.daios.dm.mysql.metadata.element.MysqlTable

/**
 * @author iPotato
 * @date 2019/11/5
 */
object MysqlElementMocker {
    private val idColumn =
            MysqlColumn("id", "int", 11, constraints = listOf("NOT NULL", "PRIMARY KEY"))
    private val nameColumn = MysqlColumn("name", "varchar", 64, constraints = listOf("NOT NULL"))
    private val ageColumn = MysqlColumn("age", "tinyint", 4, constraints = listOf("NOT NULL"))
    
    val table = MysqlTable(name = "test_table", columns = listOf(idColumn, nameColumn, ageColumn))
}