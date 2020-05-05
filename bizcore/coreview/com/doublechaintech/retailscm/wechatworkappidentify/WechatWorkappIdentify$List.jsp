<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty wechatWorkappIdentifyList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['wechat_workapp_identify']}! 
		 <a href="./${ownerBeanName}Manager/addWechatWorkappIdentify/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty wechatWorkappIdentifyList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("wechatWorkappIdentifyList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['wechat_workapp_identify']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addWechatWorkappIdentify/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'wechatWorkappIdentifyList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${wechatWorkappIdentifyListName};${wechatWorkappIdentifyListName}CurrentPage=${page.pageNumber};${wechatWorkappIdentifyListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='wechatWorkappIdentifyListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['wechat_workapp_identify.id']}</th>
</c:if>
<c:if test="${param.referName ne 'corpId'}">
	<th>${userContext.localeMap['wechat_workapp_identify.corp_id']}</th>
</c:if>
<c:if test="${param.referName ne 'userId'}">
	<th>${userContext.localeMap['wechat_workapp_identify.user_id']}</th>
</c:if>
<c:if test="${param.referName ne 'secUser'}">
	<th>${userContext.localeMap['wechat_workapp_identify.sec_user']}</th>
</c:if>
<c:if test="${param.referName ne 'createTime'}">
	<th>${userContext.localeMap['wechat_workapp_identify.create_time']}</th>
</c:if>
<c:if test="${param.referName ne 'lastLoginTime'}">
	<th>${userContext.localeMap['wechat_workapp_identify.last_login_time']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${wechatWorkappIdentifyList}">
				<tr currentVersion='${item.version}' id="wechatWorkappIdentify-${item.id}" ><td><a class="link-action-removed" href="./wechatWorkappIdentifyManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'corpId'}">	<td contenteditable='true' class='edit-value'  propertyToChange='corpId' storedCellValue='${item.corpId}' prefix='${ownerBeanName}Manager/updateWechatWorkappIdentify/${result.id}/${item.id}/'>${item.corpId}</td>
</c:if><c:if test="${param.referName ne 'userId'}">	<td contenteditable='true' class='edit-value'  propertyToChange='userId' storedCellValue='${item.userId}' prefix='${ownerBeanName}Manager/updateWechatWorkappIdentify/${result.id}/${item.id}/'>${item.userId}</td>
</c:if><c:if test="${param.referName ne 'secUser'}">
	<td class="select_candidate_td"
			data-candidate-method="./wechatWorkappIdentifyManager/requestCandidateSecUser/${ownerBeanName}/${item.id}/"
			data-switch-method="./wechatWorkappIdentifyManager/transferToAnotherSecUser/${item.id}/"
			data-link-template="./secUserManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.secUser}">
			<a href='./secUserManager/view/${item.secUser.id}/'>${item.secUser.displayName}</a>
			</c:if>
			<c:if test="${empty  item.secUser}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'createTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='createTime' storedCellValue='${item.createTime}' prefix='${ownerBeanName}Manager/updateWechatWorkappIdentify/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.createTime}" /></td>
</c:if><c:if test="${param.referName ne 'lastLoginTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='lastLoginTime' storedCellValue='${item.lastLoginTime}' prefix='${ownerBeanName}Manager/updateWechatWorkappIdentify/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.lastLoginTime}" /></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeWechatWorkappIdentify/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyWechatWorkappIdentifyFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


