package com.monkeydp.daios.dm.mysql.metadata.node

import com.monkeydp.daios.dms.sdk.metadata.node.AbstractNodeApi
import com.monkeydp.daios.dms.sdk.metadata.node.Node
import com.monkeydp.daios.dms.sdk.metadata.node.NodeLoadContext

/**
 * @author iPotato
 * @date 2019/10/25
 */
object MysqlNodeApi : AbstractNodeApi() {
    
    override fun loadNodes(ctx: NodeLoadContext): List<Node> {
        // TODO
        return emptyList()
    }
}