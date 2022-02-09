package com.viktorcvetanovic.vpl.exception;

public abstract class VPLGenericError extends RuntimeException {
    public VPLGenericError(String message) {
        super(message);
    }

    public VPLGenericError() {
        super("Internal error: An error happened");
    }

}
