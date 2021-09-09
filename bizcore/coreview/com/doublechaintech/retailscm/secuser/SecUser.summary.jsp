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
<section><h3>安全用户(${result.id})</h3><table >
<tr><td class='th'>登录名</td><td >${result.login}</td><td class='th'>手机</td><td >${result.mobile}</td></tr><tr><td class='th'>邮箱</td><td >${result.email}</td><td class='th'>密码</td><td >${result.pwd}</td></tr><tr><td class='th'>微信openId</td><td >${result.weixinOpenid}</td><td class='th'>微信应用ID</td><td >${result.weixinAppid}</td></tr><tr><td class='th'>访问令牌</td><td >${result.accessToken}</td><td class='th'>验证码</td><td >${result.verificationCode}</td></tr><tr><td class='th'>验证码有效期</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${result.verificationCodeExpire}" /></td><td class='th'>最后登录时间</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${result.lastLoginTime}" /></td></tr></table>
</section>
<section><c:if test="${not empty result.userAppList}">
	<c:forEach items="${result.userAppList}" var="item">
<section><h3>应用(${item.id})</h3><table >
<tr><td class='th'>标题</td><td >${item.title}</td><td class='th'>系统用户</td><td >${item.secUser.displayName}</td></tr><tr><td class='th'>图标</td><td >${item.appIcon}</td><td class='th'>完全访问</td><td >${item.fullAccess}</td></tr><tr><td class='th'>权限</td><td >${item.permission}</td><td class='th'>对象类型</td><td >${item.appType}</td></tr><tr><td class='th'>对象ID</td><td >${item.appId}</td><td class='th'>上下文类型</td><td >${item.ctxType}</td></tr><tr><td class='th'>上下文类型</td><td >${item.ctxId}</td><td class='th'>位置</td><td >${item.location}</td></tr></table>
</section>
</c:forEach></c:if><c:if test="${not empty result.loginHistoryList}">
<section><h3>登录历史</h3>
<table><tr>
<tr>
<th>ID</th><th>登录时间</th><th>来自IP</th><th>描述</th><th>系统用户</th></tr>	<c:forEach items="${result.loginHistoryList}" var="item">
	<tr>
<td>${item.id}</td><td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.loginTime}" /></td><td>${item.fromIp}</td><td>${item.description}</td><td>${item.secUser.displayName}</td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.wechatWorkappIdentityList}">
<section><h3>企业微信认证</h3>
<table><tr>
<tr>
<th>ID</th><th>公司</th><th>用户</th><th>系统用户</th><th>创建时间</th><th>最后登录时间</th></tr>	<c:forEach items="${result.wechatWorkappIdentityList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.corpId}</td><td>${item.userId}</td><td>${item.secUser.displayName}</td><td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.createTime}" /></td><td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastLoginTime}" /></td></tr></c:forEach></table>
</section>
</c:if><c:if test="${not empty result.wechatMiniappIdentityList}">
	<c:forEach items="${result.wechatMiniappIdentityList}" var="item">
<section><h3>微信小程序认证(${item.id})</h3><table >
<tr><td class='th'>openId</td><td >${item.openId}</td><td class='th'>应用ID</td><td >${item.appId}</td></tr><tr><td class='th'>UnionID</td><td >${item.unionId}</td><td class='th'>系统用户</td><td >${item.secUser.displayName}</td></tr><tr><td class='th'>创建时间</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.createTime}" /></td><td class='th'>最后登录时间</td><td ><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.lastLoginTime}" /></td></tr></table>
</section>
</c:forEach></c:if><c:if test="${not empty result.keyPairIdentityList}">
<section><h3>秘钥对认证</h3>
<table><tr>
<tr>
<th>ID</th><th>公钥</th><th>秘钥类型</th><th>系统用户</th><th>创建时间</th></tr>	<c:forEach items="${result.keyPairIdentityList}" var="item">
	<tr>
<td>${item.id}</td><td>${item.publicKey}</td><td>${item.keyType.displayName}</td><td>${item.secUser.displayName}</td><td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.createTime}" /></td></tr></c:forEach></table>
</section>
</c:if></section>
