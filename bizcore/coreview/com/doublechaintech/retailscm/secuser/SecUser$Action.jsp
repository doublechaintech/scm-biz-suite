
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty secUser}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A SecUser" style="color: green">${userContext.localeMap['sec_user']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['sec_user.id']}</span> ${secUser.id}</li>
<li><span>${userContext.localeMap['sec_user.login']}</span> ${secUser.login}</li>
<li><span>${userContext.localeMap['sec_user.mobile']}</span> ${secUser.maskedMobile}</li>
<li><span>${userContext.localeMap['sec_user.email']}</span> ${secUser.email}</li>
<li><span>${userContext.localeMap['sec_user.pwd']}</span> ${secUser.maskedPwd}</li>
<li><span>${userContext.localeMap['sec_user.weixin_openid']}</span> ${secUser.weixinOpenid}</li>
<li><span>${userContext.localeMap['sec_user.weixin_appid']}</span> ${secUser.weixinAppid}</li>
<li><span>${userContext.localeMap['sec_user.access_token']}</span> ${secUser.accessToken}</li>
<li><span>${userContext.localeMap['sec_user.verification_code']}</span> ${secUser.verificationCode}</li>
<li><span>${userContext.localeMap['sec_user.verification_code_expire']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${secUser.verificationCodeExpire}" /></li>
<li><span>${userContext.localeMap['sec_user.last_login_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${secUser.lastLoginTime}" /></li>
<li><span>${userContext.localeMap['sec_user.current_status']}</span> ${secUser.currentStatus}</li>

	
	</ul>
</div>



</c:if>


