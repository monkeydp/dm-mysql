package com.monkeydp.daios.dm.mysql.api

import com.monkeydp.daios.dm.base.api.AbstractConnApi
import com.monkeydp.daios.dm.mysql.conn.MysqlConn
import com.monkeydp.daios.dm.mysql.conn.MysqlConnParameters
import com.monkeydp.daios.dm.mysql.conn.MysqlNewConnFrom
import com.monkeydp.daios.dm.mysql.conn.dsDef
import com.monkeydp.daios.dms.sdk.api.annot.SdkConnApi
import com.monkeydp.daios.dms.sdk.conn.ConnProfile
import com.monkeydp.tools.ext.kotlin.toProperties
import java.sql.DriverManager

/**
 * @author iPotato
 * @date 2019/10/7
 */
@SdkConnApi
object MysqlConnApi : AbstractConnApi() {
    override fun getConn(cp: ConnProfile): MysqlConn {
        Class.forName(cp.dsDef.driver.classname)
        val form = cp.form as MysqlNewConnFrom
        val props = MysqlConnParameters(
                user = form.username,
                password = form.password
        ).toProperties()
        val rawConn = DriverManager.getConnection(form.url, props)
        return MysqlConn(cp.id, rawConn)
    }
}