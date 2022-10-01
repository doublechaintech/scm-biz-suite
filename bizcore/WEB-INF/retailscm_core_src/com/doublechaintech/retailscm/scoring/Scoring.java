package com.doublechaintech.retailscm.scoring;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;

@JsonSerialize(using = ScoringSerializer.class)
public class Scoring extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(Scoring target) {
    if (target == null) {
      return;
    }
    target.addEmployeeCompanyTrainingList(this.getEmployeeCompanyTrainingList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String SCORED_BY_PROPERTY = "scoredBy";
  public static final String SCORE_PROPERTY = "score";
  public static final String COMMENT_PROPERTY = "comment";
  public static final String VERSION_PROPERTY = "version";

  public static final String EMPLOYEE_COMPANY_TRAINING_LIST = "employeeCompanyTrainingList";

  public static final String INTERNAL_TYPE = "Scoring";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(SCORED_BY_PROPERTY, "scored_by", "由谁打分")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(SCORE_PROPERTY, "score", "分数").withType("int", "int"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(COMMENT_PROPERTY, "comment", "评论")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(EMPLOYEE_COMPANY_TRAINING_LIST, "scoring", "员工公司培训名单")
            .withType("employee_company_training", EmployeeCompanyTraining.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY, SCORED_BY_PROPERTY, SCORE_PROPERTY, COMMENT_PROPERTY, VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(EMPLOYEE_COMPANY_TRAINING_LIST, "scoring");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(EMPLOYEE_COMPANY_TRAINING_LIST, EmployeeCompanyTraining.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();

    return parents;
  }
  /*
  public Scoring want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public Scoring wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getScoredBy();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String scoredBy;
  protected int score;
  protected String comment;
  protected int version;

  protected SmartList<EmployeeCompanyTraining> mEmployeeCompanyTrainingList;

  public Scoring() {
    // lazy load for all the properties
  }

  public static Scoring withId(String id) {
    Scoring scoring = new Scoring();
    scoring.setId(id);
    scoring.setVersion(Integer.MAX_VALUE);
    scoring.setChecked(true);
    return scoring;
  }

  public static Scoring refById(String id) {
    return withId(id);
  }

  public Scoring limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public Scoring limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static Scoring searchExample() {
    Scoring scoring = new Scoring();
    scoring.setScore(UNSET_INT);
    scoring.setVersion(UNSET_INT);

    return scoring;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (SCORED_BY_PROPERTY.equals(property)) {
      changeScoredByProperty(newValueExpr);
    }
    if (SCORE_PROPERTY.equals(property)) {
      changeScoreProperty(newValueExpr);
    }
    if (COMMENT_PROPERTY.equals(property)) {
      changeCommentProperty(newValueExpr);
    }
  }

  protected void changeScoredByProperty(String newValueExpr) {

    String oldValue = getScoredBy();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateScoredBy(newValue);
    this.onChangeProperty(SCORED_BY_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeScoreProperty(String newValueExpr) {

    int oldValue = getScore();
    int newValue = parseInt(newValueExpr);
    if (equalsInt(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateScore(newValue);
    this.onChangeProperty(SCORE_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeCommentProperty(String newValueExpr) {

    String oldValue = getComment();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateComment(newValue);
    this.onChangeProperty(COMMENT_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (SCORED_BY_PROPERTY.equals(property)) {
      return getScoredBy();
    }
    if (SCORE_PROPERTY.equals(property)) {
      return getScore();
    }
    if (COMMENT_PROPERTY.equals(property)) {
      return getComment();
    }
    if (EMPLOYEE_COMPANY_TRAINING_LIST.equals(property)) {
      List<BaseEntity> list =
          getEmployeeCompanyTrainingList().stream().map(item -> item).collect(Collectors.toList());
      return list;
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

  public Scoring updateId(String id) {
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

  public Scoring orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public Scoring ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public Scoring addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setScoredBy(String scoredBy) {
    String oldScoredBy = this.scoredBy;
    String newScoredBy = trimString(scoredBy);
    this.scoredBy = newScoredBy;
  }

  public String scoredBy() {
    doLoad();
    return getScoredBy();
  }

  public String getScoredBy() {
    return this.scoredBy;
  }

  public Scoring updateScoredBy(String scoredBy) {
    String oldScoredBy = this.scoredBy;
    String newScoredBy = trimString(scoredBy);
    if (!shouldReplaceBy(newScoredBy, oldScoredBy)) {
      return this;
    }
    this.scoredBy = newScoredBy;
    if (cn.hutool.core.util.ObjectUtil.equals(newScoredBy, oldScoredBy)) {
      return this;
    }
    addPropertyChange(SCORED_BY_PROPERTY, oldScoredBy, newScoredBy);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public Scoring orderByScoredBy(boolean asc) {
    doAddOrderBy(SCORED_BY_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createScoredByCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(SCORED_BY_PROPERTY, operator, parameters);
  }

  public Scoring ignoreScoredByCriteria() {
    super.ignoreSearchProperty(SCORED_BY_PROPERTY);
    return this;
  }

  public Scoring addScoredByCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createScoredByCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeScoredBy(String scoredBy) {
    if (scoredBy != null) {
      updateScoredBy(scoredBy);
    }
  }

  public void setScore(int score) {
    int oldScore = this.score;
    int newScore = score;
    this.score = newScore;
  }

  public int score() {
    doLoad();
    return getScore();
  }

  public int getScore() {
    return this.score;
  }

  public Scoring updateScore(int score) {
    int oldScore = this.score;
    int newScore = score;
    if (!shouldReplaceBy(newScore, oldScore)) {
      return this;
    }
    this.score = newScore;
    if (cn.hutool.core.util.ObjectUtil.equals(newScore, oldScore)) {
      return this;
    }
    addPropertyChange(SCORE_PROPERTY, oldScore, newScore);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public Scoring orderByScore(boolean asc) {
    doAddOrderBy(SCORE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createScoreCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(SCORE_PROPERTY, operator, parameters);
  }

  public Scoring ignoreScoreCriteria() {
    super.ignoreSearchProperty(SCORE_PROPERTY);
    return this;
  }

  public Scoring addScoreCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createScoreCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeScore(int score) {
    updateScore(score);
  }

  public void setComment(String comment) {
    String oldComment = this.comment;
    String newComment = trimString(comment);
    this.comment = newComment;
  }

  public String comment() {
    doLoad();
    return getComment();
  }

  public String getComment() {
    return this.comment;
  }

  public Scoring updateComment(String comment) {
    String oldComment = this.comment;
    String newComment = trimString(comment);
    if (!shouldReplaceBy(newComment, oldComment)) {
      return this;
    }
    this.comment = newComment;
    if (cn.hutool.core.util.ObjectUtil.equals(newComment, oldComment)) {
      return this;
    }
    addPropertyChange(COMMENT_PROPERTY, oldComment, newComment);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public Scoring orderByComment(boolean asc) {
    doAddOrderBy(COMMENT_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCommentCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(COMMENT_PROPERTY, operator, parameters);
  }

  public Scoring ignoreCommentCriteria() {
    super.ignoreSearchProperty(COMMENT_PROPERTY);
    return this;
  }

  public Scoring addCommentCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCommentCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeComment(String comment) {
    if (comment != null) {
      updateComment(comment);
    }
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

  public Scoring updateVersion(int version) {
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

  public Scoring orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public Scoring ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public Scoring addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<EmployeeCompanyTraining> getEmployeeCompanyTrainingList() {
    if (this.mEmployeeCompanyTrainingList == null) {
      this.mEmployeeCompanyTrainingList = new SmartList<EmployeeCompanyTraining>();
      this.mEmployeeCompanyTrainingList.setListInternalName(EMPLOYEE_COMPANY_TRAINING_LIST);
      // 有名字，便于做权限控制
    }

    return this.mEmployeeCompanyTrainingList;
  }

  public SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList() {

    doLoadChild(EMPLOYEE_COMPANY_TRAINING_LIST);

    return getEmployeeCompanyTrainingList();
  }

  public void setEmployeeCompanyTrainingList(
      SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList) {
    for (EmployeeCompanyTraining employeeCompanyTraining : employeeCompanyTrainingList) {
      employeeCompanyTraining.setScoring(this);
    }

    this.mEmployeeCompanyTrainingList = employeeCompanyTrainingList;
    this.mEmployeeCompanyTrainingList.setListInternalName(EMPLOYEE_COMPANY_TRAINING_LIST);
  }

  public Scoring addEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTraining) {
    employeeCompanyTraining.updateScoring(this);
    getEmployeeCompanyTrainingList().add(employeeCompanyTraining);
    return this;
  }

  public Scoring addEmployeeCompanyTrainingList(
      SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList) {
    for (EmployeeCompanyTraining employeeCompanyTraining : employeeCompanyTrainingList) {
      employeeCompanyTraining.updateScoring(this);
    }

    Map<String, EmployeeCompanyTraining> mapById = employeeCompanyTrainingList.mapWithId();
    getEmployeeCompanyTrainingList().removeIf(item -> mapById.get(item.getId()) != null);
    getEmployeeCompanyTrainingList().addAll(employeeCompanyTrainingList);
    return this;
  }

  public void mergeEmployeeCompanyTrainingList(
      SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList) {
    if (employeeCompanyTrainingList == null) {
      return;
    }
    if (employeeCompanyTrainingList.isEmpty()) {
      return;
    }
    addEmployeeCompanyTrainingList(employeeCompanyTrainingList);
  }

  public EmployeeCompanyTraining removeEmployeeCompanyTraining(
      EmployeeCompanyTraining employeeCompanyTrainingIndex) {

    int index = getEmployeeCompanyTrainingList().indexOf(employeeCompanyTrainingIndex);
    if (index < 0) {
      String message =
          "EmployeeCompanyTraining("
              + employeeCompanyTrainingIndex.getId()
              + ") with version='"
              + employeeCompanyTrainingIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    EmployeeCompanyTraining employeeCompanyTraining = getEmployeeCompanyTrainingList().get(index);
    // employeeCompanyTraining.clearScoring(); //disconnect with Scoring
    employeeCompanyTraining.clearFromAll(); // disconnect with Scoring

    boolean result = getEmployeeCompanyTrainingList().planToRemove(employeeCompanyTraining);
    if (!result) {
      String message =
          "EmployeeCompanyTraining("
              + employeeCompanyTrainingIndex.getId()
              + ") with version='"
              + employeeCompanyTrainingIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return employeeCompanyTraining;
  }
  // 断舍离
  public void breakWithEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTraining) {

    if (employeeCompanyTraining == null) {
      return;
    }
    employeeCompanyTraining.setScoring(null);
    // getEmployeeCompanyTrainingList().remove();

  }

  public boolean hasEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTraining) {

    return getEmployeeCompanyTrainingList().contains(employeeCompanyTraining);
  }

  public void copyEmployeeCompanyTrainingFrom(EmployeeCompanyTraining employeeCompanyTraining) {

    EmployeeCompanyTraining employeeCompanyTrainingInList =
        findTheEmployeeCompanyTraining(employeeCompanyTraining);
    EmployeeCompanyTraining newEmployeeCompanyTraining = new EmployeeCompanyTraining();
    employeeCompanyTrainingInList.copyTo(newEmployeeCompanyTraining);
    newEmployeeCompanyTraining.setVersion(0); // will trigger copy
    getEmployeeCompanyTrainingList().add(newEmployeeCompanyTraining);
    addItemToFlexiableObject(COPIED_CHILD, newEmployeeCompanyTraining);
  }

  public EmployeeCompanyTraining findTheEmployeeCompanyTraining(
      EmployeeCompanyTraining employeeCompanyTraining) {

    int index = getEmployeeCompanyTrainingList().indexOf(employeeCompanyTraining);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "EmployeeCompanyTraining("
              + employeeCompanyTraining.getId()
              + ") with version='"
              + employeeCompanyTraining.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getEmployeeCompanyTrainingList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpEmployeeCompanyTrainingList() {
    getEmployeeCompanyTrainingList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {}

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getEmployeeCompanyTrainingList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getEmployeeCompanyTrainingList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, SCORED_BY_PROPERTY, getScoredBy());
    appendKeyValuePair(result, SCORE_PROPERTY, getScore());
    appendKeyValuePair(result, COMMENT_PROPERTY, getComment());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, EMPLOYEE_COMPANY_TRAINING_LIST, getEmployeeCompanyTrainingList());
    if (!getEmployeeCompanyTrainingList().isEmpty()) {
      appendKeyValuePair(
          result, "employeeCompanyTrainingCount", getEmployeeCompanyTrainingList().getTotalCount());
      appendKeyValuePair(
          result,
          "employeeCompanyTrainingCurrentPageNumber",
          getEmployeeCompanyTrainingList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof Scoring) {

      Scoring dest = (Scoring) baseDest;

      dest.setId(getId());
      dest.setScoredBy(getScoredBy());
      dest.setScore(getScore());
      dest.setComment(getComment());
      dest.setVersion(getVersion());
      dest.setEmployeeCompanyTrainingList(getEmployeeCompanyTrainingList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof Scoring) {

      Scoring source = (Scoring) sourceEntity;

      mergeId(source.getId());
      mergeScoredBy(source.getScoredBy());
      mergeScore(source.getScore());
      mergeComment(source.getComment());
      mergeVersion(source.getVersion());
      mergeEmployeeCompanyTrainingList(source.getEmployeeCompanyTrainingList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof Scoring) {

      Scoring source = (Scoring) sourceEntity;

      mergeId(source.getId());
      mergeScoredBy(source.getScoredBy());
      mergeScore(source.getScore());
      mergeComment(source.getComment());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {getId(), getScoredBy(), getScore(), getComment(), getVersion()};
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    Scoring checkScoring =
        Q.scoringWithIdField()
            .filterById(id)
            .selectEmployeeCompanyTrainingList(Q.employeeCompanyTrainingWithIdField().limit(0, 1))
            .execute(ctx);

    return checkScoring != null
        && !checkScoring.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public Scoring save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("Scoring{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tscoredBy='" + getScoredBy() + "';");
    stringBuilder.append("\tscore='" + getScore() + "';");
    stringBuilder.append("\tcomment='" + getComment() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

  public void increaseScore(int incScore) {
    updateScore(this.score + incScore);
  }

  public void decreaseScore(int decScore) {
    updateScore(this.score - decScore);
  }
}
