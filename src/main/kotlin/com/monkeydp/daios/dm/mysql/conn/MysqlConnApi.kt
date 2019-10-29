package com.monkeydp.daios.dm.mysql.conn

import com.monkeydp.daios.dms.sdk.api.impl.AbstractConnApi
import com.monkeydp.daios.dms.sdk.entity.ConnProfile
import com.monkeydp.tools.function.toProperties
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