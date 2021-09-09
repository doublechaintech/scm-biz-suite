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
<section><h3>残次货物存放区(${result.id})</h3><table >
<tr><td class='th'>位置</td><td >${result.location}</td><td class='th'>联系电话</td><td >${result.contactNumber}</td></tr><tr><td class='th'>总面积</td><td >${result.totalArea}</td><td class='th'>纬度</td><td >${result.latitude}</td></tr><tr><td class='th'>经度</td><td >${result.longitude}</td><td class='th'>仓库</td><td >${result.warehouse.displayName}</td></tr><tr><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${result.lastUpdateTime}" /></td><td class='th'></td><td ></td></tr></table>
</section>
<section><c:if test="${not empty result.goodsShelfList}">
<section><h3>货架</h3>
<table><tr>
<tr>
<th>ID</th><th>位置</th><th>存货区</th><th>供应商的空间</th><th>残次货物存放区</th><th>更新于</th></tr>	<c:forEach items="${result.goodsShelfList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.location}</td><td>${item.storageSpace.displayName}</td><td>${item.supplierSpace.displayName}</td><td>${item.damageSpace.displayName}</td><td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td></tr></c:forEach></table>
</section>
</c:if></section>
