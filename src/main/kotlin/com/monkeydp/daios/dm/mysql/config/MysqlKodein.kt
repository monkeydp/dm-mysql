package com.monkeydp.daios.dm.mysql.config

import com.monkeydp.daios.dm.base.config.DmKodeinCompRepo
import com.monkeydp.daios.dms.sdk.share.kodein.DmKodein
import com.monkeydp.daios.dms.sdk.share.kodein.kodeinModules
import com.monkeydp.tools.ext.kodein.KodeinHelper.bindComps

/**
 * @author iPotato
 * @date 2019/12/4
 */
internal val kodein =
        DmKodein(true) {
            importAll(*kodeinModules)
            bindComps(MysqlKodeinCompRepo.comps)
        }

private object MysqlKodeinCompRepo : DmKodeinCompRepo()