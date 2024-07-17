package org.example.backend.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.backend.domain.invest.domain.Invest;
import org.example.backend.domain.invest.domain.repository.InvestRepository;
import org.example.backend.domain.user.domain.User;
import org.example.backend.domain.user.facade.UserFacade;
import org.example.backend.domain.user.presentation.dto.response.UserInvestResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserInvestService {

    private final UserFacade userFacade;
    private final InvestRepository investRepository;

    public List<UserInvestResponse> execute() {
        User user = userFacade.getCurrentUser();
        List<Invest> invests = investRepository.findByUserId(user.getId());

        return invests.stream()
                .map(invest -> UserInvestResponse.builder()
                        .id(invest.getId())
                        .roc(invest.getRoc())
                        .name(invest.getName())
                        .price(invest.getPrice())
                        .build()
                )
                .collect(Collectors.toList());
    }
}
