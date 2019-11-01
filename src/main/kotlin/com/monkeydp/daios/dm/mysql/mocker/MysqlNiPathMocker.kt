package com.monkeydp.daios.dm.mysql.mocker

import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlConnNd
import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlDbNd
import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlTablesNd
import com.monkeydp.daios.dms.sdk.metadata.node.info.NodeInfoPath

/**
 * @author iPotato
 * @date 2019/10/29
 */
object MysqlNiPathMocker {
    val connNiPath = NodeInfoPath.of(MysqlConnNd, name = "MySQL Conn")
    val dbNiPath = NodeInfoPath.of(connNiPath, MysqlDbNd, name = "testdb")
    val tablesNiPath = NodeInfoPath.of(dbNiPath, MysqlTablesNd)
}