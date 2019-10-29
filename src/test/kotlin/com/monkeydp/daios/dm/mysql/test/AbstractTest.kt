package com.monkeydp.daios.dm.mysql.test

import com.monkeydp.daios.dm.mysql.MysqlDm
import com.monkeydp.daios.dm.mysql.conn.MysqlConn
import com.monkeydp.daios.dm.mysql.conn.MysqlConnApi
import com.monkeydp.daios.dm.mysql.conn.MysqlCpMocker
import com.monkeydp.daios.dms.sdk.dm.DmImplRegistrar
import com.monkeydp.tools.function.notNullSingleInit
import org.junit.After
import org.junit.Before
import kotlin.properties.Delegates

/**
 * @author iPotato
 * @date 2019/10/27
 */
abstract class AbstractTest {
    
    protected var conn by Delegates.notNullSingleInit<MysqlConn>()
    
    @Before
    fun before() {
        DmImplRegistrar.registerAll(MysqlDm.impl, MysqlDm.datasource)
        conn = MysqlConnApi.getConn(MysqlCpMocker.cp)
    }
    
    @After
    fun after() {
        conn.close()
    }
}