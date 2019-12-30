package com.monkeydp.daios.dm.mysql.api

import com.monkeydp.daios.dm.base.api.AbstractNodeApi
import com.monkeydp.daios.dm.base.jdbc.api.node.JdbcDbLoader
import com.monkeydp.daios.dm.base.jdbc.api.node.JdbcTableLoader
import com.monkeydp.daios.dm.base.ui.node.def.DbNd
import com.monkeydp.daios.dm.base.ui.node.def.TableNd
import com.monkeydp.daios.dm.base.ui.node.def.UnhandledNodeDefException
import com.monkeydp.daios.dm.mysql.MysqlSql.SHOW_DBS
import com.monkeydp.daios.dm.mysql.MysqlSql.SHOW_TABLES
import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dm.mysql.ui.node.MysqlNodePath
import com.monkeydp.daios.dms.sdk.api.annot.SdkNodeApi
import com.monkeydp.daios.dms.sdk.ui.node.Node
import com.monkeydp.daios.dms.sdk.ui.node.NodeDef
import com.monkeydp.daios.dms.sdk.ui.node.NodePath
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
    
    override fun loadNonGroupNodes(path: NodePath, def: NodeDef): List<Node> =
            loadNonGroupNodes(path.toSub(), def)
    
    private fun loadNonGroupNodes(path: MysqlNodePath, def: NodeDef): List<Node> =
            (connContext.conn.rawConn as Connection).let {
                when (def) {
                    is DbNd -> JdbcDbLoader.loadDbNodes(it, def, SHOW_DBS)
                    is TableNd -> {
                        useDb(it, path.dbName)
                        JdbcTableLoader.loadTableNodes(it, def, SHOW_TABLES)
                    }
                    else -> throw UnhandledNodeDefException(def)
                }
            }
    
    private fun useDb(connection: Connection, dbName: String) {
        connection.prepareStatement("USE $dbName;").execute()
    }
}