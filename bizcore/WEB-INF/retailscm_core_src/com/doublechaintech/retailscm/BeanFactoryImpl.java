package com.doublechaintech.retailscm;

import java.util.Map;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.catalog.Catalog;
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategory;
import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory;
import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory;
import com.doublechaintech.retailscm.product.Product;
import com.doublechaintech.retailscm.sku.Sku;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.citypartner.CityPartner;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.doublechaintech.retailscm.cityevent.CityEvent;
import com.doublechaintech.retailscm.eventattendance.EventAttendance;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising;
import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening;
import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItem;
import com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroup;
import com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroup;
import com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustment;
import com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCoupon;
import com.doublechaintech.retailscm.memberwishlist.MemberWishlist;
import com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPoint;
import com.doublechaintech.retailscm.memberrewardpointredemption.MemberRewardPointRedemption;
import com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProduct;
import com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddress;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.supplierproduct.SupplierProduct;
import com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDuration;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItem;
import com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroup;
import com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroup;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItem;
import com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroup;
import com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroup;
import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.storagespace.StorageSpace;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount;
import com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrack;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.goodsmovement.GoodsMovement;
import com.doublechaintech.retailscm.supplierspace.SupplierSpace;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.damagespace.DamageSpace;
import com.doublechaintech.retailscm.warehouseasset.WarehouseAsset;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;
import com.doublechaintech.retailscm.transporttruck.TransportTruck;
import com.doublechaintech.retailscm.truckdriver.TruckDriver;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrack;
import com.doublechaintech.retailscm.accountset.AccountSet;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubject;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.originalvoucher.OriginalVoucher;
import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLine;
import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment;
import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.doublechaintech.retailscm.skilltype.SkillType;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;
import com.doublechaintech.retailscm.terminationreason.TerminationReason;
import com.doublechaintech.retailscm.terminationtype.TerminationType;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.leavetype.LeaveType;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.interviewtype.InterviewType;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType;
import com.doublechaintech.retailscm.publicholiday.PublicHoliday;
import com.doublechaintech.retailscm.termination.Termination;
import com.doublechaintech.retailscm.view.View;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.instructor.Instructor;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;
import com.doublechaintech.retailscm.scoring.Scoring;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkill;
import com.doublechaintech.retailscm.employeeperformance.EmployeePerformance;
import com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperience;
import com.doublechaintech.retailscm.employeeleave.EmployeeLeave;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterview;
import com.doublechaintech.retailscm.employeeattendance.EmployeeAttendance;
import com.doublechaintech.retailscm.employeequalifier.EmployeeQualifier;
import com.doublechaintech.retailscm.employeeeducation.EmployeeEducation;
import com.doublechaintech.retailscm.employeeaward.EmployeeAward;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.doublechaintech.retailscm.payingoff.PayingOff;
import com.doublechaintech.retailscm.mobileapp.MobileApp;
import com.doublechaintech.retailscm.page.Page;
import com.doublechaintech.retailscm.pagetype.PageType;
import com.doublechaintech.retailscm.slide.Slide;
import com.doublechaintech.retailscm.uiaction.UiAction;
import com.doublechaintech.retailscm.section.Section;
import com.doublechaintech.retailscm.userdomain.UserDomain;
import com.doublechaintech.retailscm.userallowlist.UserAllowList;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.quicklink.QuickLink;
import com.doublechaintech.retailscm.listaccess.ListAccess;
import com.doublechaintech.retailscm.loginhistory.LoginHistory;
import com.doublechaintech.retailscm.candidatecontainer.CandidateContainer;
import com.doublechaintech.retailscm.candidateelement.CandidateElement;
import com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentity;
import com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentity;
import com.doublechaintech.retailscm.keypairidentity.KeyPairIdentity;
import com.doublechaintech.retailscm.publickeytype.PublicKeyType;
import com.doublechaintech.retailscm.treenode.TreeNode;

public class BeanFactoryImpl {

  public RetailStoreCountryCenter createRetailStoreCountryCenter(Map<String, Object> options) {
    return new RetailStoreCountryCenter();
  }

  public Catalog createCatalog(Map<String, Object> options) {
    return new Catalog();
  }

  public LevelOneCategory createLevelOneCategory(Map<String, Object> options) {
    return new LevelOneCategory();
  }

  public LevelTwoCategory createLevelTwoCategory(Map<String, Object> options) {
    return new LevelTwoCategory();
  }

  public LevelThreeCategory createLevelThreeCategory(Map<String, Object> options) {
    return new LevelThreeCategory();
  }

  public Product createProduct(Map<String, Object> options) {
    return new Product();
  }

  public Sku createSku(Map<String, Object> options) {
    return new Sku();
  }

  public RetailStoreProvinceCenter createRetailStoreProvinceCenter(Map<String, Object> options) {
    return new RetailStoreProvinceCenter();
  }

