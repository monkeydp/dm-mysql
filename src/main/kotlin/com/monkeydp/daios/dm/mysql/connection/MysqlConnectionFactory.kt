package com.monkeydp.daios.dm.mysql.connection

import com.monkeydp.daios.dms.sdk.connection.Connection
import com.monkeydp.daios.dms.sdk.connection.ConnectionFactory
import com.monkeydp.daios.dms.sdk.model.ConnectionProfile
import java.sql.DriverManager

/**
 * @author iPotato
 * @date 2019/10/7
 */
class MysqlConnectionFactory : ConnectionFactory {

    override fun getConnection(cp: ConnectionProfile): Connection {
        val form = cp.userInput.convertTo<MysqlConnectionProfileFrom>()
        Class.forName(cp.dbDriverName)
        val url = form.url()
        val props = MysqlConnectionParameters(
                user = form.username,
                password = form.password
        ).toProperties()
        val rawConn = DriverManager.getConnection(url, props)
        return Connection(cp.id, MysqlLogicConnection(rawConn))
    }
}