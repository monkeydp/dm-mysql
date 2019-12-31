package com.monkeydp.daios.dm.mysql.test.api

//import com.monkeydp.daios.dm.mysql.mocker.MysqlNodePathMocker.tablesNodePath
import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dms.sdk.api.InstrApi
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
//        val ctx = InstrParsingCtx(
//                instr = NewTable,
//                userInput = UserInput(table),
//                nodePath = tablesNodePath
//        )
//        api.parse(ctx)
    }

    @Test
    fun deleteTableTest() {
//        val ctx = InstrParsingCtx(
//                instr = DeleteTable,
//                userInput = UserInput(table),
//                nodePath = tablesNodePath
//        )
//        api.parse(ctx)
    }

    @Test
    fun showInfoTest() {
//        val ctx = InstrParsingCtx(
//                instr = ShowInfo,
//                userInput = UserInput(table),
//                nodePath = tablesNodePath,
//                selected = TABLE
//        )
//        api.parse(ctx)
    }
}