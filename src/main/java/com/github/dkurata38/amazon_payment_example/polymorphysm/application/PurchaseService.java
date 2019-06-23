package com.github.dkurata38.amazon_payment_example.polymorphysm.application;

import com.github.dkurata38.amazon_payment_example.common.domain.entity.Contract;
import com.github.dkurata38.amazon_payment_example.common.domain.entity.Purchase;
import com.github.dkurata38.amazon_payment_example.common.domain.repository.IContractRepository;
import com.github.dkurata38.amazon_payment_example.common.domain.repository.IPurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PurchaseService {
    private final IPurchaseRepository purchaseRepository;
    private final IContractRepository contractRepository;

    public PurchaseService(IPurchaseRepository purchaseRepository, IContractRepository contractRepository) {
        this.purchaseRepository = purchaseRepository;
        this.contractRepository = contractRepository;
    }

    public List<PurchaseHistory> getMemberPurchaseHistory(Integer memberId) {
        List<Purchase> purchases = purchaseRepository.findByMemberId(memberId);
        Stream<CommodityPurchaseHistory> commodityPurchaseHistoryStream = purchases.stream().map(CommodityPurchaseHistory::new);
        List<Contract> contracts = contractRepository.findByMemberId(memberId);
        Stream<ServicePurchaseHistory> contractHistoryStream = contracts.stream().map(ServicePurchaseHistory::new);
        return Stream.concat(commodityPurchaseHistoryStream, contractHistoryStream)
                .sorted(Comparator.comparing(PurchaseHistory::purchasedDate))
                .collect(Collectors.toList());
    }
}
