package com.monkeydp.daios.dm.mysql.test.api

import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dm.mysql.mocker.MysqlCpMocker
import com.monkeydp.daios.dm.mysql.test.MysqlAbstractTest
import com.monkeydp.daios.dms.sdk.api.ConnApi
import org.junit.Assert
import org.junit.Test
import org.kodein.di.generic.instance

/**
 * @author iPotato
 * @date 2019/10/18
 */
internal class MysqlConnApiTest : MysqlAbstractApiTest() {
    
    private val api: ConnApi by kodein.instance()
    
    @Test
    fun connTest() {
        val conn = api.getConn(MysqlCpMocker.cp)
        Assert.assertTrue(conn.isValid())
        Assert.assertFalse(conn.isClosed())
        
        conn.close()
        Assert.assertFalse(conn.isValid())
        Assert.assertTrue(conn.isClosed())
    }
}