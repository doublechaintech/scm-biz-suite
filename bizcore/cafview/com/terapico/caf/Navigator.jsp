<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0043)http://getbootstrap.com/examples/dashboard/ -->
<html lang="en" slick-uniqueid="3"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<c:set var="url">${pageContext.request.requestURL}</c:set>
    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
   
    <title>${result.selectBeanName} | Spring Bean Manage Console</title>

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

  <body data-feedly-mini="yes">

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          
          <div class="navbar-brand">Spring Beans [${result.selectBeanName}] ：<input id="beans" style="color:black"/>
			
          </div>
       		

        </div>
                  
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-left">
        
         	<li></li>
          </ul>
        
          <ul class="nav navbar-nav navbar-right">
           
            <li><a href="?__logout__">Logout</a></li>
           
            
          </ul>
          
        </div>
        </div>
     
    </nav>

    <div class="container-fluid" style="padding-top: 40px;">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
        <ul id="history" class="nav nav-sidebar">
           
          </ul>
          
          <ul class="nav nav-sidebar">
               
            <c:forEach var="item" items="${result.menuItems}">
            <li ><a  href="#${item.beanName}/${item.methodName}" methodName="${item.methodName}" beanName="${item.beanName }" class="action">${item.methodName}</a></li>
            </c:forEach>
          
          </ul>
          <hr/>
          <ul class="nav nav-sidebar">
           <c:forEach var="item" items="${result.beanList}">
           		<c:if test="${fn:endsWith(item, 'Manager')}">
           			<li><a href='./navi/index/${item}/' class='bean'> ${item}</a></li>
           		</c:if>
           </c:forEach>
            
          </ul>
          
          
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          

         
          <div class="table-responsive" id="content">
		<textarea rows="30" cols="120">${result.beanExpr}</textarea>
	

          </div>
        </div>
        </div>
        </div>
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
       
    <script>
    
    $( function() {
    var availableTags = [

<c:forEach var="item" items="${result.beanList}">
"${item}",
</c:forEach>
                         
                         
    ];
    $( "#beans" ).autocomplete({
      source: availableTags
    });
    var contains = function (ele)
    {
    	for(var key in availableTags){
    		//console.log("item" + item +", ele" + ele);
    		if(availableTags[key] == ele){
    			return true;
    		}
    		
    	}
    	return false;
    }
    $("#beans").keydown(function(event){
        if(event.keyCode == 13) {
          var val =	$("#beans").val()
          if(val.length==0) {
              event.preventDefault();
              return false;
          }
          
          if(contains(val)){
        	  
        	  window.location.href = "./navi/index/"+val+"/"
        	  
          }
          
          return false;
          
          
          
        }
     });
    
    $("#beans").focus();
    
  } );
  </script>
    
  <script>

    
	$(function() {
		var cache = {};
		var prevElement;
		var toggleActive=function(element)
		{
			if(element.parent()===prevElement){
				return;
			}
			
			if(prevElement){	
				prevElement.removeClass("active");
			}
			
			element.parent().addClass("active");
			prevElement=element.parent();
			
		};
		$(".action").click(function(event) {
			
			//event.preventDefault();
			
			var methodName=$(this).attr('methodName');
			var beanName=$(this).attr('beanName');
			var parameters=$(this).attr('params');
			
			toggleActive($(this));
			
			var reqURI =  encodeURIComponent(beanName) + "/"+encodeURIComponent(methodName) +"/";
			if(parameters&&parameters.length>0){
				reqURI+=parameters;
			}
			fillResult(reqURI,"#content");
			
		})
		$("#history").on("click", ".history-action",function(event) {
			
			//event.preventDefault();
			
			var link=$(this).attr('href');
			var index=link.indexOf("#");
			if(index<0){
				return;
			}
			
			var reqLink=link.substring(index+1);
			
			console.log("ready!")
			fillResult(reqLink,"#content");
			
		});

	});

	$(document).ready(function() {
		//alert($(location).attr('href'));
		var currentURL=$(location).attr('href');
		var index=currentURL.indexOf("#");
		if(index<0){
			return;
		}
		
		var methodName=currentURL.substring(index+1);
		//reqURI =  encodeURIComponent(methodName) + "/";		
		reqURI =  methodName + "/";		
		console.log("ready!")
		fillResult(reqURI,"#content");
		
		
	});
</script>



</body></html>
