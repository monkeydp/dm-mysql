package com.monkeydp.daios.dm.mysql.metadata.icon

import com.monkeydp.daios.dms.sdk.metadata.icon.Icon

/**
 * @author iPotato
 * @date 2019/10/28
 */
enum class MysqlIcon(
        override val namex: String,
        override val color: String
) : Icon<MysqlIcon> {
    MYSQL_CONN_ICON("mysql conn icon", "")
}