<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty retailStoreList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['retail_store']}! 
		 <a href="./${ownerBeanName}Manager/addRetailStore/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty retailStoreList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("retailStoreList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['retail_store']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addRetailStore/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'retailStoreList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${retailStoreListName};${retailStoreListName}CurrentPage=${page.pageNumber};${retailStoreListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='retailStoreListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['retail_store.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['retail_store.name']}</th>
</c:if>
<c:if test="${param.referName ne 'telephone'}">
	<th>${userContext.localeMap['retail_store.telephone']}</th>
</c:if>
<c:if test="${param.referName ne 'owner'}">
	<th>${userContext.localeMap['retail_store.owner']}</th>
</c:if>
<c:if test="${param.referName ne 'retailStoreCountryCenter'}">
	<th>${userContext.localeMap['retail_store.retail_store_country_center']}</th>
</c:if>
<c:if test="${param.referName ne 'cityServiceCenter'}">
	<th>${userContext.localeMap['retail_store.city_service_center']}</th>
</c:if>
<c:if test="${param.referName ne 'creation'}">
	<th>${userContext.localeMap['retail_store.creation']}</th>
</c:if>
<c:if test="${param.referName ne 'investmentInvitation'}">
	<th>${userContext.localeMap['retail_store.investment_invitation']}</th>
</c:if>
<c:if test="${param.referName ne 'franchising'}">
	<th>${userContext.localeMap['retail_store.franchising']}</th>
</c:if>
<c:if test="${param.referName ne 'decoration'}">
	<th>${userContext.localeMap['retail_store.decoration']}</th>
</c:if>
<c:if test="${param.referName ne 'opening'}">
	<th>${userContext.localeMap['retail_store.opening']}</th>
</c:if>
<c:if test="${param.referName ne 'closing'}">
	<th>${userContext.localeMap['retail_store.closing']}</th>
</c:if>
<c:if test="${param.referName ne 'founded'}">
	<th>${userContext.localeMap['retail_store.founded']}</th>
</c:if>
<c:if test="${param.referName ne 'latitude'}">
	<th>${userContext.localeMap['retail_store.latitude']}</th>
</c:if>
<c:if test="${param.referName ne 'longitude'}">
	<th>${userContext.localeMap['retail_store.longitude']}</th>
</c:if>
<c:if test="${param.referName ne 'description'}">
	<th>${userContext.localeMap['retail_store.description']}</th>
</c:if>
<c:if test="${param.referName ne 'lastUpdateTime'}">
	<th>${userContext.localeMap['retail_store.last_update_time']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${retailStoreList}">
				<tr currentVersion='${item.version}' id="retailStore-${item.id}" ><td><a class="link-action-removed" href="./retailStoreManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateRetailStore/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'telephone'}">	<td contenteditable='true' class='edit-value'  propertyToChange='telephone' storedCellValue='${item.telephone}' prefix='${ownerBeanName}Manager/updateRetailStore/${result.id}/${item.id}/'>${item.telephone}</td>
</c:if><c:if test="${param.referName ne 'owner'}">	<td contenteditable='true' class='edit-value'  propertyToChange='owner' storedCellValue='${item.owner}' prefix='${ownerBeanName}Manager/updateRetailStore/${result.id}/${item.id}/'>${item.owner}</td>
</c:if><c:if test="${param.referName ne 'retailStoreCountryCenter'}">
	<td class="select_candidate_td"
			data-candidate-method="./retailStoreManager/requestCandidateRetailStoreCountryCenter/${ownerBeanName}/${item.id}/"
			data-switch-method="./retailStoreManager/transferToAnotherRetailStoreCountryCenter/${item.id}/"
			data-link-template="./retailStoreCountryCenterManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.retailStoreCountryCenter}">
			<a href='./retailStoreCountryCenterManager/view/${item.retailStoreCountryCenter.id}/'>${item.retailStoreCountryCenter.displayName}</a>
			</c:if>
			<c:if test="${empty  item.retailStoreCountryCenter}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'cityServiceCenter'}">
	<td class="select_candidate_td"
			data-candidate-method="./retailStoreManager/requestCandidateCityServiceCenter/${ownerBeanName}/${item.id}/"
			data-switch-method="./retailStoreManager/transferToAnotherCityServiceCenter/${item.id}/"
			data-link-template="./retailStoreCityServiceCenterManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.cityServiceCenter}">
			<a href='./retailStoreCityServiceCenterManager/view/${item.cityServiceCenter.id}/'>${item.cityServiceCenter.displayName}</a>
			</c:if>
			<c:if test="${empty  item.cityServiceCenter}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'creation'}">
	<td class="select_candidate_td"
			data-candidate-method="./retailStoreManager/requestCandidateCreation/${ownerBeanName}/${item.id}/"
			data-switch-method="./retailStoreManager/transferToAnotherCreation/${item.id}/"
			data-link-template="./retailStoreCreationManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.creation}">
			<a href='./retailStoreCreationManager/view/${item.creation.id}/'>${item.creation.displayName}</a>
			</c:if>
			<c:if test="${empty  item.creation}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'investmentInvitation'}">
	<td class="select_candidate_td"
			data-candidate-method="./retailStoreManager/requestCandidateInvestmentInvitation/${ownerBeanName}/${item.id}/"
			data-switch-method="./retailStoreManager/transferToAnotherInvestmentInvitation/${item.id}/"
			data-link-template="./retailStoreInvestmentInvitationManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.investmentInvitation}">
			<a href='./retailStoreInvestmentInvitationManager/view/${item.investmentInvitation.id}/'>${item.investmentInvitation.displayName}</a>
			</c:if>
			<c:if test="${empty  item.investmentInvitation}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'franchising'}">
	<td class="select_candidate_td"
			data-candidate-method="./retailStoreManager/requestCandidateFranchising/${ownerBeanName}/${item.id}/"
			data-switch-method="./retailStoreManager/transferToAnotherFranchising/${item.id}/"
			data-link-template="./retailStoreFranchisingManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.franchising}">
			<a href='./retailStoreFranchisingManager/view/${item.franchising.id}/'>${item.franchising.displayName}</a>
			</c:if>
			<c:if test="${empty  item.franchising}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'decoration'}">
	<td class="select_candidate_td"
			data-candidate-method="./retailStoreManager/requestCandidateDecoration/${ownerBeanName}/${item.id}/"
			data-switch-method="./retailStoreManager/transferToAnotherDecoration/${item.id}/"
			data-link-template="./retailStoreDecorationManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.decoration}">
			<a href='./retailStoreDecorationManager/view/${item.decoration.id}/'>${item.decoration.displayName}</a>
			</c:if>
			<c:if test="${empty  item.decoration}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'opening'}">
	<td class="select_candidate_td"
			data-candidate-method="./retailStoreManager/requestCandidateOpening/${ownerBeanName}/${item.id}/"
			data-switch-method="./retailStoreManager/transferToAnotherOpening/${item.id}/"
			data-link-template="./retailStoreOpeningManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.opening}">
			<a href='./retailStoreOpeningManager/view/${item.opening.id}/'>${item.opening.displayName}</a>
			</c:if>
			<c:if test="${empty  item.opening}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'closing'}">
	<td class="select_candidate_td"
			data-candidate-method="./retailStoreManager/requestCandidateClosing/${ownerBeanName}/${item.id}/"
			data-switch-method="./retailStoreManager/transferToAnotherClosing/${item.id}/"
			data-link-template="./retailStoreClosingManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.closing}">
			<a href='./retailStoreClosingManager/view/${item.closing.id}/'>${item.closing.displayName}</a>
			</c:if>
			<c:if test="${empty  item.closing}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'founded'}">	<td contenteditable='true' class='edit-value'  propertyToChange='founded' storedCellValue='${item.founded}' prefix='${ownerBeanName}Manager/updateRetailStore/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.founded}" /></td>
</c:if><c:if test="${param.referName ne 'latitude'}">	<td contenteditable='true' class='edit-value'  propertyToChange='latitude' storedCellValue='${item.latitude}' prefix='${ownerBeanName}Manager/updateRetailStore/${result.id}/${item.id}/'>${item.latitude}</td>
</c:if><c:if test="${param.referName ne 'longitude'}">	<td contenteditable='true' class='edit-value'  propertyToChange='longitude' storedCellValue='${item.longitude}' prefix='${ownerBeanName}Manager/updateRetailStore/${result.id}/${item.id}/'>${item.longitude}</td>
</c:if><c:if test="${param.referName ne 'description'}">	<td contenteditable='true' class='edit-value'  propertyToChange='description' storedCellValue='${item.description}' prefix='${ownerBeanName}Manager/updateRetailStore/${result.id}/${item.id}/'>${item.description}</td>
</c:if><c:if test="${param.referName ne 'lastUpdateTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='lastUpdateTime' storedCellValue='${item.lastUpdateTime}' prefix='${ownerBeanName}Manager/updateRetailStore/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.lastUpdateTime}" /></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeRetailStore/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyRetailStoreFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


