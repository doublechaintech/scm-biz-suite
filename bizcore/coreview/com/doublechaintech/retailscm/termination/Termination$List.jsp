<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty terminationList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['termination']}! 
		 <a href="./${ownerBeanName}Manager/addTermination/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty terminationList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("terminationList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['termination']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addTermination/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'terminationList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${terminationListName};${terminationListName}CurrentPage=${page.pageNumber};${terminationListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='terminationListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['termination.id']}</th>
</c:if>
<c:if test="${param.referName ne 'reason'}">
	<th>${userContext.localeMap['termination.reason']}</th>
</c:if>
<c:if test="${param.referName ne 'type'}">
	<th>${userContext.localeMap['termination.type']}</th>
</c:if>
<c:if test="${param.referName ne 'comment'}">
	<th>${userContext.localeMap['termination.comment']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${terminationList}">
				<tr currentVersion='${item.version}' id="termination-${item.id}" ><td><a class="link-action-removed" href="./terminationManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'reason'}">
	<td class="select_candidate_td"
			data-candidate-method="./terminationManager/requestCandidateReason/${ownerBeanName}/${item.id}/"
			data-switch-method="./terminationManager/transferToAnotherReason/${item.id}/"
			data-link-template="./terminationReasonManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.reason}">
			<a href='./terminationReasonManager/view/${item.reason.id}/'>${item.reason.displayName}</a>
			</c:if>
			<c:if test="${empty  item.reason}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'type'}">
	<td class="select_candidate_td"
			data-candidate-method="./terminationManager/requestCandidateType/${ownerBeanName}/${item.id}/"
			data-switch-method="./terminationManager/transferToAnotherType/${item.id}/"
			data-link-template="./terminationTypeManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.type}">
			<a href='./terminationTypeManager/view/${item.type.id}/'>${item.type.displayName}</a>
			</c:if>
			<c:if test="${empty  item.type}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'comment'}">	<td contenteditable='true' class='edit-value'  propertyToChange='comment' storedCellValue='${item.comment}' prefix='${ownerBeanName}Manager/updateTermination/${result.id}/${item.id}/'>${item.comment}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeTermination/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyTerminationFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


