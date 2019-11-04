package com.monkeydp.daios.dm.mysql.api

import com.monkeydp.daios.dm.base.api.AbstractMenuApi
import com.monkeydp.daios.dms.sdk.metadata.menu.MenuDef
import com.monkeydp.daios.dm.mysql.metadata.node.MysqlNodePath
import com.monkeydp.daios.dms.sdk.metadata.menu.Menu
import com.monkeydp.daios.dms.sdk.metadata.menu.ctx.NodeMenuLoadCtx

/**
 * @author iPotato
 * @date 2019/11/1
 */
object MysqlMenuApi : AbstractMenuApi() {
    override fun loadNodeMenu(ctx: NodeMenuLoadCtx): Menu? {
        val nodePath = ctx.nodePath.toSub<MysqlNodePath>()
        val nodeDef = nodePath.getLastNodeDef()
        var menuDef: MenuDef? = nodeDef.menuDef
        if (menuDef == null) return null
        val nextDef = ctx.menuPath.recurFindNextDef(menuDef)
        return nextDef?.create()
    }
}