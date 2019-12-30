package com.monkeydp.daios.dm.mysql.config

import com.monkeydp.daios.dm.base.config.DmKodeinCompRepo
import com.monkeydp.daios.dms.sdk.dm.DmKodein

/**
 * @author iPotato
 * @date 2019/12/4
 */
internal val kodein = DmKodein(object : DmKodeinCompRepo() {})