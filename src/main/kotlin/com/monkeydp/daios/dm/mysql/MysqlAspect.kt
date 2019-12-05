package com.monkeydp.daios.dm.mysql

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut

/**
 * @author iPotato
 * @date 2019/12/5
 */
@Aspect
class MysqlAspect {
    @Pointcut("execution(public * com.monkeydp.daios.dms.sdk.api.NodeApi.*(..))")
    fun pointcut() {
    }
    
    @Before("pointcut()")
    fun before() {
        println("before pointcut...")
    }
}