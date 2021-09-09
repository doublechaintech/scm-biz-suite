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
<c:set var="ownerBeanName" value="platformManager" scope="request"/>
<c:set var="ownerClassName" value="PlatformCustomManagerImpl" scope="request"/>

<!DOCTYPE html>
<html lang="en">

<head>
	<base href="${baseURL}/" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>功能实验室</title>

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
.input-group-addon label {
	padding: 0px 5px;
	min-width: 80px;
}

.submit_button {
	display: inline-block;
	min-width: 100px;
	min-height: 32px;
	border-bottom-left-radius: 4px;
	border-bottom-right-radius: 15px;
	border-top-left-radius: 15px;
	border-top-right-radius: 4px;
	background-color: rgb(155, 224, 75);
	border: none;
	text-align: center;
	padding: 5px 20px;
	color: black;
	line-height: 32px;
	box-shadow: rgba(255, 254, 255, 0.6) 0px 7px 7px 0px inset, rgba(0, 0, 0, 0.14902) 0px -2px 7px 0px inset, rgb(107, 174, 30) 0px 2px 3px 0px, rgb(80, 130, 23) 0px 7px 1px 0px, rgba(0, 0, 0, 0.2) 0px 12px 5px 0px;
	margin: 2px 5px;
}
.div_functions {
	margin: 10px;
	padding: 10px;
	// background-color: white;
}
.function_card {
	display: inline-block;
	min-width: 200px;
	min-height: 63px;
	padding: 20px;
	margin: 20px 10px;
	background-color: gray;
	box-shadow: rgba(255, 254, 255, 0.6) 0px 7px 7px 0px inset, rgba(0, 0, 0, 0.14902) 0px -2px 7px 0px inset, rgb(107, 174, 30) 0px 2px 3px 0px, rgb(80, 130, 23) 0px 7px 1px 0px, rgba(0, 0, 0, 0.2) 0px 12px 5px 0px;
	border-bottom-left-radius: 8px;
	border-bottom-right-radius: 28px;
	border-top-left-radius: 28px;
	border-top-right-radius: 8px;
	background-color: rgb(155, 224, 75);
}
.function_card_header {
	font-size: 19px;
}
.function_card_header > label{
	color: white;
  	text-shadow: 1px 1px rgba(97, 123, 148,0.8),2px 2px rgba(97, 123, 148,0.8),3px 3px rgba(97, 123, 148,0.8),4px 4px rgba(97, 123, 148,0.8);
}

.function_card_header .fa {
	color: white;
	font-size: 22px;
	position: relative;
	bottom: -3px;
	left: 3px;
}
.function_content {
	background-color: #e9eded;
	padding: 20px;
	border: 1px solid #236060;
	border-radius: 15px;
	width: 600px;
	position: relative;
}
.not_selected {
	display: none;
}
.selected {
	// position: absolute;
}
.close-icon {
	float: right;
	top: 3px;
	right: 3px;
	position: absolute;
	font-size: 20px;
}
pre,.invoke_result{
	max-height: 480px;
}
</style>
</head>

