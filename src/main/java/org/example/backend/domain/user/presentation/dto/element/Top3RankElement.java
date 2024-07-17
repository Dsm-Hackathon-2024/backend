package org.example.backend.domain.user.presentation.dto.element;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Top3RankElement {
    private String name;
    private int rank;
    private long point;
}
