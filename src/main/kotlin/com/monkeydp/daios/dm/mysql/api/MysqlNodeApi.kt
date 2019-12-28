package com.monkeydp.daios.dm.mysql.api

import com.monkeydp.daios.dm.base.api.AbstractNodeApi
import com.monkeydp.daios.dm.base.jdbc.api.node.JdbcDbLoader
import com.monkeydp.daios.dm.base.jdbc.api.node.JdbcTableLoader
import com.monkeydp.daios.dm.base.metadata.node.def.UnhandledNodeDefException
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
import com.monkeydp.daios.dms.sdk.metadata.node.NodeDef
import com.monkeydp.daios.dms.sdk.metadata.node.NodePath
import com.monkeydp.daios.dms.sdk.metadata.node.find
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
    
    override fun loadNodes(path: NodePath, def: NodeDef): List<Node> =
            loadNodes(path.toSub(), def)
    
    private fun loadNodes(path: MysqlNodePath, def: NodeDef): List<Node> =
            (connContext.conn.rawConn as Connection).let {
                when (def) {
                    is DbNd -> JdbcDbLoader.loadDbNodes(it, def, SHOW_DBS)
                    is TableNd -> {
                        useDb(it, path.dbName)
                        JdbcTableLoader.loadTableNodes(it, def, SHOW_TABLES)
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