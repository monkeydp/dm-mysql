package com.monkeydp.daios.dm.mysql

import com.monkeydp.daios.dm.base.AbstractDmApp
import com.monkeydp.daios.dm.mysql.config.initKodein
import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dms.sdk.dm.DmConfig
import org.kodein.di.Kodein


/**
 * @author iPotato
 * @date 2019/12/4
 */
class MysqlApp(config: DmConfig) : AbstractDmApp(config) {
    override fun initDmKodein(vararg modules: Kodein.Module): Kodein {
        kodein.baseKodein = initKodein(*modules)
        return kodein
    }
}