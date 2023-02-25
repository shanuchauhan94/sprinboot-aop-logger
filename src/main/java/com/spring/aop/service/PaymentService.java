package com.spring.aop.service;

import com.spring.aop.model.PaymentContext;
import com.spring.aop.model.TransactionHistory;

import java.util.List;
import java.util.Optional;

public interface PaymentService {

    Optional<List<TransactionHistory>> doPayment(PaymentContext context);
    Long genUserId();

}
