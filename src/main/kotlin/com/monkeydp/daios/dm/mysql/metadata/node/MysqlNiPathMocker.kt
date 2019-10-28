package com.monkeydp.daios.dm.mysql.metadata.node

import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlConnNd
import com.monkeydp.daios.dms.sdk.metadata.node.NodeInfoPath

/**
 * @author iPotato
 * @date 2019/10/29
 */
object MysqlNiPathMocker {
    val connNiPath = NodeInfoPath.of(MysqlConnNd.info)
}