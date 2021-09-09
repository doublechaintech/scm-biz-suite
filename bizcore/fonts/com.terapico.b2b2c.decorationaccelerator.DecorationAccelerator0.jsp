

<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@page import='java.util.*,com.terapico.b2b2c.*'%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<%	BaseEntity result=(BaseEntity)request.getAttribute("result"); %>


<c:set var="ownerBeanName" value="decorationAccelerator" scope="request"/>
<c:set var="ownerClassName" value="DecorationAccelerator" scope="request"/>

<div id="msg"></div>

<div class="row">
	<ul class="nav nav-tabs" id="navi-tabs">
	  <li class="active"><a data-toggle="tab" href="#summary">jiasuqi 概览</a></li>
	  
		<li><a data-toggle="tab" href="#acceleratorAccountList">加速器账户</a></li>
		<li><a data-toggle="tab" href="#acceleratorAccountChangeList">加速器账户变化</a></li>
		<li><a data-toggle="tab" href="#decorationMemberList">装修会员</a></li>
		<li><a data-toggle="tab" href="#decorationSupplierList">装修供应商</a></li>
 
	</ul>

</div>
<div class="tab-content" style="padding-top: 10px" id='tab-content'>
<div id="summary" class="tab-pane fade in active">
<div class="row">
	
	<div class="col-xs-12 col-md-12">
	<a href='#decorationAcceleratorManager/create/${ result.id}/' class='verb-action btn btn-primary btn-md submit' beanName='decorationAccelerator' action='create'>创造</a>
<a href='#decorationAcceleratorManager/inviteInvestment/${ result.id}/' class='verb-action btn btn-success btn-md submit' beanName='decorationAccelerator' action='inviteInvestment'>招商</a>
<a href='#decorationAcceleratorManager/franchise/${ result.id}/' class='verb-action btn btn-success btn-md submit' beanName='decorationAccelerator' action='franchise'>加盟</a>
<a href='#decorationAcceleratorManager/decorate/${ result.id}/' class='verb-action btn btn-info btn-md submit' beanName='decorationAccelerator' action='decorate'>装修</a>
<a href='#decorationAcceleratorManager/open/${ result.id}/' class='verb-action btn btn-success btn-md submit' beanName='decorationAccelerator' action='open'>开业</a>
<a href='#decorationAcceleratorManager/close/${ result.id}/' class='verb-action btn btn-danger btn-md submit' beanName='decorationAccelerator' action='close'>关闭</a>

	</div>
</div>


<div class="row">
	
	   
	<c:set var="decorationAccelerator" value="${ result}" scope="request" />
<jsp:include page="../coreview/com.terapico.b2b2c.decorationaccelerator.DecorationAccelerator$Summary.jsp" />

	
</div>

	
	

	<div class="row">
<c:set var="decorationProvinceCenter" value="${ result.provinceCenter}" scope="request" />
<jsp:include page="../coreview/com.terapico.b2b2c.decorationprovincecenter.DecorationProvinceCenter$Info.jsp" />

</div>








	<hr/><div class="table-responsive">
<c:set var="acceleratorCreation" value="${ result.creation}" scope="request" />
<jsp:include page="../coreview/com.terapico.b2b2c.acceleratorcreation.AcceleratorCreation$Action.jsp" />

<c:set var="acceleratorInvestmentInvitation" value="${ result.investmentInvitation}" scope="request" />
<jsp:include page="../coreview/com.terapico.b2b2c.acceleratorinvestmentinvitation.AcceleratorInvestmentInvitation$Action.jsp" />

<c:set var="acceleratorFranchising" value="${ result.franchising}" scope="request" />
<jsp:include page="../coreview/com.terapico.b2b2c.acceleratorfranchising.AcceleratorFranchising$Action.jsp" />

<c:set var="acceleratorDecoration" value="${ result.decoration}" scope="request" />
<jsp:include page="../coreview/com.terapico.b2b2c.acceleratordecoration.AcceleratorDecoration$Action.jsp" />

<c:set var="acceleratorOpening" value="${ result.opening}" scope="request" />
<jsp:include page="../coreview/com.terapico.b2b2c.acceleratoropening.AcceleratorOpening$Action.jsp" />

<c:set var="acceleratorClosing" value="${ result.closing}" scope="request" />
<jsp:include page="../coreview/com.terapico.b2b2c.acceleratorclosing.AcceleratorClosing$Action.jsp" />

