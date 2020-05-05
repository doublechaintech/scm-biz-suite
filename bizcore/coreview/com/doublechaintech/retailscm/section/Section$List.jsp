<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty sectionList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['section']}! 
		 <a href="./${ownerBeanName}Manager/addSection/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty sectionList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("sectionList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['section']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addSection/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'sectionList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${sectionListName};${sectionListName}CurrentPage=${page.pageNumber};${sectionListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='sectionListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['section.id']}</th>
</c:if>
<c:if test="${param.referName ne 'title'}">
	<th>${userContext.localeMap['section.title']}</th>
</c:if>
<c:if test="${param.referName ne 'brief'}">
	<th>${userContext.localeMap['section.brief']}</th>
</c:if>
<c:if test="${param.referName ne 'icon'}">
	<th>${userContext.localeMap['section.icon']}</th>
</c:if>
<c:if test="${param.referName ne 'displayOrder'}">
	<th>${userContext.localeMap['section.display_order']}</th>
</c:if>
<c:if test="${param.referName ne 'viewGroup'}">
	<th>${userContext.localeMap['section.view_group']}</th>
</c:if>
<c:if test="${param.referName ne 'linkToUrl'}">
	<th>${userContext.localeMap['section.link_to_url']}</th>
</c:if>
<c:if test="${param.referName ne 'page'}">
	<th>${userContext.localeMap['section.page']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${sectionList}">
				<tr currentVersion='${item.version}' id="section-${item.id}" ><td><a class="link-action-removed" href="./sectionManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'title'}">	<td contenteditable='true' class='edit-value'  propertyToChange='title' storedCellValue='${item.title}' prefix='${ownerBeanName}Manager/updateSection/${result.id}/${item.id}/'>${item.title}</td>
</c:if><c:if test="${param.referName ne 'brief'}">	<td contenteditable='true' class='edit-value'  propertyToChange='brief' storedCellValue='${item.brief}' prefix='${ownerBeanName}Manager/updateSection/${result.id}/${item.id}/'>${item.brief}</td>
</c:if><c:if test="${param.referName ne 'icon'}">	<td contenteditable='true' class='edit-value'  propertyToChange='icon' storedCellValue='${item.icon}' prefix='${ownerBeanName}Manager/updateSection/${result.id}/${item.id}/'>${item.icon}</td>
</c:if><c:if test="${param.referName ne 'displayOrder'}">	<td contenteditable='true' class='edit-value'  propertyToChange='displayOrder' storedCellValue='${item.displayOrder}' prefix='${ownerBeanName}Manager/updateSection/${result.id}/${item.id}/'>${item.displayOrder}</td>
</c:if><c:if test="${param.referName ne 'viewGroup'}">	<td contenteditable='true' class='edit-value'  propertyToChange='viewGroup' storedCellValue='${item.viewGroup}' prefix='${ownerBeanName}Manager/updateSection/${result.id}/${item.id}/'>${item.viewGroup}</td>
</c:if><c:if test="${param.referName ne 'linkToUrl'}">	<td contenteditable='true' class='edit-value'  propertyToChange='linkToUrl' storedCellValue='${item.linkToUrl}' prefix='${ownerBeanName}Manager/updateSection/${result.id}/${item.id}/'>${item.linkToUrl}</td>
</c:if><c:if test="${param.referName ne 'page'}">
	<td class="select_candidate_td"
			data-candidate-method="./sectionManager/requestCandidatePage/${ownerBeanName}/${item.id}/"
			data-switch-method="./sectionManager/transferToAnotherPage/${item.id}/"
			data-link-template="./pageManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.page}">
			<a href='./pageManager/view/${item.page.id}/'>${item.page.displayName}</a>
			</c:if>
			<c:if test="${empty  item.page}">
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

				<a href='#${ownerBeanName}Manager/removeSection/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copySectionFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


