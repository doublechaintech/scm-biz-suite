<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty accountingDocumentLineList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['accounting_document_line']}! 
		 <a href="./${ownerBeanName}Manager/addAccountingDocumentLine/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty accountingDocumentLineList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("accountingDocumentLineList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['accounting_document_line']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addAccountingDocumentLine/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'accountingDocumentLineList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${accountingDocumentLineListName};${accountingDocumentLineListName}CurrentPage=${page.pageNumber};${accountingDocumentLineListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='accountingDocumentLineListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['accounting_document_line.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['accounting_document_line.name']}</th>
</c:if>
<c:if test="${param.referName ne 'code'}">
	<th>${userContext.localeMap['accounting_document_line.code']}</th>
</c:if>
<c:if test="${param.referName ne 'direct'}">
	<th>${userContext.localeMap['accounting_document_line.direct']}</th>
</c:if>
<c:if test="${param.referName ne 'amount'}">
	<th>${userContext.localeMap['accounting_document_line.amount']}</th>
</c:if>
<c:if test="${param.referName ne 'belongsTo'}">
	<th>${userContext.localeMap['accounting_document_line.belongs_to']}</th>
</c:if>
<c:if test="${param.referName ne 'accountingSubject'}">
	<th>${userContext.localeMap['accounting_document_line.accounting_subject']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${accountingDocumentLineList}">
				<tr currentVersion='${item.version}' id="accountingDocumentLine-${item.id}" ><td><a class="link-action-removed" href="./accountingDocumentLineManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateAccountingDocumentLine/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'code'}">	<td contenteditable='true' class='edit-value'  propertyToChange='code' storedCellValue='${item.code}' prefix='${ownerBeanName}Manager/updateAccountingDocumentLine/${result.id}/${item.id}/'>${item.code}</td>
</c:if><c:if test="${param.referName ne 'direct'}">	<td contenteditable='true' class='edit-value'  propertyToChange='direct' storedCellValue='${item.direct}' prefix='${ownerBeanName}Manager/updateAccountingDocumentLine/${result.id}/${item.id}/'>${item.direct}</td>
</c:if><c:if test="${param.referName ne 'amount'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='amount' storedCellValue='${item.amount}' prefix='${ownerBeanName}Manager/updateAccountingDocumentLine/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.amount}" /></td>
</c:if><c:if test="${param.referName ne 'belongsTo'}">
	<td class="select_candidate_td"
			data-candidate-method="./accountingDocumentLineManager/requestCandidateBelongsTo/${ownerBeanName}/${item.id}/"
			data-switch-method="./accountingDocumentLineManager/transferToAnotherBelongsTo/${item.id}/"
			data-link-template="./accountingDocumentManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.belongsTo}">
			<a href='./accountingDocumentManager/view/${item.belongsTo.id}/'>${item.belongsTo.displayName}</a>
			</c:if>
			<c:if test="${empty  item.belongsTo}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'accountingSubject'}">
	<td class="select_candidate_td"
			data-candidate-method="./accountingDocumentLineManager/requestCandidateAccountingSubject/${ownerBeanName}/${item.id}/"
			data-switch-method="./accountingDocumentLineManager/transferToAnotherAccountingSubject/${item.id}/"
			data-link-template="./accountingSubjectManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.accountingSubject}">
			<a href='./accountingSubjectManager/view/${item.accountingSubject.id}/'>${item.accountingSubject.displayName}</a>
			</c:if>
			<c:if test="${empty  item.accountingSubject}">
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

				<a href='#${ownerBeanName}Manager/removeAccountingDocumentLine/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyAccountingDocumentLineFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


