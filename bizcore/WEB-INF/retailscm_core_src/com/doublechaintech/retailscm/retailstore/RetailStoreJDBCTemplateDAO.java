
package com.doublechaintech.retailscm.retailstore;

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


import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation;
import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening;
import com.doublechaintech.retailscm.accountset.AccountSet;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosingDAO;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterDAO;
import com.doublechaintech.retailscm.goods.GoodsDAO;
import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreationDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecorationDAO;
import com.doublechaintech.retailscm.accountset.AccountSetDAO;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderDAO;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderDAO;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitationDAO;
import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpeningDAO;
import com.doublechaintech.retailscm.transporttask.TransportTaskDAO;
import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchisingDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class RetailStoreJDBCTemplateDAO extends RetailscmBaseDAOImpl implements RetailStoreDAO{

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

	protected RetailStoreCityServiceCenterDAO retailStoreCityServiceCenterDAO;
	public void setRetailStoreCityServiceCenterDAO(RetailStoreCityServiceCenterDAO retailStoreCityServiceCenterDAO){
 	
 		if(retailStoreCityServiceCenterDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreCityServiceCenterDAO to null.");
 		}
	 	this.retailStoreCityServiceCenterDAO = retailStoreCityServiceCenterDAO;
 	}
 	public RetailStoreCityServiceCenterDAO getRetailStoreCityServiceCenterDAO(){
 		if(this.retailStoreCityServiceCenterDAO == null){
 			throw new IllegalStateException("The retailStoreCityServiceCenterDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreCityServiceCenterDAO;
 	}	

	protected RetailStoreCreationDAO retailStoreCreationDAO;
	public void setRetailStoreCreationDAO(RetailStoreCreationDAO retailStoreCreationDAO){
 	
 		if(retailStoreCreationDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreCreationDAO to null.");
 		}
	 	this.retailStoreCreationDAO = retailStoreCreationDAO;
 	}
 	public RetailStoreCreationDAO getRetailStoreCreationDAO(){
 		if(this.retailStoreCreationDAO == null){
 			throw new IllegalStateException("The retailStoreCreationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreCreationDAO;
 	}	

	protected RetailStoreInvestmentInvitationDAO retailStoreInvestmentInvitationDAO;
	public void setRetailStoreInvestmentInvitationDAO(RetailStoreInvestmentInvitationDAO retailStoreInvestmentInvitationDAO){
 	
 		if(retailStoreInvestmentInvitationDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreInvestmentInvitationDAO to null.");
 		}
	 	this.retailStoreInvestmentInvitationDAO = retailStoreInvestmentInvitationDAO;
 	}
 	public RetailStoreInvestmentInvitationDAO getRetailStoreInvestmentInvitationDAO(){
 		if(this.retailStoreInvestmentInvitationDAO == null){
 			throw new IllegalStateException("The retailStoreInvestmentInvitationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreInvestmentInvitationDAO;
 	}	

	protected RetailStoreFranchisingDAO retailStoreFranchisingDAO;
	public void setRetailStoreFranchisingDAO(RetailStoreFranchisingDAO retailStoreFranchisingDAO){
 	
 		if(retailStoreFranchisingDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreFranchisingDAO to null.");
 		}
	 	this.retailStoreFranchisingDAO = retailStoreFranchisingDAO;
 	}
 	public RetailStoreFranchisingDAO getRetailStoreFranchisingDAO(){
 		if(this.retailStoreFranchisingDAO == null){
 			throw new IllegalStateException("The retailStoreFranchisingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreFranchisingDAO;
 	}	

	protected RetailStoreDecorationDAO retailStoreDecorationDAO;
	public void setRetailStoreDecorationDAO(RetailStoreDecorationDAO retailStoreDecorationDAO){
 	
 		if(retailStoreDecorationDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreDecorationDAO to null.");
 		}
	 	this.retailStoreDecorationDAO = retailStoreDecorationDAO;
 	}
 	public RetailStoreDecorationDAO getRetailStoreDecorationDAO(){
 		if(this.retailStoreDecorationDAO == null){
 			throw new IllegalStateException("The retailStoreDecorationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreDecorationDAO;
 	}	

	protected RetailStoreOpeningDAO retailStoreOpeningDAO;
	public void setRetailStoreOpeningDAO(RetailStoreOpeningDAO retailStoreOpeningDAO){
 	
 		if(retailStoreOpeningDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOpeningDAO to null.");
 		}
	 	this.retailStoreOpeningDAO = retailStoreOpeningDAO;
 	}
 	public RetailStoreOpeningDAO getRetailStoreOpeningDAO(){
 		if(this.retailStoreOpeningDAO == null){
 			throw new IllegalStateException("The retailStoreOpeningDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreOpeningDAO;
 	}	

	protected RetailStoreClosingDAO retailStoreClosingDAO;
	public void setRetailStoreClosingDAO(RetailStoreClosingDAO retailStoreClosingDAO){
 	
 		if(retailStoreClosingDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreClosingDAO to null.");
 		}
	 	this.retailStoreClosingDAO = retailStoreClosingDAO;
 	}
 	public RetailStoreClosingDAO getRetailStoreClosingDAO(){
 		if(this.retailStoreClosingDAO == null){
 			throw new IllegalStateException("The retailStoreClosingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreClosingDAO;
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

	protected RetailStoreOrderDAO retailStoreOrderDAO;
	public void setRetailStoreOrderDAO(RetailStoreOrderDAO retailStoreOrderDAO){
 	
 		if(retailStoreOrderDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderDAO to null.");
 		}
	 	this.retailStoreOrderDAO = retailStoreOrderDAO;
 	}
 	public RetailStoreOrderDAO getRetailStoreOrderDAO(){
 		if(this.retailStoreOrderDAO == null){
 			throw new IllegalStateException("The retailStoreOrderDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreOrderDAO;
 	}	

	protected GoodsDAO goodsDAO;
	public void setGoodsDAO(GoodsDAO goodsDAO){
 	
 		if(goodsDAO == null){
 			throw new IllegalStateException("Do not try to set goodsDAO to null.");
 		}
	 	this.goodsDAO = goodsDAO;
 	}
 	public GoodsDAO getGoodsDAO(){
 		if(this.goodsDAO == null){
 			throw new IllegalStateException("The goodsDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.goodsDAO;
 	}	

	protected TransportTaskDAO transportTaskDAO;
	public void setTransportTaskDAO(TransportTaskDAO transportTaskDAO){
 	
 		if(transportTaskDAO == null){
 			throw new IllegalStateException("Do not try to set transportTaskDAO to null.");
 		}
	 	this.transportTaskDAO = transportTaskDAO;
 	}
 	public TransportTaskDAO getTransportTaskDAO(){
 		if(this.transportTaskDAO == null){
 			throw new IllegalStateException("The transportTaskDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.transportTaskDAO;
 	}	

	protected AccountSetDAO accountSetDAO;
	public void setAccountSetDAO(AccountSetDAO accountSetDAO){
 	
 		if(accountSetDAO == null){
 			throw new IllegalStateException("Do not try to set accountSetDAO to null.");
 		}
	 	this.accountSetDAO = accountSetDAO;
 	}
 	public AccountSetDAO getAccountSetDAO(){
 		if(this.accountSetDAO == null){
 			throw new IllegalStateException("The accountSetDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.accountSetDAO;
 	}	

	
	/*
	protected RetailStore load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStore(accessKey, options);
	}
	*/
	
	public SmartList<RetailStore> loadAll() {
	    return this.loadAll(getRetailStoreMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public RetailStore load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStore(RetailStoreTable.withId(id), options);
	}
	
	
	
	public RetailStore save(RetailStore retailStore,Map<String,Object> options){
		
		String methodName="save(RetailStore retailStore,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStore, methodName, "retailStore");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStore(retailStore,options);
	}
	public RetailStore clone(String retailStoreId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreTable.withId(retailStoreId),options);
	}
	
	protected RetailStore clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStore newRetailStore = loadInternalRetailStore(accessKey, options);
		newRetailStore.setVersion(0);
		
		
 		
 		if(isSaveConsumerOrderListEnabled(options)){
 			for(ConsumerOrder item: newRetailStore.getConsumerOrderList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveRetailStoreOrderListEnabled(options)){
 			for(RetailStoreOrder item: newRetailStore.getRetailStoreOrderList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveGoodsListEnabled(options)){
 			for(Goods item: newRetailStore.getGoodsList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveTransportTaskListEnabled(options)){
 			for(TransportTask item: newRetailStore.getTransportTaskList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveAccountSetListEnabled(options)){
 			for(AccountSet item: newRetailStore.getAccountSetList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStore(newRetailStore,options);
		
		return newRetailStore;
	}
	
	
	
	

	protected void throwIfHasException(String retailStoreId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RetailStoreVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String retailStoreId, int version) throws Exception{
	
		String methodName="delete(String retailStoreId, int version)";
		assertMethodArgumentNotNull(retailStoreId, methodName, "retailStoreId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreId,version);
		}
		
	
	}
	
	
	
	
	

	public RetailStore disconnectFromAll(String retailStoreId, int version) throws Exception{
	
		
		RetailStore retailStore = loadInternalRetailStore(RetailStoreTable.withId(retailStoreId), emptyOptions());
		retailStore.clearFromAll();
		this.saveRetailStore(retailStore);
		return retailStore;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return RetailStoreTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store";
	}
	@Override
	protected String getBeanName() {
		
		return "retailStore";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractRetailStoreCountryCenterEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreTokens.RETAILSTORECOUNTRYCENTER);
 	}

 	protected boolean isSaveRetailStoreCountryCenterEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreTokens.RETAILSTORECOUNTRYCENTER);
 	}
 	

 	
  

 	protected boolean isExtractCityServiceCenterEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreTokens.CITYSERVICECENTER);
 	}

 	protected boolean isSaveCityServiceCenterEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreTokens.CITYSERVICECENTER);
 	}
 	

 	
  

 	protected boolean isExtractCreationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreTokens.CREATION);
 	}

 	protected boolean isSaveCreationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreTokens.CREATION);
 	}
 	

 	
  

 	protected boolean isExtractInvestmentInvitationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreTokens.INVESTMENTINVITATION);
 	}

 	protected boolean isSaveInvestmentInvitationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreTokens.INVESTMENTINVITATION);
 	}
 	

 	
  

 	protected boolean isExtractFranchisingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreTokens.FRANCHISING);
 	}

 	protected boolean isSaveFranchisingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreTokens.FRANCHISING);
 	}
 	

 	
  

 	protected boolean isExtractDecorationEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreTokens.DECORATION);
 	}

 	protected boolean isSaveDecorationEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreTokens.DECORATION);
 	}
 	

 	
  

 	protected boolean isExtractOpeningEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreTokens.OPENING);
 	}

 	protected boolean isSaveOpeningEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreTokens.OPENING);
 	}
 	

 	
  

 	protected boolean isExtractClosingEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreTokens.CLOSING);
 	}

 	protected boolean isSaveClosingEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreTokens.CLOSING);
 	}
 	

 	
 
		
	
	protected boolean isExtractConsumerOrderListEnabled(Map<String,Object> options){		
 		return checkOptions(options,RetailStoreTokens.CONSUMER_ORDER_LIST);
 	}
 	protected boolean isAnalyzeConsumerOrderListEnabled(Map<String,Object> options){		 		
 		return RetailStoreTokens.of(options).analyzeConsumerOrderListEnabled();
 	}
	
	protected boolean isSaveConsumerOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreTokens.CONSUMER_ORDER_LIST);
		
 	}
 	
		
	
	protected boolean isExtractRetailStoreOrderListEnabled(Map<String,Object> options){		
 		return checkOptions(options,RetailStoreTokens.RETAIL_STORE_ORDER_LIST);
 	}
 	protected boolean isAnalyzeRetailStoreOrderListEnabled(Map<String,Object> options){		 		
 		return RetailStoreTokens.of(options).analyzeRetailStoreOrderListEnabled();
 	}
	
	protected boolean isSaveRetailStoreOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreTokens.RETAIL_STORE_ORDER_LIST);
		
 	}
 	
		
	
	protected boolean isExtractGoodsListEnabled(Map<String,Object> options){		
 		return checkOptions(options,RetailStoreTokens.GOODS_LIST);
 	}
 	protected boolean isAnalyzeGoodsListEnabled(Map<String,Object> options){		 		
 		return RetailStoreTokens.of(options).analyzeGoodsListEnabled();
 	}
	
	protected boolean isSaveGoodsListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreTokens.GOODS_LIST);
		
 	}
 	
		
	
	protected boolean isExtractTransportTaskListEnabled(Map<String,Object> options){		
 		return checkOptions(options,RetailStoreTokens.TRANSPORT_TASK_LIST);
 	}
 	protected boolean isAnalyzeTransportTaskListEnabled(Map<String,Object> options){		 		
 		return RetailStoreTokens.of(options).analyzeTransportTaskListEnabled();
 	}
	
	protected boolean isSaveTransportTaskListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreTokens.TRANSPORT_TASK_LIST);
		
 	}
 	
		
	
	protected boolean isExtractAccountSetListEnabled(Map<String,Object> options){		
 		return checkOptions(options,RetailStoreTokens.ACCOUNT_SET_LIST);
 	}
 	protected boolean isAnalyzeAccountSetListEnabled(Map<String,Object> options){		 		
 		return RetailStoreTokens.of(options).analyzeAccountSetListEnabled();
 	}
	
	protected boolean isSaveAccountSetListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreTokens.ACCOUNT_SET_LIST);
		
 	}
 	
		

	

	protected RetailStoreMapper getRetailStoreMapper(){
		return new RetailStoreMapper();
	}

	
	
	protected RetailStore extractRetailStore(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			RetailStore retailStore = loadSingleObject(accessKey, getRetailStoreMapper());
			return retailStore;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreNotFoundException("RetailStore("+accessKey+") is not found!");
		}

	}

	
	

	protected RetailStore loadInternalRetailStore(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStore retailStore = extractRetailStore(accessKey, loadOptions);
 	
 		if(isExtractRetailStoreCountryCenterEnabled(loadOptions)){
	 		extractRetailStoreCountryCenter(retailStore, loadOptions);
 		}
  	
 		if(isExtractCityServiceCenterEnabled(loadOptions)){
	 		extractCityServiceCenter(retailStore, loadOptions);
 		}
  	
 		if(isExtractCreationEnabled(loadOptions)){
	 		extractCreation(retailStore, loadOptions);
 		}
  	
 		if(isExtractInvestmentInvitationEnabled(loadOptions)){
	 		extractInvestmentInvitation(retailStore, loadOptions);
 		}
  	
 		if(isExtractFranchisingEnabled(loadOptions)){
	 		extractFranchising(retailStore, loadOptions);
 		}
  	
 		if(isExtractDecorationEnabled(loadOptions)){
	 		extractDecoration(retailStore, loadOptions);
 		}
  	
 		if(isExtractOpeningEnabled(loadOptions)){
	 		extractOpening(retailStore, loadOptions);
 		}
  	
 		if(isExtractClosingEnabled(loadOptions)){
	 		extractClosing(retailStore, loadOptions);
 		}
 
		
		if(isExtractConsumerOrderListEnabled(loadOptions)){
	 		extractConsumerOrderList(retailStore, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeConsumerOrderListEnabled(loadOptions)){
	 		analyzeConsumerOrderList(retailStore, loadOptions);
 		}
 		
		
		if(isExtractRetailStoreOrderListEnabled(loadOptions)){
	 		extractRetailStoreOrderList(retailStore, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeRetailStoreOrderListEnabled(loadOptions)){
	 		analyzeRetailStoreOrderList(retailStore, loadOptions);
 		}
 		
		
		if(isExtractGoodsListEnabled(loadOptions)){
	 		extractGoodsList(retailStore, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeGoodsListEnabled(loadOptions)){
	 		analyzeGoodsList(retailStore, loadOptions);
 		}
 		
		
		if(isExtractTransportTaskListEnabled(loadOptions)){
	 		extractTransportTaskList(retailStore, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeTransportTaskListEnabled(loadOptions)){
	 		analyzeTransportTaskList(retailStore, loadOptions);
 		}
 		
		
		if(isExtractAccountSetListEnabled(loadOptions)){
	 		extractAccountSetList(retailStore, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeAccountSetListEnabled(loadOptions)){
	 		analyzeAccountSetList(retailStore, loadOptions);
 		}
 		
		
		return retailStore;
		
	}

	 

 	protected RetailStore extractRetailStoreCountryCenter(RetailStore retailStore, Map<String,Object> options) throws Exception{

		if(retailStore.getRetailStoreCountryCenter() == null){
			return retailStore;
		}
		String retailStoreCountryCenterId = retailStore.getRetailStoreCountryCenter().getId();
		if( retailStoreCountryCenterId == null){
			return retailStore;
		}
		RetailStoreCountryCenter retailStoreCountryCenter = getRetailStoreCountryCenterDAO().load(retailStoreCountryCenterId,options);
		if(retailStoreCountryCenter != null){
			retailStore.setRetailStoreCountryCenter(retailStoreCountryCenter);
		}
		
 		
 		return retailStore;
 	}
 		
  

 	protected RetailStore extractCityServiceCenter(RetailStore retailStore, Map<String,Object> options) throws Exception{

		if(retailStore.getCityServiceCenter() == null){
			return retailStore;
		}
		String cityServiceCenterId = retailStore.getCityServiceCenter().getId();
		if( cityServiceCenterId == null){
			return retailStore;
		}
		RetailStoreCityServiceCenter cityServiceCenter = getRetailStoreCityServiceCenterDAO().load(cityServiceCenterId,options);
		if(cityServiceCenter != null){
			retailStore.setCityServiceCenter(cityServiceCenter);
		}
		
 		
 		return retailStore;
 	}
 		
  

 	protected RetailStore extractCreation(RetailStore retailStore, Map<String,Object> options) throws Exception{

		if(retailStore.getCreation() == null){
			return retailStore;
		}
		String creationId = retailStore.getCreation().getId();
		if( creationId == null){
			return retailStore;
		}
		RetailStoreCreation creation = getRetailStoreCreationDAO().load(creationId,options);
		if(creation != null){
			retailStore.setCreation(creation);
		}
		
 		
 		return retailStore;
 	}
 		
  

 	protected RetailStore extractInvestmentInvitation(RetailStore retailStore, Map<String,Object> options) throws Exception{

		if(retailStore.getInvestmentInvitation() == null){
			return retailStore;
		}
		String investmentInvitationId = retailStore.getInvestmentInvitation().getId();
		if( investmentInvitationId == null){
			return retailStore;
		}
		RetailStoreInvestmentInvitation investmentInvitation = getRetailStoreInvestmentInvitationDAO().load(investmentInvitationId,options);
		if(investmentInvitation != null){
			retailStore.setInvestmentInvitation(investmentInvitation);
		}
		
 		
 		return retailStore;
 	}
 		
  

 	protected RetailStore extractFranchising(RetailStore retailStore, Map<String,Object> options) throws Exception{

		if(retailStore.getFranchising() == null){
			return retailStore;
		}
		String franchisingId = retailStore.getFranchising().getId();
		if( franchisingId == null){
			return retailStore;
		}
		RetailStoreFranchising franchising = getRetailStoreFranchisingDAO().load(franchisingId,options);
		if(franchising != null){
			retailStore.setFranchising(franchising);
		}
		
 		
 		return retailStore;
 	}
 		
  

 	protected RetailStore extractDecoration(RetailStore retailStore, Map<String,Object> options) throws Exception{

		if(retailStore.getDecoration() == null){
			return retailStore;
		}
		String decorationId = retailStore.getDecoration().getId();
		if( decorationId == null){
			return retailStore;
		}
		RetailStoreDecoration decoration = getRetailStoreDecorationDAO().load(decorationId,options);
		if(decoration != null){
			retailStore.setDecoration(decoration);
		}
		
 		
 		return retailStore;
 	}
 		
  

 	protected RetailStore extractOpening(RetailStore retailStore, Map<String,Object> options) throws Exception{

		if(retailStore.getOpening() == null){
			return retailStore;
		}
		String openingId = retailStore.getOpening().getId();
		if( openingId == null){
			return retailStore;
		}
		RetailStoreOpening opening = getRetailStoreOpeningDAO().load(openingId,options);
		if(opening != null){
			retailStore.setOpening(opening);
		}
		
 		
 		return retailStore;
 	}
 		
  

 	protected RetailStore extractClosing(RetailStore retailStore, Map<String,Object> options) throws Exception{

		if(retailStore.getClosing() == null){
			return retailStore;
		}
		String closingId = retailStore.getClosing().getId();
		if( closingId == null){
			return retailStore;
		}
		RetailStoreClosing closing = getRetailStoreClosingDAO().load(closingId,options);
		if(closing != null){
			retailStore.setClosing(closing);
		}
		
 		
 		return retailStore;
 	}
 		
 
		
	protected void enhanceConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected RetailStore extractConsumerOrderList(RetailStore retailStore, Map<String,Object> options){
		
		
		if(retailStore == null){
			return null;
		}
		if(retailStore.getId() == null){
			return retailStore;
		}

		
		
		SmartList<ConsumerOrder> consumerOrderList = getConsumerOrderDAO().findConsumerOrderByStore(retailStore.getId(),options);
		if(consumerOrderList != null){
			enhanceConsumerOrderList(consumerOrderList,options);
			retailStore.setConsumerOrderList(consumerOrderList);
		}
		
		return retailStore;
	
	}	
	
	protected RetailStore analyzeConsumerOrderList(RetailStore retailStore, Map<String,Object> options){
		
		
		if(retailStore == null){
			return null;
		}
		if(retailStore.getId() == null){
			return retailStore;
		}

		
		
		SmartList<ConsumerOrder> consumerOrderList = retailStore.getConsumerOrderList();
		if(consumerOrderList != null){
			getConsumerOrderDAO().analyzeConsumerOrderByStore(consumerOrderList, retailStore.getId(), options);
			
		}
		
		return retailStore;
	
	}	
	
		
	protected void enhanceRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected RetailStore extractRetailStoreOrderList(RetailStore retailStore, Map<String,Object> options){
		
		
		if(retailStore == null){
			return null;
		}
		if(retailStore.getId() == null){
			return retailStore;
		}

		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = getRetailStoreOrderDAO().findRetailStoreOrderByBuyer(retailStore.getId(),options);
		if(retailStoreOrderList != null){
			enhanceRetailStoreOrderList(retailStoreOrderList,options);
			retailStore.setRetailStoreOrderList(retailStoreOrderList);
		}
		
		return retailStore;
	
	}	
	
	protected RetailStore analyzeRetailStoreOrderList(RetailStore retailStore, Map<String,Object> options){
		
		
		if(retailStore == null){
			return null;
		}
		if(retailStore.getId() == null){
			return retailStore;
		}

		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStore.getRetailStoreOrderList();
		if(retailStoreOrderList != null){
			getRetailStoreOrderDAO().analyzeRetailStoreOrderByBuyer(retailStoreOrderList, retailStore.getId(), options);
			
		}
		
		return retailStore;
	
	}	
	
		
	protected void enhanceGoodsList(SmartList<Goods> goodsList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected RetailStore extractGoodsList(RetailStore retailStore, Map<String,Object> options){
		
		
		if(retailStore == null){
			return null;
		}
		if(retailStore.getId() == null){
			return retailStore;
		}

		
		
		SmartList<Goods> goodsList = getGoodsDAO().findGoodsByRetailStore(retailStore.getId(),options);
		if(goodsList != null){
			enhanceGoodsList(goodsList,options);
			retailStore.setGoodsList(goodsList);
		}
		
		return retailStore;
	
	}	
	
	protected RetailStore analyzeGoodsList(RetailStore retailStore, Map<String,Object> options){
		
		
		if(retailStore == null){
			return null;
		}
		if(retailStore.getId() == null){
			return retailStore;
		}

		
		
		SmartList<Goods> goodsList = retailStore.getGoodsList();
		if(goodsList != null){
			getGoodsDAO().analyzeGoodsByRetailStore(goodsList, retailStore.getId(), options);
			
		}
		
		return retailStore;
	
	}	
	
		
	protected void enhanceTransportTaskList(SmartList<TransportTask> transportTaskList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected RetailStore extractTransportTaskList(RetailStore retailStore, Map<String,Object> options){
		
		
		if(retailStore == null){
			return null;
		}
		if(retailStore.getId() == null){
			return retailStore;
		}

		
		
		SmartList<TransportTask> transportTaskList = getTransportTaskDAO().findTransportTaskByEnd(retailStore.getId(),options);
		if(transportTaskList != null){
			enhanceTransportTaskList(transportTaskList,options);
			retailStore.setTransportTaskList(transportTaskList);
		}
		
		return retailStore;
	
	}	
	
	protected RetailStore analyzeTransportTaskList(RetailStore retailStore, Map<String,Object> options){
		
		
		if(retailStore == null){
			return null;
		}
		if(retailStore.getId() == null){
			return retailStore;
		}

		
		
		SmartList<TransportTask> transportTaskList = retailStore.getTransportTaskList();
		if(transportTaskList != null){
			getTransportTaskDAO().analyzeTransportTaskByEnd(transportTaskList, retailStore.getId(), options);
			
		}
		
		return retailStore;
	
	}	
	
		
	protected void enhanceAccountSetList(SmartList<AccountSet> accountSetList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected RetailStore extractAccountSetList(RetailStore retailStore, Map<String,Object> options){
		
		
		if(retailStore == null){
			return null;
		}
		if(retailStore.getId() == null){
			return retailStore;
		}

		
		
		SmartList<AccountSet> accountSetList = getAccountSetDAO().findAccountSetByRetailStore(retailStore.getId(),options);
		if(accountSetList != null){
			enhanceAccountSetList(accountSetList,options);
			retailStore.setAccountSetList(accountSetList);
		}
		
		return retailStore;
	
	}	
	
	protected RetailStore analyzeAccountSetList(RetailStore retailStore, Map<String,Object> options){
		
		
		if(retailStore == null){
			return null;
		}
		if(retailStore.getId() == null){
			return retailStore;
		}

		
		
		SmartList<AccountSet> accountSetList = retailStore.getAccountSetList();
		if(accountSetList != null){
			getAccountSetDAO().analyzeAccountSetByRetailStore(accountSetList, retailStore.getId(), options);
			
		}
		
		return retailStore;
	
	}	
	
		
		
  	
 	public SmartList<RetailStore> findRetailStoreByRetailStoreCountryCenter(String retailStoreCountryCenterId,Map<String,Object> options){
 	
  		SmartList<RetailStore> resultList = queryWith(RetailStoreTable.COLUMN_RETAIL_STORE_COUNTRY_CENTER, retailStoreCountryCenterId, options, getRetailStoreMapper());
		// analyzeRetailStoreByRetailStoreCountryCenter(resultList, retailStoreCountryCenterId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RetailStore> findRetailStoreByRetailStoreCountryCenter(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RetailStore> resultList =  queryWithRange(RetailStoreTable.COLUMN_RETAIL_STORE_COUNTRY_CENTER, retailStoreCountryCenterId, options, getRetailStoreMapper(), start, count);
 		//analyzeRetailStoreByRetailStoreCountryCenter(resultList, retailStoreCountryCenterId, options);
 		return resultList;
 		
 	}
 	public void analyzeRetailStoreByRetailStoreCountryCenter(SmartList<RetailStore> resultList, String retailStoreCountryCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenterId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//RetailStore.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("双链小超");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(RetailStore.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(RetailStore.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countRetailStoreByRetailStoreCountryCenter(String retailStoreCountryCenterId,Map<String,Object> options){

 		return countWith(RetailStoreTable.COLUMN_RETAIL_STORE_COUNTRY_CENTER, retailStoreCountryCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countRetailStoreByRetailStoreCountryCenterIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RetailStoreTable.COLUMN_RETAIL_STORE_COUNTRY_CENTER, ids, options);
	}
 	
  	
 	public SmartList<RetailStore> findRetailStoreByCityServiceCenter(String retailStoreCityServiceCenterId,Map<String,Object> options){
 	
  		SmartList<RetailStore> resultList = queryWith(RetailStoreTable.COLUMN_CITY_SERVICE_CENTER, retailStoreCityServiceCenterId, options, getRetailStoreMapper());
		// analyzeRetailStoreByCityServiceCenter(resultList, retailStoreCityServiceCenterId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RetailStore> findRetailStoreByCityServiceCenter(String retailStoreCityServiceCenterId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RetailStore> resultList =  queryWithRange(RetailStoreTable.COLUMN_CITY_SERVICE_CENTER, retailStoreCityServiceCenterId, options, getRetailStoreMapper(), start, count);
 		//analyzeRetailStoreByCityServiceCenter(resultList, retailStoreCityServiceCenterId, options);
 		return resultList;
 		
 	}
 	public void analyzeRetailStoreByCityServiceCenter(SmartList<RetailStore> resultList, String retailStoreCityServiceCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(RetailStore.CITY_SERVICE_CENTER_PROPERTY, retailStoreCityServiceCenterId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//RetailStore.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("双链小超");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(RetailStore.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(RetailStore.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countRetailStoreByCityServiceCenter(String retailStoreCityServiceCenterId,Map<String,Object> options){

 		return countWith(RetailStoreTable.COLUMN_CITY_SERVICE_CENTER, retailStoreCityServiceCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countRetailStoreByCityServiceCenterIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RetailStoreTable.COLUMN_CITY_SERVICE_CENTER, ids, options);
	}
 	
  	
 	public SmartList<RetailStore> findRetailStoreByCreation(String retailStoreCreationId,Map<String,Object> options){
 	
  		SmartList<RetailStore> resultList = queryWith(RetailStoreTable.COLUMN_CREATION, retailStoreCreationId, options, getRetailStoreMapper());
		// analyzeRetailStoreByCreation(resultList, retailStoreCreationId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RetailStore> findRetailStoreByCreation(String retailStoreCreationId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RetailStore> resultList =  queryWithRange(RetailStoreTable.COLUMN_CREATION, retailStoreCreationId, options, getRetailStoreMapper(), start, count);
 		//analyzeRetailStoreByCreation(resultList, retailStoreCreationId, options);
 		return resultList;
 		
 	}
 	public void analyzeRetailStoreByCreation(SmartList<RetailStore> resultList, String retailStoreCreationId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(RetailStore.CREATION_PROPERTY, retailStoreCreationId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//RetailStore.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("双链小超");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(RetailStore.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(RetailStore.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countRetailStoreByCreation(String retailStoreCreationId,Map<String,Object> options){

 		return countWith(RetailStoreTable.COLUMN_CREATION, retailStoreCreationId, options);
 	}
 	@Override
	public Map<String, Integer> countRetailStoreByCreationIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RetailStoreTable.COLUMN_CREATION, ids, options);
	}
 	
  	
 	public SmartList<RetailStore> findRetailStoreByInvestmentInvitation(String retailStoreInvestmentInvitationId,Map<String,Object> options){
 	
  		SmartList<RetailStore> resultList = queryWith(RetailStoreTable.COLUMN_INVESTMENT_INVITATION, retailStoreInvestmentInvitationId, options, getRetailStoreMapper());
		// analyzeRetailStoreByInvestmentInvitation(resultList, retailStoreInvestmentInvitationId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RetailStore> findRetailStoreByInvestmentInvitation(String retailStoreInvestmentInvitationId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RetailStore> resultList =  queryWithRange(RetailStoreTable.COLUMN_INVESTMENT_INVITATION, retailStoreInvestmentInvitationId, options, getRetailStoreMapper(), start, count);
 		//analyzeRetailStoreByInvestmentInvitation(resultList, retailStoreInvestmentInvitationId, options);
 		return resultList;
 		
 	}
 	public void analyzeRetailStoreByInvestmentInvitation(SmartList<RetailStore> resultList, String retailStoreInvestmentInvitationId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, retailStoreInvestmentInvitationId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//RetailStore.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("双链小超");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(RetailStore.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(RetailStore.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countRetailStoreByInvestmentInvitation(String retailStoreInvestmentInvitationId,Map<String,Object> options){

 		return countWith(RetailStoreTable.COLUMN_INVESTMENT_INVITATION, retailStoreInvestmentInvitationId, options);
 	}
 	@Override
	public Map<String, Integer> countRetailStoreByInvestmentInvitationIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RetailStoreTable.COLUMN_INVESTMENT_INVITATION, ids, options);
	}
 	
  	
 	public SmartList<RetailStore> findRetailStoreByFranchising(String retailStoreFranchisingId,Map<String,Object> options){
 	
  		SmartList<RetailStore> resultList = queryWith(RetailStoreTable.COLUMN_FRANCHISING, retailStoreFranchisingId, options, getRetailStoreMapper());
		// analyzeRetailStoreByFranchising(resultList, retailStoreFranchisingId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RetailStore> findRetailStoreByFranchising(String retailStoreFranchisingId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RetailStore> resultList =  queryWithRange(RetailStoreTable.COLUMN_FRANCHISING, retailStoreFranchisingId, options, getRetailStoreMapper(), start, count);
 		//analyzeRetailStoreByFranchising(resultList, retailStoreFranchisingId, options);
 		return resultList;
 		
 	}
 	public void analyzeRetailStoreByFranchising(SmartList<RetailStore> resultList, String retailStoreFranchisingId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(RetailStore.FRANCHISING_PROPERTY, retailStoreFranchisingId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//RetailStore.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("双链小超");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(RetailStore.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(RetailStore.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countRetailStoreByFranchising(String retailStoreFranchisingId,Map<String,Object> options){

 		return countWith(RetailStoreTable.COLUMN_FRANCHISING, retailStoreFranchisingId, options);
 	}
 	@Override
	public Map<String, Integer> countRetailStoreByFranchisingIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RetailStoreTable.COLUMN_FRANCHISING, ids, options);
	}
 	
  	
 	public SmartList<RetailStore> findRetailStoreByDecoration(String retailStoreDecorationId,Map<String,Object> options){
 	
  		SmartList<RetailStore> resultList = queryWith(RetailStoreTable.COLUMN_DECORATION, retailStoreDecorationId, options, getRetailStoreMapper());
		// analyzeRetailStoreByDecoration(resultList, retailStoreDecorationId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RetailStore> findRetailStoreByDecoration(String retailStoreDecorationId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RetailStore> resultList =  queryWithRange(RetailStoreTable.COLUMN_DECORATION, retailStoreDecorationId, options, getRetailStoreMapper(), start, count);
 		//analyzeRetailStoreByDecoration(resultList, retailStoreDecorationId, options);
 		return resultList;
 		
 	}
 	public void analyzeRetailStoreByDecoration(SmartList<RetailStore> resultList, String retailStoreDecorationId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(RetailStore.DECORATION_PROPERTY, retailStoreDecorationId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//RetailStore.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("双链小超");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(RetailStore.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(RetailStore.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countRetailStoreByDecoration(String retailStoreDecorationId,Map<String,Object> options){

 		return countWith(RetailStoreTable.COLUMN_DECORATION, retailStoreDecorationId, options);
 	}
 	@Override
	public Map<String, Integer> countRetailStoreByDecorationIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RetailStoreTable.COLUMN_DECORATION, ids, options);
	}
 	
  	
 	public SmartList<RetailStore> findRetailStoreByOpening(String retailStoreOpeningId,Map<String,Object> options){
 	
  		SmartList<RetailStore> resultList = queryWith(RetailStoreTable.COLUMN_OPENING, retailStoreOpeningId, options, getRetailStoreMapper());
		// analyzeRetailStoreByOpening(resultList, retailStoreOpeningId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RetailStore> findRetailStoreByOpening(String retailStoreOpeningId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RetailStore> resultList =  queryWithRange(RetailStoreTable.COLUMN_OPENING, retailStoreOpeningId, options, getRetailStoreMapper(), start, count);
 		//analyzeRetailStoreByOpening(resultList, retailStoreOpeningId, options);
 		return resultList;
 		
 	}
 	public void analyzeRetailStoreByOpening(SmartList<RetailStore> resultList, String retailStoreOpeningId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(RetailStore.OPENING_PROPERTY, retailStoreOpeningId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//RetailStore.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("双链小超");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(RetailStore.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(RetailStore.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countRetailStoreByOpening(String retailStoreOpeningId,Map<String,Object> options){

 		return countWith(RetailStoreTable.COLUMN_OPENING, retailStoreOpeningId, options);
 	}
 	@Override
	public Map<String, Integer> countRetailStoreByOpeningIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RetailStoreTable.COLUMN_OPENING, ids, options);
	}
 	
  	
 	public SmartList<RetailStore> findRetailStoreByClosing(String retailStoreClosingId,Map<String,Object> options){
 	
  		SmartList<RetailStore> resultList = queryWith(RetailStoreTable.COLUMN_CLOSING, retailStoreClosingId, options, getRetailStoreMapper());
		// analyzeRetailStoreByClosing(resultList, retailStoreClosingId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RetailStore> findRetailStoreByClosing(String retailStoreClosingId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RetailStore> resultList =  queryWithRange(RetailStoreTable.COLUMN_CLOSING, retailStoreClosingId, options, getRetailStoreMapper(), start, count);
 		//analyzeRetailStoreByClosing(resultList, retailStoreClosingId, options);
 		return resultList;
 		
 	}
 	public void analyzeRetailStoreByClosing(SmartList<RetailStore> resultList, String retailStoreClosingId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(RetailStore.CLOSING_PROPERTY, retailStoreClosingId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//RetailStore.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("双链小超");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(RetailStore.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(RetailStore.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countRetailStoreByClosing(String retailStoreClosingId,Map<String,Object> options){

 		return countWith(RetailStoreTable.COLUMN_CLOSING, retailStoreClosingId, options);
 	}
 	@Override
	public Map<String, Integer> countRetailStoreByClosingIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RetailStoreTable.COLUMN_CLOSING, ids, options);
	}
 	
 	
		
		
		

	

	protected RetailStore saveRetailStore(RetailStore  retailStore){
		
		if(!retailStore.isChanged()){
			return retailStore;
		}
		
		
		String SQL=this.getSaveRetailStoreSQL(retailStore);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreParameters(retailStore);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStore.incVersion();
		return retailStore;
	
	}
	public SmartList<RetailStore> saveRetailStoreList(SmartList<RetailStore> retailStoreList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreList(retailStoreList);
		
		batchRetailStoreCreate((List<RetailStore>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreUpdate((List<RetailStore>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStore retailStore:retailStoreList){
			if(retailStore.isChanged()){
				retailStore.incVersion();
			}
			
		
		}
		
		
		return retailStoreList;
	}

	public SmartList<RetailStore> removeRetailStoreList(SmartList<RetailStore> retailStoreList,Map<String,Object> options){
		
		
		super.removeList(retailStoreList, options);
		
		return retailStoreList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreBatchCreateArgs(List<RetailStore> retailStoreList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStore retailStore:retailStoreList ){
			Object [] parameters = prepareRetailStoreCreateParameters(retailStore);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreBatchUpdateArgs(List<RetailStore> retailStoreList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStore retailStore:retailStoreList ){
			if(!retailStore.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreUpdateParameters(retailStore);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreCreate(List<RetailStore> retailStoreList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreBatchCreateArgs(retailStoreList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreUpdate(List<RetailStore> retailStoreList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreBatchUpdateArgs(retailStoreList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreList(List<RetailStore> retailStoreList){
		
		List<RetailStore> retailStoreCreateList=new ArrayList<RetailStore>();
		List<RetailStore> retailStoreUpdateList=new ArrayList<RetailStore>();
		
		for(RetailStore retailStore: retailStoreList){
			if(isUpdateRequest(retailStore)){
				retailStoreUpdateList.add( retailStore);
				continue;
			}
			retailStoreCreateList.add(retailStore);
		}
		
		return new Object[]{retailStoreCreateList,retailStoreUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStore retailStore){
 		return retailStore.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreSQL(RetailStore retailStore){
 		if(isUpdateRequest(retailStore)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreParameters(RetailStore retailStore){
 		if(isUpdateRequest(retailStore) ){
 			return prepareRetailStoreUpdateParameters(retailStore);
 		}
 		return prepareRetailStoreCreateParameters(retailStore);
 	}
 	protected Object[] prepareRetailStoreUpdateParameters(RetailStore retailStore){
 		Object[] parameters = new Object[19];
 
 		
 		parameters[0] = retailStore.getName();
 		
 		
 		parameters[1] = retailStore.getTelephone();
 		
 		
 		parameters[2] = retailStore.getOwner();
 		 	
 		if(retailStore.getRetailStoreCountryCenter() != null){
 			parameters[3] = retailStore.getRetailStoreCountryCenter().getId();
 		}
  	
 		if(retailStore.getCityServiceCenter() != null){
 			parameters[4] = retailStore.getCityServiceCenter().getId();
 		}
  	
 		if(retailStore.getCreation() != null){
 			parameters[5] = retailStore.getCreation().getId();
 		}
  	
 		if(retailStore.getInvestmentInvitation() != null){
 			parameters[6] = retailStore.getInvestmentInvitation().getId();
 		}
  	
 		if(retailStore.getFranchising() != null){
 			parameters[7] = retailStore.getFranchising().getId();
 		}
  	
 		if(retailStore.getDecoration() != null){
 			parameters[8] = retailStore.getDecoration().getId();
 		}
  	
 		if(retailStore.getOpening() != null){
 			parameters[9] = retailStore.getOpening().getId();
 		}
  	
 		if(retailStore.getClosing() != null){
 			parameters[10] = retailStore.getClosing().getId();
 		}
 
 		
 		parameters[11] = retailStore.getFounded();
 		
 		
 		parameters[12] = retailStore.getLatitude();
 		
 		
 		parameters[13] = retailStore.getLongitude();
 		
 		
 		parameters[14] = retailStore.getDescription();
 		
 		
 		parameters[15] = retailStore.getLastUpdateTime();
 				
 		parameters[16] = retailStore.nextVersion();
 		parameters[17] = retailStore.getId();
 		parameters[18] = retailStore.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreCreateParameters(RetailStore retailStore){
		Object[] parameters = new Object[17];
		String newRetailStoreId=getNextId();
		retailStore.setId(newRetailStoreId);
		parameters[0] =  retailStore.getId();
 
 		
 		parameters[1] = retailStore.getName();
 		
 		
 		parameters[2] = retailStore.getTelephone();
 		
 		
 		parameters[3] = retailStore.getOwner();
 		 	
 		if(retailStore.getRetailStoreCountryCenter() != null){
 			parameters[4] = retailStore.getRetailStoreCountryCenter().getId();
 		
 		}
 		 	
 		if(retailStore.getCityServiceCenter() != null){
 			parameters[5] = retailStore.getCityServiceCenter().getId();
 		
 		}
 		 	
 		if(retailStore.getCreation() != null){
 			parameters[6] = retailStore.getCreation().getId();
 		
 		}
 		 	
 		if(retailStore.getInvestmentInvitation() != null){
 			parameters[7] = retailStore.getInvestmentInvitation().getId();
 		
 		}
 		 	
 		if(retailStore.getFranchising() != null){
 			parameters[8] = retailStore.getFranchising().getId();
 		
 		}
 		 	
 		if(retailStore.getDecoration() != null){
 			parameters[9] = retailStore.getDecoration().getId();
 		
 		}
 		 	
 		if(retailStore.getOpening() != null){
 			parameters[10] = retailStore.getOpening().getId();
 		
 		}
 		 	
 		if(retailStore.getClosing() != null){
 			parameters[11] = retailStore.getClosing().getId();
 		
 		}
 		
 		
 		parameters[12] = retailStore.getFounded();
 		
 		
 		parameters[13] = retailStore.getLatitude();
 		
 		
 		parameters[14] = retailStore.getLongitude();
 		
 		
 		parameters[15] = retailStore.getDescription();
 		
 		
 		parameters[16] = retailStore.getLastUpdateTime();
 				
 				
 		return parameters;
 	}
 	
	protected RetailStore saveInternalRetailStore(RetailStore retailStore, Map<String,Object> options){
		
		saveRetailStore(retailStore);
 	
 		if(isSaveRetailStoreCountryCenterEnabled(options)){
	 		saveRetailStoreCountryCenter(retailStore, options);
 		}
  	
 		if(isSaveCityServiceCenterEnabled(options)){
	 		saveCityServiceCenter(retailStore, options);
 		}
  	
 		if(isSaveCreationEnabled(options)){
	 		saveCreation(retailStore, options);
 		}
  	
 		if(isSaveInvestmentInvitationEnabled(options)){
	 		saveInvestmentInvitation(retailStore, options);
 		}
  	
 		if(isSaveFranchisingEnabled(options)){
	 		saveFranchising(retailStore, options);
 		}
  	
 		if(isSaveDecorationEnabled(options)){
	 		saveDecoration(retailStore, options);
 		}
  	
 		if(isSaveOpeningEnabled(options)){
	 		saveOpening(retailStore, options);
 		}
  	
 		if(isSaveClosingEnabled(options)){
	 		saveClosing(retailStore, options);
 		}
 
		
		if(isSaveConsumerOrderListEnabled(options)){
	 		saveConsumerOrderList(retailStore, options);
	 		//removeConsumerOrderList(retailStore, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveRetailStoreOrderListEnabled(options)){
	 		saveRetailStoreOrderList(retailStore, options);
	 		//removeRetailStoreOrderList(retailStore, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveGoodsListEnabled(options)){
	 		saveGoodsList(retailStore, options);
	 		//removeGoodsList(retailStore, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveTransportTaskListEnabled(options)){
	 		saveTransportTaskList(retailStore, options);
	 		//removeTransportTaskList(retailStore, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveAccountSetListEnabled(options)){
	 		saveAccountSetList(retailStore, options);
	 		//removeAccountSetList(retailStore, options);
	 		//Not delete the record
	 		
 		}		
		
		return retailStore;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected RetailStore saveRetailStoreCountryCenter(RetailStore retailStore, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStore.getRetailStoreCountryCenter() == null){
 			return retailStore;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(retailStore.getRetailStoreCountryCenter(),options);
 		return retailStore;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStore saveCityServiceCenter(RetailStore retailStore, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStore.getCityServiceCenter() == null){
 			return retailStore;//do nothing when it is null
 		}
 		
 		getRetailStoreCityServiceCenterDAO().save(retailStore.getCityServiceCenter(),options);
 		return retailStore;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStore saveCreation(RetailStore retailStore, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStore.getCreation() == null){
 			return retailStore;//do nothing when it is null
 		}
 		
 		getRetailStoreCreationDAO().save(retailStore.getCreation(),options);
 		return retailStore;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStore saveInvestmentInvitation(RetailStore retailStore, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStore.getInvestmentInvitation() == null){
 			return retailStore;//do nothing when it is null
 		}
 		
 		getRetailStoreInvestmentInvitationDAO().save(retailStore.getInvestmentInvitation(),options);
 		return retailStore;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStore saveFranchising(RetailStore retailStore, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStore.getFranchising() == null){
 			return retailStore;//do nothing when it is null
 		}
 		
 		getRetailStoreFranchisingDAO().save(retailStore.getFranchising(),options);
 		return retailStore;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStore saveDecoration(RetailStore retailStore, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStore.getDecoration() == null){
 			return retailStore;//do nothing when it is null
 		}
 		
 		getRetailStoreDecorationDAO().save(retailStore.getDecoration(),options);
 		return retailStore;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStore saveOpening(RetailStore retailStore, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStore.getOpening() == null){
 			return retailStore;//do nothing when it is null
 		}
 		
 		getRetailStoreOpeningDAO().save(retailStore.getOpening(),options);
 		return retailStore;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected RetailStore saveClosing(RetailStore retailStore, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStore.getClosing() == null){
 			return retailStore;//do nothing when it is null
 		}
 		
 		getRetailStoreClosingDAO().save(retailStore.getClosing(),options);
 		return retailStore;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public RetailStore planToRemoveConsumerOrderList(RetailStore retailStore, String consumerOrderIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.STORE_PROPERTY, retailStore.getId());
		key.put(ConsumerOrder.ID_PROPERTY, consumerOrderIds);
		
		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return retailStore;
		}
		if(externalConsumerOrderList.isEmpty()){
			return retailStore;
		}
		
		for(ConsumerOrder consumerOrderItem: externalConsumerOrderList){

			consumerOrderItem.clearFromAll();
		}
		
		
		SmartList<ConsumerOrder> consumerOrderList = retailStore.getConsumerOrderList();		
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return retailStore;	
	
	}


	//disconnect RetailStore with consumer in ConsumerOrder
	public RetailStore planToRemoveConsumerOrderListWithConsumer(RetailStore retailStore, String consumerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.STORE_PROPERTY, retailStore.getId());
		key.put(ConsumerOrder.CONSUMER_PROPERTY, consumerId);
		
		SmartList<ConsumerOrder> externalConsumerOrderList = getConsumerOrderDAO().
				findConsumerOrderWithKey(key, options);
		if(externalConsumerOrderList == null){
			return retailStore;
		}
		if(externalConsumerOrderList.isEmpty()){
			return retailStore;
		}
		
		for(ConsumerOrder consumerOrderItem: externalConsumerOrderList){
			consumerOrderItem.clearConsumer();
			consumerOrderItem.clearStore();
			
		}
		
		
		SmartList<ConsumerOrder> consumerOrderList = retailStore.getConsumerOrderList();		
		consumerOrderList.addAllToRemoveList(externalConsumerOrderList);
		return retailStore;
	}
	
	public int countConsumerOrderListWithConsumer(String retailStoreId, String consumerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.STORE_PROPERTY, retailStoreId);
		key.put(ConsumerOrder.CONSUMER_PROPERTY, consumerId);
		
		int count = getConsumerOrderDAO().countConsumerOrderWithKey(key, options);
		return count;
	}
	
	public RetailStore planToRemoveRetailStoreOrderList(RetailStore retailStore, String retailStoreOrderIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.BUYER_PROPERTY, retailStore.getId());
		key.put(RetailStoreOrder.ID_PROPERTY, retailStoreOrderIds);
		
		SmartList<RetailStoreOrder> externalRetailStoreOrderList = getRetailStoreOrderDAO().
				findRetailStoreOrderWithKey(key, options);
		if(externalRetailStoreOrderList == null){
			return retailStore;
		}
		if(externalRetailStoreOrderList.isEmpty()){
			return retailStore;
		}
		
		for(RetailStoreOrder retailStoreOrderItem: externalRetailStoreOrderList){

			retailStoreOrderItem.clearFromAll();
		}
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStore.getRetailStoreOrderList();		
		retailStoreOrderList.addAllToRemoveList(externalRetailStoreOrderList);
		return retailStore;	
	
	}


	//disconnect RetailStore with seller in RetailStoreOrder
	public RetailStore planToRemoveRetailStoreOrderListWithSeller(RetailStore retailStore, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.BUYER_PROPERTY, retailStore.getId());
		key.put(RetailStoreOrder.SELLER_PROPERTY, sellerId);
		
		SmartList<RetailStoreOrder> externalRetailStoreOrderList = getRetailStoreOrderDAO().
				findRetailStoreOrderWithKey(key, options);
		if(externalRetailStoreOrderList == null){
			return retailStore;
		}
		if(externalRetailStoreOrderList.isEmpty()){
			return retailStore;
		}
		
		for(RetailStoreOrder retailStoreOrderItem: externalRetailStoreOrderList){
			retailStoreOrderItem.clearSeller();
			retailStoreOrderItem.clearBuyer();
			
		}
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStore.getRetailStoreOrderList();		
		retailStoreOrderList.addAllToRemoveList(externalRetailStoreOrderList);
		return retailStore;
	}
	
	public int countRetailStoreOrderListWithSeller(String retailStoreId, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.BUYER_PROPERTY, retailStoreId);
		key.put(RetailStoreOrder.SELLER_PROPERTY, sellerId);
		
		int count = getRetailStoreOrderDAO().countRetailStoreOrderWithKey(key, options);
		return count;
	}
	
	public RetailStore planToRemoveGoodsList(RetailStore retailStore, String goodsIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStore.getId());
		key.put(Goods.ID_PROPERTY, goodsIds);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return retailStore;
		}
		if(externalGoodsList.isEmpty()){
			return retailStore;
		}
		
		for(Goods goodsItem: externalGoodsList){

			goodsItem.clearFromAll();
		}
		
		
		SmartList<Goods> goodsList = retailStore.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return retailStore;	
	
	}


	//disconnect RetailStore with sku in Goods
	public RetailStore planToRemoveGoodsListWithSku(RetailStore retailStore, String skuId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStore.getId());
		key.put(Goods.SKU_PROPERTY, skuId);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return retailStore;
		}
		if(externalGoodsList.isEmpty()){
			return retailStore;
		}
		
		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearSku();
			goodsItem.clearRetailStore();
			
		}
		
		
		SmartList<Goods> goodsList = retailStore.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return retailStore;
	}
	
	public int countGoodsListWithSku(String retailStoreId, String skuId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);
		key.put(Goods.SKU_PROPERTY, skuId);
		
		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStore with receiving_space in Goods
	public RetailStore planToRemoveGoodsListWithReceivingSpace(RetailStore retailStore, String receivingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStore.getId());
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return retailStore;
		}
		if(externalGoodsList.isEmpty()){
			return retailStore;
		}
		
		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearReceivingSpace();
			goodsItem.clearRetailStore();
			
		}
		
		
		SmartList<Goods> goodsList = retailStore.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return retailStore;
	}
	
	public int countGoodsListWithReceivingSpace(String retailStoreId, String receivingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);
		key.put(Goods.RECEIVING_SPACE_PROPERTY, receivingSpaceId);
		
		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStore with goods_allocation in Goods
	public RetailStore planToRemoveGoodsListWithGoodsAllocation(RetailStore retailStore, String goodsAllocationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStore.getId());
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return retailStore;
		}
		if(externalGoodsList.isEmpty()){
			return retailStore;
		}
		
		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearGoodsAllocation();
			goodsItem.clearRetailStore();
			
		}
		
		
		SmartList<Goods> goodsList = retailStore.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return retailStore;
	}
	
	public int countGoodsListWithGoodsAllocation(String retailStoreId, String goodsAllocationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);
		key.put(Goods.GOODS_ALLOCATION_PROPERTY, goodsAllocationId);
		
		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStore with smart_pallet in Goods
	public RetailStore planToRemoveGoodsListWithSmartPallet(RetailStore retailStore, String smartPalletId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStore.getId());
		key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return retailStore;
		}
		if(externalGoodsList.isEmpty()){
			return retailStore;
		}
		
		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearSmartPallet();
			goodsItem.clearRetailStore();
			
		}
		
		
		SmartList<Goods> goodsList = retailStore.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return retailStore;
	}
	
	public int countGoodsListWithSmartPallet(String retailStoreId, String smartPalletId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);
		key.put(Goods.SMART_PALLET_PROPERTY, smartPalletId);
		
		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStore with shipping_space in Goods
	public RetailStore planToRemoveGoodsListWithShippingSpace(RetailStore retailStore, String shippingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStore.getId());
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return retailStore;
		}
		if(externalGoodsList.isEmpty()){
			return retailStore;
		}
		
		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearShippingSpace();
			goodsItem.clearRetailStore();
			
		}
		
		
		SmartList<Goods> goodsList = retailStore.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return retailStore;
	}
	
	public int countGoodsListWithShippingSpace(String retailStoreId, String shippingSpaceId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);
		key.put(Goods.SHIPPING_SPACE_PROPERTY, shippingSpaceId);
		
		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStore with transport_task in Goods
	public RetailStore planToRemoveGoodsListWithTransportTask(RetailStore retailStore, String transportTaskId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStore.getId());
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return retailStore;
		}
		if(externalGoodsList.isEmpty()){
			return retailStore;
		}
		
		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearTransportTask();
			goodsItem.clearRetailStore();
			
		}
		
		
		SmartList<Goods> goodsList = retailStore.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return retailStore;
	}
	
	public int countGoodsListWithTransportTask(String retailStoreId, String transportTaskId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);
		key.put(Goods.TRANSPORT_TASK_PROPERTY, transportTaskId);
		
		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStore with biz_order in Goods
	public RetailStore planToRemoveGoodsListWithBizOrder(RetailStore retailStore, String bizOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStore.getId());
		key.put(Goods.BIZ_ORDER_PROPERTY, bizOrderId);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return retailStore;
		}
		if(externalGoodsList.isEmpty()){
			return retailStore;
		}
		
		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearBizOrder();
			goodsItem.clearRetailStore();
			
		}
		
		
		SmartList<Goods> goodsList = retailStore.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return retailStore;
	}
	
	public int countGoodsListWithBizOrder(String retailStoreId, String bizOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);
		key.put(Goods.BIZ_ORDER_PROPERTY, bizOrderId);
		
		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStore with retail_store_order in Goods
	public RetailStore planToRemoveGoodsListWithRetailStoreOrder(RetailStore retailStore, String retailStoreOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStore.getId());
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);
		
		SmartList<Goods> externalGoodsList = getGoodsDAO().
				findGoodsWithKey(key, options);
		if(externalGoodsList == null){
			return retailStore;
		}
		if(externalGoodsList.isEmpty()){
			return retailStore;
		}
		
		for(Goods goodsItem: externalGoodsList){
			goodsItem.clearRetailStoreOrder();
			goodsItem.clearRetailStore();
			
		}
		
		
		SmartList<Goods> goodsList = retailStore.getGoodsList();		
		goodsList.addAllToRemoveList(externalGoodsList);
		return retailStore;
	}
	
	public int countGoodsListWithRetailStoreOrder(String retailStoreId, String retailStoreOrderId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_PROPERTY, retailStoreId);
		key.put(Goods.RETAIL_STORE_ORDER_PROPERTY, retailStoreOrderId);
		
		int count = getGoodsDAO().countGoodsWithKey(key, options);
		return count;
	}
	
	public RetailStore planToRemoveTransportTaskList(RetailStore retailStore, String transportTaskIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.END_PROPERTY, retailStore.getId());
		key.put(TransportTask.ID_PROPERTY, transportTaskIds);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return retailStore;
		}
		if(externalTransportTaskList.isEmpty()){
			return retailStore;
		}
		
		for(TransportTask transportTaskItem: externalTransportTaskList){

			transportTaskItem.clearFromAll();
		}
		
		
		SmartList<TransportTask> transportTaskList = retailStore.getTransportTaskList();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return retailStore;	
	
	}


	//disconnect RetailStore with driver in TransportTask
	public RetailStore planToRemoveTransportTaskListWithDriver(RetailStore retailStore, String driverId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.END_PROPERTY, retailStore.getId());
		key.put(TransportTask.DRIVER_PROPERTY, driverId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return retailStore;
		}
		if(externalTransportTaskList.isEmpty()){
			return retailStore;
		}
		
		for(TransportTask transportTaskItem: externalTransportTaskList){
			transportTaskItem.clearDriver();
			transportTaskItem.clearEnd();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = retailStore.getTransportTaskList();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return retailStore;
	}
	
	public int countTransportTaskListWithDriver(String retailStoreId, String driverId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.END_PROPERTY, retailStoreId);
		key.put(TransportTask.DRIVER_PROPERTY, driverId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStore with truck in TransportTask
	public RetailStore planToRemoveTransportTaskListWithTruck(RetailStore retailStore, String truckId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.END_PROPERTY, retailStore.getId());
		key.put(TransportTask.TRUCK_PROPERTY, truckId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return retailStore;
		}
		if(externalTransportTaskList.isEmpty()){
			return retailStore;
		}
		
		for(TransportTask transportTaskItem: externalTransportTaskList){
			transportTaskItem.clearTruck();
			transportTaskItem.clearEnd();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = retailStore.getTransportTaskList();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return retailStore;
	}
	
	public int countTransportTaskListWithTruck(String retailStoreId, String truckId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.END_PROPERTY, retailStoreId);
		key.put(TransportTask.TRUCK_PROPERTY, truckId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStore with belongs_to in TransportTask
	public RetailStore planToRemoveTransportTaskListWithBelongsTo(RetailStore retailStore, String belongsToId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.END_PROPERTY, retailStore.getId());
		key.put(TransportTask.BELONGS_TO_PROPERTY, belongsToId);
		
		SmartList<TransportTask> externalTransportTaskList = getTransportTaskDAO().
				findTransportTaskWithKey(key, options);
		if(externalTransportTaskList == null){
			return retailStore;
		}
		if(externalTransportTaskList.isEmpty()){
			return retailStore;
		}
		
		for(TransportTask transportTaskItem: externalTransportTaskList){
			transportTaskItem.clearBelongsTo();
			transportTaskItem.clearEnd();
			
		}
		
		
		SmartList<TransportTask> transportTaskList = retailStore.getTransportTaskList();		
		transportTaskList.addAllToRemoveList(externalTransportTaskList);
		return retailStore;
	}
	
	public int countTransportTaskListWithBelongsTo(String retailStoreId, String belongsToId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.END_PROPERTY, retailStoreId);
		key.put(TransportTask.BELONGS_TO_PROPERTY, belongsToId);
		
		int count = getTransportTaskDAO().countTransportTaskWithKey(key, options);
		return count;
	}
	
	public RetailStore planToRemoveAccountSetList(RetailStore retailStore, String accountSetIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountSet.RETAIL_STORE_PROPERTY, retailStore.getId());
		key.put(AccountSet.ID_PROPERTY, accountSetIds);
		
		SmartList<AccountSet> externalAccountSetList = getAccountSetDAO().
				findAccountSetWithKey(key, options);
		if(externalAccountSetList == null){
			return retailStore;
		}
		if(externalAccountSetList.isEmpty()){
			return retailStore;
		}
		
		for(AccountSet accountSetItem: externalAccountSetList){

			accountSetItem.clearFromAll();
		}
		
		
		SmartList<AccountSet> accountSetList = retailStore.getAccountSetList();		
		accountSetList.addAllToRemoveList(externalAccountSetList);
		return retailStore;	
	
	}


	//disconnect RetailStore with country_center in AccountSet
	public RetailStore planToRemoveAccountSetListWithCountryCenter(RetailStore retailStore, String countryCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountSet.RETAIL_STORE_PROPERTY, retailStore.getId());
		key.put(AccountSet.COUNTRY_CENTER_PROPERTY, countryCenterId);
		
		SmartList<AccountSet> externalAccountSetList = getAccountSetDAO().
				findAccountSetWithKey(key, options);
		if(externalAccountSetList == null){
			return retailStore;
		}
		if(externalAccountSetList.isEmpty()){
			return retailStore;
		}
		
		for(AccountSet accountSetItem: externalAccountSetList){
			accountSetItem.clearCountryCenter();
			accountSetItem.clearRetailStore();
			
		}
		
		
		SmartList<AccountSet> accountSetList = retailStore.getAccountSetList();		
		accountSetList.addAllToRemoveList(externalAccountSetList);
		return retailStore;
	}
	
	public int countAccountSetListWithCountryCenter(String retailStoreId, String countryCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountSet.RETAIL_STORE_PROPERTY, retailStoreId);
		key.put(AccountSet.COUNTRY_CENTER_PROPERTY, countryCenterId);
		
		int count = getAccountSetDAO().countAccountSetWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStore with goods_supplier in AccountSet
	public RetailStore planToRemoveAccountSetListWithGoodsSupplier(RetailStore retailStore, String goodsSupplierId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountSet.RETAIL_STORE_PROPERTY, retailStore.getId());
		key.put(AccountSet.GOODS_SUPPLIER_PROPERTY, goodsSupplierId);
		
		SmartList<AccountSet> externalAccountSetList = getAccountSetDAO().
				findAccountSetWithKey(key, options);
		if(externalAccountSetList == null){
			return retailStore;
		}
		if(externalAccountSetList.isEmpty()){
			return retailStore;
		}
		
		for(AccountSet accountSetItem: externalAccountSetList){
			accountSetItem.clearGoodsSupplier();
			accountSetItem.clearRetailStore();
			
		}
		
		
		SmartList<AccountSet> accountSetList = retailStore.getAccountSetList();		
		accountSetList.addAllToRemoveList(externalAccountSetList);
		return retailStore;
	}
	
	public int countAccountSetListWithGoodsSupplier(String retailStoreId, String goodsSupplierId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountSet.RETAIL_STORE_PROPERTY, retailStoreId);
		key.put(AccountSet.GOODS_SUPPLIER_PROPERTY, goodsSupplierId);
		
		int count = getAccountSetDAO().countAccountSetWithKey(key, options);
		return count;
	}
	

		
	protected RetailStore saveConsumerOrderList(RetailStore retailStore, Map<String,Object> options){
		
		
		
		
		SmartList<ConsumerOrder> consumerOrderList = retailStore.getConsumerOrderList();
		if(consumerOrderList == null){
			//null list means nothing
			return retailStore;
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
		
		
		return retailStore;
	
	}
	
	protected RetailStore removeConsumerOrderList(RetailStore retailStore, Map<String,Object> options){
	
	
		SmartList<ConsumerOrder> consumerOrderList = retailStore.getConsumerOrderList();
		if(consumerOrderList == null){
			return retailStore;
		}	
	
		SmartList<ConsumerOrder> toRemoveConsumerOrderList = consumerOrderList.getToRemoveList();
		
		if(toRemoveConsumerOrderList == null){
			return retailStore;
		}
		if(toRemoveConsumerOrderList.isEmpty()){
			return retailStore;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getConsumerOrderDAO().removeConsumerOrderList(toRemoveConsumerOrderList,options);
		
		return retailStore;
	
	}
	
	

 	
 	
	
	
	
		
	protected RetailStore saveRetailStoreOrderList(RetailStore retailStore, Map<String,Object> options){
		
		
		
		
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStore.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			//null list means nothing
			return retailStore;
		}
		SmartList<RetailStoreOrder> mergedUpdateRetailStoreOrderList = new SmartList<RetailStoreOrder>();
		
		
		mergedUpdateRetailStoreOrderList.addAll(retailStoreOrderList); 
		if(retailStoreOrderList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateRetailStoreOrderList.addAll(retailStoreOrderList.getToRemoveList());
			retailStoreOrderList.removeAll(retailStoreOrderList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getRetailStoreOrderDAO().saveRetailStoreOrderList(mergedUpdateRetailStoreOrderList,options);
		
		if(retailStoreOrderList.getToRemoveList() != null){
			retailStoreOrderList.removeAll(retailStoreOrderList.getToRemoveList());
		}
		
		
		return retailStore;
	
	}
	
	protected RetailStore removeRetailStoreOrderList(RetailStore retailStore, Map<String,Object> options){
	
	
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStore.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			return retailStore;
		}	
	
		SmartList<RetailStoreOrder> toRemoveRetailStoreOrderList = retailStoreOrderList.getToRemoveList();
		
		if(toRemoveRetailStoreOrderList == null){
			return retailStore;
		}
		if(toRemoveRetailStoreOrderList.isEmpty()){
			return retailStore;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreOrderDAO().removeRetailStoreOrderList(toRemoveRetailStoreOrderList,options);
		
		return retailStore;
	
	}
	
	

 	
 	
	
	
	
		
	protected RetailStore saveGoodsList(RetailStore retailStore, Map<String,Object> options){
		
		
		
		
		SmartList<Goods> goodsList = retailStore.getGoodsList();
		if(goodsList == null){
			//null list means nothing
			return retailStore;
		}
		SmartList<Goods> mergedUpdateGoodsList = new SmartList<Goods>();
		
		
		mergedUpdateGoodsList.addAll(goodsList); 
		if(goodsList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateGoodsList.addAll(goodsList.getToRemoveList());
			goodsList.removeAll(goodsList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getGoodsDAO().saveGoodsList(mergedUpdateGoodsList,options);
		
		if(goodsList.getToRemoveList() != null){
			goodsList.removeAll(goodsList.getToRemoveList());
		}
		
		
		return retailStore;
	
	}
	
	protected RetailStore removeGoodsList(RetailStore retailStore, Map<String,Object> options){
	
	
		SmartList<Goods> goodsList = retailStore.getGoodsList();
		if(goodsList == null){
			return retailStore;
		}	
	
		SmartList<Goods> toRemoveGoodsList = goodsList.getToRemoveList();
		
		if(toRemoveGoodsList == null){
			return retailStore;
		}
		if(toRemoveGoodsList.isEmpty()){
			return retailStore;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getGoodsDAO().removeGoodsList(toRemoveGoodsList,options);
		
		return retailStore;
	
	}
	
	

 	
 	
	
	
	
		
	protected RetailStore saveTransportTaskList(RetailStore retailStore, Map<String,Object> options){
		
		
		
		
		SmartList<TransportTask> transportTaskList = retailStore.getTransportTaskList();
		if(transportTaskList == null){
			//null list means nothing
			return retailStore;
		}
		SmartList<TransportTask> mergedUpdateTransportTaskList = new SmartList<TransportTask>();
		
		
		mergedUpdateTransportTaskList.addAll(transportTaskList); 
		if(transportTaskList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateTransportTaskList.addAll(transportTaskList.getToRemoveList());
			transportTaskList.removeAll(transportTaskList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getTransportTaskDAO().saveTransportTaskList(mergedUpdateTransportTaskList,options);
		
		if(transportTaskList.getToRemoveList() != null){
			transportTaskList.removeAll(transportTaskList.getToRemoveList());
		}
		
		
		return retailStore;
	
	}
	
	protected RetailStore removeTransportTaskList(RetailStore retailStore, Map<String,Object> options){
	
	
		SmartList<TransportTask> transportTaskList = retailStore.getTransportTaskList();
		if(transportTaskList == null){
			return retailStore;
		}	
	
		SmartList<TransportTask> toRemoveTransportTaskList = transportTaskList.getToRemoveList();
		
		if(toRemoveTransportTaskList == null){
			return retailStore;
		}
		if(toRemoveTransportTaskList.isEmpty()){
			return retailStore;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getTransportTaskDAO().removeTransportTaskList(toRemoveTransportTaskList,options);
		
		return retailStore;
	
	}
	
	

 	
 	
	
	
	
		
	protected RetailStore saveAccountSetList(RetailStore retailStore, Map<String,Object> options){
		
		
		
		
		SmartList<AccountSet> accountSetList = retailStore.getAccountSetList();
		if(accountSetList == null){
			//null list means nothing
			return retailStore;
		}
		SmartList<AccountSet> mergedUpdateAccountSetList = new SmartList<AccountSet>();
		
		
		mergedUpdateAccountSetList.addAll(accountSetList); 
		if(accountSetList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateAccountSetList.addAll(accountSetList.getToRemoveList());
			accountSetList.removeAll(accountSetList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getAccountSetDAO().saveAccountSetList(mergedUpdateAccountSetList,options);
		
		if(accountSetList.getToRemoveList() != null){
			accountSetList.removeAll(accountSetList.getToRemoveList());
		}
		
		
		return retailStore;
	
	}
	
	protected RetailStore removeAccountSetList(RetailStore retailStore, Map<String,Object> options){
	
	
		SmartList<AccountSet> accountSetList = retailStore.getAccountSetList();
		if(accountSetList == null){
			return retailStore;
		}	
	
		SmartList<AccountSet> toRemoveAccountSetList = accountSetList.getToRemoveList();
		
		if(toRemoveAccountSetList == null){
			return retailStore;
		}
		if(toRemoveAccountSetList.isEmpty()){
			return retailStore;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAccountSetDAO().removeAccountSetList(toRemoveAccountSetList,options);
		
		return retailStore;
	
	}
	
	

 	
 	
	
	
	
		

	public RetailStore present(RetailStore retailStore,Map<String, Object> options){
	
		presentConsumerOrderList(retailStore,options);
		presentRetailStoreOrderList(retailStore,options);
		presentGoodsList(retailStore,options);
		presentTransportTaskList(retailStore,options);
		presentAccountSetList(retailStore,options);

		return retailStore;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStore presentConsumerOrderList(
			RetailStore retailStore,
			Map<String, Object> options) {

		SmartList<ConsumerOrder> consumerOrderList = retailStore.getConsumerOrderList();		
				SmartList<ConsumerOrder> newList= presentSubList(retailStore.getId(),
				consumerOrderList,
				options,
				getConsumerOrderDAO()::countConsumerOrderByStore,
				getConsumerOrderDAO()::findConsumerOrderByStore
				);

		
		retailStore.setConsumerOrderList(newList);
		

		return retailStore;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStore presentRetailStoreOrderList(
			RetailStore retailStore,
			Map<String, Object> options) {

		SmartList<RetailStoreOrder> retailStoreOrderList = retailStore.getRetailStoreOrderList();		
				SmartList<RetailStoreOrder> newList= presentSubList(retailStore.getId(),
				retailStoreOrderList,
				options,
				getRetailStoreOrderDAO()::countRetailStoreOrderByBuyer,
				getRetailStoreOrderDAO()::findRetailStoreOrderByBuyer
				);

		
		retailStore.setRetailStoreOrderList(newList);
		

		return retailStore;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStore presentGoodsList(
			RetailStore retailStore,
			Map<String, Object> options) {

		SmartList<Goods> goodsList = retailStore.getGoodsList();		
				SmartList<Goods> newList= presentSubList(retailStore.getId(),
				goodsList,
				options,
				getGoodsDAO()::countGoodsByRetailStore,
				getGoodsDAO()::findGoodsByRetailStore
				);

		
		retailStore.setGoodsList(newList);
		

		return retailStore;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStore presentTransportTaskList(
			RetailStore retailStore,
			Map<String, Object> options) {

		SmartList<TransportTask> transportTaskList = retailStore.getTransportTaskList();		
				SmartList<TransportTask> newList= presentSubList(retailStore.getId(),
				transportTaskList,
				options,
				getTransportTaskDAO()::countTransportTaskByEnd,
				getTransportTaskDAO()::findTransportTaskByEnd
				);

		
		retailStore.setTransportTaskList(newList);
		

		return retailStore;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStore presentAccountSetList(
			RetailStore retailStore,
			Map<String, Object> options) {

		SmartList<AccountSet> accountSetList = retailStore.getAccountSetList();		
				SmartList<AccountSet> newList= presentSubList(retailStore.getId(),
				accountSetList,
				options,
				getAccountSetDAO()::countAccountSetByRetailStore,
				getAccountSetDAO()::findAccountSetByRetailStore
				);

		
		retailStore.setAccountSetList(newList);
		

		return retailStore;
	}			
		

	
    public SmartList<RetailStore> requestCandidateRetailStoreForConsumerOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreTable.COLUMN_NAME, RetailStoreTable.COLUMN_RETAIL_STORE_COUNTRY_CENTER, filterKey, pageNo, pageSize, getRetailStoreMapper());
    }
		
    public SmartList<RetailStore> requestCandidateRetailStoreForRetailStoreOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreTable.COLUMN_NAME, RetailStoreTable.COLUMN_RETAIL_STORE_COUNTRY_CENTER, filterKey, pageNo, pageSize, getRetailStoreMapper());
    }
		
    public SmartList<RetailStore> requestCandidateRetailStoreForGoods(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreTable.COLUMN_NAME, RetailStoreTable.COLUMN_RETAIL_STORE_COUNTRY_CENTER, filterKey, pageNo, pageSize, getRetailStoreMapper());
    }
		
    public SmartList<RetailStore> requestCandidateRetailStoreForTransportTask(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreTable.COLUMN_NAME, RetailStoreTable.COLUMN_RETAIL_STORE_COUNTRY_CENTER, filterKey, pageNo, pageSize, getRetailStoreMapper());
    }
		
    public SmartList<RetailStore> requestCandidateRetailStoreForAccountSet(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreTable.COLUMN_NAME, RetailStoreTable.COLUMN_RETAIL_STORE_COUNTRY_CENTER, filterKey, pageNo, pageSize, getRetailStoreMapper());
    }
		

	protected String getTableName(){
		return RetailStoreTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<RetailStore> retailStoreList) {		
		this.enhanceListInternal(retailStoreList, this.getRetailStoreMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:ConsumerOrder的store的ConsumerOrderList
	public SmartList<ConsumerOrder> loadOurConsumerOrderList(RetailscmUserContext userContext, List<RetailStore> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ConsumerOrder.STORE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ConsumerOrder> loadedObjs = userContext.getDAOGroup().getConsumerOrderDAO().findConsumerOrderWithKey(key, options);
		Map<String, List<ConsumerOrder>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getStore().getId()));
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
	
	// 需要一个加载引用我的对象的enhance方法:RetailStoreOrder的buyer的RetailStoreOrderList
	public SmartList<RetailStoreOrder> loadOurRetailStoreOrderList(RetailscmUserContext userContext, List<RetailStore> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.BUYER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<RetailStoreOrder> loadedObjs = userContext.getDAOGroup().getRetailStoreOrderDAO().findRetailStoreOrderWithKey(key, options);
		Map<String, List<RetailStoreOrder>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getBuyer().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<RetailStoreOrder> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<RetailStoreOrder> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setRetailStoreOrderList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:Goods的retailStore的GoodsList
	public SmartList<Goods> loadOurGoodsList(RetailscmUserContext userContext, List<RetailStore> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Goods.RETAIL_STORE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Goods> loadedObjs = userContext.getDAOGroup().getGoodsDAO().findGoodsWithKey(key, options);
		Map<String, List<Goods>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getRetailStore().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Goods> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Goods> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setGoodsList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:TransportTask的end的TransportTaskList
	public SmartList<TransportTask> loadOurTransportTaskList(RetailscmUserContext userContext, List<RetailStore> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportTask.END_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<TransportTask> loadedObjs = userContext.getDAOGroup().getTransportTaskDAO().findTransportTaskWithKey(key, options);
		Map<String, List<TransportTask>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getEnd().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<TransportTask> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<TransportTask> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setTransportTaskList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:AccountSet的retailStore的AccountSetList
	public SmartList<AccountSet> loadOurAccountSetList(RetailscmUserContext userContext, List<RetailStore> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountSet.RETAIL_STORE_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<AccountSet> loadedObjs = userContext.getDAOGroup().getAccountSetDAO().findAccountSetWithKey(key, options);
		Map<String, List<AccountSet>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getRetailStore().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<AccountSet> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<AccountSet> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setAccountSetList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<RetailStore> retailStoreList = ownerEntity.collectRefsWithType(RetailStore.INTERNAL_TYPE);
		this.enhanceList(retailStoreList);
		
	}
	
	@Override
	public SmartList<RetailStore> findRetailStoreWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getRetailStoreMapper());

	}
	@Override
	public int countRetailStoreWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countRetailStoreWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<RetailStore> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRetailStoreMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateRetailStore executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateRetailStore result = new CandidateRetailStore();
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
	
	

}


