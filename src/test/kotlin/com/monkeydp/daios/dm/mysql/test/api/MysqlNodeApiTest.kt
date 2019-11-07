package com.monkeydp.daios.dm.mysql.test.api

import com.monkeydp.daios.dm.mysql.mocker.MysqlNodeMocker
import com.monkeydp.daios.dm.mysql.test.AbstractTest
import com.monkeydp.daios.dms.sdk.instruction.target.GlobalTarget.*
import com.monkeydp.daios.dms.sdk.metadata.node.NodeLoadingCtx
import org.junit.Assert
import org.junit.Test

/**
 * @author iPotato
 * @date 2019/10/18
 */
class MysqlNodeApiTest : AbstractTest() {
    
    private val api = apis.nodeApi
    
    @Test
    public fun loadDbsTest() {
        val ctx = NodeLoadingCtx(conn, MysqlNodeMocker.connNodePath)
        val nodes = api.loadSubNodes(ctx)
        Assert.assertTrue(nodes.isNotEmpty())
        nodes.forEach { Assert.assertTrue(it.target == DB) }
    }
    
    @Test
    public fun loadTablesTest() {
        val ctx = NodeLoadingCtx(conn, MysqlNodeMocker.tablesNodePath)
        val nodes = api.loadSubNodes(ctx)
        Assert.assertTrue(nodes.isNotEmpty())
        nodes.forEach { Assert.assertTrue(it.target == TABLE) }
    }
    
    @Test
    public fun loadGroupsTest() {
        val ctx = NodeLoadingCtx(conn, MysqlNodeMocker.dbNodePath)
        val nodes = api.loadSubNodes(ctx)
        Assert.assertTrue(nodes.isNotEmpty())
        nodes.forEach { Assert.assertTrue(it.target == GROUP) }
    }
}