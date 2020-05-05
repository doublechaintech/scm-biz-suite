<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty retailStoreMemberGiftCardConsumeRecordList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['retail_store_member_gift_card_consume_record']}! 
		 <a href="./${ownerBeanName}Manager/addRetailStoreMemberGiftCardConsumeRecord/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty retailStoreMemberGiftCardConsumeRecordList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("retailStoreMemberGiftCardConsumeRecordList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['retail_store_member_gift_card_consume_record']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addRetailStoreMemberGiftCardConsumeRecord/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'retailStoreMemberGiftCardConsumeRecordList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${retailStoreMemberGiftCardConsumeRecordListName};${retailStoreMemberGiftCardConsumeRecordListName}CurrentPage=${page.pageNumber};${retailStoreMemberGiftCardConsumeRecordListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='retailStoreMemberGiftCardConsumeRecordListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['retail_store_member_gift_card_consume_record.id']}</th>
</c:if>
<c:if test="${param.referName ne 'occureTime'}">
	<th>${userContext.localeMap['retail_store_member_gift_card_consume_record.occure_time']}</th>
</c:if>
<c:if test="${param.referName ne 'owner'}">
	<th>${userContext.localeMap['retail_store_member_gift_card_consume_record.owner']}</th>
</c:if>
<c:if test="${param.referName ne 'bizOrder'}">
	<th>${userContext.localeMap['retail_store_member_gift_card_consume_record.biz_order']}</th>
</c:if>
<c:if test="${param.referName ne 'number'}">
	<th>${userContext.localeMap['retail_store_member_gift_card_consume_record.number']}</th>
</c:if>
<c:if test="${param.referName ne 'amount'}">
	<th>${userContext.localeMap['retail_store_member_gift_card_consume_record.amount']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${retailStoreMemberGiftCardConsumeRecordList}">
				<tr currentVersion='${item.version}' id="retailStoreMemberGiftCardConsumeRecord-${item.id}" ><td><a class="link-action-removed" href="./retailStoreMemberGiftCardConsumeRecordManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'occureTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='occureTime' storedCellValue='${item.occureTime}' prefix='${ownerBeanName}Manager/updateRetailStoreMemberGiftCardConsumeRecord/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.occureTime}" /></td>
</c:if><c:if test="${param.referName ne 'owner'}">
	<td class="select_candidate_td"
			data-candidate-method="./retailStoreMemberGiftCardConsumeRecordManager/requestCandidateOwner/${ownerBeanName}/${item.id}/"
			data-switch-method="./retailStoreMemberGiftCardConsumeRecordManager/transferToAnotherOwner/${item.id}/"
			data-link-template="./retailStoreMemberGiftCardManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.owner}">
			<a href='./retailStoreMemberGiftCardManager/view/${item.owner.id}/'>${item.owner.displayName}</a>
			</c:if>
			<c:if test="${empty  item.owner}">
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
			data-candidate-method="./retailStoreMemberGiftCardConsumeRecordManager/requestCandidateBizOrder/${ownerBeanName}/${item.id}/"
			data-switch-method="./retailStoreMemberGiftCardConsumeRecordManager/transferToAnotherBizOrder/${item.id}/"
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
<c:if test="${param.referName ne 'number'}">	<td contenteditable='true' class='edit-value'  propertyToChange='number' storedCellValue='${item.number}' prefix='${ownerBeanName}Manager/updateRetailStoreMemberGiftCardConsumeRecord/${result.id}/${item.id}/'>${item.number}</td>
</c:if><c:if test="${param.referName ne 'amount'}">	<td contenteditable='true' class='edit-value money'  propertyToChange='amount' storedCellValue='${item.amount}' prefix='${ownerBeanName}Manager/updateRetailStoreMemberGiftCardConsumeRecord/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.amount}" /></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeRetailStoreMemberGiftCardConsumeRecord/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyRetailStoreMemberGiftCardConsumeRecordFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


