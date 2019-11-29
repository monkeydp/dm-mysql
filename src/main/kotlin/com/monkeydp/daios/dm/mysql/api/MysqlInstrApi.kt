package com.monkeydp.daios.dm.mysql.api

import com.monkeydp.daios.dm.base.api.AbstractInstrApi
import com.monkeydp.daios.dm.mysql.MysqlConfig
import com.monkeydp.daios.dms.sdk.instruction.InstrParsingCtx
import com.monkeydp.daios.dms.sdk.main.SdkApi

/**
 * @author iPotato
 * @date 2019/11/5
 */
@SdkApi
object MysqlInstrApi : AbstractInstrApi() {
    override fun parse(ctx: InstrParsingCtx) = MysqlConfig.parserMap.getValue(ctx.instr).parse(ctx)
}