<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty supplierProductList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['supplier_product']}! 
		 <a href="./${ownerBeanName}Manager/addSupplierProduct/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty supplierProductList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("supplierProductList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['supplier_product']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addSupplierProduct/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'supplierProductList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${supplierProductListName};${supplierProductListName}CurrentPage=${page.pageNumber};${supplierProductListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='supplierProductListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['supplier_product.id']}</th>
</c:if>
<c:if test="${param.referName ne 'productName'}">
	<th>${userContext.localeMap['supplier_product.product_name']}</th>
</c:if>
<c:if test="${param.referName ne 'productDescription'}">
	<th>${userContext.localeMap['supplier_product.product_description']}</th>
</c:if>
<c:if test="${param.referName ne 'productUnit'}">
	<th>${userContext.localeMap['supplier_product.product_unit']}</th>
</c:if>
<c:if test="${param.referName ne 'supplier'}">
	<th>${userContext.localeMap['supplier_product.supplier']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${supplierProductList}">
				<tr currentVersion='${item.version}' id="supplierProduct-${item.id}" ><td><a class="link-action-removed" href="./supplierProductManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'productName'}">	<td contenteditable='true' class='edit-value'  propertyToChange='productName' storedCellValue='${item.productName}' prefix='${ownerBeanName}Manager/updateSupplierProduct/${result.id}/${item.id}/'>${item.productName}</td>
</c:if><c:if test="${param.referName ne 'productDescription'}">	<td contenteditable='true' class='edit-value'  propertyToChange='productDescription' storedCellValue='${item.productDescription}' prefix='${ownerBeanName}Manager/updateSupplierProduct/${result.id}/${item.id}/'>${item.productDescription}</td>
</c:if><c:if test="${param.referName ne 'productUnit'}">	<td contenteditable='true' class='edit-value'  propertyToChange='productUnit' storedCellValue='${item.productUnit}' prefix='${ownerBeanName}Manager/updateSupplierProduct/${result.id}/${item.id}/'>${item.productUnit}</td>
</c:if><c:if test="${param.referName ne 'supplier'}">
	<td class="select_candidate_td"
			data-candidate-method="./supplierProductManager/requestCandidateSupplier/${ownerBeanName}/${item.id}/"
			data-switch-method="./supplierProductManager/transferToAnotherSupplier/${item.id}/"
			data-link-template="./goodsSupplierManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.supplier}">
			<a href='./goodsSupplierManager/view/${item.supplier.id}/'>${item.supplier.displayName}</a>
			</c:if>
			<c:if test="${empty  item.supplier}">
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

				<a href='#${ownerBeanName}Manager/removeSupplierProduct/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copySupplierProductFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


