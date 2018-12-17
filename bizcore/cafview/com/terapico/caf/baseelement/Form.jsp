<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>


<!DOCTYPE html>
<!-- saved from url=(0043)http://getbootstrap.com/examples/dashboard/ -->
<html lang="en" slick-uniqueid="3"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base href="${baseURL}/" /> 
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
   
    <title>  Spring Bean Manage Console</title>

    <!-- Bootstrap core CSS -->
    <link href="./bootstrap/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="./bootstrap/ie10-viewport-bug-workaround.css" rel="stylesheet">
 	<link href="./bootstrap/jquery-ui.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="./bootstrap/dashboard.css" rel="stylesheet">
   
   

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="./bootstrap/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
 <style type="text/css">* {
 text-shadow: transparent 0px 0px 0px, rgba(0,0,0,0.68) 0px 0px 0px !important; 
}

</style>


</head>

  <body >


    <div class="container-fluid">
      <div class="row">
      
      


<style>
.form {
	font-size: 20px;
}
#parameters {
	display: none;
	border: 1px solid grey; 
	width: 400px;
	height: 400px;
	overfollow:auto;
	padding-left: 20px;
	padding-right: 20px;
	background: white;
#	opacity: 0.5;
	background-color:rgba(255,255,255,0.8);
}
</style>

<div class="form">





</div>


<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">
    
    <c:forEach var="action" items="${result.actions}">
			${action.name}
		</c:forEach>
    
    </h3>
  </div>
  
  <div class="panel-body">
    <!-- parameterName="${field.name}" parameterType="${field.type.name}" autocomplete="off" -->
    <form class="mainform"  >
		<c:forEach var="field" items="${result.fields}" varStatus="status">
		<div class="col-sm-12">
			<input id="fl${status.index}" class="form-control input-sm" 
			placeHolder="${field.name}" value="${field.defaultValue}"
			title="${field.name}" type="text" append="true" />
			
		</div>
		</c:forEach>
		
		<c:forEach var="action" items="${result.actions}">
		<div class="col-sm-2">
			<input type="submit" class="btn btn-primary btn-sm action submit" value="${action.title}" action="${action.name }"  />
			 
		</div>
		</c:forEach>
		
	</form>
	<br/>
    <hr/>
    <div id="result" >  </div>
  </div>
</div>


<div id="parameters" > Parameters </div>


      
      
     
        </div><!--  <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"> -->
        </div><!-- <div class="row"> -->
        
        
      
<div id="footer">
  <div class="col-xs-12 navbar-inverse navbar-fixed-bottom">
  <div class="row" id="bottomNav">
    <div class="col-xs-3 text-center">
    	<a href="./secUserManager/home/"><i class="glyphicon glyphicon-home"></i><br/>主页</a>
    </div>
    <div class="col-xs-3 text-center">
    	<a href="./secUserManager/login/SU000002/123456/"><i class="glyphicon glyphicon-envelope"></i><br>消息</a>
    </div>
    <div class="col-xs-3 text-center">
    	<a href="./secUserManager/login/SU000002/123456/"><i class="glyphicon glyphicon-envelope"></i><br>消息</a>
    </div>
    <div class="col-xs-3 text-center">
    	<a href="./navi/index/secUserManager/#secUserManager/loadSecUserDetail/SU000002/">
    	<i class="glyphicon glyphicon-user"></i><br>我</a>
    </div>
  </div>
  </div>
</div><!-- /.footer -->
        
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="./bootstrap/jquery.min.js"></script>
    <script src="./bootstrap/jquery-ui.min.js"></script>
    
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="./bootstrap/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="./bootstrap/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="./bootstrap/ie10-viewport-bug-workaround.js"></script>
    <script src="./scripts/qrcode.js" type="text/javascript"></script>
      <script>

 	var qrLocaleLabel = "${userContext.localeMap['@qr_code']}";
 	var scanQRTips = "${userContext.localeMap['@qr_scan_to_continue']}";
	
</script>
    <script src="./scripts/common.js" type="text/javascript"></script>   
 
    

<script type="text/javascript">
	$(function() {
		var action="";
		
		$(".submit").click(function(){
			action=$(this).attr("action");
		});
		/*
		$(":input").dblclick(function(){		
			//alert("sdfsdf");	
			//$( ".parameters" ).toggle();
			
			var pos = $(this).position();

		    // .outerWidth() takes into account border and padding.
		   
		    //show the menu directly over the placeholder
		    
		    if(!$("#parameters").is(":visible")){
		    	// var width = $(this).outerWidth();
				var parameterType=$(this).attr("parameterType");
				var parameterName=$(this).attr("parameterName");
		    
		    	fillResult("suggestParameter/"+parameterType+"/"+parameterName+"/","#parameters");
		    }
		    
		    $("#parameters").css({
		        position: "absolute",
		        top: pos.top + pos.height+"px",
		        left: (pos.left) + "px",
				    overflow: "scroll"
		    }).toggle();
			
		
		});
		
		$( window ).resize(function() {
			 // $( "#log" ).append( "<div>Handler for .resize() called.</div>" );
			var currentTargetId= $("#parameters").attr("targetInputId");
			console.log(currentTargetId)	;
			var pos = $("#"+currentTargetId).position();
			 $("#parameters").css({
			        position: "absolute",
			        top: pos.top + pos.height+"px",
			        left: (pos.left) + "px",
				      overflow: "scroll"
			   });
		});
	*/
		
		var cache = {};

		$(".mainform").submit(function(event) {
			
			if(action==""){
				return;
			}
			console.log("code get here!");
			$(this).find(":input").attr("disabled", true);
			event.preventDefault();
			var parameters = "";
			var valid=true;
			$(".mainform :input").each(function() {
				//console.log("-------------"+$(this).val());
				if ($(this).val()==""){
					console.log("--eee-----------"+$(this).val());
					$(this).parent().addClass("has-error");
					//$(this).addClass("input-danger");
					valid=false;
				}
				if ($(this).attr("append") == "true") {
					parameters += encodeURIComponent($(this).val()) + "/";
				}				
			});
			if(!valid){
				$(this).find(":input").attr("disabled", false);
				return true;
			}
			var reqURI =  action + "/" + parameters;
			fillResult(reqURI,"#result");
			$(this).find(":input").attr("disabled", false);
			//$(".mainform").submit();
			//return true;
			//$(".mainform:not(.filter) :input:visible:enabled:first").val("");
		});
		//var currentTargetId="";
		 $( "form input:text" ).focus(function() {
			 
			 //currentTargetId=$(this).attr("id");
			 //console.log("form input:text clicked: "+currentTargetId)	;
			 $("#parameters").attr("targetInputId",$(this).attr("id"));
			 
		});
		
		//


	});
		
	$(document).ready(function() {
		 $(".mainform:not(.filter) :input:visible:enabled:first").focus();
		 //$(".mainform").elements().first().focus();
	
	});	
		
</script>


</body></html>





