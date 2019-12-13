package com.monkeydp.daios.dm.mysql.api

import com.monkeydp.daios.dm.base.api.AbstractInstrApi
import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dms.sdk.annot.SdkApi
import com.monkeydp.daios.dms.sdk.annot.SdkInstrParser
import com.monkeydp.daios.dms.sdk.instruction.InstrParser
import com.monkeydp.daios.dms.sdk.instruction.InstrParsingCtx
import com.monkeydp.daios.dms.sdk.instruction.Instruction
import org.kodein.di.generic.instance

/**
 * @author iPotato
 * @date 2019/11/5
 */
@SdkApi
object MysqlInstrApi : AbstractInstrApi() {
    private val parserMap: Map<Instruction, InstrParser> by kodein.instance(SdkInstrParser::class)
    override fun parse(ctx: InstrParsingCtx) = parserMap.getValue(ctx.instr).parse(ctx)
}