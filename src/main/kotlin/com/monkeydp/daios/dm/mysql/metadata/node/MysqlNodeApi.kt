package com.monkeydp.daios.dm.mysql.metadata.node

import com.monkeydp.daios.dms.sdk.metadata.node.Node
import com.monkeydp.daios.dms.sdk.metadata.node.NodeLoadInstr
import com.monkeydp.daios.dms.sdk.metadata.node.def.ConnNodeDef
import com.monkeydp.daios.dms.sdk.metadata.node.loader.AbstractNodeApi

/**
 * @author iPotato
 * @date 2019/10/25
 */
class MysqlNodeApi : AbstractNodeApi() {
    
    override fun getConnNodeDef(): ConnNodeDef {
        return MysqlNodeDefFactory.connNodeDef()
    }
    
    override fun loadNodes(instr: NodeLoadInstr): List<Node> {
        // TODO
        return emptyList()
    }
}