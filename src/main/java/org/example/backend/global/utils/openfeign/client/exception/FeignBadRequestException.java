package org.example.backend.global.utils.openfeign.client.exception;

import org.example.backend.global.err.exception.BackendException;
import org.example.backend.global.err.exception.ErrorCode;

public class FeignBadRequestException extends BackendException {
    public static BackendException EXCEPTION = new FeignBadRequestException();

    private FeignBadRequestException() {
        super(ErrorCode.FEIGN_BAD_REQUEST);
    }
}
