<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty productSupplyDurationList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['product_supply_duration']}! 
		 <a href="./${ownerBeanName}Manager/addProductSupplyDuration/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty productSupplyDurationList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("productSupplyDurationList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['product_supply_duration']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addProductSupplyDuration/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'productSupplyDurationList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${productSupplyDurationListName};${productSupplyDurationListName}CurrentPage=${page.pageNumber};${productSupplyDurationListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='productSupplyDurationListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['product_supply_duration.id']}</th>
</c:if>
<c:if test="${param.referName ne 'quantity'}">
	<th>${userContext.localeMap['product_supply_duration.quantity']}</th>
</c:if>
<c:if test="${param.referName ne 'duration'}">
	<th>${userContext.localeMap['product_supply_duration.duration']}</th>
</c:if>
<c:if test="${param.referName ne 'price'}">
	<th>${userContext.localeMap['product_supply_duration.price']}</th>
</c:if>
<c:if test="${param.referName ne 'product'}">
	<th>${userContext.localeMap['product_supply_duration.product']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${productSupplyDurationList}">
				<tr currentVersion='${item.version}' id="productSupplyDuration-${item.id}" ><td><a class="link-action-removed" href="./productSupplyDurationManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'quantity'}">	<td contenteditable='true' class='edit-value'  propertyToChange='quantity' storedCellValue='${item.quantity}' prefix='${ownerBeanName}Manager/updateProductSupplyDuration/${result.id}/${item.id}/'>${item.quantity}</td>
</c:if><c:if test="${param.referName ne 'duration'}">	<td contenteditable='true' class='edit-value'  propertyToChange='duration' storedCellValue='${item.duration}' prefix='${ownerBeanName}Manager/updateProductSupplyDuration/${result.id}/${item.id}/'>${item.duration}</td>
</c:if><c:if test="${param.referName ne 'price'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='price' storedCellValue='${item.price}' prefix='${ownerBeanName}Manager/updateProductSupplyDuration/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.price}" /></td>
</c:if><c:if test="${param.referName ne 'product'}">
	<td class="select_candidate_td"
			data-candidate-method="./productSupplyDurationManager/requestCandidateProduct/${ownerBeanName}/${item.id}/"
			data-switch-method="./productSupplyDurationManager/transferToAnotherProduct/${item.id}/"
			data-link-template="./supplierProductManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.product}">
			<a href='./supplierProductManager/view/${item.product.id}/'>${item.product.displayName}</a>
			</c:if>
			<c:if test="${empty  item.product}">
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

				<a href='#${ownerBeanName}Manager/removeProductSupplyDuration/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyProductSupplyDurationFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


