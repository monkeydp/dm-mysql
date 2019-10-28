package com.monkeydp.daios.dm.mysql.metadata.node.def

import com.monkeydp.daios.dm.mysql.metadata.icon.MysqlIcon
import com.monkeydp.daios.dms.sdk.metadata.node.def.impl.AbstractConnNd

/**
 * @author iPotato
 * @date 2019/10/28
 */
object MysqlConnNd : AbstractConnNd() {
    override val info = super.info.copy(icon = MysqlIcon.MYSQL_CONN_ICON)
    override val children = listOf(MysqlDbNd)
}