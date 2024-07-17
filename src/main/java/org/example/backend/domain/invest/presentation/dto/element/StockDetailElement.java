package org.example.backend.domain.invest.presentation.dto.element;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StockDetailElement {
    private String basDt;
    private String itmsNm;
    private String fltRt;
    private String clpr;
    private String hipr;
    private String lopr;
    private String mkp;
}
