package org.example.backend.domain.invest.service;

import lombok.RequiredArgsConstructor;
import org.example.backend.domain.invest.domain.Invest;
import org.example.backend.domain.invest.domain.repository.InvestRepository;
import org.example.backend.domain.invest.exception.InsufficientStocksException;
import org.example.backend.domain.invest.exception.InvalidQuantityException;
import org.example.backend.domain.invest.exception.StockNotFoundException;
import org.example.backend.domain.invest.presentation.dto.repuest.SellStockRequest;
import org.example.backend.domain.user.domain.User;
import org.example.backend.domain.user.facade.UserFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SellStockService {

    private final InvestRepository investRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(SellStockRequest request) {
        User user = userFacade.getCurrentUser();

        int quantityToSell = request.getQuantity();

        if (quantityToSell <= 0) {
            throw InvalidQuantityException.EXCEPTION;
        }

        Optional<Invest> optionalInvest = investRepository.findByNameAndUser(request.getName(), user);

        if (optionalInvest.isEmpty()) {
            throw StockNotFoundException.EXCEPTION;
        }

        Invest invest = optionalInvest.get();
        int currentQuantity = invest.getQuantity();

        if (currentQuantity < quantityToSell) {
            throw InsufficientStocksException.EXCEPTION;
        }

        double currentPrice = request.getPrice();
        double totalPrice = currentPrice * quantityToSell;

        if (currentQuantity == quantityToSell) {
            investRepository.delete(invest);
        } else {
            invest.setQuantity(currentQuantity - quantityToSell);
            invest.setPrice(currentPrice);
            invest.setRoc(request.getRoc());
            investRepository.save(invest);
        }

        user.setPoint(user.getPoint() + (int) totalPrice);
    }
}
