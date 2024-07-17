package org.example.backend.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInvestResponse {

    private Long id;
    private String name;
    private double roc;
    private double price;
    private int quantity;
}
