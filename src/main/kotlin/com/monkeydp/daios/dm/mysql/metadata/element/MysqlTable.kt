package com.monkeydp.daios.dm.mysql.metadata.element

import com.monkeydp.tools.enumeration.Symbol.COMMA

/**
 * @author iPotato
 * @date 2019/11/5
 */
data class MysqlTable(
        val name: String,
        val dbName: String = "",
        val columns: List<MysqlColumn>
) {
    val newTableSql by lazy {
        val builder = StringBuilder()
        builder.append("CREATE TABLE `$dbName`.`$name`  (")
        columns.forEach { builder.append(it.newColumnSql).append(COMMA) }
        builder.deleteCharAt(builder.lastIndexOf(COMMA))
                .append(");")
                .toString()
    }
}