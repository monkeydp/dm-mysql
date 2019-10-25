package com.monkeydp.daios.dm.mysql.connection

import com.monkeydp.daios.dms.sdk.connection.AbstractConnectionFactory
import com.monkeydp.daios.dms.sdk.connection.Connection
import com.monkeydp.daios.dms.sdk.entity.ConnectionProfile
import java.sql.DriverManager

/**
 * @author iPotato
 * @date 2019/10/7
 */
class MysqlConnectionFactory : AbstractConnectionFactory() {
    
    override fun getConnection(cp: ConnectionProfile): Connection {
        val form = MysqlConnectionProfileFrom(cp.userInput)
        Class.forName(cp.dsDriverClassname)
        val url = form.getUrl()
        val props = MysqlConnectionParameters(
                user = form.username,
                password = form.password
        ).toProperties()
        val rawConn = DriverManager.getConnection(url, props)
        return Connection(cp.id, MysqlLogicConnection(rawConn))
    }
}