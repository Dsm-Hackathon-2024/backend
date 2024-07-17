package org.example.backend.global.utils.openfeign.client.dto.element;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemElement {
    private String basDt;
    private String itmsNm;
    private String fltRt;
    private String clpr;
}
