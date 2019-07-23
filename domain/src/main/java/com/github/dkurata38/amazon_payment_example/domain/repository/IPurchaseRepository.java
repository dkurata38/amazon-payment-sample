package com.github.dkurata38.amazon_payment_example.domain.repository;


import com.github.dkurata38.amazon_payment_example.domain.entity.Purchase;

import java.util.List;

public interface IPurchaseRepository {
    List<Purchase> findByMemberId(Integer memberId);
}
