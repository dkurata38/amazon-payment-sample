package com.github.dkurata38.amazon_payment_example.common.domain.entity;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class Purchase {
    public final Integer id;
    public final Commodity commodity;
    public final Integer memberId;
    public final Integer amount;
    public final LocalDate purchasedDate;
}
