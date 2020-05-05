var AdvertisePage = new function(){
    var me = this;
    var localeMap;
    var searchUrl;
    var uploadUrl;
    var managerUrl;
    var currentTargetInputElement;

    function appendTemplate(divId, contentUnitType, contentUnitTypeName){
        var listObj = $('#contentUnitListDiv');
        var contentUnit = $("<div class='dragable_item'></div>").html($(divId).html());
        $(contentUnit).find("label.lbl_content_unit_type").text(contentUnitTypeName);
        $(contentUnit).find(".v_unit_content").attr("data-unit-type", contentUnitType);
        $('#h3_empty_content_list').remove();
        listObj.append(contentUnit);
        me.dragTool.reinit();
    }

    function createBasicData(){
        var args = {};
        var errMsg = {};
        BVUtils.pickField(args, errMsg, "id", "string", "advertisePage_id", "text", true);
        BVUtils.pickField(args, errMsg, "version", "integer", "advertisePage_version", "text", true);
        BVUtils.pickField(args, errMsg, "summary", "string", "advertisePage_summary", "text", true);
        //BVUtils.pickField(args, errMsg, "customerCompany", "string", "advertisePage_customerCompany", "text", true);
        
        args.customerCompany={id:'CC000005'};
        BVUtils.pickField(args, errMsg, "researchKey", "string", "advertisePage_researchKey", "text", true);
        BVUtils.pickField(args, errMsg, "backgroundAudio", "string", "advertisePage_backgroundAudio", "text", true);
        BVUtils.pickField(args, errMsg, "backgroundImage", "string", "advertisePage_backgroundImage", "text", true);
        BVUtils.pickField(args, errMsg, "playDuration", "integer", "advertisePage_playDuration", "text", true);
        BVUtils.pickField(args, errMsg, "active", "boolean", "advertisePage_active", "radio", true);
        return {args:args, errMsg:errMsg};
    }
    function pickContentUnitsField(errMsg){
        var args = new Array();
        var errMsgArray = new Array();
        $('#contentUnitListDiv').find(".v_unit_content").each(function(i, item){
            var contentUnit = {};
            var unitErrMsg = {};
            BVUtils.pickFieldFromData(contentUnit, unitErrMsg, "id", "string", item, "id", true);
            BVUtils.pickFieldFromData(contentUnit, unitErrMsg, "version", "integer", item, "version", true);
            contentUnit.positionIndex = i;
            BVUtils.pickFieldFromData(contentUnit, unitErrMsg, "contentType", "string", item, "unit-type", false);
            BVUtils.pickFieldFromValue(contentUnit, unitErrMsg, "content", "string", item, false);

            if (!$.isEmptyObject(unitErrMsg)){
                unitErrMsg.positionIndex = i;
                errMsgArray.push(unitErrMsg);
            }
            args.push(contentUnit);
        });
        if (errMsgArray.length > 0){
            errMsg.advertiseContentUnitList = errMsgArray;
        }
        return args;
    }
    me.onMediaServiceError = function (xhr, textStatus, errorThrown){
        //alert(XMLHttpRequest.readyState+": " + textStatus);
        if (xhr.readyState == 0){
            alert("Connecting to media server failed. Please check media service is running.");
            return;
        }
    }
    me.init = function(initData){
        me.localeMap = initData.localeMap;
        me.dragTool = initData.dragTool;
        me.uploadUrl = initData.mediaUploadUrl;
        me.searchUrl = initData.mediaSearchUrl;
        me.managerUrl = initData.managerUrl;
        
        $('#input_upload_file').change(function(){
            var fileElem = this;
            var orgFileName = this.files[0].name;
            var defaultKey = orgFileName.substring(0, orgFileName.lastIndexOf('.'));
            var mediaKeyElem = $('#input_upload_key');
            if (mediaKeyElem.val() == ''){
                mediaKeyElem.val(defaultKey);
            }
        });
    }

    me.deleteContentUnit = function(btnElem){
        if (!confirm("删除这个"+$(btnElem).parent().find("label.lbl_content_unit_type").text()+"?")){
            return;
        }
        $(btnElem).parent().parent().parent().remove();
        me.dragTool.reinit();
    }
    me.addTextContentUnit = function(){
        appendTemplate('#template_new_text_content', 'plain_text', me.localeMap['text_content_unit']);
    }
    me.addImageContentUnit = function(){
        appendTemplate('#template_new_media_content', 'image', me.localeMap['image_content_unit']);
    }
    me.addHtmlContentUnit = function(){
        appendTemplate('#template_new_text_content', 'html', me.localeMap['html_content_unit']);
    }
    me.showSearchMedia = function(btnElem){
        var inputElem = $(btnElem).parent().parent().find("input.v_unit_content");
        // TODO
        currentTargetInputElement = inputElem;
        $('#searchMadieModal').modal('show');
    }
    me.resetPage = function(){
        $('#advertise_page_form')[0].reset();
        document.location.reload();
    }
    me.uploadMediaResource = function(){
        var files = $('#input_upload_file')[0].files;
        if (files == null || files.length < 1){
            alert("没有任何媒体资源被选中");
            return;
        }
        var orgFileName = files[0].name;
        var defaultKey = orgFileName.substring(0, orgFileName.lastIndexOf('.'));
        var mediaKeyElem = $('#input_upload_key');
        if (mediaKeyElem.val() != ''){
            defaultKey = mediaKeyElem.val();
        }
        $('#span_ipload_result').text('');
        BVUtils.uploadToMediaServer({
            url: me.uploadUrl,
            key: defaultKey,
            fileElemId: 'input_upload_file',
            onSuccess: function(data){
                $('#upload_form')[0].reset();
                $('#span_ipload_result').text(data.resourceUris[0]);
            },
            onError: me.onMediaServiceError
        });
        
    }

    me.setMediaResource = function(aElem){
        var value=$(aElem).data("value");
        if (currentTargetInputElement){
            currentTargetInputElement.val(value);
        }
        currentTargetInputElement=null;
        $('#searchMadieModal').modal('hide');
    }
    me.searchMediaByInput = function(){
        var inputElem= $('#search_media_input_key');
        var resultDiv= $('#search_result_list_div');

        var key = inputElem.val();
        if (key == ""){
            resultDiv.html('');
            return;
        }
        BVUtils.searchMediaResource(me.searchUrl, key, function(data){
                if(typeof data != "object" || typeof data.length != 'number'){
                    // no an array, nothing to do
                    alert(data);
                    return;
                }
                resultDiv.html('');
                $('#search_result_need_more').hide();
                $.each(data, function(i, item){
                    if (i == 30){
                        $('#search_result_need_more').show();
                    }
                    if (i > 30){
                        return;
                    }
                    var elem = $('<a href="javascript:void(0)" onclick="AdvertisePage.setMediaResource(this)" style="padding: 3px 10px;"></a>');
                    $(elem).data("value", item.mediaUri);
                    $(elem).html(BVUtils.markIgnorecase(item.fileName+"("+item.category+")",key));
                    resultDiv.append($(elem));
                });
            },me.onMediaServiceError);
    }
    me.onServiceError = function(xhr, textStatus, errorThrown){
        if (xhr.readyState == 0){
            alert("Connecting of service failed. Please check service is running.");
            return;
        }
        alert(textStatus);
    }
    me.savePage = function(){
        var data = createBasicData();
        data.args.advertiseContentUnitList = pickContentUnitsField(data.errMsg);
        console.log(JSON.stringify(data, null, "  "));
        if (!$.isEmptyObject(data.errMsg)){
            alert("Has error: " + JSON.stringify(data.errMsg, null, "  "));
            return;
        } 
        BVUtils.postRequest(me.managerUrl+"saveAdvertisePageDetail/jsonStr/",data.args,function(respData){
            //alert(JSON.stringify(respData));
            if (!respData.success){
                var alertMsg = respData.code+": " + respData.message;
                if (respData.data){
                    $(respData.data).each(function(i, item){
                        alertMsg = alertMsg+"\n"+(i+1)+": "+item.body;
                    });
                }
                alert(alertMsg);
                return;
            }
            var tgtUrl = me.managerUrl + "editAdvertisePageDetail/"+respData.data+"/";
            location.href = tgtUrl;
        },me.onServiceError);
    }
}