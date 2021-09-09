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
<section><h3>双链小超城市服务中心(${result.id})</h3><table >
<tr><td class='th'>名称</td><td >${result.name}</td><td class='th'>成立</td><td ><fmt:formatDate pattern="yyyy-MM-dd" value="${result.founded}" /></td></tr><tr><td class='th'>属于</td><td >${result.belongsTo.displayName}</td><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${result.lastUpdateTime}" /></td></tr></table>
</section>
<section><c:if test="${not empty result.cityPartnerList}">
<section><h3>城市合伙人</h3>
<table><tr>
<tr>
<th>ID</th><th>名称</th><th>手机</th><th>城市服务中心</th><th>描述</th><th>更新于</th></tr>	<c:forEach items="${result.cityPartnerList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.name}</td><td>${item.mobile}</td><td>${item.cityServiceCenter.displayName}</td><td>${item.description}</td><td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.potentialCustomerList}">
	<c:forEach items="${result.potentialCustomerList}" var="item">
<section><h3>潜在的客户(${item.id})</h3><table >
<tr><td class='th'>名称</td><td >${item.name}</td><td class='th'>手机</td><td >${item.mobile}</td></tr><tr><td class='th'>城市服务中心</td><td >${item.cityServiceCenter.displayName}</td><td class='th'>城市合伙人</td><td >${item.cityPartner.displayName}</td></tr><tr><td class='th'>描述</td><td >${item.description}</td><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td></tr></table>
</section>
</c:forEach></c:if><c:if test="${not empty result.cityEventList}">
<section><h3>城市活动</h3>
<table><tr>
<tr>
<th>ID</th><th>名称</th><th>手机</th><th>城市服务中心</th><th>描述</th><th>更新于</th></tr>	<c:forEach items="${result.cityEventList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.name}</td><td>${item.mobile}</td><td>${item.cityServiceCenter.displayName}</td><td>${item.description}</td><td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.retailStoreList}">
	<c:forEach items="${result.retailStoreList}" var="item">
<section><h3>双链小超(${item.id})</h3><table >
<tr><td class='th'>名称</td><td >${item.name}</td><td class='th'>电话</td><td >${item.telephone}</td></tr><tr><td class='th'>业主</td><td >${item.owner}</td><td class='th'>城市服务中心</td><td >${item.cityServiceCenter.displayName}</td></tr><tr><td class='th'>成立</td><td ><fmt:formatDate pattern="yyyy-MM-dd" value="${item.founded}" /></td><td class='th'>纬度</td><td >${item.latitude}</td></tr><tr><td class='th'>经度</td><td >${item.longitude}</td><td class='th'>描述</td><td >${item.description}</td></tr><tr><td class='th'>更新于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastUpdateTime}" /></td><td class='th'></td><td ></td></tr></table>
</section>
</c:forEach></c:if></section>
