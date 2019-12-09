package com.monkeydp.daios.dm.mysql.test

import com.monkeydp.daios.dm.mysql.MysqlApp
import com.monkeydp.daios.dm.mysql.MysqlVersion
import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dm.mysql.mocker.MysqlCpMocker
import com.monkeydp.daios.dms.sdk.api.ConnApi
import com.monkeydp.daios.dms.sdk.conn.Conn
import com.monkeydp.daios.dms.sdk.dm.DmConfig
import com.monkeydp.daios.dms.sdk.dm.DmTestdataRegistry
import com.monkeydp.daios.dms.sdk.exception.handler.IgnoreException
import com.monkeydp.daios.dms.sdk.request.RequestContext
import com.monkeydp.tools.exception.inner.PropertyUninitializedException
import com.monkeydp.tools.config.enableDebugMode
import com.monkeydp.tools.ext.notNullSingleton
import org.junit.After
import org.junit.Before
import org.kodein.di.Kodein
import org.kodein.di.generic.instance
import kotlin.properties.Delegates

/**
 * @author iPotato
 * @date 2019/10/27
 */
internal abstract class AbstractTest {
    
    companion object {
        init {
            enableDebugMode()
            DmTestdataRegistry.testDsVersion = MysqlVersion.MYSQL_5_7
            MysqlApp(DmConfig.mock())
        }
    }
    
    private val connApi: ConnApi by kodein.instance()
    private var conn by Delegates.notNullSingleton<Conn<*>>()
    
    @Before
    @IgnoreException(Kodein.NotFoundException::class)
    fun before() {
        conn = connApi.getConn(MysqlCpMocker.cp)
        RequestContext.init(conn = conn)
    }
    
    @After
    @IgnoreException(PropertyUninitializedException::class)
    fun after() {
        conn.close()
    }
    
    protected inline fun <reified A : Any> findApi(): A {
        val api by kodein.instance<A>()
        return api
    }
}