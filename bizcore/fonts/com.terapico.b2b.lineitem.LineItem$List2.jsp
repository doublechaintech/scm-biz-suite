
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<div class="row" style="font-size: 30px;">
	<div class="col-xs-12 col-md-12" style="padding-left: 20px">
		<c:if test="${empty result.lineItemList}"> No </c:if>
		LineItem <span>edit</span>
		<c:if test="${empty result.lineItemList}"> Found! </c:if>
	</div>
</div>

<c:if test="${not empty result.lineItemList}">
	<div class="table-responsive">




		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>SKU_ID</th>
					<th>SKU_NAME</th>
					<th>AMOUNT</th>
					<th>QUANTITY</th>
					<th>ACTIVE</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="item" items="${result.lineItemList}">
					<tr>
						<td><a class="link-action" href="#lineItemManager/loadLineItemDetail/${item.id}/"> ${item.id}</a></td>
						<td title="${item.id}" class="edit-value" action="orderManager/updateLineItem/${contextobj.id}/${item.id}/skuId/" contenteditable="true">${item.skuId}</td>
						<td title="${item.skuName}"  class="edit-value" action="orderManager/updateLineItem/${contextobj.id}/${item.id}/skuName/" contenteditable="true">${item.skuName}</td>
						<td title="${item.amount}" class="edit-value" action="orderManager/updateLineItem/${contextobj.id}/${item.id}/amount/" contenteditable="true">${item.amount}</td>
						<td title="${item.quantity}" class="edit-value" action="orderManager/updateLineItem/${contextobj.id}/${item.id}/quantity/" contenteditable="true">${item.quantity}</td>
						<td title="${item.active}" contenteditable="true">${item.active}</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>



	</div>
</c:if>


