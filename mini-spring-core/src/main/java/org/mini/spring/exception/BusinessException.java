package org.mini.spring.exception;

/**
 * 运行时异常 (非检查)
 */
public class BusinessException extends RuntimeException {

    private String errorCode;

    private String message;

    public BusinessException(String errorCode,String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }
    public BusinessException(String message) {
        super(message);
        this.errorCode = "10010";
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
