package com.doublechaintech.retailscm.iamservice;

import java.util.List;
import java.util.stream.Collectors;

import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.terapico.utils.*;

public class LoginIdAndPasswordHandler extends BaseIdentificationHandler {
	
	@Override
	public LoginResult authenticate(RetailscmUserContext userContext, LoginContext loginContext) {
		LoginResult result = new LoginResult();
		result.setLoginContext(loginContext);
		// 校验输入
		String loginId = loginContext.getLoginData().getLoginId();
		if (TextUtil.isBlank(loginId)) {
			return result.withError("请输入登录ID/账号/邮箱/手机号");
			
		}
		String password = loginContext.getLoginData().getPassword();
		if (TextUtil.isBlank(password)) {
			return result.withError("请输入密码");
		}
		
		// 获取sec user
		String sql = "select * from sec_user_data where id=? or login=? or mobile=? or email=?";
		SmartList<SecUser> sUsers = userContext.getDAOGroup().getSecUserDAO().queryList(sql, new Object[] {loginId,loginId,loginId,loginId});
		if (sUsers == null) {
			result.setAuthenticated(false);
			result.setSuccess(false);
			result.setMessage("用户"+loginId+"未注册");
			return result;
		}
		
		// 看看有没有密码匹配的
		List<SecUser> matchedUsers = sUsers.stream().filter(user->{
			 String hashedPassed = hashStringWithSHA256(password, user.getId());
			 return hashedPassed.equals(user.getPwd());
		}).collect(Collectors.toList());
		
		if (matchedUsers == null || matchedUsers.isEmpty()) {
			result.setAuthenticated(false);
			result.setSuccess(false);
			result.setMessage("密码不正确");
			return result;
		}
		
		if (matchedUsers.size() > 1) {
			result.setAuthenticated(false);	// 虽然码对了,但是我还是不知道你是哪位
			result.setSuccess(false);
			result.setMessage("用户"+loginId+"联了多个用户,无法确定唯一身份,请用其他方式登录或联系管理员处理账号.");
			return result;
		}
		
		result.getLoginContext().getLoginTarget().setSecUser(matchedUsers.get(0));
		result.setAuthenticated(true);
		result.setSuccess(true);
		return result.authenticated("用户"+loginId+"验证成功");
	}

	protected String getCachedVCode(RetailscmUserContext userContext, String cleanMobile) {
		String key =  getVeriyCodeCacheKey(userContext, cleanMobile);
		return userContext.getCachedObject(key, String.class);
	}

	@Override
	public void bindWithSecUser(RetailscmUserContext userContext, LoginContext loginContext) throws Exception {
		// 默认不做绑定
	}
}
















