package com.monkeydp.daios.dm.mysql.test.api

import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dms.sdk.api.FormApi
import com.monkeydp.daios.dms.sdk.instruction.main.NewConn
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.kodein.di.generic.instance

/**
 * @author iPotato
 * @date 2019/10/18
 */
internal class MysqlFormApiTest : MysqlAbstractApiTest() {
    
    private val api: FormApi by kodein.instance()
    
    @Test
    fun loadNewConnForm() {
        val form = api.loadFrom(NewConn)
        assertTrue(form.items.isNotEmpty())
    }
}