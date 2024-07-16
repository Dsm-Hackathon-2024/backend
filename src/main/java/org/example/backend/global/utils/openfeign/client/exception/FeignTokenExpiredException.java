package org.example.backend.global.utils.openfeign.client.exception;

import org.example.backend.global.err.exception.BackendException;
import org.example.backend.global.err.exception.ErrorCode;

public class FeignTokenExpiredException extends BackendException {
    public static BackendException EXCEPTION = new FeignTokenExpiredException();

    private FeignTokenExpiredException() {
        super(ErrorCode.FEIGN_TOKEN_EXPIRED);
    }
}
