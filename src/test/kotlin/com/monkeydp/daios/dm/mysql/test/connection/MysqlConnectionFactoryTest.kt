package com.monkeydp.daios.dm.mysql.test.connection

import com.monkeydp.daios.dm.mysql.connection.MysqlConnectionFactory
import com.monkeydp.daios.dms.sdk.connection.ConnectionProfileMocker.mysql57Cp
import org.junit.Assert
import org.junit.Test

/**
 * @author iPotato
 * @date 2019/10/18
 */
class MysqlConnectionFactoryTest {

    private val connectionFactory = MysqlConnectionFactory()

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