package com.monkeydp.daios.dm.mysql.test

import com.monkeydp.daios.dm.mysql.MysqlDm
import com.monkeydp.daios.dm.mysql.api.MysqlConnApi
import com.monkeydp.daios.dm.mysql.conn.MysqlConn
import com.monkeydp.daios.dm.mysql.mocker.MysqlCpMocker
import com.monkeydp.daios.dms.sdk.dm.DmOpenConfig
import com.monkeydp.tools.ext.notNullSingleton
import org.junit.After
import org.junit.Before
import kotlin.properties.Delegates

/**
 * @author iPotato
 * @date 2019/10/27
 */
abstract class AbstractTest {
    
    companion object {
        init {
            MysqlDm(DmOpenConfig.mock())
        }
    }
    
    private val dm = MysqlDm.INSTANCE
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