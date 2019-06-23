package com.github.dkurata38.amazon_payment_example.polymorphysm.web;

import com.github.dkurata38.amazon_payment_example.polymorphysm.application.History;
import com.github.dkurata38.amazon_payment_example.polymorphysm.application.PurchaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("polymorphism/purchase")
public class PolyPurchaseController {
    private final PurchaseService purchaseService;

    public PolyPurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("list/{memberId}")
    public ModelAndView getInterface(@PathVariable("memberId") Integer memberId) {
        List<History> memberPurchaseHistories = purchaseService.getMemberPurchaseHistory(memberId);
        ModelAndView modelAndView = new ModelAndView("polymorphism/list");
        modelAndView.addObject("memberPurchaseHistories", memberPurchaseHistories);
        return modelAndView;
    }
}
