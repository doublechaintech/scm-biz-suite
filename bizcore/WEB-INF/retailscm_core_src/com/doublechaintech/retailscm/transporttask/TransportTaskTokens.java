package com.doublechaintech.retailscm.transporttask;

import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstore.RetailStoreTokens;
import com.doublechaintech.retailscm.truckdriver.TruckDriverTokens;
import com.doublechaintech.retailscm.transporttruck.TransportTruckTokens;
import com.doublechaintech.retailscm.transportfleet.TransportFleetTokens;
import com.doublechaintech.retailscm.goods.GoodsTokens;
import com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrackTokens;

public class TransportTaskTokens extends CommonTokens {

  static final String ALL = "__all__"; // do not assign this to common users.
  static final String SELF = "__self__";
  static final String OWNER_OBJECT_NAME = "transportTask";

  public static boolean checkOptions(Map<String, Object> options, String optionToCheck) {

    if (options == null) {
      return false; // completely no option here
    }
    if (options.containsKey(ALL)) {
      // danger, debug only, might load the entire database!, really terrible
      return true;
    }
    String ownerKey = getOwnerObjectKey();
    Object ownerObject = (String) options.get(ownerKey);
    if (ownerObject == null) {
      return false;
    }
    if (!ownerObject.equals(OWNER_OBJECT_NAME)) { // is the owner?
      return false;
    }

    if (options.containsKey(optionToCheck)) {
      // options.remove(optionToCheck);
      // consume the key, can not use any more to extract the data with the same token.
      return true;
    }

    return false;
  }

  protected TransportTaskTokens() {
    // ensure not initialized outside the class
  }

  public static TransportTaskTokens of(Map<String, Object> options) {
    // ensure not initialized outside the class
    TransportTaskTokens tokens = new TransportTaskTokens(options);
    return tokens;
  }

  protected TransportTaskTokens(Map<String, Object> options) {
    this.options = options;
  }

  public TransportTaskTokens merge(String[] tokens) {
    this.parseTokens(tokens);
    return this;
  }

  public static TransportTaskTokens mergeAll(String[] tokens) {

    return allTokens().merge(tokens);
  }

  protected TransportTaskTokens setOwnerObject(String objectName) {
    ensureOptions();
    addSimpleOptions(getOwnerObjectKey(), objectName);
    return this;
  }

  public static TransportTaskTokens start() {
    return new TransportTaskTokens().setOwnerObject(OWNER_OBJECT_NAME);
  }

  public TransportTaskTokens withTokenFromListName(String listName) {
    addSimpleOptions(listName);
    return this;
  }

  public static TransportTaskTokens loadGroupTokens(String... groupNames) {
    TransportTaskTokens tokens = start();
    if (groupNames == null || groupNames.length == 0) {
      return allTokens();
    }
    addToken(tokens, END, groupNames, new String[] {"default"});
    addToken(tokens, DRIVER, groupNames, new String[] {"default"});
    addToken(tokens, TRUCK, groupNames, new String[] {"default"});
    addToken(tokens, BELONGSTO, groupNames, new String[] {"default"});

    addToken(tokens, GOODS_LIST, groupNames, new String[] {"default"});

    addToken(tokens, TRANSPORT_TASK_TRACK_LIST, groupNames, new String[] {"default"});

    return tokens;
  }

  private static void addToken(
      TransportTaskTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
    if (pGroupNames == null || fieldGroups == null) {
      return;
    }

    for (String groupName : pGroupNames) {
      for (String g : fieldGroups) {
        if (Objects.equals(groupName, g)) {
          pTokens.addSimpleOptions(pTokenName);
          break;
        }
      }
    }
  }

  public static TransportTaskTokens filterWithTokenViewGroups(String[] viewGroups) {

    return start()
        .withEnd()
        .withDriver()
        .withTruck()
        .withBelongsTo()
        .withGoodsListIfViewGroupInclude(viewGroups)
        .withTransportTaskTrackListIfViewGroupInclude(viewGroups);
  }

