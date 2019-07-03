
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty secUser}">
<div class="col-xs-12 col-md-12 section">
	<b title="A SecUser"> 
		${userContext.localeMap['sec_user']}${userContext.localeMap['@word_space']}${userContext.localeMap['@summary']}
		</b>
		
		
	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'main' eq action.actionGroup}">
		
		
		<a class="btn btn-${action.actionLevel} btn-sm" href="${action.managerBeanName}/${action.actionPath}">${userContext.localeMap[action.localeKey]}</a>
		
		
		</c:if>
	</c:forEach>
	</div><!--end of div class="btn-group" -->
	
	<hr/>
	<div>
	
	
	<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['sec_user.id']}</span>
<span >${result.id}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['sec_user.login']}</span>
<span >${result.login}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['sec_user.mobile']}</span>
<span >${result.maskedMobile}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['sec_user.email']}</span>
<span >${result.email}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['sec_user.pwd']}</span>
<span >${result.maskedPwd}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['sec_user.weixin_openid']}</span>
<span >${result.weixinOpenid}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['sec_user.weixin_appid']}</span>
<span >${result.weixinAppid}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['sec_user.access_token']}</span>
<span >${result.accessToken}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['sec_user.verification_code']}</span>
<span >${result.verificationCode}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['sec_user.verification_code_expire']}</span>
<span ><fmt:formatDate pattern="yyyy-MM-dd" value="${result.verificationCodeExpire}" /></span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['sec_user.last_login_time']}</span>
<span ><fmt:formatDate pattern="yyyy-MM-dd" value="${result.lastLoginTime}" /></span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['sec_user.current_status']}</span>
<span >${result.currentStatus}</span>
</div>

	</div>
	
</div>

</c:if>




