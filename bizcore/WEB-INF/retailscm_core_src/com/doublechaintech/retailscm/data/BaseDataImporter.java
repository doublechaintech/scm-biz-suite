package com.doublechaintech.retailscm.data;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.search.BaseRequest;
import com.doublechaintech.retailscm.search.Searcher;
import com.doublechaintech.retailscm.utils.BaseEntityUtil;
import com.terapico.utils.TaskUtil;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

import static com.doublechaintech.retailscm.secuser.CustomSecUserManagerImpl.GLOBAL_CONTEXT;
import static org.springframework.transaction.TransactionDefinition.PROPAGATION_REQUIRES_NEW;

public class BaseDataImporter {
  public static final String XLS_IMPORT_ERROR = "xls_importError";
  private PlatformTransactionManager transactionManager;

  /**
   * @param file 数据文件
   * @param config 导入配置
   * @return
   * @throws Exception
   */
  public Object importData(
      CustomRetailscmUserContextImpl ctx, File file, ExcelDataImportConfig config)
      throws Exception {
    if (ObjectUtil.isEmpty(file)) {
      throw new IllegalArgumentException("缺少参数(数据文件): file");
    }

    if (ObjectUtil.isEmpty(config)) {
      throw new IllegalArgumentException("缺少参数(导入配置): config");
    }

    config.preProcess(ctx);

    List<Map<String, Object>> dataList = config.read(file);
    int batchSize = config.getBatchSize();

    validate(ctx, dataList, config);

    if (hasError(ctx)) {
      return report(ctx, file, config);
    }

    String taskName = taskName(ctx);
    String taskId = IdUtil.fastUUID();
    TaskUtil.runSingletonTaskAsync(
        taskName,
        () -> {
          GLOBAL_CONTEXT.set(ctx);
          try {
            int start = 0;
            while (start < dataList.size()) {
              List<Map<String, Object>> batchData =
                  CollectionUtil.sub(dataList, start, start + batchSize);
              importBatch(ctx, batchData, config);
              start = start + batchSize;
            }
            ctx.putToCache(
                taskId,
                MapUtil.builder()
                    .put("success", true)
                    .put("taskId", taskId)
                    .put("message", "导入任务完成!")
                    .put("finished", true)
                    .build(),
                600);
          } catch (Exception e) {
            e.printStackTrace();
            String message = StrUtil.format("系统错误，请联系管理员({})", e.getMessage());
            ctx.putToCache(
                taskId,
                MapUtil.builder()
                    .put("success", false)
                    .put("taskId", taskId)
                    .put("message", message)
                    .put("finished", true)
                    .build(),
                600);
          }
        });
    ctx.putToCache(
        taskId,
        MapUtil.builder()
            .put("taskId", taskId)
            .put("message", "任务正在生台运行！")
            .put("finished", false)
            .build(),
        600);
    return MapUtil.builder()
        .put("message", "任务已移到后台运行！")
        .put("taskId", taskId)
        .put("success", true)
        .map();
  }

  private void validate(
      CustomRetailscmUserContextImpl ctx,
      List<Map<String, Object>> dataList,
      ExcelDataImportConfig config) {
    Map<String, PropertyValidator[]> propertyValidators = config.getPropertyValidators();

    int dataRow = config.getDataStartRow() - 1;

    for (Map<String, Object> data : dataList) {
      dataRow++;
      if (isEmpty(data)) {
        continue;
      }
      RowPreProcessor rowPreProcessor = config.getRowPreProcessor();
      if (rowPreProcessor != null) {
        rowPreProcessor.processor(ctx, data, dataRow);
      }

      for (Map.Entry<String, PropertyValidator[]> entry : propertyValidators.entrySet()) {
        String k = entry.getKey();
        PropertyValidator[] validators = entry.getValue();
        for (PropertyValidator validator : validators) {
          String s = config.getPropertyMappings().get(k);
          if (ObjectUtil.isEmpty(s)) {
            continue;
          }
          String result = validator.validate(ctx, data, s, data.get(s));
          if (result == null) {
            continue;
          }
          saveError(ctx, config, dataRow, result, s);
        }
      }

      List<RowValidator> rowValidators = config.getRowValidators();
      for (RowValidator rowValidator : rowValidators) {
        String result = rowValidator.validate(ctx, data, dataRow);
        if (result == null) {
          continue;
        }
        saveError(ctx, config, dataRow, result);
      }
    }
  }

  private void saveError(
      UserContext ctx, ExcelDataImportConfig config, int dataRow, String result, String prop) {
    List<XlsImportError> errors = getXlsImportErrors(ctx);
    errors.add(new XlsImportError(dataRow, result, config.getMessages().getOrDefault(prop, prop)));
  }

