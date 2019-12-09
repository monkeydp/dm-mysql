package com.monkeydp.daios.dm.mysql.config

import com.monkeydp.daios.dm.base.LocalConfig
import com.monkeydp.daios.dm.base.jdbc.datasource.JdbcDsDefs
import com.monkeydp.daios.dm.mysql.MysqlConfig
import com.monkeydp.daios.dm.mysql.MysqlDefs
import com.monkeydp.daios.dm.mysql.MysqlTestdata
import com.monkeydp.daios.dm.mysql.MysqlVersion
import com.monkeydp.daios.dm.mysql.conn.MysqlNewConnFrom
import com.monkeydp.daios.dm.mysql.instruction.MysqlAction
import com.monkeydp.daios.dm.mysql.instruction.MysqlTarget
import com.monkeydp.daios.dm.mysql.metadata.icon.MysqlIcon
import com.monkeydp.daios.dms.sdk.conn.NewConnForm
import com.monkeydp.daios.dms.sdk.datasource.DsDef
import com.monkeydp.daios.dms.sdk.datasource.DsVersion
import com.monkeydp.daios.dms.sdk.dm.DmTestdata
import com.monkeydp.daios.dms.sdk.instruction.action.Action
import com.monkeydp.daios.dms.sdk.instruction.target.Target
import com.monkeydp.daios.dms.sdk.metadata.icon.Icon
import com.monkeydp.tools.ext.bind
import com.monkeydp.tools.ext.notNullSingleton
import org.kodein.di.Kodein
import org.kodein.di.LazyKodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton
import kotlin.properties.Delegates
import kotlin.reflect.KClass

/**
 * @author iPotato
 * @date 2019/12/4
 */
internal var kodein: Kodein by Delegates.notNullSingleton()

internal fun initKodein(vararg modules: Kodein.Module) =
        Kodein {
            modules.forEach { import(it) }
            
            // ==== local config ====
            val config: LocalConfig = MysqlConfig()
            bind<LocalConfig>() with singleton { config }
            
            // ==== api ====
            config.apiMap.forEach { (contract, impl) -> bind(contract) with singleton { impl } }
            
            // ==== ds def ====
            val jdbcDsDefs: JdbcDsDefs = MysqlDefs
            bind<JdbcDsDefs>() with singleton { jdbcDsDefs }
            bind<Set<DsDef>>() with singleton { jdbcDsDefs.toSet() }
            
            
            // ==== class ====
            bind<KClass<out NewConnForm>>() with singleton { MysqlNewConnFrom::class }
            
            // ==== enum class ====
            bind<KClass<out DsVersion<*>>>() with singleton { MysqlVersion::class }
            bind<KClass<out Action<*>>>() with singleton { MysqlAction::class }
            bind<KClass<out Target<*>>>() with singleton { MysqlTarget::class }
            bind<KClass<out Icon<*>>>() with singleton { MysqlIcon::class }
            
            // ==== testdata ====
            bind<DmTestdata>() with singleton { MysqlTestdata }
        }