package org.example.backend.global.utils.openfeign.client.dto.element;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewsItemElement {
    private String title;
    private String originallink;
    private String description;
}
