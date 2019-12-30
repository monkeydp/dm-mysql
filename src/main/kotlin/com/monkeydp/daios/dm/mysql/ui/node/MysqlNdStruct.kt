package com.monkeydp.daios.dm.mysql.ui.node

import com.monkeydp.daios.dm.base.ui.node.def.*
import com.monkeydp.daios.dm.mysql.ui.icon.MysqlIcon.MYSQL_CONN_ICON
import com.monkeydp.daios.dm.mysql.ui.menu.MysqlMenuDefs.connMd
import com.monkeydp.daios.dm.mysql.ui.menu.MysqlMenuDefs.dbMd
import com.monkeydp.daios.dms.sdk.ui.node.AbstractNdStruct
import com.monkeydp.daios.dms.sdk.ui.node.SdkNdStruct

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

