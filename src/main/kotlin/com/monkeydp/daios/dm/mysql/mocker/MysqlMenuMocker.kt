package com.monkeydp.daios.dm.mysql.mocker

import com.monkeydp.daios.dm.mysql.metadata.menu.item.def.MysqlManageGroupMid
import com.monkeydp.daios.dms.sdk.metadata.menu.item.MenuPath

/**
 * @author iPotato
 * @date 2019/10/29
 */
object MysqlMenuMocker {
    val manageGroupPath = MenuPath.of(MysqlManageGroupMid.create())
}