package com.monkeydp.daios.dm.mysql.metadata.node

import com.monkeydp.daios.dm.mysql.MysqlSql
import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlConnNd
import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlDbNd
import com.monkeydp.daios.dm.mysql.metadata.node.def.MysqlTableNd
import com.monkeydp.daios.dms.sdk.api.impl.AbstractJdbcNodeApi
import com.monkeydp.daios.dms.sdk.metadata.instruction.target.GlobalTarget.*
import com.monkeydp.daios.dms.sdk.metadata.instruction.target.Target
import com.monkeydp.daios.dms.sdk.metadata.node.def.NodeDef

/**
 * @author iPotato
 * @date 2019/10/25
 */
object MysqlNodeApi : AbstractJdbcNodeApi() {
    
    override val map = mapOf<Target<*>, Pair<NodeDef, String>>(
            CONN to Pair(MysqlConnNd, ""),
            DB to Pair(MysqlDbNd, MysqlSql.SHOW_DBS),
            TABLE to Pair(MysqlTableNd, "")
    )
}