package com.monkeydp.daios.dm.mysql

import com.monkeydp.daios.dms.sdk.datasource.Datasource
import com.monkeydp.daios.dms.sdk.datasource.Datasource.MYSQL
import com.monkeydp.daios.dms.sdk.datasource.DsVersion

/**
 * @author iPotato
 * @date 2019/10/27
 */
enum class MysqlVersion(
        override val id: String,
        override val description: String,
        override val datasource: Datasource = MYSQL
) : DsVersion<MysqlVersion> {
    MYSQL_5_7("5.7", "MySQL 5.7"),
    MYSQL_8_0("8.0", "MySQL 8.0"),
}