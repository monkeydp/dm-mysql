package com.monkeydp.daios.dm.mysql.ext

import com.fasterxml.jackson.databind.JsonNode
import com.monkeydp.tools.util.JsonUtil
import com.monkeydp.tools.util.YamlUtil

/**
 * @author iPotato
 * @date 2019/10/30
 */
fun config(): JsonNode {
    val text = Thread.currentThread().javaClass.getResource("/config.yml").readText()
    return JsonUtil.convertTo(YamlUtil.load(text))
}