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
import com.monkeydp.tools.ext.kodein.providerX
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
    private val connContext: ConnContext get() = kodein.providerX()
    
    @Test
    fun loadDbNodesTest() {
        ContextRepoHolder.contextRepo
                .copy(nodeContext = NodeContext(connNodePath))
                .apply(ContextRepoHolder::setContextRepo)
        api.loadSubNodes().apply {
            assertTrue(isNotEmpty())
            forEach { assertEquals(DB, it.target) }
        }
    }
    
    @Test
    fun loadTableNodesTest() {
        ContextRepoHolder.contextRepo
                .copy(nodeContext = NodeContext(tablesNodePath))
                .apply(ContextRepoHolder::setContextRepo)
        api.loadSubNodes().apply {
            assertTrue(isNotEmpty())
            forEach { assertEquals(TABLE, it.target) }
        }
    }
    
    @Test
    fun loadGroupNodesTest() {
        ContextRepoHolder.contextRepo
                .copy(nodeContext = NodeContext(dbNodePath))
                .apply(ContextRepoHolder::setContextRepo)
        api.loadSubNodes().apply {
            assertTrue(isNotEmpty())
            forEach { assertEquals(GROUP, it.target) }
        }
    }
}