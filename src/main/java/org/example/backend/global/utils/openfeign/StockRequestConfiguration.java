package org.example.backend.global.utils.openfeign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class StockRequestConfiguration {
    @Value(value = "${stock.secret-key}")
    private String secretKey;

    @Bean
    public RequestInterceptor stockRequestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                template.query("serviceKey", secretKey);
                template.query("resultType", "json");
            }
        };
    }


}
