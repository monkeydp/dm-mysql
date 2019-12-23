package com.monkeydp.daios.dm.mysql.api

import com.monkeydp.daios.dm.base.api.AbstractNodeApi
import com.monkeydp.daios.dm.base.jdbc.api.node.JdbcDbsLoader
import com.monkeydp.daios.dm.base.jdbc.api.node.JdbcTablesLoader
import com.monkeydp.daios.dm.base.metadata.node.def.NodeDef
import com.monkeydp.daios.dm.base.metadata.node.def.sub.DbNd
import com.monkeydp.daios.dm.base.metadata.node.def.sub.TableNd
import com.monkeydp.daios.dm.base.metadata.node.def.sub.TablesNd
import com.monkeydp.daios.dm.base.metadata.node.def.sub.ViewsNd
import com.monkeydp.daios.dm.mysql.MysqlSql.SHOW_DBS
import com.monkeydp.daios.dm.mysql.MysqlSql.SHOW_TABLES
import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dm.mysql.metadata.node.MysqlNdStruct
import com.monkeydp.daios.dm.mysql.metadata.node.MysqlNodePath
import com.monkeydp.daios.dms.sdk.api.annot.SdkNodeApi
import com.monkeydp.daios.dms.sdk.conn.ConnProfile
import com.monkeydp.daios.dms.sdk.metadata.node.Node
import com.monkeydp.daios.dms.sdk.metadata.node.NodeLoadingCtx
import com.monkeydp.daios.dms.sdk.share.conn.ConnContext
import org.kodein.di.generic.provider
import java.sql.Connection

/**
 * @author iPotato
 * @date 2019/10/25
 */
@SdkNodeApi
object MysqlNodeApi : AbstractNodeApi() {
    
    private val connContext: () -> ConnContext by kodein.provider()
    
    override fun loadConnNode(cp: ConnProfile) = MysqlNdStruct.findConnNd().create(cp)
    
    override fun loadSubNodes(ctx: NodeLoadingCtx): List<Node> {
        val def = ctx.path.toSub<MysqlNodePath>().getLastNodeDef()
        val subNodes = mutableListOf<Node>()
        def.children.forEach { subNodes.addAll(loadNodes(ctx, it)) }
        return subNodes
    }
    
    private fun loadNodes(ctx: NodeLoadingCtx, def: NodeDef): List<Node> =
            (connContext().conn.rawConn as Connection).run {
                when (def) {
                    is DbNd -> JdbcDbsLoader.loadDbs(this, def, SHOW_DBS)
                    is TableNd -> {
                        val path = ctx.path.toSub<MysqlNodePath>()
                        useDb(this, path.dbName)
                        JdbcTablesLoader.loadTables(this, def, SHOW_TABLES)
                    }
                    is TablesNd -> listOf(MysqlNdStruct.findTablesNd().create())
                    is ViewsNd -> listOf(MysqlNdStruct.findViewsNd().create())
                    else -> emptyList()
                }
            }
    
    private fun useDb(connection: Connection, dbName: String): Unit =
            run {
                connection.prepareStatement("USE $dbName;").execute()
            }
}