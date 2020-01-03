package com.monkeydp.daios.dm.mysql.instruction

import com.monkeydp.daios.dm.base.event.ShowInfoEvent
import com.monkeydp.daios.dm.base.instruction.parser.AbstractInstrParser
import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dms.sdk.context.SelectedContext
import com.monkeydp.daios.dms.sdk.event.EventPublisher
import com.monkeydp.daios.dms.sdk.instruction.InstrParsingParams
import com.monkeydp.daios.dms.sdk.instruction.SdkInstrParser
import com.monkeydp.daios.dms.sdk.instruction.target.GlobalTarget.TABLE
import com.monkeydp.daios.dms.sdk.instruction.target.info.TargetInfo
import com.monkeydp.tools.ext.kodein.providerX
import com.monkeydp.tools.ext.main.ierror
import org.kodein.di.generic.instance

/**
 * @author iPotato
 * @date 2019/11/5
 */
@SdkInstrParser
object MysqlShowInfoParser : AbstractInstrParser() {
    
    private val eventPublisher: EventPublisher by kodein.instance()
    private val selectedContext: SelectedContext get() = kodein.providerX()
    
    override fun parse(params: InstrParsingParams) {
        when (val target = selectedContext.target) {
            TABLE -> loadTableInfo(params)
            else -> ierror("No information of selected target: $target!")
        }.also { eventPublisher.publish(ShowInfoEvent(this, it)) }
    }
    
    /**
     * TODO
     */
    private fun loadTableInfo(params: InstrParsingParams) = TargetInfo("[MySQL table info, $params]")
}