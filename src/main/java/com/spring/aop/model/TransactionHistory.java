package com.spring.aop.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransactionHistory {

    private String transId;
    private Long userId;
    private Double amount;
    private Date transDate;
    private boolean isSuccess;
}
