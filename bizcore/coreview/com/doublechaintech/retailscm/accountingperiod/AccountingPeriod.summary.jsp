<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>



<style>
	
	table{
	  border: 1px solid black;
	  border-collapse: collapse;
	  width: 100%;
	  font-size: 12px;
	  padding: 5px;
	}
	th {
	  border: 1px solid black;
	  border-collapse: collapse;
	  font-size: 12px;
	  padding: 5px;
	  text-align: center;
	  background-color: lightgray;
	}
	td {
	  border: 1px solid black;
	  border-collapse: collapse;
	  
	  font-size: 10px;
	  padding-left: 5px;
	}
	
	/**/
	.table ,.tbody {
		all:unset;
		border: 1px solid black;
		
		width:100%;
	}

	.tr {
		all:unset;
		
		width: 25%;
	}

	.td {
		border: 1px solid red;
		border:initial;
		all:unset;
		text-align: justify;
		
		outline: none;
		font-size: 10px;
	  	padding: 5px;
		background-color: darkblue;
		word-break: break-all;
		
	}
	.th {
		width:"80px";
		background-color: lightgray;

		font-size: 10px;
		font-family: "Gill Sans Extrabold", sans-serif;
		padding: 5px;
		text-align: left;
		word-break: break-all;		
	}
	
</style>
<section><h3>会计期间(${result.id})</h3><table >
<tr><td class='th'>名称</td><td >${result.name}</td><td class='th'>开始日期</td><td ><fmt:formatDate pattern="yyyy-MM-dd" value="${result.startDate}" /></td></tr><tr><td class='th'>结束日期</td><td ><fmt:formatDate pattern="yyyy-MM-dd" value="${result.endDate}" /></td><td class='th'>账套</td><td >${result.accountSet.displayName}</td></tr></table>
</section>
<section><c:if test="${not empty result.accountingDocumentList}">
<section><h3>会计凭证</h3>
<table><tr>
<tr>
<th>ID</th><th>名称</th><th>会计凭证日期</th><th>会计期间</th><th>文档类型</th></tr>	<c:forEach items="${result.accountingDocumentList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.name}</td><td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.accountingDocumentDate}" /></td><td>${item.accountingPeriod.displayName}</td><td>${item.documentType.displayName}</td></tr></c:forEach></table>
</section>
</c:if></section>
