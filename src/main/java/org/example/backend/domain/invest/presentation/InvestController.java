package org.example.backend.domain.invest.presentation;

import lombok.RequiredArgsConstructor;
import org.example.backend.domain.invest.presentation.dto.response.GetStockListResponse;
import org.example.backend.domain.invest.service.GetStockListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/invest")
@RestController
public class InvestController {
    private final GetStockListService getStockListService;

    @GetMapping("/stocks")
    public GetStockListResponse getStockList() {
        return getStockListService.execute();
    }
}