  private void saveError(
      UserContext ctx, ExcelDataImportConfig config, int dataRow, String result) {
    List<XlsImportError> errors = getXlsImportErrors(ctx);
    errors.add(new XlsImportError(dataRow, result));
  }

  private List<XlsImportError> getXlsImportErrors(UserContext ctx) {
    List<XlsImportError> errors =
        (List<XlsImportError>) ctx.getFromContextLocalStorage(XLS_IMPORT_ERROR);
    if (errors == null) {
      errors = new ArrayList<>();
      ctx.putIntoContextLocalStorage(XLS_IMPORT_ERROR, errors);
    }
    return errors;
  }

  private Object report(UserContext ctx, File file, ExcelDataImportConfig config) {
    List<XlsImportError> errors = getXlsImportErrors(ctx);
    if (ObjectUtil.isEmpty(errors)) {
      return MapUtil.builder().put("message", "数据导入成功").put("success", true).map();
    }

    ExcelWriter writer = config.getWriter(file);
    int reportColumn = config.getReportColumn();
    for (List<XlsImportError> rowErrors : CollectionUtil.groupByField(errors, "row")) {
      int row = rowErrors.get(0).getRow();
      String rowError =
          rowErrors.stream()
              .map(
                  error -> {
                    String message = error.getMessage();
                    String property = error.getProperty();
                    String finalMessage = property == null ? message : property + ":" + message;
                    return finalMessage;
                  })
              .collect(Collectors.joining(";"));
      writer.writeCellValue(reportColumn, row, "验证失败:" + rowError);
    }

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    writer.flush(out);
    return MapUtil.builder()
        .put("file", Base64.encode(out.toByteArray()))
        .put("message", "数据导入失败")
        .put("success", false)
        .build();
  }

  private void importBatch(
      CustomRetailscmUserContextImpl ctx,
      List<Map<String, Object>> batchData,
      ExcelDataImportConfig config)
      throws Exception {
    if (ObjectUtil.isEmpty(batchData)) {
      return;
    }
    DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
    transactionDefinition.setPropagationBehavior(PROPAGATION_REQUIRES_NEW);
    TransactionStatus transaction = transactionManager.getTransaction(transactionDefinition);
    try {
      if (config.isInsert()) {
        insertNewRecords(ctx, batchData, config);
      } else if (config.isUpdate()) {
        updateRecords(ctx, batchData, config);
      } else if (config.isInsertOrUpdate()) {
        insertOrUpdate(ctx, batchData, config);
      }
      transactionManager.commit(transaction);
    } catch (Exception e) {
      transactionManager.rollback(transaction);
      throw e;
    }
  }

  private void insertOrUpdate(
      CustomRetailscmUserContextImpl ctx,
      List<Map<String, Object>> batchData,
      ExcelDataImportConfig config)
      throws Exception {
    String[] idProps = config.getIdProps();
    if (ObjectUtil.isEmpty(idProps)) {
      throw new ErrorMessageException("系统错误：在更新时需要指定id属性列表(不支持全表更改)");
    }

    Set<String> allPropertyNames = new HashSet<>(config.getPropertyMappings().keySet());
    allPropertyNames.addAll(config.getDefaultPropertyValues().keySet());
    allPropertyNames.removeAll(ListUtil.of(idProps));

    for (Map<String, Object> row : batchData) {
      if (isEmpty(row)) {
        continue;
      }
      Map<String, Object> goodData = getMappingData(ctx, config, row);
      BaseRequest request =
          genSearchRequest(
              ctx, goodData, idProps, config.getTargetType(), config.getRequestUpdate());
      BaseEntity item = Searcher.searchOne(ctx, request);

      if (item == null) {
        item = BaseEntityUtil.createEntity(config.getTargetType(), goodData);
      }
      updateItem(ctx, item, goodData, allPropertyNames);
      BaseEntityUtil.save(ctx, item);
    }
  }

