var MediaService = new function(){
    var me = this;
    var currentSearchSourceElem;
    var currentSearchCallback;
    
    me.onMediaServiceError = function (xhr, textStatus, errorThrown){
        //alert(XMLHttpRequest.readyState+": " + textStatus);
        if (xhr.readyState == 0){
            alert("Connecting to media server failed. Please check media service is running.");
            return;
        }
        alert(textStatus);
    }
    me.uploadMediaResource = function(input_upload_file_id, input_upload_key_id,upload_form_id,span_ipload_result_id, resourceCategory){
    	var files = $('#'+input_upload_file_id)[0].files;
        if (files == null || files.length < 1){
            alert("没有任何媒体资源被选中");
            return;
        }
        var orgFileName = files[0].name;
        var defaultKey = orgFileName.substring(0, orgFileName.lastIndexOf('.'));
        var mediaKeyElem = $('#'+input_upload_key_id);
        if (mediaKeyElem.val() != ''){
            defaultKey = mediaKeyElem.val();
        }
        $('#'+span_ipload_result_id).text('');
        BVUtils.uploadToMediaServer({
            url: me.uploadUrl,
            key: defaultKey,
            category:resourceCategory,
            fileElemId: input_upload_file_id,
            onSuccess: function(data){
                $('#'+upload_form_id)[0].reset();
                var tagELem = $('#'+span_ipload_result_id);
                if (tagELem.is('input')){
                	tagELem.val(data.resourceUris[0]);
                }else{
                	tagELem.text(data.resourceUris[0]);
                }
            },
            onError: me.onMediaServiceError
        });
    }
    me.setMediaServerUrl = function(ms_url){
    	me.baseUrl = ms_url;
    	me.uploadUrl = ms_url+"upload.ajax";
    	me.searchUrl = ms_url+"search";
    }
    me.showSearchMedia = function(sourceElem, dlgId, callback){
        currentSearchSourceElem = $(sourceElem);
        currentSearchCallback = calback;
        $('#'+dlgId).modal('show');
    }
    me.searchMediaByInput = function(inputElem, onSearchResult, onSearchError){
        var inputElem= $(inputElem);

        var key = inputElem.val();
        if (key == ""){
            //resultDiv.html('');
            return;
        }
        BVUtils.searchMediaResource(me.searchUrl, key, onSearchResult, onSearchError | me.onMediaServiceError);
    }
}