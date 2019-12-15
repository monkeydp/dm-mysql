package com.monkeydp.daios.dm.mysql.test.api

import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dm.mysql.mocker.MysqlCpMocker
import com.monkeydp.daios.dm.mysql.test.MysqlAbstractTest
import com.monkeydp.daios.dms.sdk.api.ConnApi
import com.monkeydp.daios.dms.sdk.conn.Conn
import com.monkeydp.daios.dms.sdk.exception.handler.IgnoreException
import com.monkeydp.daios.dms.sdk.share.request.RequestContext
import com.monkeydp.tools.exception.inner.PropertyUninitializedException
import com.monkeydp.tools.ext.kotlin.notNullSingleton
import org.junit.After
import org.junit.Before
import org.kodein.di.Kodein
import org.kodein.di.generic.instance
import kotlin.properties.Delegates

/**
 * @author iPotato
 * @date 2019/12/14
 */
internal abstract class MysqlAbstractApiTest : MysqlAbstractTest() {
    
    private val cp = MysqlCpMocker.cp
    private val connApi: ConnApi by kodein.instance()
    private var conn by Delegates.notNullSingleton<Conn<*>>()
    
    @Before
    @IgnoreException(Kodein.NotFoundException::class)
    fun before() {
        RequestContext.setCp(cp)
        conn = connApi.getConn(cp)
        RequestContext.setConn(conn)
    }
    
    @After
    @IgnoreException(PropertyUninitializedException::class)
    fun after() {
        conn.close()
    }
}