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
<section><h3>页面(${result.id})</h3><table >
<tr><td class='th'>页面标题</td><td >${result.pageTitle}</td><td class='th'>链接网址</td><td >${result.linkToUrl}</td></tr><tr><td class='th'>页面类型</td><td >${result.pageType.displayName}</td><td class='th'>顺序</td><td >${result.displayOrder}</td></tr></table>
</section>
<section><c:if test="${not empty result.slideList}">
	<c:forEach items="${result.slideList}" var="item">
<section><h3>轮播内容(${item.id})</h3><table >
<tr><td class='th'>名称</td><td >${item.name}</td><td class='th'>顺序</td><td >${item.displayOrder}</td></tr><tr><td class='th'>图片链接</td><td >${item.imageUrl}</td><td class='th'>视频网址</td><td >${item.videoUrl}</td></tr><tr><td class='th'>链接网址</td><td >${item.linkToUrl}</td><td class='th'>页面</td><td >${item.page.displayName}</td></tr></table>
</section>
</c:forEach></c:if><c:if test="${not empty result.uiActionList}">
	<c:forEach items="${result.uiActionList}" var="item">
<section><h3>用户界面操作(${item.id})</h3><table >
<tr><td class='th'>代码</td><td >${item.code}</td><td class='th'>图标</td><td >${item.icon}</td></tr><tr><td class='th'>头衔</td><td >${item.title}</td><td class='th'>顺序</td><td >${item.displayOrder}</td></tr><tr><td class='th'>短暂的</td><td >${item.brief}</td><td class='th'>图片链接</td><td >${item.imageUrl}</td></tr><tr><td class='th'>链接网址</td><td >${item.linkToUrl}</td><td class='th'>额外的数据</td><td >${item.extraData}</td></tr><tr><td class='th'>页面</td><td >${item.page.displayName}</td><td class='th'></td><td ></td></tr></table>
</section>
</c:forEach></c:if><c:if test="${not empty result.sectionList}">
	<c:forEach items="${result.sectionList}" var="item">
<section><h3>板块(${item.id})</h3><table >
<tr><td class='th'>头衔</td><td >${item.title}</td><td class='th'>短暂的</td><td >${item.brief}</td></tr><tr><td class='th'>图标</td><td >${item.icon}</td><td class='th'>顺序</td><td >${item.displayOrder}</td></tr><tr><td class='th'>视图组</td><td >${item.viewGroup}</td><td class='th'>链接网址</td><td >${item.linkToUrl}</td></tr><tr><td class='th'>页面</td><td >${item.page.displayName}</td><td class='th'></td><td ></td></tr></table>
</section>
</c:forEach></c:if></section>
