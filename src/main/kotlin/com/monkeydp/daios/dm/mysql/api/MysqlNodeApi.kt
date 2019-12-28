package com.monkeydp.daios.dm.mysql.api

import com.monkeydp.daios.dm.base.api.AbstractNodeApi
import com.monkeydp.daios.dm.base.jdbc.api.node.JdbcDbsLoader
import com.monkeydp.daios.dm.base.jdbc.api.node.JdbcTablesLoader
import com.monkeydp.daios.dm.base.metadata.node.def.NodeDef
import com.monkeydp.daios.dm.base.metadata.node.def.UnhandledNodeDefException
import com.monkeydp.daios.dm.base.metadata.node.def.find
import com.monkeydp.daios.dm.base.metadata.node.def.sub.DbNd
import com.monkeydp.daios.dm.base.metadata.node.def.sub.TableNd
import com.monkeydp.daios.dm.base.metadata.node.def.sub.TablesNd
import com.monkeydp.daios.dm.base.metadata.node.def.sub.ViewsNd
import com.monkeydp.daios.dm.mysql.MysqlSql.SHOW_DBS
import com.monkeydp.daios.dm.mysql.MysqlSql.SHOW_TABLES
import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dm.mysql.metadata.node.MysqlNodePath
import com.monkeydp.daios.dms.sdk.api.annot.SdkNodeApi
import com.monkeydp.daios.dms.sdk.metadata.node.Node
import com.monkeydp.daios.dms.sdk.metadata.node.NodeLoadingCtx
import com.monkeydp.daios.dms.sdk.share.conn.ConnContext
import org.kodein.di.generic.instance
import java.sql.Connection

/**
 * @author iPotato
 * @date 2019/10/25
 */
@SdkNodeApi
object MysqlNodeApi : AbstractNodeApi() {
    
    private val connContext: ConnContext by kodein.instance()
    
    override fun loadSubNodes(ctx: NodeLoadingCtx): List<Node> =
            ctx.path.toSub<MysqlNodePath>().run {
                getLastNodeDef().children.map { loadNodes(this, it) }.flatten()
            }
    
    private fun loadNodes(path: MysqlNodePath, def: NodeDef): List<Node> =
            (connContext.conn.rawConn as Connection).let {
                when (def) {
                    is DbNd -> JdbcDbsLoader.loadDbs(it, def, SHOW_DBS)
                    is TableNd -> {
                        useDb(it, path.dbName)
                        JdbcTablesLoader.loadTables(it, def, SHOW_TABLES)
                    }
                    is TablesNd -> listOf(ndStruct.find<TablesNd>().create())
                    is ViewsNd -> listOf(ndStruct.find<ViewsNd>().create())
                    else -> throw UnhandledNodeDefException(def)
                }
            }
    
    private fun useDb(connection: Connection, dbName: String) {
        connection.prepareStatement("USE $dbName;").execute()
    }
}