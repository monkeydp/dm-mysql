package com.monkeydp.daios.dm.mysql.test.api

import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dm.mysql.mocker.MysqlNodeMocker.connNodePath
import com.monkeydp.daios.dm.mysql.mocker.MysqlNodeMocker.dbNodePath
import com.monkeydp.daios.dm.mysql.mocker.MysqlNodeMocker.tablesNodePath
import com.monkeydp.daios.dms.sdk.api.NodeApi
import com.monkeydp.daios.dms.sdk.instruction.target.GlobalTarget.*
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
    fun loadDbNodesTest() {
        val nodes = api.loadSubNodes(connNodePath)
        assertTrue(nodes.isNotEmpty())
        nodes.forEach { assertEquals(DB, it.target) }
    }
    
    @Test
    fun loadTableNodesTest() {
        val nodes = api.loadSubNodes(tablesNodePath)
        assertTrue(nodes.isNotEmpty())
        nodes.forEach { assertEquals(TABLE, it.target) }
    }
    
    @Test
    fun loadGroupNodesTest() {
        val nodes = api.loadSubNodes(dbNodePath)
        assertTrue(nodes.isNotEmpty())
        nodes.forEach { assertEquals(GROUP, it.target) }
    }
}