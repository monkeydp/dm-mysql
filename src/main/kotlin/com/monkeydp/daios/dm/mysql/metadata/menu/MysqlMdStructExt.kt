package com.monkeydp.daios.dm.mysql.metadata.menu

import com.monkeydp.daios.dm.base.instruction.main.*
import com.monkeydp.daios.dm.base.metadata.menu.def.menuDef
import com.monkeydp.daios.dm.base.metadata.menu.item.def.menuItemDef

/**
 * @author iPotato
 * @date 2019/11/29
 */
val connMenuDef = menuDef {
    +OpenConn
    +CloseConn
    +menuItemDef {
        instr = ManageGroup
        menuDef = menuDef {
            +NewGroup
        }
    }
}

val dbMenuDef = menuDef {
    +OpenDb
}