<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty objectAccessList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['object_access']}! 
		 <a href="./${ownerBeanName}Manager/addObjectAccess/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty objectAccessList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("objectAccessList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['object_access']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addObjectAccess/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'objectAccessList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${objectAccessListName};${objectAccessListName}CurrentPage=${page.pageNumber};${objectAccessListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='objectAccessListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['object_access.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['object_access.name']}</th>
</c:if>
<c:if test="${param.referName ne 'objectType'}">
	<th>${userContext.localeMap['object_access.object_type']}</th>
</c:if>
<c:if test="${param.referName ne 'list1'}">
	<th>${userContext.localeMap['object_access.list1']}</th>
</c:if>
<c:if test="${param.referName ne 'list2'}">
	<th>${userContext.localeMap['object_access.list2']}</th>
</c:if>
<c:if test="${param.referName ne 'list3'}">
	<th>${userContext.localeMap['object_access.list3']}</th>
</c:if>
<c:if test="${param.referName ne 'list4'}">
	<th>${userContext.localeMap['object_access.list4']}</th>
</c:if>
<c:if test="${param.referName ne 'list5'}">
	<th>${userContext.localeMap['object_access.list5']}</th>
</c:if>
<c:if test="${param.referName ne 'list6'}">
	<th>${userContext.localeMap['object_access.list6']}</th>
</c:if>
<c:if test="${param.referName ne 'list7'}">
	<th>${userContext.localeMap['object_access.list7']}</th>
</c:if>
<c:if test="${param.referName ne 'list8'}">
	<th>${userContext.localeMap['object_access.list8']}</th>
</c:if>
<c:if test="${param.referName ne 'list9'}">
	<th>${userContext.localeMap['object_access.list9']}</th>
</c:if>
<c:if test="${param.referName ne 'app'}">
	<th>${userContext.localeMap['object_access.app']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${objectAccessList}">
				<tr currentVersion='${item.version}' id="objectAccess-${item.id}" ><td><a class="link-action-removed" href="./objectAccessManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateObjectAccess/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'objectType'}">	<td contenteditable='true' class='edit-value'  propertyToChange='objectType' storedCellValue='${item.objectType}' prefix='${ownerBeanName}Manager/updateObjectAccess/${result.id}/${item.id}/'>${item.objectType}</td>
</c:if><c:if test="${param.referName ne 'list1'}">	<td contenteditable='true' class='edit-value'  propertyToChange='list1' storedCellValue='${item.list1}' prefix='${ownerBeanName}Manager/updateObjectAccess/${result.id}/${item.id}/'>${item.list1}</td>
</c:if><c:if test="${param.referName ne 'list2'}">	<td contenteditable='true' class='edit-value'  propertyToChange='list2' storedCellValue='${item.list2}' prefix='${ownerBeanName}Manager/updateObjectAccess/${result.id}/${item.id}/'>${item.list2}</td>
</c:if><c:if test="${param.referName ne 'list3'}">	<td contenteditable='true' class='edit-value'  propertyToChange='list3' storedCellValue='${item.list3}' prefix='${ownerBeanName}Manager/updateObjectAccess/${result.id}/${item.id}/'>${item.list3}</td>
</c:if><c:if test="${param.referName ne 'list4'}">	<td contenteditable='true' class='edit-value'  propertyToChange='list4' storedCellValue='${item.list4}' prefix='${ownerBeanName}Manager/updateObjectAccess/${result.id}/${item.id}/'>${item.list4}</td>
</c:if><c:if test="${param.referName ne 'list5'}">	<td contenteditable='true' class='edit-value'  propertyToChange='list5' storedCellValue='${item.list5}' prefix='${ownerBeanName}Manager/updateObjectAccess/${result.id}/${item.id}/'>${item.list5}</td>
</c:if><c:if test="${param.referName ne 'list6'}">	<td contenteditable='true' class='edit-value'  propertyToChange='list6' storedCellValue='${item.list6}' prefix='${ownerBeanName}Manager/updateObjectAccess/${result.id}/${item.id}/'>${item.list6}</td>
</c:if><c:if test="${param.referName ne 'list7'}">	<td contenteditable='true' class='edit-value'  propertyToChange='list7' storedCellValue='${item.list7}' prefix='${ownerBeanName}Manager/updateObjectAccess/${result.id}/${item.id}/'>${item.list7}</td>
</c:if><c:if test="${param.referName ne 'list8'}">	<td contenteditable='true' class='edit-value'  propertyToChange='list8' storedCellValue='${item.list8}' prefix='${ownerBeanName}Manager/updateObjectAccess/${result.id}/${item.id}/'>${item.list8}</td>
</c:if><c:if test="${param.referName ne 'list9'}">	<td contenteditable='true' class='edit-value'  propertyToChange='list9' storedCellValue='${item.list9}' prefix='${ownerBeanName}Manager/updateObjectAccess/${result.id}/${item.id}/'>${item.list9}</td>
</c:if><c:if test="${param.referName ne 'app'}">
	<td class="select_candidate_td"
			data-candidate-method="./objectAccessManager/requestCandidateApp/${ownerBeanName}/${item.id}/"
			data-switch-method="./objectAccessManager/transferToAnotherApp/${item.id}/"
			data-link-template="./userAppManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.app}">
			<a href='./userAppManager/view/${item.app.id}/'>${item.app.displayName}</a>
			</c:if>
			<c:if test="${empty  item.app}">
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

				<a href='#${ownerBeanName}Manager/removeObjectAccess/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyObjectAccessFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


