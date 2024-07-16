package org.example.backend.global.utils.openfeign;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.example.backend.global.exception.InternalServerError;
import org.example.backend.global.utils.openfeign.client.exception.FeignBadRequestException;
import org.example.backend.global.utils.openfeign.client.exception.FeignForbiddenException;
import org.example.backend.global.utils.openfeign.client.exception.FeignTokenExpiredException;
import org.example.backend.global.utils.openfeign.client.exception.FeignUnAuthorizedException;

public class FeignClientErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() >= 400) {
            switch (response.status()) {
                case 400: throw FeignBadRequestException.EXCEPTION;
                case 401: throw FeignUnAuthorizedException.EXCEPTION;
                case 403: throw FeignForbiddenException.EXCEPTION;
                case 419: throw FeignTokenExpiredException.EXCEPTION;
                default: throw InternalServerError.EXCEPTION;
            }
        }

        return FeignException.errorStatus(methodKey, response);
    }
}
