package org.example.backend.domain.invest.service;

import lombok.RequiredArgsConstructor;
import org.example.backend.domain.invest.presentation.dto.element.StocksElement;
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
    public GetStockListResponse execute(String itmsNm) {
        StockListResponse stockListResponse = stockFeign.getStockPriceInfoDetails(secretKey, "json", itmsNm);

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
