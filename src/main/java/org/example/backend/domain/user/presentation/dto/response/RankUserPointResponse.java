package org.example.backend.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.example.backend.domain.user.presentation.dto.element.Top3RankElement;

import java.util.List;

@Getter
@Builder
public class RankUserPointResponse {
    private String name;
    private long rank;
    private long point;
    private List<Top3RankElement> top3;
}
