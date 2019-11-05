package com.monkeydp.daios.dm.mysql.api

import com.monkeydp.daios.dm.base.api.AbstractInstrApi
import com.monkeydp.daios.dm.mysql.MysqlDm
import com.monkeydp.daios.dms.sdk.metadata.instruction.ctx.InstrParseCtx

/**
 * @author iPotato
 * @date 2019/11/5
 */
object MysqlInstrApi : AbstractInstrApi() {
    
    val dm = MysqlDm.INSTANCE
    
    override fun parse(ctx: InstrParseCtx) {
    
    }
}