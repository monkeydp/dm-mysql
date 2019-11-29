package com.monkeydp.daios.dm.mysql.metadata.node

import com.monkeydp.daios.dm.base.metadata.node.def.*
import com.monkeydp.daios.dm.base.metadata.node.def.std.StdTablesNd
import com.monkeydp.daios.dm.mysql.metadata.icon.MysqlIcon.MYSQL_CONN_ICON
import com.monkeydp.daios.dm.mysql.metadata.menu.connMenuDef
import com.monkeydp.daios.dm.mysql.metadata.menu.dbMenuDef
import com.monkeydp.daios.dms.sdk.instruction.target.GlobalTarget.DB
import com.monkeydp.daios.dms.sdk.instruction.target.GlobalTarget.GROUP

/**
 * @author iPotato
 * @date 2019/11/29
 */
object MysqlNdStruct : AbstractNdStruct(
        conn {
            icon = MYSQL_CONN_ICON
            menuDef = connMenuDef
            +db {
                menuDef = dbMenuDef
                +tables { +table {} }
                +views { +view {} }
            }
        }
) {
    fun findDbNd() = findNd { it.target == DB }
    fun findTablesNd() = findNd { it.target == GROUP && it.name == StdTablesNd().name }
    fun findViewsNd() = findNd { it.target == GROUP && it.name == StdTablesNd().name }
}

