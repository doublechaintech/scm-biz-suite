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
<section><h3>手机应用程序(${result.id})</h3><table >
<tr><td class='th'>名称</td><td >${result.name}</td><td class='th'></td><td ></td></tr></table>
</section>
<section><c:if test="${not empty result.pageList}">
<section><h3>页面</h3>
<table><tr>
<tr>
<th>ID</th><th>页面标题</th><th>链接网址</th><th>页面类型</th><th>顺序</th><th>手机应用程序</th></tr>	<c:forEach items="${result.pageList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.pageTitle}</td><td>${item.linkToUrl}</td><td>${item.pageType.displayName}</td><td>${item.displayOrder}</td><td>${item.mobileApp.displayName}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.pageTypeList}">
<section><h3>页面类型</h3>
<table><tr>
<tr>
<th>ID</th><th>名称</th><th>代码</th><th>手机应用程序</th><th>页脚选项卡</th></tr>	<c:forEach items="${result.pageTypeList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.name}</td><td>${item.code}</td><td>${item.mobileApp.displayName}</td><td>${item.footerTab}</td></tr></c:forEach></table>
</section>
</c:if></section>
