package org.example.backend.domain.invest.presentation.dto.element;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StocksElement {
    private String basDt;
    private String itmsNm;
    private String fltRt;
    private String clpr;
}
