package com.monkeydp.daios.dm.mysql.metadata.menu.def

import com.monkeydp.daios.dm.base.instruction.*
import com.monkeydp.daios.dm.base.metadata.menu.def.menu
import com.monkeydp.daios.dm.base.metadata.menu.def.menuItem

/**
 * @author iPotato
 * @date 2019/11/29
 */
val connMenuDef = menu {
    +OpenConn
    +CloseConn
    +menuItem {
        instr = ManageGroup
        menuDef = menu {
            +NewGroup
        }
    }
}

val dbMenuDef = menu {
    +OpenDb
}