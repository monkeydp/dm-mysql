package com.monkeydp.daios.dm.mysql.test.connection

import com.monkeydp.daios.dm.mysql.connection.MysqlConnFactory
import com.monkeydp.daios.dm.mysql.test.BaseTest
import com.monkeydp.daios.dms.sdk.connection.CpMocker.mysql57Cp
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * @author iPotato
 * @date 2019/10/18
 */
class MysqlConnFactoryTest : BaseTest() {
    
    private val connectionFactory = MysqlConnFactory()
    
    private val testCp = mysql57Cp
    
    @Test
    fun connectionTest() {
        val connection = connectionFactory.getConnection(testCp)
        Assert.assertTrue(connection.isValid())
        Assert.assertFalse(connection.isClosed())
        
        connection.close()
        Assert.assertFalse(connection.isValid())
        Assert.assertTrue(connection.isClosed())
    }
}