
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page import='com.caucho.server.connection.AbstractHttpResponse,
	com.caucho.server.http.HttpResponse'%>

<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<%
String jspFileName = null;
{
	AbstractHttpResponse respWrapper = (AbstractHttpResponse)response;
	HttpResponse httpResponse = (HttpResponse)respWrapper.getResponse();
	
   // 设置 name 和 url cookie 
   Cookie jwt = new Cookie("Authorization", httpResponse.getHeader("Authorization"));
   // 设置cookie过期时间为7*24小时。
   jwt.setMaxAge(60*60*24*7); 
   jwt.setPath("/");

   // 在响应头部添加cookie
   httpResponse.addCookie( jwt );
}
%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>
<c:set var="managerName" value="${userContext.ownerBeanName}"/>


<!DOCTYPE html>
<!-- saved from url=(0049)http://v4-alpha.getbootstrap.com/examples/signin/ -->
<html lang="en" slick-uniqueid="3">
<head>

	<base href="${baseURL}/" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
   
    <title>${result.pageTitle}</title>

    
    
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="bootstrap/jquery.toast.css">
    
<style type="text/css">
* {
 text-shadow: transparent 0px 0px 0px, rgba(0,0,0,0.68) 0px 0px 0px !important; 
 padding: 0;
 margin: 0;
}
body {
	display: inline-flex; 
	flex-direction: column; 
	width: 100%;  
	background: linear-gradient(to right, #000000, #ffffff);
}
a {
	margin-left: 5px;
	color: blue;
}
div {
	display: inline-block;
	position: relative;
}
.map_value_container {
    padding: 10px 20px 0px 20px;
    border: 1px solid rgba(120,120,120,0.3);
    position: relative;
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    flex: 1;
    align-content: strech;
    width: auto;
    border-radius: 10px;
	margin: 10px;
	box-shadow: 10px 5px 10px 5px rgba(0, 0, 0, 0.8);
}
.toggle1 {
	color: black !important;
	padding-right: 10px;
	padding-top: 2px;
}
<c:if test="${userContext.productEnvironment}">
.map_level_1{
	border-color: rgba(200,0,0, 0.9);
    border-width: 1px;
}
.map_level_2{
	border-color: rgba(200,0,0, 0.7);
    border-width: 1px;
}
.map_level_3{
	border-color: rgba(200,0,0, 0.5);
    border-width: 1px;
}
.map_level_4{
	border-color: rgba(200,0,0, 0.3);
    border-width: 1px;
}
.map_level_5{
	border-color: rgba(200,0,0, 0.1);
    border-width: 1px;
}
.list_row {
	padding: 10px 10px 10px -5px;
	box-shadow: 10px 5px 10px 5px rgba(200, 0, 0, 0.8);
	border-radius: 10px;
	
}
.list_row > .map_value_container {
	margin: 0px 10px;
	box-shadow: -5px -10px 10px 5px rgba(200, 0, 0, 0.8);
}
.map_value_container {
	box-shadow: 10px 5px 10px 5px rgba(200, 0, 0, 0.8);
}
</c:if>

<c:if test="${not userContext.productEnvironment}">
/*
.map_level_1{
 	border-color: rgba(200,200,200, 0.9);
    border-width: 1px;
}
.map_level_2{
 	border-color: rgba(200,200,200, 0.7);
    border-width: 1px;
}
.map_level_3{
 	border-color: rgba(200,200,200, 0.5);
    border-width: 1px;
}
.map_level_4{
 	border-color: rgba(200,200,200, 0.3);
    border-width: 1px;
}
.map_level_5{
 	border-color: rgba(200,200,200, 0.1);
    border-width: 1px;
}
*/
.list_row {
	padding: 10px 10px 10px -5px;
	box-shadow: 10px 5px 10px 5px rgba(0, 0, 0, 0.8);
	border-radius: 10px;
	
}
.list_row > .map_value_container {
	margin: 0px 10px;
	box-shadow: -5px -10px 10px 5px rgba(0, 0, 0, 0.8);
}
</c:if>

.kv_row {
	position: relative;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    flex: 1;
    align-content: strech;
    width: 100%;
    padding-top: 10px;
    border-bottom: 1px dotted rgba(248,248,248,0.4);
}
.kv_row:last-child {
	border-bottom: none;
	margin-bottom: 10px;
}
.kv_row.map_row {
	border-bottom: none;
}
.map_value_title, .list_value_title {
	padding-left: 0px;
	font-weight: 600;
	color: white;
	margin-left: 20px;
}
.list_value_title {
	font-style: italic;
	margin-left: 2px;
}
.common_value_content { 
	flex: 1;
	text-align: right;
	color: black;
	font-family: Avenir;
	color-adjust: exact;
	word-wrap: break-word;
	word-break: break-all;		
}

.empty_value_container {
	margin-left: 20px;
}
.kv_row.list_row { 
	flex-direction: column;
}
.kv_row.map_row { 
	flex-direction: column;
}
.toggle_show_flag {
    position: absolute;
	display: inline-block;
	top: 0px;
	right: 0px;
	height: 10px;
	padding-left: 5px;
	font-size: 12px;
	color: white;
	max-width: 20px;
}
.cascaded_div {
	height: 5px;
	overflow-y: hidden;
	flex: unset !important;
}
.kv_row > .toggle_show_flag {
	display: inline-block;
    position: relative;
	top: -15px;
	left: 0px;
}
.kv_row.list_row > .toggle_show_flag {
	display: inline-block;
    position: absolute;
	top: 12px;
	left: 0px;
}
.kv_row.cascaded_div {
	height: 20px;
}
.list_row.cascaded_div {
	height: 15px;
}
.image_value {
	width: 128px;
	height: 128px;
}
.jq-toast-wrap {
	width:unset;
}
.item_count {
	/* display: none; */
	/* float: right; */
	padding-left: 10px;
	color: gray;
}
.form-container {
	display: block;
	width: 90%;
	color: white;
}
.form-container > form > div {
	display: flex;
	padding: 5px;
	flex-direction: row;
	color: gray;
}
.form-container > form > div > lable {
	font-weight: 600;
	padding-right: 20px;
	font-size: 18px;
	border: none;
	padding: 2px 5px;
	color: white;
}
.form-container > form > div > input {
	flex: 1;
	background:-webkit-linear-gradient(60deg,rgba(210,210,210,1), rgba(250,250,250,1) 25%,#dbdadb);
	font-size: 18px;
	border: none;
	padding: 2px 5px;
}
.form-container > form > button {
	border: none;
	background-color: gray;
	color: black;
	padding: 12px 22px;
	height: 38px;
	border-radius: 10px;
	font-size: 14px;
	line-height: 14px;
	margin: 20px 10px 0px 10px;
}
.candidate_values {
	margin: 5px;
	margin-left: 20px;
	border: 1px solid #ededed;
	color: #44fcd4 !important;
}
.class_name {
	color: #4e055c;
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
.menu {
	display: block;
	width: 100%;
}
.common_value_title {
	font-family: Mishafi;
	color: white;
}
.closed {
	color: gray !important;
}
.list_container {
	margin-bottom: 10px;
	margin-left: 20px;
}

</style>
</head>
<body>
<c:if test="${not userContext.productEnvironment or true}">
<style>
.message_for_product_env {
	display: none;
	flex-direction: row;
}
</style>
<div style=" width: 100%; position: relative; background: white;">
	<div class="div_fw">
		<div class="div_fw_left">
			[<span ondblclick="handleDbClick(this)" class="class_name"><%
			AbstractHttpResponse respWrapper = (AbstractHttpResponse)response;
			HttpResponse httpResponse = (HttpResponse)respWrapper.getResponse();
			out.write(httpResponse.getHeader("X-Class"));
			jspFileName = httpResponse.getHeader("X-Class").replace('.','/');
			pageContext.setAttribute("jspFileName", jspFileName);
			%></span>]
		</div>
	<% if (httpResponse.getHeader("x-actor-class") != null && !httpResponse.getHeader("x-actor-class").equals(httpResponse.getHeader("X-Class"))) {
		jspFileName = httpResponse.getHeader("x-actor-class").replace('.','/');
		pageContext.setAttribute("jspFileName", jspFileName);
	%>
		<div class="div_fw_right">
			powered by[<span ondblclick="handleDbClick(this)" class="class_name" style="color:gray;"><%out.write(httpResponse.getHeader("x-actor-class"));%></span>]
		</div>
	<%}%>
	</div>
<%@include file="DevHeaderBar.jsp"%> 
<form id="form4submit" method="post" enctype="application/x-www-form-urlencoded">
	<input name="formData" type="text" style="width: 100%;" id="input4submitFormData"/>
</form>
</div>
<%
java.util.Map result = (java.util.Map)request.getAttribute("result");
com.terapico.utils.DebugUtil.renderHashMap(com.terapico.utils.DebugUtil.toMap(result,httpResponse.getHeader("X-Class")), out, 1);
%>
</c:if>
<div class="message_for_product_env">
此页面仅用于测试环境。生产环境请使用APP。
</div>
<div>
	<div id="copy_buffer"></div>
</div>
<script src="bootstrap/jquery.min.js"></script>
<script src="bootstrap/jquery-ui.min.js"></script>
<script src="bootstrap/jquery.toast.js"></script>
<script type="text/javascript">
function toggleShow(elem) {
	$(elem).parent().toggleClass("cascaded_div");
	if ($(elem).parent().hasClass("cascaded_div")) {
		$(elem).html("<i class=\"fa fa-folder-o\"></i>");
		$(elem).addClass("closed");
	}else{
		$(elem).html("<i class=\"fa fa-folder-open-o\"></i>");
		$(elem).removeClass("closed");
	}
}

function gotoAnchor(name) {
	
	var curElem = $("a[name='"+name+"']");
	console.log("now its " + curElem[0].tag);
	while(curElem.prop("tagName") != "BODY") {
		if (curElem.hasClass("cascaded_div")) {
			curElem.removeClass("cascaded_div");
		}
		curElem = $(curElem).parent();
	}

	setTimeout(function() {
		document.location.hash=name;
	}, 100);
}
function handleDbClick(elem){
	// window.clipboardData.setData("Text",$(elem).text());
	// $(elem).select(false);
	// var element = $("#copy_buffer");
 	// element.text($(elem).text());
 	// element.focus();
 	// element.select();
 	// document.execCommand("copy")

	// showToast($(elem).text());
	fallbackCopyTextToClipboard($(elem).text());
	$.toast({text:$(elem).text(), loader:false});
}
function showToast(strValue) {
	alert(strValue);
}
function fallbackCopyTextToClipboard(text) {
  var textArea = document.createElement("textarea");
  textArea.value = text;
  document.body.appendChild(textArea);
  textArea.focus();
  textArea.select();

  try {
    var successful = document.execCommand('copy');
    var msg = successful ? 'successful' : 'unsuccessful';
    console.log('Fallback: Copying text command was ' + msg);
  } catch (err) {
    console.error('Fallback: Oops, unable to copy', err);
  }

  document.body.removeChild(textArea);
}
function formButtonClicked(btnElem){
	var form = $(btnElem).closest("form");
	var data={};
	// $(form).serializeArray().map(function(x){
	//	alert(x);
	//	data[x.name]=x.value;
	//	});
	$(form).find("input").map(function (n,x) {
		switch($(x).data("type")) {
			case "image":
			case "images":
				if (x.value) {
					if (isJSON(x.value)) {
						data[x.name] = JSON.parse(x.value);
						break;
					}
					var valueAsArray = x.value.split(/;\s*/);
					var wrapperArray = new Array();
					for ( var i=0 ; i < valueAsArray.length ; ++i ){
						wrapperArray.push({imageUrl:valueAsArray[i]});
					}
					data[x.name]=wrapperArray;
				}
				break;
			case "boolean":
				data[x.name]=x.value;
				break;
			default:
				if (x.value) {
					data[x.name]=x.value;
				}
		}
	});
	if (!confirm(JSON.stringify(data))){
		return;
	}
	var actionUrl = "${pageContext.request.contextPath}/${managerName}/"+$(btnElem).data("url");
	if (actionUrl.indexOf(":") != -1){
		// 说明有 uri/method/:param/ 这样的, 直接用form里的值替代
		for(var paramName in data) {
			if (actionUrl.indexOf(":"+paramName) != 1) {
				actionUrl = actionUrl.replace(":"+paramName, data[paramName]);
			}
		}
		alert("will goto "+actionUrl);
		window.location.assign(actionUrl);
		return;
	}
	
	$("#input4submitFormData").val(JSON.stringify(data));
	$("#form4submit")[0].action = actionUrl;
	$("#form4submit")[0].submit();
}

function isJSON(str) {
    if (typeof str == 'string') {
        try {
            var obj=JSON.parse(str);
            if(typeof obj == 'object' && obj ){
                return true;
            }else{
                return false;
            }

        } catch(e) {
            console.log('error：'+str+'!!!'+e);
            return false;
        }
    }
    console.log('It is not a string!')
}

/*
$('a').click(function(){
  var linkToUrl = $(this).attr("href"); 
  
  return false;
}); 
*/
</script>
<c:if test="${not empty result.token}">
<script type="text/javascript">
localStorage.setItem("jwtToken","${result.token}")
</script>
</c:if>
<div>
<sky:include page="${jspFileName }_plugin.jsp" />
</div>
</body>


</html>
