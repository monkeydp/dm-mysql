package com.monkeydp.daios.dm.mysql.def

import com.monkeydp.daios.dm.mysql.connection.MysqlConnectionFactory
import com.monkeydp.daios.dms.sdk.datasource.Datasource
import com.monkeydp.daios.dms.sdk.dm.Dm
import com.monkeydp.daios.dms.sdk.dm.Dm.*

/**
 * @author iPotato
 * @date 2019/10/8
 */
class MysqlDm : Dm {

    override val datasource = Datasource.MYSQL
    override val dbDefs = listOf(Mysql57, Mysql80)
    override val implClassNames = MysqlImplClassNames

    object MysqlImplClassNames : ImplClassNames {
        override val connectionFactory = MysqlConnectionFactory::class.qualifiedName
    }

    private object Mysql57 : DbDef {
        override val version: DbVersion = DbVersion(
                id = "5.7",
                name = "MySQL 5.7"
        )
        override val driver: DbDriver = DbDriver(
                id = "5.1",
                name = "com.mysql.jdbc.Driver"
        )
    }

    private object Mysql80 : DbDef {
        override val version: DbVersion = DbVersion(
                id = "8.0",
                name = "MySQL 8.0"
        )
        override val driver: DbDriver = DbDriver(
                id = "8.0",
                name = "com.mysql.cj.jdbc.Driver"
        )
    }
}