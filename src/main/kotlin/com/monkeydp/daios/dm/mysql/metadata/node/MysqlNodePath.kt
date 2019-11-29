package com.monkeydp.daios.dm.mysql.metadata.node

import com.monkeydp.daios.dm.base.metadata.node.def.NodeDef
import com.monkeydp.daios.dm.mysql.MysqlDm
import com.monkeydp.daios.dms.sdk.instruction.target.GlobalTarget.GROUP
import com.monkeydp.daios.dms.sdk.metadata.node.NodePath


/**
 * @author iPotato
 * @date 2019/10/28
 */
class MysqlNodePath : NodePath() {
    
    private val defs = MysqlDm.INSTANCE.config.nodeConfig.defs
    private val defMap = defs.map { it.target to it }.toMap()
    private val groupDefMap = defs.filter { it.target == GROUP }.map { it.name to it }.toMap()
    
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
    
    fun getLastNodeDef(): NodeDef {
        val target = last().target
        return if (target == GROUP) groupDefMap.getValue(last().name)
        else defMap.getValue(target)
    }
}