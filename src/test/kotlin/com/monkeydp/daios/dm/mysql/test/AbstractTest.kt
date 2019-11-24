package com.monkeydp.daios.dm.mysql.test

import com.monkeydp.daios.dm.mysql.MysqlDm
import com.monkeydp.daios.dm.mysql.mocker.MysqlCpMocker
import com.monkeydp.daios.dms.sdk.conn.Conn
import com.monkeydp.daios.dms.sdk.dm.DmOpenConfig
import com.monkeydp.daios.dms.sdk.request.RequestContext
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
    protected var conn by Delegates.notNullSingleton<Conn<*>>()
    
    @Before
    fun before() {
        val connApi = apis.connApi
        conn = connApi.getConn(MysqlCpMocker.cp)
        RequestContext.init(conn = conn)
    }
    
    @After
    fun after() {
        conn.close()
    }
}