package com.monkeydp.daios.dm.mysql.connection

import com.monkeydp.daios.dms.sdk.metadata.form.ConnectionProfileForm

/**
 * @author iPotato
 * @date 2019/10/20
 */
class MysqlConnectionProfileFrom(map: Map<String, String>) : ConnectionProfileForm(map) {
    fun getUrl(): String {
        return "jdbc:mysql://$host:$port?useSSL=true&serverTimezone=UTC&remarksReporting=true"
    }
}