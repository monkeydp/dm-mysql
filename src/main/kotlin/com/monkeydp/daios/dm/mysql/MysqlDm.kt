package com.monkeydp.daios.dm.mysql

import com.monkeydp.daios.dm.base.AbstractDm
import com.monkeydp.daios.dm.mysql.config.MysqlDirpath
import com.monkeydp.daios.dm.mysql.mocker.MysqlCpMocker
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
    
    override val dsDefs = MysqlDefs.toSet()
    override val testdata = object : DmTestdata {
        override val cps = MysqlCpMocker.cps
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
        MysqlDirpath.dist = config.deployDir.path
    }
}