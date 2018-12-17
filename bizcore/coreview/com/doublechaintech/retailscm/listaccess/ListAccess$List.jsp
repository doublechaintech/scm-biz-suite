<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty listAccessList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['list_access']}! 
		 <a href="./${ownerBeanName}Manager/addListAccess/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty listAccessList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("listAccessList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['list_access']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addListAccess/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'listAccessList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${listAccessListName};${listAccessListName}CurrentPage=${page.pageNumber};${listAccessListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='listAccessListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['list_access.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['list_access.name']}</th>
</c:if>
<c:if test="${param.referName ne 'internalName'}">
	<th>${userContext.localeMap['list_access.internal_name']}</th>
</c:if>
<c:if test="${param.referName ne 'readPermission'}">
	<th>${userContext.localeMap['list_access.read_permission']}</th>
</c:if>
<c:if test="${param.referName ne 'createPermission'}">
	<th>${userContext.localeMap['list_access.create_permission']}</th>
</c:if>
<c:if test="${param.referName ne 'deletePermission'}">
	<th>${userContext.localeMap['list_access.delete_permission']}</th>
</c:if>
<c:if test="${param.referName ne 'updatePermission'}">
	<th>${userContext.localeMap['list_access.update_permission']}</th>
</c:if>
<c:if test="${param.referName ne 'executionPermission'}">
	<th>${userContext.localeMap['list_access.execution_permission']}</th>
</c:if>
<c:if test="${param.referName ne 'app'}">
	<th>${userContext.localeMap['list_access.app']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${listAccessList}">
				<tr currentVersion='${item.version}' id="listAccess-${item.id}" ><td><a class="link-action-removed" href="./listAccessManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateListAccess/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'internalName'}">	<td contenteditable='true' class='edit-value'  propertyToChange='internalName' storedCellValue='${item.internalName}' prefix='${ownerBeanName}Manager/updateListAccess/${result.id}/${item.id}/'>${item.internalName}</td>
</c:if><c:if test="${param.referName ne 'readPermission'}">	<td contenteditable='true' class='edit-value'  propertyToChange='readPermission' storedCellValue='${item.readPermission}' prefix='${ownerBeanName}Manager/updateListAccess/${result.id}/${item.id}/'>${item.readPermission}</td>
</c:if><c:if test="${param.referName ne 'createPermission'}">	<td contenteditable='true' class='edit-value'  propertyToChange='createPermission' storedCellValue='${item.createPermission}' prefix='${ownerBeanName}Manager/updateListAccess/${result.id}/${item.id}/'>${item.createPermission}</td>
</c:if><c:if test="${param.referName ne 'deletePermission'}">	<td contenteditable='true' class='edit-value'  propertyToChange='deletePermission' storedCellValue='${item.deletePermission}' prefix='${ownerBeanName}Manager/updateListAccess/${result.id}/${item.id}/'>${item.deletePermission}</td>
</c:if><c:if test="${param.referName ne 'updatePermission'}">	<td contenteditable='true' class='edit-value'  propertyToChange='updatePermission' storedCellValue='${item.updatePermission}' prefix='${ownerBeanName}Manager/updateListAccess/${result.id}/${item.id}/'>${item.updatePermission}</td>
</c:if><c:if test="${param.referName ne 'executionPermission'}">	<td contenteditable='true' class='edit-value'  propertyToChange='executionPermission' storedCellValue='${item.executionPermission}' prefix='${ownerBeanName}Manager/updateListAccess/${result.id}/${item.id}/'>${item.executionPermission}</td>
</c:if><c:if test="${param.referName ne 'app'}">
	<td class="select_candidate_td"
			data-candidate-method="./listAccessManager/requestCandidateApp/${ownerBeanName}/${item.id}/"
			data-switch-method="./listAccessManager/transferToAnotherApp/${item.id}/"
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

				<a href='#${ownerBeanName}Manager/removeListAccess/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyListAccessFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


