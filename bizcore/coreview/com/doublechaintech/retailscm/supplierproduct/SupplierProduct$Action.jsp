
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty supplierProduct}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A SupplierProduct" style="color: green">${userContext.localeMap['supplier_product']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['supplier_product.id']}</span> ${supplierProduct.id}</li>
<li><span>${userContext.localeMap['supplier_product.product_name']}</span> ${supplierProduct.productName}</li>
<li><span>${userContext.localeMap['supplier_product.product_description']}</span> ${supplierProduct.productDescription}</li>
<li><span>${userContext.localeMap['supplier_product.product_unit']}</span> ${supplierProduct.productUnit}</li>

	
	</ul>
</div>



</c:if>


