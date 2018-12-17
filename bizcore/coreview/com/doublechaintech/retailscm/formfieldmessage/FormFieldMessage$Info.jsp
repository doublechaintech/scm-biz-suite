
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty formFieldMessage}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A FormFieldMessage">${userContext.localeMap['form_field_message']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./formFieldMessageManager/view/${formFieldMessage.id}/"> ${formFieldMessage.id}</a></li>
<li><span>${userContext.localeMap['form_field_message.title']}</span> ${formFieldMessage.title}</li>
<li><span>${userContext.localeMap['form_field_message.parameter_name']}</span> ${formFieldMessage.parameterName}</li>
<li><span>${userContext.localeMap['form_field_message.level']}</span> ${formFieldMessage.level}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




