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
<section><h3>应用(${result.id})</h3><table >
<tr><td class='th'>标题</td><td >${result.title}</td><td class='th'>系统用户</td><td >${result.secUser.displayName}</td></tr><tr><td class='th'>图标</td><td >${result.appIcon}</td><td class='th'>完全访问</td><td >${result.fullAccess}</td></tr><tr><td class='th'>权限</td><td >${result.permission}</td><td class='th'>对象类型</td><td >${result.appType}</td></tr><tr><td class='th'>对象ID</td><td >${result.appId}</td><td class='th'>上下文类型</td><td >${result.ctxType}</td></tr><tr><td class='th'>上下文类型</td><td >${result.ctxId}</td><td class='th'>位置</td><td >${result.location}</td></tr></table>
</section>
<section><c:if test="${not empty result.quickLinkList}">
	<c:forEach items="${result.quickLinkList}" var="item">
<section><h3>快速链接(${item.id})</h3><table >
<tr><td class='th'>名称</td><td >${item.name}</td><td class='th'>图标</td><td >${item.icon}</td></tr><tr><td class='th'>图片路径</td><td >${item.imagePath}</td><td class='th'>链接的目标</td><td >${item.linkTarget}</td></tr><tr><td class='th'>创建于</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.createTime}" /></td><td class='th'>应用程序</td><td >${item.app.displayName}</td></tr></table>
</section>
</c:forEach></c:if><c:if test="${not empty result.listAccessList}">
	<c:forEach items="${result.listAccessList}" var="item">
<section><h3>列表访问控制(${item.id})</h3><table >
<tr><td class='th'>名称</td><td >${item.name}</td><td class='th'>内部名称</td><td >${item.internalName}</td></tr><tr><td class='th'>可读</td><td >${item.readPermission}</td><td class='th'>可创建</td><td >${item.createPermission}</td></tr><tr><td class='th'>可删除</td><td >${item.deletePermission}</td><td class='th'>可更新</td><td >${item.updatePermission}</td></tr><tr><td class='th'>可执行</td><td >${item.executionPermission}</td><td class='th'>应用</td><td >${item.app.displayName}</td></tr></table>
</section>
</c:forEach></c:if></section>
