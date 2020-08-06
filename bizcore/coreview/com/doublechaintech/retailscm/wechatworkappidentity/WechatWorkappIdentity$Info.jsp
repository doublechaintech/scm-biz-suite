
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty wechatWorkappIdentity}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A WechatWorkappIdentity">${userContext.localeMap['wechat_workapp_identity']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./wechatWorkappIdentityManager/view/${wechatWorkappIdentity.id}/"> ${wechatWorkappIdentity.id}</a></li>
<li><span>${userContext.localeMap['wechat_workapp_identity.corp_id']}</span> ${wechatWorkappIdentity.corpId}</li>
<li><span>${userContext.localeMap['wechat_workapp_identity.user_id']}</span> ${wechatWorkappIdentity.userId}</li>
<li><span>${userContext.localeMap['wechat_workapp_identity.create_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${wechatWorkappIdentity.createTime}" /></li>
<li><span>${userContext.localeMap['wechat_workapp_identity.last_login_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${wechatWorkappIdentity.lastLoginTime}" /></li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




