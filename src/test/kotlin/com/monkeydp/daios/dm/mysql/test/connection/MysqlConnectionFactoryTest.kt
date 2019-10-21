package com.monkeydp.daios.dm.mysql.test.connection

import com.monkeydp.daios.dm.mysql.connection.MysqlConnectionFactory
import com.monkeydp.daios.dms.sdk.mock.MockFactory.mockConnectionProfile
import org.junit.Test

/**
 * @author iPotato
 * @date 2019/10/18
 */
class MysqlConnectionFactoryTest {

    private val connectionFactory = MysqlConnectionFactory()

    @Test
    fun getConnectionTest() {
        connectionFactory.connection(mockConnectionProfile)
    }
}