</div>




	</div><!-- end of <div id="summary" class="tab-pane fade in active">-->

	

	<div id="acceleratorAccountList" class="tab-pane fade sublist">
<jsp:include page="../coreview/com.terapico.b2b2c.acceleratoraccount.AcceleratorAccount$List.jsp" />
</div>
<div id="acceleratorAccountChangeList" class="tab-pane fade sublist">
<jsp:include page="../coreview/com.terapico.b2b2c.acceleratoraccountchange.AcceleratorAccountChange$List.jsp" />
</div>
<div id="decorationMemberList" class="tab-pane fade sublist">
<jsp:include page="../coreview/com.terapico.b2b2c.decorationmember.DecorationMember$List.jsp" />
</div>
<div id="decorationSupplierList" class="tab-pane fade sublist">
<jsp:include page="../coreview/com.terapico.b2b2c.decorationsupplier.DecorationSupplier$List.jsp" />
</div>



</div><!--<div class="tab-content" style="padding-top: 10px">-->
<script>





$(function() {
	var linkfunc=function(event) {
		//event.preventDefault();
		var linkto=$(this).attr('href');
		console.log(linkto);
		//toggleActive($(this));		
		var reqURI = linkto.substring(1);
		
		
		var target = $("#result");
		//console.log(target);
		if(target.length){
			console.log("trying to fill result")
			fillResult(reqURI,"#result");
			return;
		}
		
		console.log("trying to fill content")
		fillResult(reqURI,"#content");
		
	};
	
	$(".sublist").on("click", ".link-action",linkfunc);
	$(".link-action").click(linkfunc);
	$(".verb-action").click(function(event) {
		
		//event.preventDefault();

		var linkto=$(this).attr('href');
		console.log(linkto);
		//toggleActive($(this));
		
		var reqURI = linkto.substring(1);
		
		
		var target = $("#result");
		
		
		console.log("trying to fill content")
		fillResult(reqURI,"#content");
		
	});
	
	$(".sublist").on("click", ".page-action",function(event) {
			
		//event.preventDefault();

		var linkto=$(this).attr('href');
		console.log(linkto);
		var reqURI = linkto.substring(1);
		
		console.log("trying to fill content")
		
		var id = $(this).parent().parent().attr("id");
		console.log("get the linked -> "+linkto);
		console.log("get the id -> "+id);
		
		fillPartialResult(reqURI,"#"+id);
		
		
	});
	
	$(".sublist").on("click", ".delete-action",function(event) {
			
		//event.preventDefault();
		var currentVersion = $(this).closest("tr").attr('currentVersion');
		var linkto=$(this).attr('href')+currentVersion+"/";
		console.log(linkto);
		
		
		var pageToken = $(this).closest("table").attr("pageToken");
		
		
		var reqURI = linkto.substring(1)+pageToken+"/";
		
		console.log("trying to fill content")
		
		var id = $(this).closest(".sublist").attr("id");
		
		
		console.log("get the linked -> "+linkto);
		console.log("get the id -> "+id);
		
		fillPartialResult(reqURI,"#"+id);
		
		
	});
	
	
	if(!isMobile){
		console.log("code get here in mobile");
		
		
		$("<li><a data-toggle='tab' href='#qr'>二维码</a></li>").appendTo('#navi-tabs');
		
			
		
		var qr = $("<div id='qr' class='tab-pane fade sublist'></div>");
		
		var container = $("<div class='row' style='font-size: 30px;' ></div>");
		var imageContainer = $("<div id='imagediv' class='col-xs-12 col-md-12'style='padding-left:20px'>扫一扫手机上继续</div>")
		
		imageContainer.appendTo(container);
		container.appendTo(qr);
		console.log("current qr sect:" + qr.text());
		qr.appendTo('#tab-content');
		
		
		var qrcode = new QRCode("imagediv", {
    			text: window.location.href,
    			width: 128,
    			height: 128,
    			colorDark : "#000000",
    			colorLight : "#ffffff",
    			correctLevel : QRCode.CorrectLevel.H
			});
		
	
	}
	
	$(".sublist").on("keyup",".edit-value",handleCellReturn);
	$(".sublist").on("keypress",".edit-value",handleCellReturn);
	
	//$(".edit-value").keyup(handleCellReturn);
	//$(".edit-value").keypress(handleCellPress);
	
	

});


	
</script>





