package com.monkeydp.daios.dm.mysql.api

import com.monkeydp.daios.dm.base.api.AbstractMenuApi
import com.monkeydp.daios.dm.base.metadata.menu.def.MenuDef
import com.monkeydp.daios.dm.mysql.metadata.node.MysqlNodePath
import com.monkeydp.daios.dms.sdk.api.SdkApi
import com.monkeydp.daios.dms.sdk.metadata.menu.Menu
import com.monkeydp.daios.dms.sdk.metadata.menu.MenuLoadingCtx

/**
 * @author iPotato
 * @date 2019/11/1
 */
@SdkApi
object MysqlMenuApi : AbstractMenuApi() {
    override fun loadMenu(ctx: MenuLoadingCtx): Menu? {
        val nodePath = ctx.nodePath.toSub<MysqlNodePath>()
        val nodeDef = nodePath.getLastNodeDef()
        var menuDef: MenuDef? = nodeDef.menuDef
        if (menuDef == null) return null
        val nextDef = findNextDef(ctx.menuPath, menuDef)
        return nextDef?.create()
    }
}