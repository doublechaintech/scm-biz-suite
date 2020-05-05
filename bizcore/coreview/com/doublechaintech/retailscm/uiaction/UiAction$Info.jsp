
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty uiAction}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A UiAction">${userContext.localeMap['ui_action']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./uiActionManager/view/${uiAction.id}/"> ${uiAction.id}</a></li>
<li><span>${userContext.localeMap['ui_action.code']}</span> ${uiAction.code}</li>
<li><span>${userContext.localeMap['ui_action.icon']}</span> ${uiAction.icon}</li>
<li><span>${userContext.localeMap['ui_action.title']}</span> ${uiAction.title}</li>
<li><span>${userContext.localeMap['ui_action.display_order']}</span> ${uiAction.displayOrder}</li>
<li><span>${userContext.localeMap['ui_action.brief']}</span> ${uiAction.brief}</li>
<li><span>${userContext.localeMap['ui_action.image_url']}</span> ${uiAction.imageUrl}</li>
<li><span>${userContext.localeMap['ui_action.link_to_url']}</span> ${uiAction.linkToUrl}</li>
<li><span>${userContext.localeMap['ui_action.extra_data']}</span> ${uiAction.extraData}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




