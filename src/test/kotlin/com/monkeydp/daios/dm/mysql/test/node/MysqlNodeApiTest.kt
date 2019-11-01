package com.monkeydp.daios.dm.mysql.test.node

import com.monkeydp.daios.dm.mysql.mocker.MysqlNiPathMocker
import com.monkeydp.daios.dm.mysql.test.AbstractTest
import com.monkeydp.daios.dms.sdk.metadata.node.ctx.NodeLoadCtx
import com.monkeydp.daios.dm.base.metadata.node.main.AbstractGroupNode
import com.monkeydp.daios.dm.base.metadata.node.main.DbNode
import com.monkeydp.daios.dm.base.metadata.node.main.TableNode
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
        val ctx = NodeLoadCtx(conn, MysqlNiPathMocker.connNiPath)
        val nodes = api.loadNodes(ctx)
        Assert.assertTrue(nodes.isNotEmpty())
        nodes.forEach { Assert.assertTrue(it is DbNode) }
    }
    
    @Test
    public fun loadTablesTest() {
        val ctx = NodeLoadCtx(conn, MysqlNiPathMocker.tablesNiPath)
        val nodes = api.loadNodes(ctx)
        Assert.assertTrue(nodes.isNotEmpty())
        nodes.forEach { Assert.assertTrue(it is TableNode) }
    }
    
    @Test
    public fun loadGroupsTest() {
        val ctx = NodeLoadCtx(conn, MysqlNiPathMocker.dbNiPath)
        val nodes = api.loadNodes(ctx)
        Assert.assertTrue(nodes.isNotEmpty())
        nodes.forEach { Assert.assertTrue(it is AbstractGroupNode) }
    }
}