  public ProvinceCenterDepartment createProvinceCenterDepartment(Map<String, Object> options) {
    return new ProvinceCenterDepartment();
  }

  public ProvinceCenterEmployee createProvinceCenterEmployee(Map<String, Object> options) {
    return new ProvinceCenterEmployee();
  }

  public RetailStoreCityServiceCenter createRetailStoreCityServiceCenter(
      Map<String, Object> options) {
    return new RetailStoreCityServiceCenter();
  }

  public CityPartner createCityPartner(Map<String, Object> options) {
    return new CityPartner();
  }

  public PotentialCustomer createPotentialCustomer(Map<String, Object> options) {
    return new PotentialCustomer();
  }

  public PotentialCustomerContactPerson createPotentialCustomerContactPerson(
      Map<String, Object> options) {
    return new PotentialCustomerContactPerson();
  }

  public PotentialCustomerContact createPotentialCustomerContact(Map<String, Object> options) {
    return new PotentialCustomerContact();
  }

  public CityEvent createCityEvent(Map<String, Object> options) {
    return new CityEvent();
  }

  public EventAttendance createEventAttendance(Map<String, Object> options) {
    return new EventAttendance();
  }

  public RetailStore createRetailStore(Map<String, Object> options) {
    return new RetailStore();
  }

  public RetailStoreCreation createRetailStoreCreation(Map<String, Object> options) {
    return new RetailStoreCreation();
  }

  public RetailStoreInvestmentInvitation createRetailStoreInvestmentInvitation(
      Map<String, Object> options) {
    return new RetailStoreInvestmentInvitation();
  }

  public RetailStoreFranchising createRetailStoreFranchising(Map<String, Object> options) {
    return new RetailStoreFranchising();
  }

  public RetailStoreDecoration createRetailStoreDecoration(Map<String, Object> options) {
    return new RetailStoreDecoration();
  }

  public RetailStoreOpening createRetailStoreOpening(Map<String, Object> options) {
    return new RetailStoreOpening();
  }

  public RetailStoreClosing createRetailStoreClosing(Map<String, Object> options) {
    return new RetailStoreClosing();
  }

  public RetailStoreMember createRetailStoreMember(Map<String, Object> options) {
    return new RetailStoreMember();
  }

  public ConsumerOrder createConsumerOrder(Map<String, Object> options) {
    return new ConsumerOrder();
  }

  public ConsumerOrderLineItem createConsumerOrderLineItem(Map<String, Object> options) {
    return new ConsumerOrderLineItem();
  }

  public ConsumerOrderShippingGroup createConsumerOrderShippingGroup(Map<String, Object> options) {
    return new ConsumerOrderShippingGroup();
  }

  public ConsumerOrderPaymentGroup createConsumerOrderPaymentGroup(Map<String, Object> options) {
    return new ConsumerOrderPaymentGroup();
  }

  public ConsumerOrderPriceAdjustment createConsumerOrderPriceAdjustment(
      Map<String, Object> options) {
    return new ConsumerOrderPriceAdjustment();
  }

  public RetailStoreMemberCoupon createRetailStoreMemberCoupon(Map<String, Object> options) {
    return new RetailStoreMemberCoupon();
  }

  public MemberWishlist createMemberWishlist(Map<String, Object> options) {
    return new MemberWishlist();
  }

  public MemberRewardPoint createMemberRewardPoint(Map<String, Object> options) {
    return new MemberRewardPoint();
  }

  public MemberRewardPointRedemption createMemberRewardPointRedemption(
      Map<String, Object> options) {
    return new MemberRewardPointRedemption();
  }

  public MemberWishlistProduct createMemberWishlistProduct(Map<String, Object> options) {
    return new MemberWishlistProduct();
  }

  public RetailStoreMemberAddress createRetailStoreMemberAddress(Map<String, Object> options) {
    return new RetailStoreMemberAddress();
  }

  public RetailStoreMemberGiftCard createRetailStoreMemberGiftCard(Map<String, Object> options) {
    return new RetailStoreMemberGiftCard();
  }

  public RetailStoreMemberGiftCardConsumeRecord createRetailStoreMemberGiftCardConsumeRecord(
      Map<String, Object> options) {
    return new RetailStoreMemberGiftCardConsumeRecord();
  }

  public GoodsSupplier createGoodsSupplier(Map<String, Object> options) {
    return new GoodsSupplier();
  }

  public SupplierProduct createSupplierProduct(Map<String, Object> options) {
    return new SupplierProduct();
  }

  public ProductSupplyDuration createProductSupplyDuration(Map<String, Object> options) {
    return new ProductSupplyDuration();
  }

  public SupplyOrder createSupplyOrder(Map<String, Object> options) {
    return new SupplyOrder();
  }

