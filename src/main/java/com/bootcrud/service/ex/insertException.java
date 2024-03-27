package com.bootcrud.service.ex;
/**
 *  数据在插入的过程中所产生的异常
 */
public class insertException extends RuntimeException{
    public insertException() {
        super();
    }

    public insertException(String message) {
        super(message);
    }

    public insertException(String message, Throwable cause) {
        super(message, cause);
    }

    public insertException(Throwable cause) {
        super(cause);
    }

    protected insertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
