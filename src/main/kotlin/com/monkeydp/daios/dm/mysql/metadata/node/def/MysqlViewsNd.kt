package com.monkeydp.daios.dm.mysql.metadata.node.def

import com.monkeydp.daios.dms.sdk.metadata.node.def.impl.AbstractViewsNd

/**
 * @author iPotato
 * @date 2019/10/28
 */
object MysqlViewsNd : AbstractViewsNd() {
    override val children = listOf(MysqlViewNd)
}