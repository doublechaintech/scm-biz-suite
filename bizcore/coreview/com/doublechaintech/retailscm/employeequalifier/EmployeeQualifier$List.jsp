<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty employeeQualifierList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['employee_qualifier']}! 
		 <a href="./${ownerBeanName}Manager/addEmployeeQualifier/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty employeeQualifierList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("employeeQualifierList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['employee_qualifier']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addEmployeeQualifier/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'employeeQualifierList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${employeeQualifierListName};${employeeQualifierListName}CurrentPage=${page.pageNumber};${employeeQualifierListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='employeeQualifierListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['employee_qualifier.id']}</th>
</c:if>
<c:if test="${param.referName ne 'employee'}">
	<th>${userContext.localeMap['employee_qualifier.employee']}</th>
</c:if>
<c:if test="${param.referName ne 'qualifiedTime'}">
	<th>${userContext.localeMap['employee_qualifier.qualified_time']}</th>
</c:if>
<c:if test="${param.referName ne 'type'}">
	<th>${userContext.localeMap['employee_qualifier.type']}</th>
</c:if>
<c:if test="${param.referName ne 'level'}">
	<th>${userContext.localeMap['employee_qualifier.level']}</th>
</c:if>
<c:if test="${param.referName ne 'remark'}">
	<th>${userContext.localeMap['employee_qualifier.remark']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${employeeQualifierList}">
				<tr currentVersion='${item.version}' id="employeeQualifier-${item.id}" ><td><a class="link-action-removed" href="./employeeQualifierManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'employee'}">
	<td class="select_candidate_td"
			data-candidate-method="./employeeQualifierManager/requestCandidateEmployee/${ownerBeanName}/${item.id}/"
			data-switch-method="./employeeQualifierManager/transferToAnotherEmployee/${item.id}/"
			data-link-template="./employeeManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.employee}">
			<a href='./employeeManager/view/${item.employee.id}/'>${item.employee.displayName}</a>
			</c:if>
			<c:if test="${empty  item.employee}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'qualifiedTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='qualifiedTime' storedCellValue='${item.qualifiedTime}' prefix='${ownerBeanName}Manager/updateEmployeeQualifier/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.qualifiedTime}" /></td>
</c:if><c:if test="${param.referName ne 'type'}">	<td contenteditable='true' class='edit-value'  propertyToChange='type' storedCellValue='${item.type}' prefix='${ownerBeanName}Manager/updateEmployeeQualifier/${result.id}/${item.id}/'>${item.type}</td>
</c:if><c:if test="${param.referName ne 'level'}">	<td contenteditable='true' class='edit-value'  propertyToChange='level' storedCellValue='${item.level}' prefix='${ownerBeanName}Manager/updateEmployeeQualifier/${result.id}/${item.id}/'>${item.level}</td>
</c:if><c:if test="${param.referName ne 'remark'}">	<td contenteditable='true' class='edit-value'  propertyToChange='remark' storedCellValue='${item.remark}' prefix='${ownerBeanName}Manager/updateEmployeeQualifier/${result.id}/${item.id}/'>${item.remark}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeEmployeeQualifier/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyEmployeeQualifierFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


