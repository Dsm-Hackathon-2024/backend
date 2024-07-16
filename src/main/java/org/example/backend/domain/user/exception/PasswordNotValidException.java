package org.example.backend.domain.user.exception;

import org.example.backend.global.err.exception.BackendException;
import org.example.backend.global.err.exception.ErrorCode;

public class PasswordNotValidException extends BackendException {

    public static final BackendException EXCEPTION = new PasswordNotValidException();

    private PasswordNotValidException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}