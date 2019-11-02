package com.monkeydp.daios.dm.mysql.api

import com.monkeydp.daios.dm.base.api.AbstractNodeApi
import com.monkeydp.daios.dm.base.jdbc.api.node.JdbcDbsLoader
import com.monkeydp.daios.dm.base.jdbc.api.node.JdbcTablesLoader
import com.monkeydp.daios.dm.base.metadata.node.DbNode
import com.monkeydp.daios.dm.base.metadata.node.TableNode
import com.monkeydp.daios.dm.base.metadata.node.TablesNode
import com.monkeydp.daios.dm.base.metadata.node.ViewsNode
import com.monkeydp.daios.dm.mysql.MysqlSql
import com.monkeydp.daios.dm.mysql.metadata.node.MysqlNodePath
import com.monkeydp.daios.dm.mysql.metadata.node.MysqlTablesNode
import com.monkeydp.daios.dm.mysql.metadata.node.MysqlViewsNode
import com.monkeydp.daios.dms.sdk.metadata.node.Node
import com.monkeydp.daios.dms.sdk.metadata.node.ctx.NodeLoadCtx
import java.sql.Connection

/**
 * @author iPotato
 * @date 2019/10/25
 */
object MysqlNodeApi : AbstractNodeApi() {
    
    override fun loadSubNodes(ctx: NodeLoadCtx): List<Node> {
        return super.loadSubNodes(ctx.copy(path = ctx.path.toSub<MysqlNodePath>()))
    }
    
    override fun loadSubNodes(ctx: NodeLoadCtx, node: Node): List<Node> {
        val conn = ctx.conn.rawConn as Connection
        return when (node) {
            is DbNode     -> JdbcDbsLoader.loadDbs(conn, node, MysqlSql.SHOW_DBS)
            is TableNode  -> {
                val path = ctx.path.toSub<MysqlNodePath>()
                val sql = MysqlSql.showTablesSql(path.dbName)
                JdbcTablesLoader.loadTables(conn, node, sql)
            }
            is TablesNode -> listOf(MysqlTablesNode)
            is ViewsNode  -> listOf(MysqlViewsNode)
            else          -> emptyList()
        }
    }
}