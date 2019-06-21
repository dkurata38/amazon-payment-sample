package com.github.dkurata38.amazon_payment_example.monomorphism.web;

import com.github.dkurata38.amazon_payment_example.common.domain.entity.Contract;
import com.github.dkurata38.amazon_payment_example.common.domain.entity.Purchase;
import com.github.dkurata38.amazon_payment_example.monomorphism.application.PurchaseUseCase;
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
    private final PurchaseUseCase purchaseUseCase;

    public PurchaseController(PurchaseUseCase purchaseUseCase) {
        this.purchaseUseCase = purchaseUseCase;
    }

    @GetMapping("list/{memberId}")
    public ModelAndView listByBadDto(@PathVariable Integer memberId) {
        List<Contract> memberContracts = purchaseUseCase.getMemberContracts(memberId);
        List<Purchase> memberPurchases = purchaseUseCase.getMemberPurchases(memberId);

        ModelAndView modelAndView = new ModelAndView("monomorphism/complex");
        modelAndView.addObject("memberContracts", memberContracts.stream().collect(Collectors.toMap(c -> "c-" + c.id, c -> c)));
        modelAndView.addObject("memberPurchases", memberPurchases.stream().collect(Collectors.toMap(p -> "p-" + p.id, p -> p)));
        Map<String, LocalDate> contractDateMap = memberContracts.stream()
                .collect(Collectors.toMap(element -> "c-" + element.id, element -> element.beginDate));
        Map<String, LocalDate> purchaseDateMap = memberPurchases.stream()
                .collect(Collectors.toMap(element -> "p-" + element.id, element -> element.purchasedDate));
        Map<String, LocalDate> idMap = new HashMap<>();
        idMap.putAll(contractDateMap);
        idMap.putAll(purchaseDateMap);
        List<String> ids = idMap.entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getValue()))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
        modelAndView.addObject("ids", ids);
        return modelAndView;
    }
}
