package com.doublechaintech.retailscm;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.baseelement.CandidateQuery;
import com.terapico.uccaf.BaseUserContext;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class RetailscmCheckerManager extends BaseManagerImpl {
	public SmartList<BaseEntity> requestCandidateValuesForSearch(RetailscmUserContext ctx, String ownerMemberName,
			String ownerId, String resultMemberName, String resutlClassName, String targetClassName, String filterKey, int pageNo) {
		return ((BaseDAO)daoOf(ctx)).requestCandidateValuesForSearch(ownerMemberName, ownerId, resultMemberName,
				resutlClassName, targetClassName, filterKey, pageNo);
	}
	
	protected Object daoOf(RetailscmUserContext ctx) {
		throw new UnsupportedOperationException("You must implement it in your specific Manager implementation");
	}
	
	
	public Object queryCandidates(RetailscmUserContext userContext, CandidateQuery query) throws Exception {
		return new CandidatesUtil().queryCandidates(userContext, query);
	}
	
	public Object queryCandidatesForAssign(RetailscmUserContext userContext, CandidateQuery query) throws Exception {
		return new CandidatesUtil().queryCandidatesForAssign(userContext, query);
	}

	public Object queryCandidatesForSearch(RetailscmUserContext userContext, CandidateQuery query) throws Exception {
		return new CandidatesUtil().queryCandidatesForSearch(userContext, query);
	}
	
	protected RetailscmObjectChecker checkerOf(RetailscmUserContext ctx) {
		return ctx.getChecker();
	}
	private static class AsyncManagerJob extends Thread {
		protected Object me;
		protected Object proxy;
		protected Method method;
		protected Object[] args;
		protected MethodProxy methodProxy;

		public AsyncManagerJob(Object me, Object proxy, Method method, Object[] args, MethodProxy methodProxy) {
			super();
			this.me = me;
			this.proxy = proxy;
			this.method = method;
			this.args = args;
			this.methodProxy = methodProxy;
		}

		@Override
		public void run() {
			try {
				method.setAccessible(true);
				method.invoke(me, args);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
	
	public static final Map<String, Object> EO = new HashMap<>();
	protected Object asyncProxy = null;
	protected Object getAsyncProxy() {
		if (asyncProxy != null) {
			return asyncProxy;
		}
		
		Object me = this;
		MethodInterceptor proxy = new MethodInterceptor() {

			@Override
			public Object intercept(Object proxyObj, Method method, Object[] args, MethodProxy methodProxy)
					throws Throwable {
				new AsyncManagerJob(me, proxyObj, method, args, methodProxy).start();
				return null;
			}
		};
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(me.getClass());
		enhancer.setCallback(proxy);
		return asyncProxy = enhancer.create();
	}
	
	protected void cacheVerifyCode(RetailscmUserContext ctx, String mobile, String verifyCode) {
		String cacheKey = String.format("vcode:%s:%s", mobile, "login");
		ctx.putToCache(cacheKey, verifyCode, RetailscmBaseConstants.DEFAULT_CACHE_TIME_FOR_VCODE);
	}

	protected String getVerifyCodeFromCache(RetailscmUserContext ctx, String mobile) {
		String cacheKey = String.format("vcode:%s:%s", mobile, "login");
		return (String) ctx.getCachedObject(cacheKey, String.class);
	}
	protected void checkVerifyCode(RetailscmUserContext ctx, String inputVerifyCode, String mobile) throws Exception {
		String cachedVerifyCode = getVerifyCodeFromCache(ctx, mobile);
		if (cachedVerifyCode == null) {
			throw new Exception("请先获取验证码");
		}
		if (!cachedVerifyCode.equals(inputVerifyCode)) {
			throw new Exception("验证码不正确");
		}
	}
	
	public com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterManager retailStoreCountryCenterManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreCountryCenterManager();
	}
	public com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO retailStoreCountryCenterDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreCountryCenterDAO();
	}
	public com.doublechaintech.retailscm.catalog.CatalogManager catalogManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getCatalogManager();
	}
	public com.doublechaintech.retailscm.catalog.CatalogDAO catalogDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getCatalogDAO();
	}
	public com.doublechaintech.retailscm.levelonecategory.LevelOneCategoryManager levelOneCategoryManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getLevelOneCategoryManager();
	}
	public com.doublechaintech.retailscm.levelonecategory.LevelOneCategoryDAO levelOneCategoryDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getLevelOneCategoryDAO();
	}
	public com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategoryManager levelTwoCategoryManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getLevelTwoCategoryManager();
	}
	public com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategoryDAO levelTwoCategoryDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getLevelTwoCategoryDAO();
	}
	public com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategoryManager levelThreeCategoryManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getLevelThreeCategoryManager();
	}
	public com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategoryDAO levelThreeCategoryDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getLevelThreeCategoryDAO();
	}
	public com.doublechaintech.retailscm.product.ProductManager productManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getProductManager();
	}
	public com.doublechaintech.retailscm.product.ProductDAO productDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getProductDAO();
	}
	public com.doublechaintech.retailscm.sku.SkuManager skuManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getSkuManager();
	}
	public com.doublechaintech.retailscm.sku.SkuDAO skuDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getSkuDAO();
	}
	public com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterManager retailStoreProvinceCenterManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreProvinceCenterManager();
	}
	public com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterDAO retailStoreProvinceCenterDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreProvinceCenterDAO();
	}
	public com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartmentManager provinceCenterDepartmentManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getProvinceCenterDepartmentManager();
	}
	public com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartmentDAO provinceCenterDepartmentDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getProvinceCenterDepartmentDAO();
	}
	public com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployeeManager provinceCenterEmployeeManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getProvinceCenterEmployeeManager();
	}
	public com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployeeDAO provinceCenterEmployeeDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getProvinceCenterEmployeeDAO();
	}
	public com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterManager retailStoreCityServiceCenterManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreCityServiceCenterManager();
	}
	public com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterDAO retailStoreCityServiceCenterDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreCityServiceCenterDAO();
	}
	public com.doublechaintech.retailscm.citypartner.CityPartnerManager cityPartnerManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getCityPartnerManager();
	}
	public com.doublechaintech.retailscm.citypartner.CityPartnerDAO cityPartnerDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getCityPartnerDAO();
	}
	public com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerManager potentialCustomerManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getPotentialCustomerManager();
	}
	public com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerDAO potentialCustomerDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getPotentialCustomerDAO();
	}
	public com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPersonManager potentialCustomerContactPersonManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getPotentialCustomerContactPersonManager();
	}
	public com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPersonDAO potentialCustomerContactPersonDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getPotentialCustomerContactPersonDAO();
	}
	public com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContactManager potentialCustomerContactManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getPotentialCustomerContactManager();
	}
	public com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContactDAO potentialCustomerContactDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getPotentialCustomerContactDAO();
	}
	public com.doublechaintech.retailscm.cityevent.CityEventManager cityEventManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getCityEventManager();
	}
	public com.doublechaintech.retailscm.cityevent.CityEventDAO cityEventDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getCityEventDAO();
	}
	public com.doublechaintech.retailscm.eventattendance.EventAttendanceManager eventAttendanceManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getEventAttendanceManager();
	}
	public com.doublechaintech.retailscm.eventattendance.EventAttendanceDAO eventAttendanceDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getEventAttendanceDAO();
	}
	public com.doublechaintech.retailscm.retailstore.RetailStoreManager retailStoreManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreManager();
	}
	public com.doublechaintech.retailscm.retailstore.RetailStoreDAO retailStoreDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreDAO();
	}
	public com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreationManager retailStoreCreationManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreCreationManager();
	}
	public com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreationDAO retailStoreCreationDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreCreationDAO();
	}
	public com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitationManager retailStoreInvestmentInvitationManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreInvestmentInvitationManager();
	}
	public com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitationDAO retailStoreInvestmentInvitationDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreInvestmentInvitationDAO();
	}
	public com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchisingManager retailStoreFranchisingManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreFranchisingManager();
	}
	public com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchisingDAO retailStoreFranchisingDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreFranchisingDAO();
	}
	public com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecorationManager retailStoreDecorationManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreDecorationManager();
	}
	public com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecorationDAO retailStoreDecorationDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreDecorationDAO();
	}
	public com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpeningManager retailStoreOpeningManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreOpeningManager();
	}
	public com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpeningDAO retailStoreOpeningDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreOpeningDAO();
	}
	public com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosingManager retailStoreClosingManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreClosingManager();
	}
	public com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosingDAO retailStoreClosingDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreClosingDAO();
	}
	public com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberManager retailStoreMemberManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreMemberManager();
	}
	public com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberDAO retailStoreMemberDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreMemberDAO();
	}
	public com.doublechaintech.retailscm.consumerorder.ConsumerOrderManager consumerOrderManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getConsumerOrderManager();
	}
	public com.doublechaintech.retailscm.consumerorder.ConsumerOrderDAO consumerOrderDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getConsumerOrderDAO();
	}
	public com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItemManager consumerOrderLineItemManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getConsumerOrderLineItemManager();
	}
	public com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItemDAO consumerOrderLineItemDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getConsumerOrderLineItemDAO();
	}
	public com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroupManager consumerOrderShippingGroupManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getConsumerOrderShippingGroupManager();
	}
	public com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroupDAO consumerOrderShippingGroupDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getConsumerOrderShippingGroupDAO();
	}
	public com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroupManager consumerOrderPaymentGroupManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getConsumerOrderPaymentGroupManager();
	}
	public com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroupDAO consumerOrderPaymentGroupDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getConsumerOrderPaymentGroupDAO();
	}
	public com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustmentManager consumerOrderPriceAdjustmentManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getConsumerOrderPriceAdjustmentManager();
	}
	public com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustmentDAO consumerOrderPriceAdjustmentDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getConsumerOrderPriceAdjustmentDAO();
	}
	public com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCouponManager retailStoreMemberCouponManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreMemberCouponManager();
	}
	public com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCouponDAO retailStoreMemberCouponDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreMemberCouponDAO();
	}
	public com.doublechaintech.retailscm.memberwishlist.MemberWishlistManager memberWishlistManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getMemberWishlistManager();
	}
	public com.doublechaintech.retailscm.memberwishlist.MemberWishlistDAO memberWishlistDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getMemberWishlistDAO();
	}
	public com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPointManager memberRewardPointManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getMemberRewardPointManager();
	}
	public com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPointDAO memberRewardPointDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getMemberRewardPointDAO();
	}
	public com.doublechaintech.retailscm.memberrewardpointredemption.MemberRewardPointRedemptionManager memberRewardPointRedemptionManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getMemberRewardPointRedemptionManager();
	}
	public com.doublechaintech.retailscm.memberrewardpointredemption.MemberRewardPointRedemptionDAO memberRewardPointRedemptionDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getMemberRewardPointRedemptionDAO();
	}
	public com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProductManager memberWishlistProductManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getMemberWishlistProductManager();
	}
	public com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProductDAO memberWishlistProductDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getMemberWishlistProductDAO();
	}
	public com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddressManager retailStoreMemberAddressManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreMemberAddressManager();
	}
	public com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddressDAO retailStoreMemberAddressDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreMemberAddressDAO();
	}
	public com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCardManager retailStoreMemberGiftCardManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreMemberGiftCardManager();
	}
	public com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCardDAO retailStoreMemberGiftCardDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreMemberGiftCardDAO();
	}
	public com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordManager retailStoreMemberGiftCardConsumeRecordManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreMemberGiftCardConsumeRecordManager();
	}
	public com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordDAO retailStoreMemberGiftCardConsumeRecordDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreMemberGiftCardConsumeRecordDAO();
	}
	public com.doublechaintech.retailscm.goodssupplier.GoodsSupplierManager goodsSupplierManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getGoodsSupplierManager();
	}
	public com.doublechaintech.retailscm.goodssupplier.GoodsSupplierDAO goodsSupplierDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getGoodsSupplierDAO();
	}
	public com.doublechaintech.retailscm.supplierproduct.SupplierProductManager supplierProductManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getSupplierProductManager();
	}
	public com.doublechaintech.retailscm.supplierproduct.SupplierProductDAO supplierProductDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getSupplierProductDAO();
	}
	public com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDurationManager productSupplyDurationManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getProductSupplyDurationManager();
	}
	public com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDurationDAO productSupplyDurationDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getProductSupplyDurationDAO();
	}
	public com.doublechaintech.retailscm.supplyorder.SupplyOrderManager supplyOrderManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getSupplyOrderManager();
	}
	public com.doublechaintech.retailscm.supplyorder.SupplyOrderDAO supplyOrderDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getSupplyOrderDAO();
	}
	public com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItemManager supplyOrderLineItemManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getSupplyOrderLineItemManager();
	}
	public com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItemDAO supplyOrderLineItemDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getSupplyOrderLineItemDAO();
	}
	public com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroupManager supplyOrderShippingGroupManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getSupplyOrderShippingGroupManager();
	}
	public com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroupDAO supplyOrderShippingGroupDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getSupplyOrderShippingGroupDAO();
	}
	public com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroupManager supplyOrderPaymentGroupManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getSupplyOrderPaymentGroupManager();
	}
	public com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroupDAO supplyOrderPaymentGroupDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getSupplyOrderPaymentGroupDAO();
	}
	public com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderManager retailStoreOrderManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreOrderManager();
	}
	public com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderDAO retailStoreOrderDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreOrderDAO();
	}
	public com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItemManager retailStoreOrderLineItemManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreOrderLineItemManager();
	}
	public com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItemDAO retailStoreOrderLineItemDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreOrderLineItemDAO();
	}
	public com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroupManager retailStoreOrderShippingGroupManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreOrderShippingGroupManager();
	}
	public com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroupDAO retailStoreOrderShippingGroupDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreOrderShippingGroupDAO();
	}
	public com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroupManager retailStoreOrderPaymentGroupManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getRetailStoreOrderPaymentGroupManager();
	}
	public com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroupDAO retailStoreOrderPaymentGroupDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getRetailStoreOrderPaymentGroupDAO();
	}
	public com.doublechaintech.retailscm.warehouse.WarehouseManager warehouseManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getWarehouseManager();
	}
	public com.doublechaintech.retailscm.warehouse.WarehouseDAO warehouseDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getWarehouseDAO();
	}
	public com.doublechaintech.retailscm.storagespace.StorageSpaceManager storageSpaceManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getStorageSpaceManager();
	}
	public com.doublechaintech.retailscm.storagespace.StorageSpaceDAO storageSpaceDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getStorageSpaceDAO();
	}
	public com.doublechaintech.retailscm.smartpallet.SmartPalletManager smartPalletManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getSmartPalletManager();
	}
	public com.doublechaintech.retailscm.smartpallet.SmartPalletDAO smartPalletDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getSmartPalletDAO();
	}
	public com.doublechaintech.retailscm.goodsshelf.GoodsShelfManager goodsShelfManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getGoodsShelfManager();
	}
	public com.doublechaintech.retailscm.goodsshelf.GoodsShelfDAO goodsShelfDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getGoodsShelfDAO();
	}
	public com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCountManager goodsShelfStockCountManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getGoodsShelfStockCountManager();
	}
	public com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCountDAO goodsShelfStockCountDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getGoodsShelfStockCountDAO();
	}
	public com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrackManager stockCountIssueTrackManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getStockCountIssueTrackManager();
	}
	public com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrackDAO stockCountIssueTrackDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getStockCountIssueTrackDAO();
	}
	public com.doublechaintech.retailscm.goodsallocation.GoodsAllocationManager goodsAllocationManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getGoodsAllocationManager();
	}
	public com.doublechaintech.retailscm.goodsallocation.GoodsAllocationDAO goodsAllocationDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getGoodsAllocationDAO();
	}
	public com.doublechaintech.retailscm.goods.GoodsManager goodsManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getGoodsManager();
	}
	public com.doublechaintech.retailscm.goods.GoodsDAO goodsDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getGoodsDAO();
	}
	public com.doublechaintech.retailscm.goodsmovement.GoodsMovementManager goodsMovementManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getGoodsMovementManager();
	}
	public com.doublechaintech.retailscm.goodsmovement.GoodsMovementDAO goodsMovementDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getGoodsMovementDAO();
	}
	public com.doublechaintech.retailscm.supplierspace.SupplierSpaceManager supplierSpaceManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getSupplierSpaceManager();
	}
	public com.doublechaintech.retailscm.supplierspace.SupplierSpaceDAO supplierSpaceDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getSupplierSpaceDAO();
	}
	public com.doublechaintech.retailscm.receivingspace.ReceivingSpaceManager receivingSpaceManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getReceivingSpaceManager();
	}
	public com.doublechaintech.retailscm.receivingspace.ReceivingSpaceDAO receivingSpaceDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getReceivingSpaceDAO();
	}
	public com.doublechaintech.retailscm.shippingspace.ShippingSpaceManager shippingSpaceManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getShippingSpaceManager();
	}
	public com.doublechaintech.retailscm.shippingspace.ShippingSpaceDAO shippingSpaceDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getShippingSpaceDAO();
	}
	public com.doublechaintech.retailscm.damagespace.DamageSpaceManager damageSpaceManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getDamageSpaceManager();
	}
	public com.doublechaintech.retailscm.damagespace.DamageSpaceDAO damageSpaceDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getDamageSpaceDAO();
	}
	public com.doublechaintech.retailscm.warehouseasset.WarehouseAssetManager warehouseAssetManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getWarehouseAssetManager();
	}
	public com.doublechaintech.retailscm.warehouseasset.WarehouseAssetDAO warehouseAssetDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getWarehouseAssetDAO();
	}
	public com.doublechaintech.retailscm.transportfleet.TransportFleetManager transportFleetManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getTransportFleetManager();
	}
	public com.doublechaintech.retailscm.transportfleet.TransportFleetDAO transportFleetDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getTransportFleetDAO();
	}
	public com.doublechaintech.retailscm.transporttruck.TransportTruckManager transportTruckManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getTransportTruckManager();
	}
	public com.doublechaintech.retailscm.transporttruck.TransportTruckDAO transportTruckDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getTransportTruckDAO();
	}
	public com.doublechaintech.retailscm.truckdriver.TruckDriverManager truckDriverManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getTruckDriverManager();
	}
	public com.doublechaintech.retailscm.truckdriver.TruckDriverDAO truckDriverDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getTruckDriverDAO();
	}
	public com.doublechaintech.retailscm.transporttask.TransportTaskManager transportTaskManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getTransportTaskManager();
	}
	public com.doublechaintech.retailscm.transporttask.TransportTaskDAO transportTaskDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getTransportTaskDAO();
	}
	public com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrackManager transportTaskTrackManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getTransportTaskTrackManager();
	}
	public com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrackDAO transportTaskTrackDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getTransportTaskTrackDAO();
	}
	public com.doublechaintech.retailscm.accountset.AccountSetManager accountSetManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getAccountSetManager();
	}
	public com.doublechaintech.retailscm.accountset.AccountSetDAO accountSetDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getAccountSetDAO();
	}
	public com.doublechaintech.retailscm.accountingsubject.AccountingSubjectManager accountingSubjectManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getAccountingSubjectManager();
	}
	public com.doublechaintech.retailscm.accountingsubject.AccountingSubjectDAO accountingSubjectDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getAccountingSubjectDAO();
	}
	public com.doublechaintech.retailscm.accountingperiod.AccountingPeriodManager accountingPeriodManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getAccountingPeriodManager();
	}
	public com.doublechaintech.retailscm.accountingperiod.AccountingPeriodDAO accountingPeriodDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getAccountingPeriodDAO();
	}
	public com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentTypeManager accountingDocumentTypeManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getAccountingDocumentTypeManager();
	}
	public com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentTypeDAO accountingDocumentTypeDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getAccountingDocumentTypeDAO();
	}
	public com.doublechaintech.retailscm.accountingdocument.AccountingDocumentManager accountingDocumentManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getAccountingDocumentManager();
	}
	public com.doublechaintech.retailscm.accountingdocument.AccountingDocumentDAO accountingDocumentDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getAccountingDocumentDAO();
	}
	public com.doublechaintech.retailscm.originalvoucher.OriginalVoucherManager originalVoucherManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getOriginalVoucherManager();
	}
	public com.doublechaintech.retailscm.originalvoucher.OriginalVoucherDAO originalVoucherDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getOriginalVoucherDAO();
	}
	public com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLineManager accountingDocumentLineManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getAccountingDocumentLineManager();
	}
	public com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLineDAO accountingDocumentLineDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getAccountingDocumentLineDAO();
	}
	public com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartmentManager levelOneDepartmentManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getLevelOneDepartmentManager();
	}
	public com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartmentDAO levelOneDepartmentDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getLevelOneDepartmentDAO();
	}
	public com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartmentManager levelTwoDepartmentManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getLevelTwoDepartmentManager();
	}
	public com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartmentDAO levelTwoDepartmentDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getLevelTwoDepartmentDAO();
	}
	public com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartmentManager levelThreeDepartmentManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getLevelThreeDepartmentManager();
	}
	public com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartmentDAO levelThreeDepartmentDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getLevelThreeDepartmentDAO();
	}
	public com.doublechaintech.retailscm.skilltype.SkillTypeManager skillTypeManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getSkillTypeManager();
	}
	public com.doublechaintech.retailscm.skilltype.SkillTypeDAO skillTypeDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getSkillTypeDAO();
	}
	public com.doublechaintech.retailscm.responsibilitytype.ResponsibilityTypeManager responsibilityTypeManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getResponsibilityTypeManager();
	}
	public com.doublechaintech.retailscm.responsibilitytype.ResponsibilityTypeDAO responsibilityTypeDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getResponsibilityTypeDAO();
	}
	public com.doublechaintech.retailscm.terminationreason.TerminationReasonManager terminationReasonManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getTerminationReasonManager();
	}
	public com.doublechaintech.retailscm.terminationreason.TerminationReasonDAO terminationReasonDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getTerminationReasonDAO();
	}
	public com.doublechaintech.retailscm.terminationtype.TerminationTypeManager terminationTypeManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getTerminationTypeManager();
	}
	public com.doublechaintech.retailscm.terminationtype.TerminationTypeDAO terminationTypeDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getTerminationTypeDAO();
	}
	public com.doublechaintech.retailscm.occupationtype.OccupationTypeManager occupationTypeManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getOccupationTypeManager();
	}
	public com.doublechaintech.retailscm.occupationtype.OccupationTypeDAO occupationTypeDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getOccupationTypeDAO();
	}
	public com.doublechaintech.retailscm.leavetype.LeaveTypeManager leaveTypeManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getLeaveTypeManager();
	}
	public com.doublechaintech.retailscm.leavetype.LeaveTypeDAO leaveTypeDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getLeaveTypeDAO();
	}
	public com.doublechaintech.retailscm.salarygrade.SalaryGradeManager salaryGradeManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getSalaryGradeManager();
	}
	public com.doublechaintech.retailscm.salarygrade.SalaryGradeDAO salaryGradeDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getSalaryGradeDAO();
	}
	public com.doublechaintech.retailscm.interviewtype.InterviewTypeManager interviewTypeManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getInterviewTypeManager();
	}
	public com.doublechaintech.retailscm.interviewtype.InterviewTypeDAO interviewTypeDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getInterviewTypeDAO();
	}
	public com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseTypeManager trainingCourseTypeManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getTrainingCourseTypeManager();
	}
	public com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseTypeDAO trainingCourseTypeDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getTrainingCourseTypeDAO();
	}
	public com.doublechaintech.retailscm.publicholiday.PublicHolidayManager publicHolidayManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getPublicHolidayManager();
	}
	public com.doublechaintech.retailscm.publicholiday.PublicHolidayDAO publicHolidayDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getPublicHolidayDAO();
	}
	public com.doublechaintech.retailscm.termination.TerminationManager terminationManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getTerminationManager();
	}
	public com.doublechaintech.retailscm.termination.TerminationDAO terminationDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getTerminationDAO();
	}
	public com.doublechaintech.retailscm.view.ViewManager viewManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getViewManager();
	}
	public com.doublechaintech.retailscm.view.ViewDAO viewDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getViewDAO();
	}
	public com.doublechaintech.retailscm.employee.EmployeeManager employeeManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getEmployeeManager();
	}
	public com.doublechaintech.retailscm.employee.EmployeeDAO employeeDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getEmployeeDAO();
	}
	public com.doublechaintech.retailscm.instructor.InstructorManager instructorManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getInstructorManager();
	}
	public com.doublechaintech.retailscm.instructor.InstructorDAO instructorDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getInstructorDAO();
	}
	public com.doublechaintech.retailscm.companytraining.CompanyTrainingManager companyTrainingManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getCompanyTrainingManager();
	}
	public com.doublechaintech.retailscm.companytraining.CompanyTrainingDAO companyTrainingDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getCompanyTrainingDAO();
	}
	public com.doublechaintech.retailscm.scoring.ScoringManager scoringManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getScoringManager();
	}
	public com.doublechaintech.retailscm.scoring.ScoringDAO scoringDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getScoringDAO();
	}
	public com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTrainingManager employeeCompanyTrainingManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getEmployeeCompanyTrainingManager();
	}
	public com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTrainingDAO employeeCompanyTrainingDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getEmployeeCompanyTrainingDAO();
	}
	public com.doublechaintech.retailscm.employeeskill.EmployeeSkillManager employeeSkillManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getEmployeeSkillManager();
	}
	public com.doublechaintech.retailscm.employeeskill.EmployeeSkillDAO employeeSkillDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getEmployeeSkillDAO();
	}
	public com.doublechaintech.retailscm.employeeperformance.EmployeePerformanceManager employeePerformanceManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getEmployeePerformanceManager();
	}
	public com.doublechaintech.retailscm.employeeperformance.EmployeePerformanceDAO employeePerformanceDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getEmployeePerformanceDAO();
	}
	public com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperienceManager employeeWorkExperienceManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getEmployeeWorkExperienceManager();
	}
	public com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperienceDAO employeeWorkExperienceDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getEmployeeWorkExperienceDAO();
	}
	public com.doublechaintech.retailscm.employeeleave.EmployeeLeaveManager employeeLeaveManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getEmployeeLeaveManager();
	}
	public com.doublechaintech.retailscm.employeeleave.EmployeeLeaveDAO employeeLeaveDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getEmployeeLeaveDAO();
	}
	public com.doublechaintech.retailscm.employeeinterview.EmployeeInterviewManager employeeInterviewManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getEmployeeInterviewManager();
	}
	public com.doublechaintech.retailscm.employeeinterview.EmployeeInterviewDAO employeeInterviewDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getEmployeeInterviewDAO();
	}
	public com.doublechaintech.retailscm.employeeattendance.EmployeeAttendanceManager employeeAttendanceManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getEmployeeAttendanceManager();
	}
	public com.doublechaintech.retailscm.employeeattendance.EmployeeAttendanceDAO employeeAttendanceDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getEmployeeAttendanceDAO();
	}
	public com.doublechaintech.retailscm.employeequalifier.EmployeeQualifierManager employeeQualifierManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getEmployeeQualifierManager();
	}
	public com.doublechaintech.retailscm.employeequalifier.EmployeeQualifierDAO employeeQualifierDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getEmployeeQualifierDAO();
	}
	public com.doublechaintech.retailscm.employeeeducation.EmployeeEducationManager employeeEducationManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getEmployeeEducationManager();
	}
	public com.doublechaintech.retailscm.employeeeducation.EmployeeEducationDAO employeeEducationDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getEmployeeEducationDAO();
	}
	public com.doublechaintech.retailscm.employeeaward.EmployeeAwardManager employeeAwardManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getEmployeeAwardManager();
	}
	public com.doublechaintech.retailscm.employeeaward.EmployeeAwardDAO employeeAwardDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getEmployeeAwardDAO();
	}
	public com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetManager employeeSalarySheetManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getEmployeeSalarySheetManager();
	}
	public com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetDAO employeeSalarySheetDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getEmployeeSalarySheetDAO();
	}
	public com.doublechaintech.retailscm.payingoff.PayingOffManager payingOffManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getPayingOffManager();
	}
	public com.doublechaintech.retailscm.payingoff.PayingOffDAO payingOffDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getPayingOffDAO();
	}
	public com.doublechaintech.retailscm.mobileapp.MobileAppManager mobileAppManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getMobileAppManager();
	}
	public com.doublechaintech.retailscm.mobileapp.MobileAppDAO mobileAppDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getMobileAppDAO();
	}
	public com.doublechaintech.retailscm.page.PageManager pageManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getPageManager();
	}
	public com.doublechaintech.retailscm.page.PageDAO pageDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getPageDAO();
	}
	public com.doublechaintech.retailscm.pagetype.PageTypeManager pageTypeManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getPageTypeManager();
	}
	public com.doublechaintech.retailscm.pagetype.PageTypeDAO pageTypeDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getPageTypeDAO();
	}
	public com.doublechaintech.retailscm.slide.SlideManager slideManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getSlideManager();
	}
	public com.doublechaintech.retailscm.slide.SlideDAO slideDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getSlideDAO();
	}
	public com.doublechaintech.retailscm.uiaction.UiActionManager uiActionManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getUiActionManager();
	}
	public com.doublechaintech.retailscm.uiaction.UiActionDAO uiActionDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getUiActionDAO();
	}
	public com.doublechaintech.retailscm.section.SectionManager sectionManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getSectionManager();
	}
	public com.doublechaintech.retailscm.section.SectionDAO sectionDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getSectionDAO();
	}
	public com.doublechaintech.retailscm.userdomain.UserDomainManager userDomainManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getUserDomainManager();
	}
	public com.doublechaintech.retailscm.userdomain.UserDomainDAO userDomainDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getUserDomainDAO();
	}
	public com.doublechaintech.retailscm.userallowlist.UserAllowListManager userAllowListManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getUserAllowListManager();
	}
	public com.doublechaintech.retailscm.userallowlist.UserAllowListDAO userAllowListDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getUserAllowListDAO();
	}
	public com.doublechaintech.retailscm.secuser.SecUserManager secUserManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getSecUserManager();
	}
	public com.doublechaintech.retailscm.secuser.SecUserDAO secUserDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getSecUserDAO();
	}
	public com.doublechaintech.retailscm.userapp.UserAppManager userAppManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getUserAppManager();
	}
	public com.doublechaintech.retailscm.userapp.UserAppDAO userAppDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getUserAppDAO();
	}
	public com.doublechaintech.retailscm.quicklink.QuickLinkManager quickLinkManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getQuickLinkManager();
	}
	public com.doublechaintech.retailscm.quicklink.QuickLinkDAO quickLinkDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getQuickLinkDAO();
	}
	public com.doublechaintech.retailscm.listaccess.ListAccessManager listAccessManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getListAccessManager();
	}
	public com.doublechaintech.retailscm.listaccess.ListAccessDAO listAccessDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getListAccessDAO();
	}
	public com.doublechaintech.retailscm.loginhistory.LoginHistoryManager loginHistoryManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getLoginHistoryManager();
	}
	public com.doublechaintech.retailscm.loginhistory.LoginHistoryDAO loginHistoryDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getLoginHistoryDAO();
	}
	public com.doublechaintech.retailscm.candidatecontainer.CandidateContainerManager candidateContainerManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getCandidateContainerManager();
	}
	public com.doublechaintech.retailscm.candidatecontainer.CandidateContainerDAO candidateContainerDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getCandidateContainerDAO();
	}
	public com.doublechaintech.retailscm.candidateelement.CandidateElementManager candidateElementManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getCandidateElementManager();
	}
	public com.doublechaintech.retailscm.candidateelement.CandidateElementDAO candidateElementDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getCandidateElementDAO();
	}
	public com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentityManager wechatWorkappIdentityManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getWechatWorkappIdentityManager();
	}
	public com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentityDAO wechatWorkappIdentityDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getWechatWorkappIdentityDAO();
	}
	public com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentityManager wechatMiniappIdentityManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getWechatMiniappIdentityManager();
	}
	public com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentityDAO wechatMiniappIdentityDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getWechatMiniappIdentityDAO();
	}
	public com.doublechaintech.retailscm.keypairidentity.KeypairIdentityManager keypairIdentityManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getKeypairIdentityManager();
	}
	public com.doublechaintech.retailscm.keypairidentity.KeypairIdentityDAO keypairIdentityDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getKeypairIdentityDAO();
	}
	public com.doublechaintech.retailscm.publickeytype.PublicKeyTypeManager publicKeyTypeManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getPublicKeyTypeManager();
	}
	public com.doublechaintech.retailscm.publickeytype.PublicKeyTypeDAO publicKeyTypeDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getPublicKeyTypeDAO();
	}
	public com.doublechaintech.retailscm.treenode.TreeNodeManager treeNodeManagerOf(RetailscmUserContext userContext){
		return userContext.getManagerGroup().getTreeNodeManager();
	}
	public com.doublechaintech.retailscm.treenode.TreeNodeDAO treeNodeDaoOf(RetailscmUserContext userContext){
		return userContext.getDAOGroup().getTreeNodeDAO();
	}
	
	
	
	

	protected void checkGender(String gender, int i, int j,String targetFieldName, List<Message> messageList) {
		
		
	}
	
	//for stub only
	protected void checkDateNow(Date likeTime, int i, Object now,
			String targetFieldName, RetailscmException exception) {
		
		
	}


	protected Object now() {

		return null;
	}
	
	protected boolean isValidIdentifier(String value){
		return hasVisualChar(value);
		
	}
	
	protected boolean hasVisualChar(String value){
		if(value==null){
			return false;
		}
		if(value.isEmpty()){
			return false;
		}
		if(value.trim().isEmpty()){
			return false;
		}
		return true;
		
	}
	protected void checkBigDecimalRange(BigDecimal projectArea, double i, double j, String projectAreaOfProject,
			List<Message> messageList) {
		
	}
    
}


















