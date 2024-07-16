package org.example.backend.global.utils.openfeign.client.exception;

import org.example.backend.global.err.exception.BackendException;
import org.example.backend.global.err.exception.ErrorCode;

public class FeignForbiddenException extends BackendException {
    public static BackendException EXCEPTION = new FeignForbiddenException();

    private FeignForbiddenException() {
        super(ErrorCode.FEIGN_FORBIDDEN);
    }
}
