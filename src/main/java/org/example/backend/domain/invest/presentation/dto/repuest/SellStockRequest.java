package org.example.backend.domain.invest.presentation.dto.repuest;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SellStockRequest {
    private String name;
    private int quantity;
    private double price;
    private double roc;
}
