package com.monkeydp.daios.dm.mysql.test.api

import com.monkeydp.daios.dm.base.ui.node.def.ConnNd
import com.monkeydp.daios.dm.base.ui.node.def.DbNd
import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dms.sdk.api.MenuApi
import com.monkeydp.daios.dms.sdk.instruction.main.ManageGroup
import com.monkeydp.daios.dms.sdk.ui.menu.MenuDef
import com.monkeydp.daios.dms.sdk.ui.node.NodeDef
import com.monkeydp.daios.dms.sdk.ui.node.NodeDefStruct
import com.monkeydp.daios.dms.sdk.ui.node.find
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.kodein.di.generic.instance

/**
 * @author iPotato
 * @date 2019/10/18
 */
internal class MysqlMenuApiTest : MysqlAbstractApiTest() {

    private val api: MenuApi by kodein.instance()
    private val ndStruct: NodeDefStruct by kodein.instance()

    private inline fun <reified ND : NodeDef> findMenuDefId(): Int = findMenuDef<ND>().id

    private inline fun <reified ND : NodeDef> findMenuDef(): MenuDef = ndStruct.find<ND>().menuDef!!

    @Test
    fun loadConnMenuTest() {
        val menu = api.loadMenu(findMenuDefId<ConnNd>())
        assertTrue(menu.items.isNotEmpty())
    }

    @Test
    fun loadDbMenuTest() {
        val menu = api.loadMenu(findMenuDefId<DbNd>())
        assertTrue(menu.items.isNotEmpty())
    }

    @Test
    fun loadSubMenuTest() {
        val menuDefId = findMenuDef<ConnNd>().items.first { it.instr == ManageGroup }.menuDef!!.id
        val menu = api.loadMenu(menuDefId)
        assertTrue(menu.items.isNotEmpty())
    }
}