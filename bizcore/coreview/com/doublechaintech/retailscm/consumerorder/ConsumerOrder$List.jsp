<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty consumerOrderList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['consumer_order']}! 
		 <a href="./${ownerBeanName}Manager/addConsumerOrder/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty consumerOrderList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("consumerOrderList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['consumer_order']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addConsumerOrder/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'consumerOrderList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${consumerOrderListName};${consumerOrderListName}CurrentPage=${page.pageNumber};${consumerOrderListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='consumerOrderListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['consumer_order.id']}</th>
</c:if>
<c:if test="${param.referName ne 'title'}">
	<th>${userContext.localeMap['consumer_order.title']}</th>
</c:if>
<c:if test="${param.referName ne 'consumer'}">
	<th>${userContext.localeMap['consumer_order.consumer']}</th>
</c:if>
<c:if test="${param.referName ne 'confirmation'}">
	<th>${userContext.localeMap['consumer_order.confirmation']}</th>
</c:if>
<c:if test="${param.referName ne 'approval'}">
	<th>${userContext.localeMap['consumer_order.approval']}</th>
</c:if>
<c:if test="${param.referName ne 'processing'}">
	<th>${userContext.localeMap['consumer_order.processing']}</th>
</c:if>
<c:if test="${param.referName ne 'shipment'}">
	<th>${userContext.localeMap['consumer_order.shipment']}</th>
</c:if>
<c:if test="${param.referName ne 'delivery'}">
	<th>${userContext.localeMap['consumer_order.delivery']}</th>
</c:if>
<c:if test="${param.referName ne 'store'}">
	<th>${userContext.localeMap['consumer_order.store']}</th>
</c:if>
<c:if test="${param.referName ne 'lastUpdateTime'}">
	<th>${userContext.localeMap['consumer_order.last_update_time']}</th>
</c:if>
<c:if test="${param.referName ne 'currentStatus'}">
	<th>${userContext.localeMap['consumer_order.current_status']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${consumerOrderList}">
				<tr currentVersion='${item.version}' id="consumerOrder-${item.id}" ><td><a class="link-action-removed" href="./consumerOrderManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'title'}">	<td contenteditable='true' class='edit-value'  propertyToChange='title' storedCellValue='${item.title}' prefix='${ownerBeanName}Manager/updateConsumerOrder/${result.id}/${item.id}/'>${item.title}</td>
</c:if><c:if test="${param.referName ne 'consumer'}">
	<td class="select_candidate_td"
			data-candidate-method="./consumerOrderManager/requestCandidateConsumer/${ownerBeanName}/${item.id}/"
			data-switch-method="./consumerOrderManager/transferToAnotherConsumer/${item.id}/"
			data-link-template="./retailStoreMemberManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.consumer}">
			<a href='./retailStoreMemberManager/view/${item.consumer.id}/'>${item.consumer.displayName}</a>
			</c:if>
			<c:if test="${empty  item.consumer}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'confirmation'}">
	<td class="select_candidate_td"
			data-candidate-method="./consumerOrderManager/requestCandidateConfirmation/${ownerBeanName}/${item.id}/"
			data-switch-method="./consumerOrderManager/transferToAnotherConfirmation/${item.id}/"
			data-link-template="./supplyOrderConfirmationManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.confirmation}">
			<a href='./supplyOrderConfirmationManager/view/${item.confirmation.id}/'>${item.confirmation.displayName}</a>
			</c:if>
			<c:if test="${empty  item.confirmation}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'approval'}">
	<td class="select_candidate_td"
			data-candidate-method="./consumerOrderManager/requestCandidateApproval/${ownerBeanName}/${item.id}/"
			data-switch-method="./consumerOrderManager/transferToAnotherApproval/${item.id}/"
			data-link-template="./supplyOrderApprovalManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.approval}">
			<a href='./supplyOrderApprovalManager/view/${item.approval.id}/'>${item.approval.displayName}</a>
			</c:if>
			<c:if test="${empty  item.approval}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'processing'}">
	<td class="select_candidate_td"
			data-candidate-method="./consumerOrderManager/requestCandidateProcessing/${ownerBeanName}/${item.id}/"
			data-switch-method="./consumerOrderManager/transferToAnotherProcessing/${item.id}/"
			data-link-template="./supplyOrderProcessingManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.processing}">
			<a href='./supplyOrderProcessingManager/view/${item.processing.id}/'>${item.processing.displayName}</a>
			</c:if>
			<c:if test="${empty  item.processing}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'shipment'}">
	<td class="select_candidate_td"
			data-candidate-method="./consumerOrderManager/requestCandidateShipment/${ownerBeanName}/${item.id}/"
			data-switch-method="./consumerOrderManager/transferToAnotherShipment/${item.id}/"
			data-link-template="./supplyOrderShipmentManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.shipment}">
			<a href='./supplyOrderShipmentManager/view/${item.shipment.id}/'>${item.shipment.displayName}</a>
			</c:if>
			<c:if test="${empty  item.shipment}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'delivery'}">
	<td class="select_candidate_td"
			data-candidate-method="./consumerOrderManager/requestCandidateDelivery/${ownerBeanName}/${item.id}/"
			data-switch-method="./consumerOrderManager/transferToAnotherDelivery/${item.id}/"
			data-link-template="./supplyOrderDeliveryManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.delivery}">
			<a href='./supplyOrderDeliveryManager/view/${item.delivery.id}/'>${item.delivery.displayName}</a>
			</c:if>
			<c:if test="${empty  item.delivery}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'store'}">
	<td class="select_candidate_td"
			data-candidate-method="./consumerOrderManager/requestCandidateStore/${ownerBeanName}/${item.id}/"
			data-switch-method="./consumerOrderManager/transferToAnotherStore/${item.id}/"
			data-link-template="./retailStoreManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.store}">
			<a href='./retailStoreManager/view/${item.store.id}/'>${item.store.displayName}</a>
			</c:if>
			<c:if test="${empty  item.store}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'lastUpdateTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='lastUpdateTime' storedCellValue='${item.lastUpdateTime}' prefix='${ownerBeanName}Manager/updateConsumerOrder/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.lastUpdateTime}" /></td>
</c:if><c:if test="${param.referName ne 'currentStatus'}">	<td contenteditable='true' class='edit-value'  propertyToChange='currentStatus' storedCellValue='${item.currentStatus}' prefix='${ownerBeanName}Manager/updateConsumerOrder/${result.id}/${item.id}/'>${item.currentStatus}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeConsumerOrder/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyConsumerOrderFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


