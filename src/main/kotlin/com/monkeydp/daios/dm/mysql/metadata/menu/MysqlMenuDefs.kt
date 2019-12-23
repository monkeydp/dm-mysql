package com.monkeydp.daios.dm.mysql.metadata.menu

import com.monkeydp.daios.dm.base.instruction.main.*
import com.monkeydp.daios.dm.base.metadata.menu.MenuDef
import com.monkeydp.daios.dm.base.metadata.menu.MenuItemDef

/**
 * @author iPotato
 * @date 2019/12/23
 */
internal object MysqlMenuDefs {
    val connMd = MenuDef {
        +OpenConn
        +CloseConn
        +MenuItemDef(
                instr = ManageGroup,
                menuDef = MenuDef {
                    +NewGroup
                }
        )
    }
    
    val dbMd = MenuDef {
        +OpenDb
    }
}