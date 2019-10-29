package com.monkeydp.daios.dm.mysql.metadata.node

import com.monkeydp.daios.dm.mysql.MysqlSql
import com.monkeydp.daios.dms.sdk.jdbc.node.AbstractJdbcNodeApi
import com.monkeydp.daios.dms.sdk.jdbc.node.JdbcDbsLoader
import com.monkeydp.daios.dms.sdk.jdbc.node.JdbcTablesLoader
import com.monkeydp.daios.dms.sdk.metadata.node.Node
import com.monkeydp.daios.dms.sdk.metadata.node.NodeLoadContext
import com.monkeydp.daios.dms.sdk.metadata.node.def.DbNd
import com.monkeydp.daios.dms.sdk.metadata.node.def.NodeDef
import com.monkeydp.daios.dms.sdk.metadata.node.def.TableNd
import java.sql.Connection

/**
 * @author iPotato
 * @date 2019/10/25
 */
object MysqlNodeApi : AbstractJdbcNodeApi() {
    
    override fun loadNodes(ctx: NodeLoadContext): List<Node> {
        return super.loadNodes(ctx.copy(path = ctx.path.toSub<MysqlNiPath>()))
    }
    
    override fun loadNodes(ctx: NodeLoadContext, def: NodeDef): List<Node> {
        val conn = ctx.conn.rawConn as Connection
        return when (def) {
            is DbNd    -> JdbcDbsLoader.loadDbs(conn, def, MysqlSql.SHOW_DBS)
            is TableNd -> {
                val path = ctx.path.toSub<MysqlNiPath>()
                JdbcTablesLoader.loadTables(conn, def, MysqlSql.showTablesSql(path.dbName))
            }
            else       -> emptyList()
        }
    }
}