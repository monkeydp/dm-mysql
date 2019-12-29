package com.monkeydp.daios.dm.mysql.api

import com.monkeydp.daios.dm.base.api.AbstractFormApi
import com.monkeydp.daios.dm.mysql.config.kodein
import com.monkeydp.daios.dms.sdk.api.annot.SdkFormApi
import com.monkeydp.daios.dms.sdk.metadata.form.Form
import com.monkeydp.daios.dms.sdk.metadata.form.FormBuilder
import com.monkeydp.daios.dms.sdk.metadata.form.FormLoadingCtx
import com.monkeydp.daios.dms.sdk.received.form.ReceivedForm
import com.sun.org.apache.bcel.internal.generic.Instruction
import org.kodein.di.generic.instance
import kotlin.reflect.KClass

/**
 * @author iPotato
 * @date 2019/11/5
 */
@SdkFormApi
object MysqlFormApi : AbstractFormApi() {

}