package com.monkeydp.daios.dm.mysql.test.api

import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dm.mysql.mocker.MysqlCpMocker.cp
import com.monkeydp.daios.dm.mysql.test.MysqlAbstractTest
import com.monkeydp.daios.dms.sdk.api.ConnApi
import com.monkeydp.daios.dms.sdk.context.ConnContext
import com.monkeydp.daios.dms.sdk.context.ContextRepoHolder
import com.monkeydp.daios.dms.sdk.exception.handler.IgnoreException
import com.monkeydp.tools.ext.kodein.findImpl
import com.monkeydp.tools.ext.kotlin.PropertyUninitializedException
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import org.kodein.di.Kodein
import org.kodein.di.generic.instance

/**
 * @author iPotato
 * @date 2019/12/14
 */
@Execution(ExecutionMode.CONCURRENT)
internal abstract class MysqlAbstractApiTest : MysqlAbstractTest() {
    
    private val connApi: ConnApi by kodein.instance()
    private val connContext: ConnContext get() = kodein.findImpl()
    
    @BeforeEach
    @IgnoreException(Kodein.NotFoundException::class)
    fun beforeEach() {
        ContextRepoHolder.setContextRepo {
            connContext = ConnContext(cp) {
                conn = connApi.getConn(cp)
            }
        }
    }
    
    @AfterEach
    @IgnoreException(PropertyUninitializedException::class)
    fun afterEach() {
        connContext.conn.close()
        ContextRepoHolder.resetContextRepo()
    }
}