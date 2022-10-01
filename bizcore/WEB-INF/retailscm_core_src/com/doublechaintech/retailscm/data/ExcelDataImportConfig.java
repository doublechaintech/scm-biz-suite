package com.doublechaintech.retailscm.data;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelWriter;
import com.doublechaintech.retailscm.BaseEntity;

import java.io.File;
import java.util.List;
import java.util.Map;

public class ExcelDataImportConfig extends DataImportConfig {
  private int headerRow = 0;
  private int dataStartRow = 2;
  private int dataEndRow = Integer.MAX_VALUE;
  private int reportColumn;
  private Integer sheetIndex;
  private String sheetName;

  public ExcelDataImportConfig(Class<? extends BaseEntity> pTargetType) {
    super(pTargetType);
  }

  public ExcelDataImportConfig reportColumn(int reportColumn) {
    this.reportColumn = reportColumn;
    return this;
  }

  public ExcelReader getReader(File file) {
    if (sheetIndex != null) {
      return new ExcelReader(file, sheetIndex).setIgnoreEmptyRow(false);
    }

    if (sheetName != null) {
      return new ExcelReader(file, sheetName).setIgnoreEmptyRow(false);
    }

    return new ExcelReader(file, 0).setIgnoreEmptyRow(false);
  }

  public List<Map<String, Object>> read(File file) {
    return getReader(file).read(headerRow, dataStartRow, dataEndRow);
  }

  public ExcelWriter getWriter(File inputFile) {
    ExcelWriter writer = getReader(inputFile).getWriter();
    return writer;
  }

  public int getHeaderRow() {
    return headerRow;
  }

  public void setHeaderRow(int pHeaderRow) {
    headerRow = pHeaderRow;
  }

  public int getDataStartRow() {
    return dataStartRow;
  }

  public void setDataStartRow(int pDataStartRow) {
    dataStartRow = pDataStartRow;
  }

  public int getDataEndRow() {
    return dataEndRow;
  }

  public void setDataEndRow(int pDataEndRow) {
    dataEndRow = pDataEndRow;
  }

  public Integer getSheetIndex() {
    return sheetIndex;
  }

  public void setSheetIndex(Integer pSheetIndex) {
    sheetIndex = pSheetIndex;
  }

  public String getSheetName() {
    return sheetName;
  }

  public void setSheetName(String pSheetName) {
    sheetName = pSheetName;
  }

  public int getReportColumn() {
    return reportColumn;
  }

  public void setReportColumn(int pReportColumn) {
    reportColumn = pReportColumn;
  }
}
