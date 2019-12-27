package com.monkeydp.daios.dm.mysql.mocker

import com.monkeydp.daios.dms.sdk.instruction.main.ManageGroup
import com.monkeydp.daios.dm.mysql.metadata.menu.MysqlMenuDefs.connMd
import com.monkeydp.daios.dms.sdk.metadata.menu.item.MenuPath

/**
 * @author iPotato
 * @date 2019/10/29
 */
object MysqlMenuMocker {
    val manageGroupPath = MenuPath.of(connMd.items.first { it.instr == ManageGroup }.create())
}