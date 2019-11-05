package com.monkeydp.daios.dm.mysql.test.api

import com.monkeydp.daios.dm.base.metadata.instruction.DeleteTable
import com.monkeydp.daios.dm.base.metadata.instruction.NewTable
import com.monkeydp.daios.dm.mysql.mocker.MysqlElementMocker.table
import com.monkeydp.daios.dm.mysql.mocker.MysqlNodeMocker.tablesNodePath
import com.monkeydp.daios.dm.mysql.test.AbstractTest
import com.monkeydp.daios.dms.sdk.metadata.instruction.ctx.NodeInstrParseCtx
import com.monkeydp.daios.dms.sdk.useful.UserInput
import org.junit.Test

/**
 * @author iPotato
 * @date 2019/11/5
 */
class MysqlInstrApiTest : AbstractTest() {
    
    private val api = apis.instrApi
    
    @Test
    fun parseTest() {
        newTableTest()
        deleteTableTest()
    }
    
    private fun newTableTest() {
        val ctx = NodeInstrParseCtx(
                instr = NewTable,
                userInput = UserInput(table),
                conn = conn,
                nodePath = tablesNodePath
        )
        api.parse(ctx)
    }
    
    private fun deleteTableTest() {
        val ctx = NodeInstrParseCtx(
                instr = DeleteTable,
                userInput = UserInput(table),
                conn = conn,
                nodePath = tablesNodePath
        )
        api.parse(ctx)
    }
}