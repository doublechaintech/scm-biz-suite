
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty wechatWorkappIdentify}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A WechatWorkappIdentify" style="color: green">${userContext.localeMap['wechat_workapp_identify']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['wechat_workapp_identify.id']}</span> ${wechatWorkappIdentify.id}</li>
<li><span>${userContext.localeMap['wechat_workapp_identify.corp_id']}</span> ${wechatWorkappIdentify.corpId}</li>
<li><span>${userContext.localeMap['wechat_workapp_identify.user_id']}</span> ${wechatWorkappIdentify.userId}</li>
<li><span>${userContext.localeMap['wechat_workapp_identify.create_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${wechatWorkappIdentify.createTime}" /></li>
<li><span>${userContext.localeMap['wechat_workapp_identify.last_login_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${wechatWorkappIdentify.lastLoginTime}" /></li>

	
	</ul>
</div>



</c:if>


