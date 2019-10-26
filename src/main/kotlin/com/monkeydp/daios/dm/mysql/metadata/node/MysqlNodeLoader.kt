package com.monkeydp.daios.dm.mysql.metadata.node

import com.monkeydp.daios.dms.sdk.metadata.node.AbstractNodeLoader
import com.monkeydp.daios.dms.sdk.metadata.node.Node
import com.monkeydp.daios.dms.sdk.metadata.node.NodeLoadContext

/**
 * @author iPotato
 * @date 2019/10/25
 */
class MysqlNodeLoader : AbstractNodeLoader() {
    override fun loadNodes(ctx: NodeLoadContext): List<Node> {
        // TODO
        return emptyList()
    }
}