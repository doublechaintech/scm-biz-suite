package com.doublechaintech.retailscm;

public class RetailscmRuntimeException extends RuntimeException {
  static final long serialVersionUID = -1;

  public RetailscmRuntimeException() {
    super();
  }

  public RetailscmRuntimeException(String message) {
    super(message);
  }

  public RetailscmRuntimeException(String message, Throwable cause) {
    super(message, cause);
  }

  public RetailscmRuntimeException(Throwable cause) {
    super(cause);
  }
}
