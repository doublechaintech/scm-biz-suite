
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty potentialCustomerContact}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A PotentialCustomerContact" style="color: green">${userContext.localeMap['potential_customer_contact']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['potential_customer_contact.id']}</span> ${potentialCustomerContact.id}</li>
<li><span>${userContext.localeMap['potential_customer_contact.name']}</span> ${potentialCustomerContact.name}</li>
<li><span>${userContext.localeMap['potential_customer_contact.contact_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${potentialCustomerContact.contactDate}" /></li>
<li><span>${userContext.localeMap['potential_customer_contact.contact_method']}</span> ${potentialCustomerContact.contactMethod}</li>
<li><span>${userContext.localeMap['potential_customer_contact.description']}</span> ${potentialCustomerContact.description}</li>
<li><span>${userContext.localeMap['potential_customer_contact.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${potentialCustomerContact.lastUpdateTime}" /></li>

	
	</ul>
</div>



</c:if>


