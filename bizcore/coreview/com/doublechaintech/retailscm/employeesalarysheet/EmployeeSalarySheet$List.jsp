<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty employeeSalarySheetList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['employee_salary_sheet']}! 
		 <a href="./${ownerBeanName}Manager/addEmployeeSalarySheet/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty employeeSalarySheetList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("employeeSalarySheetList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['employee_salary_sheet']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addEmployeeSalarySheet/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'employeeSalarySheetList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${employeeSalarySheetListName};${employeeSalarySheetListName}CurrentPage=${page.pageNumber};${employeeSalarySheetListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='employeeSalarySheetListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['employee_salary_sheet.id']}</th>
</c:if>
<c:if test="${param.referName ne 'employee'}">
	<th>${userContext.localeMap['employee_salary_sheet.employee']}</th>
</c:if>
<c:if test="${param.referName ne 'currentSalaryGrade'}">
	<th>${userContext.localeMap['employee_salary_sheet.current_salary_grade']}</th>
</c:if>
<c:if test="${param.referName ne 'baseSalary'}">
	<th>${userContext.localeMap['employee_salary_sheet.base_salary']}</th>
</c:if>
<c:if test="${param.referName ne 'bonus'}">
	<th>${userContext.localeMap['employee_salary_sheet.bonus']}</th>
</c:if>
<c:if test="${param.referName ne 'reward'}">
	<th>${userContext.localeMap['employee_salary_sheet.reward']}</th>
</c:if>
<c:if test="${param.referName ne 'personalTax'}">
	<th>${userContext.localeMap['employee_salary_sheet.personal_tax']}</th>
</c:if>
<c:if test="${param.referName ne 'socialSecurity'}">
	<th>${userContext.localeMap['employee_salary_sheet.social_security']}</th>
</c:if>
<c:if test="${param.referName ne 'housingFound'}">
	<th>${userContext.localeMap['employee_salary_sheet.housing_found']}</th>
</c:if>
<c:if test="${param.referName ne 'jobInsurance'}">
	<th>${userContext.localeMap['employee_salary_sheet.job_insurance']}</th>
</c:if>
<c:if test="${param.referName ne 'payingOff'}">
	<th>${userContext.localeMap['employee_salary_sheet.paying_off']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${employeeSalarySheetList}">
				<tr currentVersion='${item.version}' id="employeeSalarySheet-${item.id}" ><td><a class="link-action-removed" href="./employeeSalarySheetManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'employee'}">
	<td class="select_candidate_td"
			data-candidate-method="./employeeSalarySheetManager/requestCandidateEmployee/${ownerBeanName}/${item.id}/"
			data-switch-method="./employeeSalarySheetManager/transferToAnotherEmployee/${item.id}/"
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
<c:if test="${param.referName ne 'currentSalaryGrade'}">
	<td class="select_candidate_td"
			data-candidate-method="./employeeSalarySheetManager/requestCandidateCurrentSalaryGrade/${ownerBeanName}/${item.id}/"
			data-switch-method="./employeeSalarySheetManager/transferToAnotherCurrentSalaryGrade/${item.id}/"
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
<c:if test="${param.referName ne 'baseSalary'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='baseSalary' storedCellValue='${item.baseSalary}' prefix='${ownerBeanName}Manager/updateEmployeeSalarySheet/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.baseSalary}" /></td>
</c:if><c:if test="${param.referName ne 'bonus'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='bonus' storedCellValue='${item.bonus}' prefix='${ownerBeanName}Manager/updateEmployeeSalarySheet/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.bonus}" /></td>
</c:if><c:if test="${param.referName ne 'reward'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='reward' storedCellValue='${item.reward}' prefix='${ownerBeanName}Manager/updateEmployeeSalarySheet/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.reward}" /></td>
</c:if><c:if test="${param.referName ne 'personalTax'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='personalTax' storedCellValue='${item.personalTax}' prefix='${ownerBeanName}Manager/updateEmployeeSalarySheet/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.personalTax}" /></td>
</c:if><c:if test="${param.referName ne 'socialSecurity'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='socialSecurity' storedCellValue='${item.socialSecurity}' prefix='${ownerBeanName}Manager/updateEmployeeSalarySheet/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.socialSecurity}" /></td>
</c:if><c:if test="${param.referName ne 'housingFound'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='housingFound' storedCellValue='${item.housingFound}' prefix='${ownerBeanName}Manager/updateEmployeeSalarySheet/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.housingFound}" /></td>
</c:if><c:if test="${param.referName ne 'jobInsurance'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='jobInsurance' storedCellValue='${item.jobInsurance}' prefix='${ownerBeanName}Manager/updateEmployeeSalarySheet/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.jobInsurance}" /></td>
</c:if><c:if test="${param.referName ne 'payingOff'}">
	<td class="select_candidate_td"
			data-candidate-method="./employeeSalarySheetManager/requestCandidatePayingOff/${ownerBeanName}/${item.id}/"
			data-switch-method="./employeeSalarySheetManager/transferToAnotherPayingOff/${item.id}/"
			data-link-template="./payingOffManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.payingOff}">
			<a href='./payingOffManager/view/${item.payingOff.id}/'>${item.payingOff.displayName}</a>
			</c:if>
			<c:if test="${empty  item.payingOff}">
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

				<a href='#${ownerBeanName}Manager/removeEmployeeSalarySheet/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyEmployeeSalarySheetFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


