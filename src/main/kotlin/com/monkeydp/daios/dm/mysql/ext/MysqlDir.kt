package com.monkeydp.daios.dm.mysql.ext

import com.monkeydp.tools.ext.toStdPath

/**
 * @author iPotato
 * @date 2019/10/30
 */
val rootDir = System.getProperty("user.dir").toStdPath()
val sourceDir = "$rootDir/src"
val mainDir = "$sourceDir/main"
val kotlinDir = "$mainDir/kotlin"
val packageDir = "$kotlinDir/com/monkeydp/daios/dm/mysql"