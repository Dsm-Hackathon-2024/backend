package org.example.backend.global.utils.openfeign.client;

import org.example.backend.global.utils.openfeign.StockRequestConfiguration;
import org.example.backend.global.utils.openfeign.client.dto.response.StockListResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "StockFeign", url = "https://apis.data.go.kr/1160100/service/GetStockSecuritiesInfoService/getStockPriceInfo", configuration = StockRequestConfiguration.class)
public interface StockFeign {
    @GetMapping
    StockListResponse getStockPriceInfo();
}
