package com.monkeydp.daios.dm.mysql.metadata.node

import com.monkeydp.daios.dm.base.metadata.node.def.*
import com.monkeydp.daios.dm.mysql.metadata.icon.MysqlIcon.MYSQL_CONN_ICON

/**
 * @author iPotato
 * @date 2019/11/29
 */
object MysqlNdStruct : AbstractNdStruct(
        conn {
            icon = MYSQL_CONN_ICON
            +db {
                +tables { +table {} }
                +views { +view {} }
            }
        }
)

