
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty userWhiteList}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A UserWhiteList" style="color: green">${userContext.localeMap['user_white_list']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['user_white_list.id']}</span> ${userWhiteList.id}</li>
<li><span>${userContext.localeMap['user_white_list.user_identity']}</span> ${userWhiteList.userIdentity}</li>
<li><span>${userContext.localeMap['user_white_list.user_special_functions']}</span> ${userWhiteList.userSpecialFunctions}</li>

	
	</ul>
</div>



</c:if>


