
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty wechatWorkappIdentify}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A WechatWorkappIdentify">${userContext.localeMap['wechat_workapp_identify']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./wechatWorkappIdentifyManager/view/${wechatWorkappIdentify.id}/"> ${wechatWorkappIdentify.id}</a></li>
<li><span>${userContext.localeMap['wechat_workapp_identify.corp_id']}</span> ${wechatWorkappIdentify.corpId}</li>
<li><span>${userContext.localeMap['wechat_workapp_identify.user_id']}</span> ${wechatWorkappIdentify.userId}</li>
<li><span>${userContext.localeMap['wechat_workapp_identify.create_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${wechatWorkappIdentify.createTime}" /></li>
<li><span>${userContext.localeMap['wechat_workapp_identify.last_login_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${wechatWorkappIdentify.lastLoginTime}" /></li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




