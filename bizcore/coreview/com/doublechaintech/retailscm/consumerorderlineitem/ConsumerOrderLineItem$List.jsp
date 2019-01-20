<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty consumerOrderLineItemList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['consumer_order_line_item']}! 
		 <a href="./${ownerBeanName}Manager/addConsumerOrderLineItem/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty consumerOrderLineItemList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("consumerOrderLineItemList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['consumer_order_line_item']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addConsumerOrderLineItem/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'consumerOrderLineItemList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${consumerOrderLineItemListName};${consumerOrderLineItemListName}CurrentPage=${page.pageNumber};${consumerOrderLineItemListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='consumerOrderLineItemListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['consumer_order_line_item.id']}</th>
</c:if>
<c:if test="${param.referName ne 'bizOrder'}">
	<th>${userContext.localeMap['consumer_order_line_item.biz_order']}</th>
</c:if>
<c:if test="${param.referName ne 'skuId'}">
	<th>${userContext.localeMap['consumer_order_line_item.sku_id']}</th>
</c:if>
<c:if test="${param.referName ne 'skuName'}">
	<th>${userContext.localeMap['consumer_order_line_item.sku_name']}</th>
</c:if>
<c:if test="${param.referName ne 'price'}">
	<th>${userContext.localeMap['consumer_order_line_item.price']}</th>
</c:if>
<c:if test="${param.referName ne 'quantity'}">
	<th>${userContext.localeMap['consumer_order_line_item.quantity']}</th>
</c:if>
<c:if test="${param.referName ne 'amount'}">
	<th>${userContext.localeMap['consumer_order_line_item.amount']}</th>
</c:if>
<c:if test="${param.referName ne 'lastUpdateTime'}">
	<th>${userContext.localeMap['consumer_order_line_item.last_update_time']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${consumerOrderLineItemList}">
				<tr currentVersion='${item.version}' id="consumerOrderLineItem-${item.id}" ><td><a class="link-action-removed" href="./consumerOrderLineItemManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'bizOrder'}">
	<td class="select_candidate_td"
			data-candidate-method="./consumerOrderLineItemManager/requestCandidateBizOrder/${ownerBeanName}/${item.id}/"
			data-switch-method="./consumerOrderLineItemManager/transferToAnotherBizOrder/${item.id}/"
			data-link-template="./consumerOrderManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.bizOrder}">
			<a href='./consumerOrderManager/view/${item.bizOrder.id}/'>${item.bizOrder.displayName}</a>
			</c:if>
			<c:if test="${empty  item.bizOrder}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'skuId'}">	<td contenteditable='true' class='edit-value'  propertyToChange='skuId' storedCellValue='${item.skuId}' prefix='${ownerBeanName}Manager/updateConsumerOrderLineItem/${result.id}/${item.id}/'>${item.skuId}</td>
</c:if><c:if test="${param.referName ne 'skuName'}">	<td contenteditable='true' class='edit-value'  propertyToChange='skuName' storedCellValue='${item.skuName}' prefix='${ownerBeanName}Manager/updateConsumerOrderLineItem/${result.id}/${item.id}/'>${item.skuName}</td>
</c:if><c:if test="${param.referName ne 'price'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='price' storedCellValue='${item.price}' prefix='${ownerBeanName}Manager/updateConsumerOrderLineItem/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.price}" /></td>
</c:if><c:if test="${param.referName ne 'quantity'}">	<td contenteditable='true' class='edit-value'  propertyToChange='quantity' storedCellValue='${item.quantity}' prefix='${ownerBeanName}Manager/updateConsumerOrderLineItem/${result.id}/${item.id}/'>${item.quantity}</td>
</c:if><c:if test="${param.referName ne 'amount'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='amount' storedCellValue='${item.amount}' prefix='${ownerBeanName}Manager/updateConsumerOrderLineItem/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.amount}" /></td>
</c:if><c:if test="${param.referName ne 'lastUpdateTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='lastUpdateTime' storedCellValue='${item.lastUpdateTime}' prefix='${ownerBeanName}Manager/updateConsumerOrderLineItem/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.lastUpdateTime}" /></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeConsumerOrderLineItem/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyConsumerOrderLineItemFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


