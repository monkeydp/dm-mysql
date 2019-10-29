package com.monkeydp.daios.dm.mysql.metadata.node

import com.monkeydp.daios.dm.mysql.MysqlSql
import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlConnNd
import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlDbNd
import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlTableNd
import com.monkeydp.daios.dms.sdk.api.contract.node.DbNodeLoader
import com.monkeydp.daios.dms.sdk.jdbc.node.AbstractJdbcNodeApi
import com.monkeydp.daios.dms.sdk.jdbc.node.JdbcDbNodeLoader
import com.monkeydp.daios.dms.sdk.metadata.instruction.target.GlobalTarget.*
import com.monkeydp.daios.dms.sdk.metadata.instruction.target.Target
import com.monkeydp.daios.dms.sdk.metadata.node.Node
import com.monkeydp.daios.dms.sdk.metadata.node.NodeLoadContext
import com.monkeydp.daios.dms.sdk.metadata.node.def.DbNd
import com.monkeydp.daios.dms.sdk.metadata.node.def.NodeDef
import java.sql.Connection

/**
 * @author iPotato
 * @date 2019/10/25
 */
object MysqlNodeApi :
        DbNodeLoader by JdbcDbNodeLoader(),
        AbstractJdbcNodeApi() {
    
    override val map = mapOf<Target<*>, Pair<NodeDef, String>>(
            CONN to Pair(MysqlConnNd, ""),
            DB to Pair(MysqlDbNd, MysqlSql.SHOW_DBS),
            TABLE to Pair(MysqlTableNd, "")
    )
    
    override fun loadNodes(ctx: NodeLoadContext, def: NodeDef): List<Node> {
        val conn = ctx.conn.rawConn as Connection
        return when (def) {
            is DbNd -> loadDbNodes(conn, def, getSql(def))
            else    -> emptyList()
        }
    }
}