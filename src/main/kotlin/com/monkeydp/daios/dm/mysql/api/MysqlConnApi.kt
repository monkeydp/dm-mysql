package com.monkeydp.daios.dm.mysql.api

import com.monkeydp.daios.dm.base.jdbc.api.conn.AbstractJdbcConnApi
import com.monkeydp.daios.dm.mysql.MysqlDefs
import com.monkeydp.daios.dm.mysql.conn.MysqlConn
import com.monkeydp.daios.dm.mysql.conn.MysqlConnParameters
import com.monkeydp.daios.dm.mysql.conn.MysqlNewConnFrom
import com.monkeydp.daios.dms.sdk.conn.JdbcConnProfile
import com.monkeydp.daios.dms.sdk.main.SdkApi
import com.monkeydp.tools.ext.toProps
import java.sql.DriverManager

/**
 * @author iPotato
 * @date 2019/10/7
 */
@SdkApi
object MysqlConnApi : AbstractJdbcConnApi() {
    
    override fun findDsDef(cp: JdbcConnProfile) =
            MysqlDefs.toSet().first { it.version == cp.dsVersion }
    
    override fun getConn(cp: JdbcConnProfile): MysqlConn {
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