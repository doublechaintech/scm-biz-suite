

<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<div id="msg"></div>


<hr><div>
<c:set var="contextobj" value="${ result}" scope="request" />

<jsp:include page="../customview/com.terapico.b2b.lineitem.LineItem$List.jsp" />
<jsp:include page="../coreview/com.terapico.b2b.shippinggroup.ShippingGroup$List.jsp" />
<jsp:include page="../coreview/com.terapico.b2b.paymentgroup.PaymentGroup$List.jsp" />
<jsp:include page="../coreview/com.terapico.b2b.action.Action$List.jsp" />
</div>
	
	
<div class="row">
	
	
	<c:set var="order" value="${ result}" scope="request" />
<jsp:include page="../coreview/com.terapico.b2b.order.Order$Summary.jsp" />

	
</div>
	<div class="row">
<c:set var="buyerCompany" value="${ result.buyer}" scope="request" />
<jsp:include page="../coreview/com.terapico.b2b.buyercompany.BuyerCompany$Info.jsp" />

<c:set var="sellerCompany" value="${ result.seller}" scope="request" />
<jsp:include page="../coreview/com.terapico.b2b.sellercompany.SellerCompany$Info.jsp" />

<c:set var="costCenter" value="${ result.costCenter}" scope="request" />
<jsp:include page="../coreview/com.terapico.b2b.costcenter.CostCenter$Info.jsp" />

<c:set var="profitCenter" value="${ result.profitCenter}" scope="request" />
<jsp:include page="../coreview/com.terapico.b2b.profitcenter.ProfitCenter$Info.jsp" />

<c:set var="recurringInfo" value="${ result.recurringInfo}" scope="request" />
<jsp:include page="../coreview/com.terapico.b2b.recurringinfo.RecurringInfo$Info.jsp" />

</div>








	<hr/><div class="table-responsive">
<c:set var="confirmation" value="${ result.confirmation}" scope="request" />
<jsp:include page="../coreview/com.terapico.b2b.confirmation.Confirmation$Action.jsp" />

<c:set var="approval" value="${ result.approval}" scope="request" />
<jsp:include page="../coreview/com.terapico.b2b.approval.Approval$Action.jsp" />

<c:set var="processing" value="${ result.processing}" scope="request" />
<jsp:include page="../coreview/com.terapico.b2b.processing.Processing$Action.jsp" />

<c:set var="shipment" value="${ result.shipment}" scope="request" />
<jsp:include page="../coreview/com.terapico.b2b.shipment.Shipment$Action.jsp" />

<c:set var="delivery" value="${ result.delivery}" scope="request" />
<jsp:include page="../coreview/com.terapico.b2b.delivery.Delivery$Action.jsp" />

</div>







	



<script>




$(function() {

	$(".link-action").click(function(event) {
		
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
		
	});
	
	
	
	
	//$(".edit-value").blur(handleChange);
	$(".edit-value").keyup(handleCellReturn);
	$(".edit-value").keypress(handleCellPress);
	
	

});

	
</script>




