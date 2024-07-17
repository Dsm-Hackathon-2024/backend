package org.example.backend.global.utils.openfeign.client.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.backend.global.utils.openfeign.client.dto.element.ResponseElement;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockListResponse {
    private ResponseElement response;
}



