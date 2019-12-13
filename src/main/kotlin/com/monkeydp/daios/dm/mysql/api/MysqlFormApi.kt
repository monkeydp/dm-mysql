package com.monkeydp.daios.dm.mysql.api

import com.monkeydp.daios.dm.base.api.AbstractFormApi
import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dms.sdk.annot.SdkApi
import com.monkeydp.daios.dms.sdk.annot.SdkForm
import com.monkeydp.daios.dms.sdk.instruction.Instruction
import com.monkeydp.daios.dms.sdk.metadata.form.FormBuilder
import com.monkeydp.daios.dms.sdk.metadata.form.FormLoadingCtx
import org.kodein.di.generic.instance
import kotlin.reflect.KClass

/**
 * @author iPotato
 * @date 2019/11/5
 */
@SdkApi
object MysqlFormApi : AbstractFormApi() {
    private val formKClassMap: Map<Instruction, KClass<*>> by kodein.instance(SdkForm::class)
    override fun loadFrom(ctx: FormLoadingCtx) = FormBuilder.buildForm(formKClassMap.getValue(ctx.instr))
}