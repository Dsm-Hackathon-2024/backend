package org.example.backend.domain.invest.service;

import lombok.RequiredArgsConstructor;
import org.example.backend.domain.invest.domain.Invest;
import org.example.backend.domain.invest.domain.repository.InvestRepository;
import org.example.backend.domain.invest.exception.InsufficientPointsException;
import org.example.backend.domain.invest.exception.InvalidQuantityException;
import org.example.backend.domain.invest.presentation.dto.repuest.BuyStockRequest;
import org.example.backend.domain.user.domain.User;
import org.example.backend.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuyStockService {

    private final InvestRepository investRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(BuyStockRequest request) {
        User user = userFacade.getCurrentUser();

        Long userPoint = user.getPoint();
        double totalPrice = request.getPrice() * request.getQuantity();

        if (userPoint < totalPrice) {
            throw InsufficientPointsException.EXCEPTION;
        }

        if (request.getQuantity() <= 0) {
            throw InvalidQuantityException.EXCEPTION;
        }

        Optional<Invest> optionalInvest = investRepository.findByNameAndUser(request.getName(), user);

        Invest invest;
        if (optionalInvest.isPresent()) {
            invest = optionalInvest.get();
            invest.setQuantity(invest.getQuantity() + request.getQuantity());
            invest.setPrice(request.getPrice());
            invest.setRoc(request.getRoc());
        } else {
            invest = Invest.builder()
                    .user(user)
                    .name(request.getName())
                    .quantity(request.getQuantity())
                    .price(request.getPrice())
                    .roc(request.getRoc())
                    .build();
        }

        user.setPoint(userPoint - (int) totalPrice);

        investRepository.save(invest);
    }
}
