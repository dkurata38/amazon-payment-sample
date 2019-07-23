package com.github.dkurata38.amazon_payment_example.infrastructure.repository;

import com.github.dkurata38.amazon_payment_example.domain.entity.Contract;
import com.github.dkurata38.amazon_payment_example.domain.entity.Service;
import com.github.dkurata38.amazon_payment_example.domain.repository.IContractRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ContractRepository implements IContractRepository {
    private static Service amazonPrime = new Service(1, "ぷらいむ", 500, 1, 1100);
    private static Service amazonMusicUnlimited = new Service(2, "ストリーミングサービス", 780, 1, 1560);

    private static List<Contract> contracts = Arrays.asList(
            new Contract(1, amazonPrime, 1, 12, LocalDate.of(2019, 6, 4))
            ,new Contract(2, amazonMusicUnlimited, 1, 1, LocalDate.of(2019, 6, 4))
            ,new Contract(3, amazonMusicUnlimited, 1, 1, LocalDate.of(2019, 5, 4))
    );

    @Override
    public List<Contract> findByMemberId(Integer memberId) {
        return contracts
                .stream()
                .filter(contract -> contract.memberId.equals(memberId))
                .collect(Collectors.toList());
    }
}
