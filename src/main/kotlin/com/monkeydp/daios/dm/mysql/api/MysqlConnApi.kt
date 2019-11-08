package com.monkeydp.daios.dm.mysql.api

import com.monkeydp.daios.dm.base.api.AbstractConnApi
import com.monkeydp.daios.dm.mysql.conn.MysqlConn
import com.monkeydp.daios.dm.mysql.conn.MysqlConnParameters
import com.monkeydp.daios.dm.mysql.conn.MysqlNewConnFrom
import com.monkeydp.daios.dms.sdk.api.SdkApi
import com.monkeydp.daios.dms.sdk.conn.ConnProfile
import com.monkeydp.tools.ext.toProps
import java.sql.DriverManager

/**
 * @author iPotato
 * @date 2019/10/7
 */
@SdkApi
object MysqlConnApi : AbstractConnApi() {
    
    override fun getConn(cp: ConnProfile): MysqlConn {
        val form = cp.form as MysqlNewConnFrom
        Class.forName(cp.dsDriverClassname)
        val props = MysqlConnParameters(
                user = form.username,
                password = form.password
        ).toProps()
        val rawConn = DriverManager.getConnection(form.url, props)
        return MysqlConn(cp.id, rawConn)
    }
}