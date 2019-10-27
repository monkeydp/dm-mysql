package com.monkeydp.daios.dm.mysql.conn

import com.monkeydp.daios.dms.sdk.conn.LogicConn
import java.sql.Connection

/**
 * @author iPotato
 * @date 2019/10/21
 */
class MysqlLogicConn(override val rawConn: Connection) : LogicConn {
    
    override fun isValid(timeout: Int): Boolean {
        return rawConn.isValid(timeout)
    }
    
    override fun close() {
        rawConn.close()
    }
    
    override fun isClosed(): Boolean {
        return rawConn.isClosed
    }
}