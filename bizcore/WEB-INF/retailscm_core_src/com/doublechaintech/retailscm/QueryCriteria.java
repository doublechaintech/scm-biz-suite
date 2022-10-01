package com.doublechaintech.retailscm;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.terapico.caf.DateTime;
import com.terapico.caf.Images;

/*
 * 支持多个字段或的操作，比如
 *
 * name|title|content    contains 'super'
 * 会被解析成 where name contains ? or title contains ?
 * */
class QueryElement extends BaseEntity {
  protected Object[] wrapToArray(Object value) {

    return new Object[] {value};
  }

  protected String mapToInternalColumn(String field) {
    char[] fieldArray = field.toCharArray();
    StringBuilder internalFieldBuffer = new StringBuilder();

    for (char ch : fieldArray) {
      if (Character.isUpperCase(ch)) {
        internalFieldBuffer.append('_');
        char lowerCaseChar = Character.toLowerCase(ch);
        internalFieldBuffer.append(lowerCaseChar);
        continue;
      }
      internalFieldBuffer.append(ch);
    }
    return internalFieldBuffer.toString();
  }

  protected void setToDayBegin(final Calendar cal) {

    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
  }

  protected void setToDayEnd(final Calendar cal) {

    cal.set(Calendar.HOUR_OF_DAY, 23);
    cal.set(Calendar.MINUTE, 59);
    cal.set(Calendar.SECOND, 59);
    cal.set(Calendar.MILLISECOND, 999);
  }

  protected Date localYearBegin() {
    Calendar cal = Calendar.getInstance();
    // cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
    cal.set(Calendar.DAY_OF_YEAR, 1);
    setToDayBegin(cal);

    return cal.getTime();
  }

  protected Date localMonthBegin() {
    Calendar cal = Calendar.getInstance();
    // cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
    // cal.set(Calendar.MONTH, cal.get(Calendar.MONTH));
    cal.set(Calendar.DAY_OF_MONTH, 1);
    setToDayBegin(cal);
    return cal.getTime();
  }

  protected Date localWeekBegin() {
    Calendar cal = Calendar.getInstance();
    // cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
    // cal.set(Calendar.WEEK_OF_YEAR, cal.get(Calendar.WEEK_OF_YEAR));
    cal.set(Calendar.DAY_OF_WEEK, 1);
    setToDayBegin(cal);
    return cal.getTime();
  }

  protected Date localDayBegin() {
    Calendar cal = Calendar.getInstance();
    // cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
    // cal.set(Calendar.WEEK_OF_YEAR, cal.get(Calendar.WEEK_OF_YEAR));
    setToDayBegin(cal);
    return cal.getTime();
  }

  protected Date localYearEnd() {
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.YEAR, 1 + cal.get(Calendar.YEAR));
    cal.set(Calendar.DAY_OF_YEAR, 1);
    this.setToDayBegin(cal);
    cal.add(Calendar.MILLISECOND, -1);
    return cal.getTime();
  }

  protected Date localMonthEnd() {
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
    cal.set(Calendar.MONTH, 1 + cal.get(Calendar.MONTH));
    cal.set(Calendar.DAY_OF_MONTH, 1);
    setToDayBegin(cal);
    cal.add(Calendar.MILLISECOND, -1);
    return cal.getTime();
  }

  protected Date localWeekEnd() {
    Calendar cal = Calendar.getInstance();
    // cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
    // cal.set(Calendar.MONTH,1+cal.get(Calendar.MONTH));
    cal.setFirstDayOfWeek(Calendar.MONDAY);
    cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
    setToDayEnd(cal);

    return cal.getTime();
  }

  protected Date localDayEnd() {
    Calendar cal = Calendar.getInstance();
    // cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
    // cal.set(Calendar.MONTH,1+cal.get(Calendar.MONTH));

    setToDayEnd(cal);

    return cal.getTime();
  }

  protected Object[] today() {
    Date start = this.localDayBegin();
    Date end = this.localDayEnd();

    return new Object[] {start, end};
  }

  protected Object[] thisWeek() {
    Date start = this.localWeekBegin();
    Date end = this.localWeekEnd();

    return new Object[] {start, end};
  }

  protected Object[] thisMonth() {
    Date start = this.localMonthBegin();
    Date end = this.localMonthEnd();

    return new Object[] {start, end};
  }

  protected Object[] thisQuater() {
    Date start = new Date();
    Date end = new Date();

    return new Object[] {start, end};
  }

  protected Object[] lastQuater() {
    Date start = new Date();
    Date end = new Date();

    return new Object[] {start, end};
  }

  protected Object[] thisYear() {
    Date start = this.localYearBegin();
    Date end = this.localYearEnd();

    return new Object[] {start, end};
  }

  protected void checkFieldName(String field) {

    if (field.length() > 50) {
      String message = "The field name: " + field + " length(" + field.length() + ") is more 50!";
      throw new IllegalArgumentException(message);
    }

    char[] fieldCharArray = field.toCharArray();
    for (char ch : fieldCharArray) {
      if (isValidFieldChar(ch)) {
        continue;
      }
      String message = "Found invalid char <" + ch + "> from the field name: " + field;
      throw new IllegalArgumentException(message);
    }
  }
}

