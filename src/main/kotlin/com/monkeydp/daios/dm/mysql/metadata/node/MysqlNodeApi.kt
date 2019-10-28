package com.monkeydp.daios.dm.mysql.metadata.node

import com.monkeydp.daios.dms.sdk.metadata.node.Node
import com.monkeydp.daios.dms.sdk.metadata.node.NodeLoadContext
import com.monkeydp.daios.dms.sdk.metadata.node.loader.AbstractNodeApi

/**
 * @author iPotato
 * @date 2019/10/25
 */
class MysqlNodeApi : AbstractNodeApi() {
    
    override fun loadNodes(context: NodeLoadContext): List<Node> {
        // TODO
        return emptyList()
    }
}