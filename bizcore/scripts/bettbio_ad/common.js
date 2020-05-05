var BVUtils = new function() {
    var me = this;
    var mediaServerAppKey = "bettbio_ad";
    function appendFileData(formData, fileElemId){
        var fileElem = $('#'+fileElemId);
        formData.append(fileElem.attr('name'), fileElem[0].files[0]);
    }

	function doAjaxMediaUpload(parameters) {
        var mediaUploadUrl = parameters.url;
        var mediaKey = parameters.key;
        var fileElemId = parameters.fileElemId;
        var onSuccessFunc = parameters.onSuccess;
        var onErrorFunc = parameters.onError;
        var onProgressFunc = parameters.onProgress;

        var args = {
            appKey: me.mediaServerAppKey,
            medias: [
                {
                    needAuth: false,
                    category: parameters.category,
                    resourceKey: mediaKey
                }
            ]
        };

        var formData = new FormData();

        
        formData.append("jsonstr", JSON.stringify(args));
        appendFileData(formData, fileElemId);
        $.ajax({
            url: mediaUploadUrl,
            type: 'POST',
            data: formData,
            dataType: "json",
            processData: false,
            contentType: false,
            beforeSend: function () {
                //console.log("正在进行，请稍候");
            },
            success: function (data) {
                if (typeof onSuccessFunc == "function") {
                    onSuccessFunc(data);
                }else{
                    alert(JSON.stringify(data, null, "  "));
                }
            },
            xhr: function(){ 
                var xhr = $.ajaxSettings.xhr();  
                xhr.upload.onload = function (){  
                    console.log('finish uploading');
                }  

                xhr.upload.onprogress = function (ev) {
                    if (typeof onProgressFunc == "function") {
                        if(ev.lengthComputable) {  
                            var progress = parseInt(ev.loaded / ev.total * 990, 10)/10;
                            onProgressFunc(progress);
                        }
                    }
                }  
                return xhr;  
            },
            error: function (responseStr) {
                if (typeof onErrorFunc == "function"){
                    onErrorFunc(responseStr);
                }else{
                    alert(responseStr);
                }
            }
        });
    }
    function getInputValue(elemId, elemType){
        if (elemType=="radio"){
           return  $("input[name='"+elemId+"']:checked").val();
        }
        return $('#'+elemId).val();
    }
    function setFieldValue(attrValue, args, errMessages, attrName, attrType, nullable){
        if (attrValue == "" || attrValue == null){
            if(!nullable){
                errMessages[attrName] = "is empty";
            }
            return;
        }
        if (attrType == "integer"){
            if (isNaN(attrValue)){
                errMessages[attrName] = "not a integer";
                return;
            }
            args[attrName] = parseInt(attrValue);
            return;
        }
        if (attrType == "float"){
            if (isNaN(attrValue)){
                errMessages[attrName] = "not a float";
                return;
            }
            args[attrName] = parseFloat(attrValue);
            return;
        }
        if (attrType == "boolean"){
            if (attrValue.toLowerCase() == "true"){
                args[attrName] = true;
            }else if (attrValue.toLowerCase() == "false"){
                args[attrName] = false;
            }else{
                errMessages[attrName] = "not a boolean";
            }
            return;
        }
        args[attrName] = attrValue;
    }
    me.uploadToMediaServer = function(parameters){
        doAjaxMediaUpload(parameters);
    }

    me.markIgnorecase = function(orgStr, findStr){
		var replaceVal = "<span style='color:red;'>$1</span>"
		findStr = findStr.replace('%', '.*'); // Oops, DB use % as wild char, but js use .*
		var regS = new RegExp("("+findStr+")", "gi"); 
		return orgStr.replace(regS, replaceVal);
	}
    me.searchMediaResource = function(mediaSearchUrl, searchKey, onResultFunc, onErrorFunc){
        $.ajax({
            url: mediaSearchUrl,
            type: 'GET',
            data: {appKey:me.mediaServerAppKey, key:searchKey},
            dataType: "json",
            success: function (data) {
                if (typeof onResultFunc == "function") {
                    onResultFunc(searchKey, data);
                }else{
                    alert(JSON.stringify(data, null, "  "));
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                if (typeof onErrorFunc == "function"){
                    onErrorFunc(XMLHttpRequest, textStatus, errorThrown);
                }else{
                	if (XMLHttpRequest.status != 4){
                		alert("连接失败，请联系维护人员检查媒体服务器是否正常运行");
                		return;
                	}
                    alert(textStatus);
                }
            }
        });
    }
    me.postRequest = function(reqUrl, args, onSuccessFunc, onErrorFunc){
        $.ajax({
            cache: false,
            url: reqUrl,
            type: 'POST',
            data: {jsonStr:JSON.stringify(args)},
            dataType: "json",
            contentType: "application/x-www-form-urlencoded; charset=UTF-8;",
            success: function (data) {
                if (typeof onSuccessFunc == "function") {
                    onSuccessFunc(data);
                }else{
                    alert(JSON.stringify(data, null, "  "));
                }
            },
            error: function (responseStr) {
                if (typeof onErrorFunc == "function"){
                    onErrorFunc(responseStr);
                }else{
                    alert(responseStr);
                }
            }
        });
    }
    me.pickFieldFromData = function (args, errMessages, attrName, attrType, elem, dataName, nullable){
        var attrValue = $(elem).data(dataName);
        setFieldValue(attrValue, args, errMessages, attrName, attrType, nullable);
    }
    me.pickFieldFromValue = function (args, errMessages, attrName, attrType, elem, nullable){
        var attrValue = $(elem).val();
        setFieldValue(attrValue, args, errMessages, attrName, attrType, nullable);
    }
    me.pickField = function (args, errMessages, attrName, attrType, elementId, elementType, nullable){
        var attrValue = getInputValue(elementId, elementType);
        setFieldValue(attrValue, args, errMessages, attrName, attrType, nullable);
    }
    me.setAppKey = function(appKey){
    	me.mediaServerAppKey = appKey;
    }
}