class PowerFilter extends Filter {

  protected boolean isSingleSearch() {

    int index = this.getSearchField().indexOf('|');
    return index < 0;
  }

  protected void checkFieldName(String field) {
    if (isSingleSearch()) {
      super.checkFieldName(field);
      return;
    }
    String fields[] = getFields();
    for (String fieldName : fields) {
      super.checkFieldName(fieldName);
    }
  }

  protected String[] getFields() {

    return getSearchField().split("\\|");
  }

  public String getWhereClause() {

    if (isSingleSearch()) {
      return super.getWhereClause();
    }
    // handle multiple search

    String fields[] = getFields();

    StringBuilder whereSQL = new StringBuilder();

    whereSQL.append('(');

    int index = 0;
    for (String field : fields) {

      if (index > 0) {
        whereSQL.append(" or ");
      }
      whereSQL.append(join(mapToInternalColumn(field), " ", getVerbSQL()));
      index++;
    }
    whereSQL.append(')');

    return whereSQL.toString();
  }

  public Object[] getWhereParameters() {

    if (isSingleSearch()) {
      return super.getWhereParameters();
    }
    // handle multiple search
    int count = getFields().length;
    Object[] singleResult = wrapParameters(this.getSearchVerb(), this.getSearchValue());
    int singleLength = singleResult.length;
    Object result[] = new Object[count * singleLength];

    for (int i = 0; i < count; i++) {
      System.arraycopy(singleResult, 0, result, i * singleLength, singleLength);
    }

    return result;
  }
}

class Filter extends QueryElement {

  private String searchField;
  private String searchVerb;
  private String searchValue;

  public String getSearchField() {
    return searchField;
  }

  public void setSearchField(String searchField) {

    this.searchField = searchField;
  }

  public String getSearchVerb() {
    return searchVerb;
  }

  public void setSearchVerb(String searchVerb) {
    verifyVerb(searchVerb);

    this.searchVerb = searchVerb;
  }

  public String getSearchValue() {
    return searchValue;
  }

  public void setSearchValue(String searchValue) {
    this.searchValue = searchValue;
  }

  static Map<String, String> statementMap;

  protected void initStatementMap() {
    if (statementMap != null) {
      return;
    }
    statementMap = new HashMap<String, String>();

    statementMap.put("between", "between ? and ?");
    statementMap.put("startsWith", "like ?");
    statementMap.put("endsWith", "like ?");
    statementMap.put("contains", "like ?");
    statementMap.put("range", "between ? and ?");
    statementMap.put("is", "= ?");
    statementMap.put("not", "<> ?");
    statementMap.put("eq", "= ?");
    statementMap.put("gt", "> ?");
    statementMap.put("gte", ">= ?");
    statementMap.put("lt", "< ?");
    statementMap.put("lte", "<= ?");
    statementMap.put(VERB_ONEOF, CALC_STATEMENT);
  }

