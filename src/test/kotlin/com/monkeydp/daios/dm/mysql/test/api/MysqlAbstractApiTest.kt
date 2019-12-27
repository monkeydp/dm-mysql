package com.monkeydp.daios.dm.mysql.test.api

import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dm.mysql.mocker.MysqlCpMocker.cp
import com.monkeydp.daios.dm.mysql.test.MysqlAbstractTest
import com.monkeydp.daios.dms.sdk.api.ConnApi
import com.monkeydp.daios.dms.sdk.exception.handler.IgnoreException
import com.monkeydp.daios.dms.sdk.share.conn.ConnContext
import com.monkeydp.daios.dms.sdk.share.request.RequestContextHolder
import com.monkeydp.tools.ext.kotlin.PropertyUninitializedException
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.kodein.di.Kodein
import org.kodein.di.generic.instance

/**
 * @author iPotato
 * @date 2019/12/14
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal abstract class MysqlAbstractApiTest : MysqlAbstractTest() {
    
    private val connApi: ConnApi by kodein.instance()
    private val connContext: ConnContext by kodein.instance()
    
    @BeforeAll
    @IgnoreException(Kodein.NotFoundException::class)
    fun beforeAll() {
        RequestContextHolder.setRequestAttributes(
                ConnContext(cp) {
                    conn = connApi.getConn(cp)
                }
        )
    }
    
    @AfterAll
    @IgnoreException(PropertyUninitializedException::class)
    fun afterAll() {
        connContext.conn.close()
    }
}