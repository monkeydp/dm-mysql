package com.monkeydp.daios.dm.mysql.api

import com.monkeydp.daios.dm.base.api.AbstractFormApi
import com.monkeydp.daios.dm.mysql.MysqlDm
import com.monkeydp.daios.dms.sdk.api.SdkApi
import com.monkeydp.daios.dms.sdk.metadata.form.FormBuilder
import com.monkeydp.daios.dms.sdk.metadata.form.FormLoadingCtx

/**
 * @author iPotato
 * @date 2019/11/5
 */
@SdkApi
object MysqlFormApi : AbstractFormApi() {
    
    private val formKClassMap by lazy { MysqlDm.INSTANCE.config.formConfig.formKClassMap }
    
    override fun loadFrom(ctx: FormLoadingCtx) = FormBuilder.buildForm(formKClassMap.getValue(ctx.instr))
}