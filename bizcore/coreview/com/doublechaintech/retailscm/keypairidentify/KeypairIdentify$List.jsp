<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty keypairIdentifyList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['keypair_identify']}! 
		 <a href="./${ownerBeanName}Manager/addKeypairIdentify/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty keypairIdentifyList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("keypairIdentifyList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['keypair_identify']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addKeypairIdentify/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'keypairIdentifyList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${keypairIdentifyListName};${keypairIdentifyListName}CurrentPage=${page.pageNumber};${keypairIdentifyListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='keypairIdentifyListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['keypair_identify.id']}</th>
</c:if>
<c:if test="${param.referName ne 'publicKey'}">
	<th>${userContext.localeMap['keypair_identify.public_key']}</th>
</c:if>
<c:if test="${param.referName ne 'keyType'}">
	<th>${userContext.localeMap['keypair_identify.key_type']}</th>
</c:if>
<c:if test="${param.referName ne 'secUser'}">
	<th>${userContext.localeMap['keypair_identify.sec_user']}</th>
</c:if>
<c:if test="${param.referName ne 'createTime'}">
	<th>${userContext.localeMap['keypair_identify.create_time']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${keypairIdentifyList}">
				<tr currentVersion='${item.version}' id="keypairIdentify-${item.id}" ><td><a class="link-action-removed" href="./keypairIdentifyManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'publicKey'}">	<td contenteditable='true' class='edit-value'  propertyToChange='publicKey' storedCellValue='${item.publicKey}' prefix='${ownerBeanName}Manager/updateKeypairIdentify/${result.id}/${item.id}/'><a title='${item.publicKey}'>${fn:substring(item.publicKey,0,10)}...</a></td>
</c:if><c:if test="${param.referName ne 'keyType'}">
	<td class="select_candidate_td"
			data-candidate-method="./keypairIdentifyManager/requestCandidateKeyType/${ownerBeanName}/${item.id}/"
			data-switch-method="./keypairIdentifyManager/transferToAnotherKeyType/${item.id}/"
			data-link-template="./publicKeyTypeManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.keyType}">
			<a href='./publicKeyTypeManager/view/${item.keyType.id}/'>${item.keyType.displayName}</a>
			</c:if>
			<c:if test="${empty  item.keyType}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'secUser'}">
	<td class="select_candidate_td"
			data-candidate-method="./keypairIdentifyManager/requestCandidateSecUser/${ownerBeanName}/${item.id}/"
			data-switch-method="./keypairIdentifyManager/transferToAnotherSecUser/${item.id}/"
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
<c:if test="${param.referName ne 'createTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='createTime' storedCellValue='${item.createTime}' prefix='${ownerBeanName}Manager/updateKeypairIdentify/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.createTime}" /></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeKeypairIdentify/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyKeypairIdentifyFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


