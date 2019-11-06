package com.monkeydp.daios.dm.mysql.instruction

import com.monkeydp.daios.dm.base.instruction.parser.AbstractInstrParser
import com.monkeydp.daios.dm.base.instruction.parser.InstrParserImpl
import com.monkeydp.daios.dm.mysql.metadata.element.MysqlTable
import com.monkeydp.daios.dm.mysql.metadata.node.MysqlNodePath
import com.monkeydp.daios.dms.sdk.instruction.ctx.NodeInstrParseCtx
import java.sql.Connection

/**
 * @author iPotato
 * @date 2019/11/5
 */
@InstrParserImpl
object MysqlDeleteTableParser : AbstractInstrParser<NodeInstrParseCtx>() {
    
    override fun parse(ctx: NodeInstrParseCtx) {
        val path = ctx.nodePath.toSub<MysqlNodePath>()
        val userInput = ctx.userInput
        userInput[MysqlTable::dbName.name] = path.dbName
        val table = userInput.convertTo<MysqlTable>()
        val conn = ctx.conn.rawConn as Connection
        conn.createStatement().use {
            it.executeUpdate(table.deleteTableSql)
        }
    }
}