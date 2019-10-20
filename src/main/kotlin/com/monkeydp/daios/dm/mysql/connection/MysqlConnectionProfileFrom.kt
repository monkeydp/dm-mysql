package com.monkeydp.daios.dm.mysql.connection

import kotlin.properties.Delegates

/**
 * @author iPotato
 * @date 2019/10/20
 */
class MysqlConnectionProfileFrom {

    private val urlFormat = "jdbc:mysql://%s:%s?useSSL=true&serverTimezone=UTC&remarksReporting=true"

    lateinit var host: String
    var port by Delegates.notNull<Int>()
    lateinit var username: String
    lateinit var password: String

    fun url(): String {
        return String.format(urlFormat, host, port)
    }
}