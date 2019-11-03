package com.monkeydp.daios.dm.mysql.api

import com.monkeydp.daios.dm.base.api.AbstractNodeApi
import com.monkeydp.daios.dm.base.jdbc.api.node.JdbcDbsLoader
import com.monkeydp.daios.dm.base.jdbc.api.node.JdbcTablesLoader
import com.monkeydp.daios.dm.base.metadata.node.def.DbNd
import com.monkeydp.daios.dm.base.metadata.node.def.TableNd
import com.monkeydp.daios.dm.base.metadata.node.def.TablesNd
import com.monkeydp.daios.dm.base.metadata.node.def.ViewsNd
import com.monkeydp.daios.dm.mysql.MysqlSql
import com.monkeydp.daios.dm.mysql.metadata.node.MysqlNodePath
import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlTablesNd
import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlViewsNd
import com.monkeydp.daios.dms.sdk.metadata.node.main.Node
import com.monkeydp.daios.dms.sdk.metadata.node.ctx.NodeLoadCtx
import com.monkeydp.daios.dms.sdk.metadata.node.def.NodeDef
import java.sql.Connection

/**
 * @author iPotato
 * @date 2019/10/25
 */
object MysqlNodeApi : AbstractNodeApi() {
    
    override fun loadSubNodes(ctx: NodeLoadCtx): List<Node> {
        return super.loadSubNodes(ctx.copy(path = ctx.path.toSub<MysqlNodePath>()))
    }
    
    override fun loadNodes(ctx: NodeLoadCtx, def: NodeDef): List<Node> {
        val conn = ctx.conn.rawConn as Connection
        return when (def) {
            is DbNd     -> JdbcDbsLoader.loadDbs(conn, def, MysqlSql.SHOW_DBS)
            is TableNd  -> {
                val path = ctx.path.toSub<MysqlNodePath>()
                val sql = MysqlSql.showTablesSql(path.dbName)
                JdbcTablesLoader.loadTables(conn, def, sql)
            }
            is TablesNd -> listOf(MysqlTablesNd.create())
            is ViewsNd  -> listOf(MysqlViewsNd.create())
            else        -> emptyList()
        }
    }
}