<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty instructorList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['instructor']}! 
		 <a href="./${ownerBeanName}Manager/addInstructor/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty instructorList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("instructorList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['instructor']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addInstructor/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'instructorList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${instructorListName};${instructorListName}CurrentPage=${page.pageNumber};${instructorListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='instructorListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['instructor.id']}</th>
</c:if>
<c:if test="${param.referName ne 'title'}">
	<th>${userContext.localeMap['instructor.title']}</th>
</c:if>
<c:if test="${param.referName ne 'familyName'}">
	<th>${userContext.localeMap['instructor.family_name']}</th>
</c:if>
<c:if test="${param.referName ne 'givenName'}">
	<th>${userContext.localeMap['instructor.given_name']}</th>
</c:if>
<c:if test="${param.referName ne 'cellPhone'}">
	<th>${userContext.localeMap['instructor.cell_phone']}</th>
</c:if>
<c:if test="${param.referName ne 'email'}">
	<th>${userContext.localeMap['instructor.email']}</th>
</c:if>
<c:if test="${param.referName ne 'company'}">
	<th>${userContext.localeMap['instructor.company']}</th>
</c:if>
<c:if test="${param.referName ne 'introduction'}">
	<th>${userContext.localeMap['instructor.introduction']}</th>
</c:if>
<c:if test="${param.referName ne 'lastUpdateTime'}">
	<th>${userContext.localeMap['instructor.last_update_time']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${instructorList}">
				<tr currentVersion='${item.version}' id="instructor-${item.id}" ><td><a class="link-action-removed" href="./instructorManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'title'}">	<td contenteditable='true' class='edit-value'  propertyToChange='title' storedCellValue='${item.title}' prefix='${ownerBeanName}Manager/updateInstructor/${result.id}/${item.id}/'>${item.title}</td>
</c:if><c:if test="${param.referName ne 'familyName'}">	<td contenteditable='true' class='edit-value'  propertyToChange='familyName' storedCellValue='${item.familyName}' prefix='${ownerBeanName}Manager/updateInstructor/${result.id}/${item.id}/'>${item.familyName}</td>
</c:if><c:if test="${param.referName ne 'givenName'}">	<td contenteditable='true' class='edit-value'  propertyToChange='givenName' storedCellValue='${item.givenName}' prefix='${ownerBeanName}Manager/updateInstructor/${result.id}/${item.id}/'>${item.givenName}</td>
</c:if><c:if test="${param.referName ne 'cellPhone'}">	<td contenteditable='true' class='edit-value'  propertyToChange='cellPhone' storedCellValue='${item.maskedCellPhone}' prefix='${ownerBeanName}Manager/updateInstructor/${result.id}/${item.id}/'>${item.maskedCellPhone}</td>
</c:if><c:if test="${param.referName ne 'email'}">	<td contenteditable='true' class='edit-value'  propertyToChange='email' storedCellValue='${item.email}' prefix='${ownerBeanName}Manager/updateInstructor/${result.id}/${item.id}/'>${item.email}</td>
</c:if><c:if test="${param.referName ne 'company'}">
	<td class="select_candidate_td"
			data-candidate-method="./instructorManager/requestCandidateCompany/${ownerBeanName}/${item.id}/"
			data-switch-method="./instructorManager/transferToAnotherCompany/${item.id}/"
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
<c:if test="${param.referName ne 'introduction'}">	<td contenteditable='true' class='edit-value'  propertyToChange='introduction' storedCellValue='${item.introduction}' prefix='${ownerBeanName}Manager/updateInstructor/${result.id}/${item.id}/'>${item.introduction}</td>
</c:if><c:if test="${param.referName ne 'lastUpdateTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='lastUpdateTime' storedCellValue='${item.lastUpdateTime}' prefix='${ownerBeanName}Manager/updateInstructor/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.lastUpdateTime}" /></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeInstructor/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyInstructorFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


