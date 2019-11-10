package com.monkeydp.daios.dm.mysql.api

import com.monkeydp.daios.dm.base.api.AbstractInstrApi
import com.monkeydp.daios.dm.mysql.MysqlDm
import com.monkeydp.daios.dms.sdk.main.SdkApi
import com.monkeydp.daios.dms.sdk.instruction.InstrParsingCtx

/**
 * @author iPotato
 * @date 2019/11/5
 */
@SdkApi
object MysqlInstrApi : AbstractInstrApi() {
    
    private val parserMap by lazy { MysqlDm.INSTANCE.config.instrConfig.parserMap }
    
    override fun parse(ctx: InstrParsingCtx) = parserMap.getValue(ctx.instr).parse(ctx)
}