package com.github.dkurata38.amazon_payment_example.common.domain.repository;

import com.github.dkurata38.amazon_payment_example.common.domain.entity.Contract;

import java.util.List;

public interface IContractRepository {
    public List<Contract> findByMemberId(Integer memberId);
}
