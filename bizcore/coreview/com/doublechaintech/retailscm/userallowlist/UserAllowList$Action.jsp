
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty userAllowList}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A UserAllowList" style="color: green">${userContext.localeMap['user_allow_list']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['user_allow_list.id']}</span> ${userAllowList.id}</li>
<li><span>${userContext.localeMap['user_allow_list.user_identity']}</span> ${userAllowList.userIdentity}</li>
<li><span>${userContext.localeMap['user_allow_list.user_special_functions']}</span> ${userAllowList.userSpecialFunctions}</li>

	
	</ul>
</div>



</c:if>


