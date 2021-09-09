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
<section><h3>供应商的产品(${result.id})</h3><table >
<tr><td class='th'>品名</td><td >${result.productName}</td><td class='th'>产品描述</td><td >${result.productDescription}</td></tr><tr><td class='th'>产品单元</td><td >${result.productUnit}</td><td class='th'>供应商</td><td >${result.supplier.displayName}</td></tr></table>
</section>
<section><c:if test="${not empty result.productSupplyDurationList}">
<section><h3>产品供应时间</h3>
<table><tr>
<tr>
<th>ID</th><th>数量</th><th>持续时间</th><th>价格</th><th>产品</th></tr>	<c:forEach items="${result.productSupplyDurationList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.quantity}</td><td>${item.duration}</td><td>${item.price}</td><td>${item.product.displayName}</td></tr></c:forEach></table>
</section>
</c:if></section>
