package org.example.backend.domain.invest.exception;

import org.example.backend.global.err.exception.BackendException;
import org.example.backend.global.err.exception.ErrorCode;

public class InvalidQuantityException extends BackendException {

    public static final BackendException EXCEPTION = new InvalidQuantityException();

    private InvalidQuantityException() {
        super(ErrorCode.INVALID_QUANTITY);
    }
}