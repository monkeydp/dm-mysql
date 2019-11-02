package com.monkeydp.daios.dm.mysql.test.node

import com.monkeydp.daios.dm.base.metadata.node.DbNode
import com.monkeydp.daios.dm.base.metadata.node.GroupNode
import com.monkeydp.daios.dm.base.metadata.node.TableNode
import com.monkeydp.daios.dm.mysql.mocker.MysqlNodePathMocker
import com.monkeydp.daios.dm.mysql.test.AbstractTest
import com.monkeydp.daios.dms.sdk.metadata.node.ctx.NodeLoadCtx
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
        val ctx = NodeLoadCtx(conn, MysqlNodePathMocker.connNodePath)
        val nodes = api.loadSubNodes(ctx)
        Assert.assertTrue(nodes.isNotEmpty())
        nodes.forEach { Assert.assertTrue(it is DbNode) }
    }
    
    @Test
    public fun loadTablesTest() {
        val ctx = NodeLoadCtx(conn, MysqlNodePathMocker.tablesNodePath)
        val nodes = api.loadSubNodes(ctx)
        Assert.assertTrue(nodes.isNotEmpty())
        nodes.forEach { Assert.assertTrue(it is TableNode) }
    }
    
    @Test
    public fun loadGroupsTest() {
        val ctx = NodeLoadCtx(conn, MysqlNodePathMocker.dbNodePath)
        val nodes = api.loadSubNodes(ctx)
        Assert.assertTrue(nodes.isNotEmpty())
        nodes.forEach { Assert.assertTrue(it is GroupNode) }
    }
}