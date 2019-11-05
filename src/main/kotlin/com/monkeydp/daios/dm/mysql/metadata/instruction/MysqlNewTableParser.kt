package com.monkeydp.daios.dm.mysql.metadata.instruction

import com.monkeydp.daios.dm.base.metadata.instruction.parser.AbstractInstrParser
import com.monkeydp.daios.dm.base.metadata.instruction.parser.InstrParserImpl
import com.monkeydp.daios.dms.sdk.metadata.instruction.ctx.InstrParseCtx

/**
 * @author iPotato
 * @date 2019/11/5
 */
@InstrParserImpl
object MysqlNewTableParser : AbstractInstrParser() {
    override fun parse(ctx: InstrParseCtx) {
    
    }
}