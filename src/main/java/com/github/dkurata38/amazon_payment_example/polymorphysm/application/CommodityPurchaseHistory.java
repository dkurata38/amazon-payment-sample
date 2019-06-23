package com.github.dkurata38.amazon_payment_example.polymorphysm.application;

import com.github.dkurata38.amazon_payment_example.common.domain.entity.Purchase;

import java.time.LocalDate;

public class CommodityPurchaseHistory implements PurchaseHistory {
    private final Purchase purchase;

    CommodityPurchaseHistory(Purchase purchase) {
        this.purchase = purchase;
    }

    @Override
    public LocalDate purchasedDate() {
        return purchase.purchasedDate;
    }

    @Override
    public String purchasedCommodityName() {
        return purchase.commodity.name;
    }

    @Override
    public String unitPrice() {
        return purchase.commodity.unitPrice + "円";
    }

    @Override
    public String amount() {
        return purchase.amount + "個";
    }

    @Override
    public String subtotal() {
        return purchase.commodity.unitPrice * purchase.amount + "円";
    }
}
