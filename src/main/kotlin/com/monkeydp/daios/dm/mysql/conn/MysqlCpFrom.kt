package com.monkeydp.daios.dm.mysql.conn

import com.monkeydp.daios.dms.sdk.metadata.form.AbstractCpForm

/**
 * @author iPotato
 * @date 2019/10/20
 */
class MysqlCpFrom(map: Map<String, String>) : AbstractCpForm(map) {
    fun getUrl(): String {
        return "jdbc:mysql://$host:$port?useSSL=true&serverTimezone=UTC&remarksReporting=true"
    }
}