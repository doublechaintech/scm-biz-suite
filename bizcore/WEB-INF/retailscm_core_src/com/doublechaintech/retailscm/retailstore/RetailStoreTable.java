
package com.doublechaintech.retailscm.retailstore;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class RetailStoreTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="retail_store_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_TELEPHONE = "telephone";
	static final String COLUMN_OWNER = "owner";
	static final String COLUMN_RETAIL_STORE_COUNTRY_CENTER = "retail_store_country_center";
	static final String COLUMN_CITY_SERVICE_CENTER = "city_service_center";
	static final String COLUMN_CREATION = "creation";
	static final String COLUMN_INVESTMENT_INVITATION = "investment_invitation";
	static final String COLUMN_FRANCHISING = "franchising";
	static final String COLUMN_DECORATION = "decoration";
	static final String COLUMN_OPENING = "opening";
	static final String COLUMN_CLOSING = "closing";
	static final String COLUMN_FOUNDED = "founded";
	static final String COLUMN_LATITUDE = "latitude";
	static final String COLUMN_LONGITUDE = "longitude";
	static final String COLUMN_DESCRIPTION = "description";
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_TELEPHONE,COLUMN_OWNER,COLUMN_RETAIL_STORE_COUNTRY_CENTER,COLUMN_CITY_SERVICE_CENTER,COLUMN_CREATION,COLUMN_INVESTMENT_INVITATION,COLUMN_FRANCHISING,COLUMN_DECORATION,COLUMN_OPENING,COLUMN_CLOSING,COLUMN_FOUNDED,COLUMN_LATITUDE,COLUMN_LONGITUDE,COLUMN_DESCRIPTION,COLUMN_LAST_UPDATE_TIME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_TELEPHONE,COLUMN_OWNER,COLUMN_RETAIL_STORE_COUNTRY_CENTER,COLUMN_CITY_SERVICE_CENTER,COLUMN_CREATION,COLUMN_INVESTMENT_INVITATION,COLUMN_FRANCHISING,COLUMN_DECORATION,COLUMN_OPENING,COLUMN_CLOSING,COLUMN_FOUNDED,COLUMN_LATITUDE,COLUMN_LONGITUDE,COLUMN_DESCRIPTION,COLUMN_LAST_UPDATE_TIME};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "retail_store_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"name","varchar(24)","","名称","",""},
                new String[]{"telephone","varchar(48)","","电话","",""},
                new String[]{"owner","varchar(8)","","业主","",""},
                new String[]{"retail_store_country_center","varchar(48)","","双链小超全国运营中心","retail_store_country_center_data","id"},
                new String[]{"city_service_center","varchar(48)","","城市服务中心","retail_store_city_service_center_data","id"},
                new String[]{"creation","varchar(48)","","创建","retail_store_creation_data","id"},
                new String[]{"investment_invitation","varchar(48)","","招商","retail_store_investment_invitation_data","id"},
                new String[]{"franchising","varchar(48)","","加盟","retail_store_franchising_data","id"},
                new String[]{"decoration","varchar(48)","","装修","retail_store_decoration_data","id"},
                new String[]{"opening","varchar(48)","","开业","retail_store_opening_data","id"},
                new String[]{"closing","varchar(48)","","关闭","retail_store_closing_data","id"},
                new String[]{"founded","date","","成立","",""},
                new String[]{"latitude","numeric(9,6)","","纬度","",""},
                new String[]{"longitude","numeric(10,6)","","经度","",""},
                new String[]{"description","varchar(84)","","描述","",""},
                new String[]{"last_update_time","datetime","","更新于","",""},
                new String[]{"version","int","","版本","",""}
            }, "双链小超", new String[]{
                "create unique index idx4id_ver_of_retail_store on retail_store_data (id, version);",
                "create  index idx4founded_of_retail_store on retail_store_data (founded);",
                "create  index idx4latitude_of_retail_store on retail_store_data (latitude);",
                "create  index idx4longitude_of_retail_store on retail_store_data (longitude);",
                "create  index idx4last_update_time_of_retail_store on retail_store_data (last_update_time);"
         }, new String[]{
                "alter table retail_store_data add constraint pk4id_of_retail_store_data primary key (id);",
                "alter table retail_store_data add constraint fk4retail_store_country_center_of_retail_store_data foreign key (retail_store_country_center) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table retail_store_data add constraint fk4city_service_center_of_retail_store_data foreign key (city_service_center) references retail_store_city_service_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table retail_store_data add constraint fk4creation_of_retail_store_data foreign key (creation) references retail_store_creation_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table retail_store_data add constraint fk4investment_invitation_of_retail_store_data foreign key (investment_invitation) references retail_store_investment_invitation_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table retail_store_data add constraint fk4franchising_of_retail_store_data foreign key (franchising) references retail_store_franchising_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table retail_store_data add constraint fk4decoration_of_retail_store_data foreign key (decoration) references retail_store_decoration_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table retail_store_data add constraint fk4opening_of_retail_store_data foreign key (opening) references retail_store_opening_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table retail_store_data add constraint fk4closing_of_retail_store_data foreign key (closing) references retail_store_closing_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


