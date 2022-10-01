package com.doublechaintech.retailscm.supplierproduct;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDuration;

@JsonSerialize(using = SupplierProductSerializer.class)
public class SupplierProduct extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(SupplierProduct target) {
    if (target == null) {
      return;
    }
    target.addProductSupplyDurationList(this.getProductSupplyDurationList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String PRODUCT_NAME_PROPERTY = "productName";
  public static final String PRODUCT_DESCRIPTION_PROPERTY = "productDescription";
  public static final String PRODUCT_UNIT_PROPERTY = "productUnit";
  public static final String SUPPLIER_PROPERTY = "supplier";
  public static final String VERSION_PROPERTY = "version";

  public static final String PRODUCT_SUPPLY_DURATION_LIST = "productSupplyDurationList";

  public static final String INTERNAL_TYPE = "SupplierProduct";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(PRODUCT_NAME_PROPERTY, "product_name", "品名")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(PRODUCT_DESCRIPTION_PROPERTY, "product_description", "产品描述")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(PRODUCT_UNIT_PROPERTY, "product_unit", "产品单元")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(SUPPLIER_PROPERTY, "goods_supplier", "供应商")
            .withType("goods_supplier", GoodsSupplier.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(PRODUCT_SUPPLY_DURATION_LIST, "product", "产品供货期限清单")
            .withType("product_supply_duration", ProductSupplyDuration.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      PRODUCT_NAME_PROPERTY,
      PRODUCT_DESCRIPTION_PROPERTY,
      PRODUCT_UNIT_PROPERTY,
      SUPPLIER_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(PRODUCT_SUPPLY_DURATION_LIST, "product");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(PRODUCT_SUPPLY_DURATION_LIST, ProductSupplyDuration.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(SUPPLIER_PROPERTY, GoodsSupplier.class);

    return parents;
  }
  /*
  public SupplierProduct want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public SupplierProduct wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getProductName();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String productName;
  protected String productDescription;
  protected String productUnit;
  protected GoodsSupplier supplier;
  protected int version;

  protected SmartList<ProductSupplyDuration> mProductSupplyDurationList;

  public SupplierProduct() {
    // lazy load for all the properties
  }

  public static SupplierProduct withId(String id) {
    SupplierProduct supplierProduct = new SupplierProduct();
    supplierProduct.setId(id);
    supplierProduct.setVersion(Integer.MAX_VALUE);
    supplierProduct.setChecked(true);
    return supplierProduct;
  }

  public static SupplierProduct refById(String id) {
    return withId(id);
  }

  public SupplierProduct limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public SupplierProduct limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static SupplierProduct searchExample() {
    SupplierProduct supplierProduct = new SupplierProduct();
    supplierProduct.setVersion(UNSET_INT);

    return supplierProduct;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setSupplier( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (PRODUCT_NAME_PROPERTY.equals(property)) {
      changeProductNameProperty(newValueExpr);
    }
    if (PRODUCT_DESCRIPTION_PROPERTY.equals(property)) {
      changeProductDescriptionProperty(newValueExpr);
    }
    if (PRODUCT_UNIT_PROPERTY.equals(property)) {
      changeProductUnitProperty(newValueExpr);
    }
  }

  protected void changeProductNameProperty(String newValueExpr) {

    String oldValue = getProductName();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateProductName(newValue);
    this.onChangeProperty(PRODUCT_NAME_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeProductDescriptionProperty(String newValueExpr) {

    String oldValue = getProductDescription();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateProductDescription(newValue);
    this.onChangeProperty(PRODUCT_DESCRIPTION_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeProductUnitProperty(String newValueExpr) {

    String oldValue = getProductUnit();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateProductUnit(newValue);
    this.onChangeProperty(PRODUCT_UNIT_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (PRODUCT_NAME_PROPERTY.equals(property)) {
      return getProductName();
    }
    if (PRODUCT_DESCRIPTION_PROPERTY.equals(property)) {
      return getProductDescription();
    }
    if (PRODUCT_UNIT_PROPERTY.equals(property)) {
      return getProductUnit();
    }
    if (SUPPLIER_PROPERTY.equals(property)) {
      return getSupplier();
    }
    if (PRODUCT_SUPPLY_DURATION_LIST.equals(property)) {
      List<BaseEntity> list =
          getProductSupplyDurationList().stream().map(item -> item).collect(Collectors.toList());
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

  public SupplierProduct updateId(String id) {
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

  public SupplierProduct orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public SupplierProduct ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public SupplierProduct addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setProductName(String productName) {
    String oldProductName = this.productName;
    String newProductName = trimString(productName);
    this.productName = newProductName;
  }

  public String productName() {
    doLoad();
    return getProductName();
  }

  public String getProductName() {
    return this.productName;
  }

  public SupplierProduct updateProductName(String productName) {
    String oldProductName = this.productName;
    String newProductName = trimString(productName);
    if (!shouldReplaceBy(newProductName, oldProductName)) {
      return this;
    }
    this.productName = newProductName;
    if (cn.hutool.core.util.ObjectUtil.equals(newProductName, oldProductName)) {
      return this;
    }
    addPropertyChange(PRODUCT_NAME_PROPERTY, oldProductName, newProductName);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public SupplierProduct orderByProductName(boolean asc) {
    doAddOrderBy(PRODUCT_NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createProductNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(PRODUCT_NAME_PROPERTY, operator, parameters);
  }

  public SupplierProduct ignoreProductNameCriteria() {
    super.ignoreSearchProperty(PRODUCT_NAME_PROPERTY);
    return this;
  }

  public SupplierProduct addProductNameCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createProductNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeProductName(String productName) {
    if (productName != null) {
      updateProductName(productName);
    }
  }

  public void setProductDescription(String productDescription) {
    String oldProductDescription = this.productDescription;
    String newProductDescription = trimString(productDescription);
    this.productDescription = newProductDescription;
  }

  public String productDescription() {
    doLoad();
    return getProductDescription();
  }

  public String getProductDescription() {
    return this.productDescription;
  }

  public SupplierProduct updateProductDescription(String productDescription) {
    String oldProductDescription = this.productDescription;
    String newProductDescription = trimString(productDescription);
    if (!shouldReplaceBy(newProductDescription, oldProductDescription)) {
      return this;
    }
    this.productDescription = newProductDescription;
    if (cn.hutool.core.util.ObjectUtil.equals(newProductDescription, oldProductDescription)) {
      return this;
    }
    addPropertyChange(PRODUCT_DESCRIPTION_PROPERTY, oldProductDescription, newProductDescription);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public SupplierProduct orderByProductDescription(boolean asc) {
    doAddOrderBy(PRODUCT_DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createProductDescriptionCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(PRODUCT_DESCRIPTION_PROPERTY, operator, parameters);
  }

  public SupplierProduct ignoreProductDescriptionCriteria() {
    super.ignoreSearchProperty(PRODUCT_DESCRIPTION_PROPERTY);
    return this;
  }

  public SupplierProduct addProductDescriptionCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createProductDescriptionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeProductDescription(String productDescription) {
    if (productDescription != null) {
      updateProductDescription(productDescription);
    }
  }

  public void setProductUnit(String productUnit) {
    String oldProductUnit = this.productUnit;
    String newProductUnit = trimString(productUnit);
    this.productUnit = newProductUnit;
  }

  public String productUnit() {
    doLoad();
    return getProductUnit();
  }

  public String getProductUnit() {
    return this.productUnit;
  }

  public SupplierProduct updateProductUnit(String productUnit) {
    String oldProductUnit = this.productUnit;
    String newProductUnit = trimString(productUnit);
    if (!shouldReplaceBy(newProductUnit, oldProductUnit)) {
      return this;
    }
    this.productUnit = newProductUnit;
    if (cn.hutool.core.util.ObjectUtil.equals(newProductUnit, oldProductUnit)) {
      return this;
    }
    addPropertyChange(PRODUCT_UNIT_PROPERTY, oldProductUnit, newProductUnit);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public SupplierProduct orderByProductUnit(boolean asc) {
    doAddOrderBy(PRODUCT_UNIT_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createProductUnitCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(PRODUCT_UNIT_PROPERTY, operator, parameters);
  }

  public SupplierProduct ignoreProductUnitCriteria() {
    super.ignoreSearchProperty(PRODUCT_UNIT_PROPERTY);
    return this;
  }

  public SupplierProduct addProductUnitCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createProductUnitCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeProductUnit(String productUnit) {
    if (productUnit != null) {
      updateProductUnit(productUnit);
    }
  }

  public void setSupplier(GoodsSupplier supplier) {
    GoodsSupplier oldSupplier = this.supplier;
    GoodsSupplier newSupplier = supplier;
    this.supplier = newSupplier;
  }

  public GoodsSupplier supplier() {
    doLoad();
    return getSupplier();
  }

  public GoodsSupplier getSupplier() {
    return this.supplier;
  }

  public SupplierProduct updateSupplier(GoodsSupplier supplier) {
    GoodsSupplier oldSupplier = this.supplier;
    GoodsSupplier newSupplier = supplier;
    if (!shouldReplaceBy(newSupplier, oldSupplier)) {
      return this;
    }
    this.supplier = newSupplier;
    if (cn.hutool.core.util.ObjectUtil.equals(newSupplier, oldSupplier)) {
      return this;
    }
    addPropertyChange(SUPPLIER_PROPERTY, oldSupplier, newSupplier);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public SupplierProduct orderBySupplier(boolean asc) {
    doAddOrderBy(SUPPLIER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createSupplierCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(SUPPLIER_PROPERTY, operator, parameters);
  }

  public SupplierProduct ignoreSupplierCriteria() {
    super.ignoreSearchProperty(SUPPLIER_PROPERTY);
    return this;
  }

  public SupplierProduct addSupplierCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createSupplierCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeSupplier(GoodsSupplier supplier) {
    if (supplier != null) {
      updateSupplier(supplier);
    }
  }

  public SupplierProduct updateSupplierByReferenceId(String supplierId) {
    updateSupplier(GoodsSupplier.refById(supplierId));
    return this;
  }

  public void clearSupplier() {
    setSupplier(null);
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

  public SupplierProduct updateVersion(int version) {
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

  public SupplierProduct orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public SupplierProduct ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public SupplierProduct addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<ProductSupplyDuration> getProductSupplyDurationList() {
    if (this.mProductSupplyDurationList == null) {
      this.mProductSupplyDurationList = new SmartList<ProductSupplyDuration>();
      this.mProductSupplyDurationList.setListInternalName(PRODUCT_SUPPLY_DURATION_LIST);
      // 有名字，便于做权限控制
    }

    return this.mProductSupplyDurationList;
  }

  public SmartList<ProductSupplyDuration> productSupplyDurationList() {

    doLoadChild(PRODUCT_SUPPLY_DURATION_LIST);

    return getProductSupplyDurationList();
  }

  public void setProductSupplyDurationList(
      SmartList<ProductSupplyDuration> productSupplyDurationList) {
    for (ProductSupplyDuration productSupplyDuration : productSupplyDurationList) {
      productSupplyDuration.setProduct(this);
    }

    this.mProductSupplyDurationList = productSupplyDurationList;
    this.mProductSupplyDurationList.setListInternalName(PRODUCT_SUPPLY_DURATION_LIST);
  }

  public SupplierProduct addProductSupplyDuration(ProductSupplyDuration productSupplyDuration) {
    productSupplyDuration.updateProduct(this);
    getProductSupplyDurationList().add(productSupplyDuration);
    return this;
  }

  public SupplierProduct addProductSupplyDurationList(
      SmartList<ProductSupplyDuration> productSupplyDurationList) {
    for (ProductSupplyDuration productSupplyDuration : productSupplyDurationList) {
      productSupplyDuration.updateProduct(this);
    }

    Map<String, ProductSupplyDuration> mapById = productSupplyDurationList.mapWithId();
    getProductSupplyDurationList().removeIf(item -> mapById.get(item.getId()) != null);
    getProductSupplyDurationList().addAll(productSupplyDurationList);
    return this;
  }

  public void mergeProductSupplyDurationList(
      SmartList<ProductSupplyDuration> productSupplyDurationList) {
    if (productSupplyDurationList == null) {
      return;
    }
    if (productSupplyDurationList.isEmpty()) {
      return;
    }
    addProductSupplyDurationList(productSupplyDurationList);
  }

  public ProductSupplyDuration removeProductSupplyDuration(
      ProductSupplyDuration productSupplyDurationIndex) {

    int index = getProductSupplyDurationList().indexOf(productSupplyDurationIndex);
    if (index < 0) {
      String message =
          "ProductSupplyDuration("
              + productSupplyDurationIndex.getId()
              + ") with version='"
              + productSupplyDurationIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    ProductSupplyDuration productSupplyDuration = getProductSupplyDurationList().get(index);
    // productSupplyDuration.clearProduct(); //disconnect with Product
    productSupplyDuration.clearFromAll(); // disconnect with Product

    boolean result = getProductSupplyDurationList().planToRemove(productSupplyDuration);
    if (!result) {
      String message =
          "ProductSupplyDuration("
              + productSupplyDurationIndex.getId()
              + ") with version='"
              + productSupplyDurationIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return productSupplyDuration;
  }
  // 断舍离
  public void breakWithProductSupplyDuration(ProductSupplyDuration productSupplyDuration) {

    if (productSupplyDuration == null) {
      return;
    }
    productSupplyDuration.setProduct(null);
    // getProductSupplyDurationList().remove();

  }

  public boolean hasProductSupplyDuration(ProductSupplyDuration productSupplyDuration) {

    return getProductSupplyDurationList().contains(productSupplyDuration);
  }

  public void copyProductSupplyDurationFrom(ProductSupplyDuration productSupplyDuration) {

    ProductSupplyDuration productSupplyDurationInList =
        findTheProductSupplyDuration(productSupplyDuration);
    ProductSupplyDuration newProductSupplyDuration = new ProductSupplyDuration();
    productSupplyDurationInList.copyTo(newProductSupplyDuration);
    newProductSupplyDuration.setVersion(0); // will trigger copy
    getProductSupplyDurationList().add(newProductSupplyDuration);
    addItemToFlexiableObject(COPIED_CHILD, newProductSupplyDuration);
  }

  public ProductSupplyDuration findTheProductSupplyDuration(
      ProductSupplyDuration productSupplyDuration) {

    int index = getProductSupplyDurationList().indexOf(productSupplyDuration);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "ProductSupplyDuration("
              + productSupplyDuration.getId()
              + ") with version='"
              + productSupplyDuration.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getProductSupplyDurationList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpProductSupplyDurationList() {
    getProductSupplyDurationList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getSupplier(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getProductSupplyDurationList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getProductSupplyDurationList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, PRODUCT_NAME_PROPERTY, getProductName());
    appendKeyValuePair(result, PRODUCT_DESCRIPTION_PROPERTY, getProductDescription());
    appendKeyValuePair(result, PRODUCT_UNIT_PROPERTY, getProductUnit());
    appendKeyValuePair(result, SUPPLIER_PROPERTY, getSupplier());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, PRODUCT_SUPPLY_DURATION_LIST, getProductSupplyDurationList());
    if (!getProductSupplyDurationList().isEmpty()) {
      appendKeyValuePair(
          result, "productSupplyDurationCount", getProductSupplyDurationList().getTotalCount());
      appendKeyValuePair(
          result,
          "productSupplyDurationCurrentPageNumber",
          getProductSupplyDurationList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof SupplierProduct) {

      SupplierProduct dest = (SupplierProduct) baseDest;

      dest.setId(getId());
      dest.setProductName(getProductName());
      dest.setProductDescription(getProductDescription());
      dest.setProductUnit(getProductUnit());
      dest.setSupplier(getSupplier());
      dest.setVersion(getVersion());
      dest.setProductSupplyDurationList(getProductSupplyDurationList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof SupplierProduct) {

      SupplierProduct source = (SupplierProduct) sourceEntity;

      mergeId(source.getId());
      mergeProductName(source.getProductName());
      mergeProductDescription(source.getProductDescription());
      mergeProductUnit(source.getProductUnit());
      mergeSupplier(source.getSupplier());
      mergeVersion(source.getVersion());
      mergeProductSupplyDurationList(source.getProductSupplyDurationList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof SupplierProduct) {

      SupplierProduct source = (SupplierProduct) sourceEntity;

      mergeId(source.getId());
      mergeProductName(source.getProductName());
      mergeProductDescription(source.getProductDescription());
      mergeProductUnit(source.getProductUnit());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(),
      getProductName(),
      getProductDescription(),
      getProductUnit(),
      getSupplier(),
      getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    SupplierProduct checkSupplierProduct =
        Q.supplierProductWithIdField()
            .filterById(id)
            .selectProductSupplyDurationList(Q.productSupplyDurationWithIdField().limit(0, 1))
            .execute(ctx);

    return checkSupplierProduct != null
        && !checkSupplierProduct.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public SupplierProduct save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("SupplierProduct{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tproductName='" + getProductName() + "';");
    stringBuilder.append("\tproductDescription='" + getProductDescription() + "';");
    stringBuilder.append("\tproductUnit='" + getProductUnit() + "';");
    if (getSupplier() != null) {
      stringBuilder.append("\tsupplier='GoodsSupplier(" + getSupplier().getId() + ")';");
    }
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
