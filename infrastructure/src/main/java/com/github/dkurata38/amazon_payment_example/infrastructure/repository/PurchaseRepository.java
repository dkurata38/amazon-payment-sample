package com.github.dkurata38.amazon_payment_example.infrastructure.repository;

import com.github.dkurata38.amazon_payment_example.domain.entity.Commodity;
import com.github.dkurata38.amazon_payment_example.domain.entity.Purchase;
import com.github.dkurata38.amazon_payment_example.domain.repository.IPurchaseRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PurchaseRepository implements IPurchaseRepository {
    private static List<Purchase> purchases = Arrays.asList(
            new Purchase(1, new Commodity(1, "テストの本", 2678), 1,1, LocalDate.of(2019,5,18))
            ,new Purchase(2, new Commodity(2, "キャリアの本", 1296), 1,1, LocalDate.of(2019,5,18))
            ,new Purchase(3, new Commodity(3, "集合論の本", 2808), 1,1, LocalDate.of(2019,5,9))
            ,new Purchase(4, new Commodity(4, "すごいH本", 3024), 1,1, LocalDate.of(2019,5,9))
            ,new Purchase(5, new Commodity(5, "乙男がテーマの漫画", 659), 1,1, LocalDate.of(2019,5,6))
    );


    @Override
    public List<Purchase> findByMemberId(Integer memberId) {
        return purchases
                .stream()
                .filter(purchase -> purchase.memberId.equals(memberId))
                .collect(Collectors.toList());
    }
}
