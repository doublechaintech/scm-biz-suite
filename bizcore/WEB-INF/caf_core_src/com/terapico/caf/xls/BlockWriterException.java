package com.terapico.caf.xls;

public class BlockWriterException extends RuntimeException{
    public BlockWriterException() {
    }

    public BlockWriterException(String message) {
        super(message);
    }

    public BlockWriterException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlockWriterException(Throwable cause) {
        super(cause);
    }

    public BlockWriterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
