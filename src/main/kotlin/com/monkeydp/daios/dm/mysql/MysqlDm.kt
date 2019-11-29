package com.monkeydp.daios.dm.mysql

import com.monkeydp.daios.dm.base.AbstractDm
import com.monkeydp.daios.dm.base.LocalConfig
import com.monkeydp.daios.dm.mysql.ext.distDirpath
import com.monkeydp.daios.dm.mysql.mocker.MysqlCpMocker
import com.monkeydp.daios.dms.sdk.datasource.Datasource.MYSQL
import com.monkeydp.daios.dms.sdk.dm.DmOpenConfig
import com.monkeydp.daios.dms.sdk.dm.DmTestdata
import com.monkeydp.tools.ext.notNullSingleton
import kotlin.properties.Delegates

/**
 * @author iPotato
 * @date 2019/10/8
 */
class MysqlDm(config: DmOpenConfig) : AbstractDm(config) {
    
    companion object {
        @Volatile
        private var isInitialized = false
        var INSTANCE by Delegates.notNullSingleton<MysqlDm>()
            private set
    }
    
    override val datasource = MYSQL
    override val dsDefs = listOf(MysqlDefs.Mysql57, MysqlDefs.Mysql80)
    override val testdata = object : DmTestdata {
        override val cps = MysqlCpMocker.cps
    }
    
    override val config = object : LocalConfig() {
        override val formConfig = object : FormConfig() {
            override val reflections = getReflections()
        }
        override val instrConfig = object : InstrConfig() {
            override val reflections = getReflections()
        }
    }
    
    init {
        if (!isInitialized) {
            synchronized(MysqlDm::class) {
                if (!isInitialized) {
                    initialize()
                    INSTANCE = this
                }
            }
        }
    }
    
    override fun updateOpenConfig(config: DmOpenConfig) {
        distDirpath = config.deployDir.path
    }
}