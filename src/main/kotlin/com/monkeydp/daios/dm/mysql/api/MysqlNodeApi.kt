package com.monkeydp.daios.dm.mysql.api

import com.monkeydp.daios.dm.base.api.AbstractNodeApi
import com.monkeydp.daios.dm.base.jdbc.api.node.JdbcDbsLoader
import com.monkeydp.daios.dm.base.jdbc.api.node.JdbcTablesLoader
import com.monkeydp.daios.dm.base.metadata.node.def.NodeDef
import com.monkeydp.daios.dm.mysql.MysqlSql.SHOW_DBS
import com.monkeydp.daios.dm.mysql.MysqlSql.SHOW_TABLES
import com.monkeydp.daios.dm.mysql.metadata.node.MysqlNodePath
import com.monkeydp.daios.dm.mysql.metadata.node.def.*
import com.monkeydp.daios.dms.sdk.conn.ConnProfile
import com.monkeydp.daios.dms.sdk.main.SdkApi
import com.monkeydp.daios.dms.sdk.metadata.node.Node
import com.monkeydp.daios.dms.sdk.metadata.node.NodeLoadingCtx
import com.monkeydp.daios.dms.sdk.request.RequestContext
import java.sql.Connection

/**
 * @author iPotato
 * @date 2019/10/25
 */
@SdkApi
object MysqlNodeApi : AbstractNodeApi() {
    
    override fun loadConnNode(cp: ConnProfile) = MysqlConnNd.create(cp)
    
    override fun loadSubNodes(ctx: NodeLoadingCtx): List<Node> {
        val def = ctx.path.toSub<MysqlNodePath>().getLastNodeDef()
        val subNodes = mutableListOf<Node>()
        def.children.forEach { subNodes.addAll(loadNodes(ctx, it)) }
        return subNodes
    }
    
    private fun loadNodes(ctx: NodeLoadingCtx, def: NodeDef): List<Node> {
        val connection = RequestContext.conn!!.rawConn as Connection
        return when (def) {
            is MysqlDbNd -> JdbcDbsLoader.loadDbs(connection, def, SHOW_DBS)
            is MysqlTableNd -> {
                val path = ctx.path.toSub<MysqlNodePath>()
                useDb(connection, path.dbName)
                JdbcTablesLoader.loadTables(connection, def, SHOW_TABLES)
            }
            is MysqlTablesNd -> listOf(MysqlTablesNd.create())
            is MysqlViewsNd -> listOf(MysqlViewsNd.create())
            else -> emptyList()
        }
    }
    
    private fun useDb(connection: Connection, dbName: String) {
        val useDbSql = "USE $dbName;"
        connection.prepareStatement(useDbSql).execute()
    }
}