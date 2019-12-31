package com.monkeydp.daios.dm.mysql.test.api

import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dm.mysql.mocker.MysqlNodePathMocker.connNodePath
import com.monkeydp.daios.dm.mysql.mocker.MysqlNodePathMocker.dbNodePath
import com.monkeydp.daios.dm.mysql.mocker.MysqlNodePathMocker.tablesNodePath
import com.monkeydp.daios.dms.sdk.api.NodeApi
import com.monkeydp.daios.dms.sdk.context.ConnContext
import com.monkeydp.daios.dms.sdk.context.ContextRepoHolder
import com.monkeydp.daios.dms.sdk.context.NodeContext
import com.monkeydp.daios.dms.sdk.instruction.target.GlobalTarget.*
import com.monkeydp.tools.ext.kodein.findImpl
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
    private val connContext: ConnContext get() = kodein.findImpl()
    
    @Test
    fun loadDbNodesTest() {
        ContextRepoHolder.updateContextRepo {
            nodeContext = NodeContext(connNodePath)
        }
        val nodes = api.loadSubNodes()
        assertTrue(nodes.isNotEmpty())
        nodes.forEach { assertEquals(DB, it.target) }
    }
    
    @Test
    fun loadTableNodesTest() {
        ContextRepoHolder.updateContextRepo {
            nodeContext = NodeContext(tablesNodePath)
        }
        val nodes = api.loadSubNodes()
        assertTrue(nodes.isNotEmpty())
        nodes.forEach { assertEquals(TABLE, it.target) }
    }
    
    @Test
    fun loadGroupNodesTest() {
        ContextRepoHolder.updateContextRepo {
            nodeContext = NodeContext(dbNodePath)
        }
        val nodes = api.loadSubNodes()
        assertTrue(nodes.isNotEmpty())
        nodes.forEach { assertEquals(GROUP, it.target) }
    }
}