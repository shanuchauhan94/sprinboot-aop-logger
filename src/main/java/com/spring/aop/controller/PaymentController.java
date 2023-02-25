package com.spring.aop.controller;

import com.spring.aop.model.PaymentContext;
import com.spring.aop.model.TransactionHistory;
import com.spring.aop.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/record")
    public ResponseEntity<List<TransactionHistory>> recordPayment(@RequestBody PaymentContext context) {

        Optional<List<TransactionHistory>> paymentHistory = paymentService.doPayment(context);
        if (paymentHistory.isPresent()) {
            return new ResponseEntity<>(paymentHistory.get(), HttpStatus.OK);
        } else {
            throw new RuntimeException("Invalid Transaction!");
        }
    }


}
