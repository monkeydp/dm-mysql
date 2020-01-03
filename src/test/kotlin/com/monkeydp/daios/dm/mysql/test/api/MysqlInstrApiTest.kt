package com.monkeydp.daios.dm.mysql.test.api

import com.monkeydp.daios.dm.base.instruction.main.DeleteTable
import com.monkeydp.daios.dm.base.instruction.main.NewTable
import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dm.mysql.mocker.MysqlElementMocker.table
import com.monkeydp.daios.dm.mysql.mocker.MysqlNodePathMocker.tableNodePath
import com.monkeydp.daios.dm.mysql.mocker.MysqlNodePathMocker.tablesNodePath
import com.monkeydp.daios.dms.sdk.api.InstrApi
import com.monkeydp.daios.dms.sdk.context.ContextRepoHolder
import com.monkeydp.daios.dms.sdk.context.NodeContext
import com.monkeydp.daios.dms.sdk.context.SelectedContext
import com.monkeydp.daios.dms.sdk.instruction.InstrParsingParams
import com.monkeydp.daios.dms.sdk.instruction.main.ShowInfo
import com.monkeydp.daios.dms.sdk.instruction.target.GlobalTarget.TABLE
import com.monkeydp.daios.dms.sdk.useful.UserInput
import org.junit.jupiter.api.Test
import org.kodein.di.generic.instance

/**
 * @author iPotato
 * @date 2019/11/5
 */
internal class MysqlInstrApiTest : MysqlAbstractApiTest() {
    
    private val api: InstrApi by kodein.instance()
    
    @Test
    fun newTableTest() {
        ContextRepoHolder.contextRepo
                .copy(nodeContext = NodeContext(tablesNodePath))
                .apply(ContextRepoHolder::setContextRepo)
        InstrParsingParams(
                instr = NewTable,
                userInput = UserInput(table)
        ).apply(api::parse)
    }
    
    @Test
    fun deleteTableTest() {
        ContextRepoHolder.contextRepo
                .copy(nodeContext = NodeContext(tablesNodePath))
                .apply(ContextRepoHolder::setContextRepo)
        InstrParsingParams(
                instr = DeleteTable,
                userInput = UserInput(table)
        ).apply(api::parse)
    }
    
    @Test
    fun showInfoTest() {
        ContextRepoHolder.contextRepo
                .copy(
                        nodeContext = NodeContext(tableNodePath),
                        selectedContext = SelectedContext(TABLE)
                )
                .apply(ContextRepoHolder::setContextRepo)
        InstrParsingParams(
                instr = ShowInfo,
                userInput = UserInput(table)
        ).apply(api::parse)
    }
}