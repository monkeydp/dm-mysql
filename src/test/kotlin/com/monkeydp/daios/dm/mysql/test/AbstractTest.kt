package com.monkeydp.daios.dm.mysql.test

import com.monkeydp.daios.dm.mysql.MysqlDm
import com.monkeydp.daios.dms.sdk.dm.DmImplRegistrar
import org.junit.Before

/**
 * @author iPotato
 * @date 2019/10/27
 */
abstract class AbstractTest {
    @Before
    fun before() {
        DmImplRegistrar.registerAll(MysqlDm.impl, MysqlDm.datasource)
    }
}