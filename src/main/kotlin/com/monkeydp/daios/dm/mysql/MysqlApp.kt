package com.monkeydp.daios.dm.mysql

import com.monkeydp.daios.dm.base.AbstractDmApp
import com.monkeydp.daios.dm.mysql.config.MysqlKodeinComponentConfig
import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dms.sdk.dm.DmConfig
import com.monkeydp.tools.ext.kodein.KodeinHelper
import org.kodein.di.Kodein


/**
 * @author iPotato
 * @date 2019/12/4
 */
class MysqlApp(config: DmConfig) : AbstractDmApp(config) {
    override fun initDmKodein(vararg modules: Kodein.Module): Kodein {
        kodein.baseKodein = KodeinHelper.initKodein(MysqlKodeinComponentConfig, *modules)
        return kodein
    }
}