package com.payment.generator.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String errorMessage;
    private final HttpStatus httpStatus;

    public ApiException(final String errorMessage, final HttpStatus httpStatus) {
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    String getErrorMessage() {
        return errorMessage;
    }

    HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
