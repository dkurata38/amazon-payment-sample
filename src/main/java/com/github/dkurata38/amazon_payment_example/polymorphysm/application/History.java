package com.github.dkurata38.amazon_payment_example.polymorphysm.application;

import java.time.LocalDate;

public interface History {
    LocalDate purchasedDate();
    String purchasedCommodityName();
    String unitPrice();
    String amount();
    String subtotal();
}
