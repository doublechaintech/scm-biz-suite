var JsHelper = new function() {
	var me = this;
	var rtData = {};
	
	function showErrorMessage(msg){
		//console.log('ErrorMsg: ' + msg);
		$('#dialog_alert_content').html(msg);
		$('#dialog_alert').fadeIn(200);
	}
	function collectIntentOrderInfo(){
		var formInputs = UTILS.collectFormInputValues("form");
		if (!(formInputs.inputServiceTypeList == null || $.isArray(formInputs.inputServiceTypeList))){
			// OOTB 只有搜到多个同名参数才会组织成数组。这里强制该字段为数组
			var values = new Array();
			values.push(formInputs.inputServiceTypeList);
			formInputs.inputServiceTypeList=values;
		}
		console.log(JSON.stringify(formInputs,"  ", "  "));
		return formInputs;
	}
	function verifyOrderData(order) {
		console.log(JSON.stringify(order));
		var errMsg = '';
		if (order.pickUpFromHome){
			if (order.pickUpAddress == ''){
				errMsg = errMsg + "上门取车需要输入地址<br/>";
			}
			
		}
		if (order.needEngagementLetter == "true" && !order.engagementLetterProvided){
			errMsg = errMsg + "非本地车辆上线检测必须提供委托书<br/>";
		}
		if (order.contactMobile == ''){
			errMsg = errMsg + "请输入联系人电话<br/>";
		}else if(!(/^1(3|4|5|7|8)\d{9}$/.test(order.contactMobile))){
			errMsg = errMsg + "联系人电话不正确<br/>";
		}
		if (order.planInspectionDate == ''){
			errMsg = errMsg + "请选择服务日期<br/>";
		}
		return errMsg;
	}
	// ////////////////////////////////////////////////////////////////////////
	//  below are 'interface' methods
	me.setInitialData = function (initData){
		rtData = initData;
	}
	me.onMerchantClick = function(elem){
		console.log('Clicked company ' + $(elem).data('company-id'));
		$('a.selected_company').removeClass('selected_company');
		$(elem).addClass('selected_company');
		rtData.selectedCompanyId = $(elem).data('company-id');
	}
	me.onVehicleClicked = function(elem){
		console.log('Clicked company ' + $(elem).data('vehicle-id'));
		$('div.selected_vehicle').removeClass('selected_vehicle');
		$(elem).addClass('selected_vehicle');
		rtData.selectedVehicleId = $(elem).data('vehicle-id');
	}
	me.onAfterSelectMerchant = function(){
		if (typeof rtData.selectedCompanyId == 'undefined'){
			return showErrorMessage('您还没有选择任何商家');
		}
		if (rtData.selectedCompanyId == ''){
			return showErrorMessage('您需要选择一个商家为您服务');
		}
		var url = './weixinreq/placeOrderSelectVehicle/'+rtData.selectedCompanyId+'/placeOrder/';
		UTILS.gotoUrl(url);
	}
	me.onAfterSelectVehicle = function(){
		if (typeof rtData.selectedVehicleId == 'undefined'){
			return showErrorMessage('您还没有选择任何车辆');
		}
		if (rtData.selectedVehicleId == ''){
			return showErrorMessage('您需要选择一个车辆进行');
		}
		var url = './weixinreq/placeOrderSelectMovement/'+rtData.selectedCompanyId+'/'+rtData.selectedVehicleId+'/';
		UTILS.gotoUrl(url);
	}
	me.onHomePickupChanged = function(){
		var val = $('#home_pickup_type').val();
		console.log("上门:" + val);
		if (val == 'to_store'){
			$('#input_cells_for_pickup_from_home').hide();
		}else{
			$('#input_cells_for_pickup_from_home').show();
		}
	}
	me.onIntentOrderInputChanged = function(){
		var elem = $(this);
		var formInputs = UTILS.collectFormInputValues("form");
		if (!(formInputs.inputServiceTypeList == null || $.isArray(formInputs.inputServiceTypeList))){
			// OOTB 只有搜到多个同名参数才会组织成数组。这里强制该字段为数组
			var values = new Array();
			values.push(formInputs.inputServiceTypeList);
			formInputs.inputServiceTypeList=values;
		}
		console.log(JSON.stringify(formInputs,"  ", "  "));
		
		var url = "./weixinreq/refreshPlaceOrderPage/";
		url = url + formInputs.companyId+"/";
		url = url + formInputs.vehicleId+"/";
		url = url + encodeURIComponent(JSON.stringify(formInputs)) +"/";
		var request = UTILS.getRequestAsHtml(url);
		// 如果请求失败, 静悄悄的什么也不告诉客户, 等待下次
		request.fail(function(jqXHR, textStatus, errorThrown) {
			console.log("request fail: " + textStatus+". state=" + jqXHR.readyState);
		});
		request.done(function( msg, textStatus, jqXHR ){
			if (jqXHR.readyState != 4){
				return;
			}
			var index = msg.indexOf("Exception");
			if(index > 0){
				$('#page_error_message').html("发生错误:"+UTILS.getResponseExceptionMessage(msg));
				$('#page_error_message').css("display","block");
				return;
			}
			var text = $(msg).find('#content_container');
			console.log("get the text from #content_container " + text.html());
			$('#content_container').html(text.html());
			$('.form_input').bind('change', me.onIntentOrderInputChanged);
		});
	}
	
	me.readyToPlaceOrder = function(){
		var orderInfo = collectIntentOrderInfo();
		
		var url = "./weixinreq/placeOrderSubmitOrder/"+ orderInfo.companyId+"/"+ orderInfo.vehicleId+"/" + encodeURIComponent(JSON.stringify(orderInfo))+"/";
		var request = UTILS.getRequestAsJson(url);
		request.fail(function(jqXHR, textStatus, errorThrown) {
			console.log("request fail: " + textStatus+". state=" + jqXHR.readyState);
			return showErrorMessage("系统错误,请稍后再试");
		});
		request.done(function( msg, textStatus, jqXHR ){
			if (jqXHR.readyState != 4){
				return;
			}
			
			if (msg == "input_has_error"){
				me.onIntentOrderInputChanged();
				return;
			}
			
			//console.log(JSON.stringify(msg));
			if (typeof msg['class'] == "undefined"){
				$('#page_error_message').html("发生错误:"+msg);
				$('#page_error_message').css("display","block");
				return showErrorMessage(msg);
			}
			
			var orderId = msg.id;
			var url = "./weixinreq/placeOrderPayment/?order=" + orderId+"&type=order";
			UTILS.gotoUrl(url);
		});
	}

	me.readyToPlaceOrder_v1 = function(){
		var orderInfo = collectIntentOrderInfo();
		
		var url = "./weixinreq/placeOrderSubmitOrder/" + encodeURIComponent(JSON.stringify(orderInfo))+"/";
		var request = UTILS.getRequestAsJson(url);
		request.fail(function(jqXHR, textStatus, errorThrown) {
			console.log("request fail: " + textStatus+". state=" + jqXHR.readyState);
			return showErrorMessage("系统错误,请稍后再试");
		});
		request.done(function( msg, textStatus, jqXHR ){
			if (jqXHR.readyState != 4){
				return;
			}
			
			//console.log(JSON.stringify(msg));
			if (typeof msg['class'] == "undefined"){
				return showErrorMessage(msg);
			}
			
			var orderId = msg.id;
			var url = "./weixinreq/placeOrderPayment/?order=" + orderId+"&type=order";
			UTILS.gotoUrl(url);
		});
	}
	
	me.onSelectAddVehicle = function(){
		$('#dialog_select_add_vehicle').fadeIn(200);
	}
	function compressPicture(file,param,callback){
		var ready=new FileReader();
        /*开始读取指定的Blob对象或File对象中的内容. 当读取操作完成时,readyState属性的值会成为DONE,如果设置了onloadend事件处理程序,则调用之.同时,result属性中将包含一个data: URL格式的字符串以表示所读取文件的内容.*/
        ready.readAsDataURL(file);
        ready.onload=function(){
            var re=this.result;
            canvasDataURL(re,param,callback)
        }
	}
	function canvasDataURL(path, param, callback){
        var img = new Image();
        img.src = path;
        img.onload = function(){
            var that = this;
            // 默认按比例压缩
            var w = that.width,
                h = that.height,
                scale = w / h;
            w = param.width || w;
            h = param.height || (w / scale);
            var quality = 1.0;  // 默认图片质量为1.0
            //生成canvas
            var canvas = document.createElement('canvas');
            var ctx = canvas.getContext('2d');
            // 创建属性节点
            var anw = document.createAttribute("width");
            anw.nodeValue = w;
            var anh = document.createAttribute("height");
            anh.nodeValue = h;
            canvas.setAttributeNode(anw);
            canvas.setAttributeNode(anh);
            ctx.drawImage(that, 0, 0, w, h);
            // 图像质量
            if(param.quality && param.quality <= 1 && param.quality > 0){
                quality = param.quality;
            }
            // quality值越小，所绘制出的图像越模糊
            var base64 = canvas.toDataURL('image/jpeg', quality);
            // 回调函数返回base64的值
            callback(base64);
        }
    }
	function convertBase64UrlToBlob(urlData){
        var arr = urlData.split(','), mime = arr[0].match(/:(.*?);/)[1],
            bstr = atob(arr[1]), n = bstr.length, u8arr = new Uint8Array(n);
        while(n--){
            u8arr[n] = bstr.charCodeAt(n);
        }
        return new Blob([u8arr], {type:mime});
    }
	function gotoUrlAfterConfirm(message, url){
		$('#dialog_ocr_alert_content').html(message);
		$('#dialog_ocr_alert_link').attr('href', url);
		$('#dialog_ocr_alert').fadeIn(200);
	}
	me.onSubmitVehiclePermitImage = function(ocrServer, fromWhere){
		//curl -X POST --header 'Content-Type: multipart/form-data' 
		// --header 'Accept: application/json' {"type":"formData"} 'http://localhost:8180/ocr/vehicle'
		// UTILS.vehiclePermitOcr('uploaderInput', 'http://localhost:8180/ocr/vehicle', 'multipart/form-data');
		var nextUrlWhenError = "./weixinreq/fillVehicleForm/" +rtData.selectedCompanyId+"/" 
		+ encodeURIComponent(" ")+"/" + fromWhere +"/";
		var uploadCallback = {
				beforeSend: function(){
					$('#loadingToast').show();
				},
				success: function(response){
					$('#loadingToast').hide();
					
					if (response.code != "000"){
						//showErrorMessage("识别失败,请手工填写车辆信息.");
						//return showErrorMessage("识别失败: "+response.message+". 换一张试试");
						//UTILS.gotoUrl(nextUrlWhenError);
						gotoUrlAfterConfirm("识别失败,请手工填写车辆信息.", nextUrlWhenError);
						return;
					}
					if (response.data.primary.success && response.data.primary.plate_num != ''){
						showErrorMessage(response.data.primary.plate_num);
						var nextUrl="./weixinreq/fillVehicleForm/" +rtData.selectedCompanyId+"/" 
							+ encodeURIComponent(JSON.stringify(response.data.primary))+"/" + fromWhere +"/";
						UTILS.gotoUrl(nextUrl);
						return;
					}
					var message = "识别失败"+(response.message==null?"":": "+response.message)+". 手工填写车辆信息";
					//showErrorMessage(message);
					//UTILS.gotoUrl(nextUrlWhenError);
					gotoUrlAfterConfirm(message, nextUrlWhenError);
					return;
				},
				error: function(xhr, responseStr, throwable){
					$('#loadingToast').hide();
					if (xhr.status == 0){
						//showErrorMessage("图像识别服务没有响应, 将手工填写车辆信息");
						//UTILS.gotoUrl(nextUrlWhenError);
						gotoUrlAfterConfirm("图像识别服务没有响应, 将手工填写车辆信息", nextUrlWhenError);
						return;
					}
					//showErrorMessage("识别失败, 将手工填写车辆信息");
					//UTILS.gotoUrl(nextUrlWhenError);
					gotoUrlAfterConfirm("识别失败, 将手工填写车辆信息", nextUrlWhenError);
					return;
				}
			};
		
		/** for debug, block OCR , use direct value
		 * 
		 */
		var fileElem =  $('#uploaderInput');
		var fileSize = fileElem[0].files[0].size;
		if (fileSize > (512*1024)){
			//$(fileElem).val("");
			//showErrorMessage("图片大小不能超过 1M .请采用合适的图片再试");
			compressPicture(fileElem[0].files[0], {w:1080, quality:0.1}, function(base64Code){
				var bl = convertBase64UrlToBlob(base64Code);
				var formData = new FormData();
				formData.append("face", bl, "file_"+Date.parse(new Date())+".jpg"); // 文件对象
				UTILS.postFormForJsonResponse(ocrServer +'/ocr/vehicle', formData, uploadCallback);
			});
			return;
		}
		// http://119.23.65.188:8180
		UTILS.vehiclePermitOcr('uploaderInput', ocrServer +'/ocr/vehicle',uploadCallback);
		
	}
	me.uploadFile = function(){
		var customerId = $('#input_customer_id').val();
		var mediaServerHost = $('#input_mediaserver_host').val();
		
		var imageName = "vhlpermit" + new Date().getTime();
		var category = '/' + customerId + '/vehiclepermit'
		var uploadParam = {
			serverHost: mediaServerHost,
			fileElementId: 'uploaderInput',
			appKey: 'cis',
			category: category,
			resourceKey: imageName
		};
		UTILS.uploadSingleImage(uploadParam, {
			onprogress : function (progress){
				$('#div_progress').text(progress+"%");
			},
			success : function(data){
				var picurl = data.resourceUris;
				var nextUrl = "./weixinreq/fillVehicleForm/"+encodeURIComponent(picurl)+"/";
				UTILS.gotoUrl(nextUrl);
			}
		});
	}
	me.reportOrderPayResult = function(orderId, logMsg, paySuccess, payType, paymentId, prepayId, wechatOrderId){
		var url="./weixinreq/reportPayResult/"+orderId+"/"
			+ encodeURIComponent(logMsg)+"/"
			+ paySuccess +"/"
			+ payType +"/"
			+ paymentId +"/"
			+ prepayId +"/"
			+ wechatOrderId +"/";
//		UTILS.getRequestAsJson(url);
		var request = UTILS.getRequestAsJson(url);
		request.fail(function(jqXHR, textStatus, errorThrown) {
			console.log("request fail: " + textStatus+". state=" + jqXHR.readyState);
			return showErrorMessage("系统错误,请稍后再试");
		});
		request.done(function( msg, textStatus, jqXHR ){
			if (msg == "success"){
				var orderUrl = "./weixinreq/viewOrder/"+orderId+"/wechatpay/";
				UTILS.gotoUrl(orderUrl);
				return;
			}
			if ((typeof msg.message) == "string" ) {
				$("#pay_result").html(msg.message);
			}
		});
	}
	me.onEditVehicle = function(elem){
		var url = $(elem).data("url");
		UTILS.gotoUrl(url);
	}
	me.onRemoveVehicle = function(elem){
		var pNum = $(elem).data("platenum");
		var vId = $(elem).data("id");
		var url = $(elem).data("url");
		UTILS.showConfirm("删除车辆","你确定要删除"+pNum+"吗?",function(){
			// on cancel, nothing to do
		}, function(){
			var request = UTILS.getRequestAsJson(url);
			request.fail(function(jqXHR, textStatus, errorThrown) {
				console.log("request fail: " + textStatus+". state=" + jqXHR.readyState);
				return showErrorMessage("系统错误,请稍后再试");
			});
			request.done(function( msg, textStatus, jqXHR ){
				if (jqXHR.readyState != 4){
					return;
				}
				
				//console.log(JSON.stringify(msg));
				if (msg['text'] != "OK"){
					return showErrorMessage(msg.message);
				}
				UTILS.reloadPage();
			});
		})
	}
}

// reportPayResult/orderId/success/true/order/paymentId/prepayId/wechatOrderId/