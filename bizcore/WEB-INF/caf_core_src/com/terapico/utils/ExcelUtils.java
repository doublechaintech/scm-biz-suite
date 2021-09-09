package com.terapico.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zyydd
 * @date 2019/3/15 15:00
 */
public class ExcelUtils {
    @FunctionalInterface
    public interface RowProcessor {
        /**
         *
         * @param extData 需要传入的外部数据
         * @param sheetName 工作表名字
         * @param sheetIndex 工作表序号
         * @param row 行号
         * @param values 本行的所有数据
         * @return  true: 继续处理下一行; false: 终止处理
         * @throws Exception
         */
        boolean processRow(Object extData, String sheetName, int sheetIndex, int row, List<Object> values) throws Exception;
    }
    /**
     * 获取xlsx文件内容某个sheet（从0开始）的内容，以二维数组形式返回
     */
    public static void processByRow(InputStream inputStream, RowProcessor processor, Object extData) throws Exception {
            XSSFWorkbook book = new XSSFWorkbook(inputStream);
            int sheetsNum = book.getNumberOfSheets();
            for (int bookIndex=0;bookIndex<sheetsNum;bookIndex++) {
                XSSFSheet sheet = book.getSheetAt(bookIndex);
                String sheetName =  sheet.getSheetName();
                int rowNum = sheet.getLastRowNum() + 1;
                // int coloumNum = sheet.getRow(0).getPhysicalNumberOfCells();

                for (int j = 0; j < rowNum; j++) {
                    XSSFRow row = sheet.getRow(j);
                    List<Object> values = new ArrayList<>();
                    if (row != null) {
                        for (int k = 0; k < row.getLastCellNum(); k++) {
                            values.add(getXCellFormatValue(row.getCell(k)));
                        }
                    }
                    if (!processor.processRow(extData, sheetName, bookIndex, j, values)){
                        return;
                    }
                }
            }
    }

    private static Object getXCellFormatValue(XSSFCell cell) {
        if (null == cell) {
            return null;
        }
        switch (cell.getCellType()) {
            case NUMERIC:
                return cell.getNumericCellValue();
            case BLANK:
                return "";
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case ERROR:
                return null;
            default:
                return cell.getStringCellValue();
        }
    }

}