  private void updateRecords(
      CustomRetailscmUserContextImpl ctx,
      List<Map<String, Object>> batchData,
      ExcelDataImportConfig config)
      throws Exception {
    String[] idProps = config.getIdProps();
    if (ObjectUtil.isEmpty(idProps)) {
      throw new ErrorMessageException("系统错误：在更新时需要指定id属性列表(不支持全表更改)");
    }

    Set<String> allPropertyNames = new HashSet<>(config.getPropertyMappings().keySet());
    allPropertyNames.addAll(config.getDefaultPropertyValues().keySet());
    allPropertyNames.removeAll(ListUtil.of(idProps));

    List<BaseEntity> batchItems = new ArrayList<>();
    for (Map<String, Object> row : batchData) {
      if (isEmpty(row)) {
        continue;
      }
      Map<String, Object> goodData = getMappingData(ctx, config, row);
      BaseRequest request =
          genSearchRequest(
              ctx, goodData, idProps, config.getTargetType(), config.getRequestUpdate());
      SmartList items = Searcher.search(ctx, request);
      if (ObjectUtil.isEmpty(items)) {
        continue;
      }
      for (Object item : items) {
        updateItem(ctx, (BaseEntity) item, goodData, allPropertyNames);
      }
      batchItems.addAll(items);
    }
    BaseEntityUtil.save(ctx, batchItems);
  }

  private void updateItem(
      CustomRetailscmUserContextImpl ctx,
      BaseEntity item,
      Map<String, Object> row,
      Set<String> updateProperties) {
    for (String updateProperty : updateProperties) {
      Object value = row.get(updateProperty);
      if (ObjectUtil.isNotEmpty(value)) {
        BaseEntityUtil.setFieldValue(item, updateProperty, value);
      }
    }
  }

  private BaseRequest genSearchRequest(
      CustomRetailscmUserContextImpl ctx,
      Map<String, Object> row,
      String[] idProps,
      Class<? extends BaseEntity> updateItemType,
      RequestUpdater requestUpdate) {
    Map<String, Object> ids = new HashMap<>();
    for (String idProp : idProps) {
      ids.put(idProp, row.get(idProp));
    }
    BaseEntity sampleRequest = BaseEntityUtil.createEntity(updateItemType, ids);
    BaseRequest reloadRequest = RetailscmBaseUtils.createReloadRequest(sampleRequest);
    RetailscmBaseUtils.enhanceRequest(reloadRequest);

    if (requestUpdate != null) {
      BaseRequest current = reloadRequest;
      while (current != null) {
        requestUpdate.updateRequest(reloadRequest);
        current = getParentRequest(current);
      }
    }
    return reloadRequest;
  }

  private BaseRequest getParentRequest(BaseRequest pCurrent) {
    return RetailscmBaseUtils.getParentRequest(pCurrent);
  }

  private void insertNewRecords(
      CustomRetailscmUserContextImpl ctx,
      List<Map<String, Object>> batchData,
      ExcelDataImportConfig config)
      throws Exception {
    List<BaseEntity> records = new ArrayList<>();
    for (Map<String, Object> batchDatum : batchData) {
      if (isEmpty(batchDatum)) {
        continue;
      }
      BaseEntity record = createRecord(ctx, batchDatum, config);
      records.add(record);
    }
    BaseEntityUtil.save(ctx, records);
  }

  private boolean isEmpty(Map<String, Object> batchDatum) {
    if (ObjectUtil.isEmpty(batchDatum)) {
      return true;
    }
    for (Object value : batchDatum.values()) {
      if (!ObjectUtil.isEmpty(value)) {
        return false;
      }
    }
    return true;
  }

  private BaseEntity createRecord(
      CustomRetailscmUserContextImpl ctx, Map<String, Object> oneRecord, DataImportConfig config)
      throws Exception {

    Map<String, Object> goodData = getMappingData(ctx, config, oneRecord);
    return BaseEntityUtil.createEntity(config.getTargetType(), goodData);
  }

  public static Map<String, Object> getMappingData(
      CustomRetailscmUserContextImpl ctx, DataImportConfig config, Map<String, Object> data)
      throws Exception {
    Map<String, Object> goodData = new HashMap<>(config.getDefaultPropertyValues());
    Map<String, String> mapping = config.getPropertyMappings();
    for (Map.Entry<String, String> entry : mapping.entrySet()) {
      String tName = entry.getKey();
      String sName = entry.getValue();
      PropertyConverter dataConverter = config.getDataConverter(tName);
      Object v = dataConverter.convert(ctx, data, data.get(sName), config.getTargetType(tName));
      goodData.put(tName, v);
    }
    return goodData;
  }

  private boolean hasError(CustomRetailscmUserContextImpl ctx) {
    return !ObjectUtil.isEmpty(getXlsImportErrors(ctx));
  }

  public PlatformTransactionManager getTransactionManager() {
    return transactionManager;
  }

  public void setTransactionManager(PlatformTransactionManager pTransactionManager) {
    transactionManager = pTransactionManager;
  }

  protected String taskName(CustomRetailscmUserContextImpl ctx) {
    return "dataImporter";
  }
}
