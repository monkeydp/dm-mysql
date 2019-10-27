package com.monkeydp.daios.dm.mysql.test

import com.monkeydp.daios.dm.mysql.def.MysqlDm
import com.monkeydp.daios.dms.sdk.dm.DmImplRegistrar
import org.junit.Before

/**
 * @author iPotato
 * @date 2019/10/27
 */
abstract class BaseTest {
    @Before
    fun before() {
        val dm = MysqlDm()
        DmImplRegistrar.registerAll(dm.impl, dm.datasource)
    }
}