package com.monkeydp.daios.dm.mysql.api

import com.monkeydp.daios.dm.mysql.MysqlSql
import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlTablesNd
import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlViewsNd
import com.monkeydp.daios.dm.base.jdbc.api.node.AbstractJdbcNodeApi
import com.monkeydp.daios.dm.base.jdbc.api.node.JdbcDbsLoader
import com.monkeydp.daios.dm.base.jdbc.api.node.JdbcTablesLoader
import com.monkeydp.daios.dms.sdk.metadata.node.main.Node
import com.monkeydp.daios.dms.sdk.metadata.node.def.NodeDef
import com.monkeydp.daios.dms.sdk.metadata.node.ctx.NodeLoadCtx
import com.monkeydp.daios.dms.sdk.metadata.node.def.*
import com.monkeydp.daios.dm.base.metadata.node.main.TableGroupNode
import com.monkeydp.daios.dm.base.metadata.node.main.ViewGroupNode
import com.monkeydp.daios.dm.mysql.metadata.node.MysqlNiPath
import java.sql.Connection

/**
 * @author iPotato
 * @date 2019/10/25
 */
object MysqlNodeApi : AbstractJdbcNodeApi() {
    
    override fun loadNodes(ctx: NodeLoadCtx): List<Node> {
        return super.loadNodes(ctx.copy(path = ctx.path.toSub<MysqlNiPath>()))
    }
    
    override fun loadNodes(ctx: NodeLoadCtx, def: NodeDef): List<Node> {
        val conn = ctx.conn.rawConn as Connection
        return when (def) {
            is DbNd     -> JdbcDbsLoader.loadDbs(conn, def, MysqlSql.SHOW_DBS)
            is TableNd  -> {
                val path = ctx.path.toSub<MysqlNiPath>()
                JdbcTablesLoader.loadTables(conn, def, MysqlSql.showTablesSql(path.dbName))
            }
            is TablesNd -> listOf(TableGroupNode(MysqlTablesNd))
            is ViewsNd  -> listOf(ViewGroupNode(MysqlViewsNd))
            else        -> emptyList()
        }
    }
}