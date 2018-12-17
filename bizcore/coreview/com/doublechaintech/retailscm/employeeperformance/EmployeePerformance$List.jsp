<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty employeePerformanceList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['employee_performance']}! 
		 <a href="./${ownerBeanName}Manager/addEmployeePerformance/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty employeePerformanceList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("employeePerformanceList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['employee_performance']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addEmployeePerformance/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'employeePerformanceList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${employeePerformanceListName};${employeePerformanceListName}CurrentPage=${page.pageNumber};${employeePerformanceListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='employeePerformanceListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['employee_performance.id']}</th>
</c:if>
<c:if test="${param.referName ne 'employee'}">
	<th>${userContext.localeMap['employee_performance.employee']}</th>
</c:if>
<c:if test="${param.referName ne 'performanceComment'}">
	<th>${userContext.localeMap['employee_performance.performance_comment']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${employeePerformanceList}">
				<tr currentVersion='${item.version}' id="employeePerformance-${item.id}" ><td><a class="link-action-removed" href="./employeePerformanceManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'employee'}">
	<td class="select_candidate_td"
			data-candidate-method="./employeePerformanceManager/requestCandidateEmployee/${ownerBeanName}/${item.id}/"
			data-switch-method="./employeePerformanceManager/transferToAnotherEmployee/${item.id}/"
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
<c:if test="${param.referName ne 'performanceComment'}">	<td contenteditable='true' class='edit-value'  propertyToChange='performanceComment' storedCellValue='${item.performanceComment}' prefix='${ownerBeanName}Manager/updateEmployeePerformance/${result.id}/${item.id}/'>${item.performanceComment}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeEmployeePerformance/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyEmployeePerformanceFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


