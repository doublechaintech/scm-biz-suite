<%@ page import='java.util.*,com.doublechaintech.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty treeNodeList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['tree_node']}! 
		 <a href="./${ownerBeanName}Manager/addTreeNode/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty treeNodeList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("treeNodeList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['tree_node']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addTreeNode/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'treeNodeList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${treeNodeListName};${treeNodeListName}CurrentPage=${page.pageNumber};${treeNodeListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='treeNodeListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['tree_node.id']}</th>
</c:if>
<c:if test="${param.referName ne 'nodeId'}">
	<th>${userContext.localeMap['tree_node.node_id']}</th>
</c:if>
<c:if test="${param.referName ne 'nodeType'}">
	<th>${userContext.localeMap['tree_node.node_type']}</th>
</c:if>
<c:if test="${param.referName ne 'leftValue'}">
	<th>${userContext.localeMap['tree_node.left_value']}</th>
</c:if>
<c:if test="${param.referName ne 'rightValue'}">
	<th>${userContext.localeMap['tree_node.right_value']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${treeNodeList}">
				<tr currentVersion='${item.version}' id="treeNode-${item.id}" ><td><a class="link-action-removed" href="./treeNodeManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'nodeId'}">	<td contenteditable='true' class='edit-value'  propertyToChange='nodeId' storedCellValue='${item.nodeId}' prefix='${ownerBeanName}Manager/updateTreeNode/${result.id}/${item.id}/'>${item.nodeId}</td>
</c:if><c:if test="${param.referName ne 'nodeType'}">	<td contenteditable='true' class='edit-value'  propertyToChange='nodeType' storedCellValue='${item.nodeType}' prefix='${ownerBeanName}Manager/updateTreeNode/${result.id}/${item.id}/'>${item.nodeType}</td>
</c:if><c:if test="${param.referName ne 'leftValue'}">	<td contenteditable='true' class='edit-value'  propertyToChange='leftValue' storedCellValue='${item.leftValue}' prefix='${ownerBeanName}Manager/updateTreeNode/${result.id}/${item.id}/'>${item.leftValue}</td>
</c:if><c:if test="${param.referName ne 'rightValue'}">	<td contenteditable='true' class='edit-value'  propertyToChange='rightValue' storedCellValue='${item.rightValue}' prefix='${ownerBeanName}Manager/updateTreeNode/${result.id}/${item.id}/'>${item.rightValue}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeTreeNode/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyTreeNodeFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>










