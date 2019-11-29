package com.monkeydp.daios.dm.mysql.mocker

import com.monkeydp.daios.dm.mysql.metadata.node.MysqlNdStruct
import com.monkeydp.daios.dm.mysql.mocker.MysqlElementMocker.DB_NAME
import com.monkeydp.daios.dms.sdk.metadata.node.NodePath

/**
 * @author iPotato
 * @date 2019/10/29
 */
object MysqlNodeMocker {
    val connNodePath = NodePath.of(MysqlNdStruct.findConnNd().create(MysqlCpMocker.cp))
    val dbNodePath = NodePath.of(connNodePath, MysqlNdStruct.findDbNd().create(DB_NAME))
    val tablesNodePath = NodePath.of(dbNodePath, MysqlNdStruct.findTablesNd().create())
}