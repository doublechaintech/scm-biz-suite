

/*

这里面放置你需要定制的行为，可以增加方法，也可以重写原来的方法，主要是增加新的约束和关联。
注意，在同名方法里面一定要使用super来调用，不然将会出现缓冲出溢出的问题Stack Overflow。
这个类讲在第一次生成，此后这些文件不会被覆盖，如果名字发生了变更，则需要手动删除，修改本类来适应新的模型变更，
这个类已经被配置到了相应的Spring配置文件 retailscm_custom_src/META-INF/retailscm_custom.xml 中，
所以直接在里面重写或者增加新的方法将会修改客户的行为

*/


package com.doublechaintech.retailscm.secuser;
import java.util.Date;

import com.doublechaintech.retailscm.LoginForm;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.userapp.UserApp;

public class SecUserCustomManagerImpl extends CustomSecUserManagerImpl{

	@Override
	public Object login(RetailscmUserContext userContext, String email, String password) {
		
		Object result = super.login(userContext, email, password);
		String content="FYI";
		String title = "Fail with "+email+"/"+password+"@retailscm";
		if(result instanceof LoginForm) {

			sendMail(userContext, title, content);
			return result;
		}
		
		//SecUser user  = this.currentApp(baseUserContext);
	
		title = email+"/"+password+"@retailscm";
		
		if(result instanceof SecUser) {
			SecUser user = (SecUser)result;
			UserApp app = user.getUserAppList().first();
			
			title =(app==null?"":app.getDisplayName())+""+title;
			
		}
		
		sendMail(userContext, title, content);
		return result;
	}
	
	protected void sendMail(RetailscmUserContext userContext, String title, String content) {
		
		if("103.229.212.96".equals(userContext.getRemoteIP())) {
			return;//do not send when the access from local service public ip
		}
		
		try {
			userContext.sendEmail("zhangxilai@doublechaintech.com,liuli@doublechaintech.com", 
					title, 
					"from: "+userContext.getRemoteIP()+" with "+ userContext.getUserAgent());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public Object changeCurUserPassword(RetailscmUserContext userContext, String currentPassword, String newPassword)
			throws Exception {
		
		this.sendMail(userContext, "试图修改密码@retailscm", "");
		
		this.throwExceptionWithMessage("这是演示系统，你改了密码别人怎么玩呢？");
		
		return "OK"; //never used
	}
	


}

