package com.monkeydp.daios.dm.mysql.test.api

import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dm.mysql.mocker.MysqlCpMocker
import com.monkeydp.daios.dms.sdk.api.ConnApi
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
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
        assertTrue(conn.isValid())
        assertFalse(conn.isClosed())
        
        conn.close()
        assertFalse(conn.isValid())
        assertTrue(conn.isClosed())
    }
}