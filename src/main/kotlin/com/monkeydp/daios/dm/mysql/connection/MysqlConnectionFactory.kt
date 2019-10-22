package com.monkeydp.daios.dm.mysql.connection

import com.monkeydp.daios.dms.sdk.connection.Connection
import com.monkeydp.daios.dms.sdk.connection.ConnectionFactory
import com.monkeydp.daios.dms.sdk.connection.ConnectionProfile
import java.sql.DriverManager

/**
 * @author iPotato
 * @date 2019/10/7
 */
class MysqlConnectionFactory : ConnectionFactory {

    override fun getConnection(profile: ConnectionProfile): Connection {
        val form = profile.userInput.convertTo<MysqlConnectionProfileFrom>()
        Class.forName(profile.dbDriverName)
        val url = form.url()
        val props = MysqlConnectionParameters(
                user = form.username,
                password = form.password
        ).toProperties()
        val rawConn = DriverManager.getConnection(url, props)
        return Connection(profile.id, MysqlLogicConnection(rawConn))
    }
}