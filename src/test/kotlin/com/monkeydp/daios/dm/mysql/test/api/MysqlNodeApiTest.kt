package com.monkeydp.daios.dm.mysql.test.api

import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dm.mysql.mocker.MysqlNodeMocker
import com.monkeydp.daios.dms.sdk.api.NodeApi
import com.monkeydp.daios.dms.sdk.instruction.target.GlobalTarget.*
import com.monkeydp.daios.dms.sdk.metadata.node.NodeLoadingCtx
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.kodein.di.generic.instance

/**
 * @author iPotato
 * @date 2019/10/18
 */
internal class MysqlNodeApiTest : MysqlAbstractApiTest() {
    
    private val api: NodeApi by kodein.instance()
    
    @Test
    fun loadDbsTest() {
        val ctx = NodeLoadingCtx(MysqlNodeMocker.connNodePath)
        val nodes = api.loadSubNodes(ctx)
        assertTrue(nodes.isNotEmpty())
        nodes.forEach { assertEquals(DB, it.target) }
    }
    
    @Test
    fun loadTablesTest() {
        val ctx = NodeLoadingCtx(MysqlNodeMocker.tablesNodePath)
        val nodes = api.loadSubNodes(ctx)
        assertTrue(nodes.isNotEmpty())
        nodes.forEach { assertEquals(TABLE, it.target) }
    }
    
    @Test
    fun loadGroupsTest() {
        val ctx = NodeLoadingCtx(MysqlNodeMocker.dbNodePath)
        val nodes = api.loadSubNodes(ctx)
        assertTrue(nodes.isNotEmpty())
        nodes.forEach { assertEquals(GROUP, it.target) }
    }
}