  public SupplyOrderLineItem createSupplyOrderLineItem(Map<String, Object> options) {
    return new SupplyOrderLineItem();
  }

  public SupplyOrderShippingGroup createSupplyOrderShippingGroup(Map<String, Object> options) {
    return new SupplyOrderShippingGroup();
  }

  public SupplyOrderPaymentGroup createSupplyOrderPaymentGroup(Map<String, Object> options) {
    return new SupplyOrderPaymentGroup();
  }

  public RetailStoreOrder createRetailStoreOrder(Map<String, Object> options) {
    return new RetailStoreOrder();
  }

  public RetailStoreOrderLineItem createRetailStoreOrderLineItem(Map<String, Object> options) {
    return new RetailStoreOrderLineItem();
  }

  public RetailStoreOrderShippingGroup createRetailStoreOrderShippingGroup(
      Map<String, Object> options) {
    return new RetailStoreOrderShippingGroup();
  }

  public RetailStoreOrderPaymentGroup createRetailStoreOrderPaymentGroup(
      Map<String, Object> options) {
    return new RetailStoreOrderPaymentGroup();
  }

  public Warehouse createWarehouse(Map<String, Object> options) {
    return new Warehouse();
  }

  public StorageSpace createStorageSpace(Map<String, Object> options) {
    return new StorageSpace();
  }

  public SmartPallet createSmartPallet(Map<String, Object> options) {
    return new SmartPallet();
  }

  public GoodsShelf createGoodsShelf(Map<String, Object> options) {
    return new GoodsShelf();
  }

  public GoodsShelfStockCount createGoodsShelfStockCount(Map<String, Object> options) {
    return new GoodsShelfStockCount();
  }

  public StockCountIssueTrack createStockCountIssueTrack(Map<String, Object> options) {
    return new StockCountIssueTrack();
  }

  public GoodsAllocation createGoodsAllocation(Map<String, Object> options) {
    return new GoodsAllocation();
  }

  public Goods createGoods(Map<String, Object> options) {
    return new Goods();
  }

  public GoodsMovement createGoodsMovement(Map<String, Object> options) {
    return new GoodsMovement();
  }

  public SupplierSpace createSupplierSpace(Map<String, Object> options) {
    return new SupplierSpace();
  }

  public ReceivingSpace createReceivingSpace(Map<String, Object> options) {
    return new ReceivingSpace();
  }

  public ShippingSpace createShippingSpace(Map<String, Object> options) {
    return new ShippingSpace();
  }

  public DamageSpace createDamageSpace(Map<String, Object> options) {
    return new DamageSpace();
  }

  public WarehouseAsset createWarehouseAsset(Map<String, Object> options) {
    return new WarehouseAsset();
  }

  public TransportFleet createTransportFleet(Map<String, Object> options) {
    return new TransportFleet();
  }

  public TransportTruck createTransportTruck(Map<String, Object> options) {
    return new TransportTruck();
  }

  public TruckDriver createTruckDriver(Map<String, Object> options) {
    return new TruckDriver();
  }

  public TransportTask createTransportTask(Map<String, Object> options) {
    return new TransportTask();
  }

  public TransportTaskTrack createTransportTaskTrack(Map<String, Object> options) {
    return new TransportTaskTrack();
  }

  public AccountSet createAccountSet(Map<String, Object> options) {
    return new AccountSet();
  }

  public AccountingSubject createAccountingSubject(Map<String, Object> options) {
    return new AccountingSubject();
  }

  public AccountingPeriod createAccountingPeriod(Map<String, Object> options) {
    return new AccountingPeriod();
  }

  public AccountingDocumentType createAccountingDocumentType(Map<String, Object> options) {
    return new AccountingDocumentType();
  }

  public AccountingDocument createAccountingDocument(Map<String, Object> options) {
    return new AccountingDocument();
  }

  public OriginalVoucher createOriginalVoucher(Map<String, Object> options) {
    return new OriginalVoucher();
  }

  public AccountingDocumentLine createAccountingDocumentLine(Map<String, Object> options) {
    return new AccountingDocumentLine();
  }

  public LevelOneDepartment createLevelOneDepartment(Map<String, Object> options) {
    return new LevelOneDepartment();
  }

  public LevelTwoDepartment createLevelTwoDepartment(Map<String, Object> options) {
    return new LevelTwoDepartment();
  }

  public LevelThreeDepartment createLevelThreeDepartment(Map<String, Object> options) {
    return new LevelThreeDepartment();
  }

  public SkillType createSkillType(Map<String, Object> options) {
    return new SkillType();
  }

  public ResponsibilityType createResponsibilityType(Map<String, Object> options) {
    return new ResponsibilityType();
  }

  public TerminationReason createTerminationReason(Map<String, Object> options) {
    return new TerminationReason();
  }

