package com.monkeydp.daios.dm.mysql.ui.element

import com.monkeydp.tools.constant.Symbol.SPACE

/**
 * @author iPotato
 * @date 2019/11/5
 */
data class MysqlColumn(
        val name: String,
        val dataType: String,
        val size: Int = 0,
        val constraints: List<String> = emptyList()
) {
    val newColumnSql by lazy {
        val builder = StringBuilder()
        builder.append("`$name`")
                .append(SPACE)
                .append(dataType)
                .append("($size)")
        
        if (constraints.isNotEmpty()) {
            constraints.forEach { constraint ->
                builder.append(SPACE)
                        .append(constraint)
            }
        }
        
        builder.toString()
    }
}