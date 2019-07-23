package com.github.dkurata38.amazon_payment_example.web.monomorphism;

import com.github.dkurata38.amazon_payment_example.application.monomorphism.PurchaseHistoryQueryService;
import com.github.dkurata38.amazon_payment_example.domain.entity.Contract;
import com.github.dkurata38.amazon_payment_example.domain.entity.Purchase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("monomorphism/purchase")
public class PurchaseController {
    private final PurchaseHistoryQueryService purchaseHistoryQueryService;

    public PurchaseController(PurchaseHistoryQueryService purchaseHistoryQueryService) {
        this.purchaseHistoryQueryService = purchaseHistoryQueryService;
    }

    @GetMapping("list/{memberId}")
    public ModelAndView listByBadDto(@PathVariable Integer memberId) {
        List<Contract> memberContracts = purchaseHistoryQueryService.getMemberContracts(memberId);
        List<Purchase> memberPurchases = purchaseHistoryQueryService.getMemberPurchases(memberId);

        ModelAndView modelAndView = new ModelAndView("monomorphism/complex");
        // c-{id}形式のキーとContractのMap
        Map<String, Contract> contractMap = memberContracts.stream().collect(Collectors.toMap(c -> "c-" + c.id, c -> c));
        modelAndView.addObject("memberContracts", contractMap);

        // p-{id}形式のキーとPurchaseのMap
        Map<String, Purchase> purchaseMap = memberPurchases.stream().collect(Collectors.toMap(p -> "p-" + p.id, p -> p));
        modelAndView.addObject("memberPurchases", purchaseMap);

        // idと購入日付のMapを生成し、購入日順にソート
        Map<String, LocalDate> contractDateMap = contractMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().beginDate));
        Map<String, LocalDate> purchaseDateMap = purchaseMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().purchasedDate));

        Map<String, LocalDate> idMap = new HashMap<>();
        idMap.putAll(contractDateMap);
        idMap.putAll(purchaseDateMap);
        List<String> ids = idMap.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        modelAndView.addObject("ids", ids);
        return modelAndView;
    }
}
