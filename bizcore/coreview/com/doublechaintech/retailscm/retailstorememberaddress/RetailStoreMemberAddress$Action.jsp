
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty retailStoreMemberAddress}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A RetailStoreMemberAddress" style="color: green">${userContext.localeMap['retail_store_member_address']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['retail_store_member_address.id']}</span> ${retailStoreMemberAddress.id}</li>
<li><span>${userContext.localeMap['retail_store_member_address.name']}</span> ${retailStoreMemberAddress.name}</li>
<li><span>${userContext.localeMap['retail_store_member_address.mobile_phone']}</span> ${retailStoreMemberAddress.maskedMobilePhone}</li>
<li><span>${userContext.localeMap['retail_store_member_address.address']}</span> ${retailStoreMemberAddress.address}</li>

	
	</ul>
</div>



</c:if>


