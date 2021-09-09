<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page import='com.caucho.server.connection.AbstractHttpResponse,
	com.caucho.server.http.HttpResponse'%>

<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<%

	AbstractHttpResponse respWrapper = (AbstractHttpResponse)response;
	HttpResponse httpResponse = (HttpResponse)respWrapper.getResponse();
	
   // 设置 name 和 url cookie 
   Cookie jwt = new Cookie("Authorization", httpResponse.getHeader("Authorization"));
   // 设置cookie过期时间为7*24小时。
   jwt.setMaxAge(60*60*24*7); 
   jwt.setPath("/");

   // 在响应头部添加cookie
   httpResponse.addCookie( jwt );

%>
<fmt:setLocale value="zh_CN"/>
<c:set var="managerName" value="ucService"/>


<!DOCTYPE html>
<!-- saved from url=(0049)http://v4-alpha.getbootstrap.com/examples/signin/ -->
<html lang="en" slick-uniqueid="3">
<head>

	<base href="${baseURL}/${managerName}/" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
   
    <title>${result.pageTitle}</title>

    
    
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../bootstrap/jquery.toast.css">
 	<style>
 	#show_body_window {
 		width: 400px; 
 		border: 1px solid gray;
 	}
 	a {
 		color: inherit;
 		text-decoration:none;
 	}

.slide_container {
	height: 245px;
	display: flex;
	flex-direction: rows;
	width: 100%;
	overflow-x: default;
	overflow-y: hidden;
}
.slide_container .slide {
	display: inline-block;
	padding: 0;
	margin: 0;
	height: 100%;
	width: 400px;
}
.slide img {
	padding: 0;
	margin: 0;
	height: 100%;
	width: 400px;
}
.div_fw {
	flex: 1;
	display: flex;
	flex-direction: row;
	justify-content: space-between;
	
}
.div_fw_left {
}
.div_fw_right {
}
 	</style>
</head>
<body>
<div class="div_fw">
		<div class="div_fw_left">
			[<span ondblclick="handleDbClick(this)" class="class_name"><%
			out.write(httpResponse.getHeader("X-Class"));
			%></span>]
		</div>
	<% if (httpResponse.getHeader("x-actor-class") != null && !httpResponse.getHeader("x-actor-class").equals(httpResponse.getHeader("X-Class"))) {%>
		<div class="div_fw_right">
			powered by[<span ondblclick="handleDbClick(this)" class="class_name" style="color:gray;"><%out.write(httpResponse.getHeader("x-actor-class"));%></span>]
		</div>
	<%}%>
	</div>
<%@include file="/customview/java/util/DevHeaderBar.jsp"%> 
<form id="form4submit" method="post" enctype="application/x-www-form-urlencoded">
	<input name="formData" type="text" style="width: 100%;" id="input4submitFormData"/>
</form>
<div id="show_body_window">