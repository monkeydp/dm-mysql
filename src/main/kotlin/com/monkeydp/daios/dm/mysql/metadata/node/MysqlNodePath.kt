package com.monkeydp.daios.dm.mysql.metadata.node

import com.monkeydp.daios.dm.base.metadata.node.def.NodeDef
import com.monkeydp.daios.dm.base.metadata.node.def.NodeDefStruct
import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dms.sdk.metadata.node.NodePath
import org.kodein.di.generic.instance


/**
 * @author iPotato
 * @date 2019/10/28
 */
class MysqlNodePath : NodePath() {
    
    private val ndStruct: NodeDefStruct by kodein.instance()
    
    private val dbNode get() = this[1]
    val dbName get() = dbNode.name
    
    private val tableNode get() = this[3]
    val tableName get() = tableNode.name
    
    private val viewNode get() = this[3]
    val viewName get() = viewNode.name
    
    fun getLastNodeDef(): NodeDef = ndStruct.find(last().defId)
}