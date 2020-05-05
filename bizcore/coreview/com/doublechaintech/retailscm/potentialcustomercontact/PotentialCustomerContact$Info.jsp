
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty potentialCustomerContact}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A PotentialCustomerContact">${userContext.localeMap['potential_customer_contact']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./potentialCustomerContactManager/view/${potentialCustomerContact.id}/"> ${potentialCustomerContact.id}</a></li>
<li><span>${userContext.localeMap['potential_customer_contact.name']}</span> ${potentialCustomerContact.name}</li>
<li><span>${userContext.localeMap['potential_customer_contact.contact_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${potentialCustomerContact.contactDate}" /></li>
<li><span>${userContext.localeMap['potential_customer_contact.contact_method']}</span> ${potentialCustomerContact.contactMethod}</li>
<li><span>${userContext.localeMap['potential_customer_contact.description']}</span> ${potentialCustomerContact.description}</li>
<li><span>${userContext.localeMap['potential_customer_contact.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${potentialCustomerContact.lastUpdateTime}" /></li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




