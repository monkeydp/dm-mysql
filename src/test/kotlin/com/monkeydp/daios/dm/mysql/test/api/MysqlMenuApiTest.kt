package com.monkeydp.daios.dm.mysql.test.api

import com.monkeydp.daios.dm.mysql.mocker.MysqlMenuMocker.manageGroupPath
import com.monkeydp.daios.dm.mysql.mocker.MysqlNodeMocker.connNodePath
import com.monkeydp.daios.dm.mysql.mocker.MysqlNodeMocker.dbNodePath
import com.monkeydp.daios.dm.mysql.test.AbstractTest
import com.monkeydp.daios.dms.sdk.api.MenuApi
import com.monkeydp.daios.dms.sdk.metadata.menu.MenuLoadingCtx
import org.junit.Assert
import org.junit.Test

/**
 * @author iPotato
 * @date 2019/10/18
 */
class MysqlMenuApiTest : AbstractTest() {
    
    private val api: MenuApi = findApi()
    
    @Test
    fun loadConnMenuTest() {
        val ctx = MenuLoadingCtx(nodePath = connNodePath)
        val menu = api.loadMenu(ctx)!!
        Assert.assertTrue(menu.items.isNotEmpty())
    }
    
    @Test
    fun loadDbMenuTest() {
        val ctx = MenuLoadingCtx(nodePath = dbNodePath)
        val menu = api.loadMenu(ctx)!!
        Assert.assertTrue(menu.items.isNotEmpty())
    }
    
    @Test
    fun loadSubMenuTest() {
        val ctx =
                MenuLoadingCtx(nodePath = connNodePath, menuPath = manageGroupPath)
        val menu = api.loadMenu(ctx)!!
        Assert.assertTrue(menu.items.isNotEmpty())
    }
}