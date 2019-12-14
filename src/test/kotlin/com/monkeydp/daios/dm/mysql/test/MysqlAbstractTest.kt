package com.monkeydp.daios.dm.mysql.test

import com.monkeydp.daios.dm.mysql.MysqlApp
import com.monkeydp.daios.dms.sdk.dm.DmConfig
import com.monkeydp.tools.config.enableDebugMode

/**
 * @author iPotato
 * @date 2019/10/27
 */
internal abstract class MysqlAbstractTest {
    companion object {
        init {
            enableDebugMode()
            MysqlApp(DmConfig.mock())
        }
    }
}