<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty accountingDocumentList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['accounting_document']}! 
		 <a href="./${ownerBeanName}Manager/addAccountingDocument/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty accountingDocumentList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("accountingDocumentList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['accounting_document']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addAccountingDocument/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'accountingDocumentList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${accountingDocumentListName};${accountingDocumentListName}CurrentPage=${page.pageNumber};${accountingDocumentListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='accountingDocumentListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['accounting_document.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['accounting_document.name']}</th>
</c:if>
<c:if test="${param.referName ne 'accountingDocumentDate'}">
	<th>${userContext.localeMap['accounting_document.accounting_document_date']}</th>
</c:if>
<c:if test="${param.referName ne 'accountingPeriod'}">
	<th>${userContext.localeMap['accounting_document.accounting_period']}</th>
</c:if>
<c:if test="${param.referName ne 'documentType'}">
	<th>${userContext.localeMap['accounting_document.document_type']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${accountingDocumentList}">
				<tr currentVersion='${item.version}' id="accountingDocument-${item.id}" ><td><a class="link-action-removed" href="./accountingDocumentManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateAccountingDocument/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'accountingDocumentDate'}">	<td contenteditable='true' class='edit-value'  propertyToChange='accountingDocumentDate' storedCellValue='${item.accountingDocumentDate}' prefix='${ownerBeanName}Manager/updateAccountingDocument/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.accountingDocumentDate}" /></td>
</c:if><c:if test="${param.referName ne 'accountingPeriod'}">
	<td class="select_candidate_td"
			data-candidate-method="./accountingDocumentManager/requestCandidateAccountingPeriod/${ownerBeanName}/${item.id}/"
			data-switch-method="./accountingDocumentManager/transferToAnotherAccountingPeriod/${item.id}/"
			data-link-template="./accountingPeriodManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.accountingPeriod}">
			<a href='./accountingPeriodManager/view/${item.accountingPeriod.id}/'>${item.accountingPeriod.displayName}</a>
			</c:if>
			<c:if test="${empty  item.accountingPeriod}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'documentType'}">
	<td class="select_candidate_td"
			data-candidate-method="./accountingDocumentManager/requestCandidateDocumentType/${ownerBeanName}/${item.id}/"
			data-switch-method="./accountingDocumentManager/transferToAnotherDocumentType/${item.id}/"
			data-link-template="./accountingDocumentTypeManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.documentType}">
			<a href='./accountingDocumentTypeManager/view/${item.documentType.id}/'>${item.documentType.displayName}</a>
			</c:if>
			<c:if test="${empty  item.documentType}">
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

				<a href='#${ownerBeanName}Manager/removeAccountingDocument/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyAccountingDocumentFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


