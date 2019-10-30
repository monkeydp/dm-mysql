package com.monkeydp.daios.dm.mysql.metadata.node.def

import com.monkeydp.daios.dms.sdk.metadata.node.def.impl.AbstractTablesNd

/**
 * @author iPotato
 * @date 2019/10/28
 */
object MysqlTablesNd : AbstractTablesNd() {
    override val children = listOf(MysqlTableNd)
}