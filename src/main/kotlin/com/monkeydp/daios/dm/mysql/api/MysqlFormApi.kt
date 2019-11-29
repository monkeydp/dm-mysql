package com.monkeydp.daios.dm.mysql.api

import com.monkeydp.daios.dm.base.api.AbstractFormApi
import com.monkeydp.daios.dm.mysql.MysqlConfig
import com.monkeydp.daios.dms.sdk.main.SdkApi
import com.monkeydp.daios.dms.sdk.metadata.form.FormBuilder
import com.monkeydp.daios.dms.sdk.metadata.form.FormLoadingCtx

/**
 * @author iPotato
 * @date 2019/11/5
 */
@SdkApi
object MysqlFormApi : AbstractFormApi() {
    override fun loadFrom(ctx: FormLoadingCtx) = FormBuilder.buildForm(MysqlConfig.formKClassMap.getValue(ctx.instr))
}