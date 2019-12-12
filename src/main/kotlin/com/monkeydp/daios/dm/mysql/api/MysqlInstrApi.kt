package com.monkeydp.daios.dm.mysql.api

import com.monkeydp.daios.dm.base.LocalConfig
import com.monkeydp.daios.dm.base.api.AbstractInstrApi
import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dms.sdk.annot.SdkApi
import com.monkeydp.daios.dms.sdk.instruction.InstrParsingCtx
import org.kodein.di.generic.instance

/**
 * @author iPotato
 * @date 2019/11/5
 */
@SdkApi
object MysqlInstrApi : AbstractInstrApi() {
    private val config: LocalConfig by kodein.instance()
    override fun parse(ctx: InstrParsingCtx) = config.parserMap.getValue(ctx.instr).parse(ctx)
}