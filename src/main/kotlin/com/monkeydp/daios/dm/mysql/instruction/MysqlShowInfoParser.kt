package com.monkeydp.daios.dm.mysql.instruction

import com.monkeydp.daios.dm.base.event.ShowInfoEvent
import com.monkeydp.daios.dm.base.instruction.parser.AbstractInstrParser
import com.monkeydp.daios.dm.base.metadata.info.StdInfo
import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dms.sdk.annot.SdkInstrParser
import com.monkeydp.daios.dms.sdk.event.EventPublisher
import com.monkeydp.daios.dms.sdk.instruction.InstrParsingCtx
import com.monkeydp.daios.dms.sdk.instruction.target.GlobalTarget.TABLE
import com.monkeydp.daios.dms.sdk.metadata.info.Info
import com.monkeydp.tools.ext.main.ierror
import org.kodein.di.generic.instance

/**
 * @author iPotato
 * @date 2019/11/5
 */
@SdkInstrParser
object MysqlShowInfoParser : AbstractInstrParser() {
    
    private val eventPublisher: EventPublisher by kodein.instance()
    
    override fun parse(ctx: InstrParsingCtx) {
        val info: Info
        when (val selected = ctx.selected) {
            TABLE -> info = loadTableInfo(ctx)
            else -> ierror("No information of $selected!")
        }
        eventPublisher.publish(ShowInfoEvent(this, info))
    }
    
    /**
     * TODO
     */
    private fun loadTableInfo(ctx: InstrParsingCtx) = StdInfo("[MySQL table info, $ctx]")
}