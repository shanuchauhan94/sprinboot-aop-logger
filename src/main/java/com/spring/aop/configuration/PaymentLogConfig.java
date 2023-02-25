package com.spring.aop.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class PaymentLogConfig {


    @Pointcut("execution(public * com.spring.aop.service.PaymentService..*(..))")
    public void getTransaction() {
        log.debug("************** pointcut method executed ********************");
    }

    @Before("getTransaction()")
    public void getBeginTransactionLog() {
        log.debug("Before transaction log");
    }

    @After("getTransaction()")
    public void getCompleteTransactionLog() {
        log.debug("After transaction log");
    }

    @AfterReturning("getTransaction()")
    public void getCommitTransactionLog() {
        log.debug("Commit transaction log");
    }

    @AfterThrowing("getTransaction()")
    public void getRollbackTransactionLog() {
        log.error("Exception transaction log");
    }
}
