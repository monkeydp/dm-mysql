package com.monkeydp.daios.dm.mysql.metadata.menu

import com.monkeydp.daios.dms.sdk.metadata.menu.AbstractMdStruct
import com.monkeydp.daios.dms.sdk.metadata.menu.SdkMdStruct
import com.monkeydp.tools.ext.kotlin.toPropValuesX

/**
 * @author iPotato
 * @date 2019/12/23
 */
@SdkMdStruct
internal object MysqlMdStruct : AbstractMdStruct(
        MysqlMenuDefs.toPropValuesX()
)