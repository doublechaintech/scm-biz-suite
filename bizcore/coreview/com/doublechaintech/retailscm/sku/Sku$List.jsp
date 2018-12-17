<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty skuList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['sku']}! 
		 <a href="./${ownerBeanName}Manager/addSku/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty skuList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("skuList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['sku']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addSku/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'skuList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${skuListName};${skuListName}CurrentPage=${page.pageNumber};${skuListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='skuListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['sku.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['sku.name']}</th>
</c:if>
<c:if test="${param.referName ne 'size'}">
	<th>${userContext.localeMap['sku.size']}</th>
</c:if>
<c:if test="${param.referName ne 'product'}">
	<th>${userContext.localeMap['sku.product']}</th>
</c:if>
<c:if test="${param.referName ne 'barcode'}">
	<th>${userContext.localeMap['sku.barcode']}</th>
</c:if>
<c:if test="${param.referName ne 'packageType'}">
	<th>${userContext.localeMap['sku.package_type']}</th>
</c:if>
<c:if test="${param.referName ne 'netContent'}">
	<th>${userContext.localeMap['sku.net_content']}</th>
</c:if>
<c:if test="${param.referName ne 'price'}">
	<th>${userContext.localeMap['sku.price']}</th>
</c:if>
<c:if test="${param.referName ne 'picture'}">
	<th>${userContext.localeMap['sku.picture']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${skuList}">
				<tr currentVersion='${item.version}' id="sku-${item.id}" ><td><a class="link-action-removed" href="./skuManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateSku/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'size'}">	<td contenteditable='true' class='edit-value'  propertyToChange='size' storedCellValue='${item.size}' prefix='${ownerBeanName}Manager/updateSku/${result.id}/${item.id}/'>${item.size}</td>
</c:if><c:if test="${param.referName ne 'product'}">
	<td class="select_candidate_td"
			data-candidate-method="./skuManager/requestCandidateProduct/${ownerBeanName}/${item.id}/"
			data-switch-method="./skuManager/transferToAnotherProduct/${item.id}/"
			data-link-template="./productManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.product}">
			<a href='./productManager/view/${item.product.id}/'>${item.product.displayName}</a>
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
<c:if test="${param.referName ne 'barcode'}">	<td contenteditable='true' class='edit-value'  propertyToChange='barcode' storedCellValue='${item.barcode}' prefix='${ownerBeanName}Manager/updateSku/${result.id}/${item.id}/'>${item.barcode}</td>
</c:if><c:if test="${param.referName ne 'packageType'}">	<td contenteditable='true' class='edit-value'  propertyToChange='packageType' storedCellValue='${item.packageType}' prefix='${ownerBeanName}Manager/updateSku/${result.id}/${item.id}/'>${item.packageType}</td>
</c:if><c:if test="${param.referName ne 'netContent'}">	<td contenteditable='true' class='edit-value'  propertyToChange='netContent' storedCellValue='${item.netContent}' prefix='${ownerBeanName}Manager/updateSku/${result.id}/${item.id}/'>${item.netContent}</td>
</c:if><c:if test="${param.referName ne 'price'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='price' storedCellValue='${item.price}' prefix='${ownerBeanName}Manager/updateSku/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.price}" /></td>
</c:if><c:if test="${param.referName ne 'picture'}">	<td contenteditable='true' class='edit-value'  propertyToChange='picture' storedCellValue='${item.picture}' prefix='${ownerBeanName}Manager/updateSku/${result.id}/${item.id}/'>${item.picture}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeSku/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copySkuFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


