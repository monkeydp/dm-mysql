package com.monkeydp.daios.dm.mysql.config

import com.monkeydp.daios.dms.sdk.share.kodein.kodeinModules
import com.monkeydp.tools.ext.kodein.KodeinHelper.bindComps
import org.kodein.di.Kodein

/**
 * @author iPotato
 * @date 2019/12/4
 */
internal val kodein =
        Kodein(true) {
            importAll(*kodeinModules)
            bindComps(MysqlKodeinRepo.comps)
        }