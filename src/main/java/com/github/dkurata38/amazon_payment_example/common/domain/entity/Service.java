package com.github.dkurata38.amazon_payment_example.common.domain.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Service {
    public final Integer id;
    public final String name;
    public final Integer priceByUnitMonth;
    public final Integer unitMonths;
    public final Integer yearlyDiscount;
}
