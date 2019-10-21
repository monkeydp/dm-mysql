package com.monkeydp.daios.dm.mysql.connection

import com.monkeydp.daios.dms.sdk.connection.LogicConnection
import java.sql.Connection

/**
 * @author iPotato
 * @date 2019/10/21
 */
class MysqlLogicConnection(override val rawConnection: Connection) : LogicConnection {

    override fun isValid(timeout: Int): Boolean {
        return rawConnection.isValid(timeout)
    }

    override fun close() {
        rawConnection.close()
    }

    override fun isClosed(): Boolean {
        return rawConnection.isClosed
    }
}