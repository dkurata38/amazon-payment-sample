package com.github.dkurata38.amazon_payment_example.monomorphism.application;

import com.github.dkurata38.amazon_payment_example.common.domain.entity.Contract;
import com.github.dkurata38.amazon_payment_example.common.domain.entity.Purchase;
import com.github.dkurata38.amazon_payment_example.common.domain.repository.IContractRepository;
import com.github.dkurata38.amazon_payment_example.common.domain.repository.IPurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseUseCase {
    private final IContractRepository contractRepository;
    private final IPurchaseRepository purchaseRepository;

    public PurchaseUseCase(IContractRepository contractRepository, IPurchaseRepository purchaseRepository) {
        this.contractRepository = contractRepository;
        this.purchaseRepository = purchaseRepository;
    }

    public List<Contract> getMemberContracts(Integer memberId) {
        return contractRepository.findByMemberId(memberId);
    }

    public List<Purchase> getMemberPurchases(Integer memberId) {
        return purchaseRepository.findByMemberId(memberId);
    }
}
