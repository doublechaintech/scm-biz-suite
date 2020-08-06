
package com.doublechaintech.retailscm.consumerorder;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class ConsumerOrderTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="consumer_order_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_TITLE = "title";
	static final String COLUMN_CONSUMER = "consumer";
	static final String COLUMN_STORE = "store";
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_TITLE,COLUMN_CONSUMER,COLUMN_STORE,COLUMN_LAST_UPDATE_TIME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_TITLE,COLUMN_CONSUMER,COLUMN_STORE,COLUMN_LAST_UPDATE_TIME};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "consumer_order_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"title","varchar(16)","","头衔","",""},
                new String[]{"consumer","varchar(48)","","消费者","retail_store_member_data","id"},
                new String[]{"store","varchar(48)","","商场","retail_store_data","id"},
                new String[]{"last_update_time","datetime","","更新于","",""},
                new String[]{"version","int","","版本","",""}
            }, "消费者订单", new String[]{
                "create unique index idx4id_ver_of_consumer_order on consumer_order_data (id, version);",
                "create  index idx4last_update_time_of_consumer_order on consumer_order_data (last_update_time);"
         }, new String[]{
                "alter table consumer_order_data add constraint pk4id_of_consumer_order_data primary key (id);",
                "alter table consumer_order_data add constraint fk4consumer_of_consumer_order_data foreign key (consumer) references retail_store_member_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table consumer_order_data add constraint fk4store_of_consumer_order_data foreign key (store) references retail_store_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


