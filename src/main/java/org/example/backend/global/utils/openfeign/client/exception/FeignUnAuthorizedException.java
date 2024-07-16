package org.example.backend.global.utils.openfeign.client.exception;

import org.example.backend.global.err.exception.BackendException;
import org.example.backend.global.err.exception.ErrorCode;

public class FeignUnAuthorizedException extends BackendException {
    public static BackendException EXCEPTION = new FeignUnAuthorizedException();

    private FeignUnAuthorizedException() {
        super(ErrorCode.FEIGN_UNAUTHORIZED);
    }
}
