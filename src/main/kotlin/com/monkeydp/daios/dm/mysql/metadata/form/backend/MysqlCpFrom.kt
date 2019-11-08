package com.monkeydp.daios.dm.mysql.metadata.form.backend

import com.fasterxml.jackson.annotation.JsonIgnore
import com.monkeydp.daios.dm.base.instruction.NewConn
import com.monkeydp.daios.dm.base.metadata.form.backend.AbstractCpForm
import com.monkeydp.daios.dms.sdk.metadata.form.FormImpl
import org.jetbrains.annotations.TestOnly

/**
 * @author iPotato
 * @date 2019/10/20
 */
@FormImpl(instrClass = NewConn::class)
class MysqlCpFrom : AbstractCpForm {
    constructor(
            connName: String = "MySQL Conn",
            host: String = "127.0.0.1",
            port: String = "3306",
            username: String = "root",
            password: String = ""
    ) : super(connName, host, port, username, password)
    
    val testVar = "Just for test"
        @TestOnly get
    
    @JsonIgnore
    val url = "jdbc:mysql://$host:$port?useSSL=true&serverTimezone=UTC&remarksReporting=true"
}