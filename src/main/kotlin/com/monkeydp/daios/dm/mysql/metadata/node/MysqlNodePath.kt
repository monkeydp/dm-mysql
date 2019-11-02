package com.monkeydp.daios.dm.mysql.metadata.node

import com.monkeydp.daios.dm.mysql.MysqlDm
import com.monkeydp.daios.dms.sdk.metadata.instruction.target.GlobalTarget.GROUP
import com.monkeydp.daios.dms.sdk.metadata.node.Node
import com.monkeydp.daios.dms.sdk.metadata.node.NodePath


/**
 * @author iPotato
 * @date 2019/10/28
 */
class MysqlNodePath : NodePath() {
    
    private val list = MysqlDm.INSTANCE.config.nodeConfig.list
    private val map = list.map { it.target to it }.toMap()
    private val groupMap = list.filter { it.target == GROUP }.map { it.name to it }.toMap()
    
    private val dbNode
        get() = this[1]
    val dbName
        get() = dbNode.name
    
    private val tableNode
        get() = this[3]
    val tableName
        get() = tableNode.name
    
    private val viewNode
        get() = this[3]
    val viewName
        get() = viewNode.name
    
    override fun getLastNode(): Node {
        val target = last().target
        return if (target == GROUP) groupMap.getValue(last().name)
        else map.getValue(target)
    }
}