<body>
	<div class="div_user_info">
		当前用户：${result.curUser}
	</div>
	<form id="form4submit" method="post" enctype="application/x-www-form-urlencoded" target="_blank">
		<input name="formData" type="text" style="width: 100%;" id="input4submitFormData"/>
	</form>
	<div class="div_functions">
		<c:forEach items="${result.functions }" var="card">
			<c:if test="${card.type == 'simple'}">
				<div class="function_card" data-title="${card.title}" data-invoke-url="${card.invokeUrl}" >
					<div class="function_card_header" onclick="javascript:showMe(this, false)">
						<label>${card.title}</label>
						<i class="fa fa-play-circle-o" aria-hidden="true"></i>
					</div>
					<div class="function_content not_selected">
						<i class="fa fa-close close-icon" aria-hidden="true" onclick="javascript:closeFunction(event, this)"></i>
						<form role="form">
						<c:forEach items="${card.params}" var="ppinfo">
							<div class="input-group">
								<span class="input-group-addon">
									<label>${ppinfo.value.title}</label>
								</span>
								
								<c:if test="${ppinfo.value.type=='input' }">
									<input type="text" class="form-control" name="${ppinfo.key}"></input>
								</c:if>
								<c:if test="${ppinfo.value.type=='file' }">
                                    <input type="file" class="form-control" name="${ppinfo.key}"></input>
                                </c:if>
								<c:if test="${ppinfo.value.type=='select' }">
									<select class="form-control" name="${ppinfo.key}">
										<c:forEach items="${ppinfo.value.candidateValues}" var="candidate">
											<option value="${candidate.key}">${candidate.value}</option>
										</c:forEach>
									</select>
								</c:if>
							</div>
						</c:forEach>
						</form>
						<button onclick="javascript:invokeMe(this)" class="btn btn-primary btn-lg btn-link">执行</button>
						<div class="invoke_result"></div>
					</div>
				</div>
			</c:if>
			<c:if test="${card.type == 'form'}">
				<div class="function_card" data-title="${card.title}" data-invoke-url="${card.invokeUrl}" >
					<div class="function_card_header" onclick="javascript:showMe(this, false)">
						<label>${card.title}</label>
						<i class="fa fa-play-circle-o" aria-hidden="true"></i>
					</div>
					<div class="function_content not_selected">
						<i class="fa fa-close close-icon" aria-hidden="true" onclick="javascript:closeFunction(event, this)"></i>
						<form role="form" method="post" enctype="multipart/form-data" action="${card.invokeUrl}">
						<c:forEach items="${card.params}" var="ppinfo">
							<div class="input-group">
								<span class="input-group-addon">
									<label>${ppinfo.value.title}</label>
								</span>
								
								<c:if test="${ppinfo.value.type=='input' }">
									<input type="text" class="form-control" name="${ppinfo.key}"></input>
								</c:if>
								<c:if test="${ppinfo.value.type=='file' }">
                                    <input type="file" class="form-control" name="${ppinfo.key}"></input>
                                </c:if>
								<c:if test="${ppinfo.value.type=='select' }">
									<select class="form-control" name="${ppinfo.key}">
										<c:forEach items="${ppinfo.value.candidateValues}" var="candidate">
											<option value="${candidate.key}">${candidate.value}</option>
										</c:forEach>
									</select>
								</c:if>
							</div>
						</c:forEach>
						</form>
						<button onclick="javascript:postMe(this)" class="btn btn-primary btn-lg btn-link">执行</button>
						<div class="invoke_result"></div>
					</div>
				</div>
			</c:if>
			<c:if test="${card.type == 'haspage'}">
				<div class="function_card" data-title="${card.title}" data-invoke-url="${card.invokeUrl}" onclick="javascript:openMe(this, true)">
					<div class="function_card_header">
						<label>${card.title}</label>
						<i class="fa fa-play-circle-o" aria-hidden="true"></i>
					</div>
				</div>
			</c:if>
				
		</c:forEach>
	</div>

	<!-- jQuery -->
    <script src="./scripts/jquery-1.9.1.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="./bootstrap/bootstrap.min.js"></script>
<script type="text/javascript">
function closeFunction(event,elem) {
	event.stopPropagation();
	var tgtElem = $(elem).parents(".function_content");
	// alert(tgtElem);
    tgtElem.addClass("not_selected");
    tgtElem.removeClass("selected");
}
function showMe(elem) {
	$(".function_content").addClass("not_selected");
	$(".function_content").removeClass("selected");
	$(".invoke_result").html("");
	$(elem).parent().find(".function_content").removeClass("not_selected");
	$(elem).parent().find(".function_content").addClass("selected");
}
function invokeMe(elem) {
	var funcElem = $(elem).parents(".function_card");
	var invokeUrl = $(funcElem).data("invoke-url");
	var varNames=invokeUrl.match(/:\w+/gi);
	if (varNames){
		for (i = 0; i < varNames.length; i++) { 
			var varName = varNames[i];
			var vName = varName.substring(1);
			var value = funcElem.find("[name='"+vName+"']").val();
			invokeUrl = invokeUrl.replace(varName, value);
		}
	}
	
	// alert("call " + invokeUrl +" with " + value);
	var url="${baseURL}/"+invokeUrl;
	$.ajax({ url: url, success: function(res, stateStr, xhr){
		var xClazz = xhr.getResponseHeader("X-Class");
		if (xClazz.match(/\.Form$/)){
			alert("请填写所有参数");
			return;
		}
		if (!res.success) {
			alert(res.message);
			return;
		}
		var text = JSON.stringify(res.data, null, 4);
		var rstDiv = $(funcElem).find(".invoke_result");
		rstDiv.html("");
		var rstPre = $("<pre>");
		$(rstPre).html(text);
		rstDiv.append(rstPre);
		if (res.message){
			alert("执行成功："+res.message);
		}else{
			// alert("执行成功");
		}
      }});
}
function serializeFormJSON(form) {

        var o = {};
        var a = $(form).serializeArray();
        $.each(a, function () {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };
    
function postMe(elem) {
	var funcElem = $(elem).parents(".function_card");
	var invokeUrl = $(funcElem).data("invoke-url");
	var url="${baseURL}/"+invokeUrl+"/";
	var form = $(funcElem).find("form");


    var data=serializeFormJSON(form);
	if (!confirm(JSON.stringify(data))){
		return;
	}
	form.action = url;
    form.submit();

	
}
</script>

</body>

</html>