  protected static final String CALC_STATEMENT = "__calc__";
  protected static final String VERB_ONEOF = "oneof";
  protected static final String NONE_OF = "noneof";

  protected void verifyVerb(String verb) {
    initStatementMap();
    String statement = statementMap.get(verb);
    if (statement == null) {
      throw new IllegalStateException("The verb '" + verb + "' is not supported for now!");
    }
  }

  protected String includeStatementOfArray(Object[] array) {

    String SQL = " in (" + repeatExpr("?", ",", array.length) + ")";

    return SQL;
  }

  protected String excludeStatementOfArray(Object[] array) {

    String SQL = " not in (" + repeatExpr("?", ",", array.length) + ")";

    return SQL;
  }

  protected String overrideStatement(String statement) {

    if (statement.equals(VERB_ONEOF)) {
      Object[] parameters = this.wrapParameters(VERB_ONEOF, this.searchValue);
      return includeStatementOfArray(parameters);
    }
    if (statement.equals(NONE_OF)) {
      Object[] parameters = this.wrapParameters(NONE_OF, this.searchValue);
      return excludeStatementOfArray(parameters);
    }

    throw new IllegalArgumentException(
        "Override for verb: '" + statement + "' is not supported for now");
  }

  protected String getVerbSQL() {

    verifyVerb(searchVerb);
    String statement = statementMap.get(searchVerb);
    // override with calc

    if (CALC_STATEMENT.equals(statement)) {

      return overrideStatement(searchVerb);
    }

    // already checked
    return statement;
  }

  /*
  protected Object[] lastMonth(String value){
  	Date start = new Date();
  	Date end = new Date();

  	return new Object[]{start, end};
  }
  protected Object[] lastWeek(String value){
  	Date start = new Date();
  	Date end = new Date();

  	return new Object[]{start, end};
  }
  protected Object[] yesterday(String value){
  	Date start = new Date();
  	Date end = new Date();

  	return new Object[]{start, end};
  }
  protected Object[] tomorrow(String value){
  	Date start = new Date();
  	Date end = new Date();

  	return new Object[]{start, end};
  }
  */
  protected Object[] wrapParameters(String verb, String value) {

    // Map<String, Object[]> parametersMap = new HashMap<String, Object[]>();

    if ("startsWith".equals(verb)) {
      return wrapToArray(join(value, "%"));
    }
    if ("endsWith".equals(verb)) {
      return wrapToArray(join("%", value));
    }
    if ("contains".equals(verb)) {
      return wrapToArray(join("%", value, "%"));
    }
    if ("range".equals(verb)) {
      if ("today".equals(value)) {
        return this.today();
      }
      if ("past".equals(value)) {
        return this.past();
      }
      String[] values = value.split("~");
      return values;
    }
    if ("between".equals(verb)) {
      if ("today".equals(value)) {
        return this.today();
      }
      String[] values = value.split("~");

      return values;
    }
    if (VERB_ONEOF.equals(verb)) {
      String[] values = value.split("\\|");
      return values;
    }
    if (NONE_OF.equals(verb)) {
      String[] values = value.split("\\|");
      return values;
    }
    if ("today".equals(value)) {
      return this.today();
    }
    if ("past".equals(value)) {
      return this.past();
    }
    if ("thisyear".equals(value)) {
      return this.thisYear();
    }
    if ("thisweek".equals(value)) {
      return this.thisWeek();
    }
    if ("thismonth".equals(value)) {
      return this.thisMonth();
    }
    // eq or something other
    return wrapToArray(value);
  }

  protected Object[] pastDate() {
    // TODO Auto-generated method stub
    Date start = this.timeStart();
    Date end = this.timeNow();

    return new Object[] {start, end};
  }

  protected Object[] past() {
    // TODO Auto-generated method stub
    Date start = this.timeStart();
    Date end = this.timeNow();

    return new Object[] {start, end};
  }

  private Date dateStart() {
    // TODO Auto-generated method stub
    return new Date(0);
  }

  private Date todayEnd() {
    // TODO Auto-generated method stub
    return new Date();
  }

