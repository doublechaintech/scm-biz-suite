<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty accountSetList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['account_set']}! 
		 <a href="./${ownerBeanName}Manager/addAccountSet/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty accountSetList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("accountSetList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['account_set']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addAccountSet/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'accountSetList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${accountSetListName};${accountSetListName}CurrentPage=${page.pageNumber};${accountSetListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='accountSetListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['account_set.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['account_set.name']}</th>
</c:if>
<c:if test="${param.referName ne 'yearSet'}">
	<th>${userContext.localeMap['account_set.year_set']}</th>
</c:if>
<c:if test="${param.referName ne 'effectiveDate'}">
	<th>${userContext.localeMap['account_set.effective_date']}</th>
</c:if>
<c:if test="${param.referName ne 'accountingSystem'}">
	<th>${userContext.localeMap['account_set.accounting_system']}</th>
</c:if>
<c:if test="${param.referName ne 'domesticCurrencyCode'}">
	<th>${userContext.localeMap['account_set.domestic_currency_code']}</th>
</c:if>
<c:if test="${param.referName ne 'domesticCurrencyName'}">
	<th>${userContext.localeMap['account_set.domestic_currency_name']}</th>
</c:if>
<c:if test="${param.referName ne 'openingBank'}">
	<th>${userContext.localeMap['account_set.opening_bank']}</th>
</c:if>
<c:if test="${param.referName ne 'accountNumber'}">
	<th>${userContext.localeMap['account_set.account_number']}</th>
</c:if>
<c:if test="${param.referName ne 'countryCenter'}">
	<th>${userContext.localeMap['account_set.country_center']}</th>
</c:if>
<c:if test="${param.referName ne 'retailStore'}">
	<th>${userContext.localeMap['account_set.retail_store']}</th>
</c:if>
<c:if test="${param.referName ne 'goodsSupplier'}">
	<th>${userContext.localeMap['account_set.goods_supplier']}</th>
</c:if>
<c:if test="${param.referName ne 'lastUpdateTime'}">
	<th>${userContext.localeMap['account_set.last_update_time']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${accountSetList}">
				<tr currentVersion='${item.version}' id="accountSet-${item.id}" ><td><a class="link-action-removed" href="./accountSetManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateAccountSet/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'yearSet'}">	<td contenteditable='true' class='edit-value'  propertyToChange='yearSet' storedCellValue='${item.yearSet}' prefix='${ownerBeanName}Manager/updateAccountSet/${result.id}/${item.id}/'>${item.yearSet}</td>
</c:if><c:if test="${param.referName ne 'effectiveDate'}">	<td contenteditable='true' class='edit-value'  propertyToChange='effectiveDate' storedCellValue='${item.effectiveDate}' prefix='${ownerBeanName}Manager/updateAccountSet/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.effectiveDate}" /></td>
</c:if><c:if test="${param.referName ne 'accountingSystem'}">	<td contenteditable='true' class='edit-value'  propertyToChange='accountingSystem' storedCellValue='${item.accountingSystem}' prefix='${ownerBeanName}Manager/updateAccountSet/${result.id}/${item.id}/'>${item.accountingSystem}</td>
</c:if><c:if test="${param.referName ne 'domesticCurrencyCode'}">	<td contenteditable='true' class='edit-value'  propertyToChange='domesticCurrencyCode' storedCellValue='${item.domesticCurrencyCode}' prefix='${ownerBeanName}Manager/updateAccountSet/${result.id}/${item.id}/'>${item.domesticCurrencyCode}</td>
</c:if><c:if test="${param.referName ne 'domesticCurrencyName'}">	<td contenteditable='true' class='edit-value'  propertyToChange='domesticCurrencyName' storedCellValue='${item.domesticCurrencyName}' prefix='${ownerBeanName}Manager/updateAccountSet/${result.id}/${item.id}/'>${item.domesticCurrencyName}</td>
</c:if><c:if test="${param.referName ne 'openingBank'}">	<td contenteditable='true' class='edit-value'  propertyToChange='openingBank' storedCellValue='${item.openingBank}' prefix='${ownerBeanName}Manager/updateAccountSet/${result.id}/${item.id}/'>${item.openingBank}</td>
</c:if><c:if test="${param.referName ne 'accountNumber'}">	<td contenteditable='true' class='edit-value'  propertyToChange='accountNumber' storedCellValue='${item.accountNumber}' prefix='${ownerBeanName}Manager/updateAccountSet/${result.id}/${item.id}/'>${item.accountNumber}</td>
</c:if><c:if test="${param.referName ne 'countryCenter'}">
	<td class="select_candidate_td"
			data-candidate-method="./accountSetManager/requestCandidateCountryCenter/${ownerBeanName}/${item.id}/"
			data-switch-method="./accountSetManager/transferToAnotherCountryCenter/${item.id}/"
			data-link-template="./retailStoreCountryCenterManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.countryCenter}">
			<a href='./retailStoreCountryCenterManager/view/${item.countryCenter.id}/'>${item.countryCenter.displayName}</a>
			</c:if>
			<c:if test="${empty  item.countryCenter}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'retailStore'}">
	<td class="select_candidate_td"
			data-candidate-method="./accountSetManager/requestCandidateRetailStore/${ownerBeanName}/${item.id}/"
			data-switch-method="./accountSetManager/transferToAnotherRetailStore/${item.id}/"
			data-link-template="./retailStoreManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.retailStore}">
			<a href='./retailStoreManager/view/${item.retailStore.id}/'>${item.retailStore.displayName}</a>
			</c:if>
			<c:if test="${empty  item.retailStore}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'goodsSupplier'}">
	<td class="select_candidate_td"
			data-candidate-method="./accountSetManager/requestCandidateGoodsSupplier/${ownerBeanName}/${item.id}/"
			data-switch-method="./accountSetManager/transferToAnotherGoodsSupplier/${item.id}/"
			data-link-template="./goodsSupplierManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.goodsSupplier}">
			<a href='./goodsSupplierManager/view/${item.goodsSupplier.id}/'>${item.goodsSupplier.displayName}</a>
			</c:if>
			<c:if test="${empty  item.goodsSupplier}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'lastUpdateTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='lastUpdateTime' storedCellValue='${item.lastUpdateTime}' prefix='${ownerBeanName}Manager/updateAccountSet/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.lastUpdateTime}" /></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeAccountSet/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyAccountSetFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


