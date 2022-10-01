package com.doublechaintech.retailscm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import com.terapico.caf.DateTime;
import com.terapico.caf.BlobObject;
import com.terapico.caf.xls.Block;
import com.terapico.caf.xls.XlsWriter;

class HeaderBlock extends Block {

  public String getLocaleKey() {
    return localeKey;
  }

  public void setLocaleKey(String localeKey) {
    this.localeKey = localeKey;
  }

  private String localeKey;
}

public abstract class BaseGridViewGenerator extends BaseEntity {

  private static final long serialVersionUID = 1L;

  protected abstract String[] getHeaderKeys(String listName);

  protected abstract String getObjectKey(String listName);

  public BlobObject exportExcel(BaseEntity targetObjectToExport, String listName)
      throws IOException {

    List<Block> blkList = allBlocks(targetObjectToExport, listName);
    String fileName = getFileName(targetObjectToExport, listName);
    return this.exportExcel(fileName, blkList);
  }

  protected List<BaseEntity> getListToExport(BaseEntity targetObjectToExport, String listName) {
    Object listObject = targetObjectToExport.propertyOf(listName);
    if (!(listObject instanceof List)) {
      String message =
          String.format(
              "The property name '%s' provided for '%s' should be a list",
              listName, targetObjectToExport.getDisplayName());
      throw new IllegalArgumentException(message);
    }

    @SuppressWarnings("unchecked")
    List<BaseEntity> elements = (List<BaseEntity>) listObject;
    return elements;
  }

  protected String getFileName(BaseEntity user, String listName) {

    return listName + ".xls";
  }

  public BlobObject exportExcel(String fileName, List<Block> blkList) throws IOException {

    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    try (XlsWriter tXlsWriter = new XlsWriter(stream)) {

      blkList.forEach(
          b -> {
            tXlsWriter.write(b);
          });
    }

    BlobObject blob = new BlobObject();
    blob.setMimeType("application/vnd.ms-excel");
    blob.setData(stream.toByteArray());
    blob.setFileName(fileName + ".xls");

    return blob;
  }

  public boolean isHeaderBlock(Block block) {
    // TODO Auto-generated method stub
    return (block instanceof HeaderBlock);
  }

  public List<Block> allBlocks(BaseEntity targetObjectToExport, String listName) {

    List<BaseEntity> elements = getListToExport(targetObjectToExport, listName);

    List<Block> blkList = new ArrayList<Block>();

    blkList.addAll(genHeaderBlocks(targetObjectToExport, listName));
    blkList.addAll(genBodyBlocks(elements, listName));

    return blkList;
  }

  protected List<Block> genBodyBlocks(List<BaseEntity> elements, String listName) {
    List<Block> blkList = new ArrayList<Block>();
    String sheetName = this.getObjectKey(listName);

    AtomicInteger row = new AtomicInteger(1);
    AtomicInteger column = new AtomicInteger(0);

    elements.forEach(
        ele -> {
          List<Block> lineBlkList = this.genBlocksForSimpleObject(sheetName, ele);

          lineBlkList.forEach(
              block -> {
                block.setTop(row.intValue());
                block.setBottom(row.intValue());
                block.setLeft(column.intValue());
                block.setRight(column.intValue());
                column.incrementAndGet();
              });

          column.getAndSet(0);

          blkList.addAll(lineBlkList);
          row.incrementAndGet();
        });

    return blkList;
  }

  private List<Block> genBlocksForSimpleObject(String pageName, BaseEntity ele) {

    // List<KeyValuePair> keyValuePairList = ele.keyValuePairOf();

    // keyValuePairList.stream().map(kvPair->kvPair.getValue()).forEach(action);
    return Arrays.stream(ele.toFlatArray())
        .map(value -> wrapValueInCellBlock(pageName, value, 1, 2, 3, 4, 1))
        .collect(Collectors.toList());

    // return null;
  }

  protected List<Block> genHeaderBlocks(BaseEntity targetObject, String listName) {

    int i = 0;
    List<Block> blkList = new ArrayList<Block>();
    String sheetName = getObjectKey(listName);
    for (String key : this.getHeaderKeys(listName)) {
      String fieldKey = String.format("%s.%s", getObjectKey(listName), key);
      String headerName = fieldKey;
      Block headBlock = wrapValueInSingleCellBlock(sheetName, headerName, i, HEADER_LINE_NUMBER, 1);
      // last color is white
      blkList.add(headBlock);
      i++;
    }
    return blkList;
  }

  static final int HEADER_LINE_NUMBER = 0;

  protected Block createBlock(
      String pageName, Object value, int left, int right, int top, int bottom, int color) {

    if (bottom > HEADER_LINE_NUMBER) {
      // not header
      return new Block();
    }
    HeaderBlock headerBlock = new HeaderBlock();
    headerBlock.setLocaleKey(value.toString());

    return new HeaderBlock();
  }

  protected Block wrapValueInCellBlock(
      String pageName, Object value, int left, int right, int top, int bottom, int color) {
    Block bl = this.createBlock(pageName, value, left, right, top, bottom, color);

    bl.setPage(pageName);
    bl.setTop(top);
    bl.setBottom(bottom);
    bl.setLeft(left);
    bl.setRight(right);
    bl.setValue(value);
    bl.withBgColor(color);
    if (value instanceof BaseEntity) {
      BaseEntity entity = (BaseEntity) value;
      bl.setValue(entity.getDisplayName());
    }
    if (value instanceof Number) {
      bl.withBgColor(10);
      // bl.setValue(((BaseEntity)value).getDisplayName());
    }
    if (value instanceof DateTime) {
      Date date = (Date) value;
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
      bl.setValue(sdf.format(date));
      return bl;
      // bl.setValue(((BaseEntity)value).getDisplayName());
    }
    if (value instanceof Date) {
      Date date = (Date) value;
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      bl.setValue(sdf.format(date));
      return bl;
      // bl.setValue(((BaseEntity)value).getDisplayName());
    }

    // bl.setValue(value);

    return bl;
  }

  protected Block wrapValueInSingleCellBlock(
      String pageName, Object value, int left, int top, int color) {
    return wrapValueInCellBlock(pageName, value, left, left, top, top, color);
  }

  protected Block wrapValueInSingleRedCellBlock(String pageName, Object value, int left, int top) {
    return wrapValueInCellBlock(pageName, value, left, 1, top, 1, 10);
  }
}
