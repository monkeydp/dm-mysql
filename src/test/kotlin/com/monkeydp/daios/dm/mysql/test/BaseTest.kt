package com.monkeydp.daios.dm.mysql.test

import com.monkeydp.daios.dm.mysql.connection.MysqlCpFrom
import com.monkeydp.daios.dms.sdk.datasource.Datasource.MYSQL
import com.monkeydp.daios.dms.sdk.dm.ImplContext
import org.junit.Before

/**
 * @author iPotato
 * @date 2019/10/27
 */
abstract class BaseTest {
    @Before
    fun before() {
        // TODO
        ImplContext.registerDataClass(MysqlCpFrom::class.java, MYSQL)
    }
}