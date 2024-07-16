package org.example.backend.global.exception;

import org.example.backend.global.err.exception.BackendException;
import org.example.backend.global.err.exception.ErrorCode;

public class InternalServerError extends BackendException {
    public static BackendException EXCEPTION = new InternalServerError();

    private InternalServerError() {
        super(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}
