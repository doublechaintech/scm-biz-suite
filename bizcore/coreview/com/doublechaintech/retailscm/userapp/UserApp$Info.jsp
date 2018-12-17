
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty userApp}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A UserApp">${userContext.localeMap['user_app']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./userAppManager/view/${userApp.id}/"> ${userApp.id}</a></li>
<li><span>${userContext.localeMap['user_app.title']}</span> ${userApp.title}</li>
<li><span>${userContext.localeMap['user_app.app_icon']}</span> ${userApp.appIcon}</li>
<li><span>${userContext.localeMap['user_app.full_access']}</span> ${userApp.fullAccess}</li>
<li><span>${userContext.localeMap['user_app.permission']}</span> ${userApp.permission}</li>
<li><span>${userContext.localeMap['user_app.object_type']}</span> ${userApp.objectType}</li>
<li><span>${userContext.localeMap['user_app.object_id']}</span> ${userApp.objectId}</li>
<li><span>${userContext.localeMap['user_app.location']}</span> ${userApp.location}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




