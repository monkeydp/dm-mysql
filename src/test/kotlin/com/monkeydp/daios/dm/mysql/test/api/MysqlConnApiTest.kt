package com.monkeydp.daios.dm.mysql.test.api

import com.monkeydp.daios.dm.mysql.mocker.MysqlCpMocker
import com.monkeydp.daios.dm.mysql.test.AbstractTest
import com.monkeydp.daios.dms.sdk.api.ConnApi
import org.junit.Assert
import org.junit.Test

/**
 * @author iPotato
 * @date 2019/10/18
 */
class MysqlConnApiTest : AbstractTest() {
    
    private val api: ConnApi = findApi()
    
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