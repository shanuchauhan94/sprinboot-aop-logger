package com.spring.aop.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentContext {

    private Long userId;
    private Double amount;
}
