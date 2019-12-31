package com.monkeydp.daios.dm.mysql.instruction

import com.monkeydp.daios.dm.base.instruction.parser.AbstractInstrParser
import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dm.mysql.ui.element.MysqlTable
import com.monkeydp.daios.dm.mysql.ui.node.MysqlNodePath
import com.monkeydp.daios.dms.sdk.context.ConnContext
import com.monkeydp.daios.dms.sdk.instruction.InstrParsingCtx
import com.monkeydp.daios.dms.sdk.instruction.SdkInstrParser
import com.monkeydp.tools.ext.kodein.findImpl
import com.monkeydp.tools.ext.kotlin.convertTo
import java.sql.Connection

/**
 * @author iPotato
 * @date 2019/11/5
 */
@SdkInstrParser
object MysqlNewTableParser : AbstractInstrParser() {
    
    private val connContext: ConnContext get() = kodein.findImpl()
    
    override fun parse(ctx: InstrParsingCtx) {
        val path = ctx.nodePath.toSub<MysqlNodePath>()
        val userInput = ctx.userInput
        ctx.userInput[MysqlTable::dbName.name] = path.dbName
        val table = userInput.convertTo<MysqlTable>()
        val conn = connContext.conn.rawConn as Connection
        conn.createStatement().use {
            it.executeUpdate(table.newTableSql)
        }
    }
}