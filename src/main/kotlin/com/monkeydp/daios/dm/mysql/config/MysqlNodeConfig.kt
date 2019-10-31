package com.monkeydp.daios.dm.mysql.config

import com.fasterxml.jackson.databind.JsonNode
import com.monkeydp.daios.dm.mysql.ext.config

/**
 * @author iPotato
 * @date 2019/10/30
 */
object MysqlNodeConfig {
    
    val structure: JsonNode
    
    init {
        val node = config()["node"]
        structure = node[::structure.name]
    }
}