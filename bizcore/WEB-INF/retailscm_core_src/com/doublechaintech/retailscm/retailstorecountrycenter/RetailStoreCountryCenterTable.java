
package com.doublechaintech.retailscm.retailstorecountrycenter;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class RetailStoreCountryCenterTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="retail_store_country_center_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_SERVICE_NUMBER = "service_number";
	static final String COLUMN_FOUNDED = "founded";
	static final String COLUMN_WEB_SITE = "web_site";
	static final String COLUMN_ADDRESS = "address";
	static final String COLUMN_OPERATED_BY = "operated_by";
	static final String COLUMN_LEGAL_REPRESENTATIVE = "legal_representative";
	static final String COLUMN_DESCRIPTION = "description";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_SERVICE_NUMBER,COLUMN_FOUNDED,COLUMN_WEB_SITE,COLUMN_ADDRESS,COLUMN_OPERATED_BY,COLUMN_LEGAL_REPRESENTATIVE,COLUMN_DESCRIPTION,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_SERVICE_NUMBER,COLUMN_FOUNDED,COLUMN_WEB_SITE,COLUMN_ADDRESS,COLUMN_OPERATED_BY,COLUMN_LEGAL_REPRESENTATIVE,COLUMN_DESCRIPTION};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "retail_store_country_center_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"name","varchar(44)","","名称","",""},
                new String[]{"service_number","varchar(36)","","服务号码","",""},
                new String[]{"founded","date","","成立","",""},
                new String[]{"web_site","varchar(128)","","网站","",""},
                new String[]{"address","varchar(56)","","地址","",""},
                new String[]{"operated_by","varchar(16)","","由","",""},
                new String[]{"legal_representative","varchar(12)","","法定代表人","",""},
                new String[]{"description","varchar(52)","","描述","",""},
                new String[]{"version","int","","版本","",""}
            }, "双链小超全国运营中心", new String[]{
                "create unique index idx4id_ver_of_retail_store_country_center on retail_store_country_center_data (id, version);",
                "create  index idx4founded_of_retail_store_country_center on retail_store_country_center_data (founded);"
         }, new String[]{
                "alter table retail_store_country_center_data add constraint pk4id_of_retail_store_country_center_data primary key (id);",
                ""
         });
  }


}


