package com.monkeydp.daios.dm.mysql.instruction

import com.monkeydp.daios.dms.sdk.annot.SdkEnum
import com.monkeydp.daios.dms.sdk.instruction.action.Action
import com.monkeydp.daios.dms.sdk.instruction.action.GlobalAction
import com.monkeydp.tools.enumx.EnumxOption


/**
 * @author iPotato
 * @date 2019/10/25
 */
@SdkEnum
@EnumxOption(GlobalAction::class)
enum class MysqlAction : Action<MysqlAction> {
    MYSQL_EXAMPLE_ACTION
}