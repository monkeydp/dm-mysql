package com.monkeydp.daios.dm.mysql.metadata.node

import com.monkeydp.daios.dm.mysql.metadata.node.def.*
import com.monkeydp.daios.dms.sdk.metadata.instruction.target.GlobalTarget.*
import com.monkeydp.daios.dms.sdk.metadata.instruction.target.Target
import com.monkeydp.daios.dms.sdk.metadata.node.info.NodeInfoPath
import com.monkeydp.daios.dms.sdk.metadata.node.def.GroupNd
import com.monkeydp.daios.dms.sdk.metadata.node.def.NodeDef


/**
 * @author iPotato
 * @date 2019/10/28
 */
class MysqlNiPath : NodeInfoPath() {
    
    private val map = mapOf<Target<*>, NodeDef>(
            CONN to MysqlConnNd,
            DB to MysqlDbNd,
            TABLE to MysqlTableNd
    )
    private val groupNdList = listOf<GroupNd>(MysqlTablesNd, MysqlViewsNd)
    
    private val dbNodeInfo
        get() = this[1]
    val dbName
        get() = dbNodeInfo.name
    
    private val tableNodeInfo
        get() = this[3]
    val tableName
        get() = tableNodeInfo.name
    
    private val viewNodeInfo
        get() = this[3]
    val viewName
        get() = viewNodeInfo.name
    
    override fun getLastNodeDef(): NodeDef {
        val target = last().target
        return if (target == GROUP) getLastGroupNd()
        else map.getValue(target)
    }
    
    private fun getLastGroupNd() = groupNdList.first { it.info.name == last().name }
}