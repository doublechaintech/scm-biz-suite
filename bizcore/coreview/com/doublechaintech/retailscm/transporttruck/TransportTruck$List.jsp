<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty transportTruckList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['transport_truck']}! 
		 <a href="./${ownerBeanName}Manager/addTransportTruck/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty transportTruckList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("transportTruckList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("rowsPerPage",list.getRowsPerPage()); 
 	
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//pageContext.setAttribute("accessible",list.isAccessible()); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['transport_truck']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addTransportTruck/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'transportTruckList' eq action.actionGroup}">
		<a class="btn btn-${action.actionLevel} btn-sm" href="${action.managerBeanName}/${action.actionPath}">${userContext.localeMap[action.localeKey]}</a>
		</c:if>
	</c:forEach>
	</div><!--end of div class="btn-group" -->
	
		 
		 
		 
		 </div>
 </div>
    
    
<div class="table-responsive">


<c:set var="currentPageNumber" value="1"/>	



<nav aria-label="Page navigation example">
  <ul class="pagination">
<c:forEach var="page" items="${pages}"> 
<c:set var="classType" value=""/>
<c:if test='${page.selected}' >
<c:set var="classType" value="active"/>
<c:set var="currentPageNumber" value="${page.pageNumber}"/>
</c:if>


	<li class="page-item ${classType}">
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${transportTruckListName};${transportTruckListName}CurrentPage=${page.pageNumber};${transportTruckListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='transportTruckListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['transport_truck.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['transport_truck.name']}</th>
</c:if>
<c:if test="${param.referName ne 'plateNumber'}">
	<th>${userContext.localeMap['transport_truck.plate_number']}</th>
</c:if>
<c:if test="${param.referName ne 'contactNumber'}">
	<th>${userContext.localeMap['transport_truck.contact_number']}</th>
</c:if>
<c:if test="${param.referName ne 'vehicleLicenseNumber'}">
	<th>${userContext.localeMap['transport_truck.vehicle_license_number']}</th>
</c:if>
<c:if test="${param.referName ne 'engineNumber'}">
	<th>${userContext.localeMap['transport_truck.engine_number']}</th>
</c:if>
<c:if test="${param.referName ne 'makeDate'}">
	<th>${userContext.localeMap['transport_truck.make_date']}</th>
</c:if>
<c:if test="${param.referName ne 'mileage'}">
	<th>${userContext.localeMap['transport_truck.mileage']}</th>
</c:if>
<c:if test="${param.referName ne 'bodyColor'}">
	<th>${userContext.localeMap['transport_truck.body_color']}</th>
</c:if>
<c:if test="${param.referName ne 'owner'}">
	<th>${userContext.localeMap['transport_truck.owner']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${transportTruckList}">
				<tr currentVersion='${item.version}' id="transportTruck-${item.id}" ><td><a class="link-action-removed" href="./transportTruckManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateTransportTruck/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'plateNumber'}">	<td contenteditable='true' class='edit-value'  propertyToChange='plateNumber' storedCellValue='${item.plateNumber}' prefix='${ownerBeanName}Manager/updateTransportTruck/${result.id}/${item.id}/'>${item.plateNumber}</td>
</c:if><c:if test="${param.referName ne 'contactNumber'}">	<td contenteditable='true' class='edit-value'  propertyToChange='contactNumber' storedCellValue='${item.contactNumber}' prefix='${ownerBeanName}Manager/updateTransportTruck/${result.id}/${item.id}/'>${item.contactNumber}</td>
</c:if><c:if test="${param.referName ne 'vehicleLicenseNumber'}">	<td contenteditable='true' class='edit-value'  propertyToChange='vehicleLicenseNumber' storedCellValue='${item.vehicleLicenseNumber}' prefix='${ownerBeanName}Manager/updateTransportTruck/${result.id}/${item.id}/'>${item.vehicleLicenseNumber}</td>
</c:if><c:if test="${param.referName ne 'engineNumber'}">	<td contenteditable='true' class='edit-value'  propertyToChange='engineNumber' storedCellValue='${item.engineNumber}' prefix='${ownerBeanName}Manager/updateTransportTruck/${result.id}/${item.id}/'>${item.engineNumber}</td>
</c:if><c:if test="${param.referName ne 'makeDate'}">	<td contenteditable='true' class='edit-value'  propertyToChange='makeDate' storedCellValue='${item.makeDate}' prefix='${ownerBeanName}Manager/updateTransportTruck/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.makeDate}" /></td>
</c:if><c:if test="${param.referName ne 'mileage'}">	<td contenteditable='true' class='edit-value'  propertyToChange='mileage' storedCellValue='${item.mileage}' prefix='${ownerBeanName}Manager/updateTransportTruck/${result.id}/${item.id}/'>${item.mileage}</td>
</c:if><c:if test="${param.referName ne 'bodyColor'}">	<td contenteditable='true' class='edit-value'  propertyToChange='bodyColor' storedCellValue='${item.bodyColor}' prefix='${ownerBeanName}Manager/updateTransportTruck/${result.id}/${item.id}/'>${item.bodyColor}</td>
</c:if><c:if test="${param.referName ne 'owner'}">
	<td class="select_candidate_td"
			data-candidate-method="./transportTruckManager/requestCandidateOwner/${ownerBeanName}/${item.id}/"
			data-switch-method="./transportTruckManager/transferToAnotherOwner/${item.id}/"
			data-link-template="./transportFleetManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.owner}">
			<a href='./transportFleetManager/view/${item.owner.id}/'>${item.owner.displayName}</a>
			</c:if>
			<c:if test="${empty  item.owner}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>

				<td>

				<a href='#${ownerBeanName}Manager/removeTransportTruck/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyTransportTruckFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


