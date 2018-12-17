
package com.doublechaintech.retailscm.formaction;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.genericform.GenericFormDAO;


public interface FormActionDAO{

	
	public FormAction load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<FormAction> formActionList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public FormAction present(FormAction formAction,Map<String,Object> options) throws Exception;
	public FormAction clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public FormAction save(FormAction formAction,Map<String,Object> options);
	public SmartList<FormAction> saveFormActionList(SmartList<FormAction> formActionList,Map<String,Object> options);
	public SmartList<FormAction> removeFormActionList(SmartList<FormAction> formActionList,Map<String,Object> options);
	public SmartList<FormAction> findFormActionWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countFormActionWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countFormActionWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String formActionId, int version) throws Exception;
	public FormAction disconnectFromAll(String formActionId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<FormAction> queryList(String sql, Object ... parmeters);
 
 	public SmartList<FormAction> findFormActionByForm(String genericFormId, Map<String,Object> options);
 	public int countFormActionByForm(String genericFormId, Map<String,Object> options);
 	public Map<String, Integer> countFormActionByFormIds(String[] ids, Map<String,Object> options);
 	public SmartList<FormAction> findFormActionByForm(String genericFormId, int start, int count, Map<String,Object> options);
 	public void analyzeFormActionByForm(SmartList<FormAction> resultList, String genericFormId, Map<String,Object> options);

 
 }










