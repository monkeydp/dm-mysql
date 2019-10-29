package com.monkeydp.daios.dm.mysql.test.node

import com.monkeydp.daios.dm.mysql.metadata.node.MysqlNiPathMocker
import com.monkeydp.daios.dm.mysql.metadata.node.MysqlNodeApi
import com.monkeydp.daios.dm.mysql.test.AbstractTest
import com.monkeydp.daios.dms.sdk.metadata.node.NodeLoadContext
import com.monkeydp.daios.dms.sdk.metadata.node.impl.DbNode
import com.monkeydp.daios.dms.sdk.metadata.node.impl.TableNode
import org.junit.Assert
import org.junit.Test

/**
 * @author iPotato
 * @date 2019/10/18
 */
class MysqlNodeApiTest : AbstractTest() {
    
    private val api = MysqlNodeApi
    
    @Test
    public fun loadDbsTest() {
        val ctx = NodeLoadContext.mock(conn, MysqlNiPathMocker.connNiPath)
        val nodes = api.loadNodes(ctx)
        Assert.assertTrue(nodes.isNotEmpty())
        nodes.forEach { Assert.assertTrue(it is DbNode) }
    }
    
    @Test
    public fun loadTablesTest() {
        val ctx = NodeLoadContext.mock(conn, MysqlNiPathMocker.tablesNiPath)
        val nodes = api.loadNodes(ctx)
        Assert.assertTrue(nodes.isNotEmpty())
        nodes.forEach { Assert.assertTrue(it is TableNode) }
    }
}