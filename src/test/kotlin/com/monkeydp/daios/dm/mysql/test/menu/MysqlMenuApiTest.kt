package com.monkeydp.daios.dm.mysql.test.menu

import com.monkeydp.daios.dm.mysql.mocker.MysqlMenuMocker
import com.monkeydp.daios.dm.mysql.mocker.MysqlNodeMocker
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
        val ctx = NodeMenuLoadCtx(MysqlNodeMocker.connNodePath)
        val menu = api.loadNodeMenu(ctx)!!
        Assert.assertTrue(menu.items.isNotEmpty())
    }
    
    @Test
    public fun loadDbMenuTest() {
        val ctx = NodeMenuLoadCtx(MysqlNodeMocker.dbNodePath)
        val menu = api.loadNodeMenu(ctx)!!
        Assert.assertTrue(menu.items.isNotEmpty())
    }
    
    @Test
    public fun loadSubMenuTest() {
        val ctx = NodeMenuLoadCtx(MysqlNodeMocker.connNodePath, MysqlMenuMocker.manageGroupPath)
        val menu = api.loadNodeMenu(ctx)!!
        Assert.assertTrue(menu.items.isNotEmpty())
    }
}