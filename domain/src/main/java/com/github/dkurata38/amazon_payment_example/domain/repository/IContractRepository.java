package com.github.dkurata38.amazon_payment_example.domain.repository;

import com.github.dkurata38.amazon_payment_example.domain.entity.Contract;

import java.util.List;

public interface IContractRepository {
    List<Contract> findByMemberId(Integer memberId);
}
