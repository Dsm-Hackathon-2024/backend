package org.example.backend.domain.invest.exception;

import org.example.backend.global.err.exception.BackendException;
import org.example.backend.global.err.exception.ErrorCode;

public class InsufficientPointsException extends BackendException {

    public static final BackendException EXCEPTION = new InsufficientPointsException();

    private InsufficientPointsException() {
        super(ErrorCode.INSUFFICIENT_POINTS);
    }
}