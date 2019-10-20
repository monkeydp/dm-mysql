package com.monkeydp.daios.dm.mysql.connection

import com.monkeydp.daios.dms.sdk.connection.Connection
import com.monkeydp.daios.dms.sdk.connection.ConnectionFactory
import com.monkeydp.daios.dms.sdk.connection.ConnectionProfile

/**
 * @author iPotato
 * @date 2019/10/7
 */
class MysqlConnectionFactory : ConnectionFactory {
    override fun getConnection(profile: ConnectionProfile): Connection {
        Class.forName(profile.dbDriverName)
        return Connection(5L, 1L)
    }
}