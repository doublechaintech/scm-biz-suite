
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty formAction}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A FormAction" style="color: green">${userContext.localeMap['form_action']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['form_action.id']}</span> ${formAction.id}</li>
<li><span>${userContext.localeMap['form_action.label']}</span> ${formAction.label}</li>
<li><span>${userContext.localeMap['form_action.locale_key']}</span> ${formAction.localeKey}</li>
<li><span>${userContext.localeMap['form_action.action_key']}</span> ${formAction.actionKey}</li>
<li><span>${userContext.localeMap['form_action.level']}</span> ${formAction.level}</li>
<li><span>${userContext.localeMap['form_action.url']}</span> ${formAction.url}</li>

	
	</ul>
</div>



</c:if>









