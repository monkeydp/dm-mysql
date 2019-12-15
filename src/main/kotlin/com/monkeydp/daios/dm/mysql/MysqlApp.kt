package com.monkeydp.daios.dm.mysql

import com.monkeydp.daios.dm.base.AbstractDmApp
import com.monkeydp.daios.dm.mysql.config.MysqlKodeinComponentConfig
import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dms.sdk.annot.SdkDmApp
import com.monkeydp.daios.dms.sdk.datasource.Datasource.MYSQL
import com.monkeydp.daios.dms.sdk.share.kodein.kodeinModules
import com.monkeydp.tools.ext.kodein.KodeinHelper
import org.kodein.di.Kodein


/**
 * @author iPotato
 * @date 2019/12/4
 */
@SdkDmApp(MYSQL)
object MysqlApp : AbstractDmApp() {
    override fun initDmKodein(): Kodein {
        kodein.baseKodein = KodeinHelper.initKodein(MysqlKodeinComponentConfig, *kodeinModules)
        return kodein
    }
}