package org.example.backend.domain.news.presentation;

import lombok.RequiredArgsConstructor;
import org.example.backend.domain.news.service.NewsService;
import org.example.backend.global.utils.openfeign.client.dto.response.NewsListResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/news")
@RestController
public class NewsController {
    private final NewsService newsService;

    @GetMapping
    public NewsListResponse getNewsList() {
        return newsService.execute();
    }
}
