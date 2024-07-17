package org.example.backend.domain.invest.service;

import lombok.RequiredArgsConstructor;
import org.example.backend.domain.invest.presentation.dto.element.StocksElement;
import org.example.backend.domain.invest.presentation.dto.response.GetStockListResponse;
import org.example.backend.global.utils.openfeign.client.StockFeign;
import org.example.backend.global.utils.openfeign.client.dto.response.StockListResponse;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GetStockListService {
    private final StockFeign stockFeign;

    public GetStockListResponse execute() {
        StockListResponse stockListResponse = stockFeign.getStockPriceInfo();
        return GetStockListResponse.builder()
                .stocks(stockListResponse.getResponse().getBody().getItems().getItem().stream().map(
                        itemElement ->
                                StocksElement.builder()
                                        .basDt(itemElement.getBasDt())
                                        .itmsNm(itemElement.getItmsNm())
                                        .fltRt(itemElement.getFltRt())
                                        .clpr(itemElement.getClpr())
                                        .build()

                ).collect(Collectors.toList())).build();
    }
}
