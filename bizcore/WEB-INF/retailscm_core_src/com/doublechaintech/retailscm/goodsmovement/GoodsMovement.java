package com.doublechaintech.retailscm.goodsmovement;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.goods.Goods;

@JsonSerialize(using = GoodsMovementSerializer.class)
public class GoodsMovement extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(GoodsMovement target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String MOVE_TIME_PROPERTY = "moveTime";
  public static final String FACILITY_PROPERTY = "facility";
  public static final String FACILITY_ID_PROPERTY = "facilityId";
  public static final String FROM_IP_PROPERTY = "fromIp";
  public static final String USER_AGENT_PROPERTY = "userAgent";
  public static final String SESSION_ID_PROPERTY = "sessionId";
  public static final String LATITUDE_PROPERTY = "latitude";
  public static final String LONGITUDE_PROPERTY = "longitude";
  public static final String GOODS_PROPERTY = "goods";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "GoodsMovement";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(MOVE_TIME_PROPERTY, "move_time", "移动时间")
            .withType("date_time", DateTime.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(FACILITY_PROPERTY, "facility", "设施")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(FACILITY_ID_PROPERTY, "facility_id", "设备ID")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(FROM_IP_PROPERTY, "from_ip", "从IP")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(USER_AGENT_PROPERTY, "user_agent", "用户代理")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(SESSION_ID_PROPERTY, "session_id", "会话ID")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LATITUDE_PROPERTY, "latitude", "纬度")
            .withType("double", "BigDecimal"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LONGITUDE_PROPERTY, "longitude", "经度")
            .withType("double", "BigDecimal"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(GOODS_PROPERTY, "goods", "货物").withType("goods", Goods.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      MOVE_TIME_PROPERTY,
      FACILITY_PROPERTY,
      FACILITY_ID_PROPERTY,
      FROM_IP_PROPERTY,
      USER_AGENT_PROPERTY,
      SESSION_ID_PROPERTY,
      LATITUDE_PROPERTY,
      LONGITUDE_PROPERTY,
      GOODS_PROPERTY,
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
    parents.put(GOODS_PROPERTY, Goods.class);

    return parents;
  }
  /*
  public GoodsMovement want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public GoodsMovement wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getFacility();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected DateTime moveTime;
  protected String facility;
  protected String facilityId;
  protected String fromIp;
  protected String userAgent;
  protected String sessionId;
  protected BigDecimal latitude;
  protected BigDecimal longitude;
  protected Goods goods;
  protected int version;

  public GoodsMovement() {
    // lazy load for all the properties
  }

  public static GoodsMovement withId(String id) {
    GoodsMovement goodsMovement = new GoodsMovement();
    goodsMovement.setId(id);
    goodsMovement.setVersion(Integer.MAX_VALUE);
    goodsMovement.setChecked(true);
    return goodsMovement;
  }

  public static GoodsMovement refById(String id) {
    return withId(id);
  }

  public GoodsMovement limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public GoodsMovement limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static GoodsMovement searchExample() {
    GoodsMovement goodsMovement = new GoodsMovement();
    goodsMovement.setVersion(UNSET_INT);

    return goodsMovement;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setGoods( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (MOVE_TIME_PROPERTY.equals(property)) {
      changeMoveTimeProperty(newValueExpr);
    }
    if (FACILITY_PROPERTY.equals(property)) {
      changeFacilityProperty(newValueExpr);
    }
    if (FACILITY_ID_PROPERTY.equals(property)) {
      changeFacilityIdProperty(newValueExpr);
    }
    if (FROM_IP_PROPERTY.equals(property)) {
      changeFromIpProperty(newValueExpr);
    }
    if (USER_AGENT_PROPERTY.equals(property)) {
      changeUserAgentProperty(newValueExpr);
    }
    if (SESSION_ID_PROPERTY.equals(property)) {
      changeSessionIdProperty(newValueExpr);
    }
    if (LATITUDE_PROPERTY.equals(property)) {
      changeLatitudeProperty(newValueExpr);
    }
    if (LONGITUDE_PROPERTY.equals(property)) {
      changeLongitudeProperty(newValueExpr);
    }
  }

  protected void changeMoveTimeProperty(String newValueExpr) {

    DateTime oldValue = getMoveTime();
    DateTime newValue = parseTimestamp(newValueExpr);
    if (equalsTimestamp(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateMoveTime(newValue);
    this.onChangeProperty(MOVE_TIME_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeFacilityProperty(String newValueExpr) {

    String oldValue = getFacility();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateFacility(newValue);
    this.onChangeProperty(FACILITY_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeFacilityIdProperty(String newValueExpr) {

    String oldValue = getFacilityId();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateFacilityId(newValue);
    this.onChangeProperty(FACILITY_ID_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeFromIpProperty(String newValueExpr) {

    String oldValue = getFromIp();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateFromIp(newValue);
    this.onChangeProperty(FROM_IP_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeUserAgentProperty(String newValueExpr) {

    String oldValue = getUserAgent();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateUserAgent(newValue);
    this.onChangeProperty(USER_AGENT_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeSessionIdProperty(String newValueExpr) {

    String oldValue = getSessionId();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateSessionId(newValue);
    this.onChangeProperty(SESSION_ID_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeLatitudeProperty(String newValueExpr) {

    BigDecimal oldValue = getLatitude();
    BigDecimal newValue = parseBigDecimal(newValueExpr);
    if (equalsBigDecimal(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateLatitude(newValue);
    this.onChangeProperty(LATITUDE_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeLongitudeProperty(String newValueExpr) {

    BigDecimal oldValue = getLongitude();
    BigDecimal newValue = parseBigDecimal(newValueExpr);
    if (equalsBigDecimal(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateLongitude(newValue);
    this.onChangeProperty(LONGITUDE_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (MOVE_TIME_PROPERTY.equals(property)) {
      return getMoveTime();
    }
    if (FACILITY_PROPERTY.equals(property)) {
      return getFacility();
    }
    if (FACILITY_ID_PROPERTY.equals(property)) {
      return getFacilityId();
    }
    if (FROM_IP_PROPERTY.equals(property)) {
      return getFromIp();
    }
    if (USER_AGENT_PROPERTY.equals(property)) {
      return getUserAgent();
    }
    if (SESSION_ID_PROPERTY.equals(property)) {
      return getSessionId();
    }
    if (LATITUDE_PROPERTY.equals(property)) {
      return getLatitude();
    }
    if (LONGITUDE_PROPERTY.equals(property)) {
      return getLongitude();
    }
    if (GOODS_PROPERTY.equals(property)) {
      return getGoods();
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

  public GoodsMovement updateId(String id) {
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

  public GoodsMovement orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public GoodsMovement ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public GoodsMovement addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setMoveTime(DateTime moveTime) {
    DateTime oldMoveTime = this.moveTime;
    DateTime newMoveTime = moveTime;
    this.moveTime = newMoveTime;
  }

  public DateTime moveTime() {
    doLoad();
    return getMoveTime();
  }

  public DateTime getMoveTime() {
    return this.moveTime;
  }

  public GoodsMovement updateMoveTime(DateTime moveTime) {
    DateTime oldMoveTime = this.moveTime;
    DateTime newMoveTime = moveTime;
    if (!shouldReplaceBy(newMoveTime, oldMoveTime)) {
      return this;
    }
    this.moveTime = newMoveTime;
    if (cn.hutool.core.util.ObjectUtil.equals(newMoveTime, oldMoveTime)) {
      return this;
    }
    addPropertyChange(MOVE_TIME_PROPERTY, oldMoveTime, newMoveTime);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public GoodsMovement orderByMoveTime(boolean asc) {
    doAddOrderBy(MOVE_TIME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createMoveTimeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(MOVE_TIME_PROPERTY, operator, parameters);
  }

  public GoodsMovement ignoreMoveTimeCriteria() {
    super.ignoreSearchProperty(MOVE_TIME_PROPERTY);
    return this;
  }

  public GoodsMovement addMoveTimeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createMoveTimeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeMoveTime(DateTime moveTime) {
    updateMoveTime(moveTime);
  }

  public void setFacility(String facility) {
    String oldFacility = this.facility;
    String newFacility = trimString(facility);
    this.facility = newFacility;
  }

  public String facility() {
    doLoad();
    return getFacility();
  }

  public String getFacility() {
    return this.facility;
  }

  public GoodsMovement updateFacility(String facility) {
    String oldFacility = this.facility;
    String newFacility = trimString(facility);
    if (!shouldReplaceBy(newFacility, oldFacility)) {
      return this;
    }
    this.facility = newFacility;
    if (cn.hutool.core.util.ObjectUtil.equals(newFacility, oldFacility)) {
      return this;
    }
    addPropertyChange(FACILITY_PROPERTY, oldFacility, newFacility);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public GoodsMovement orderByFacility(boolean asc) {
    doAddOrderBy(FACILITY_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createFacilityCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(FACILITY_PROPERTY, operator, parameters);
  }

  public GoodsMovement ignoreFacilityCriteria() {
    super.ignoreSearchProperty(FACILITY_PROPERTY);
    return this;
  }

  public GoodsMovement addFacilityCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createFacilityCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeFacility(String facility) {
    if (facility != null) {
      updateFacility(facility);
    }
  }

  public void setFacilityId(String facilityId) {
    String oldFacilityId = this.facilityId;
    String newFacilityId = trimString(facilityId);
    this.facilityId = newFacilityId;
  }

  public String facilityId() {
    doLoad();
    return getFacilityId();
  }

  public String getFacilityId() {
    return this.facilityId;
  }

  public GoodsMovement updateFacilityId(String facilityId) {
    String oldFacilityId = this.facilityId;
    String newFacilityId = trimString(facilityId);
    if (!shouldReplaceBy(newFacilityId, oldFacilityId)) {
      return this;
    }
    this.facilityId = newFacilityId;
    if (cn.hutool.core.util.ObjectUtil.equals(newFacilityId, oldFacilityId)) {
      return this;
    }
    addPropertyChange(FACILITY_ID_PROPERTY, oldFacilityId, newFacilityId);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public GoodsMovement orderByFacilityId(boolean asc) {
    doAddOrderBy(FACILITY_ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createFacilityIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(FACILITY_ID_PROPERTY, operator, parameters);
  }

  public GoodsMovement ignoreFacilityIdCriteria() {
    super.ignoreSearchProperty(FACILITY_ID_PROPERTY);
    return this;
  }

  public GoodsMovement addFacilityIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createFacilityIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeFacilityId(String facilityId) {
    if (facilityId != null) {
      updateFacilityId(facilityId);
    }
  }

  public void setFromIp(String fromIp) {
    String oldFromIp = this.fromIp;
    String newFromIp = trimString(fromIp);
    this.fromIp = newFromIp;
  }

  public String fromIp() {
    doLoad();
    return getFromIp();
  }

  public String getFromIp() {
    return this.fromIp;
  }

  public GoodsMovement updateFromIp(String fromIp) {
    String oldFromIp = this.fromIp;
    String newFromIp = trimString(fromIp);
    if (!shouldReplaceBy(newFromIp, oldFromIp)) {
      return this;
    }
    this.fromIp = newFromIp;
    if (cn.hutool.core.util.ObjectUtil.equals(newFromIp, oldFromIp)) {
      return this;
    }
    addPropertyChange(FROM_IP_PROPERTY, oldFromIp, newFromIp);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public GoodsMovement orderByFromIp(boolean asc) {
    doAddOrderBy(FROM_IP_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createFromIpCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(FROM_IP_PROPERTY, operator, parameters);
  }

  public GoodsMovement ignoreFromIpCriteria() {
    super.ignoreSearchProperty(FROM_IP_PROPERTY);
    return this;
  }

  public GoodsMovement addFromIpCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createFromIpCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeFromIp(String fromIp) {
    if (fromIp != null) {
      updateFromIp(fromIp);
    }
  }

  public void setUserAgent(String userAgent) {
    String oldUserAgent = this.userAgent;
    String newUserAgent = trimString(userAgent);
    this.userAgent = newUserAgent;
  }

  public String userAgent() {
    doLoad();
    return getUserAgent();
  }

  public String getUserAgent() {
    return this.userAgent;
  }

  public GoodsMovement updateUserAgent(String userAgent) {
    String oldUserAgent = this.userAgent;
    String newUserAgent = trimString(userAgent);
    if (!shouldReplaceBy(newUserAgent, oldUserAgent)) {
      return this;
    }
    this.userAgent = newUserAgent;
    if (cn.hutool.core.util.ObjectUtil.equals(newUserAgent, oldUserAgent)) {
      return this;
    }
    addPropertyChange(USER_AGENT_PROPERTY, oldUserAgent, newUserAgent);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public GoodsMovement orderByUserAgent(boolean asc) {
    doAddOrderBy(USER_AGENT_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createUserAgentCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(USER_AGENT_PROPERTY, operator, parameters);
  }

  public GoodsMovement ignoreUserAgentCriteria() {
    super.ignoreSearchProperty(USER_AGENT_PROPERTY);
    return this;
  }

  public GoodsMovement addUserAgentCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createUserAgentCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeUserAgent(String userAgent) {
    if (userAgent != null) {
      updateUserAgent(userAgent);
    }
  }

  public void setSessionId(String sessionId) {
    String oldSessionId = this.sessionId;
    String newSessionId = trimString(sessionId);
    this.sessionId = newSessionId;
  }

  public String sessionId() {
    doLoad();
    return getSessionId();
  }

  public String getSessionId() {
    return this.sessionId;
  }

  public GoodsMovement updateSessionId(String sessionId) {
    String oldSessionId = this.sessionId;
    String newSessionId = trimString(sessionId);
    if (!shouldReplaceBy(newSessionId, oldSessionId)) {
      return this;
    }
    this.sessionId = newSessionId;
    if (cn.hutool.core.util.ObjectUtil.equals(newSessionId, oldSessionId)) {
      return this;
    }
    addPropertyChange(SESSION_ID_PROPERTY, oldSessionId, newSessionId);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public GoodsMovement orderBySessionId(boolean asc) {
    doAddOrderBy(SESSION_ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createSessionIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(SESSION_ID_PROPERTY, operator, parameters);
  }

  public GoodsMovement ignoreSessionIdCriteria() {
    super.ignoreSearchProperty(SESSION_ID_PROPERTY);
    return this;
  }

  public GoodsMovement addSessionIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createSessionIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeSessionId(String sessionId) {
    if (sessionId != null) {
      updateSessionId(sessionId);
    }
  }

  public void setLatitude(BigDecimal latitude) {
    BigDecimal oldLatitude = this.latitude;
    BigDecimal newLatitude = latitude;
    this.latitude = newLatitude;
  }

  public BigDecimal latitude() {
    doLoad();
    return getLatitude();
  }

  public BigDecimal getLatitude() {
    return this.latitude;
  }

  public GoodsMovement updateLatitude(BigDecimal latitude) {
    BigDecimal oldLatitude = this.latitude;
    BigDecimal newLatitude = latitude;
    if (!shouldReplaceBy(newLatitude, oldLatitude)) {
      return this;
    }
    this.latitude = newLatitude;
    if (cn.hutool.core.util.ObjectUtil.equals(newLatitude, oldLatitude)) {
      return this;
    }
    addPropertyChange(LATITUDE_PROPERTY, oldLatitude, newLatitude);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public GoodsMovement orderByLatitude(boolean asc) {
    doAddOrderBy(LATITUDE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLatitudeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LATITUDE_PROPERTY, operator, parameters);
  }

  public GoodsMovement ignoreLatitudeCriteria() {
    super.ignoreSearchProperty(LATITUDE_PROPERTY);
    return this;
  }

  public GoodsMovement addLatitudeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLatitudeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLatitude(BigDecimal latitude) {
    updateLatitude(latitude);
  }

  public void setLongitude(BigDecimal longitude) {
    BigDecimal oldLongitude = this.longitude;
    BigDecimal newLongitude = longitude;
    this.longitude = newLongitude;
  }

  public BigDecimal longitude() {
    doLoad();
    return getLongitude();
  }

  public BigDecimal getLongitude() {
    return this.longitude;
  }

  public GoodsMovement updateLongitude(BigDecimal longitude) {
    BigDecimal oldLongitude = this.longitude;
    BigDecimal newLongitude = longitude;
    if (!shouldReplaceBy(newLongitude, oldLongitude)) {
      return this;
    }
    this.longitude = newLongitude;
    if (cn.hutool.core.util.ObjectUtil.equals(newLongitude, oldLongitude)) {
      return this;
    }
    addPropertyChange(LONGITUDE_PROPERTY, oldLongitude, newLongitude);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public GoodsMovement orderByLongitude(boolean asc) {
    doAddOrderBy(LONGITUDE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLongitudeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LONGITUDE_PROPERTY, operator, parameters);
  }

  public GoodsMovement ignoreLongitudeCriteria() {
    super.ignoreSearchProperty(LONGITUDE_PROPERTY);
    return this;
  }

  public GoodsMovement addLongitudeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLongitudeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLongitude(BigDecimal longitude) {
    updateLongitude(longitude);
  }

  public void setGoods(Goods goods) {
    Goods oldGoods = this.goods;
    Goods newGoods = goods;
    this.goods = newGoods;
  }

  public Goods goods() {
    doLoad();
    return getGoods();
  }

  public Goods getGoods() {
    return this.goods;
  }

  public GoodsMovement updateGoods(Goods goods) {
    Goods oldGoods = this.goods;
    Goods newGoods = goods;
    if (!shouldReplaceBy(newGoods, oldGoods)) {
      return this;
    }
    this.goods = newGoods;
    if (cn.hutool.core.util.ObjectUtil.equals(newGoods, oldGoods)) {
      return this;
    }
    addPropertyChange(GOODS_PROPERTY, oldGoods, newGoods);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public GoodsMovement orderByGoods(boolean asc) {
    doAddOrderBy(GOODS_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createGoodsCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(GOODS_PROPERTY, operator, parameters);
  }

  public GoodsMovement ignoreGoodsCriteria() {
    super.ignoreSearchProperty(GOODS_PROPERTY);
    return this;
  }

  public GoodsMovement addGoodsCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createGoodsCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeGoods(Goods goods) {
    if (goods != null) {
      updateGoods(goods);
    }
  }

  public GoodsMovement updateGoodsByReferenceId(String goodsId) {
    updateGoods(Goods.refById(goodsId));
    return this;
  }

  public void clearGoods() {
    setGoods(null);
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

  public GoodsMovement updateVersion(int version) {
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

  public GoodsMovement orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public GoodsMovement ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public GoodsMovement addVersionCriteria(QueryOperator operator, Object... parameters) {
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

    addToEntityList(this, entityList, getGoods(), internalType);
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
    appendKeyValuePair(result, MOVE_TIME_PROPERTY, getMoveTime());
    appendKeyValuePair(result, FACILITY_PROPERTY, getFacility());
    appendKeyValuePair(result, FACILITY_ID_PROPERTY, getFacilityId());
    appendKeyValuePair(result, FROM_IP_PROPERTY, getFromIp());
    appendKeyValuePair(result, USER_AGENT_PROPERTY, getUserAgent());
    appendKeyValuePair(result, SESSION_ID_PROPERTY, getSessionId());
    appendKeyValuePair(result, LATITUDE_PROPERTY, getLatitude());
    appendKeyValuePair(result, LONGITUDE_PROPERTY, getLongitude());
    appendKeyValuePair(result, GOODS_PROPERTY, getGoods());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof GoodsMovement) {

      GoodsMovement dest = (GoodsMovement) baseDest;

      dest.setId(getId());
      dest.setMoveTime(getMoveTime());
      dest.setFacility(getFacility());
      dest.setFacilityId(getFacilityId());
      dest.setFromIp(getFromIp());
      dest.setUserAgent(getUserAgent());
      dest.setSessionId(getSessionId());
      dest.setLatitude(getLatitude());
      dest.setLongitude(getLongitude());
      dest.setGoods(getGoods());
      dest.setVersion(getVersion());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof GoodsMovement) {

      GoodsMovement source = (GoodsMovement) sourceEntity;

      mergeId(source.getId());
      mergeMoveTime(source.getMoveTime());
      mergeFacility(source.getFacility());
      mergeFacilityId(source.getFacilityId());
      mergeFromIp(source.getFromIp());
      mergeUserAgent(source.getUserAgent());
      mergeSessionId(source.getSessionId());
      mergeLatitude(source.getLatitude());
      mergeLongitude(source.getLongitude());
      mergeGoods(source.getGoods());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof GoodsMovement) {

      GoodsMovement source = (GoodsMovement) sourceEntity;

      mergeId(source.getId());
      mergeMoveTime(source.getMoveTime());
      mergeFacility(source.getFacility());
      mergeFacilityId(source.getFacilityId());
      mergeFromIp(source.getFromIp());
      mergeUserAgent(source.getUserAgent());
      mergeSessionId(source.getSessionId());
      mergeLatitude(source.getLatitude());
      mergeLongitude(source.getLongitude());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(),
      getMoveTime(),
      getFacility(),
      getFacilityId(),
      getFromIp(),
      getUserAgent(),
      getSessionId(),
      getLatitude(),
      getLongitude(),
      getGoods(),
      getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    GoodsMovement checkGoodsMovement = Q.goodsMovementWithIdField().filterById(id).execute(ctx);

    return checkGoodsMovement != null
        && !checkGoodsMovement.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public GoodsMovement save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("GoodsMovement{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tmoveTime='" + getMoveTime() + "';");
    stringBuilder.append("\tfacility='" + getFacility() + "';");
    stringBuilder.append("\tfacilityId='" + getFacilityId() + "';");
    stringBuilder.append("\tfromIp='" + getFromIp() + "';");
    stringBuilder.append("\tuserAgent='" + getUserAgent() + "';");
    stringBuilder.append("\tsessionId='" + getSessionId() + "';");
    stringBuilder.append("\tlatitude='" + getLatitude() + "';");
    stringBuilder.append("\tlongitude='" + getLongitude() + "';");
    if (getGoods() != null) {
      stringBuilder.append("\tgoods='Goods(" + getGoods().getId() + ")';");
    }
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
