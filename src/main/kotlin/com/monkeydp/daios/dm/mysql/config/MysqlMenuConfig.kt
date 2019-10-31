package com.monkeydp.daios.dm.mysql.config

import com.fasterxml.jackson.databind.JsonNode
import com.monkeydp.daios.dm.mysql.ext.config

/**
 * @author iPotato
 * @date 2019/10/31
 */
object MysqlMenuConfig {
    
    val structure: JsonNode
    
    init {
        val node = config()["menu"]
        structure = node[::structure.name]
    }
    
    val structOfNode = structure["node"]
}