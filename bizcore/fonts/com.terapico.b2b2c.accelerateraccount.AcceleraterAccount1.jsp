

<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div class="row">
	
	<div class="col-xs-12 col-md-12">
	<c:set var="now" value="<%=new java.util.Date()%>" />

<p>Formatted Date (1): <fmt:formatDate pattern="yyyy-MM-dd" value="${now}" /></p>
	</div>
</div>


<div class="row">
	
	   
	<c:set var="acceleraterAccount" value="${ result}" scope="request" />
<jsp:include page="../coreview/com.terapico.b2b2c.accelerateraccount.AcceleraterAccount$Summary.jsp" />

	
</div>

	
	

	<div class="row">
<c:set var="decorationAccelerater" value="${ result.owner}" scope="request" />
<jsp:include page="../coreview/com.terapico.b2b2c.decorationaccelerater.DecorationAccelerater$Info.jsp" />

</div>








	







	<hr><div>
<jsp:include page="../coreview/com.terapico.b2b2c.accelerateraccountchange.AcceleraterAccountChange$List.jsp" />
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

});


	
</script>





