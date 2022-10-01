package com.doublechaintech.retailscm.stockcountissuetrack;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount;

@JsonSerialize(using = StockCountIssueTrackSerializer.class)
public class StockCountIssueTrack extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(StockCountIssueTrack target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String TITLE_PROPERTY = "title";
  public static final String COUNT_TIME_PROPERTY = "countTime";
  public static final String SUMMARY_PROPERTY = "summary";
  public static final String STOCK_COUNT_PROPERTY = "stockCount";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "StockCountIssueTrack";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(TITLE_PROPERTY, "title", "头衔").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(COUNT_TIME_PROPERTY, "count_time", "计数时间")
            .withType("date", Date.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(SUMMARY_PROPERTY, "summary", "概览")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(STOCK_COUNT_PROPERTY, "goods_shelf_stock_count", "盘点")
            .withType("goods_shelf_stock_count", GoodsShelfStockCount.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      TITLE_PROPERTY,
      COUNT_TIME_PROPERTY,
      SUMMARY_PROPERTY,
      STOCK_COUNT_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(STOCK_COUNT_PROPERTY, GoodsShelfStockCount.class);

    return parents;
  }
  /*
  public StockCountIssueTrack want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public StockCountIssueTrack wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getTitle();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String title;
  protected Date countTime;
  protected String summary;
  protected GoodsShelfStockCount stockCount;
  protected int version;

  public StockCountIssueTrack() {
    // lazy load for all the properties
  }

  public static StockCountIssueTrack withId(String id) {
    StockCountIssueTrack stockCountIssueTrack = new StockCountIssueTrack();
    stockCountIssueTrack.setId(id);
    stockCountIssueTrack.setVersion(Integer.MAX_VALUE);
    stockCountIssueTrack.setChecked(true);
    return stockCountIssueTrack;
  }

  public static StockCountIssueTrack refById(String id) {
    return withId(id);
  }

  public StockCountIssueTrack limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public StockCountIssueTrack limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static StockCountIssueTrack searchExample() {
    StockCountIssueTrack stockCountIssueTrack = new StockCountIssueTrack();
    stockCountIssueTrack.setVersion(UNSET_INT);

    return stockCountIssueTrack;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setStockCount( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (TITLE_PROPERTY.equals(property)) {
      changeTitleProperty(newValueExpr);
    }
    if (COUNT_TIME_PROPERTY.equals(property)) {
      changeCountTimeProperty(newValueExpr);
    }
    if (SUMMARY_PROPERTY.equals(property)) {
      changeSummaryProperty(newValueExpr);
    }
  }

  protected void changeTitleProperty(String newValueExpr) {

    String oldValue = getTitle();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateTitle(newValue);
    this.onChangeProperty(TITLE_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeCountTimeProperty(String newValueExpr) {

    Date oldValue = getCountTime();
    Date newValue = parseDate(newValueExpr);
    if (equalsDate(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateCountTime(newValue);
    this.onChangeProperty(COUNT_TIME_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeSummaryProperty(String newValueExpr) {

    String oldValue = getSummary();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateSummary(newValue);
    this.onChangeProperty(SUMMARY_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (TITLE_PROPERTY.equals(property)) {
      return getTitle();
    }
    if (COUNT_TIME_PROPERTY.equals(property)) {
      return getCountTime();
    }
    if (SUMMARY_PROPERTY.equals(property)) {
      return getSummary();
    }
    if (STOCK_COUNT_PROPERTY.equals(property)) {
      return getStockCount();
    }

    // other property not include here
    return super.propertyOf(property);
  }

  public void setId(String id) {
    String oldId = this.id;
    String newId = trimString(id);
    this.id = newId;
  }

  public String id() {
    doLoad();
    return getId();
  }

  public String getId() {
    return this.id;
  }

  public StockCountIssueTrack updateId(String id) {
    String oldId = this.id;
    String newId = trimString(id);
    if (!shouldReplaceBy(newId, oldId)) {
      return this;
    }
    this.id = newId;
    if (cn.hutool.core.util.ObjectUtil.equals(newId, oldId)) {
      return this;
    }
    addPropertyChange(ID_PROPERTY, oldId, newId);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public StockCountIssueTrack orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public StockCountIssueTrack ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public StockCountIssueTrack addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setTitle(String title) {
    String oldTitle = this.title;
    String newTitle = trimString(title);
    this.title = newTitle;
  }

  public String title() {
    doLoad();
    return getTitle();
  }

  public String getTitle() {
    return this.title;
  }

  public StockCountIssueTrack updateTitle(String title) {
    String oldTitle = this.title;
    String newTitle = trimString(title);
    if (!shouldReplaceBy(newTitle, oldTitle)) {
      return this;
    }
    this.title = newTitle;
    if (cn.hutool.core.util.ObjectUtil.equals(newTitle, oldTitle)) {
      return this;
    }
    addPropertyChange(TITLE_PROPERTY, oldTitle, newTitle);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public StockCountIssueTrack orderByTitle(boolean asc) {
    doAddOrderBy(TITLE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createTitleCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(TITLE_PROPERTY, operator, parameters);
  }

  public StockCountIssueTrack ignoreTitleCriteria() {
    super.ignoreSearchProperty(TITLE_PROPERTY);
    return this;
  }

  public StockCountIssueTrack addTitleCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createTitleCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeTitle(String title) {
    if (title != null) {
      updateTitle(title);
    }
  }

  public void setCountTime(Date countTime) {
    Date oldCountTime = this.countTime;
    Date newCountTime = countTime;
    this.countTime = newCountTime;
  }

  public Date countTime() {
    doLoad();
    return getCountTime();
  }

  public Date getCountTime() {
    return this.countTime;
  }

  public StockCountIssueTrack updateCountTime(Date countTime) {
    Date oldCountTime = this.countTime;
    Date newCountTime = countTime;
    if (!shouldReplaceBy(newCountTime, oldCountTime)) {
      return this;
    }
    this.countTime = newCountTime;
    if (cn.hutool.core.util.ObjectUtil.equals(newCountTime, oldCountTime)) {
      return this;
    }
    addPropertyChange(COUNT_TIME_PROPERTY, oldCountTime, newCountTime);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public StockCountIssueTrack orderByCountTime(boolean asc) {
    doAddOrderBy(COUNT_TIME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCountTimeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(COUNT_TIME_PROPERTY, operator, parameters);
  }

  public StockCountIssueTrack ignoreCountTimeCriteria() {
    super.ignoreSearchProperty(COUNT_TIME_PROPERTY);
    return this;
  }

  public StockCountIssueTrack addCountTimeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCountTimeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCountTime(Date countTime) {
    updateCountTime(countTime);
  }

  public void setSummary(String summary) {
    String oldSummary = this.summary;
    String newSummary = trimString(summary);
    this.summary = newSummary;
  }

  public String summary() {
    doLoad();
    return getSummary();
  }

  public String getSummary() {
    return this.summary;
  }

  public StockCountIssueTrack updateSummary(String summary) {
    String oldSummary = this.summary;
    String newSummary = trimString(summary);
    if (!shouldReplaceBy(newSummary, oldSummary)) {
      return this;
    }
    this.summary = newSummary;
    if (cn.hutool.core.util.ObjectUtil.equals(newSummary, oldSummary)) {
      return this;
    }
    addPropertyChange(SUMMARY_PROPERTY, oldSummary, newSummary);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public StockCountIssueTrack orderBySummary(boolean asc) {
    doAddOrderBy(SUMMARY_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createSummaryCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(SUMMARY_PROPERTY, operator, parameters);
  }

  public StockCountIssueTrack ignoreSummaryCriteria() {
    super.ignoreSearchProperty(SUMMARY_PROPERTY);
    return this;
  }

  public StockCountIssueTrack addSummaryCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createSummaryCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeSummary(String summary) {
    if (summary != null) {
      updateSummary(summary);
    }
  }

  public void setStockCount(GoodsShelfStockCount stockCount) {
    GoodsShelfStockCount oldStockCount = this.stockCount;
    GoodsShelfStockCount newStockCount = stockCount;
    this.stockCount = newStockCount;
  }

  public GoodsShelfStockCount stockCount() {
    doLoad();
    return getStockCount();
  }

  public GoodsShelfStockCount getStockCount() {
    return this.stockCount;
  }

  public StockCountIssueTrack updateStockCount(GoodsShelfStockCount stockCount) {
    GoodsShelfStockCount oldStockCount = this.stockCount;
    GoodsShelfStockCount newStockCount = stockCount;
    if (!shouldReplaceBy(newStockCount, oldStockCount)) {
      return this;
    }
    this.stockCount = newStockCount;
    if (cn.hutool.core.util.ObjectUtil.equals(newStockCount, oldStockCount)) {
      return this;
    }
    addPropertyChange(STOCK_COUNT_PROPERTY, oldStockCount, newStockCount);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public StockCountIssueTrack orderByStockCount(boolean asc) {
    doAddOrderBy(STOCK_COUNT_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createStockCountCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(STOCK_COUNT_PROPERTY, operator, parameters);
  }

  public StockCountIssueTrack ignoreStockCountCriteria() {
    super.ignoreSearchProperty(STOCK_COUNT_PROPERTY);
    return this;
  }

  public StockCountIssueTrack addStockCountCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createStockCountCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeStockCount(GoodsShelfStockCount stockCount) {
    if (stockCount != null) {
      updateStockCount(stockCount);
    }
  }

  public StockCountIssueTrack updateStockCountByReferenceId(String stockCountId) {
    updateStockCount(GoodsShelfStockCount.refById(stockCountId));
    return this;
  }

  public void clearStockCount() {
    setStockCount(null);
    this.changed = true;
    setChecked(false);
  }

  public void setVersion(int version) {
    int oldVersion = this.version;
    int newVersion = version;
    this.version = newVersion;
  }

  public int version() {
    doLoad();
    return getVersion();
  }

  public int getVersion() {
    return this.version;
  }

  public StockCountIssueTrack updateVersion(int version) {
    int oldVersion = this.version;
    int newVersion = version;
    if (!shouldReplaceBy(newVersion, oldVersion)) {
      return this;
    }
    this.version = newVersion;
    if (cn.hutool.core.util.ObjectUtil.equals(newVersion, oldVersion)) {
      return this;
    }
    addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public StockCountIssueTrack orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public StockCountIssueTrack ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public StockCountIssueTrack addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getStockCount(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, TITLE_PROPERTY, getTitle());
    appendKeyValuePair(result, COUNT_TIME_PROPERTY, getCountTime());
    appendKeyValuePair(result, SUMMARY_PROPERTY, getSummary());
    appendKeyValuePair(result, STOCK_COUNT_PROPERTY, getStockCount());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof StockCountIssueTrack) {

      StockCountIssueTrack dest = (StockCountIssueTrack) baseDest;

      dest.setId(getId());
      dest.setTitle(getTitle());
      dest.setCountTime(getCountTime());
      dest.setSummary(getSummary());
      dest.setStockCount(getStockCount());
      dest.setVersion(getVersion());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof StockCountIssueTrack) {

      StockCountIssueTrack source = (StockCountIssueTrack) sourceEntity;

      mergeId(source.getId());
      mergeTitle(source.getTitle());
      mergeCountTime(source.getCountTime());
      mergeSummary(source.getSummary());
      mergeStockCount(source.getStockCount());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof StockCountIssueTrack) {

      StockCountIssueTrack source = (StockCountIssueTrack) sourceEntity;

      mergeId(source.getId());
      mergeTitle(source.getTitle());
      mergeCountTime(source.getCountTime());
      mergeSummary(source.getSummary());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(), getTitle(), getCountTime(), getSummary(), getStockCount(), getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    StockCountIssueTrack checkStockCountIssueTrack =
        Q.stockCountIssueTrackWithIdField().filterById(id).execute(ctx);

    return checkStockCountIssueTrack != null
        && !checkStockCountIssueTrack.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public StockCountIssueTrack save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("StockCountIssueTrack{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\ttitle='" + getTitle() + "';");
    stringBuilder.append("\tcountTime='" + getCountTime() + "';");
    stringBuilder.append("\tsummary='" + getSummary() + "';");
    if (getStockCount() != null) {
      stringBuilder.append("\tstockCount='GoodsShelfStockCount(" + getStockCount().getId() + ")';");
    }
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
