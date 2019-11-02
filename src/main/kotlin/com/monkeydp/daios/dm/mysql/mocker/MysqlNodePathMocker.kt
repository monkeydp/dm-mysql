package com.monkeydp.daios.dm.mysql.mocker

import com.monkeydp.daios.dm.mysql.metadata.node.MysqlConnNode
import com.monkeydp.daios.dm.mysql.metadata.node.MysqlDbNode
import com.monkeydp.daios.dm.mysql.metadata.node.MysqlTablesNode
import com.monkeydp.daios.dms.sdk.metadata.node.NodePath

/**
 * @author iPotato
 * @date 2019/10/29
 */
object MysqlNodePathMocker {
    val connNodePath = NodePath.of(MysqlConnNode, name = "MySQL Conn")
    val dbNodePath = NodePath.of(connNodePath, MysqlDbNode, name = "testdb")
    val tablesNodePath = NodePath.of(dbNodePath, MysqlTablesNode)
}