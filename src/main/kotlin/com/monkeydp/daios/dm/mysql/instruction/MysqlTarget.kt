package com.monkeydp.daios.dm.mysql.instruction

import com.monkeydp.daios.dms.sdk.annot.SdkEnum
import com.monkeydp.daios.dms.sdk.instruction.target.GlobalTarget
import com.monkeydp.daios.dms.sdk.instruction.target.Target

/**
 * @author iPotato
 * @date 2019/10/25
 */
@SdkEnum(parent = GlobalTarget::class)
enum class MysqlTarget : Target<MysqlTarget> {
    MYSQL_EXAMPLE_TARGET
}