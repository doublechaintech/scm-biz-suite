<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty goodsPackagingList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['goods_packaging']}! 
		 <a href="./${ownerBeanName}Manager/addGoodsPackaging/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty goodsPackagingList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("goodsPackagingList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['goods_packaging']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addGoodsPackaging/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'goodsPackagingList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${goodsPackagingListName};${goodsPackagingListName}CurrentPage=${page.pageNumber};${goodsPackagingListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='goodsPackagingListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['goods_packaging.id']}</th>
</c:if>
<c:if test="${param.referName ne 'packageName'}">
	<th>${userContext.localeMap['goods_packaging.package_name']}</th>
</c:if>
<c:if test="${param.referName ne 'rfid'}">
	<th>${userContext.localeMap['goods_packaging.rfid']}</th>
</c:if>
<c:if test="${param.referName ne 'packageTime'}">
	<th>${userContext.localeMap['goods_packaging.package_time']}</th>
</c:if>
<c:if test="${param.referName ne 'description'}">
	<th>${userContext.localeMap['goods_packaging.description']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${goodsPackagingList}">
				<tr currentVersion='${item.version}' id="goodsPackaging-${item.id}" ><td><a class="link-action-removed" href="./goodsPackagingManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'packageName'}">	<td contenteditable='true' class='edit-value'  propertyToChange='packageName' storedCellValue='${item.packageName}' prefix='${ownerBeanName}Manager/updateGoodsPackaging/${result.id}/${item.id}/'>${item.packageName}</td>
</c:if><c:if test="${param.referName ne 'rfid'}">	<td contenteditable='true' class='edit-value'  propertyToChange='rfid' storedCellValue='${item.rfid}' prefix='${ownerBeanName}Manager/updateGoodsPackaging/${result.id}/${item.id}/'>${item.rfid}</td>
</c:if><c:if test="${param.referName ne 'packageTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='packageTime' storedCellValue='${item.packageTime}' prefix='${ownerBeanName}Manager/updateGoodsPackaging/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.packageTime}" /></td>
</c:if><c:if test="${param.referName ne 'description'}">	<td contenteditable='true' class='edit-value'  propertyToChange='description' storedCellValue='${item.description}' prefix='${ownerBeanName}Manager/updateGoodsPackaging/${result.id}/${item.id}/'>${item.description}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeGoodsPackaging/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyGoodsPackagingFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


