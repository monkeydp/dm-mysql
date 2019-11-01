package com.monkeydp.daios.dm.mysql.ext

import com.monkeydp.tools.ext.toStdPath

/**
 * @author iPotato
 * @date 2019/10/30
 */
val rootDirpath = System.getProperty("user.dir").toStdPath()
val sourceDirpath = "$rootDirpath/src"
val mainDirpath = "$sourceDirpath/main"
var distDirpath = "$mainDirpath/dist"