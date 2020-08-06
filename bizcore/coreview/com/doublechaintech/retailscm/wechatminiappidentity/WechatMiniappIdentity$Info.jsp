
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty wechatMiniappIdentity}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A WechatMiniappIdentity">${userContext.localeMap['wechat_miniapp_identity']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./wechatMiniappIdentityManager/view/${wechatMiniappIdentity.id}/"> ${wechatMiniappIdentity.id}</a></li>
<li><span>${userContext.localeMap['wechat_miniapp_identity.open_id']}</span> ${wechatMiniappIdentity.openId}</li>
<li><span>${userContext.localeMap['wechat_miniapp_identity.app_id']}</span> ${wechatMiniappIdentity.appId}</li>
<li><span>${userContext.localeMap['wechat_miniapp_identity.create_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${wechatMiniappIdentity.createTime}" /></li>
<li><span>${userContext.localeMap['wechat_miniapp_identity.last_login_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${wechatMiniappIdentity.lastLoginTime}" /></li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




