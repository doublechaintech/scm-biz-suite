<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty provinceCenterEmployeeList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['province_center_employee']}! 
		 <a href="./${ownerBeanName}Manager/addProvinceCenterEmployee/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty provinceCenterEmployeeList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("provinceCenterEmployeeList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['province_center_employee']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addProvinceCenterEmployee/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'provinceCenterEmployeeList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${provinceCenterEmployeeListName};${provinceCenterEmployeeListName}CurrentPage=${page.pageNumber};${provinceCenterEmployeeListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='provinceCenterEmployeeListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['province_center_employee.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['province_center_employee.name']}</th>
</c:if>
<c:if test="${param.referName ne 'mobile'}">
	<th>${userContext.localeMap['province_center_employee.mobile']}</th>
</c:if>
<c:if test="${param.referName ne 'email'}">
	<th>${userContext.localeMap['province_center_employee.email']}</th>
</c:if>
<c:if test="${param.referName ne 'founded'}">
	<th>${userContext.localeMap['province_center_employee.founded']}</th>
</c:if>
<c:if test="${param.referName ne 'department'}">
	<th>${userContext.localeMap['province_center_employee.department']}</th>
</c:if>
<c:if test="${param.referName ne 'provinceCenter'}">
	<th>${userContext.localeMap['province_center_employee.province_center']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${provinceCenterEmployeeList}">
				<tr currentVersion='${item.version}' id="provinceCenterEmployee-${item.id}" ><td><a class="link-action-removed" href="./provinceCenterEmployeeManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateProvinceCenterEmployee/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'mobile'}">	<td contenteditable='true' class='edit-value'  propertyToChange='mobile' storedCellValue='${item.maskedMobile}' prefix='${ownerBeanName}Manager/updateProvinceCenterEmployee/${result.id}/${item.id}/'>${item.maskedMobile}</td>
</c:if><c:if test="${param.referName ne 'email'}">	<td contenteditable='true' class='edit-value'  propertyToChange='email' storedCellValue='${item.email}' prefix='${ownerBeanName}Manager/updateProvinceCenterEmployee/${result.id}/${item.id}/'>${item.email}</td>
</c:if><c:if test="${param.referName ne 'founded'}">	<td contenteditable='true' class='edit-value'  propertyToChange='founded' storedCellValue='${item.founded}' prefix='${ownerBeanName}Manager/updateProvinceCenterEmployee/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.founded}" /></td>
</c:if><c:if test="${param.referName ne 'department'}">
	<td class="select_candidate_td"
			data-candidate-method="./provinceCenterEmployeeManager/requestCandidateDepartment/${ownerBeanName}/${item.id}/"
			data-switch-method="./provinceCenterEmployeeManager/transferToAnotherDepartment/${item.id}/"
			data-link-template="./provinceCenterDepartmentManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.department}">
			<a href='./provinceCenterDepartmentManager/view/${item.department.id}/'>${item.department.displayName}</a>
			</c:if>
			<c:if test="${empty  item.department}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'provinceCenter'}">
	<td class="select_candidate_td"
			data-candidate-method="./provinceCenterEmployeeManager/requestCandidateProvinceCenter/${ownerBeanName}/${item.id}/"
			data-switch-method="./provinceCenterEmployeeManager/transferToAnotherProvinceCenter/${item.id}/"
			data-link-template="./retailStoreProvinceCenterManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.provinceCenter}">
			<a href='./retailStoreProvinceCenterManager/view/${item.provinceCenter.id}/'>${item.provinceCenter.displayName}</a>
			</c:if>
			<c:if test="${empty  item.provinceCenter}">
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

				<a href='#${ownerBeanName}Manager/removeProvinceCenterEmployee/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyProvinceCenterEmployeeFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


