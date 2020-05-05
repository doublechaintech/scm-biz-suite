
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@page import='com.terapico.b2b2c.*'%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>


	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<c:if test="${not empty result.acceleratorAccountList}"> 加速器账户 </c:if>
		
		<c:if test="${empty result.acceleratorAccountList}"> 没有找到加速器账户!</c:if>
		 </div>
	</div>

    <c:if test="${not empty result.acceleratorAccountList}" >
<div class="table-responsive">

<%
	//this is the only resolution for serlvet 2.5, EL2.2 will be much better
	BaseEntity result=(BaseEntity)request.getAttribute("result");
	
%>

<c:set var="pages" value="<%=result.flexibleListOf("acceleratorAccountListPagination")%>" />

<c:forEach var="page" items="${pages}"> 
<c:if test='${page.selected}' >
<a href='#decorationAcceleratorManager/loadDecorationAccelerator/${result.id}/acceleratorAccountList;acceleratorAccountListCurrentPage=${page.pageNumber}/' class='page-action btn btn-danger btn-md submit'>${page.title}</a>
</c:if>
<c:if test='${ not page.selected }' >
<a href='#decorationAcceleratorManager/loadDecorationAccelerator/${result.id}/acceleratorAccountList;acceleratorAccountListCurrentPage=${page.pageNumber}/' class='page-action btn btn-info btn-md submit'>${page.title}</a>
</c:if>

</c:forEach>


	<table class="table table-striped">
		<thead><tr>
		<th>序号</th><th>名称</th><th>描述</th><th>动作链接</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.acceleratorAccountList}">
				<tr><td><a class="link-action" href="#acceleratorAccountManager/loadAcceleratorAccountDetail/${item.id}/"> ${item.id}</a></td>
<td>${item.name}</td><td>${item.description}</td><td>${item.actionLink}</td></tr>
			</c:forEach>
		
		</tbody>
	</table>	
	
		
		
</div></c:if>


