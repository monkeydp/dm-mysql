package com.monkeydp.daios.dm.mysql.test.api

import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dm.mysql.mocker.MysqlMenuMocker.manageGroupPath
import com.monkeydp.daios.dm.mysql.mocker.MysqlNodeMocker.connNodePath
import com.monkeydp.daios.dm.mysql.mocker.MysqlNodeMocker.dbNodePath
import com.monkeydp.daios.dms.sdk.api.MenuApi
import com.monkeydp.daios.dms.sdk.metadata.menu.MenuLoadingCtx
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.kodein.di.generic.instance

/**
 * @author iPotato
 * @date 2019/10/18
 */
internal class MysqlMenuApiTest : MysqlAbstractApiTest() {
    
    private val api: MenuApi by kodein.instance()
    
    @Test
    fun loadConnMenuTest() {
        val ctx = MenuLoadingCtx(nodePath = connNodePath)
        val menu = api.loadMenu(ctx)
        assertTrue(menu.items.isNotEmpty())
    }
    
    @Test
    fun loadDbMenuTest() {
        val ctx = MenuLoadingCtx(nodePath = dbNodePath)
        val menu = api.loadMenu(ctx)
        assertTrue(menu.items.isNotEmpty())
    }
    
    @Test
    fun loadSubMenuTest() {
        val ctx = MenuLoadingCtx(nodePath = connNodePath, menuPath = manageGroupPath)
        val menu = api.loadMenu(ctx)
        assertTrue(menu.items.isNotEmpty())
    }
}