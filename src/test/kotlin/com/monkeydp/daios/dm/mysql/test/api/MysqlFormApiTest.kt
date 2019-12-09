package com.monkeydp.daios.dm.mysql.test.api

import com.monkeydp.daios.dm.base.instruction.NewConn
import com.monkeydp.daios.dm.mysql.test.AbstractTest
import com.monkeydp.daios.dms.sdk.api.FormApi
import com.monkeydp.daios.dms.sdk.metadata.form.FormLoadingCtx
import org.junit.Assert
import org.junit.Test

/**
 * @author iPotato
 * @date 2019/10/18
 */
internal class MysqlFormApiTest : AbstractTest() {
    
    private val api: FormApi = findApi()
    
    @Test
    fun loadNewConnForm() {
        val ctx = FormLoadingCtx(instr = NewConn)
        val form = api.loadFrom(ctx)
        Assert.assertTrue(form.items.isNotEmpty())
    }
}