package com.doublechaintech.retailscm.data;

public class XlsImportError {
  private int row;
  private String message;
  private String property;

  public XlsImportError(int pRow, String error, String prop) {
    row = pRow;
    message = error;
    property = prop;
  }

  public XlsImportError(int pDataRow, String pResult) {
    row = pDataRow;
    message = pResult;
  }

  public int getRow() {
    return row;
  }

  public void setRow(int pRow) {
    row = pRow;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String pMessage) {
    message = pMessage;
  }

  public String getProperty() {
    return property;
  }

  public void setProperty(String pProperty) {
    property = pProperty;
  }
}
