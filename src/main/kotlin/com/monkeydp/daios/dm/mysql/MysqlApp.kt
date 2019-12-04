package com.monkeydp.daios.dm.mysql

import com.monkeydp.daios.dm.base.AbstractDmApp
import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dms.sdk.dm.DmConfig
import com.monkeydp.daios.dms.sdk.main.SdkDmApp
import org.kodein.di.Kodein
import com.monkeydp.daios.dm.mysql.config.initKodein as initKodeinExt


/**
 * @author iPotato
 * @date 2019/12/4
 */
@SdkDmApp
class MysqlApp(config: DmConfig) : AbstractDmApp(config) {
    override fun initKodein(vararg modules: Kodein.Module): Kodein {
        initKodeinExt(*modules)
        return kodein
    }
}