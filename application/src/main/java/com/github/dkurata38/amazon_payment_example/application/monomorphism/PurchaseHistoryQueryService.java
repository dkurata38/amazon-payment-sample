package com.github.dkurata38.amazon_payment_example.application.monomorphism;

import com.github.dkurata38.amazon_payment_example.domain.entity.Contract;
import com.github.dkurata38.amazon_payment_example.domain.entity.Purchase;
import com.github.dkurata38.amazon_payment_example.domain.repository.IContractRepository;
import com.github.dkurata38.amazon_payment_example.domain.repository.IPurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseHistoryQueryService {
    private final IContractRepository contractRepository;
    private final IPurchaseRepository purchaseRepository;

    public PurchaseHistoryQueryService(IContractRepository contractRepository, IPurchaseRepository purchaseRepository) {
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
