
package com.doublechaintech.retailscm.retailstoremember;

import com.doublechaintech.retailscm.Beans;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

import com.terapico.caf.baseelement.CandidateQuery;
import com.terapico.utils.TextUtil;

import com.doublechaintech.retailscm.RetailscmBaseDAOImpl;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.DateKey;
import com.doublechaintech.retailscm.StatsInfo;
import com.doublechaintech.retailscm.StatsItem;

import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;


import com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPoint;
import com.doublechaintech.retailscm.memberrewardpointredemption.MemberRewardPointRedemption;
import com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCoupon;
import com.doublechaintech.retailscm.memberwishlist.MemberWishlist;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddress;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;

import com.doublechaintech.retailscm.consumerorder.ConsumerOrderDAO;
import com.doublechaintech.retailscm.memberwishlist.MemberWishlistDAO;
import com.doublechaintech.retailscm.memberrewardpointredemption.MemberRewardPointRedemptionDAO;
import com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPointDAO;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCardDAO;
import com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddressDAO;
import com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCouponDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class RetailStoreMemberJDBCTemplateDAO extends RetailscmBaseDAOImpl implements RetailStoreMemberDAO{

	protected RetailStoreCountryCenterDAO retailStoreCountryCenterDAO;
	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){

 		if(retailStoreCountryCenterDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreCountryCenterDAO to null.");
 		}
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
 		if(this.retailStoreCountryCenterDAO == null){
 			throw new IllegalStateException("The retailStoreCountryCenterDAO is not configured yet, please config it some where.");
 		}

	 	return this.retailStoreCountryCenterDAO;
 	}

	protected ConsumerOrderDAO consumerOrderDAO;
	public void setConsumerOrderDAO(ConsumerOrderDAO consumerOrderDAO){

 		if(consumerOrderDAO == null){
 			throw new IllegalStateException("Do not try to set consumerOrderDAO to null.");
 		}
	 	this.consumerOrderDAO = consumerOrderDAO;
 	}
 	public ConsumerOrderDAO getConsumerOrderDAO(){
 		if(this.consumerOrderDAO == null){
 			throw new IllegalStateException("The consumerOrderDAO is not configured yet, please config it some where.");
 		}

	 	return this.consumerOrderDAO;
 	}

	protected RetailStoreMemberCouponDAO retailStoreMemberCouponDAO;
	public void setRetailStoreMemberCouponDAO(RetailStoreMemberCouponDAO retailStoreMemberCouponDAO){

 		if(retailStoreMemberCouponDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreMemberCouponDAO to null.");
 		}
	 	this.retailStoreMemberCouponDAO = retailStoreMemberCouponDAO;
 	}
 	public RetailStoreMemberCouponDAO getRetailStoreMemberCouponDAO(){
 		if(this.retailStoreMemberCouponDAO == null){
 			throw new IllegalStateException("The retailStoreMemberCouponDAO is not configured yet, please config it some where.");
 		}

	 	return this.retailStoreMemberCouponDAO;
 	}

	protected MemberWishlistDAO memberWishlistDAO;
	public void setMemberWishlistDAO(MemberWishlistDAO memberWishlistDAO){

 		if(memberWishlistDAO == null){
 			throw new IllegalStateException("Do not try to set memberWishlistDAO to null.");
 		}
	 	this.memberWishlistDAO = memberWishlistDAO;
 	}
 	public MemberWishlistDAO getMemberWishlistDAO(){
 		if(this.memberWishlistDAO == null){
 			throw new IllegalStateException("The memberWishlistDAO is not configured yet, please config it some where.");
 		}

	 	return this.memberWishlistDAO;
 	}

	protected MemberRewardPointDAO memberRewardPointDAO;
	public void setMemberRewardPointDAO(MemberRewardPointDAO memberRewardPointDAO){

 		if(memberRewardPointDAO == null){
 			throw new IllegalStateException("Do not try to set memberRewardPointDAO to null.");
 		}
	 	this.memberRewardPointDAO = memberRewardPointDAO;
 	}
 	public MemberRewardPointDAO getMemberRewardPointDAO(){
 		if(this.memberRewardPointDAO == null){
 			throw new IllegalStateException("The memberRewardPointDAO is not configured yet, please config it some where.");
 		}

	 	return this.memberRewardPointDAO;
 	}

	protected MemberRewardPointRedemptionDAO memberRewardPointRedemptionDAO;
	public void setMemberRewardPointRedemptionDAO(MemberRewardPointRedemptionDAO memberRewardPointRedemptionDAO){

 		if(memberRewardPointRedemptionDAO == null){
 			throw new IllegalStateException("Do not try to set memberRewardPointRedemptionDAO to null.");
 		}
	 	this.memberRewardPointRedemptionDAO = memberRewardPointRedemptionDAO;
 	}
 	public MemberRewardPointRedemptionDAO getMemberRewardPointRedemptionDAO(){
 		if(this.memberRewardPointRedemptionDAO == null){
 			throw new IllegalStateException("The memberRewardPointRedemptionDAO is not configured yet, please config it some where.");
 		}

	 	return this.memberRewardPointRedemptionDAO;
 	}

	protected RetailStoreMemberAddressDAO retailStoreMemberAddressDAO;
	public void setRetailStoreMemberAddressDAO(RetailStoreMemberAddressDAO retailStoreMemberAddressDAO){

 		if(retailStoreMemberAddressDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreMemberAddressDAO to null.");
 		}
	 	this.retailStoreMemberAddressDAO = retailStoreMemberAddressDAO;
 	}
 	public RetailStoreMemberAddressDAO getRetailStoreMemberAddressDAO(){
 		if(this.retailStoreMemberAddressDAO == null){
 			throw new IllegalStateException("The retailStoreMemberAddressDAO is not configured yet, please config it some where.");
 		}

	 	return this.retailStoreMemberAddressDAO;
 	}

	protected RetailStoreMemberGiftCardDAO retailStoreMemberGiftCardDAO;
	public void setRetailStoreMemberGiftCardDAO(RetailStoreMemberGiftCardDAO retailStoreMemberGiftCardDAO){

 		if(retailStoreMemberGiftCardDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreMemberGiftCardDAO to null.");
 		}
	 	this.retailStoreMemberGiftCardDAO = retailStoreMemberGiftCardDAO;
 	}
 	public RetailStoreMemberGiftCardDAO getRetailStoreMemberGiftCardDAO(){
 		if(this.retailStoreMemberGiftCardDAO == null){
 			throw new IllegalStateException("The retailStoreMemberGiftCardDAO is not configured yet, please config it some where.");
 		}

	 	return this.retailStoreMemberGiftCardDAO;
 	}



	/*
	protected RetailStoreMember load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreMember(accessKey, options);
	}
	*/

	public SmartList<RetailStoreMember> loadAll() {
	    return this.loadAll(getRetailStoreMemberMapper());
	}

  public Stream<RetailStoreMember> loadAllAsStream() {
      return this.loadAllAsStream(getRetailStoreMemberMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public RetailStoreMember load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreMember(RetailStoreMemberTable.withId(id), options);
	}

	

	public RetailStoreMember save(RetailStoreMember retailStoreMember,Map<String,Object> options){

		String methodName="save(RetailStoreMember retailStoreMember,Map<String,Object> options)";

		assertMethodArgumentNotNull(retailStoreMember, methodName, "retailStoreMember");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalRetailStoreMember(retailStoreMember,options);
	}
	public RetailStoreMember clone(String retailStoreMemberId, Map<String,Object> options) throws Exception{

		return clone(RetailStoreMemberTable.withId(retailStoreMemberId),options);
	}

	protected RetailStoreMember clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String retailStoreMemberId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		RetailStoreMember newRetailStoreMember = loadInternalRetailStoreMember(accessKey, options);
		newRetailStoreMember.setVersion(0);
		
		

 		if(isSaveConsumerOrderListEnabled(options)){
 			for(ConsumerOrder item: newRetailStoreMember.getConsumerOrderList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveRetailStoreMemberCouponListEnabled(options)){
 			for(RetailStoreMemberCoupon item: newRetailStoreMember.getRetailStoreMemberCouponList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveMemberWishlistListEnabled(options)){
 			for(MemberWishlist item: newRetailStoreMember.getMemberWishlistList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveMemberRewardPointListEnabled(options)){
 			for(MemberRewardPoint item: newRetailStoreMember.getMemberRewardPointList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveMemberRewardPointRedemptionListEnabled(options)){
 			for(MemberRewardPointRedemption item: newRetailStoreMember.getMemberRewardPointRedemptionList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveRetailStoreMemberAddressListEnabled(options)){
 			for(RetailStoreMemberAddress item: newRetailStoreMember.getRetailStoreMemberAddressList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveRetailStoreMemberGiftCardListEnabled(options)){
 			for(RetailStoreMemberGiftCard item: newRetailStoreMember.getRetailStoreMemberGiftCardList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalRetailStoreMember(newRetailStoreMember,options);

		return newRetailStoreMember;
	}

	



	protected void throwIfHasException(String retailStoreMemberId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RetailStoreMemberVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreMemberNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreMemberId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String retailStoreMemberId, int version) throws Exception{

		String methodName="delete(String retailStoreMemberId, int version)";
		assertMethodArgumentNotNull(retailStoreMemberId, methodName, "retailStoreMemberId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreMemberId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreMemberId,version);
		}


	}






	public RetailStoreMember disconnectFromAll(String retailStoreMemberId, int version) throws Exception{


		RetailStoreMember retailStoreMember = loadInternalRetailStoreMember(RetailStoreMemberTable.withId(retailStoreMemberId), emptyOptions());
		retailStoreMember.clearFromAll();
		this.saveRetailStoreMember(retailStoreMember);
		return retailStoreMember;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return RetailStoreMemberTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "retail_store_member";
	}
	@Override
	protected String getBeanName() {

		return "retailStoreMember";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return RetailStoreMemberTokens.checkOptions(options, optionToCheck);

	}



 	protected boolean isExtractOwnerEnabled(Map<String,Object> options){

	 	return checkOptions(options, RetailStoreMemberTokens.OWNER);
 	}

 	protected boolean isSaveOwnerEnabled(Map<String,Object> options){

 		return checkOptions(options, RetailStoreMemberTokens.OWNER);
 	}



 
		

	protected boolean isExtractConsumerOrderListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreMemberTokens.CONSUMER_ORDER_LIST);
 	}
 	protected boolean isAnalyzeConsumerOrderListEnabled(Map<String,Object> options){
 		return RetailStoreMemberTokens.of(options).analyzeConsumerOrderListEnabled();
 	}

	protected boolean isSaveConsumerOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreMemberTokens.CONSUMER_ORDER_LIST);

 	}

		

	protected boolean isExtractRetailStoreMemberCouponListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreMemberTokens.RETAIL_STORE_MEMBER_COUPON_LIST);
 	}
 	protected boolean isAnalyzeRetailStoreMemberCouponListEnabled(Map<String,Object> options){
 		return RetailStoreMemberTokens.of(options).analyzeRetailStoreMemberCouponListEnabled();
 	}

	protected boolean isSaveRetailStoreMemberCouponListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreMemberTokens.RETAIL_STORE_MEMBER_COUPON_LIST);

 	}

		

	protected boolean isExtractMemberWishlistListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreMemberTokens.MEMBER_WISHLIST_LIST);
 	}
 	protected boolean isAnalyzeMemberWishlistListEnabled(Map<String,Object> options){
 		return RetailStoreMemberTokens.of(options).analyzeMemberWishlistListEnabled();
 	}

	protected boolean isSaveMemberWishlistListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreMemberTokens.MEMBER_WISHLIST_LIST);

 	}

		

	protected boolean isExtractMemberRewardPointListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreMemberTokens.MEMBER_REWARD_POINT_LIST);
 	}
 	protected boolean isAnalyzeMemberRewardPointListEnabled(Map<String,Object> options){
 		return RetailStoreMemberTokens.of(options).analyzeMemberRewardPointListEnabled();
 	}

	protected boolean isSaveMemberRewardPointListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreMemberTokens.MEMBER_REWARD_POINT_LIST);

 	}

		

	protected boolean isExtractMemberRewardPointRedemptionListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreMemberTokens.MEMBER_REWARD_POINT_REDEMPTION_LIST);
 	}
 	protected boolean isAnalyzeMemberRewardPointRedemptionListEnabled(Map<String,Object> options){
 		return RetailStoreMemberTokens.of(options).analyzeMemberRewardPointRedemptionListEnabled();
 	}

	protected boolean isSaveMemberRewardPointRedemptionListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreMemberTokens.MEMBER_REWARD_POINT_REDEMPTION_LIST);

 	}

		

	protected boolean isExtractRetailStoreMemberAddressListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreMemberTokens.RETAIL_STORE_MEMBER_ADDRESS_LIST);
 	}
 	protected boolean isAnalyzeRetailStoreMemberAddressListEnabled(Map<String,Object> options){
 		return RetailStoreMemberTokens.of(options).analyzeRetailStoreMemberAddressListEnabled();
 	}

	protected boolean isSaveRetailStoreMemberAddressListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreMemberTokens.RETAIL_STORE_MEMBER_ADDRESS_LIST);

 	}

		

	protected boolean isExtractRetailStoreMemberGiftCardListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreMemberTokens.RETAIL_STORE_MEMBER_GIFT_CARD_LIST);
 	}
 	protected boolean isAnalyzeRetailStoreMemberGiftCardListEnabled(Map<String,Object> options){
 		return RetailStoreMemberTokens.of(options).analyzeRetailStoreMemberGiftCardListEnabled();
 	}

	protected boolean isSaveRetailStoreMemberGiftCardListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreMemberTokens.RETAIL_STORE_MEMBER_GIFT_CARD_LIST);

 	}

		

	

	protected RetailStoreMemberMapper getRetailStoreMemberMapper(){
		return new RetailStoreMemberMapper();
	}



	protected RetailStoreMember extractRetailStoreMember(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			RetailStoreMember retailStoreMember = loadSingleObject(accessKey, getRetailStoreMemberMapper());
			return retailStoreMember;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreMemberNotFoundException("RetailStoreMember("+accessKey+") is not found!");
		}

	}




	protected RetailStoreMember loadInternalRetailStoreMember(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		RetailStoreMember retailStoreMember = extractRetailStoreMember(accessKey, loadOptions);

 		if(isExtractOwnerEnabled(loadOptions)){
	 		extractOwner(retailStoreMember, loadOptions);
 		}
 
		
		if(isExtractConsumerOrderListEnabled(loadOptions)){
	 		extractConsumerOrderList(retailStoreMember, loadOptions);
 		}

 		
 		if(isAnalyzeConsumerOrderListEnabled(loadOptions)){
	 		analyzeConsumerOrderList(retailStoreMember, loadOptions);
 		}
 		
		
		if(isExtractRetailStoreMemberCouponListEnabled(loadOptions)){
	 		extractRetailStoreMemberCouponList(retailStoreMember, loadOptions);
 		}

 		
 		if(isAnalyzeRetailStoreMemberCouponListEnabled(loadOptions)){
	 		analyzeRetailStoreMemberCouponList(retailStoreMember, loadOptions);
 		}
 		
		
		if(isExtractMemberWishlistListEnabled(loadOptions)){
	 		extractMemberWishlistList(retailStoreMember, loadOptions);
 		}

 		
 		if(isAnalyzeMemberWishlistListEnabled(loadOptions)){
	 		analyzeMemberWishlistList(retailStoreMember, loadOptions);
 		}
 		
		
		if(isExtractMemberRewardPointListEnabled(loadOptions)){
	 		extractMemberRewardPointList(retailStoreMember, loadOptions);
 		}

 		
 		if(isAnalyzeMemberRewardPointListEnabled(loadOptions)){
	 		analyzeMemberRewardPointList(retailStoreMember, loadOptions);
 		}
 		
		
		if(isExtractMemberRewardPointRedemptionListEnabled(loadOptions)){
	 		extractMemberRewardPointRedemptionList(retailStoreMember, loadOptions);
 		}

 		
 		if(isAnalyzeMemberRewardPointRedemptionListEnabled(loadOptions)){
	 		analyzeMemberRewardPointRedemptionList(retailStoreMember, loadOptions);
 		}
 		
		
		if(isExtractRetailStoreMemberAddressListEnabled(loadOptions)){
	 		extractRetailStoreMemberAddressList(retailStoreMember, loadOptions);
 		}

 		
 		if(isAnalyzeRetailStoreMemberAddressListEnabled(loadOptions)){
	 		analyzeRetailStoreMemberAddressList(retailStoreMember, loadOptions);
 		}
 		
		
		if(isExtractRetailStoreMemberGiftCardListEnabled(loadOptions)){
	 		extractRetailStoreMemberGiftCardList(retailStoreMember, loadOptions);
 		}

 		
 		if(isAnalyzeRetailStoreMemberGiftCardListEnabled(loadOptions)){
	 		analyzeRetailStoreMemberGiftCardList(retailStoreMember, loadOptions);
 		}
 		
		
		return retailStoreMember;

	}

	

 	protected RetailStoreMember extractOwner(RetailStoreMember retailStoreMember, Map<String,Object> options) throws Exception{
  

		if(retailStoreMember.getOwner() == null){
			return retailStoreMember;
		}
		String ownerId = retailStoreMember.getOwner().getId();
		if( ownerId == null){
			return retailStoreMember;
		}
		RetailStoreCountryCenter owner = getRetailStoreCountryCenterDAO().load(ownerId,options);
		if(owner != null){
			retailStoreMember.setOwner(owner);
		}


 		return retailStoreMember;
 	}

 
		
	protected void enhanceConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreMember extractConsumerOrderList(RetailStoreMember retailStoreMember, Map<String,Object> options){
    

		if(retailStoreMember == null){
			return null;
		}
		if(retailStoreMember.getId() == null){
			return retailStoreMember;
		}



		SmartList<ConsumerOrder> consumerOrderList = getConsumerOrderDAO().findConsumerOrderByConsumer(retailStoreMember.getId(),options);
		if(consumerOrderList != null){
			enhanceConsumerOrderList(consumerOrderList,options);
			retailStoreMember.setConsumerOrderList(consumerOrderList);
		}

		return retailStoreMember;
  
	}

	protected RetailStoreMember analyzeConsumerOrderList(RetailStoreMember retailStoreMember, Map<String,Object> options){
     
		if(retailStoreMember == null){
			return null;
		}
		if(retailStoreMember.getId() == null){
			return retailStoreMember;
		}



		SmartList<ConsumerOrder> consumerOrderList = retailStoreMember.getConsumerOrderList();
		if(consumerOrderList != null){
			getConsumerOrderDAO().analyzeConsumerOrderByConsumer(consumerOrderList, retailStoreMember.getId(), options);

		}

		return retailStoreMember;
    
	}

		
	protected void enhanceRetailStoreMemberCouponList(SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreMember extractRetailStoreMemberCouponList(RetailStoreMember retailStoreMember, Map<String,Object> options){
    

		if(retailStoreMember == null){
			return null;
		}
		if(retailStoreMember.getId() == null){
			return retailStoreMember;
		}



		SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList = getRetailStoreMemberCouponDAO().findRetailStoreMemberCouponByOwner(retailStoreMember.getId(),options);
		if(retailStoreMemberCouponList != null){
			enhanceRetailStoreMemberCouponList(retailStoreMemberCouponList,options);
			retailStoreMember.setRetailStoreMemberCouponList(retailStoreMemberCouponList);
		}

		return retailStoreMember;
  
	}

	protected RetailStoreMember analyzeRetailStoreMemberCouponList(RetailStoreMember retailStoreMember, Map<String,Object> options){
     
		if(retailStoreMember == null){
			return null;
		}
		if(retailStoreMember.getId() == null){
			return retailStoreMember;
		}



		SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList = retailStoreMember.getRetailStoreMemberCouponList();
		if(retailStoreMemberCouponList != null){
			getRetailStoreMemberCouponDAO().analyzeRetailStoreMemberCouponByOwner(retailStoreMemberCouponList, retailStoreMember.getId(), options);

		}

		return retailStoreMember;
    
	}

		
	protected void enhanceMemberWishlistList(SmartList<MemberWishlist> memberWishlistList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreMember extractMemberWishlistList(RetailStoreMember retailStoreMember, Map<String,Object> options){
    

		if(retailStoreMember == null){
			return null;
		}
		if(retailStoreMember.getId() == null){
			return retailStoreMember;
		}



		SmartList<MemberWishlist> memberWishlistList = getMemberWishlistDAO().findMemberWishlistByOwner(retailStoreMember.getId(),options);
		if(memberWishlistList != null){
			enhanceMemberWishlistList(memberWishlistList,options);
			retailStoreMember.setMemberWishlistList(memberWishlistList);
		}

		return retailStoreMember;
  
	}

	protected RetailStoreMember analyzeMemberWishlistList(RetailStoreMember retailStoreMember, Map<String,Object> options){
     
		if(retailStoreMember == null){
			return null;
		}
		if(retailStoreMember.getId() == null){
			return retailStoreMember;
		}



		SmartList<MemberWishlist> memberWishlistList = retailStoreMember.getMemberWishlistList();
		if(memberWishlistList != null){
			getMemberWishlistDAO().analyzeMemberWishlistByOwner(memberWishlistList, retailStoreMember.getId(), options);

		}

		return retailStoreMember;
    
	}

		
	protected void enhanceMemberRewardPointList(SmartList<MemberRewardPoint> memberRewardPointList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreMember extractMemberRewardPointList(RetailStoreMember retailStoreMember, Map<String,Object> options){
    

		if(retailStoreMember == null){
			return null;
		}
		if(retailStoreMember.getId() == null){
			return retailStoreMember;
		}



		SmartList<MemberRewardPoint> memberRewardPointList = getMemberRewardPointDAO().findMemberRewardPointByOwner(retailStoreMember.getId(),options);
		if(memberRewardPointList != null){
			enhanceMemberRewardPointList(memberRewardPointList,options);
			retailStoreMember.setMemberRewardPointList(memberRewardPointList);
		}

		return retailStoreMember;
  
	}

	protected RetailStoreMember analyzeMemberRewardPointList(RetailStoreMember retailStoreMember, Map<String,Object> options){
     
		if(retailStoreMember == null){
			return null;
		}
		if(retailStoreMember.getId() == null){
			return retailStoreMember;
		}



		SmartList<MemberRewardPoint> memberRewardPointList = retailStoreMember.getMemberRewardPointList();
		if(memberRewardPointList != null){
			getMemberRewardPointDAO().analyzeMemberRewardPointByOwner(memberRewardPointList, retailStoreMember.getId(), options);

		}

		return retailStoreMember;
    
	}

		
	protected void enhanceMemberRewardPointRedemptionList(SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreMember extractMemberRewardPointRedemptionList(RetailStoreMember retailStoreMember, Map<String,Object> options){
    

		if(retailStoreMember == null){
			return null;
		}
		if(retailStoreMember.getId() == null){
			return retailStoreMember;
		}



		SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList = getMemberRewardPointRedemptionDAO().findMemberRewardPointRedemptionByOwner(retailStoreMember.getId(),options);
		if(memberRewardPointRedemptionList != null){
			enhanceMemberRewardPointRedemptionList(memberRewardPointRedemptionList,options);
			retailStoreMember.setMemberRewardPointRedemptionList(memberRewardPointRedemptionList);
		}

		return retailStoreMember;
  
	}

	protected RetailStoreMember analyzeMemberRewardPointRedemptionList(RetailStoreMember retailStoreMember, Map<String,Object> options){
     
		if(retailStoreMember == null){
			return null;
		}
		if(retailStoreMember.getId() == null){
			return retailStoreMember;
		}



		SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList = retailStoreMember.getMemberRewardPointRedemptionList();
		if(memberRewardPointRedemptionList != null){
			getMemberRewardPointRedemptionDAO().analyzeMemberRewardPointRedemptionByOwner(memberRewardPointRedemptionList, retailStoreMember.getId(), options);

		}

		return retailStoreMember;
    
	}

		
	protected void enhanceRetailStoreMemberAddressList(SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreMember extractRetailStoreMemberAddressList(RetailStoreMember retailStoreMember, Map<String,Object> options){
    

		if(retailStoreMember == null){
			return null;
		}
		if(retailStoreMember.getId() == null){
			return retailStoreMember;
		}



		SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList = getRetailStoreMemberAddressDAO().findRetailStoreMemberAddressByOwner(retailStoreMember.getId(),options);
		if(retailStoreMemberAddressList != null){
			enhanceRetailStoreMemberAddressList(retailStoreMemberAddressList,options);
			retailStoreMember.setRetailStoreMemberAddressList(retailStoreMemberAddressList);
		}

		return retailStoreMember;
  
	}

	protected RetailStoreMember analyzeRetailStoreMemberAddressList(RetailStoreMember retailStoreMember, Map<String,Object> options){
     
		if(retailStoreMember == null){
			return null;
		}
		if(retailStoreMember.getId() == null){
			return retailStoreMember;
		}



		SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList = retailStoreMember.getRetailStoreMemberAddressList();
		if(retailStoreMemberAddressList != null){
			getRetailStoreMemberAddressDAO().analyzeRetailStoreMemberAddressByOwner(retailStoreMemberAddressList, retailStoreMember.getId(), options);

		}

		return retailStoreMember;
    
	}

		
	protected void enhanceRetailStoreMemberGiftCardList(SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreMember extractRetailStoreMemberGiftCardList(RetailStoreMember retailStoreMember, Map<String,Object> options){
    

		if(retailStoreMember == null){
			return null;
		}
		if(retailStoreMember.getId() == null){
			return retailStoreMember;
		}



		SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList = getRetailStoreMemberGiftCardDAO().findRetailStoreMemberGiftCardByOwner(retailStoreMember.getId(),options);
		if(retailStoreMemberGiftCardList != null){
			enhanceRetailStoreMemberGiftCardList(retailStoreMemberGiftCardList,options);
			retailStoreMember.setRetailStoreMemberGiftCardList(retailStoreMemberGiftCardList);
		}

		return retailStoreMember;
  
	}

	protected RetailStoreMember analyzeRetailStoreMemberGiftCardList(RetailStoreMember retailStoreMember, Map<String,Object> options){
     
		if(retailStoreMember == null){
			return null;
		}
		if(retailStoreMember.getId() == null){
			return retailStoreMember;
		}



		SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList = retailStoreMember.getRetailStoreMemberGiftCardList();
		if(retailStoreMemberGiftCardList != null){
			getRetailStoreMemberGiftCardDAO().analyzeRetailStoreMemberGiftCardByOwner(retailStoreMemberGiftCardList, retailStoreMember.getId(), options);

		}

		return retailStoreMember;
    
	}

		

 
 	public SmartList<RetailStoreMember> findRetailStoreMemberByOwner(String retailStoreCountryCenterId,Map<String,Object> options){

  		SmartList<RetailStoreMember> resultList = queryWith(RetailStoreMemberTable.COLUMN_OWNER, retailStoreCountryCenterId, options, getRetailStoreMemberMapper());
		// analyzeRetailStoreMemberByOwner(resultList, retailStoreCountryCenterId, options);
		return resultList;
 	}
 	

 	public SmartList<RetailStoreMember> findRetailStoreMemberByOwner(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){

 		SmartList<RetailStoreMember> resultList =  queryWithRange(RetailStoreMemberTable.COLUMN_OWNER, retailStoreCountryCenterId, options, getRetailStoreMemberMapper(), start, count);
 		//analyzeRetailStoreMemberByOwner(resultList, retailStoreCountryCenterId, options);
 		return resultList;

 	}
 	public void analyzeRetailStoreMemberByOwner(SmartList<RetailStoreMember> resultList, String retailStoreCountryCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}



 	}
 	@Override
 	public int countRetailStoreMemberByOwner(String retailStoreCountryCenterId,Map<String,Object> options){

 		return countWith(RetailStoreMemberTable.COLUMN_OWNER, retailStoreCountryCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countRetailStoreMemberByOwnerIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RetailStoreMemberTable.COLUMN_OWNER, ids, options);
	}

 




	

	protected RetailStoreMember saveRetailStoreMember(RetailStoreMember  retailStoreMember){
    

		
		if(!retailStoreMember.isChanged()){
			return retailStoreMember;
		}
		

    Beans.dbUtil().cacheCleanUp(retailStoreMember);
		String SQL=this.getSaveRetailStoreMemberSQL(retailStoreMember);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreMemberParameters(retailStoreMember);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		retailStoreMember.incVersion();
		retailStoreMember.afterSave();
		return retailStoreMember;

	}
	public SmartList<RetailStoreMember> saveRetailStoreMemberList(SmartList<RetailStoreMember> retailStoreMemberList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreMemberList(retailStoreMemberList);

		batchRetailStoreMemberCreate((List<RetailStoreMember>)lists[CREATE_LIST_INDEX]);

		batchRetailStoreMemberUpdate((List<RetailStoreMember>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(RetailStoreMember retailStoreMember:retailStoreMemberList){
			if(retailStoreMember.isChanged()){
				retailStoreMember.incVersion();
				retailStoreMember.afterSave();
			}


		}


		return retailStoreMemberList;
	}

	public SmartList<RetailStoreMember> removeRetailStoreMemberList(SmartList<RetailStoreMember> retailStoreMemberList,Map<String,Object> options){


		super.removeList(retailStoreMemberList, options);

		return retailStoreMemberList;


	}

	protected List<Object[]> prepareRetailStoreMemberBatchCreateArgs(List<RetailStoreMember> retailStoreMemberList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreMember retailStoreMember:retailStoreMemberList ){
			Object [] parameters = prepareRetailStoreMemberCreateParameters(retailStoreMember);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareRetailStoreMemberBatchUpdateArgs(List<RetailStoreMember> retailStoreMemberList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreMember retailStoreMember:retailStoreMemberList ){
			if(!retailStoreMember.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreMemberUpdateParameters(retailStoreMember);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchRetailStoreMemberCreate(List<RetailStoreMember> retailStoreMemberList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreMemberBatchCreateArgs(retailStoreMemberList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchRetailStoreMemberUpdate(List<RetailStoreMember> retailStoreMemberList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreMemberBatchUpdateArgs(retailStoreMemberList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitRetailStoreMemberList(List<RetailStoreMember> retailStoreMemberList){

		List<RetailStoreMember> retailStoreMemberCreateList=new ArrayList<RetailStoreMember>();
		List<RetailStoreMember> retailStoreMemberUpdateList=new ArrayList<RetailStoreMember>();

		for(RetailStoreMember retailStoreMember: retailStoreMemberList){
			if(isUpdateRequest(retailStoreMember)){
				retailStoreMemberUpdateList.add( retailStoreMember);
				continue;
			}
			retailStoreMemberCreateList.add(retailStoreMember);
		}

		return new Object[]{retailStoreMemberCreateList,retailStoreMemberUpdateList};
	}

	protected boolean isUpdateRequest(RetailStoreMember retailStoreMember){
 		return retailStoreMember.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreMemberSQL(RetailStoreMember retailStoreMember){
 		if(isUpdateRequest(retailStoreMember)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveRetailStoreMemberParameters(RetailStoreMember retailStoreMember){
 		if(isUpdateRequest(retailStoreMember) ){
 			return prepareRetailStoreMemberUpdateParameters(retailStoreMember);
 		}
 		return prepareRetailStoreMemberCreateParameters(retailStoreMember);
 	}
 	protected Object[] prepareRetailStoreMemberUpdateParameters(RetailStoreMember retailStoreMember){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = retailStoreMember.getName();
 		
 		parameters[1] = retailStoreMember.getMobilePhone();
 		
 		if(retailStoreMember.getOwner() != null){
 			parameters[2] = retailStoreMember.getOwner().getId();
 		}
    
 		parameters[3] = retailStoreMember.nextVersion();
 		parameters[4] = retailStoreMember.getId();
 		parameters[5] = retailStoreMember.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareRetailStoreMemberCreateParameters(RetailStoreMember retailStoreMember){
		Object[] parameters = new Object[4];
        if(retailStoreMember.getId() == null){
          String newRetailStoreMemberId=getNextId();
          retailStoreMember.setId(newRetailStoreMemberId);
        }
		parameters[0] =  retailStoreMember.getId();
 
 		parameters[1] = retailStoreMember.getName();
 		
 		parameters[2] = retailStoreMember.getMobilePhone();
 		
 		if(retailStoreMember.getOwner() != null){
 			parameters[3] = retailStoreMember.getOwner().getId();
 		}
 		

 		return parameters;
 	}

	protected RetailStoreMember saveInternalRetailStoreMember(RetailStoreMember retailStoreMember, Map<String,Object> options){

 		if(isSaveOwnerEnabled(options)){
	 		saveOwner(retailStoreMember, options);
 		}
 
   saveRetailStoreMember(retailStoreMember);
		
		if(isSaveConsumerOrderListEnabled(options)){
	 		saveConsumerOrderList(retailStoreMember, options);
	 		//removeConsumerOrderList(retailStoreMember, options);
	 		//Not delete the record

 		}
		
		if(isSaveRetailStoreMemberCouponListEnabled(options)){
	 		saveRetailStoreMemberCouponList(retailStoreMember, options);
	 		//removeRetailStoreMemberCouponList(retailStoreMember, options);
	 		//Not delete the record

 		}
		
		if(isSaveMemberWishlistListEnabled(options)){
	 		saveMemberWishlistList(retailStoreMember, options);
	 		//removeMemberWishlistList(retailStoreMember, options);
	 		//Not delete the record

 		}
		
		if(isSaveMemberRewardPointListEnabled(options)){
	 		saveMemberRewardPointList(retailStoreMember, options);
	 		//removeMemberRewardPointList(retailStoreMember, options);
	 		//Not delete the record

 		}
		
		if(isSaveMemberRewardPointRedemptionListEnabled(options)){
	 		saveMemberRewardPointRedemptionList(retailStoreMember, options);
	 		//removeMemberRewardPointRedemptionList(retailStoreMember, options);
	 		//Not delete the record

 		}
		
		if(isSaveRetailStoreMemberAddressListEnabled(options)){
	 		saveRetailStoreMemberAddressList(retailStoreMember, options);
	 		//removeRetailStoreMemberAddressList(retailStoreMember, options);
	 		//Not delete the record

 		}
		
		if(isSaveRetailStoreMemberGiftCardListEnabled(options)){
	 		saveRetailStoreMemberGiftCardList(retailStoreMember, options);
	 		//removeRetailStoreMemberGiftCardList(retailStoreMember, options);
	 		//Not delete the record

 		}
		
		return retailStoreMember;

	}



	//======================================================================================
	

 	protected RetailStoreMember saveOwner(RetailStoreMember retailStoreMember, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(retailStoreMember.getOwner() == null){
 			return retailStoreMember;//do nothing when it is null
 		}

 		getRetailStoreCountryCenterDAO().save(retailStoreMember.getOwner(),options);
 		return retailStoreMember;

 	}
 

	
	public RetailStoreMember planToRemoveConsumerOrderList(RetailStoreMember retailStoreMember, String consumerOrderIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.CONSUMER_PROPERTY, retailStoreMember.getId());
		key.put(ConsumerOrder.ID_PROPERTY, consumerOrderIds);

		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return retailStoreMember;
		}
		if(externalConsumerOrderList.isEmpty()){
			return retailStoreMember;
		}

		for(ConsumerOrder consumerOrderItem: externalConsumerOrderList){

			consumerOrderItem.clearFromAll();
		}


		SmartList<ConsumerOrder> consumerOrderList = retailStoreMember.getConsumerOrderList();
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return retailStoreMember;

	}


	//disconnect RetailStoreMember with store in ConsumerOrder
	public RetailStoreMember planToRemoveConsumerOrderListWithStore(RetailStoreMember retailStoreMember, String storeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.CONSUMER_PROPERTY, retailStoreMember.getId());
		key.put(ConsumerOrder.STORE_PROPERTY, storeId);

		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return retailStoreMember;
		}
		if(externalConsumerOrderList.isEmpty()){
			return retailStoreMember;
		}

		for(ConsumerOrder consumerOrderItem: externalConsumerOrderList){
			consumerOrderItem.clearStore();
			consumerOrderItem.clearConsumer();

		}


		SmartList<ConsumerOrder> consumerOrderList = retailStoreMember.getConsumerOrderList();
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return retailStoreMember;
	}

	public int countConsumerOrderListWithStore(String retailStoreMemberId, String storeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.CONSUMER_PROPERTY, retailStoreMemberId);
		key.put(ConsumerOrder.STORE_PROPERTY, storeId);

		int count = getConsumerOrderDAO().countConsumerOrderWithKey(key, options);
		return count;
	}
	
	public RetailStoreMember planToRemoveRetailStoreMemberCouponList(RetailStoreMember retailStoreMember, String retailStoreMemberCouponIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreMemberCoupon.OWNER_PROPERTY, retailStoreMember.getId());
		key.put(RetailStoreMemberCoupon.ID_PROPERTY, retailStoreMemberCouponIds);

		SmartList<RetailStoreMemberCoupon> externalRetailStoreMemberCouponList = getRetailStoreMemberCouponDAO().
				findRetailStoreMemberCouponWithKey(key, options);
		if(externalRetailStoreMemberCouponList == null){
			return retailStoreMember;
		}
		if(externalRetailStoreMemberCouponList.isEmpty()){
			return retailStoreMember;
		}

		for(RetailStoreMemberCoupon retailStoreMemberCouponItem: externalRetailStoreMemberCouponList){

			retailStoreMemberCouponItem.clearFromAll();
		}


		SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList = retailStoreMember.getRetailStoreMemberCouponList();
		retailStoreMemberCouponList.addAllToRemoveList(externalRetailStoreMemberCouponList);
		return retailStoreMember;

	}


	public RetailStoreMember planToRemoveMemberWishlistList(RetailStoreMember retailStoreMember, String memberWishlistIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(MemberWishlist.OWNER_PROPERTY, retailStoreMember.getId());
		key.put(MemberWishlist.ID_PROPERTY, memberWishlistIds);

		SmartList<MemberWishlist> externalMemberWishlistList = getMemberWishlistDAO().
				findMemberWishlistWithKey(key, options);
		if(externalMemberWishlistList == null){
			return retailStoreMember;
		}
		if(externalMemberWishlistList.isEmpty()){
			return retailStoreMember;
		}

		for(MemberWishlist memberWishlistItem: externalMemberWishlistList){

			memberWishlistItem.clearFromAll();
		}


		SmartList<MemberWishlist> memberWishlistList = retailStoreMember.getMemberWishlistList();
		memberWishlistList.addAllToRemoveList(externalMemberWishlistList);
		return retailStoreMember;

	}


	public RetailStoreMember planToRemoveMemberRewardPointList(RetailStoreMember retailStoreMember, String memberRewardPointIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(MemberRewardPoint.OWNER_PROPERTY, retailStoreMember.getId());
		key.put(MemberRewardPoint.ID_PROPERTY, memberRewardPointIds);

		SmartList<MemberRewardPoint> externalMemberRewardPointList = getMemberRewardPointDAO().
				findMemberRewardPointWithKey(key, options);
		if(externalMemberRewardPointList == null){
			return retailStoreMember;
		}
		if(externalMemberRewardPointList.isEmpty()){
			return retailStoreMember;
		}

		for(MemberRewardPoint memberRewardPointItem: externalMemberRewardPointList){

			memberRewardPointItem.clearFromAll();
		}


		SmartList<MemberRewardPoint> memberRewardPointList = retailStoreMember.getMemberRewardPointList();
		memberRewardPointList.addAllToRemoveList(externalMemberRewardPointList);
		return retailStoreMember;

	}


	public RetailStoreMember planToRemoveMemberRewardPointRedemptionList(RetailStoreMember retailStoreMember, String memberRewardPointRedemptionIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(MemberRewardPointRedemption.OWNER_PROPERTY, retailStoreMember.getId());
		key.put(MemberRewardPointRedemption.ID_PROPERTY, memberRewardPointRedemptionIds);

		SmartList<MemberRewardPointRedemption> externalMemberRewardPointRedemptionList = getMemberRewardPointRedemptionDAO().
				findMemberRewardPointRedemptionWithKey(key, options);
		if(externalMemberRewardPointRedemptionList == null){
			return retailStoreMember;
		}
		if(externalMemberRewardPointRedemptionList.isEmpty()){
			return retailStoreMember;
		}

		for(MemberRewardPointRedemption memberRewardPointRedemptionItem: externalMemberRewardPointRedemptionList){

			memberRewardPointRedemptionItem.clearFromAll();
		}


		SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList = retailStoreMember.getMemberRewardPointRedemptionList();
		memberRewardPointRedemptionList.addAllToRemoveList(externalMemberRewardPointRedemptionList);
		return retailStoreMember;

	}


	public RetailStoreMember planToRemoveRetailStoreMemberAddressList(RetailStoreMember retailStoreMember, String retailStoreMemberAddressIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreMemberAddress.OWNER_PROPERTY, retailStoreMember.getId());
		key.put(RetailStoreMemberAddress.ID_PROPERTY, retailStoreMemberAddressIds);

		SmartList<RetailStoreMemberAddress> externalRetailStoreMemberAddressList = getRetailStoreMemberAddressDAO().
				findRetailStoreMemberAddressWithKey(key, options);
		if(externalRetailStoreMemberAddressList == null){
			return retailStoreMember;
		}
		if(externalRetailStoreMemberAddressList.isEmpty()){
			return retailStoreMember;
		}

		for(RetailStoreMemberAddress retailStoreMemberAddressItem: externalRetailStoreMemberAddressList){

			retailStoreMemberAddressItem.clearFromAll();
		}


		SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList = retailStoreMember.getRetailStoreMemberAddressList();
		retailStoreMemberAddressList.addAllToRemoveList(externalRetailStoreMemberAddressList);
		return retailStoreMember;

	}


	public RetailStoreMember planToRemoveRetailStoreMemberGiftCardList(RetailStoreMember retailStoreMember, String retailStoreMemberGiftCardIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreMemberGiftCard.OWNER_PROPERTY, retailStoreMember.getId());
		key.put(RetailStoreMemberGiftCard.ID_PROPERTY, retailStoreMemberGiftCardIds);

		SmartList<RetailStoreMemberGiftCard> externalRetailStoreMemberGiftCardList = getRetailStoreMemberGiftCardDAO().
				findRetailStoreMemberGiftCardWithKey(key, options);
		if(externalRetailStoreMemberGiftCardList == null){
			return retailStoreMember;
		}
		if(externalRetailStoreMemberGiftCardList.isEmpty()){
			return retailStoreMember;
		}

		for(RetailStoreMemberGiftCard retailStoreMemberGiftCardItem: externalRetailStoreMemberGiftCardList){

			retailStoreMemberGiftCardItem.clearFromAll();
		}


		SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList = retailStoreMember.getRetailStoreMemberGiftCardList();
		retailStoreMemberGiftCardList.addAllToRemoveList(externalRetailStoreMemberGiftCardList);
		return retailStoreMember;

	}



		
	protected RetailStoreMember saveConsumerOrderList(RetailStoreMember retailStoreMember, Map<String,Object> options){
    



		SmartList<ConsumerOrder> consumerOrderList = retailStoreMember.getConsumerOrderList();
		if(consumerOrderList == null){
			//null list means nothing
			return retailStoreMember;
		}
		SmartList<ConsumerOrder> mergedUpdateConsumerOrderList = new SmartList<ConsumerOrder>();


		mergedUpdateConsumerOrderList.addAll(consumerOrderList);
		if(consumerOrderList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateConsumerOrderList.addAll(consumerOrderList.getToRemoveList());
			consumerOrderList.removeAll(consumerOrderList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getConsumerOrderDAO().saveConsumerOrderList(mergedUpdateConsumerOrderList,options);

		if(consumerOrderList.getToRemoveList() != null){
			consumerOrderList.removeAll(consumerOrderList.getToRemoveList());
		}


		return retailStoreMember;

	}

	protected RetailStoreMember removeConsumerOrderList(RetailStoreMember retailStoreMember, Map<String,Object> options){


		SmartList<ConsumerOrder> consumerOrderList = retailStoreMember.getConsumerOrderList();
		if(consumerOrderList == null){
			return retailStoreMember;
		}

		SmartList<ConsumerOrder> toRemoveConsumerOrderList = consumerOrderList.getToRemoveList();

		if(toRemoveConsumerOrderList == null){
			return retailStoreMember;
		}
		if(toRemoveConsumerOrderList.isEmpty()){
			return retailStoreMember;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getConsumerOrderDAO().removeConsumerOrderList(toRemoveConsumerOrderList,options);

		return retailStoreMember;

	}








		
	protected RetailStoreMember saveRetailStoreMemberCouponList(RetailStoreMember retailStoreMember, Map<String,Object> options){
    



		SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList = retailStoreMember.getRetailStoreMemberCouponList();
		if(retailStoreMemberCouponList == null){
			//null list means nothing
			return retailStoreMember;
		}
		SmartList<RetailStoreMemberCoupon> mergedUpdateRetailStoreMemberCouponList = new SmartList<RetailStoreMemberCoupon>();


		mergedUpdateRetailStoreMemberCouponList.addAll(retailStoreMemberCouponList);
		if(retailStoreMemberCouponList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateRetailStoreMemberCouponList.addAll(retailStoreMemberCouponList.getToRemoveList());
			retailStoreMemberCouponList.removeAll(retailStoreMemberCouponList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getRetailStoreMemberCouponDAO().saveRetailStoreMemberCouponList(mergedUpdateRetailStoreMemberCouponList,options);

		if(retailStoreMemberCouponList.getToRemoveList() != null){
			retailStoreMemberCouponList.removeAll(retailStoreMemberCouponList.getToRemoveList());
		}


		return retailStoreMember;

	}

	protected RetailStoreMember removeRetailStoreMemberCouponList(RetailStoreMember retailStoreMember, Map<String,Object> options){


		SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList = retailStoreMember.getRetailStoreMemberCouponList();
		if(retailStoreMemberCouponList == null){
			return retailStoreMember;
		}

		SmartList<RetailStoreMemberCoupon> toRemoveRetailStoreMemberCouponList = retailStoreMemberCouponList.getToRemoveList();

		if(toRemoveRetailStoreMemberCouponList == null){
			return retailStoreMember;
		}
		if(toRemoveRetailStoreMemberCouponList.isEmpty()){
			return retailStoreMember;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getRetailStoreMemberCouponDAO().removeRetailStoreMemberCouponList(toRemoveRetailStoreMemberCouponList,options);

		return retailStoreMember;

	}








		
	protected RetailStoreMember saveMemberWishlistList(RetailStoreMember retailStoreMember, Map<String,Object> options){
    



		SmartList<MemberWishlist> memberWishlistList = retailStoreMember.getMemberWishlistList();
		if(memberWishlistList == null){
			//null list means nothing
			return retailStoreMember;
		}
		SmartList<MemberWishlist> mergedUpdateMemberWishlistList = new SmartList<MemberWishlist>();


		mergedUpdateMemberWishlistList.addAll(memberWishlistList);
		if(memberWishlistList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateMemberWishlistList.addAll(memberWishlistList.getToRemoveList());
			memberWishlistList.removeAll(memberWishlistList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getMemberWishlistDAO().saveMemberWishlistList(mergedUpdateMemberWishlistList,options);

		if(memberWishlistList.getToRemoveList() != null){
			memberWishlistList.removeAll(memberWishlistList.getToRemoveList());
		}


		return retailStoreMember;

	}

	protected RetailStoreMember removeMemberWishlistList(RetailStoreMember retailStoreMember, Map<String,Object> options){


		SmartList<MemberWishlist> memberWishlistList = retailStoreMember.getMemberWishlistList();
		if(memberWishlistList == null){
			return retailStoreMember;
		}

		SmartList<MemberWishlist> toRemoveMemberWishlistList = memberWishlistList.getToRemoveList();

		if(toRemoveMemberWishlistList == null){
			return retailStoreMember;
		}
		if(toRemoveMemberWishlistList.isEmpty()){
			return retailStoreMember;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getMemberWishlistDAO().removeMemberWishlistList(toRemoveMemberWishlistList,options);

		return retailStoreMember;

	}








		
	protected RetailStoreMember saveMemberRewardPointList(RetailStoreMember retailStoreMember, Map<String,Object> options){
    



		SmartList<MemberRewardPoint> memberRewardPointList = retailStoreMember.getMemberRewardPointList();
		if(memberRewardPointList == null){
			//null list means nothing
			return retailStoreMember;
		}
		SmartList<MemberRewardPoint> mergedUpdateMemberRewardPointList = new SmartList<MemberRewardPoint>();


		mergedUpdateMemberRewardPointList.addAll(memberRewardPointList);
		if(memberRewardPointList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateMemberRewardPointList.addAll(memberRewardPointList.getToRemoveList());
			memberRewardPointList.removeAll(memberRewardPointList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getMemberRewardPointDAO().saveMemberRewardPointList(mergedUpdateMemberRewardPointList,options);

		if(memberRewardPointList.getToRemoveList() != null){
			memberRewardPointList.removeAll(memberRewardPointList.getToRemoveList());
		}


		return retailStoreMember;

	}

	protected RetailStoreMember removeMemberRewardPointList(RetailStoreMember retailStoreMember, Map<String,Object> options){


		SmartList<MemberRewardPoint> memberRewardPointList = retailStoreMember.getMemberRewardPointList();
		if(memberRewardPointList == null){
			return retailStoreMember;
		}

		SmartList<MemberRewardPoint> toRemoveMemberRewardPointList = memberRewardPointList.getToRemoveList();

		if(toRemoveMemberRewardPointList == null){
			return retailStoreMember;
		}
		if(toRemoveMemberRewardPointList.isEmpty()){
			return retailStoreMember;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getMemberRewardPointDAO().removeMemberRewardPointList(toRemoveMemberRewardPointList,options);

		return retailStoreMember;

	}








		
	protected RetailStoreMember saveMemberRewardPointRedemptionList(RetailStoreMember retailStoreMember, Map<String,Object> options){
    



		SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList = retailStoreMember.getMemberRewardPointRedemptionList();
		if(memberRewardPointRedemptionList == null){
			//null list means nothing
			return retailStoreMember;
		}
		SmartList<MemberRewardPointRedemption> mergedUpdateMemberRewardPointRedemptionList = new SmartList<MemberRewardPointRedemption>();


		mergedUpdateMemberRewardPointRedemptionList.addAll(memberRewardPointRedemptionList);
		if(memberRewardPointRedemptionList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateMemberRewardPointRedemptionList.addAll(memberRewardPointRedemptionList.getToRemoveList());
			memberRewardPointRedemptionList.removeAll(memberRewardPointRedemptionList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getMemberRewardPointRedemptionDAO().saveMemberRewardPointRedemptionList(mergedUpdateMemberRewardPointRedemptionList,options);

		if(memberRewardPointRedemptionList.getToRemoveList() != null){
			memberRewardPointRedemptionList.removeAll(memberRewardPointRedemptionList.getToRemoveList());
		}


		return retailStoreMember;

	}

	protected RetailStoreMember removeMemberRewardPointRedemptionList(RetailStoreMember retailStoreMember, Map<String,Object> options){


		SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList = retailStoreMember.getMemberRewardPointRedemptionList();
		if(memberRewardPointRedemptionList == null){
			return retailStoreMember;
		}

		SmartList<MemberRewardPointRedemption> toRemoveMemberRewardPointRedemptionList = memberRewardPointRedemptionList.getToRemoveList();

		if(toRemoveMemberRewardPointRedemptionList == null){
			return retailStoreMember;
		}
		if(toRemoveMemberRewardPointRedemptionList.isEmpty()){
			return retailStoreMember;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getMemberRewardPointRedemptionDAO().removeMemberRewardPointRedemptionList(toRemoveMemberRewardPointRedemptionList,options);

		return retailStoreMember;

	}








		
	protected RetailStoreMember saveRetailStoreMemberAddressList(RetailStoreMember retailStoreMember, Map<String,Object> options){
    



		SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList = retailStoreMember.getRetailStoreMemberAddressList();
		if(retailStoreMemberAddressList == null){
			//null list means nothing
			return retailStoreMember;
		}
		SmartList<RetailStoreMemberAddress> mergedUpdateRetailStoreMemberAddressList = new SmartList<RetailStoreMemberAddress>();


		mergedUpdateRetailStoreMemberAddressList.addAll(retailStoreMemberAddressList);
		if(retailStoreMemberAddressList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateRetailStoreMemberAddressList.addAll(retailStoreMemberAddressList.getToRemoveList());
			retailStoreMemberAddressList.removeAll(retailStoreMemberAddressList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getRetailStoreMemberAddressDAO().saveRetailStoreMemberAddressList(mergedUpdateRetailStoreMemberAddressList,options);

		if(retailStoreMemberAddressList.getToRemoveList() != null){
			retailStoreMemberAddressList.removeAll(retailStoreMemberAddressList.getToRemoveList());
		}


		return retailStoreMember;

	}

	protected RetailStoreMember removeRetailStoreMemberAddressList(RetailStoreMember retailStoreMember, Map<String,Object> options){


		SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList = retailStoreMember.getRetailStoreMemberAddressList();
		if(retailStoreMemberAddressList == null){
			return retailStoreMember;
		}

		SmartList<RetailStoreMemberAddress> toRemoveRetailStoreMemberAddressList = retailStoreMemberAddressList.getToRemoveList();

		if(toRemoveRetailStoreMemberAddressList == null){
			return retailStoreMember;
		}
		if(toRemoveRetailStoreMemberAddressList.isEmpty()){
			return retailStoreMember;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getRetailStoreMemberAddressDAO().removeRetailStoreMemberAddressList(toRemoveRetailStoreMemberAddressList,options);

		return retailStoreMember;

	}








		
	protected RetailStoreMember saveRetailStoreMemberGiftCardList(RetailStoreMember retailStoreMember, Map<String,Object> options){
    



		SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList = retailStoreMember.getRetailStoreMemberGiftCardList();
		if(retailStoreMemberGiftCardList == null){
			//null list means nothing
			return retailStoreMember;
		}
		SmartList<RetailStoreMemberGiftCard> mergedUpdateRetailStoreMemberGiftCardList = new SmartList<RetailStoreMemberGiftCard>();


		mergedUpdateRetailStoreMemberGiftCardList.addAll(retailStoreMemberGiftCardList);
		if(retailStoreMemberGiftCardList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateRetailStoreMemberGiftCardList.addAll(retailStoreMemberGiftCardList.getToRemoveList());
			retailStoreMemberGiftCardList.removeAll(retailStoreMemberGiftCardList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getRetailStoreMemberGiftCardDAO().saveRetailStoreMemberGiftCardList(mergedUpdateRetailStoreMemberGiftCardList,options);

		if(retailStoreMemberGiftCardList.getToRemoveList() != null){
			retailStoreMemberGiftCardList.removeAll(retailStoreMemberGiftCardList.getToRemoveList());
		}


		return retailStoreMember;

	}

	protected RetailStoreMember removeRetailStoreMemberGiftCardList(RetailStoreMember retailStoreMember, Map<String,Object> options){


		SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList = retailStoreMember.getRetailStoreMemberGiftCardList();
		if(retailStoreMemberGiftCardList == null){
			return retailStoreMember;
		}

		SmartList<RetailStoreMemberGiftCard> toRemoveRetailStoreMemberGiftCardList = retailStoreMemberGiftCardList.getToRemoveList();

		if(toRemoveRetailStoreMemberGiftCardList == null){
			return retailStoreMember;
		}
		if(toRemoveRetailStoreMemberGiftCardList.isEmpty()){
			return retailStoreMember;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getRetailStoreMemberGiftCardDAO().removeRetailStoreMemberGiftCardList(toRemoveRetailStoreMemberGiftCardList,options);

		return retailStoreMember;

	}








		

	public RetailStoreMember present(RetailStoreMember retailStoreMember,Map<String, Object> options){

		presentConsumerOrderList(retailStoreMember,options);
		presentRetailStoreMemberCouponList(retailStoreMember,options);
		presentMemberWishlistList(retailStoreMember,options);
		presentMemberRewardPointList(retailStoreMember,options);
		presentMemberRewardPointRedemptionList(retailStoreMember,options);
		presentRetailStoreMemberAddressList(retailStoreMember,options);
		presentRetailStoreMemberGiftCardList(retailStoreMember,options);

		return retailStoreMember;

	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreMember presentConsumerOrderList(
			RetailStoreMember retailStoreMember,
			Map<String, Object> options) {
    
		SmartList<ConsumerOrder> consumerOrderList = retailStoreMember.getConsumerOrderList();
				SmartList<ConsumerOrder> newList= presentSubList(retailStoreMember.getId(),
				consumerOrderList,
				options,
				getConsumerOrderDAO()::countConsumerOrderByConsumer,
				getConsumerOrderDAO()::findConsumerOrderByConsumer
				);


		retailStoreMember.setConsumerOrderList(newList);


		return retailStoreMember;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreMember presentRetailStoreMemberCouponList(
			RetailStoreMember retailStoreMember,
			Map<String, Object> options) {
    
		SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList = retailStoreMember.getRetailStoreMemberCouponList();
				SmartList<RetailStoreMemberCoupon> newList= presentSubList(retailStoreMember.getId(),
				retailStoreMemberCouponList,
				options,
				getRetailStoreMemberCouponDAO()::countRetailStoreMemberCouponByOwner,
				getRetailStoreMemberCouponDAO()::findRetailStoreMemberCouponByOwner
				);


		retailStoreMember.setRetailStoreMemberCouponList(newList);


		return retailStoreMember;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreMember presentMemberWishlistList(
			RetailStoreMember retailStoreMember,
			Map<String, Object> options) {
    
		SmartList<MemberWishlist> memberWishlistList = retailStoreMember.getMemberWishlistList();
				SmartList<MemberWishlist> newList= presentSubList(retailStoreMember.getId(),
				memberWishlistList,
				options,
				getMemberWishlistDAO()::countMemberWishlistByOwner,
				getMemberWishlistDAO()::findMemberWishlistByOwner
				);


		retailStoreMember.setMemberWishlistList(newList);


		return retailStoreMember;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreMember presentMemberRewardPointList(
			RetailStoreMember retailStoreMember,
			Map<String, Object> options) {
    
		SmartList<MemberRewardPoint> memberRewardPointList = retailStoreMember.getMemberRewardPointList();
				SmartList<MemberRewardPoint> newList= presentSubList(retailStoreMember.getId(),
				memberRewardPointList,
				options,
				getMemberRewardPointDAO()::countMemberRewardPointByOwner,
				getMemberRewardPointDAO()::findMemberRewardPointByOwner
				);


		retailStoreMember.setMemberRewardPointList(newList);


		return retailStoreMember;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreMember presentMemberRewardPointRedemptionList(
			RetailStoreMember retailStoreMember,
			Map<String, Object> options) {
    
		SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList = retailStoreMember.getMemberRewardPointRedemptionList();
				SmartList<MemberRewardPointRedemption> newList= presentSubList(retailStoreMember.getId(),
				memberRewardPointRedemptionList,
				options,
				getMemberRewardPointRedemptionDAO()::countMemberRewardPointRedemptionByOwner,
				getMemberRewardPointRedemptionDAO()::findMemberRewardPointRedemptionByOwner
				);


		retailStoreMember.setMemberRewardPointRedemptionList(newList);


		return retailStoreMember;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreMember presentRetailStoreMemberAddressList(
			RetailStoreMember retailStoreMember,
			Map<String, Object> options) {
    
		SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList = retailStoreMember.getRetailStoreMemberAddressList();
				SmartList<RetailStoreMemberAddress> newList= presentSubList(retailStoreMember.getId(),
				retailStoreMemberAddressList,
				options,
				getRetailStoreMemberAddressDAO()::countRetailStoreMemberAddressByOwner,
				getRetailStoreMemberAddressDAO()::findRetailStoreMemberAddressByOwner
				);


		retailStoreMember.setRetailStoreMemberAddressList(newList);


		return retailStoreMember;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreMember presentRetailStoreMemberGiftCardList(
			RetailStoreMember retailStoreMember,
			Map<String, Object> options) {
    
		SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList = retailStoreMember.getRetailStoreMemberGiftCardList();
				SmartList<RetailStoreMemberGiftCard> newList= presentSubList(retailStoreMember.getId(),
				retailStoreMemberGiftCardList,
				options,
				getRetailStoreMemberGiftCardDAO()::countRetailStoreMemberGiftCardByOwner,
				getRetailStoreMemberGiftCardDAO()::findRetailStoreMemberGiftCardByOwner
				);


		retailStoreMember.setRetailStoreMemberGiftCardList(newList);


		return retailStoreMember;
	}
		

	
    public SmartList<RetailStoreMember> requestCandidateRetailStoreMemberForConsumerOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreMemberTable.COLUMN_NAME, RetailStoreMemberTable.COLUMN_OWNER, filterKey, pageNo, pageSize, getRetailStoreMemberMapper());
    }
		
    public SmartList<RetailStoreMember> requestCandidateRetailStoreMemberForRetailStoreMemberCoupon(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreMemberTable.COLUMN_NAME, RetailStoreMemberTable.COLUMN_OWNER, filterKey, pageNo, pageSize, getRetailStoreMemberMapper());
    }
		
    public SmartList<RetailStoreMember> requestCandidateRetailStoreMemberForMemberWishlist(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreMemberTable.COLUMN_NAME, RetailStoreMemberTable.COLUMN_OWNER, filterKey, pageNo, pageSize, getRetailStoreMemberMapper());
    }
		
    public SmartList<RetailStoreMember> requestCandidateRetailStoreMemberForMemberRewardPoint(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreMemberTable.COLUMN_NAME, RetailStoreMemberTable.COLUMN_OWNER, filterKey, pageNo, pageSize, getRetailStoreMemberMapper());
    }
		
    public SmartList<RetailStoreMember> requestCandidateRetailStoreMemberForMemberRewardPointRedemption(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreMemberTable.COLUMN_NAME, RetailStoreMemberTable.COLUMN_OWNER, filterKey, pageNo, pageSize, getRetailStoreMemberMapper());
    }
		
    public SmartList<RetailStoreMember> requestCandidateRetailStoreMemberForRetailStoreMemberAddress(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreMemberTable.COLUMN_NAME, RetailStoreMemberTable.COLUMN_OWNER, filterKey, pageNo, pageSize, getRetailStoreMemberMapper());
    }
		
    public SmartList<RetailStoreMember> requestCandidateRetailStoreMemberForRetailStoreMemberGiftCard(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreMemberTable.COLUMN_NAME, RetailStoreMemberTable.COLUMN_OWNER, filterKey, pageNo, pageSize, getRetailStoreMemberMapper());
    }
		

	protected String getTableName(){
		return RetailStoreMemberTable.TABLE_NAME;
	}



	public void enhanceList(List<RetailStoreMember> retailStoreMemberList) {
		this.enhanceListInternal(retailStoreMemberList, this.getRetailStoreMemberMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:ConsumerOrder的consumer的ConsumerOrderList
	public SmartList<ConsumerOrder> loadOurConsumerOrderList(RetailscmUserContext userContext, List<RetailStoreMember> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.CONSUMER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ConsumerOrder> loadedObjs = userContext.getDAOGroup().getConsumerOrderDAO().findConsumerOrderWithKey(key, options);
		Map<String, List<ConsumerOrder>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getConsumer().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<ConsumerOrder> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<ConsumerOrder> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setConsumerOrderList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:RetailStoreMemberCoupon的owner的RetailStoreMemberCouponList
	public SmartList<RetailStoreMemberCoupon> loadOurRetailStoreMemberCouponList(RetailscmUserContext userContext, List<RetailStoreMember> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreMemberCoupon.OWNER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<RetailStoreMemberCoupon> loadedObjs = userContext.getDAOGroup().getRetailStoreMemberCouponDAO().findRetailStoreMemberCouponWithKey(key, options);
		Map<String, List<RetailStoreMemberCoupon>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getOwner().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<RetailStoreMemberCoupon> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<RetailStoreMemberCoupon> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setRetailStoreMemberCouponList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:MemberWishlist的owner的MemberWishlistList
	public SmartList<MemberWishlist> loadOurMemberWishlistList(RetailscmUserContext userContext, List<RetailStoreMember> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(MemberWishlist.OWNER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<MemberWishlist> loadedObjs = userContext.getDAOGroup().getMemberWishlistDAO().findMemberWishlistWithKey(key, options);
		Map<String, List<MemberWishlist>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getOwner().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<MemberWishlist> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<MemberWishlist> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setMemberWishlistList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:MemberRewardPoint的owner的MemberRewardPointList
	public SmartList<MemberRewardPoint> loadOurMemberRewardPointList(RetailscmUserContext userContext, List<RetailStoreMember> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(MemberRewardPoint.OWNER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<MemberRewardPoint> loadedObjs = userContext.getDAOGroup().getMemberRewardPointDAO().findMemberRewardPointWithKey(key, options);
		Map<String, List<MemberRewardPoint>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getOwner().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<MemberRewardPoint> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<MemberRewardPoint> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setMemberRewardPointList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:MemberRewardPointRedemption的owner的MemberRewardPointRedemptionList
	public SmartList<MemberRewardPointRedemption> loadOurMemberRewardPointRedemptionList(RetailscmUserContext userContext, List<RetailStoreMember> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(MemberRewardPointRedemption.OWNER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<MemberRewardPointRedemption> loadedObjs = userContext.getDAOGroup().getMemberRewardPointRedemptionDAO().findMemberRewardPointRedemptionWithKey(key, options);
		Map<String, List<MemberRewardPointRedemption>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getOwner().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<MemberRewardPointRedemption> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<MemberRewardPointRedemption> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setMemberRewardPointRedemptionList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:RetailStoreMemberAddress的owner的RetailStoreMemberAddressList
	public SmartList<RetailStoreMemberAddress> loadOurRetailStoreMemberAddressList(RetailscmUserContext userContext, List<RetailStoreMember> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreMemberAddress.OWNER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<RetailStoreMemberAddress> loadedObjs = userContext.getDAOGroup().getRetailStoreMemberAddressDAO().findRetailStoreMemberAddressWithKey(key, options);
		Map<String, List<RetailStoreMemberAddress>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getOwner().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<RetailStoreMemberAddress> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<RetailStoreMemberAddress> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setRetailStoreMemberAddressList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:RetailStoreMemberGiftCard的owner的RetailStoreMemberGiftCardList
	public SmartList<RetailStoreMemberGiftCard> loadOurRetailStoreMemberGiftCardList(RetailscmUserContext userContext, List<RetailStoreMember> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreMemberGiftCard.OWNER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<RetailStoreMemberGiftCard> loadedObjs = userContext.getDAOGroup().getRetailStoreMemberGiftCardDAO().findRetailStoreMemberGiftCardWithKey(key, options);
		Map<String, List<RetailStoreMemberGiftCard>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getOwner().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<RetailStoreMemberGiftCard> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<RetailStoreMemberGiftCard> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setRetailStoreMemberGiftCardList(loadedSmartList);
		});
		return loadedObjs;
	}
	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<RetailStoreMember> retailStoreMemberList = ownerEntity.collectRefsWithType(RetailStoreMember.INTERNAL_TYPE);
		this.enhanceList(retailStoreMemberList);

	}

	@Override
	public SmartList<RetailStoreMember> findRetailStoreMemberWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getRetailStoreMemberMapper());

	}
	@Override
	public int countRetailStoreMemberWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countRetailStoreMemberWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<RetailStoreMember> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRetailStoreMemberMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<RetailStoreMember> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getRetailStoreMemberMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateRetailStoreMember executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateRetailStoreMember result = new CandidateRetailStoreMember();
		int pageNo = Math.max(1, query.getPageNo());
		result.setOwnerClass(TextUtil.toCamelCase(query.getOwnerType()));
		result.setOwnerId(query.getOwnerId());
		result.setFilterKey(query.getFilterKey());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase("displayName")));
		result.setGroupByFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase(query.getGroupBy())));

		SmartList candidateList = queryList(sql, parmeters);
		this.alias(candidateList);
		result.setCandidates(candidateList);
		int offSet = (pageNo - 1 ) * query.getPageSize();
		if (candidateList.size() > query.getPageSize()) {
			result.setTotalPage(pageNo+1);
		}else {
			result.setTotalPage(pageNo);
		}
		return result;
	}

	

  @Override
  public List<RetailStoreMember> search(RetailStoreMemberRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected RetailStoreMemberMapper mapper() {
    return getRetailStoreMemberMapper();
  }
}


