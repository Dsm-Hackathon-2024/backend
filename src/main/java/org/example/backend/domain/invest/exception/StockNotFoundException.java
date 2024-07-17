package org.example.backend.domain.invest.exception;

import org.example.backend.global.err.exception.BackendException;
import org.example.backend.global.err.exception.ErrorCode;

public class StockNotFoundException extends BackendException {

    public static final BackendException EXCEPTION = new StockNotFoundException();

    private StockNotFoundException() {
        super(ErrorCode.STOCK_NOT_FOUND);
    }
}