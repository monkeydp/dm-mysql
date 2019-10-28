package com.monkeydp.daios.dm.mysql.metadata.node.def

import com.monkeydp.daios.dms.sdk.metadata.node.def.impl.AbstractTableGnd

/**
 * @author iPotato
 * @date 2019/10/28
 */
object MysqlTableGnd : AbstractTableGnd() {
    override val children = listOf(MysqlTableNd)
}