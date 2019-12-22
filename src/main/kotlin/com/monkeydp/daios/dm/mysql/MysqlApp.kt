package com.monkeydp.daios.dm.mysql

import com.monkeydp.daios.dm.base.AbstractDmApp
import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dms.sdk.SdkDmApp
import com.monkeydp.daios.dms.sdk.datasource.Datasource.MYSQL


/**
 * @author iPotato
 * @date 2019/12/4
 */
@SdkDmApp(MYSQL)
object MysqlApp : AbstractDmApp(kodein)