
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty originalVoucher}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A OriginalVoucher">${userContext.localeMap['original_voucher']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./originalVoucherManager/view/${originalVoucher.id}/"> ${originalVoucher.id}</a></li>
<li><span>${userContext.localeMap['original_voucher.title']}</span> ${originalVoucher.title}</li>
<li><span>${userContext.localeMap['original_voucher.made_by']}</span> ${originalVoucher.madeBy}</li>
<li><span>${userContext.localeMap['original_voucher.received_by']}</span> ${originalVoucher.receivedBy}</li>
<li><span>${userContext.localeMap['original_voucher.voucher_type']}</span> ${originalVoucher.voucherType}</li>
<li><span>${userContext.localeMap['original_voucher.voucher_image']}</span> ${originalVoucher.voucherImage}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