  public static TransportTaskTokens allTokens() {

    return start()
        .withEnd()
        .withDriver()
        .withTruck()
        .withBelongsTo()
        .withGoodsList()
        .withTransportTaskTrackList();
  }

  public static TransportTaskTokens withoutListsTokens() {

    return start().withEnd().withDriver().withTruck().withBelongsTo();
  }

  public static Map<String, Object> all() {
    return allTokens().done();
  }

  public static Map<String, Object> withoutLists() {
    return withoutListsTokens().done();
  }

  public static Map<String, Object> empty() {
    return start().done();
  }

  public TransportTaskTokens analyzeAllLists() {
    addSimpleOptions(ALL_LISTS_ANALYZE);
    return this;
  }

  protected static final String END = "end";

  public String getEnd() {
    return END;
  }
  //
  public TransportTaskTokens withEnd() {
    addSimpleOptions(END);
    return this;
  }

  public RetailStoreTokens withEndTokens() {
    // addSimpleOptions(END);
    return RetailStoreTokens.start();
  }

  protected static final String DRIVER = "driver";

  public String getDriver() {
    return DRIVER;
  }
  //
  public TransportTaskTokens withDriver() {
    addSimpleOptions(DRIVER);
    return this;
  }

  public TruckDriverTokens withDriverTokens() {
    // addSimpleOptions(DRIVER);
    return TruckDriverTokens.start();
  }

  protected static final String TRUCK = "truck";

  public String getTruck() {
    return TRUCK;
  }
  //
  public TransportTaskTokens withTruck() {
    addSimpleOptions(TRUCK);
    return this;
  }

  public TransportTruckTokens withTruckTokens() {
    // addSimpleOptions(TRUCK);
    return TransportTruckTokens.start();
  }

  protected static final String BELONGSTO = "belongsTo";

  public String getBelongsTo() {
    return BELONGSTO;
  }
  //
  public TransportTaskTokens withBelongsTo() {
    addSimpleOptions(BELONGSTO);
    return this;
  }

  public TransportFleetTokens withBelongsToTokens() {
    // addSimpleOptions(BELONGSTO);
    return TransportFleetTokens.start();
  }

  protected static final String GOODS_LIST = "goodsList";

  public String getGoodsList() {
    return GOODS_LIST;
  }

