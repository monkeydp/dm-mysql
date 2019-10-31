package com.monkeydp.daios.dm.mysql.conn

import com.monkeydp.daios.dm.base.conn.AbstractConn
import java.sql.Connection

/**
 * @author iPotato
 * @date 2019/10/21
 */
data class MysqlConn(
        override val cpId: Long,
        override val rawConn: Connection
) : AbstractConn<Connection>(cpId, rawConn) {
    
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