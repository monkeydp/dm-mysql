package com.monkeydp.daios.dm.mysql.instruction

import com.monkeydp.daios.dms.sdk.enumx.SdkEnum
import com.monkeydp.daios.dms.sdk.instruction.action.Action


/**
 * @author iPotato
 * @date 2019/10/25
 */
@SdkEnum(parent = MysqlAction::class)
enum class MysqlAction : Action<MysqlAction> {
    MYSQL_EXAMPLE_ACTION
}