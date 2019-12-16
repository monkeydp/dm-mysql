package com.monkeydp.daios.dm.mysql.instruction

import com.monkeydp.daios.dms.sdk.annot.SdkEnum
import com.monkeydp.daios.dms.sdk.instruction.action.Action
import com.monkeydp.daios.dms.sdk.instruction.action.GlobalAction
import com.monkeydp.tools.enumx.EnumxOption
import com.monkeydp.tools.ext.kodein.component.AbstractKodeinBindArgs
import com.monkeydp.tools.ext.kodein.component.KodeinCompOption
import org.kodein.di.generic
import kotlin.reflect.KClass


/**
 * @author iPotato
 * @date 2019/10/25
 */
@SdkEnum
@EnumxOption(GlobalAction::class)
@KodeinCompOption(MysqlAction.KodeinBindArgs::class)
enum class MysqlAction : Action<MysqlAction> {
    
    MYSQL_EXAMPLE_ACTION;
    
    object KodeinBindArgs : AbstractKodeinBindArgs() {
        override val typeToken = generic<KClass<out Action<*>>>()
        override val overrides: Boolean? = true
    }
}