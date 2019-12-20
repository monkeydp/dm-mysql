package com.monkeydp.daios.dm.mysql.instruction

import com.monkeydp.daios.dms.sdk.instruction.target.GlobalTarget
import com.monkeydp.daios.dms.sdk.instruction.target.SdkTarget
import com.monkeydp.daios.dms.sdk.instruction.target.Target
import com.monkeydp.tools.enumx.EnumxOption

/**
 * @author iPotato
 * @date 2019/10/25
 */
@SdkTarget
@EnumxOption(GlobalTarget::class)
enum class MysqlTarget : Target<MysqlTarget> {
    MYSQL_EXAMPLE_TARGET;
}