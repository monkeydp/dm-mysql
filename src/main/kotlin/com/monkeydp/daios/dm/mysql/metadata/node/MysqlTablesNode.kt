package com.monkeydp.daios.dm.mysql.metadata.node

import com.monkeydp.daios.dm.base.metadata.node.AbstractTablesNode
import com.monkeydp.daios.dms.sdk.metadata.node.NodeImpl

/**
 * @author iPotato
 * @date 2019/10/28
 */
@NodeImpl(isGroup = true)
object MysqlTablesNode : AbstractTablesNode()