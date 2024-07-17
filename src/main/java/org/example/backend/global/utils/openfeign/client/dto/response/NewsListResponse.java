package org.example.backend.global.utils.openfeign.client.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.backend.global.utils.openfeign.client.dto.element.NewsItemElement;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewsListResponse {
    private List<NewsItemElement> items;
}
