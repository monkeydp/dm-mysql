package com.monkeydp.daios.dm.mysql.test.api

import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dm.mysql.mocker.MysqlCpMocker
import com.monkeydp.daios.dm.mysql.test.MysqlAbstractTest
import com.monkeydp.daios.dms.sdk.api.ConnApi
import com.monkeydp.daios.dms.sdk.exception.handler.IgnoreException
import com.monkeydp.daios.dms.sdk.share.conn.ConnContext
import com.monkeydp.daios.dms.sdk.share.request.RequestContext
import com.monkeydp.tools.exception.inner.PropertyUninitializedException
import org.junit.After
import org.junit.Before
import org.kodein.di.Kodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

/**
 * @author iPotato
 * @date 2019/12/14
 */
internal abstract class MysqlAbstractApiTest : MysqlAbstractTest() {
    
    private val ctx: RequestContext by kodein.instance()
    private val connApi: ConnApi by kodein.instance()
    private val connContext: () -> ConnContext by kodein.provider()
    
    @Before
    @IgnoreException(Kodein.NotFoundException::class)
    fun before() {
        ctx.setRequestAttributes(
                ConnContext {
                    cp = MysqlCpMocker.cp
                    conn = connApi.getConn(cp)
                }
        )
    }
    
    @After
    @IgnoreException(PropertyUninitializedException::class)
    fun after() {
        connContext().conn.close()
    }
}