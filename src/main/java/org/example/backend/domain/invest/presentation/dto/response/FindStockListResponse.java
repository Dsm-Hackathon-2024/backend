package org.example.backend.domain.invest.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.example.backend.domain.invest.presentation.dto.element.StocksElement;

import java.util.List;

@Getter
@Builder
public class FindStockListResponse {
    private List<StocksElement> stocks;
}
