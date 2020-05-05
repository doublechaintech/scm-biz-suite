<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty employeeList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['employee']}! 
		 <a href="./${ownerBeanName}Manager/addEmployee/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty employeeList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("employeeList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['employee']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addEmployee/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'employeeList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${employeeListName};${employeeListName}CurrentPage=${page.pageNumber};${employeeListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='employeeListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['employee.id']}</th>
</c:if>
<c:if test="${param.referName ne 'company'}">
	<th>${userContext.localeMap['employee.company']}</th>
</c:if>
<c:if test="${param.referName ne 'title'}">
	<th>${userContext.localeMap['employee.title']}</th>
</c:if>
<c:if test="${param.referName ne 'department'}">
	<th>${userContext.localeMap['employee.department']}</th>
</c:if>
<c:if test="${param.referName ne 'familyName'}">
	<th>${userContext.localeMap['employee.family_name']}</th>
</c:if>
<c:if test="${param.referName ne 'givenName'}">
	<th>${userContext.localeMap['employee.given_name']}</th>
</c:if>
<c:if test="${param.referName ne 'email'}">
	<th>${userContext.localeMap['employee.email']}</th>
</c:if>
<c:if test="${param.referName ne 'city'}">
	<th>${userContext.localeMap['employee.city']}</th>
</c:if>
<c:if test="${param.referName ne 'address'}">
	<th>${userContext.localeMap['employee.address']}</th>
</c:if>
<c:if test="${param.referName ne 'cellPhone'}">
	<th>${userContext.localeMap['employee.cell_phone']}</th>
</c:if>
<c:if test="${param.referName ne 'occupation'}">
	<th>${userContext.localeMap['employee.occupation']}</th>
</c:if>
<c:if test="${param.referName ne 'responsibleFor'}">
	<th>${userContext.localeMap['employee.responsible_for']}</th>
</c:if>
<c:if test="${param.referName ne 'currentSalaryGrade'}">
	<th>${userContext.localeMap['employee.current_salary_grade']}</th>
</c:if>
<c:if test="${param.referName ne 'salaryAccount'}">
	<th>${userContext.localeMap['employee.salary_account']}</th>
</c:if>
<c:if test="${param.referName ne 'lastUpdateTime'}">
	<th>${userContext.localeMap['employee.last_update_time']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${employeeList}">
				<tr currentVersion='${item.version}' id="employee-${item.id}" ><td><a class="link-action-removed" href="./employeeManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'company'}">
	<td class="select_candidate_td"
			data-candidate-method="./employeeManager/requestCandidateCompany/${ownerBeanName}/${item.id}/"
			data-switch-method="./employeeManager/transferToAnotherCompany/${item.id}/"
			data-link-template="./retailStoreCountryCenterManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.company}">
			<a href='./retailStoreCountryCenterManager/view/${item.company.id}/'>${item.company.displayName}</a>
			</c:if>
			<c:if test="${empty  item.company}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'title'}">	<td contenteditable='true' class='edit-value'  propertyToChange='title' storedCellValue='${item.title}' prefix='${ownerBeanName}Manager/updateEmployee/${result.id}/${item.id}/'>${item.title}</td>
</c:if><c:if test="${param.referName ne 'department'}">
	<td class="select_candidate_td"
			data-candidate-method="./employeeManager/requestCandidateDepartment/${ownerBeanName}/${item.id}/"
			data-switch-method="./employeeManager/transferToAnotherDepartment/${item.id}/"
			data-link-template="./levelThreeDepartmentManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.department}">
			<a href='./levelThreeDepartmentManager/view/${item.department.id}/'>${item.department.displayName}</a>
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
<c:if test="${param.referName ne 'familyName'}">	<td contenteditable='true' class='edit-value'  propertyToChange='familyName' storedCellValue='${item.familyName}' prefix='${ownerBeanName}Manager/updateEmployee/${result.id}/${item.id}/'>${item.familyName}</td>
</c:if><c:if test="${param.referName ne 'givenName'}">	<td contenteditable='true' class='edit-value'  propertyToChange='givenName' storedCellValue='${item.givenName}' prefix='${ownerBeanName}Manager/updateEmployee/${result.id}/${item.id}/'>${item.givenName}</td>
</c:if><c:if test="${param.referName ne 'email'}">	<td contenteditable='true' class='edit-value'  propertyToChange='email' storedCellValue='${item.email}' prefix='${ownerBeanName}Manager/updateEmployee/${result.id}/${item.id}/'>${item.email}</td>
</c:if><c:if test="${param.referName ne 'city'}">	<td contenteditable='true' class='edit-value'  propertyToChange='city' storedCellValue='${item.city}' prefix='${ownerBeanName}Manager/updateEmployee/${result.id}/${item.id}/'>${item.city}</td>
</c:if><c:if test="${param.referName ne 'address'}">	<td contenteditable='true' class='edit-value'  propertyToChange='address' storedCellValue='${item.address}' prefix='${ownerBeanName}Manager/updateEmployee/${result.id}/${item.id}/'>${item.address}</td>
</c:if><c:if test="${param.referName ne 'cellPhone'}">	<td contenteditable='true' class='edit-value'  propertyToChange='cellPhone' storedCellValue='${item.maskedCellPhone}' prefix='${ownerBeanName}Manager/updateEmployee/${result.id}/${item.id}/'>${item.maskedCellPhone}</td>
</c:if><c:if test="${param.referName ne 'occupation'}">
	<td class="select_candidate_td"
			data-candidate-method="./employeeManager/requestCandidateOccupation/${ownerBeanName}/${item.id}/"
			data-switch-method="./employeeManager/transferToAnotherOccupation/${item.id}/"
			data-link-template="./occupationTypeManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.occupation}">
			<a href='./occupationTypeManager/view/${item.occupation.id}/'>${item.occupation.displayName}</a>
			</c:if>
			<c:if test="${empty  item.occupation}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'responsibleFor'}">
	<td class="select_candidate_td"
			data-candidate-method="./employeeManager/requestCandidateResponsibleFor/${ownerBeanName}/${item.id}/"
			data-switch-method="./employeeManager/transferToAnotherResponsibleFor/${item.id}/"
			data-link-template="./responsibilityTypeManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.responsibleFor}">
			<a href='./responsibilityTypeManager/view/${item.responsibleFor.id}/'>${item.responsibleFor.displayName}</a>
			</c:if>
			<c:if test="${empty  item.responsibleFor}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'currentSalaryGrade'}">
	<td class="select_candidate_td"
			data-candidate-method="./employeeManager/requestCandidateCurrentSalaryGrade/${ownerBeanName}/${item.id}/"
			data-switch-method="./employeeManager/transferToAnotherCurrentSalaryGrade/${item.id}/"
			data-link-template="./salaryGradeManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.currentSalaryGrade}">
			<a href='./salaryGradeManager/view/${item.currentSalaryGrade.id}/'>${item.currentSalaryGrade.displayName}</a>
			</c:if>
			<c:if test="${empty  item.currentSalaryGrade}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'salaryAccount'}">	<td contenteditable='true' class='edit-value'  propertyToChange='salaryAccount' storedCellValue='${item.salaryAccount}' prefix='${ownerBeanName}Manager/updateEmployee/${result.id}/${item.id}/'>${item.salaryAccount}</td>
</c:if><c:if test="${param.referName ne 'lastUpdateTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='lastUpdateTime' storedCellValue='${item.lastUpdateTime}' prefix='${ownerBeanName}Manager/updateEmployee/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.lastUpdateTime}" /></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeEmployee/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyEmployeeFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


