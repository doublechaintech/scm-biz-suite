
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty transportTruck}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A TransportTruck">${userContext.localeMap['transport_truck']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./transportTruckManager/view/${transportTruck.id}/"> ${transportTruck.id}</a></li>
<li><span>${userContext.localeMap['transport_truck.name']}</span> ${transportTruck.name}</li>
<li><span>${userContext.localeMap['transport_truck.plate_number']}</span> ${transportTruck.plateNumber}</li>
<li><span>${userContext.localeMap['transport_truck.contact_number']}</span> ${transportTruck.contactNumber}</li>
<li><span>${userContext.localeMap['transport_truck.vehicle_license_number']}</span> ${transportTruck.vehicleLicenseNumber}</li>
<li><span>${userContext.localeMap['transport_truck.engine_number']}</span> ${transportTruck.engineNumber}</li>
<li><span>${userContext.localeMap['transport_truck.make_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${transportTruck.makeDate}" /></li>
<li><span>${userContext.localeMap['transport_truck.mileage']}</span> ${transportTruck.mileage}</li>
<li><span>${userContext.localeMap['transport_truck.body_color']}</span> ${transportTruck.bodyColor}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




