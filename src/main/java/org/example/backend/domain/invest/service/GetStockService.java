package org.example.backend.domain.invest.service;

import lombok.RequiredArgsConstructor;
import org.example.backend.domain.invest.presentation.dto.element.StockDetailElement;
import org.example.backend.domain.invest.presentation.dto.element.StocksElement;
import org.example.backend.domain.invest.presentation.dto.response.GetStockDetailResponse;
import org.example.backend.domain.invest.presentation.dto.response.GetStockListResponse;
import org.example.backend.global.utils.openfeign.client.StockFeign;
import org.example.backend.global.utils.openfeign.client.dto.response.StockListResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GetStockService {
    @Value(value = "${stock.secret-key}")
    private String secretKey;
    private final StockFeign stockFeign;

    @Transactional(readOnly = true)
    public GetStockDetailResponse execute(String itmsNm) {
        StockListResponse stockListResponse = stockFeign.getStockPriceInfoDetails(secretKey, "json", itmsNm, 46);

        return GetStockDetailResponse.builder()
                .stocks(stockListResponse.getResponse().getBody().getItems().getItem().stream().map(
                        itemElement ->
                                StockDetailElement.builder()
                                        .basDt(itemElement.getBasDt())
                                        .itmsNm(itemElement.getItmsNm())
                                        .fltRt(itemElement.getFltRt())
                                        .clpr(itemElement.getClpr())
                                        .hipr(itemElement.getHipr())
                                        .lopr(itemElement.getLopr())
                                        .mkp(itemElement.getMkp())
                                        .build()

                ).collect(Collectors.toList())).build();
    }
}
