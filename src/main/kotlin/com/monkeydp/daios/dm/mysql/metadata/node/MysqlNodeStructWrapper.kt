package com.monkeydp.daios.dm.mysql.metadata.node

import com.monkeydp.daios.dm.mysql.config.MysqlNodeConfig
import com.monkeydp.daios.dms.sdk.metadata.node.AbstractNodeStructWrapper

/**
 * @author iPotato
 * @date 2019/10/30
 */
object MysqlNodeStructWrapper : AbstractNodeStructWrapper(MysqlNodeConfig.structure)