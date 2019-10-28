package com.monkeydp.daios.dm.mysql.conn

import com.monkeydp.daios.dms.sdk.conn.AbstractConnApi
import com.monkeydp.daios.dms.sdk.entity.ConnProfile
import java.sql.DriverManager

/**
 * @author iPotato
 * @date 2019/10/7
 */
object MysqlConnApi : AbstractConnApi() {
    
    override fun getConn(cp: ConnProfile): MysqlConn {
        val form = cp.form as MysqlCpFrom
        Class.forName(cp.dsDriverClassname)
        val props = MysqlConnParameters(
                user = form.username,
                password = form.password
        ).toProperties()
        val rawConn = DriverManager.getConnection(form.url, props)
        return MysqlConn(cp.id, rawConn)
    }
}