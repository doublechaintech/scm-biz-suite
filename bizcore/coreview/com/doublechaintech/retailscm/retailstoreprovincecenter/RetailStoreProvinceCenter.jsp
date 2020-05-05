<%@ page import='java.util.*,com.doublechaintech.retailscm.*,com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter'%>

<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<!DOCTYPE html>
<html lang="en" slick-uniqueid="3"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="${baseURL}/" />    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
   
    <title>  ${userContext.localeMap['@system_name']} </title>

    <!-- Bootstrap core CSS -->
    <link href="./bootstrap/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="./bootstrap/ie10-viewport-bug-workaround.css" rel="stylesheet">
 	<link href="./bootstrap/jquery-ui.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="./bootstrap/dashboard.css" rel="stylesheet">
    <link href="./bootstrap/font-awesome.min.css" rel="stylesheet">
   
   

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
      
        <div class="col-xs-12 col-sm-12  col-md-12  main">
          
          <div class="table-responsive" id="content">
          <!-- real content -->

<c:set var="ownerBeanName" value="retailStoreProvinceCenter" scope="request"/>
<c:set var="ownerClassName" value="RetailStoreProvinceCenter" scope="request"/>




<div id="msg"></div>

<div class="row">

	<div class="col-xs-12 col-md-12">
			    <c:if test="${not empty result.errorMessageList}" >
    <ul>
    	<c:forEach var="item" items="${result.errorMessageList}">
    		
    		<div class="alert alert-success">
   ${item.sourcePosition} ${item.body}
</div>
    	</c:forEach>
    	</ul>
    </c:if>
</div>



</div> <!--<div class="row">-->

<div class="row">
	
</div>

<div class="row">
	
	<div class="col-xs-12 col-md-12">

	<ul class="nav nav-tabs" id="navi-tabs">
	  <li class="active"><a data-toggle="tab" href="#summary" class="disabled"><i class="fa  fa-home"></i> ${userContext.localeMap['@summary']}</a></li>
	 
	<% RetailStoreProvinceCenter result = (RetailStoreProvinceCenter)request.getAttribute("result");  %>
			<li><a data-toggle="tab" href="#provinceCenterDepartmentList" class="disabled"> ${userContext.localeMap['province_center_department']}</a></li>
			<li><a data-toggle="tab" href="#provinceCenterEmployeeList" class="disabled"> ${userContext.localeMap['province_center_employee']}</a></li>
			<li><a data-toggle="tab" href="#retailStoreCityServiceCenterList" class="disabled"> ${userContext.localeMap['retail_store_city_service_center']}</a></li>
 
	</ul>
	</div>
</div>
<div class="tab-content"  id='tab-content'>
<div id="summary" class="tab-pane fade in active">
<div class="row">
	
	<div class="col-xs-12 col-md-12">
	
	</div>
</div>

<div class="row" desc="show parent objects">
	
	   
	<c:set var="retailStoreProvinceCenter" value="${ result}" scope="request" />
<sky:include page="com/doublechaintech/retailscm/retailstoreprovincecenter/RetailStoreProvinceCenter$Summary.jsp" />

	
</div>

	
	

	<div class="row">
<c:set var="retailStoreCountryCenter" value="${ result.country}" scope="request" />
<c:set var="referName" value="(country)" scope="request" />
<sky:include page="com/doublechaintech/retailscm/retailstorecountrycenter/RetailStoreCountryCenter$Info.jsp" />

</div>








	





	</div><!-- end of <div id="summary" class="tab-pane fade in active">-->

	

		<c:if test='${not empty userContext.accessTokens["provinceCenterDepartmentList"] or ignoreListAccessControl}'>
		<c:set var="provinceCenterDepartmentList" value="${result.provinceCenterDepartmentList}" scope="request"/>
		<c:set var="provinceCenterDepartmentListName" value="provinceCenterDepartmentList" scope="request"/>
		<div id="provinceCenterDepartmentList" class="tab-pane fade sublist" refer-name="province_center">
			<sky:include page="com/doublechaintech/retailscm/provincecenterdepartment/ProvinceCenterDepartment$List.jsp"
					referName="provinceCenter"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["provinceCenterEmployeeList"] or ignoreListAccessControl}'>
		<c:set var="provinceCenterEmployeeList" value="${result.provinceCenterEmployeeList}" scope="request"/>
		<c:set var="provinceCenterEmployeeListName" value="provinceCenterEmployeeList" scope="request"/>
		<div id="provinceCenterEmployeeList" class="tab-pane fade sublist" refer-name="province_center">
			<sky:include page="com/doublechaintech/retailscm/provincecenteremployee/ProvinceCenterEmployee$List.jsp"
					referName="provinceCenter"/>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["retailStoreCityServiceCenterList"] or ignoreListAccessControl}'>
		<c:set var="retailStoreCityServiceCenterList" value="${result.retailStoreCityServiceCenterList}" scope="request"/>
		<c:set var="retailStoreCityServiceCenterListName" value="retailStoreCityServiceCenterList" scope="request"/>
		<div id="retailStoreCityServiceCenterList" class="tab-pane fade sublist" refer-name="belongs_to">
			<sky:include page="com/doublechaintech/retailscm/retailstorecityservicecenter/RetailStoreCityServiceCenter$List.jsp"
					referName="belongsTo"/>
		</div>
	</c:if>

	

</div><!--<div class="tab-content" style="padding-top: 10px">-->




 <!-- /real content -->
          
          
          </div>
        </div><!--  <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"> -->
        </div><!-- <div class="row"> -->
        </div>
        
  
<div id="footer">
  <div class="col-xs-12 navbar-inverse navbar-fixed-bottom">
  <div class="row" id="bottomNav">
    <div class="col-xs-3 text-center">
    	<a href="./secUserManager/home/"><i class="glyphicon glyphicon-home"></i><br/>${userContext.localeMap['@home_page']}</a>
    </div>
    <div class="col-xs-3 text-center">
    	<a href="./secUserManager/home/"><i class="glyphicon glyphicon-envelope"></i><br>${userContext.localeMap['@message']}</a>
    </div>
    <div class="col-xs-3 text-center">
    	<a href="./secUserManager/home/"><i class="glyphicon glyphicon-envelope"></i><br>${userContext.localeMap['@message']}</a>
    </div>
    <div class="col-xs-3 text-center">
    	<a href="./secUserManager/showlogin/">
    	<i class="glyphicon glyphicon-user"></i><br>${userContext.localeMap['@log_out']}</a>
    </div>
  </div>
  </div>
</div>   <!-- --><!-- /.footer -->
        
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
 	$("a[data-toggle='tab']").removeClass("disabled");
 	
	
</script>
     <script src="./scripts/common.js" type="text/javascript"></script>
     <script src="./bootstrap/bootstrap3-typeahead.js" type="text/javascript"></script>


</body></html>