  private DateTime timeStart() {
    // TODO Auto-generated method stub
    return new DateTime(0);
  }

  private DateTime timeNow() {
    // TODO Auto-generated method stub
    //		return new Date();
    //		return new Timestamp(System.currentTimeMillis());
    return DateTime.now();
  }

  public String getWhereClause() {
    return join(mapToInternalColumn(searchField), " ", getVerbSQL());
  }

  public Object[] getWhereParameters() {

    if (this.getSearchVerb() == null) {
      return new Object[] {};
    }
    if (this.getSearchVerb().equals("")) {
      return new Object[] {};
    }

    if (this.getSearchValue() == null) {
      return new Object[] {};
    }
    if (this.getSearchValue().equals("")) {
      return new Object[] {};
    }

    return wrapParameters(this.getSearchVerb(), this.getSearchValue());
  }
}

class Sorter extends QueryElement {

  private String sortField;
  private String sortDescOrAsc;

  public String getSortField() {
    return sortField;
  }

  public void setSortField(String sortField) {
    this.checkFieldName(sortField);
    this.sortField = sortField;
  }

  public String getSortDescOrAsc() {
    return sortDescOrAsc;
  }

  public void setSortDescOrAsc(String sortDescOrAsc) {
    this.sortDescOrAsc = sortDescOrAsc;
  }

  public String getOrderByClause() {
    return join(mapToInternalColumn(this.sortField), " ", this.sortDescOrAsc);
  }
  // TODO DUPLICATTE METHOD
  protected String mapToInternalColumn(String field) {
    char[] fieldArray = field.toCharArray();
    StringBuilder internalFieldBuffer = new StringBuilder();

    for (char ch : fieldArray) {
      if (Character.isUpperCase(ch)) {
        internalFieldBuffer.append('_');
        char lowerCaseChar = Character.toLowerCase(ch);
        internalFieldBuffer.append(lowerCaseChar);
        continue;
      }
      internalFieldBuffer.append(ch);
    }
    return internalFieldBuffer.toString();
  }
}

class CommonInfo {
  private String name;
  private String localeKey;
  private String presentName;

  public String getName() {
    return name;
  }

  public String getPresentName() {
    return presentName;
  }

  public void setPresentName(String presentName) {
    this.presentName = presentName;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocaleKey() {
    return localeKey;
  }

  public void setLocaleKey(String localeKey) {
    this.localeKey = localeKey;
  }
}

class SearchField extends CommonInfo {}

class SortType extends CommonInfo {}

public class QueryCriteria extends BaseEntity {

  /**
   * customList.searchField=name customList.searchVerb=startsWith/eq/contains/endsWith/range(between
   * and)/between customList.searchValue=Philip customList.searchResultOrderBy=name
   * customList.searchResultOrder=desc/asc
   */
  private static final long serialVersionUID = 1L;

  private List<Filter> moreFilters;
  private List<Sorter> moreSorters;

  public List<Sorter> getMoreSorters() {
    if (moreSorters == null) {
      moreSorters = new ArrayList<Sorter>();
    }
    return moreSorters;
  }

  public void setMoreSorters(List<Sorter> moreSorters) {
    this.moreSorters = moreSorters;
  }

  public List<Filter> getMoreFilters() {
    if (moreFilters == null) {
      moreFilters = new ArrayList<Filter>();
    }
    return moreFilters;
  }

  protected QueryCriteria addFilter(Filter filter) {
    if (filter == null) {
      throw new IllegalArgumentException("addFilter(Filter filter): filter can not be null");
    }
    this.getMoreFilters().add(filter);
    return this;
  }

  public void setMoreFilters(List<Filter> moreFilters) {
    this.moreFilters = moreFilters;
  }

