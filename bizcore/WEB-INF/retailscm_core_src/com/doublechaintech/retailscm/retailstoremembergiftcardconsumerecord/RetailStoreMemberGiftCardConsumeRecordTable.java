
package com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class RetailStoreMemberGiftCardConsumeRecordTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="retail_store_member_gift_card_consume_record_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_OCCURE_TIME = "occure_time";
	static final String COLUMN_OWNER = "owner";
	static final String COLUMN_BIZ_ORDER = "biz_order";
	static final String COLUMN_NUMBER = "number";
	static final String COLUMN_AMOUNT = "amount";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_OCCURE_TIME,COLUMN_OWNER,COLUMN_BIZ_ORDER,COLUMN_NUMBER,COLUMN_AMOUNT,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_OCCURE_TIME,COLUMN_OWNER,COLUMN_BIZ_ORDER,COLUMN_NUMBER,COLUMN_AMOUNT};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "retail_store_member_gift_card_consume_record_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"occure_time","date","","发生时间","",""},
                new String[]{"owner","varchar(48)","","业主","retail_store_member_gift_card_data","id"},
                new String[]{"biz_order","varchar(48)","","订单","consumer_order_data","id"},
                new String[]{"number","varchar(28)","","数","",""},
                new String[]{"amount","numeric(6,2)","","金额","",""},
                new String[]{"version","int","","版本","",""}
            }, "零售门店会员卡消费记录", new String[]{
                "create unique index idx4id_ver_of_retail_store_member_gift_card_consume_record on retail_store_member_gift_card_consume_record_data (id, version);",
                "create  index idx16345293022745 on retail_store_member_gift_card_consume_record_data (occure_time);",
                "create  index idx4amount_of_retail_store_member_gift_card_consume_record on retail_store_member_gift_card_consume_record_data (amount);"
         }, new String[]{
                "alter table retail_store_member_gift_card_consume_record_data add constraint pk4id_of_retail_store_member_gift_card_consume_record_data primary key (id);",
                "alter table retail_store_member_gift_card_consume_record_data add constraint fk4owner_of_retail_store_member_gift_card_consume_record_data foreign key (owner) references retail_store_member_gift_card_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table retail_store_member_gift_card_consume_record_data add constraint fk4biz_order_of_000006 foreign key (biz_order) references consumer_order_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


