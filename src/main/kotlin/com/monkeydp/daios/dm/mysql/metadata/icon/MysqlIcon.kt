package com.monkeydp.daios.dm.mysql.metadata.icon

import com.monkeydp.daios.dms.sdk.annot.SdkEnum
import com.monkeydp.daios.dms.sdk.metadata.icon.GlobalIcon
import com.monkeydp.daios.dms.sdk.metadata.icon.Icon
import com.monkeydp.tools.enumx.EnumxOption

/**
 * @author iPotato
 * @date 2019/10/28
 */
@SdkEnum
@EnumxOption(GlobalIcon::class)
enum class MysqlIcon(
        override val namex: String,
        override val color: String
) : Icon<MysqlIcon> {
    MYSQL_CONN_ICON("mysql conn icon", "")
}