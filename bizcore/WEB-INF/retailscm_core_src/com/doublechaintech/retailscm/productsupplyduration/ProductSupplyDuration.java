package com.doublechaintech.retailscm.productsupplyduration;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.supplierproduct.SupplierProduct;

@JsonSerialize(using = ProductSupplyDurationSerializer.class)
public class ProductSupplyDuration extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(ProductSupplyDuration target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String QUANTITY_PROPERTY = "quantity";
  public static final String DURATION_PROPERTY = "duration";
  public static final String PRICE_PROPERTY = "price";
  public static final String PRODUCT_PROPERTY = "product";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "ProductSupplyDuration";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(QUANTITY_PROPERTY, "quantity", "数量").withType("int", "int"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(DURATION_PROPERTY, "duration", "持续时间")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(PRICE_PROPERTY, "price", "价格").withType("money", "BigDecimal"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(PRODUCT_PROPERTY, "supplier_product", "产品")
            .withType("supplier_product", SupplierProduct.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      QUANTITY_PROPERTY,
      DURATION_PROPERTY,
      PRICE_PROPERTY,
      PRODUCT_PROPERTY,
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
    parents.put(PRODUCT_PROPERTY, SupplierProduct.class);

    return parents;
  }
  /*
  public ProductSupplyDuration want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public ProductSupplyDuration wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getDuration();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected int quantity;
  protected String duration;
  protected BigDecimal price;
  protected SupplierProduct product;
  protected int version;

  public ProductSupplyDuration() {
    // lazy load for all the properties
  }

  public static ProductSupplyDuration withId(String id) {
    ProductSupplyDuration productSupplyDuration = new ProductSupplyDuration();
    productSupplyDuration.setId(id);
    productSupplyDuration.setVersion(Integer.MAX_VALUE);
    productSupplyDuration.setChecked(true);
    return productSupplyDuration;
  }

  public static ProductSupplyDuration refById(String id) {
    return withId(id);
  }

  public ProductSupplyDuration limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public ProductSupplyDuration limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static ProductSupplyDuration searchExample() {
    ProductSupplyDuration productSupplyDuration = new ProductSupplyDuration();
    productSupplyDuration.setQuantity(UNSET_INT);
    productSupplyDuration.setVersion(UNSET_INT);

    return productSupplyDuration;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setProduct( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (QUANTITY_PROPERTY.equals(property)) {
      changeQuantityProperty(newValueExpr);
    }
    if (DURATION_PROPERTY.equals(property)) {
      changeDurationProperty(newValueExpr);
    }
    if (PRICE_PROPERTY.equals(property)) {
      changePriceProperty(newValueExpr);
    }
  }

  protected void changeQuantityProperty(String newValueExpr) {

    int oldValue = getQuantity();
    int newValue = parseInt(newValueExpr);
    if (equalsInt(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateQuantity(newValue);
    this.onChangeProperty(QUANTITY_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeDurationProperty(String newValueExpr) {

    String oldValue = getDuration();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateDuration(newValue);
    this.onChangeProperty(DURATION_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changePriceProperty(String newValueExpr) {

    BigDecimal oldValue = getPrice();
    BigDecimal newValue = parseBigDecimal(newValueExpr);
    if (equalsBigDecimal(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updatePrice(newValue);
    this.onChangeProperty(PRICE_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (QUANTITY_PROPERTY.equals(property)) {
      return getQuantity();
    }
    if (DURATION_PROPERTY.equals(property)) {
      return getDuration();
    }
    if (PRICE_PROPERTY.equals(property)) {
      return getPrice();
    }
    if (PRODUCT_PROPERTY.equals(property)) {
      return getProduct();
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

  public ProductSupplyDuration updateId(String id) {
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

  public ProductSupplyDuration orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public ProductSupplyDuration ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public ProductSupplyDuration addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setQuantity(int quantity) {
    int oldQuantity = this.quantity;
    int newQuantity = quantity;
    this.quantity = newQuantity;
  }

  public int quantity() {
    doLoad();
    return getQuantity();
  }

  public int getQuantity() {
    return this.quantity;
  }

  public ProductSupplyDuration updateQuantity(int quantity) {
    int oldQuantity = this.quantity;
    int newQuantity = quantity;
    if (!shouldReplaceBy(newQuantity, oldQuantity)) {
      return this;
    }
    this.quantity = newQuantity;
    if (cn.hutool.core.util.ObjectUtil.equals(newQuantity, oldQuantity)) {
      return this;
    }
    addPropertyChange(QUANTITY_PROPERTY, oldQuantity, newQuantity);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public ProductSupplyDuration orderByQuantity(boolean asc) {
    doAddOrderBy(QUANTITY_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createQuantityCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(QUANTITY_PROPERTY, operator, parameters);
  }

  public ProductSupplyDuration ignoreQuantityCriteria() {
    super.ignoreSearchProperty(QUANTITY_PROPERTY);
    return this;
  }

  public ProductSupplyDuration addQuantityCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createQuantityCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeQuantity(int quantity) {
    updateQuantity(quantity);
  }

  public void setDuration(String duration) {
    String oldDuration = this.duration;
    String newDuration = trimString(duration);
    this.duration = newDuration;
  }

  public String duration() {
    doLoad();
    return getDuration();
  }

  public String getDuration() {
    return this.duration;
  }

  public ProductSupplyDuration updateDuration(String duration) {
    String oldDuration = this.duration;
    String newDuration = trimString(duration);
    if (!shouldReplaceBy(newDuration, oldDuration)) {
      return this;
    }
    this.duration = newDuration;
    if (cn.hutool.core.util.ObjectUtil.equals(newDuration, oldDuration)) {
      return this;
    }
    addPropertyChange(DURATION_PROPERTY, oldDuration, newDuration);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public ProductSupplyDuration orderByDuration(boolean asc) {
    doAddOrderBy(DURATION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDurationCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DURATION_PROPERTY, operator, parameters);
  }

  public ProductSupplyDuration ignoreDurationCriteria() {
    super.ignoreSearchProperty(DURATION_PROPERTY);
    return this;
  }

  public ProductSupplyDuration addDurationCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDurationCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDuration(String duration) {
    if (duration != null) {
      updateDuration(duration);
    }
  }

  public void setPrice(BigDecimal price) {
    BigDecimal oldPrice = this.price;
    BigDecimal newPrice = price;
    this.price = newPrice;
  }

  public BigDecimal price() {
    doLoad();
    return getPrice();
  }

  public BigDecimal getPrice() {
    return this.price;
  }

  public ProductSupplyDuration updatePrice(BigDecimal price) {
    BigDecimal oldPrice = this.price;
    BigDecimal newPrice = price;
    if (!shouldReplaceBy(newPrice, oldPrice)) {
      return this;
    }
    this.price = newPrice;
    if (cn.hutool.core.util.ObjectUtil.equals(newPrice, oldPrice)) {
      return this;
    }
    addPropertyChange(PRICE_PROPERTY, oldPrice, newPrice);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public ProductSupplyDuration orderByPrice(boolean asc) {
    doAddOrderBy(PRICE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createPriceCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(PRICE_PROPERTY, operator, parameters);
  }

  public ProductSupplyDuration ignorePriceCriteria() {
    super.ignoreSearchProperty(PRICE_PROPERTY);
    return this;
  }

  public ProductSupplyDuration addPriceCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createPriceCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergePrice(BigDecimal price) {
    updatePrice(price);
  }

  public void setProduct(SupplierProduct product) {
    SupplierProduct oldProduct = this.product;
    SupplierProduct newProduct = product;
    this.product = newProduct;
  }

  public SupplierProduct product() {
    doLoad();
    return getProduct();
  }

  public SupplierProduct getProduct() {
    return this.product;
  }

  public ProductSupplyDuration updateProduct(SupplierProduct product) {
    SupplierProduct oldProduct = this.product;
    SupplierProduct newProduct = product;
    if (!shouldReplaceBy(newProduct, oldProduct)) {
      return this;
    }
    this.product = newProduct;
    if (cn.hutool.core.util.ObjectUtil.equals(newProduct, oldProduct)) {
      return this;
    }
    addPropertyChange(PRODUCT_PROPERTY, oldProduct, newProduct);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public ProductSupplyDuration orderByProduct(boolean asc) {
    doAddOrderBy(PRODUCT_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createProductCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(PRODUCT_PROPERTY, operator, parameters);
  }

  public ProductSupplyDuration ignoreProductCriteria() {
    super.ignoreSearchProperty(PRODUCT_PROPERTY);
    return this;
  }

  public ProductSupplyDuration addProductCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createProductCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeProduct(SupplierProduct product) {
    if (product != null) {
      updateProduct(product);
    }
  }

  public ProductSupplyDuration updateProductByReferenceId(String productId) {
    updateProduct(SupplierProduct.refById(productId));
    return this;
  }

  public void clearProduct() {
    setProduct(null);
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

  public ProductSupplyDuration updateVersion(int version) {
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

  public ProductSupplyDuration orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public ProductSupplyDuration ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public ProductSupplyDuration addVersionCriteria(QueryOperator operator, Object... parameters) {
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

    addToEntityList(this, entityList, getProduct(), internalType);
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
    appendKeyValuePair(result, QUANTITY_PROPERTY, getQuantity());
    appendKeyValuePair(result, DURATION_PROPERTY, getDuration());
    appendKeyValuePair(result, PRICE_PROPERTY, getPrice());
    appendKeyValuePair(result, PRODUCT_PROPERTY, getProduct());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof ProductSupplyDuration) {

      ProductSupplyDuration dest = (ProductSupplyDuration) baseDest;

      dest.setId(getId());
      dest.setQuantity(getQuantity());
      dest.setDuration(getDuration());
      dest.setPrice(getPrice());
      dest.setProduct(getProduct());
      dest.setVersion(getVersion());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof ProductSupplyDuration) {

      ProductSupplyDuration source = (ProductSupplyDuration) sourceEntity;

      mergeId(source.getId());
      mergeQuantity(source.getQuantity());
      mergeDuration(source.getDuration());
      mergePrice(source.getPrice());
      mergeProduct(source.getProduct());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof ProductSupplyDuration) {

      ProductSupplyDuration source = (ProductSupplyDuration) sourceEntity;

      mergeId(source.getId());
      mergeQuantity(source.getQuantity());
      mergeDuration(source.getDuration());
      mergePrice(source.getPrice());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(), getQuantity(), getDuration(), getPrice(), getProduct(), getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    ProductSupplyDuration checkProductSupplyDuration =
        Q.productSupplyDurationWithIdField().filterById(id).execute(ctx);

    return checkProductSupplyDuration != null
        && !checkProductSupplyDuration.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public ProductSupplyDuration save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("ProductSupplyDuration{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tquantity='" + getQuantity() + "';");
    stringBuilder.append("\tduration='" + getDuration() + "';");
    stringBuilder.append("\tprice='" + getPrice() + "';");
    if (getProduct() != null) {
      stringBuilder.append("\tproduct='SupplierProduct(" + getProduct().getId() + ")';");
    }
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

  public void increaseQuantity(int incQuantity) {
    updateQuantity(this.quantity + incQuantity);
  }

  public void decreaseQuantity(int decQuantity) {
    updateQuantity(this.quantity - decQuantity);
  }
}
