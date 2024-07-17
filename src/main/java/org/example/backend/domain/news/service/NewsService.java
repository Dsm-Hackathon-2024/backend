package org.example.backend.domain.news.service;

import lombok.RequiredArgsConstructor;
import org.example.backend.global.utils.openfeign.client.NaverNewsFeign;
import org.example.backend.global.utils.openfeign.client.dto.response.NewsListResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class NewsService {
    @Value(value = "${naver.client-id}")
    private String clientId;

    @Value(value = "${naver.client-secret}")
    private String secret;


    private final NaverNewsFeign naverNewsFeign;

    @Transactional(readOnly = true)
    public NewsListResponse execute() {
        return naverNewsFeign.getNews(clientId, secret, "주식");
    }
}
