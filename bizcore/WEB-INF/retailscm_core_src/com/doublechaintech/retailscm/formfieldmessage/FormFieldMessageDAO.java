
package com.doublechaintech.retailscm.formfieldmessage;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.genericform.GenericFormDAO;


public interface FormFieldMessageDAO{

	
	public FormFieldMessage load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<FormFieldMessage> formFieldMessageList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public FormFieldMessage present(FormFieldMessage formFieldMessage,Map<String,Object> options) throws Exception;
	public FormFieldMessage clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public FormFieldMessage save(FormFieldMessage formFieldMessage,Map<String,Object> options);
	public SmartList<FormFieldMessage> saveFormFieldMessageList(SmartList<FormFieldMessage> formFieldMessageList,Map<String,Object> options);
	public SmartList<FormFieldMessage> removeFormFieldMessageList(SmartList<FormFieldMessage> formFieldMessageList,Map<String,Object> options);
	public SmartList<FormFieldMessage> findFormFieldMessageWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countFormFieldMessageWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countFormFieldMessageWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String formFieldMessageId, int version) throws Exception;
	public FormFieldMessage disconnectFromAll(String formFieldMessageId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<FormFieldMessage> queryList(String sql, Object ... parmeters);
 
 	public SmartList<FormFieldMessage> findFormFieldMessageByForm(String genericFormId, Map<String,Object> options);
 	public int countFormFieldMessageByForm(String genericFormId, Map<String,Object> options);
 	public Map<String, Integer> countFormFieldMessageByFormIds(String[] ids, Map<String,Object> options);
 	public SmartList<FormFieldMessage> findFormFieldMessageByForm(String genericFormId, int start, int count, Map<String,Object> options);
 	public void analyzeFormFieldMessageByForm(SmartList<FormFieldMessage> resultList, String genericFormId, Map<String,Object> options);

 
 }


