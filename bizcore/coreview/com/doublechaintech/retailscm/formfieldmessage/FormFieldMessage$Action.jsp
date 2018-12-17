
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty formFieldMessage}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A FormFieldMessage" style="color: green">${userContext.localeMap['form_field_message']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['form_field_message.id']}</span> ${formFieldMessage.id}</li>
<li><span>${userContext.localeMap['form_field_message.title']}</span> ${formFieldMessage.title}</li>
<li><span>${userContext.localeMap['form_field_message.parameter_name']}</span> ${formFieldMessage.parameterName}</li>
<li><span>${userContext.localeMap['form_field_message.level']}</span> ${formFieldMessage.level}</li>

	
	</ul>
</div>



</c:if>


