<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty goodsShelfStockCountList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['goods_shelf_stock_count']}! 
		 <a href="./${ownerBeanName}Manager/addGoodsShelfStockCount/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty goodsShelfStockCountList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("goodsShelfStockCountList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['goods_shelf_stock_count']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addGoodsShelfStockCount/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'goodsShelfStockCountList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${goodsShelfStockCountListName};${goodsShelfStockCountListName}CurrentPage=${page.pageNumber};${goodsShelfStockCountListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='goodsShelfStockCountListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['goods_shelf_stock_count.id']}</th>
</c:if>
<c:if test="${param.referName ne 'title'}">
	<th>${userContext.localeMap['goods_shelf_stock_count.title']}</th>
</c:if>
<c:if test="${param.referName ne 'countTime'}">
	<th>${userContext.localeMap['goods_shelf_stock_count.count_time']}</th>
</c:if>
<c:if test="${param.referName ne 'summary'}">
	<th>${userContext.localeMap['goods_shelf_stock_count.summary']}</th>
</c:if>
<c:if test="${param.referName ne 'shelf'}">
	<th>${userContext.localeMap['goods_shelf_stock_count.shelf']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${goodsShelfStockCountList}">
				<tr currentVersion='${item.version}' id="goodsShelfStockCount-${item.id}" ><td><a class="link-action-removed" href="./goodsShelfStockCountManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'title'}">	<td contenteditable='true' class='edit-value'  propertyToChange='title' storedCellValue='${item.title}' prefix='${ownerBeanName}Manager/updateGoodsShelfStockCount/${result.id}/${item.id}/'>${item.title}</td>
</c:if><c:if test="${param.referName ne 'countTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='countTime' storedCellValue='${item.countTime}' prefix='${ownerBeanName}Manager/updateGoodsShelfStockCount/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.countTime}" /></td>
</c:if><c:if test="${param.referName ne 'summary'}">	<td contenteditable='true' class='edit-value'  propertyToChange='summary' storedCellValue='${item.summary}' prefix='${ownerBeanName}Manager/updateGoodsShelfStockCount/${result.id}/${item.id}/'>${item.summary}</td>
</c:if><c:if test="${param.referName ne 'shelf'}">
	<td class="select_candidate_td"
			data-candidate-method="./goodsShelfStockCountManager/requestCandidateShelf/${ownerBeanName}/${item.id}/"
			data-switch-method="./goodsShelfStockCountManager/transferToAnotherShelf/${item.id}/"
			data-link-template="./goodsShelfManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.shelf}">
			<a href='./goodsShelfManager/view/${item.shelf.id}/'>${item.shelf.displayName}</a>
			</c:if>
			<c:if test="${empty  item.shelf}">
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

				<a href='#${ownerBeanName}Manager/removeGoodsShelfStockCount/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyGoodsShelfStockCountFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


