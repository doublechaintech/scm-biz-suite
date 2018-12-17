<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty goodsMovementList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['goods_movement']}! 
		 <a href="./${ownerBeanName}Manager/addGoodsMovement/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty goodsMovementList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("goodsMovementList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['goods_movement']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addGoodsMovement/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'goodsMovementList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${goodsMovementListName};${goodsMovementListName}CurrentPage=${page.pageNumber};${goodsMovementListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='goodsMovementListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['goods_movement.id']}</th>
</c:if>
<c:if test="${param.referName ne 'moveTime'}">
	<th>${userContext.localeMap['goods_movement.move_time']}</th>
</c:if>
<c:if test="${param.referName ne 'facility'}">
	<th>${userContext.localeMap['goods_movement.facility']}</th>
</c:if>
<c:if test="${param.referName ne 'facilityId'}">
	<th>${userContext.localeMap['goods_movement.facility_id']}</th>
</c:if>
<c:if test="${param.referName ne 'fromIp'}">
	<th>${userContext.localeMap['goods_movement.from_ip']}</th>
</c:if>
<c:if test="${param.referName ne 'userAgent'}">
	<th>${userContext.localeMap['goods_movement.user_agent']}</th>
</c:if>
<c:if test="${param.referName ne 'sessionId'}">
	<th>${userContext.localeMap['goods_movement.session_id']}</th>
</c:if>
<c:if test="${param.referName ne 'latitude'}">
	<th>${userContext.localeMap['goods_movement.latitude']}</th>
</c:if>
<c:if test="${param.referName ne 'longitude'}">
	<th>${userContext.localeMap['goods_movement.longitude']}</th>
</c:if>
<c:if test="${param.referName ne 'goods'}">
	<th>${userContext.localeMap['goods_movement.goods']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${goodsMovementList}">
				<tr currentVersion='${item.version}' id="goodsMovement-${item.id}" ><td><a class="link-action-removed" href="./goodsMovementManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'moveTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='moveTime' storedCellValue='${item.moveTime}' prefix='${ownerBeanName}Manager/updateGoodsMovement/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.moveTime}" /></td>
</c:if><c:if test="${param.referName ne 'facility'}">	<td contenteditable='true' class='edit-value'  propertyToChange='facility' storedCellValue='${item.facility}' prefix='${ownerBeanName}Manager/updateGoodsMovement/${result.id}/${item.id}/'>${item.facility}</td>
</c:if><c:if test="${param.referName ne 'facilityId'}">	<td contenteditable='true' class='edit-value'  propertyToChange='facilityId' storedCellValue='${item.facilityId}' prefix='${ownerBeanName}Manager/updateGoodsMovement/${result.id}/${item.id}/'>${item.facilityId}</td>
</c:if><c:if test="${param.referName ne 'fromIp'}">	<td contenteditable='true' class='edit-value'  propertyToChange='fromIp' storedCellValue='${item.fromIp}' prefix='${ownerBeanName}Manager/updateGoodsMovement/${result.id}/${item.id}/'>${item.fromIp}</td>
</c:if><c:if test="${param.referName ne 'userAgent'}">	<td contenteditable='true' class='edit-value'  propertyToChange='userAgent' storedCellValue='${item.userAgent}' prefix='${ownerBeanName}Manager/updateGoodsMovement/${result.id}/${item.id}/'>${item.userAgent}</td>
</c:if><c:if test="${param.referName ne 'sessionId'}">	<td contenteditable='true' class='edit-value'  propertyToChange='sessionId' storedCellValue='${item.sessionId}' prefix='${ownerBeanName}Manager/updateGoodsMovement/${result.id}/${item.id}/'>${item.sessionId}</td>
</c:if><c:if test="${param.referName ne 'latitude'}">	<td contenteditable='true' class='edit-value'  propertyToChange='latitude' storedCellValue='${item.latitude}' prefix='${ownerBeanName}Manager/updateGoodsMovement/${result.id}/${item.id}/'>${item.latitude}</td>
</c:if><c:if test="${param.referName ne 'longitude'}">	<td contenteditable='true' class='edit-value'  propertyToChange='longitude' storedCellValue='${item.longitude}' prefix='${ownerBeanName}Manager/updateGoodsMovement/${result.id}/${item.id}/'>${item.longitude}</td>
</c:if><c:if test="${param.referName ne 'goods'}">
	<td class="select_candidate_td"
			data-candidate-method="./goodsMovementManager/requestCandidateGoods/${ownerBeanName}/${item.id}/"
			data-switch-method="./goodsMovementManager/transferToAnotherGoods/${item.id}/"
			data-link-template="./goodsManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.goods}">
			<a href='./goodsManager/view/${item.goods.id}/'>${item.goods.displayName}</a>
			</c:if>
			<c:if test="${empty  item.goods}">
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

				<a href='#${ownerBeanName}Manager/removeGoodsMovement/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyGoodsMovementFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


