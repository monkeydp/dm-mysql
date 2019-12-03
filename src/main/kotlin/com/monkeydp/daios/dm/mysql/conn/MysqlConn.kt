package com.monkeydp.daios.dm.mysql.conn

import com.monkeydp.daios.dm.base.jdbc.conn.AbstractJdbcConn
import java.sql.Connection

/**
 * @author iPotato
 * @date 2019/10/21
 */
class MysqlConn(
        cpId: Long,
        rawConn: Connection
) : AbstractJdbcConn(cpId, rawConn)