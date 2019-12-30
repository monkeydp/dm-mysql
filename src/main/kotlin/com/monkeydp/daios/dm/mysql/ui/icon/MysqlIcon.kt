package com.monkeydp.daios.dm.mysql.ui.icon

import com.monkeydp.daios.dms.sdk.ui.icon.GlobalIcon
import com.monkeydp.daios.dms.sdk.ui.icon.Icon
import com.monkeydp.daios.dms.sdk.ui.icon.SdkIcon
import com.monkeydp.tools.enumx.EnumxOption

/**
 * @author iPotato
 * @date 2019/10/28
 */
@SdkIcon
@EnumxOption(GlobalIcon::class)
enum class MysqlIcon(
        override val namex: String,
        override val color: String
) : Icon<MysqlIcon> {
    MYSQL_CONN_ICON("mysql conn icon", "")
}