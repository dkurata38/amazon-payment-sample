package com.github.dkurata38.amazon_payment_example.common.domain.repository;

import com.github.dkurata38.amazon_payment_example.common.domain.entity.Purchase;

import java.util.List;

public interface IPurchaseRepository {
    List<Purchase> findByMemberId(Integer memberId);
}
