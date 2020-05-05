<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty goodsShelfList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['goods_shelf']}! 
		 <a href="./${ownerBeanName}Manager/addGoodsShelf/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty goodsShelfList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("goodsShelfList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['goods_shelf']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addGoodsShelf/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'goodsShelfList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${goodsShelfListName};${goodsShelfListName}CurrentPage=${page.pageNumber};${goodsShelfListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='goodsShelfListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['goods_shelf.id']}</th>
</c:if>
<c:if test="${param.referName ne 'location'}">
	<th>${userContext.localeMap['goods_shelf.location']}</th>
</c:if>
<c:if test="${param.referName ne 'storageSpace'}">
	<th>${userContext.localeMap['goods_shelf.storage_space']}</th>
</c:if>
<c:if test="${param.referName ne 'supplierSpace'}">
	<th>${userContext.localeMap['goods_shelf.supplier_space']}</th>
</c:if>
<c:if test="${param.referName ne 'damageSpace'}">
	<th>${userContext.localeMap['goods_shelf.damage_space']}</th>
</c:if>
<c:if test="${param.referName ne 'lastUpdateTime'}">
	<th>${userContext.localeMap['goods_shelf.last_update_time']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${goodsShelfList}">
				<tr currentVersion='${item.version}' id="goodsShelf-${item.id}" ><td><a class="link-action-removed" href="./goodsShelfManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'location'}">	<td contenteditable='true' class='edit-value'  propertyToChange='location' storedCellValue='${item.location}' prefix='${ownerBeanName}Manager/updateGoodsShelf/${result.id}/${item.id}/'>${item.location}</td>
</c:if><c:if test="${param.referName ne 'storageSpace'}">
	<td class="select_candidate_td"
			data-candidate-method="./goodsShelfManager/requestCandidateStorageSpace/${ownerBeanName}/${item.id}/"
			data-switch-method="./goodsShelfManager/transferToAnotherStorageSpace/${item.id}/"
			data-link-template="./storageSpaceManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.storageSpace}">
			<a href='./storageSpaceManager/view/${item.storageSpace.id}/'>${item.storageSpace.displayName}</a>
			</c:if>
			<c:if test="${empty  item.storageSpace}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'supplierSpace'}">
	<td class="select_candidate_td"
			data-candidate-method="./goodsShelfManager/requestCandidateSupplierSpace/${ownerBeanName}/${item.id}/"
			data-switch-method="./goodsShelfManager/transferToAnotherSupplierSpace/${item.id}/"
			data-link-template="./supplierSpaceManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.supplierSpace}">
			<a href='./supplierSpaceManager/view/${item.supplierSpace.id}/'>${item.supplierSpace.displayName}</a>
			</c:if>
			<c:if test="${empty  item.supplierSpace}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'damageSpace'}">
	<td class="select_candidate_td"
			data-candidate-method="./goodsShelfManager/requestCandidateDamageSpace/${ownerBeanName}/${item.id}/"
			data-switch-method="./goodsShelfManager/transferToAnotherDamageSpace/${item.id}/"
			data-link-template="./damageSpaceManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.damageSpace}">
			<a href='./damageSpaceManager/view/${item.damageSpace.id}/'>${item.damageSpace.displayName}</a>
			</c:if>
			<c:if test="${empty  item.damageSpace}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'lastUpdateTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='lastUpdateTime' storedCellValue='${item.lastUpdateTime}' prefix='${ownerBeanName}Manager/updateGoodsShelf/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.lastUpdateTime}" /></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeGoodsShelf/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyGoodsShelfFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


