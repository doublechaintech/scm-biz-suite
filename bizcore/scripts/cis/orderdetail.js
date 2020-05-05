$('.employee-summary').on("click", function(){
	var contentBlock=$(this).next('.employee-more-info');
	contentBlock.slideToggle("slow");
	$(this).find(".drop_down_flag").toggleClass("show_down");
});

$('.btn-cancel-order').on("click", function(){
	var orderId = $(this).data("order-id");
	var onCanel = function(){
		console.log("Will not cancel order " + orderId);
	};
	var onConfirm = function(){
		console.log("Will cancel order " + orderId);
		var url="./weixinreq/cancelOrder/"+orderId+"/";
		UTILS.gotoUrl(url);
	}
	UTILS.showConfirm("取消订单","取消后无法恢复. 你要取消此订单么?",onCanel,onConfirm);
});