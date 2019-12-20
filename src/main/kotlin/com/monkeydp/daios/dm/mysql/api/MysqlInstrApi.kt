package com.monkeydp.daios.dm.mysql.api

import com.monkeydp.daios.dm.base.api.AbstractInstrApi
import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dms.sdk.api.annot.SdkInstrApi
import com.monkeydp.daios.dms.sdk.instruction.InstrParser
import com.monkeydp.daios.dms.sdk.instruction.InstrParsingCtx
import org.kodein.di.generic.instance

/**
 * @author iPotato
 * @date 2019/11/5
 */
@SdkInstrApi
object MysqlInstrApi : AbstractInstrApi() {
    override fun parse(ctx: InstrParsingCtx) {
        val parser: InstrParser by kodein.instance(ctx.instr)
        return parser.parse(ctx)
    }
}