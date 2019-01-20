
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty supplierSpace}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A SupplierSpace" style="color: green">${userContext.localeMap['supplier_space']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['supplier_space.id']}</span> ${supplierSpace.id}</li>
<li><span>${userContext.localeMap['supplier_space.location']}</span> ${supplierSpace.location}</li>
<li><span>${userContext.localeMap['supplier_space.contact_number']}</span> ${supplierSpace.contactNumber}</li>
<li><span>${userContext.localeMap['supplier_space.total_area']}</span> ${supplierSpace.totalArea}</li>
<li><span>${userContext.localeMap['supplier_space.latitude']}</span> ${supplierSpace.latitude}</li>
<li><span>${userContext.localeMap['supplier_space.longitude']}</span> ${supplierSpace.longitude}</li>
<li><span>${userContext.localeMap['supplier_space.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${supplierSpace.lastUpdateTime}" /></li>

	
	</ul>
</div>



</c:if>