  public static QueryCriteria createCriteriaFromOptions(
      String listName, Map<String, Object> options) {

    QueryCriteria criteria = new QueryCriteria();

    Filter filter =
        criteria.createFilter(
            getOptionsValue(listName, "searchField", options),
            getOptionsValue(listName, "searchVerb", options),
            getOptionsValue(listName, "searchValue", options));

    if (filter != null) {
      criteria.addFilter(filter); // 没办法，兼容老的标准
    }

    for (int i = 0; i < 20; i++) {

      filter =
          criteria.createFilter(
              getOptionsValue(listName, "searchField" + "." + i, options),
              getOptionsValue(listName, "searchVerb" + "." + i, options),
              getOptionsValue(listName, "searchValue" + "." + i, options));
      if (filter == null) {
        // no break from 0, there are some old code use new code, it stars from 1
        break;
      }
      criteria.addFilter(filter);
    }

    Sorter sorter =
        criteria.createSorter(
            getOptionsValue(listName, "orderBy", options),
            getOptionsValue(listName, "descOrAsc", options));

    if (sorter != null) {
      criteria.addSorter(sorter); // 没办法，兼容老的标准
    }

    for (int i = 0; i < 20; i++) {

      sorter =
          criteria.createSorter(
              getOptionsValue(listName, "orderBy" + "." + i, options),
              getOptionsValue(listName, "descOrAsc" + "." + i, options));
      if (sorter == null) {
        // no break from 0, there are some old code use new code, it stars from 1
        break;
      }
      criteria.addSorter(sorter);
    }

    return criteria;
  }

  protected QueryCriteria addSorter(Sorter sorter) {
    if (sorter == null) {
      throw new IllegalArgumentException("addSorter(Sorter sorter): sorter can not be null");
    }
    this.getMoreSorters().add(sorter);
    return this;
  }

  protected static String getOptionsValue(
      String listName, String key, Map<String, Object> options) {
    Object obj = options.get(listName + "." + key);
    if (obj == null) {
      return null;
    }
    return obj.toString();
  }

  public static QueryCriteria createCriteria(
      String field, String verb, String value, String orderBy, String descOrAsc) {

    QueryCriteria criteria = new QueryCriteria();

    criteria.addFilter(criteria.createFilter(field, verb, value));
    criteria.addSorter(criteria.createSorter(orderBy, descOrAsc));

    return criteria;
  }

  public boolean hasStatement() {
    if (!this.getMoreFilters().isEmpty()) {
      return true;
    }

    if (!this.getMoreSorters().isEmpty()) {
      return true;
    }

    return false;
  }

  public String getSQL() {
    String sorterSQL = getSorterSQL();
    String filterSQL = getFilterSQL();
    if (filterSQL != null) {
      return join(" and ", filterSQL, " ", sorterSQL);
    }
    return sorterSQL;
  }

  protected String getFilterSQL() {
    // TODO Auto-generated method stub

    if (this.getMoreFilters().isEmpty()) {
      return null;
    }
    // there are more sorters;

    StringBuilder stringBuilder = new StringBuilder(100);

    int counter = 0;
    for (Filter filter : getMoreFilters()) {
      if (counter > 0) {
        stringBuilder.append(" and ");
      }
      counter++;
      stringBuilder.append(filter.getWhereClause());
    }
    return stringBuilder.toString();
  }

  protected String getSorterSQL() {
    if (this.getMoreSorters().isEmpty()) {
      return "";
    }

    StringBuilder stringBuilder = new StringBuilder(100);
    stringBuilder.append("order by ");
    int counter = 0;
    for (Sorter sorter : getMoreSorters()) {
      if (counter > 0) {
        stringBuilder.append(",");
      }
      counter++;
      stringBuilder.append(sorter.getOrderByClause());
    }
    return stringBuilder.toString();
  }

  public Object[] getParameters() {

    if (this.getMoreFilters().isEmpty()) {

      return new Object[] {};
    }

    List<Object> parameters = new ArrayList<Object>();

    for (Filter filter : getMoreFilters()) {
      // stringBuilder.append(filter.getWhereClause());
      parameters.addAll(Arrays.asList(filter.getWhereParameters()));
    }

    return parameters.toArray();
    // uncertain parameters

  }

