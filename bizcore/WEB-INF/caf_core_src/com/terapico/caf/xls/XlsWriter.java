package com.terapico.caf.xls;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

public class XlsWriter implements BlockWriter {

    private Workbook mWorkbook;
    private File mFile;
    private InputStream mInputStream;
    private OutputStream mOutputStream;

    /**
     * @param pOutputStream
     */
    public XlsWriter(OutputStream pOutputStream) {
        mOutputStream = pOutputStream;
        try {
            mWorkbook = WorkbookFactory.create(true);
        } catch (IOException pE) {
        }
    }

    /**
     * write the xml and save as the file
     *
     * @param file
     */
    public XlsWriter(String file) {
        this(file, true);
    }

    /**
     * update/create the xls file depend on the override flag
     *
     * @param file
     * @param override
     */
    public XlsWriter(String file, boolean override) {
        File f = new File(file);
        mFile = f;
        //file existed and not override, load the file and then append more cells
        if (f.exists() && !override) {
            try {
                InputStream stream = new BufferedInputStream(new FileInputStream(f));
                mWorkbook = WorkbookFactory.create(stream);
                mInputStream = stream;
            } catch (IOException pE) {

            }
        } else {
            try {
                mWorkbook = WorkbookFactory.create(true);
            } catch (IOException pE) {
                //we are creating new file
            }
        }


    }

    @Override
    public void write(Stream<Block> pBlockStream) throws Exception {
        if (pBlockStream == null) {
            return;
        }

        pBlockStream.forEach(bl -> {
            write(bl);
        });
    }

    @Override
    public void write(Block pBl) {
        if (pBl == null) {
            return;
        }

        Cell cell = ensureCell(pBl);
        setCellValue(cell, pBl);

        if (pBl.getProperties() != null) {
            CellUtil.setCellStyleProperties(cell, pBl.getProperties());
        }

    }


    public CellStyle getDefaultStyle() {

    	final XSSFCellStyle style =(XSSFCellStyle) mWorkbook.createCellStyle ();

    	style.setBorderBottom(BorderStyle.THIN);

    	return style;


    }

    protected void setCellValue(Cell cell, Block pBlock) {
        //TODO
        //now only test for string

    	cell.setCellStyle(getDefaultStyle());

        cell.setCellValue(String.valueOf(pBlock.getValue()));
    }


    private Cell ensureCell(Block pBlock) {
        Sheet sheet = ensureSheet(pBlock);

        //region, let's create the region
        if (!isCell(pBlock)) {
            CellRangeAddress region = new CellRangeAddress(
                    pBlock.getTop(),
                    pBlock.getBottom(),
                    pBlock.getLeft(),
                    pBlock.getRight()
            );

            if (!regionExisted(sheet, region)) {

                //here also may fail for intersection, will do nothing here
                sheet.addMergedRegion(region);
            }
        }

        //use the primary cell/ left-top
        Row row = sheet.getRow(pBlock.getTop());
        if (row == null) {
            row = sheet.createRow(pBlock.getTop());
            row.setHeight((short)500);
        }
        Cell cell = row.getCell(pBlock.getLeft());
        if (cell == null) {
            cell = row.createCell(pBlock.getLeft());
        }
        return cell;

    }

    private boolean regionExisted(Sheet pSheet, CellRangeAddress pRegion) {
        List<CellRangeAddress> tMergedRegions = pSheet.getMergedRegions();
        if (tMergedRegions == null) {
            return false;
        }

        return tMergedRegions.contains(pRegion);
    }

    private Sheet ensureSheet(Block pBlock) {
        String page = pBlock.getPage();

        //the sheet
        String sheetName = sheetName(page);
        Sheet sheet = null;
        if (sheetName == null) {
            //no sheet name, we will try first sheet
            sheet = mWorkbook.getSheetAt(0);
            if (sheet == null) {
                sheet = mWorkbook.createSheet();
            }
        } else {
            sheet = mWorkbook.getSheet(sheetName);
            if (sheet == null) {
                sheet = mWorkbook.createSheet(sheetName);
            }
        }
        return sheet;
    }

    private String sheetName(String pPage) {
        if (pPage == null) {
            return null;
        }
        return WorkbookUtil.createSafeSheetName(pPage);
    }

    @Override
    public void close() throws IOException {
      mWorkbook
        .sheetIterator()
        .forEachRemaining(
            sheet -> {
              for (int i = 0; i < 20; i++) {
                sheet.autoSizeColumn(i, true);
              }
            });
        try (OutputStream fileOut = (mOutputStream == null && mFile != null) ? new BufferedOutputStream(new FileOutputStream(mFile)) : mOutputStream) {
            mWorkbook.write(fileOut);
        }
        mWorkbook.close();
        if (mInputStream != null) {
            mInputStream.close();
        }
    }

    private boolean isCell(Block pBlock) {
        return pBlock.getBottom() == pBlock.getTop() && pBlock.getLeft() == pBlock.getRight();
    }

}
