package com.monkeydp.daios.dm.mysql.bundle

import com.monkeydp.daios.dm.base.bundle.AbstractDm
import com.monkeydp.daios.dm.mysql.connection.MysqlConnectionFactory
import com.monkeydp.daios.dms.sdk.dm.Dm.ImplClassNames

/**
 * @author iPotato
 * @date 2019/10/8
 */
object MysqlDm : AbstractDm() {

    override fun implClassNames(): ImplClassNames {
        return MysqlImplClassNames
    }

    private object MysqlImplClassNames : ImplClassNames {
        override fun connectionFactory(): String? = MysqlConnectionFactory::class.qualifiedName
    }
}