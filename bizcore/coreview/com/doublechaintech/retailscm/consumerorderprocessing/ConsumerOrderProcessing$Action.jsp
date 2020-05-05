
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty consumerOrderProcessing}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A ConsumerOrderProcessing" style="color: green">${userContext.localeMap['consumer_order_processing']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['consumer_order_processing.id']}</span> ${consumerOrderProcessing.id}</li>
<li><span>${userContext.localeMap['consumer_order_processing.who']}</span> ${consumerOrderProcessing.who}</li>
<li><span>${userContext.localeMap['consumer_order_processing.process_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${consumerOrderProcessing.processTime}" /></li>

	
	</ul>
</div>



</c:if>


