
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty wechatMiniappIdentify}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A WechatMiniappIdentify">${userContext.localeMap['wechat_miniapp_identify']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./wechatMiniappIdentifyManager/view/${wechatMiniappIdentify.id}/"> ${wechatMiniappIdentify.id}</a></li>
<li><span>${userContext.localeMap['wechat_miniapp_identify.open_id']}</span> ${wechatMiniappIdentify.openId}</li>
<li><span>${userContext.localeMap['wechat_miniapp_identify.app_id']}</span> ${wechatMiniappIdentify.appId}</li>
<li><span>${userContext.localeMap['wechat_miniapp_identify.create_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${wechatMiniappIdentify.createTime}" /></li>
<li><span>${userContext.localeMap['wechat_miniapp_identify.last_login_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${wechatMiniappIdentify.lastLoginTime}" /></li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




