package org.example.backend.global.utils.openfeign.client;

import org.example.backend.global.utils.openfeign.FeignConfig;
import org.example.backend.global.utils.openfeign.client.dto.response.NewsListResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "NaverNews", url = "https://openapi.naver.com/v1/search/news.json", configuration = FeignConfig.class)
public interface NaverNewsFeign {
    @GetMapping
    NewsListResponse getNews(@RequestHeader("X-Naver-Client-Id") String clientId, @RequestHeader("X-Naver-Client-Secret") String secret, @RequestParam("query") String query);
}
