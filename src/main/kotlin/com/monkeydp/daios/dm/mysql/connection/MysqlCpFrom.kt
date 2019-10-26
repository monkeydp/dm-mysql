package com.monkeydp.daios.dm.mysql.connection

import com.monkeydp.daios.dms.sdk.metadata.form.CpForm

/**
 * @author iPotato
 * @date 2019/10/20
 */
class MysqlCpFrom(map: Map<String, String>) : CpForm(map) {
    fun getUrl(): String {
        return "jdbc:mysql://$host:$port?useSSL=true&serverTimezone=UTC&remarksReporting=true"
    }
}