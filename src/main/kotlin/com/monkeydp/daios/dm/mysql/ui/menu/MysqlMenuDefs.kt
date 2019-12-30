package com.monkeydp.daios.dm.mysql.ui.menu

import com.monkeydp.daios.dm.base.instruction.main.OpenDb
import com.monkeydp.daios.dms.sdk.instruction.main.CloseConn
import com.monkeydp.daios.dms.sdk.instruction.main.ManageGroup
import com.monkeydp.daios.dms.sdk.instruction.main.NewGroup
import com.monkeydp.daios.dms.sdk.instruction.main.OpenConn
import com.monkeydp.daios.dms.sdk.ui.menu.MenuDef
import com.monkeydp.daios.dms.sdk.ui.menu.MenuItemDef

/**
 * @author iPotato
 * @date 2019/12/29
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