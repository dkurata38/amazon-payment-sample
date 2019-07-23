package com.github.dkurata38.amazon_payment_example.application.polymorphysm;

import java.time.LocalDate;

public interface PurchaseHistory {
    LocalDate purchasedDate();
    String purchasedCommodityName();
    String unitPrice();
    String amount();
    String subtotal();
}
