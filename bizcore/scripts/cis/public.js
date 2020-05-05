var UTILS = new function(){
	var me = this;
	
	function collectFormValue(){
		var data = {};
		$("form").find(".form-field").each(function(i, elem){
			data[$(elem).attr('name')] = me.getValue(elem);
		});
		return data;
	}
	function getInputElementValue(elem){
		var elemDataType = $(elem).prop('type');
		if (elemDataType == 'checkbox'){
			var checked = $(elem).prop('checked');
			var inputType = $(elem).data("input-type");
			if (inputType == "checkbox"){
				return checked?$(elem).val():null;
			}
			return checked;
		}
		return $(elem).val();
	}
	function appendFileData(formData, fileElemId){
		var fileElem = $('#'+fileElemId);
		formData.append(fileElem.attr('name'), fileElem[0].files[0]);
	}
	function ajaxPostFormForJsonResponse(url, formData, callback){
		$.ajax({
			url: url,
			type: 'POST',
			data: formData,
			dataType: "json",
			processData: false,
			contentType: false,
			beforeSend: function () {
				//console.log("正在进行，请稍候");
				if (typeof callback.beforeSend == 'function') {
					callback.beforeSend();
				}else{
					console.log("开始上传，请稍候");
				}
			},
			success: function (data) {
				if (typeof callback.success == 'function') {
					callback.success(data);
				}else{
					console.log(JSON.stringify(data, null, "  "));
				}
			},
			xhr: function(){ 
				var xhr = $.ajaxSettings.xhr();  
				xhr.upload.onload = function (){  
					if (typeof callback.onloaded == 'function') {
						callback.onloaded();
					}else{
						console.log('finish uploading');
					}
				}  

				xhr.upload.onprogress = function (ev) {  
					if(ev.lengthComputable) {  
						var progress = parseInt(ev.loaded / ev.total * 1000, 10)/10;
						progress = Math.min(progress, 99);
						if (typeof callback.onprogress == 'function') {
							callback.onprogress(progress);
						}else{
							console.log('uploading progress ' + progress);
						}
					}  
				}  
				return xhr;  
			},
			error: function (xhr, responseStr, throwable) {
				if (typeof callback.error == 'function') {
					callback.error(xhr, responseStr, throwable);
				}else{
					console.log("error: " + responseStr+", status=" + xhr.status);
				}
			}
		});
	}
	// /////////////////////////////////////////////////////
	// below are interface functions
	me.toggleClass = function (elem, className){
		if ($(elem).hasClass(className)){
			$(elem).removeClass(className);
		}else{
			$(elem).addClass(className);
		}
	}
	
	me.gotoUrl = function(url){
		window.location.href=url;
	}
	
	me.getValue = function(elem){
		var elemNodeType = $(elem).prop('tagName');
		if (elemNodeType == 'INPUT'){
			return getInputElementValue(elem);
		}else if (elemNodeType == 'SELECT'){
			return $(elem).val();
		}
		return null;
	}
	
	me.getRequestAsHtml = function(url) {
		return $.ajax({
			url : url,
			type : "GET",
			dataType : "html"
		});
	}
	me.getRequestAsJson = function(url) {
		return $.ajax({
			url : url,
			type : "GET",
			dataType : "json"
		});
	}
	me.reloadPage = function(){
		window.location.reload();
	}
	me.uploadSingleImage = function(imageArgs, callback){
		if (typeof callback == 'undefined') {
			callback = {};
		}
		var args = {
			appKey: imageArgs.appKey,
			medias: [
				{
					needAuth: false,
					category: imageArgs.category,
					resourceKey: imageArgs.resourceKey
				}
			]
		};
		var formData = new FormData();
		formData.append("jsonstr", JSON.stringify(args));
		appendFileData(formData, imageArgs.fileElementId);
		ajaxPostFormForJsonResponse(imageArgs.serverHost+'/upload.ajax', formData, callback);
	}
	me.vehiclePermitOcr = function(fileElemId, url, callback){
		if (typeof callback == 'undefined') {
			callback = {};
		}
		var formData = new FormData();
		var fileElem = $('#'+fileElemId);
		formData.append('face', fileElem[0].files[0]);
		ajaxPostFormForJsonResponse(url, formData, callback);
	}
	me.postFormForJsonResponse = function(url, formData, callback){
		ajaxPostFormForJsonResponse(url, formData, callback);
	}
	me.onFormActionClick = function(){
		var url = $(this).data('action-url');
		var formData = collectFormValue();
//		console.log(JSON.stringify(formData));
		$('#action_form').find('input').val(JSON.stringify(formData));
		document.getElementById('action_form').action = url;  
        document.getElementById("action_form").submit();  
	}
	
	me.showConfirm = function(title, content, onCancel, onConfirm){
		var dialog = $("#dialog_confirm");
		$("#dialog_confirm_title").html(title);
		$("#dialog_confirm_content").html(content);
		$("#dialog_confirm_cancel").on("click", function(){
			dialog.fadeOut(200);
			onCancel();
		});
		$("#dialog_confirm_ok").on("click", function(){
			dialog.fadeOut(200);
			onConfirm();
		});
		dialog.fadeIn(200);
	}
	
	me.collectFormInputValues = function(formSelector){
		var data = {};
		$(formSelector).find(".form_input").each(function(i, elem){
			var inputName = $(elem).attr('name');
			var inputValue = me.getValue(elem);
			//console.log("==>"+inputName+" = "+inputValue);
			if (inputValue == null){
				return;
			}
			if (!data[inputName]){
				data[inputName] = inputValue;
				return;
			}
			if ($.isArray(data[inputName])){
				data[inputName].push(inputValue);
				return;
			}
			var values = new Array();
			values.push(data[inputName]);
			values.push(inputValue);
			data[inputName] = values;
		});
		return data;
	}
	me.getResponseExceptionMessage = function(responseMessage){
		index = responseMessage.indexOf("Exception");
		return responseMessage.substring(index).split('\n')[0];
	}
}