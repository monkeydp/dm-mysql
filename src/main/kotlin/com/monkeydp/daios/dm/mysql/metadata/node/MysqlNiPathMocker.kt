package com.monkeydp.daios.dm.mysql.metadata.node

import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlConnNd
import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlDbNd
import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlTableGnd
import com.monkeydp.daios.dms.sdk.metadata.node.NodeInfoPath

/**
 * @author iPotato
 * @date 2019/10/29
 */
object MysqlNiPathMocker {
    val connNiPath = NodeInfoPath.of(MysqlConnNd, name = "MySQL Conn")
    val dbNiPath = NodeInfoPath.of(connNiPath, MysqlDbNd, name = "testdb")
    val tablesNiPath = NodeInfoPath.of(dbNiPath, MysqlTableGnd)
}