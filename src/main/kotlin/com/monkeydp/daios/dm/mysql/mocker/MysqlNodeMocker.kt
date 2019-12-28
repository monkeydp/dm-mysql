package com.monkeydp.daios.dm.mysql.mocker

import com.monkeydp.daios.dms.sdk.metadata.node.NodeDefStruct
import com.monkeydp.daios.dms.sdk.metadata.node.find
import com.monkeydp.daios.dm.base.metadata.node.def.sub.ConnNd
import com.monkeydp.daios.dm.base.metadata.node.def.sub.DbNd
import com.monkeydp.daios.dm.base.metadata.node.def.sub.TablesNd
import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dm.mysql.mocker.MysqlElementMocker.DB_NAME
import com.monkeydp.daios.dms.sdk.metadata.node.NodePath
import org.kodein.di.generic.instance

/**
 * @author iPotato
 * @date 2019/10/29
 */
object MysqlNodeMocker {
    private val ndStruct: NodeDefStruct by kodein.instance()
    
    val connNodePath = NodePath.of(ndStruct.find<ConnNd>().create(MysqlCpMocker.cp))
    val dbNodePath = NodePath.of(connNodePath, ndStruct.find<DbNd>().create(DB_NAME))
    val tablesNodePath = NodePath.of(dbNodePath, ndStruct.find<TablesNd>().create())
}