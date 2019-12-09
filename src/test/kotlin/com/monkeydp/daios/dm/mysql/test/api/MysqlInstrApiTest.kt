package com.monkeydp.daios.dm.mysql.test.api

import com.monkeydp.daios.dm.base.instruction.DeleteTable
import com.monkeydp.daios.dm.base.instruction.NewTable
import com.monkeydp.daios.dm.base.instruction.ShowInfo
import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dm.mysql.mocker.MysqlElementMocker.table
import com.monkeydp.daios.dm.mysql.mocker.MysqlNodeMocker.tablesNodePath
import com.monkeydp.daios.dm.mysql.test.AbstractTest
import com.monkeydp.daios.dms.sdk.api.InstrApi
import com.monkeydp.daios.dms.sdk.instruction.InstrParsingCtx
import com.monkeydp.daios.dms.sdk.instruction.target.GlobalTarget.TABLE
import com.monkeydp.daios.dms.sdk.useful.UserInput
import org.junit.Test
import org.kodein.di.generic.instance

/**
 * @author iPotato
 * @date 2019/11/5
 */
internal class MysqlInstrApiTest : AbstractTest() {
    
    private val api: InstrApi by kodein.instance()
    
    @Test
    fun newTableTest() {
        val ctx = InstrParsingCtx(
                instr = NewTable,
                userInput = UserInput(table),
                nodePath = tablesNodePath
        )
        api.parse(ctx)
    }
    
    @Test
    fun deleteTableTest() {
        val ctx = InstrParsingCtx(
                instr = DeleteTable,
                userInput = UserInput(table),
                nodePath = tablesNodePath
        )
        api.parse(ctx)
    }
    
    @Test
    fun showInfoTest() {
        val ctx = InstrParsingCtx(
                instr = ShowInfo,
                userInput = UserInput(table),
                nodePath = tablesNodePath,
                selected = TABLE
        )
        api.parse(ctx)
    }
}