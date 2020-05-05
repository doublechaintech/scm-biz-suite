<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty goodsList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['goods']}! 
		 <a href="./${ownerBeanName}Manager/addGoods/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty goodsList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("goodsList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['goods']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addGoods/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'goodsList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${goodsListName};${goodsListName}CurrentPage=${page.pageNumber};${goodsListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='goodsListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['goods.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['goods.name']}</th>
</c:if>
<c:if test="${param.referName ne 'rfid'}">
	<th>${userContext.localeMap['goods.rfid']}</th>
</c:if>
<c:if test="${param.referName ne 'uom'}">
	<th>${userContext.localeMap['goods.uom']}</th>
</c:if>
<c:if test="${param.referName ne 'maxPackage'}">
	<th>${userContext.localeMap['goods.max_package']}</th>
</c:if>
<c:if test="${param.referName ne 'expireTime'}">
	<th>${userContext.localeMap['goods.expire_time']}</th>
</c:if>
<c:if test="${param.referName ne 'sku'}">
	<th>${userContext.localeMap['goods.sku']}</th>
</c:if>
<c:if test="${param.referName ne 'receivingSpace'}">
	<th>${userContext.localeMap['goods.receiving_space']}</th>
</c:if>
<c:if test="${param.referName ne 'goodsAllocation'}">
	<th>${userContext.localeMap['goods.goods_allocation']}</th>
</c:if>
<c:if test="${param.referName ne 'smartPallet'}">
	<th>${userContext.localeMap['goods.smart_pallet']}</th>
</c:if>
<c:if test="${param.referName ne 'shippingSpace'}">
	<th>${userContext.localeMap['goods.shipping_space']}</th>
</c:if>
<c:if test="${param.referName ne 'transportTask'}">
	<th>${userContext.localeMap['goods.transport_task']}</th>
</c:if>
<c:if test="${param.referName ne 'retailStore'}">
	<th>${userContext.localeMap['goods.retail_store']}</th>
</c:if>
<c:if test="${param.referName ne 'bizOrder'}">
	<th>${userContext.localeMap['goods.biz_order']}</th>
</c:if>
<c:if test="${param.referName ne 'retailStoreOrder'}">
	<th>${userContext.localeMap['goods.retail_store_order']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${goodsList}">
				<tr currentVersion='${item.version}' id="goods-${item.id}" ><td><a class="link-action-removed" href="./goodsManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateGoods/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'rfid'}">	<td contenteditable='true' class='edit-value'  propertyToChange='rfid' storedCellValue='${item.rfid}' prefix='${ownerBeanName}Manager/updateGoods/${result.id}/${item.id}/'>${item.rfid}</td>
</c:if><c:if test="${param.referName ne 'uom'}">	<td contenteditable='true' class='edit-value'  propertyToChange='uom' storedCellValue='${item.uom}' prefix='${ownerBeanName}Manager/updateGoods/${result.id}/${item.id}/'>${item.uom}</td>
</c:if><c:if test="${param.referName ne 'maxPackage'}">	<td contenteditable='true' class='edit-value'  propertyToChange='maxPackage' storedCellValue='${item.maxPackage}' prefix='${ownerBeanName}Manager/updateGoods/${result.id}/${item.id}/'>${item.maxPackage}</td>
</c:if><c:if test="${param.referName ne 'expireTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='expireTime' storedCellValue='${item.expireTime}' prefix='${ownerBeanName}Manager/updateGoods/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.expireTime}" /></td>
</c:if><c:if test="${param.referName ne 'sku'}">
	<td class="select_candidate_td"
			data-candidate-method="./goodsManager/requestCandidateSku/${ownerBeanName}/${item.id}/"
			data-switch-method="./goodsManager/transferToAnotherSku/${item.id}/"
			data-link-template="./skuManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.sku}">
			<a href='./skuManager/view/${item.sku.id}/'>${item.sku.displayName}</a>
			</c:if>
			<c:if test="${empty  item.sku}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'receivingSpace'}">
	<td class="select_candidate_td"
			data-candidate-method="./goodsManager/requestCandidateReceivingSpace/${ownerBeanName}/${item.id}/"
			data-switch-method="./goodsManager/transferToAnotherReceivingSpace/${item.id}/"
			data-link-template="./receivingSpaceManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.receivingSpace}">
			<a href='./receivingSpaceManager/view/${item.receivingSpace.id}/'>${item.receivingSpace.displayName}</a>
			</c:if>
			<c:if test="${empty  item.receivingSpace}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'goodsAllocation'}">
	<td class="select_candidate_td"
			data-candidate-method="./goodsManager/requestCandidateGoodsAllocation/${ownerBeanName}/${item.id}/"
			data-switch-method="./goodsManager/transferToAnotherGoodsAllocation/${item.id}/"
			data-link-template="./goodsAllocationManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.goodsAllocation}">
			<a href='./goodsAllocationManager/view/${item.goodsAllocation.id}/'>${item.goodsAllocation.displayName}</a>
			</c:if>
			<c:if test="${empty  item.goodsAllocation}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'smartPallet'}">
	<td class="select_candidate_td"
			data-candidate-method="./goodsManager/requestCandidateSmartPallet/${ownerBeanName}/${item.id}/"
			data-switch-method="./goodsManager/transferToAnotherSmartPallet/${item.id}/"
			data-link-template="./smartPalletManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.smartPallet}">
			<a href='./smartPalletManager/view/${item.smartPallet.id}/'>${item.smartPallet.displayName}</a>
			</c:if>
			<c:if test="${empty  item.smartPallet}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'shippingSpace'}">
	<td class="select_candidate_td"
			data-candidate-method="./goodsManager/requestCandidateShippingSpace/${ownerBeanName}/${item.id}/"
			data-switch-method="./goodsManager/transferToAnotherShippingSpace/${item.id}/"
			data-link-template="./shippingSpaceManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.shippingSpace}">
			<a href='./shippingSpaceManager/view/${item.shippingSpace.id}/'>${item.shippingSpace.displayName}</a>
			</c:if>
			<c:if test="${empty  item.shippingSpace}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'transportTask'}">
	<td class="select_candidate_td"
			data-candidate-method="./goodsManager/requestCandidateTransportTask/${ownerBeanName}/${item.id}/"
			data-switch-method="./goodsManager/transferToAnotherTransportTask/${item.id}/"
			data-link-template="./transportTaskManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.transportTask}">
			<a href='./transportTaskManager/view/${item.transportTask.id}/'>${item.transportTask.displayName}</a>
			</c:if>
			<c:if test="${empty  item.transportTask}">
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
			data-candidate-method="./goodsManager/requestCandidateRetailStore/${ownerBeanName}/${item.id}/"
			data-switch-method="./goodsManager/transferToAnotherRetailStore/${item.id}/"
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
<c:if test="${param.referName ne 'bizOrder'}">
	<td class="select_candidate_td"
			data-candidate-method="./goodsManager/requestCandidateBizOrder/${ownerBeanName}/${item.id}/"
			data-switch-method="./goodsManager/transferToAnotherBizOrder/${item.id}/"
			data-link-template="./supplyOrderManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.bizOrder}">
			<a href='./supplyOrderManager/view/${item.bizOrder.id}/'>${item.bizOrder.displayName}</a>
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
<c:if test="${param.referName ne 'retailStoreOrder'}">
	<td class="select_candidate_td"
			data-candidate-method="./goodsManager/requestCandidateRetailStoreOrder/${ownerBeanName}/${item.id}/"
			data-switch-method="./goodsManager/transferToAnotherRetailStoreOrder/${item.id}/"
			data-link-template="./retailStoreOrderManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.retailStoreOrder}">
			<a href='./retailStoreOrderManager/view/${item.retailStoreOrder.id}/'>${item.retailStoreOrder.displayName}</a>
			</c:if>
			<c:if test="${empty  item.retailStoreOrder}">
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

				<a href='#${ownerBeanName}Manager/removeGoods/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyGoodsFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


