package org.example.backend.domain.invest.presentation;

import lombok.RequiredArgsConstructor;
import org.example.backend.domain.invest.presentation.dto.repuest.BuyStockRequest;
import org.example.backend.domain.invest.presentation.dto.repuest.SellStockRequest;
import org.example.backend.domain.invest.presentation.dto.response.GetStockListResponse;
import org.example.backend.domain.invest.service.BuyStockService;
import org.example.backend.domain.invest.service.GetStockListService;
import org.example.backend.domain.invest.service.SellStockService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/invest")
@RestController
public class InvestController {
    private final GetStockListService getStockListService;
    private final BuyStockService buyStockService;
    private final SellStockService sellStockService;

    @GetMapping("/stocks")
    public GetStockListResponse getStockList() {
        return getStockListService.execute();
    }

    @PostMapping("/stocks/buy")
    public void buyStock(@RequestBody BuyStockRequest request) {
        buyStockService.execute(request);
    }

    @PostMapping("/stocks/sell")
    public void sellStock(@RequestBody SellStockRequest request) {
        sellStockService.execute(request);
    }
}
