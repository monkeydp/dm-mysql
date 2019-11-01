package com.monkeydp.daios.dm.mysql.api

import com.monkeydp.daios.dm.base.api.AbstractMenuApi
import com.monkeydp.daios.dm.mysql.metadata.node.MysqlNiPath
import com.monkeydp.daios.dms.sdk.metadata.menu.Menu
import com.monkeydp.daios.dms.sdk.metadata.menu.ctx.NodeMenuLoadCtx

/**
 * @author iPotato
 * @date 2019/11/1
 */
object MysqlMenuApi : AbstractMenuApi() {
    override fun loadNodeMenu(ctx: NodeMenuLoadCtx): Menu? {
        val path = ctx.path.toSub<MysqlNiPath>()
        val nodeDef = path.getLastNodeDef()
        return nodeDef.menu
    }
}