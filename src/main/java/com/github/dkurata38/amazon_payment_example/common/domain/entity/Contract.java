package com.github.dkurata38.amazon_payment_example.common.domain.entity;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class Contract {
    public final Integer id;
    public final Service service;
    public final Integer memberId;
    public final Integer months;
    public final LocalDate beginDate;
}