  public TransportTaskTokens withGoodsListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(GOODS_LIST);
    }
    return this;
  }

  public TransportTaskTokens withGoodsList() {
    addSimpleOptions(GOODS_LIST);
    return this;
  }

  public GoodsTokens withGoodsListTokens() {
    // addSimpleOptions(GOODS_LIST);
    return GoodsTokens.start();
  }

  public TransportTaskTokens analyzeGoodsList() {
    addSimpleOptions(GOODS_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeGoodsListEnabled() {

    if (checkOptions(this.options(), GOODS_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public TransportTaskTokens extractMoreFromGoodsList(String idsSeperatedWithComma) {
    addSimpleOptions(GOODS_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int goodsListSortCounter = 0;

  public TransportTaskTokens sortGoodsListWith(String field, String descOrAsc) {
    addSortMoreOptions(GOODS_LIST, goodsListSortCounter++, field, descOrAsc);
    return this;
  }

  private int goodsListSearchCounter = 0;

  public TransportTaskTokens searchGoodsListWith(String field, String verb, String value) {

    withGoodsList();
    addSearchMoreOptions(GOODS_LIST, goodsListSearchCounter++, field, verb, value);
    return this;
  }

  public TransportTaskTokens searchAllTextOfGoodsList(String verb, String value) {
    String field = "id|name|rfid|uom";
    addSearchMoreOptions(GOODS_LIST, goodsListSearchCounter++, field, verb, value);
    return this;
  }

  public TransportTaskTokens rowsPerPageOfGoodsList(int rowsPerPage) {
    addSimpleOptions(GOODS_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public TransportTaskTokens currentPageNumberOfGoodsList(int currentPageNumber) {
    addSimpleOptions(GOODS_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public TransportTaskTokens retainColumnsOfGoodsList(String[] columns) {
    addSimpleOptions(GOODS_LIST + "RetainColumns", columns);
    return this;
  }

  public TransportTaskTokens excludeColumnsOfGoodsList(String[] columns) {
    addSimpleOptions(GOODS_LIST + "ExcludeColumns", columns);
    return this;
  }

  protected static final String TRANSPORT_TASK_TRACK_LIST = "transportTaskTrackList";

  public String getTransportTaskTrackList() {
    return TRANSPORT_TASK_TRACK_LIST;
  }

  public TransportTaskTokens withTransportTaskTrackListIfViewGroupInclude(String[] viewGroups) {

    if (isViewGroupOneOf("__no_group", viewGroups)) {
      addSimpleOptions(TRANSPORT_TASK_TRACK_LIST);
    }
    return this;
  }

  public TransportTaskTokens withTransportTaskTrackList() {
    addSimpleOptions(TRANSPORT_TASK_TRACK_LIST);
    return this;
  }

  public TransportTaskTrackTokens withTransportTaskTrackListTokens() {
    // addSimpleOptions(TRANSPORT_TASK_TRACK_LIST);
    return TransportTaskTrackTokens.start();
  }

  public TransportTaskTokens analyzeTransportTaskTrackList() {
    addSimpleOptions(TRANSPORT_TASK_TRACK_LIST + ".anaylze");
    return this;
  }

  public boolean analyzeTransportTaskTrackListEnabled() {

    if (checkOptions(this.options(), TRANSPORT_TASK_TRACK_LIST + ".anaylze")) {
      return true; // most of the case, should call here
    }
    // if not true, then query for global setting
    return checkOptions(this.options(), ALL_LISTS_ANALYZE);
  }

  public TransportTaskTokens extractMoreFromTransportTaskTrackList(String idsSeperatedWithComma) {
    addSimpleOptions(TRANSPORT_TASK_TRACK_LIST + ".extractIds", idsSeperatedWithComma);
    return this;
  }

  private int transportTaskTrackListSortCounter = 0;

  public TransportTaskTokens sortTransportTaskTrackListWith(String field, String descOrAsc) {
    addSortMoreOptions(
        TRANSPORT_TASK_TRACK_LIST, transportTaskTrackListSortCounter++, field, descOrAsc);
    return this;
  }

  private int transportTaskTrackListSearchCounter = 0;

  public TransportTaskTokens searchTransportTaskTrackListWith(
      String field, String verb, String value) {

    withTransportTaskTrackList();
    addSearchMoreOptions(
        TRANSPORT_TASK_TRACK_LIST, transportTaskTrackListSearchCounter++, field, verb, value);
    return this;
  }

  public TransportTaskTokens searchAllTextOfTransportTaskTrackList(String verb, String value) {
    String field = "id";
    addSearchMoreOptions(
        TRANSPORT_TASK_TRACK_LIST, transportTaskTrackListSearchCounter++, field, verb, value);
    return this;
  }

  public TransportTaskTokens rowsPerPageOfTransportTaskTrackList(int rowsPerPage) {
    addSimpleOptions(TRANSPORT_TASK_TRACK_LIST + "RowsPerPage", rowsPerPage);
    return this;
  }

  public TransportTaskTokens currentPageNumberOfTransportTaskTrackList(int currentPageNumber) {
    addSimpleOptions(TRANSPORT_TASK_TRACK_LIST + "CurrentPage", currentPageNumber);
    return this;
  }

  public TransportTaskTokens retainColumnsOfTransportTaskTrackList(String[] columns) {
    addSimpleOptions(TRANSPORT_TASK_TRACK_LIST + "RetainColumns", columns);
    return this;
  }

  public TransportTaskTokens excludeColumnsOfTransportTaskTrackList(String[] columns) {
    addSimpleOptions(TRANSPORT_TASK_TRACK_LIST + "ExcludeColumns", columns);
    return this;
  }

  public TransportTaskTokens searchEntireObjectText(String verb, String value) {

    searchAllTextOfGoodsList(verb, value);
    searchAllTextOfTransportTaskTrackList(verb, value);
    return this;
  }
}
