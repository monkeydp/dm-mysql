package com.monkeydp.daios.dm.mysql

import com.monkeydp.daios.dm.base.jdbc.datasource.AbstractJdbcDsDef
import com.monkeydp.daios.dms.sdk.datasource.DsDriver
import com.monkeydp.daios.dms.sdk.datasource.DsVersion

/**
 * @author iPotato
 * @date 2019/12/27
 */
class MysqlDef(
        version: DsVersion<*>,
        driver: DsDriver
) : AbstractJdbcDsDef(version, driver)