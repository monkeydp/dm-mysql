package com.monkeydp.daios.dm.mysql.test.menu

import com.monkeydp.daios.dm.mysql.mocker.MysqlNiPathMocker
import com.monkeydp.daios.dm.mysql.test.AbstractTest
import com.monkeydp.daios.dms.sdk.metadata.menu.ctx.NodeMenuLoadCtx
import org.junit.Assert
import org.junit.Test

/**
 * @author iPotato
 * @date 2019/10/18
 */
class MysqlMenuApiTest : AbstractTest() {
    
    private val api = apis.menuApi
    
    @Test
    public fun loadConnMenuTest() {
        val ctx = NodeMenuLoadCtx(MysqlNiPathMocker.connNiPath)
        val menu = api.loadNodeMenu(ctx)!!
        val items = menu.items
        Assert.assertTrue(items.isNotEmpty())
    }
    
    @Test
    public fun loadDbMenuTest() {
        val ctx = NodeMenuLoadCtx(MysqlNiPathMocker.dbNiPath)
        val menu = api.loadNodeMenu(ctx)!!
        val items = menu.items
        Assert.assertTrue(items.isNotEmpty())
    }
}