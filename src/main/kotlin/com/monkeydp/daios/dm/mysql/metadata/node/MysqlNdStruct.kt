package com.monkeydp.daios.dm.mysql.metadata.node

import com.monkeydp.daios.dm.base.metadata.node.def.AbstractNdStruct
import com.monkeydp.daios.dm.base.metadata.node.def.SdkNdStruct
import com.monkeydp.daios.dm.base.metadata.node.def.sub.*
import com.monkeydp.daios.dm.mysql.metadata.icon.MysqlIcon.MYSQL_CONN_ICON
import com.monkeydp.daios.dm.mysql.metadata.menu.MysqlMenuDefs.connMd
import com.monkeydp.daios.dm.mysql.metadata.menu.MysqlMenuDefs.dbMd

/**
 * @author iPotato
 * @date 2019/11/29
 */
@SdkNdStruct
object MysqlNdStruct : AbstractNdStruct(
        ConnNd {
            icon = MYSQL_CONN_ICON
            menuDef = connMd
            +DbNd {
                menuDef = dbMd
                +TablesNd { +TableNd {} }
                +ViewsNd { +ViewsNd {} }
            }
        }
)

