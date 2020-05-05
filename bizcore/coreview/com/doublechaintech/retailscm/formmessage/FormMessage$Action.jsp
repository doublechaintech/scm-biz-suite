
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty formMessage}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A FormMessage" style="color: green">${userContext.localeMap['form_message']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['form_message.id']}</span> ${formMessage.id}</li>
<li><span>${userContext.localeMap['form_message.title']}</span> ${formMessage.title}</li>
<li><span>${userContext.localeMap['form_message.level']}</span> ${formMessage.level}</li>

	
	</ul>
</div>



</c:if>