  public TerminationType createTerminationType(Map<String, Object> options) {
    return new TerminationType();
  }

  public OccupationType createOccupationType(Map<String, Object> options) {
    return new OccupationType();
  }

  public LeaveType createLeaveType(Map<String, Object> options) {
    return new LeaveType();
  }

  public SalaryGrade createSalaryGrade(Map<String, Object> options) {
    return new SalaryGrade();
  }

  public InterviewType createInterviewType(Map<String, Object> options) {
    return new InterviewType();
  }

  public TrainingCourseType createTrainingCourseType(Map<String, Object> options) {
    return new TrainingCourseType();
  }

  public PublicHoliday createPublicHoliday(Map<String, Object> options) {
    return new PublicHoliday();
  }

  public Termination createTermination(Map<String, Object> options) {
    return new Termination();
  }

  public View createView(Map<String, Object> options) {
    return new View();
  }

  public Employee createEmployee(Map<String, Object> options) {
    return new Employee();
  }

  public Instructor createInstructor(Map<String, Object> options) {
    return new Instructor();
  }

  public CompanyTraining createCompanyTraining(Map<String, Object> options) {
    return new CompanyTraining();
  }

  public Scoring createScoring(Map<String, Object> options) {
    return new Scoring();
  }

  public EmployeeCompanyTraining createEmployeeCompanyTraining(Map<String, Object> options) {
    return new EmployeeCompanyTraining();
  }

  public EmployeeSkill createEmployeeSkill(Map<String, Object> options) {
    return new EmployeeSkill();
  }

  public EmployeePerformance createEmployeePerformance(Map<String, Object> options) {
    return new EmployeePerformance();
  }

  public EmployeeWorkExperience createEmployeeWorkExperience(Map<String, Object> options) {
    return new EmployeeWorkExperience();
  }

  public EmployeeLeave createEmployeeLeave(Map<String, Object> options) {
    return new EmployeeLeave();
  }

  public EmployeeInterview createEmployeeInterview(Map<String, Object> options) {
    return new EmployeeInterview();
  }

  public EmployeeAttendance createEmployeeAttendance(Map<String, Object> options) {
    return new EmployeeAttendance();
  }

  public EmployeeQualifier createEmployeeQualifier(Map<String, Object> options) {
    return new EmployeeQualifier();
  }

  public EmployeeEducation createEmployeeEducation(Map<String, Object> options) {
    return new EmployeeEducation();
  }

  public EmployeeAward createEmployeeAward(Map<String, Object> options) {
    return new EmployeeAward();
  }

  public EmployeeSalarySheet createEmployeeSalarySheet(Map<String, Object> options) {
    return new EmployeeSalarySheet();
  }

  public PayingOff createPayingOff(Map<String, Object> options) {
    return new PayingOff();
  }

  public MobileApp createMobileApp(Map<String, Object> options) {
    return new MobileApp();
  }

  public Page createPage(Map<String, Object> options) {
    return new Page();
  }

  public PageType createPageType(Map<String, Object> options) {
    return new PageType();
  }

  public Slide createSlide(Map<String, Object> options) {
    return new Slide();
  }

  public UiAction createUiAction(Map<String, Object> options) {
    return new UiAction();
  }

  public Section createSection(Map<String, Object> options) {
    return new Section();
  }

  public UserDomain createUserDomain(Map<String, Object> options) {
    return new UserDomain();
  }

  public UserAllowList createUserAllowList(Map<String, Object> options) {
    return new UserAllowList();
  }

  public SecUser createSecUser(Map<String, Object> options) {
    return new SecUser();
  }

  public UserApp createUserApp(Map<String, Object> options) {
    return new UserApp();
  }

  public QuickLink createQuickLink(Map<String, Object> options) {
    return new QuickLink();
  }

  public ListAccess createListAccess(Map<String, Object> options) {
    return new ListAccess();
  }

  public LoginHistory createLoginHistory(Map<String, Object> options) {
    return new LoginHistory();
  }

  public CandidateContainer createCandidateContainer(Map<String, Object> options) {
    return new CandidateContainer();
  }

  public CandidateElement createCandidateElement(Map<String, Object> options) {
    return new CandidateElement();
  }

  public WechatWorkappIdentity createWechatWorkappIdentity(Map<String, Object> options) {
    return new WechatWorkappIdentity();
  }

  public WechatMiniappIdentity createWechatMiniappIdentity(Map<String, Object> options) {
    return new WechatMiniappIdentity();
  }

  public KeyPairIdentity createKeyPairIdentity(Map<String, Object> options) {
    return new KeyPairIdentity();
  }

  public PublicKeyType createPublicKeyType(Map<String, Object> options) {
    return new PublicKeyType();
  }

  public TreeNode createTreeNode(Map<String, Object> options) {
    return new TreeNode();
  }
}
