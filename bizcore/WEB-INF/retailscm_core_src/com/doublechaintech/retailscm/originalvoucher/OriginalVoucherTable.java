
package com.doublechaintech.retailscm.originalvoucher;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

public class OriginalVoucherTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="original_voucher_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_TITLE = "title";
	static final String COLUMN_MADE_BY = "made_by";
	static final String COLUMN_RECEIVED_BY = "received_by";
	static final String COLUMN_VOUCHER_TYPE = "voucher_type";
	static final String COLUMN_VOUCHER_IMAGE = "voucher_image";
	static final String COLUMN_BELONGS_TO = "belongs_to";
	static final String COLUMN_VERSION = "version";

	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_TITLE,COLUMN_MADE_BY,COLUMN_RECEIVED_BY,COLUMN_VOUCHER_TYPE,COLUMN_VOUCHER_IMAGE,COLUMN_BELONGS_TO,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_TITLE,COLUMN_MADE_BY,COLUMN_RECEIVED_BY,COLUMN_VOUCHER_TYPE,COLUMN_VOUCHER_IMAGE,COLUMN_BELONGS_TO};

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "original_voucher_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"title","varchar(28)","","头衔","",""},
                new String[]{"made_by","varchar(12)","","由","",""},
                new String[]{"received_by","varchar(12)","","受","",""},
                new String[]{"voucher_type","varchar(16)","","凭证类型","",""},
                new String[]{"voucher_image","varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci","","凭证图像","",""},
                new String[]{"belongs_to","varchar(48)","","属于","accounting_document_data","id"},
                new String[]{"version","int","","版本","",""}
            }, "原始凭证", new String[]{
                "create unique index idx4id_ver_of_original_voucher on original_voucher_data (id, version);"
         }, new String[]{
                "alter table original_voucher_data add constraint pk4id_of_original_voucher_data primary key (id);",
                "alter table original_voucher_data add constraint fk4belongs_to_of_original_voucher_data foreign key (belongs_to) references accounting_document_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


