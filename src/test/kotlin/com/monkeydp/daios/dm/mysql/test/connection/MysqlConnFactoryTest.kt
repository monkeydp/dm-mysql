package com.monkeydp.daios.dm.mysql.test.connection

import com.monkeydp.daios.dm.mysql.conn.MysqlConnFactory
import com.monkeydp.daios.dm.mysql.test.BaseTest
import com.monkeydp.daios.dms.sdk.conn.CpMocker.mysql57Cp
import org.junit.Assert
import org.junit.Test

/**
 * @author iPotato
 * @date 2019/10/18
 */
class MysqlConnFactoryTest : BaseTest() {
    
    private val connFactory = MysqlConnFactory()
    
    private val testCp = mysql57Cp
    
    @Test
    fun connTest() {
        val conn = connFactory.getConn(testCp)
        Assert.assertTrue(conn.isValid())
        Assert.assertFalse(conn.isClosed())
    
        conn.close()
        Assert.assertFalse(conn.isValid())
        Assert.assertTrue(conn.isClosed())
    }
}