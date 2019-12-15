package com.monkeydp.daios.dm.mysql.instruction

import com.monkeydp.daios.dm.base.instruction.parser.AbstractInstrParser
import com.monkeydp.daios.dm.mysql.metadata.element.MysqlTable
import com.monkeydp.daios.dm.mysql.metadata.node.MysqlNodePath
import com.monkeydp.daios.dms.sdk.annot.SdkInstrParser
import com.monkeydp.daios.dms.sdk.instruction.InstrParsingCtx
import com.monkeydp.daios.dms.sdk.share.request.MyRequestContext
import com.monkeydp.tools.ext.kotlin.convertTo
import java.sql.Connection

/**
 * @author iPotato
 * @date 2019/11/5
 */
@SdkInstrParser
object MysqlNewTableParser : AbstractInstrParser() {
    
    override fun parse(ctx: InstrParsingCtx) {
        val path = ctx.nodePath.toSub<MysqlNodePath>()
        val userInput = ctx.userInput
        ctx.userInput[MysqlTable::dbName.name] = path.dbName
        val table = userInput.convertTo<MysqlTable>()
        val conn = MyRequestContext.requestAttributes.conn.rawConn as Connection
        conn.createStatement().use {
            it.executeUpdate(table.newTableSql)
        }
    }
}