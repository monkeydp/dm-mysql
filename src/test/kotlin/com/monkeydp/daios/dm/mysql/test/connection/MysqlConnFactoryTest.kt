package com.monkeydp.daios.dm.mysql.test.connection

import com.monkeydp.daios.dm.mysql.conn.MysqlConnFactory
import com.monkeydp.daios.dm.mysql.conn.MysqlCpMocker
import com.monkeydp.daios.dm.mysql.test.BaseTest
import org.junit.Assert
import org.junit.Test

/**
 * @author iPotato
 * @date 2019/10/18
 */
class MysqlConnFactoryTest : BaseTest() {
    
    private val connFactory = MysqlConnFactory()
    
    @Test
    fun connTest() {
        val conn = connFactory.getConn(MysqlCpMocker.cp)
        Assert.assertTrue(conn.isValid())
        Assert.assertFalse(conn.isClosed())
    
        conn.close()
        Assert.assertFalse(conn.isValid())
        Assert.assertTrue(conn.isClosed())
    }
}