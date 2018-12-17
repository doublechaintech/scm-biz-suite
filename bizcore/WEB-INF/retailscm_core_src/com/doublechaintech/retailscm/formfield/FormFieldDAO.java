
package com.doublechaintech.retailscm.formfield;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.genericform.GenericFormDAO;


public interface FormFieldDAO{

	
	public FormField load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<FormField> formFieldList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public FormField present(FormField formField,Map<String,Object> options) throws Exception;
	public FormField clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public FormField save(FormField formField,Map<String,Object> options);
	public SmartList<FormField> saveFormFieldList(SmartList<FormField> formFieldList,Map<String,Object> options);
	public SmartList<FormField> removeFormFieldList(SmartList<FormField> formFieldList,Map<String,Object> options);
	public SmartList<FormField> findFormFieldWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countFormFieldWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countFormFieldWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String formFieldId, int version) throws Exception;
	public FormField disconnectFromAll(String formFieldId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<FormField> queryList(String sql, Object ... parmeters);
 
 	public SmartList<FormField> findFormFieldByForm(String genericFormId, Map<String,Object> options);
 	public int countFormFieldByForm(String genericFormId, Map<String,Object> options);
 	public Map<String, Integer> countFormFieldByFormIds(String[] ids, Map<String,Object> options);
 	public SmartList<FormField> findFormFieldByForm(String genericFormId, int start, int count, Map<String,Object> options);
 	public void analyzeFormFieldByForm(SmartList<FormField> resultList, String genericFormId, Map<String,Object> options);

 
 }


