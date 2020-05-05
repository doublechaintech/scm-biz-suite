
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty potentialCustomerContactPerson}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A PotentialCustomerContactPerson" style="color: green">${userContext.localeMap['potential_customer_contact_person']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['potential_customer_contact_person.id']}</span> ${potentialCustomerContactPerson.id}</li>
<li><span>${userContext.localeMap['potential_customer_contact_person.name']}</span> ${potentialCustomerContactPerson.name}</li>
<li><span>${userContext.localeMap['potential_customer_contact_person.mobile']}</span> ${potentialCustomerContactPerson.maskedMobile}</li>
<li><span>${userContext.localeMap['potential_customer_contact_person.description']}</span> ${potentialCustomerContactPerson.description}</li>

	
	</ul>
</div>



</c:if>


