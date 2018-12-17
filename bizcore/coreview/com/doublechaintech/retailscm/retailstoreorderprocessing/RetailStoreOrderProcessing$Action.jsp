
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty retailStoreOrderProcessing}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A RetailStoreOrderProcessing" style="color: green">${userContext.localeMap['retail_store_order_processing']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['retail_store_order_processing.id']}</span> ${retailStoreOrderProcessing.id}</li>
<li><span>${userContext.localeMap['retail_store_order_processing.who']}</span> ${retailStoreOrderProcessing.who}</li>
<li><span>${userContext.localeMap['retail_store_order_processing.process_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${retailStoreOrderProcessing.processTime}" /></li>

	
	</ul>
</div>



</c:if>


