package com.github.dkurata38.amazon_payment_example.common.infrastracture.repository;

import com.github.dkurata38.amazon_payment_example.common.domain.entity.Commodity;
import com.github.dkurata38.amazon_payment_example.common.domain.entity.Purchase;
import com.github.dkurata38.amazon_payment_example.common.domain.repository.IPurchaseRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PurchaseRepository implements IPurchaseRepository {
    private static List<Purchase> purchases = Arrays.asList(
            new Purchase(1, new Commodity(1, "[改訂新版]マインドマップから始めるソフトウェアテスト", 2678), 1,1, LocalDate.of(2019,5,18))
            ,new Purchase(2, new Commodity(2, "遊泳プログラマー: 時代にとらわれないプログラミング人生", 1296), 1,1, LocalDate.of(2019,5,18))
            ,new Purchase(3, new Commodity(3, "集合・位相入門 (松坂和夫 数学入門シリーズ 1)", 2808), 1,1, LocalDate.of(2019,5,9))
            ,new Purchase(4, new Commodity(4, "すごいHaskellたのしく学ぼう!", 3024), 1,1, LocalDate.of(2019,5,9))
            ,new Purchase(5, new Commodity(5, "乙女男子に恋する乙女（３） (星海社コミックス)", 659), 1,1, LocalDate.of(2019,5,6))
    );


    @Override
    public List<Purchase> findByMemberId(Integer memberId) {
        return purchases
                .stream()
                .filter(purchase -> purchase.memberId.equals(memberId))
                .collect(Collectors.toList());
    }
}
