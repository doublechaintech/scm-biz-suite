
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty potentialCustomer}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A PotentialCustomer">${userContext.localeMap['potential_customer']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./potentialCustomerManager/view/${potentialCustomer.id}/"> ${potentialCustomer.id}</a></li>
<li><span>${userContext.localeMap['potential_customer.name']}</span> ${potentialCustomer.name}</li>
<li><span>${userContext.localeMap['potential_customer.mobile']}</span> ${potentialCustomer.maskedMobile}</li>
<li><span>${userContext.localeMap['potential_customer.description']}</span> ${potentialCustomer.description}</li>
<li><span>${userContext.localeMap['potential_customer.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${potentialCustomer.lastUpdateTime}" /></li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




