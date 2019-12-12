package com.monkeydp.daios.dm.mysql.api

import com.monkeydp.daios.dm.base.LocalConfig
import com.monkeydp.daios.dm.base.api.AbstractFormApi
import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dms.sdk.annot.SdkApi
import com.monkeydp.daios.dms.sdk.metadata.form.FormBuilder
import com.monkeydp.daios.dms.sdk.metadata.form.FormLoadingCtx
import org.kodein.di.generic.instance

/**
 * @author iPotato
 * @date 2019/11/5
 */
@SdkApi
object MysqlFormApi : AbstractFormApi() {
    private val config: LocalConfig by kodein.instance()
    override fun loadFrom(ctx: FormLoadingCtx) = FormBuilder.buildForm(config.formKClassMap.getValue(ctx.instr))
}