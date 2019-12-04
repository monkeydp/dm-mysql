package com.monkeydp.daios.dm.mysql

import com.monkeydp.daios.dm.base.AbstractDmTestdata
import com.monkeydp.daios.dm.mysql.mocker.MysqlCpMocker

/**
 * @author iPotato
 * @date 2019/12/5
 */
object MysqlTestdata : AbstractDmTestdata() {
    override val cps = MysqlCpMocker.cps
}