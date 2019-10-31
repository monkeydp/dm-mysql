package com.monkeydp.daios.dm.mysql.test

import com.monkeydp.daios.dm.mysql.MysqlDm
import com.monkeydp.daios.dm.mysql.conn.MysqlConn
import com.monkeydp.daios.dm.mysql.conn.MysqlConnApi
import com.monkeydp.daios.dm.mysql.conn.MysqlCpMocker
import com.monkeydp.tools.ext.notNullSingleton
import org.junit.After
import org.junit.Before
import kotlin.properties.Delegates

/**
 * @author iPotato
 * @date 2019/10/27
 */
abstract class AbstractTest {
    
    private val dm = MysqlDm()
    protected val apis = dm.impl.apis
    protected var conn by Delegates.notNullSingleton<MysqlConn>()
    
    @Before
    fun before() {
        conn = MysqlConnApi.getConn(MysqlCpMocker.cp)
    }
    
    @After
    fun after() {
        conn.close()
    }
}