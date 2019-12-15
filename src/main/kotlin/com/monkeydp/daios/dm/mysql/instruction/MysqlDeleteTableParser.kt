package com.monkeydp.daios.dm.mysql.instruction

import com.monkeydp.daios.dm.base.instruction.parser.AbstractInstrParser
import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dm.mysql.metadata.element.MysqlTable
import com.monkeydp.daios.dm.mysql.metadata.node.MysqlNodePath
import com.monkeydp.daios.dms.sdk.annot.SdkInstrParser
import com.monkeydp.daios.dms.sdk.instruction.InstrParsingCtx
import com.monkeydp.daios.dms.sdk.share.request.RequestAttributes
import com.monkeydp.tools.ext.kotlin.convertTo
import org.kodein.di.generic.provider
import java.sql.Connection

/**
 * @author iPotato
 * @date 2019/11/5
 */
@SdkInstrParser
object MysqlDeleteTableParser : AbstractInstrParser() {
    
    val requestAttributes: () -> RequestAttributes by kodein.provider()
    
    override fun parse(ctx: InstrParsingCtx) {
        val path = ctx.nodePath.toSub<MysqlNodePath>()
        val userInput = ctx.userInput
        userInput[MysqlTable::dbName.name] = path.dbName
        val table = userInput.convertTo<MysqlTable>()
        val conn = requestAttributes().conn.rawConn as Connection
        conn.createStatement().use {
            it.executeUpdate(table.deleteTableSql)
        }
    }
}