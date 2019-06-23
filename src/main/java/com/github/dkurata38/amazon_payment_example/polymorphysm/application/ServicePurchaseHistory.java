package com.github.dkurata38.amazon_payment_example.polymorphysm.application;

import com.github.dkurata38.amazon_payment_example.common.domain.entity.Contract;

import java.time.LocalDate;

public class ServicePurchaseHistory implements PurchaseHistory {
    private final Contract contract;

    ServicePurchaseHistory(Contract contract) {
        this.contract = contract;
    }

    @Override
    public LocalDate purchasedDate() {
        return contract.beginDate;
    }

    @Override
    public String purchasedCommodityName() {
        return contract.service.name;
    }

    @Override
    public String unitPrice() {
        return contract.service.priceByUnitMonth + "円/" + contract.service.unitMonths + "ヶ月" ;
    }

    @Override
    public String amount() {
        return contract.months + "ヶ月";
    }

    @Override
    public String subtotal() {
        return contract.service.priceByUnitMonth / contract.service.unitMonths * contract.months + "円";
    }
}
