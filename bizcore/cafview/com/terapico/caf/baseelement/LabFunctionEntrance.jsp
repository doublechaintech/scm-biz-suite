
<%@ page import='java.util.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<fmt:setLocale value="zh_CN"/>
<c:set var="ownerBeanName" value="secUser" scope="request"/>
<c:set var="ownerClassName" value="SecUser" scope="request"/>

<!DOCTYPE html>
<html lang="en">

<head>
	<base href="${baseURL}/" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>身份验证</title>

    <!-- Bootstrap Core CSS -->
    <link href="./bootstrap/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./bootstrap/signin.css" rel="stylesheet">
    <!-- Custom CSS -->
     <link href="./bootstrap/sec-user.css" rel="stylesheet">
     <link href="./bootstrap/font-awesome.min.css" rel="stylesheet">
    <script src="./scripts/modernizr.min.js" type="text/javascript"></script>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<style>
body {
	margin: 0;
	padding: 0;
}
.table_name {
	font-size: 20px;
	color: #881010;
}

.table_element {
    border-collapse: collapse;
    border: none;
    width: 100%;
    padding: 10px 20px;
}
.table_element th {
    border: solid #000 1px;
    padding: 0px 3px;
}
.table_element td {
    border: solid #888 1px;
    padding: 0px 3px;
}

.div_form,.div_infor{
	margin: 20px;
	padding: 20px;
}
form {
	margin: auto;
	width: 50%;
}
.form_row {
	display: flex;
	flex-direction: row;
	margin: auto;
	font-size: 16px;
}
.form_row label {
	width: 80px;
	margin: 7px 5px 0px 5px;
	display: inline-box;
}
.form_row input {
	flex: 1;
	margin: 3px 5px;
}
.form_row button {
	width: 160px;
	margin: 3px 5px;
	border-radius: 5px;
}
.submit_button {
	display: inline-block;
	min-width: 100px;
	min-height: 32px;
	background-color: #52aaf3;
	border-radius: 20px;
	border: none;
	text-align: center;
	padding: 5px 20px;
	color: white;
	line-height: 32px;
	box-shadow: 0px 6px 13px 1px rgba(0, 0, 0, 0.28);
	margin: 2px 5px;
}
.div_infor {
	background-color: white;
	border-radius: 20px;
}
</style>
</head>

<body>
	<div class="div_infor">
		<h1>说明</h1>
		<div class="div_text">
			验证了手机后，可以进入高级管理功能页面。<br/>
			验证有效期30分钟，请在30分钟内完成管理操作,超过30分钟需要重新验证。
		</div>
	</div>

	<div class="div_form">
		<form action="${baseURL}/${result.callbackUrl}mobile/verifyCode/" method="post" target="_blank">
			<div class="form_row">
				<label>手机号</label>
				<input id="input_mobile" name="mobile" value="" placeholder="请输入手机号"/>
			</div>
			<div class="form_row">
				<label>验证码</label>
				<input id="input_vcode" name="verifyCode" value="" placeholder="请先获取验证码"/>
				<button type="button" onclick="javascript:sendVCode()">获取验证码</button>
			</div>
			<div class="form_row">
				<input type="submit" class="submit_button" value="验证身份"/>
			</div>
		</form>
	</div>

	<!-- jQuery -->
    <script src="./scripts/jquery-1.9.1.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="./bootstrap/bootstrap.min.js"></script>
<script type="text/javascript">
function sendVCode() {
	var mobileNum = $('#input_mobile').val();
	if (!mobileNum) {
		alert("请先输入手机号");
	}
	console.log("手机号:"+mobileNum);
	var url = "${baseURL}/${result.sendVCodeUrl}" + mobileNum +"/";
	$.ajax({ url: url, success: function(res){
		alert(res.toast.text);
      }});
}
</script>

</body>

</html>

