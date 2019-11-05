package com.monkeydp.daios.dm.mysql.mocker

import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlConnNd
import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlDbNd
import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlTablesNd
import com.monkeydp.daios.dm.mysql.mocker.MysqlElementMocker.DB_NAME
import com.monkeydp.daios.dms.sdk.metadata.node.NodePath

/**
 * @author iPotato
 * @date 2019/10/29
 */
object MysqlNodeMocker {
    val connNodePath = NodePath.of(MysqlConnNd.create(MysqlCpMocker.cp))
    val dbNodePath = NodePath.of(connNodePath, MysqlDbNd.create(DB_NAME))
    val tablesNodePath = NodePath.of(dbNodePath, MysqlTablesNd.create())
}