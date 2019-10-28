package com.monkeydp.daios.dm.mysql.metadata.node

import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlConnNd
import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlDbNd
import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlTableNd
import com.monkeydp.daios.dms.sdk.metadata.instruction.target.GlobalTarget.*
import com.monkeydp.daios.dms.sdk.metadata.instruction.target.Target
import com.monkeydp.daios.dms.sdk.metadata.node.AbstractNodeApi
import com.monkeydp.daios.dms.sdk.metadata.node.Node
import com.monkeydp.daios.dms.sdk.metadata.node.NodeLoadContext
import com.monkeydp.daios.dms.sdk.metadata.node.def.NodeDef
import com.monkeydp.daios.dms.sdk.metadata.node.impl.DbNode
import com.monkeydp.daios.dms.sdk.sql.Sql
import java.sql.Connection

/**
 * @author iPotato
 * @date 2019/10/25
 */
object MysqlNodeApi : AbstractNodeApi() {
    
    private val map = mapOf<Target<*>, NodeDef>(
            CONN to MysqlConnNd,
            DB to MysqlDbNd,
            TABLE to MysqlTableNd
    )
    
    override fun loadNodes(ctx: NodeLoadContext): List<Node> {
        val nodeDef = map.getValue(ctx.lastTarget)
        val nodes = mutableListOf<Node>()
        nodeDef.children.forEach { nodes.addAll(loadNodes(ctx, it)) }
        return nodes
    }
    
    private fun loadNodes(ctx: NodeLoadContext, nodeDef: NodeDef): List<Node> {
        return when (nodeDef) {
            MysqlDbNd -> loadDbs(ctx)
            else      -> emptyList()
        }
    }
    
    private fun loadDbs(ctx: NodeLoadContext): List<DbNode> {
        val rawConn = ctx.conn.rawConn as Connection
        val statement = rawConn.createStatement()
        val nodes = mutableListOf<DbNode>()
        statement.use {
            val resultSet = it.executeQuery(Sql.SHOW_DBS)
            resultSet.use {
                while (resultSet.next()) nodes.add(DbNode(MysqlDbNd, resultSet.getString(1)))
            }
        }
        return nodes
    }
}