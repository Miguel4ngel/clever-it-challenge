package com.cleverit.demo.domain.exception;

/**
 * @author Miguel Angel
 * @since v1.0.0
 */

public class DomainErrorException extends RuntimeException {

    public static DomainErrorException thrown(String message) {
        throw new DomainErrorException(message);
    }

    public DomainErrorException(String message) {
        super(message);
    }
}
