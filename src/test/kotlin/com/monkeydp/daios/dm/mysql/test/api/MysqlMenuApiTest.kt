package com.monkeydp.daios.dm.mysql.test.api

import com.monkeydp.daios.dm.mysql.mocker.MysqlMenuMocker.manageGroupPath
import com.monkeydp.daios.dm.mysql.mocker.MysqlNodeMocker.connNodePath
import com.monkeydp.daios.dm.mysql.mocker.MysqlNodeMocker.dbNodePath
import com.monkeydp.daios.dm.mysql.test.AbstractTest
import com.monkeydp.daios.dms.sdk.metadata.menu.MenuLoadCtx
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
        val ctx = MenuLoadCtx(nodePath = connNodePath)
        val menu = api.loadMenu(ctx)!!
        Assert.assertTrue(menu.items.isNotEmpty())
    }
    
    @Test
    public fun loadDbMenuTest() {
        val ctx = MenuLoadCtx(nodePath = dbNodePath)
        val menu = api.loadMenu(ctx)!!
        Assert.assertTrue(menu.items.isNotEmpty())
    }
    
    @Test
    public fun loadSubMenuTest() {
        val ctx =
                MenuLoadCtx(nodePath = connNodePath, menuPath = manageGroupPath)
        val menu = api.loadMenu(ctx)!!
        Assert.assertTrue(menu.items.isNotEmpty())
    }
}