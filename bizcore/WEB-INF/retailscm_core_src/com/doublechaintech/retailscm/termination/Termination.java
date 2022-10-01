package com.doublechaintech.retailscm.termination;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.terminationtype.TerminationType;
import com.doublechaintech.retailscm.terminationreason.TerminationReason;

@JsonSerialize(using = TerminationSerializer.class)
public class Termination extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(Termination target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String REASON_PROPERTY = "reason";
  public static final String TYPE_PROPERTY = "type";
  public static final String COMMENT_PROPERTY = "comment";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "Termination";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(REASON_PROPERTY, "termination_reason", "原因")
            .withType("termination_reason", TerminationReason.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(TYPE_PROPERTY, "termination_type", "类型")
            .withType("termination_type", TerminationType.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(COMMENT_PROPERTY, "comment", "评论")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY, REASON_PROPERTY, TYPE_PROPERTY, COMMENT_PROPERTY, VERSION_PROPERTY
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
    parents.put(REASON_PROPERTY, TerminationReason.class);
    parents.put(TYPE_PROPERTY, TerminationType.class);

    return parents;
  }
  /*
  public Termination want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public Termination wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getComment();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected TerminationReason reason;
  protected TerminationType type;
  protected String comment;
  protected int version;

  public Termination() {
    // lazy load for all the properties
  }

  public static Termination withId(String id) {
    Termination termination = new Termination();
    termination.setId(id);
    termination.setVersion(Integer.MAX_VALUE);
    termination.setChecked(true);
    return termination;
  }

  public static Termination refById(String id) {
    return withId(id);
  }

  public Termination limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public Termination limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static Termination searchExample() {
    Termination termination = new Termination();
    termination.setVersion(UNSET_INT);

    return termination;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setReason( null );
  	setType( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (COMMENT_PROPERTY.equals(property)) {
      changeCommentProperty(newValueExpr);
    }
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

    if (REASON_PROPERTY.equals(property)) {
      return getReason();
    }
    if (TYPE_PROPERTY.equals(property)) {
      return getType();
    }
    if (COMMENT_PROPERTY.equals(property)) {
      return getComment();
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

  public Termination updateId(String id) {
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

  public Termination orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public Termination ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public Termination addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setReason(TerminationReason reason) {
    TerminationReason oldReason = this.reason;
    TerminationReason newReason = reason;
    this.reason = newReason;
  }

  public TerminationReason reason() {
    doLoad();
    return getReason();
  }

  public TerminationReason getReason() {
    return this.reason;
  }

  public Termination updateReason(TerminationReason reason) {
    TerminationReason oldReason = this.reason;
    TerminationReason newReason = reason;
    if (!shouldReplaceBy(newReason, oldReason)) {
      return this;
    }
    this.reason = newReason;
    if (cn.hutool.core.util.ObjectUtil.equals(newReason, oldReason)) {
      return this;
    }
    addPropertyChange(REASON_PROPERTY, oldReason, newReason);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public Termination orderByReason(boolean asc) {
    doAddOrderBy(REASON_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createReasonCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(REASON_PROPERTY, operator, parameters);
  }

  public Termination ignoreReasonCriteria() {
    super.ignoreSearchProperty(REASON_PROPERTY);
    return this;
  }

  public Termination addReasonCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createReasonCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeReason(TerminationReason reason) {
    if (reason != null) {
      updateReason(reason);
    }
  }

  public Termination updateReasonByReferenceId(String reasonId) {
    updateReason(TerminationReason.refById(reasonId));
    return this;
  }

  public void clearReason() {
    setReason(null);
    this.changed = true;
    setChecked(false);
  }

  public void setType(TerminationType type) {
    TerminationType oldType = this.type;
    TerminationType newType = type;
    this.type = newType;
  }

  public TerminationType type() {
    doLoad();
    return getType();
  }

  public TerminationType getType() {
    return this.type;
  }

  public Termination updateType(TerminationType type) {
    TerminationType oldType = this.type;
    TerminationType newType = type;
    if (!shouldReplaceBy(newType, oldType)) {
      return this;
    }
    this.type = newType;
    if (cn.hutool.core.util.ObjectUtil.equals(newType, oldType)) {
      return this;
    }
    addPropertyChange(TYPE_PROPERTY, oldType, newType);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public Termination orderByType(boolean asc) {
    doAddOrderBy(TYPE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createTypeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(TYPE_PROPERTY, operator, parameters);
  }

  public Termination ignoreTypeCriteria() {
    super.ignoreSearchProperty(TYPE_PROPERTY);
    return this;
  }

  public Termination addTypeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createTypeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeType(TerminationType type) {
    if (type != null) {
      updateType(type);
    }
  }

  public Termination updateTypeByReferenceId(String typeId) {
    updateType(TerminationType.refById(typeId));
    return this;
  }

  public void clearType() {
    setType(null);
    this.changed = true;
    setChecked(false);
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

  public Termination updateComment(String comment) {
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

  public Termination orderByComment(boolean asc) {
    doAddOrderBy(COMMENT_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCommentCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(COMMENT_PROPERTY, operator, parameters);
  }

  public Termination ignoreCommentCriteria() {
    super.ignoreSearchProperty(COMMENT_PROPERTY);
    return this;
  }

  public Termination addCommentCriteria(QueryOperator operator, Object... parameters) {
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

  public Termination updateVersion(int version) {
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

  public Termination orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public Termination ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public Termination addVersionCriteria(QueryOperator operator, Object... parameters) {
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

    addToEntityList(this, entityList, getReason(), internalType);
    addToEntityList(this, entityList, getType(), internalType);
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
    appendKeyValuePair(result, REASON_PROPERTY, getReason());
    appendKeyValuePair(result, TYPE_PROPERTY, getType());
    appendKeyValuePair(result, COMMENT_PROPERTY, getComment());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof Termination) {

      Termination dest = (Termination) baseDest;

      dest.setId(getId());
      dest.setReason(getReason());
      dest.setType(getType());
      dest.setComment(getComment());
      dest.setVersion(getVersion());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof Termination) {

      Termination source = (Termination) sourceEntity;

      mergeId(source.getId());
      mergeReason(source.getReason());
      mergeType(source.getType());
      mergeComment(source.getComment());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof Termination) {

      Termination source = (Termination) sourceEntity;

      mergeId(source.getId());
      mergeComment(source.getComment());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {getId(), getReason(), getType(), getComment(), getVersion()};
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    Termination checkTermination = Q.terminationWithIdField().filterById(id).execute(ctx);

    return checkTermination != null
        && !checkTermination.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public Termination save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("Termination{");
    stringBuilder.append("\tid='" + getId() + "';");
    if (getReason() != null) {
      stringBuilder.append("\treason='TerminationReason(" + getReason().getId() + ")';");
    }
    if (getType() != null) {
      stringBuilder.append("\ttype='TerminationType(" + getType().getId() + ")';");
    }
    stringBuilder.append("\tcomment='" + getComment() + "';");
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