  private String showParameters() {
    StringBuilder internalPresentBuffer = new StringBuilder();
    internalPresentBuffer.append('[');

    for (Filter filter : this.getMoreFilters()) {
      String parameters = this.joinWithDelimitter(", ", filter.getWhereParameters());
      internalPresentBuffer.append(parameters);
    }

    internalPresentBuffer.append(']');
    return internalPresentBuffer.toString();
  }

  protected Filter createFilter(String field, String verb, String value) {
    if (isEmptyOrNull(field)) {
      return null;
    }
    if (isEmptyOrNull(verb)) {
      return null;
    }
    if (isEmptyOrNull(value)) {
      // return null;
    }

    Filter filter = creteNewFilter();
    filter.setSearchField(field);
    filter.setSearchVerb(verb);
    filter.setSearchValue(value);
    return filter;
  }

  protected boolean isValidFieldChar(char fieldChar) {

    // Character.isAlphabetic(codePoint);
    if (fieldChar >= '0' && fieldChar <= '9') {
      return true;
    }
    if (fieldChar >= 'A' && fieldChar <= 'Z') {
      return true;
    }
    if (fieldChar >= 'a' && fieldChar <= 'z') {
      return true;
    }
    if (fieldChar == '_') {
      return true;
    }
    if (fieldChar == '|') {
      return true;
    }

    return false;
  }

  protected List<SearchField> getCandidateFields() {
    List<SearchField> fields = new ArrayList<SearchField>();
    SearchField field = new SearchField();
    field.setName("id");
    field.setLocaleKey("@id");
    field.setPresentName("序号");

    fields.add(field);

    return fields;
  }

  protected final List<SortType> getCandidateSortTypes() {
    List<SortType> fields = new ArrayList<SortType>();
    SortType sortType = new SortType();
    sortType.setName("asc");
    sortType.setLocaleKey("@asc");
    sortType.setPresentName("正序");

    fields.add(sortType);
    sortType = new SortType();
    sortType.setName("desc");
    sortType.setLocaleKey("@desc");
    sortType.setPresentName("倒序");
    fields.add(sortType);
    return fields;
  }

  protected boolean isEmptyOrNull(String value) {
    if (value == null) {
      return true;
    }
    if (value.isEmpty()) {
      return true;
    }
    return false;
  }

  protected Sorter createSorter(String sortField, String descOrAsc) {
    if (isEmptyOrNull(sortField)) {
      return null;
    }
    if (isEmptyOrNull(descOrAsc)) {
      return null;
    }
    Sorter sorter = creteNewSorter();
    sorter.setSortField(sortField);
    sorter.setSortDescOrAsc(descOrAsc);
    return sorter;
  }

  protected Sorter creteNewSorter() {
    return new Sorter();
  }

  protected Filter creteNewFilter() {
    return new PowerFilter();
  }

  public static void main(String[] args) {
    Filter f = new Filter();

    System.out.println(f.localWeekEnd());
    System.out.println(f.localMonthEnd());
    System.out.println(f.localYearEnd());
    System.out.println(f.localDayEnd());

    System.out.println(f.localWeekBegin());
    System.out.println(f.localMonthBegin());
    System.out.println(f.localYearBegin());
    System.out.println(f.localDayBegin());

    QueryCriteria qc = QueryCriteria.createCriteria("name", "startsWith", "philip", "age", "asc");

    System.out.println(qc.getSQL() + " " + qc.showParameters());

    qc = QueryCriteria.createCriteria("name", "is", "philip", "age", "asc");

    System.out.println(qc.getSQL() + " " + qc.showParameters());

    qc = QueryCriteria.createCriteria("name|desc", "contains", "philip", "age", "asc");

    System.out.println(qc.getSQL() + " " + qc.showParameters());

    qc = QueryCriteria.createCriteria("nameColumn", "range", "philip~zebra", "ageColumn", "asc");

    System.out.println(qc.getSQL() + " " + qc.showParameters());

    qc =
        QueryCriteria.createCriteria(
            "nameColumn|titleColumn", "range", "philip~zebra", "ageColumn", "asc");

    System.out.println(qc.getSQL() + " " + qc.showParameters());
  }
}
