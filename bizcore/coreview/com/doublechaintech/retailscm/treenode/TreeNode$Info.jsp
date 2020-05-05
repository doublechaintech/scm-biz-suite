
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty treeNode}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A TreeNode">${userContext.localeMap['tree_node']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./treeNodeManager/view/${treeNode.id}/"> ${treeNode.id}</a></li>
<li><span>${userContext.localeMap['tree_node.node_id']}</span> ${treeNode.nodeId}</li>
<li><span>${userContext.localeMap['tree_node.node_type']}</span> ${treeNode.nodeType}</li>
<li><span>${userContext.localeMap['tree_node.left_value']}</span> ${treeNode.leftValue}</li>
<li><span>${userContext.localeMap['tree_node.right_value']}</span> ${treeNode.rightValue}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>











