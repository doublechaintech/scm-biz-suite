package com.doublechaintech.retailscm;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class RetailscmNamingServiceDAO extends CommonJDBCTemplateDAO {

	private static Map<String, String[]>namingTableMap;
	static {
		namingTableMap = new HashMap<String, String[]>();
		namingTableMap.put("RetailStoreCountryCenter", new String[]{"retail_store_country_center_data","name"});
		namingTableMap.put("Catalog", new String[]{"catalog_data","name"});
		namingTableMap.put("LevelOneCategory", new String[]{"level_one_category_data","name"});
		namingTableMap.put("LevelTwoCategory", new String[]{"level_two_category_data","name"});
		namingTableMap.put("LevelThreeCategory", new String[]{"level_three_category_data","name"});
		namingTableMap.put("Product", new String[]{"product_data","name"});
		namingTableMap.put("Sku", new String[]{"sku_data","name"});
		namingTableMap.put("RetailStoreProvinceCenter", new String[]{"retail_store_province_center_data","name"});
		namingTableMap.put("ProvinceCenterDepartment", new String[]{"province_center_department_data","name"});
		namingTableMap.put("ProvinceCenterEmployee", new String[]{"province_center_employee_data","name"});
		namingTableMap.put("RetailStoreCityServiceCenter", new String[]{"retail_store_city_service_center_data","name"});
		namingTableMap.put("CityPartner", new String[]{"city_partner_data","name"});
		namingTableMap.put("PotentialCustomer", new String[]{"potential_customer_data","name"});
		namingTableMap.put("PotentialCustomerContactPerson", new String[]{"potential_customer_contact_person_data","name"});
		namingTableMap.put("PotentialCustomerContact", new String[]{"potential_customer_contact_data","name"});
		namingTableMap.put("CityEvent", new String[]{"city_event_data","name"});
		namingTableMap.put("EventAttendance", new String[]{"event_attendance_data","name"});
		namingTableMap.put("RetailStore", new String[]{"retail_store_data","name"});
		namingTableMap.put("RetailStoreCreation", new String[]{"retail_store_creation_data","comment"});
		namingTableMap.put("RetailStoreInvestmentInvitation", new String[]{"retail_store_investment_invitation_data","comment"});
		namingTableMap.put("RetailStoreFranchising", new String[]{"retail_store_franchising_data","comment"});
		namingTableMap.put("RetailStoreDecoration", new String[]{"retail_store_decoration_data","comment"});
		namingTableMap.put("RetailStoreOpening", new String[]{"retail_store_opening_data","comment"});
		namingTableMap.put("RetailStoreClosing", new String[]{"retail_store_closing_data","comment"});
		namingTableMap.put("RetailStoreMember", new String[]{"retail_store_member_data","name"});
		namingTableMap.put("ConsumerOrder", new String[]{"consumer_order_data","title"});
		namingTableMap.put("ConsumerOrderLineItem", new String[]{"consumer_order_line_item_data","sku_id"});
		namingTableMap.put("ConsumerOrderShippingGroup", new String[]{"consumer_order_shipping_group_data","name"});
		namingTableMap.put("ConsumerOrderPaymentGroup", new String[]{"consumer_order_payment_group_data","name"});
		namingTableMap.put("ConsumerOrderPriceAdjustment", new String[]{"consumer_order_price_adjustment_data","name"});
		namingTableMap.put("RetailStoreMemberCoupon", new String[]{"retail_store_member_coupon_data","name"});
		namingTableMap.put("MemberWishlist", new String[]{"member_wishlist_data","name"});
		namingTableMap.put("MemberRewardPoint", new String[]{"member_reward_point_data","name"});
		namingTableMap.put("MemberRewardPointRedemption", new String[]{"member_reward_point_redemption_data","name"});
		namingTableMap.put("MemberWishlistProduct", new String[]{"member_wishlist_product_data","name"});
		namingTableMap.put("RetailStoreMemberAddress", new String[]{"retail_store_member_address_data","name"});
		namingTableMap.put("RetailStoreMemberGiftCard", new String[]{"retail_store_member_gift_card_data","name"});
		namingTableMap.put("RetailStoreMemberGiftCardConsumeRecord", new String[]{"retail_store_member_gift_card_consume_record_data","number"});
		namingTableMap.put("GoodsSupplier", new String[]{"goods_supplier_data","name"});
		namingTableMap.put("SupplierProduct", new String[]{"supplier_product_data","product_name"});
		namingTableMap.put("ProductSupplyDuration", new String[]{"product_supply_duration_data","duration"});
		namingTableMap.put("SupplyOrder", new String[]{"supply_order_data","title"});
		namingTableMap.put("SupplyOrderLineItem", new String[]{"supply_order_line_item_data","sku_id"});
		namingTableMap.put("SupplyOrderShippingGroup", new String[]{"supply_order_shipping_group_data","name"});
		namingTableMap.put("SupplyOrderPaymentGroup", new String[]{"supply_order_payment_group_data","name"});
		namingTableMap.put("RetailStoreOrder", new String[]{"retail_store_order_data","title"});
		namingTableMap.put("RetailStoreOrderLineItem", new String[]{"retail_store_order_line_item_data","sku_id"});
		namingTableMap.put("RetailStoreOrderShippingGroup", new String[]{"retail_store_order_shipping_group_data","name"});
		namingTableMap.put("RetailStoreOrderPaymentGroup", new String[]{"retail_store_order_payment_group_data","name"});
		namingTableMap.put("Warehouse", new String[]{"warehouse_data","location"});
		namingTableMap.put("StorageSpace", new String[]{"storage_space_data","location"});
		namingTableMap.put("SmartPallet", new String[]{"smart_pallet_data","location"});
		namingTableMap.put("GoodsShelf", new String[]{"goods_shelf_data","location"});
		namingTableMap.put("GoodsShelfStockCount", new String[]{"goods_shelf_stock_count_data","title"});
		namingTableMap.put("StockCountIssueTrack", new String[]{"stock_count_issue_track_data","title"});
		namingTableMap.put("GoodsAllocation", new String[]{"goods_allocation_data","location"});
		namingTableMap.put("Goods", new String[]{"goods_data","name"});
		namingTableMap.put("GoodsMovement", new String[]{"goods_movement_data","facility"});
		namingTableMap.put("SupplierSpace", new String[]{"supplier_space_data","location"});
		namingTableMap.put("ReceivingSpace", new String[]{"receiving_space_data","location"});
		namingTableMap.put("ShippingSpace", new String[]{"shipping_space_data","location"});
		namingTableMap.put("DamageSpace", new String[]{"damage_space_data","location"});
		namingTableMap.put("WarehouseAsset", new String[]{"warehouse_asset_data","name"});
		namingTableMap.put("TransportFleet", new String[]{"transport_fleet_data","name"});
		namingTableMap.put("TransportTruck", new String[]{"transport_truck_data","name"});
		namingTableMap.put("TruckDriver", new String[]{"truck_driver_data","name"});
		namingTableMap.put("TransportTask", new String[]{"transport_task_data","name"});
		namingTableMap.put("TransportTaskTrack", new String[]{"transport_task_track_data","id"});
		namingTableMap.put("AccountSet", new String[]{"account_set_data","name"});
		namingTableMap.put("AccountingSubject", new String[]{"accounting_subject_data","accounting_subject_code"});
		namingTableMap.put("AccountingPeriod", new String[]{"accounting_period_data","name"});
		namingTableMap.put("AccountingDocumentType", new String[]{"accounting_document_type_data","name"});
		namingTableMap.put("AccountingDocument", new String[]{"accounting_document_data","name"});
		namingTableMap.put("OriginalVoucher", new String[]{"original_voucher_data","title"});
		namingTableMap.put("AccountingDocumentLine", new String[]{"accounting_document_line_data","name"});
		namingTableMap.put("LevelOneDepartment", new String[]{"level_one_department_data","name"});
		namingTableMap.put("LevelTwoDepartment", new String[]{"level_two_department_data","name"});
		namingTableMap.put("LevelThreeDepartment", new String[]{"level_three_department_data","name"});
		namingTableMap.put("SkillType", new String[]{"skill_type_data","code"});
		namingTableMap.put("ResponsibilityType", new String[]{"responsibility_type_data","code"});
		namingTableMap.put("TerminationReason", new String[]{"termination_reason_data","code"});
		namingTableMap.put("TerminationType", new String[]{"termination_type_data","code"});
		namingTableMap.put("OccupationType", new String[]{"occupation_type_data","code"});
		namingTableMap.put("LeaveType", new String[]{"leave_type_data","code"});
		namingTableMap.put("SalaryGrade", new String[]{"salary_grade_data","code"});
		namingTableMap.put("InterviewType", new String[]{"interview_type_data","code"});
		namingTableMap.put("TrainingCourseType", new String[]{"training_course_type_data","code"});
		namingTableMap.put("PublicHoliday", new String[]{"public_holiday_data","code"});
		namingTableMap.put("Termination", new String[]{"termination_data","comment"});
		namingTableMap.put("View", new String[]{"view_data","who"});
		namingTableMap.put("Employee", new String[]{"employee_data","title"});
		namingTableMap.put("Instructor", new String[]{"instructor_data","title"});
		namingTableMap.put("CompanyTraining", new String[]{"company_training_data","title"});
		namingTableMap.put("Scoring", new String[]{"scoring_data","scored_by"});
		namingTableMap.put("EmployeeCompanyTraining", new String[]{"employee_company_training_data","id"});
		namingTableMap.put("EmployeeSkill", new String[]{"employee_skill_data","description"});
		namingTableMap.put("EmployeePerformance", new String[]{"employee_performance_data","performance_comment"});
		namingTableMap.put("EmployeeWorkExperience", new String[]{"employee_work_experience_data","company"});
		namingTableMap.put("EmployeeLeave", new String[]{"employee_leave_data","remark"});
		namingTableMap.put("EmployeeInterview", new String[]{"employee_interview_data","remark"});
		namingTableMap.put("EmployeeAttendance", new String[]{"employee_attendance_data","remark"});
		namingTableMap.put("EmployeeQualifier", new String[]{"employee_qualifier_data","type"});
		namingTableMap.put("EmployeeEducation", new String[]{"employee_education_data","type"});
		namingTableMap.put("EmployeeAward", new String[]{"employee_award_data","type"});
		namingTableMap.put("EmployeeSalarySheet", new String[]{"employee_salary_sheet_data","id"});
		namingTableMap.put("PayingOff", new String[]{"paying_off_data","who"});
		namingTableMap.put("MobileApp", new String[]{"mobile_app_data","name"});
		namingTableMap.put("Page", new String[]{"page_data","page_title"});
		namingTableMap.put("PageType", new String[]{"page_type_data","name"});
		namingTableMap.put("Slide", new String[]{"slide_data","name"});
		namingTableMap.put("UiAction", new String[]{"ui_action_data","code"});
		namingTableMap.put("Section", new String[]{"section_data","title"});
		namingTableMap.put("UserDomain", new String[]{"user_domain_data","name"});
		namingTableMap.put("UserAllowList", new String[]{"user_allow_list_data","user_identity"});
		namingTableMap.put("SecUser", new String[]{"sec_user_data","login"});
		namingTableMap.put("UserApp", new String[]{"user_app_data","title"});
		namingTableMap.put("QuickLink", new String[]{"quick_link_data","name"});
		namingTableMap.put("ListAccess", new String[]{"list_access_data","name"});
		namingTableMap.put("LoginHistory", new String[]{"login_history_data","from_ip"});
		namingTableMap.put("CandidateContainer", new String[]{"candidate_container_data","name"});
		namingTableMap.put("CandidateElement", new String[]{"candidate_element_data","name"});
		namingTableMap.put("WechatWorkappIdentity", new String[]{"wechat_workapp_identity_data","corp_id"});
		namingTableMap.put("WechatMiniappIdentity", new String[]{"wechat_miniapp_identity_data","open_id"});
		namingTableMap.put("KeypairIdentity", new String[]{"keypair_identity_data","public_key"});
		namingTableMap.put("PublicKeyType", new String[]{"public_key_type_data","name"});
		namingTableMap.put("TreeNode", new String[]{"tree_node_data","node_id"});
		

		
		
	}

	@Override
	protected String[] getNormalColumnNames() {
		// TODO Auto-generated method stub
		return new String[]{"id"};
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "naming";
	}

	@Override
	protected String getBeanName() {
		// TODO Auto-generated method stub
		return null;
	}
	 
	public void alias(List<BaseEntity> entityList){
		//this.getClass().getSimpleName()
		//these objects are most likely the same, or most are the same
		if(entityList == null){
			//noting to be enhanced
			return;
		}
		
		if(entityList.isEmpty()){
			//noting to be enhanced
			return;
		}
		List<BaseEntity> entityListToSort = new ArrayList<BaseEntity>();
		entityListToSort.addAll(entityList);
		Collections.sort(entityListToSort, new Comparator<BaseEntity>(){

			@Override
			public int compare(BaseEntity o1, BaseEntity o2) {
				if(o1==o2){
					return 0;
				}
				if(o1==null){
					return 1;
				}
				int round1 = internalTypeOf(o1).compareTo(internalTypeOf(o2));
				
				if(round1!=0){
					return round1;
				}
				if(o1.getId()==null){
					return 1;//should check in pojo, but prevent the bad thing happing
				}
				if(o2.getId()==null){
					return -1;//should check in pojo, but prevent the bad thing happing
				}
				int round2 = o1.getId().compareTo(o2.getId());
				
				return round2;
			}
			
		});
		List<BaseEntity> sortedEntityList = entityListToSort;//just for better reading
		//with a sorted list, the find out the sql and parameters
		Map<String, List<String>> sqlMap = sqlMapOf(sortedEntityList);
		String unionedSQL = unionSQLOf(sqlMap);
		Object [] parameters = parametersOf(sqlMap);
		Map<String,String> resultMap = getResultMap(unionedSQL, parameters);
		fillResult(entityList, resultMap);

		//List<BaseEntity> resultList = this.queryForList(unionedSQL, parameters, getMapper());
		
	}

	protected  void fillResult(List<BaseEntity> entityList,Map<String, String> resultMap) {
		
		for(BaseEntity baseEntity: entityList){
			String displayName = findDisplayNameInMap(baseEntity, resultMap);
			if(displayName==null){
				baseEntity.setDisplayName("<null>");
				continue;
			}
			baseEntity.setDisplayName(displayName);
		}
		
		
	}

	protected String findDisplayNameInMap(BaseEntity baseEntity, Map<String, String> resultMap) {
		String key = this.join(internalTypeOf(baseEntity),":",baseEntity.getId());
		return resultMap.get(key);
	}

	protected String trimString(String valueToTrim) {
		if(valueToTrim==null) {
			return null;
		}
		if(valueToTrim.isEmpty()) {
			return "";
		}
		return valueToTrim.trim();
		
	}
	protected Map<String, String> getResultMap(String unionedSQL,
			Object[] parameters) {
		
		this.logSQLAndParameters("getDisplayName", unionedSQL, parameters,"---");
		
		
		return getJdbcTemplateObject().query(unionedSQL, parameters,new ResultSetExtractor<Map<String,String>>(){

			@Override
			public Map<String,String > extractData(ResultSet resultSet) throws SQLException,
					DataAccessException {
				
				
				Map<String,String> internalMap = new HashMap<String,String>();
				while(resultSet.next()){ 
					String key = trimString(resultSet.getString(1))+":"+trimString(resultSet.getString(2));
					// Fixed the issue for Informix and Gbase 8t/s data base, it appends values for the class column
					String value = resultSet.getString(3);
					
					// System.out.printf("%s = %s\r\n",key, value);
					
					internalMap.put(key, value);
					
				} 
				return internalMap;
			}
			
		});
	}
	


	protected Object[] parametersOf(Map<String, List<String>> sqlMap) {
		// TODO Auto-generated method stub
		List<Object> resultParameters = new ArrayList<Object>();
		for(Map.Entry<String, List<String>> entry: sqlMap.entrySet()){
			List<String> parameters = entry.getValue();
			resultParameters.addAll(parameters);
		}
		return resultParameters.toArray();
	}
	
	private String unionSQLOf(Map<String, List<String>> sqlMap) {
		
		StringBuilder stringBuilder = new StringBuilder();
		int index = 0 ;
		for(Map.Entry<String, List<String>> entry: sqlMap.entrySet()){
			
			if(index>0){
				
				stringBuilder.append("\r\n");
				stringBuilder.append(" union ");
				
			}
			String sqlPrefix = entry.getKey();
			List<String> parameters = entry.getValue();
			String sqlToUnion = this.getNamingQuerySQL(sqlPrefix, parameters);
			stringBuilder.append(sqlToUnion);
			index++;
			
		}
		
		return stringBuilder.toString();
	}

	Map<String, List<String>> sqlMapOf(List<BaseEntity> sortedEntityList){
		String lastClassName = null;
		List<String> idList = null;
		Map<String, List<String>> sqlMap = new HashMap<String, List<String>>();
		for(BaseEntity baseEntity: sortedEntityList){
			
			String currentClassName = this.internalTypeOf(baseEntity);
			
			if(currentClassName.equals(lastClassName)){
				if(idList.contains(baseEntity.getId())){
					continue;
				}
				idList.add(baseEntity.getId());
				continue;
			}
			idList = new ArrayList<String>();
			idList.add(baseEntity.getId());
			String sql = sqlOf(currentClassName);
			
			sqlMap.put(sql, idList);
			
			lastClassName = currentClassName;
			
			
		}
		return sqlMap;
	}
	protected String sqlOf(String currentClassName) {
		String[] sqlInfo=namingTableMap.get(currentClassName);
		if(sqlInfo==null){
			throw new IllegalArgumentException("sqlOf(String currentClassName): Not able to find sql info for class: "+currentClassName);
		}
		if(sqlInfo.length<2){
			throw new IllegalArgumentException("sqlOf(String currentClassName): sqlInfo.length should equals 2 for class: "+currentClassName);
			
		}
		String tableName = sqlInfo[0];
		String displayExpr = sqlInfo[1];
		
		
		String sql = this.join("select '",currentClassName,"' as class_name, id, ",displayExpr," as display_name from ",tableName," where id in ");
		
		return sql;
	}

	protected String internalTypeOf(BaseEntity baseEntity){
		if(baseEntity==null){
			return "null";
		}
		return baseEntity.getInternalType();
	}
	protected Set <BaseEntity>  uniqize(List<BaseEntity> entityList){
		Set <BaseEntity> baseEntitySet = new HashSet<BaseEntity>();
		for(BaseEntity baseEntity: entityList){
			if(baseEntity == null){
				continue;
			}
			if(baseEntity.getId() == null){
				continue;
			}
			baseEntitySet.add(baseEntity);
		}
		return baseEntitySet;
		
	}
	
	protected String getNamingQuerySQL(String sqlPrefix, List<String> entityList){
		
		String SQL = this.join(sqlPrefix, "(",repeatExpr("?",",",entityList.size()),")");// "select * from "+this.getTableName()+" where id in ;
		
		return SQL;
	}
	
	/*
	static {
		namingTableMap = new HashMap<String, String[]>();


		namingTableMap.put("CarInspectionPlatform", new String[]{"car_inspection_platform_data","name"});
		namingTableMap.put("IdentityCard", new String[]{"identity_card_data","holder_name"});
	
		
		
	}*/
	
    public SmartList<BaseEntity> requestCandidateValuesForSearch(String ownerMemberName, String ownerId, String resultMemberName, String resutlClassName, String targetClassName, String filterKey, int pageNo){
    	this.checkFieldName(resultMemberName);
    	this.checkFieldName(resutlClassName);
    	this.checkFieldName(ownerMemberName);
    	this.checkFieldName(targetClassName);
    	
    	List<Object> params = new ArrayList<>();
    	params.add(ownerId);
    	
    	String filterClause = " ";
    	String joinClause = " ";
    	if (filterKey != null && !filterKey.trim().isEmpty() ) {
    		String[] sqlInfo=namingTableMap.get(targetClassName);
    		if(sqlInfo==null){
    			throw new IllegalArgumentException("sqlOf(String currentClassName): Not able to find sql info for filter class: "+targetClassName);
    		}
    		if(sqlInfo.length<2){
    			throw new IllegalArgumentException("sqlOf(String currentClassName): sqlInfo.length should equals 2 for filter class: "+targetClassName);
    			
    		}
    		String displayExpr = sqlInfo[1];
    		joinClause = String.format(" left join %s_data T2 on T1.%s=T2.id ", mapToInternalColumn(targetClassName), mapToInternalColumn(resultMemberName));
    		filterClause = String.format(" and T2.%s like ? ", displayExpr);
    		params.add("%"+filterKey.trim()+"%");
    	}
    	String sql = String.format("select distinct T1.%s from %s_data T1%swhere T1.%s = ?%sorder by cast(%s as CHAR CHARACTER SET GBK) asc", 
    			mapToInternalColumn(resultMemberName), mapToInternalColumn(resutlClassName), 
    			joinClause,
    			mapToInternalColumn(ownerMemberName), 
    			filterClause,
    			mapToInternalColumn(resultMemberName));
    	// System.out.println(sql +" executed with " + params);
    	List<String> keyList = getJdbcTemplateObject().queryForList(sql, params.toArray(), String.class);
    	SmartList<BaseEntity> resultList = new SmartList<>();
    	if (keyList == null) {
    		return resultList;
    	}
    	keyList.forEach(key->{
    		resultList.add(BaseEntity.pretendToBe(targetClassName, key));
    	});
    	this.alias(resultList);
    	return resultList;
    }
    
    protected String mapToInternalColumn(String field){
		char [] fieldArray = field.toCharArray();
		StringBuilder internalFieldBuffer = new StringBuilder();
		int i = 0;
		for(char ch:fieldArray){
			i++;
			if(Character.isUpperCase(ch) ){
				if (i > 1) {
					internalFieldBuffer.append('_');
				}
				char lowerCaseChar = Character.toLowerCase(ch);
				internalFieldBuffer.append(lowerCaseChar);
				continue;
			}
			internalFieldBuffer.append(ch);
		}
		return internalFieldBuffer.toString();
	}
	
	public static String getDisplayNameColumnName(String modelName) {
    	String[] sqlInfo=namingTableMap.get(modelName);
    	if (sqlInfo == null || sqlInfo.length < 2) {
    		return null;
    	}
    	return sqlInfo[1];
    }
}
























