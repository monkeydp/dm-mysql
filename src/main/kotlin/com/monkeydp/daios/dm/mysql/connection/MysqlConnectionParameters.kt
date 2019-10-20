package com.monkeydp.daios.dm.mysql.connection

import com.monkeydp.tools.util.PropertyUtil
import java.util.*

/**
 * @author iPotato
 * @date 2019/10/20
 */
class MysqlConnectionParameters(
        private val user: String,
        private val password: String
) {
    fun toProperties(): Properties {
        return PropertyUtil.from(this)
    }
}