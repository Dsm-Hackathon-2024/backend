package org.example.backend.domain.invest.exception;

import org.example.backend.global.err.exception.BackendException;
import org.example.backend.global.err.exception.ErrorCode;

public class InsufficientStocksException extends BackendException {

    public static final BackendException EXCEPTION = new InsufficientStocksException();

    private InsufficientStocksException() {
        super(ErrorCode.INSUFFICIENT_STOCKS);
    }
}