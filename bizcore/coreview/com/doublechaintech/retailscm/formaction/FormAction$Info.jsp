
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty formAction}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A FormAction">${userContext.localeMap['form_action']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./formActionManager/view/${formAction.id}/"> ${formAction.id}</a></li>
<li><span>${userContext.localeMap['form_action.label']}</span> ${formAction.label}</li>
<li><span>${userContext.localeMap['form_action.locale_key']}</span> ${formAction.localeKey}</li>
<li><span>${userContext.localeMap['form_action.action_key']}</span> ${formAction.actionKey}</li>
<li><span>${userContext.localeMap['form_action.level']}</span> ${formAction.level}</li>
<li><span>${userContext.localeMap['form_action.url']}</span> ${formAction.url}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>











