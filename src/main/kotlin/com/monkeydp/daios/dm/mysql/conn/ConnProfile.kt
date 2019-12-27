package com.monkeydp.daios.dm.mysql.conn

import com.monkeydp.daios.dm.mysql.MysqlDef
import com.monkeydp.daios.dm.mysql.MysqlDefRepo
import com.monkeydp.daios.dms.sdk.conn.ConnProfile
import com.monkeydp.tools.ext.kotlin.convertTo

/**
 * @author iPotato
 * @date 2019/12/27
 */
val ConnProfile.dsDef: MysqlDef get() = MysqlDefRepo.find { it.version == dsVersion }