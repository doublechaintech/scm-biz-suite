
/* 图片自动上传 */
var uploadCount = 0, uploadList = [];
var uploadCountDom = document.getElementById("uploadCount");
weui.uploader('#uploader', {
    url: 'http://' + location.hostname + ':8002/upload',
    auto: true,
    type: 'file',
    fileVal: 'fileVal',
    compress: {
        width: 1600,
        height: 1600,
        quality: .8
    },
    onBeforeQueued: function(files) {
        if(["image/jpg", "image/jpeg", "image/png", "image/gif"].indexOf(this.type) < 0){
            weui.alert('请上传图片');
            return false;
        }
        if(this.size > 10 * 1024 * 1024){
            weui.alert('请上传不超过10M的图片');
            return false;
        }
        if (files.length > 5) { // 防止一下子选中过多文件
            weui.alert('最多只能上传5张图片，请重新选择');
            return false;
        }
        if (uploadCount + 1 > 5) {
            weui.alert('最多只能上传5张图片');
            return false;
        }

        ++uploadCount;
        uploadCountDom.innerHTML = uploadCount;
    },
    onQueued: function(){
        uploadList.push(this);
        console.log(this);
    },
    onBeforeSend: function(data, headers){
        console.log(this, data, headers);
        // $.extend(data, { test: 1 }); // 可以扩展此对象来控制上传参数
        // $.extend(headers, { Origin: 'http://127.0.0.1' }); // 可以扩展此对象来控制上传头部

        // return false; // 阻止文件上传
    },
    onProgress: function(procent){
        console.log(this, procent);
    },
    onSuccess: function (ret) {
        console.log(this, ret);
    },
    onError: function(err){
        console.log(this, err);
    }
});

// 缩略图预览
document.querySelector('#uploaderFiles').addEventListener('click', function(e){
    var target = e.target;

    while(!target.classList.contains('weui-uploader__file') && target){
        target = target.parentNode;
    }
    if(!target) return;

    var url = target.getAttribute('style') || '';
    var id = target.getAttribute('data-id');

    if(url){
        url = url.match(/url\((.*?)\)/)[1].replace(/"/g, '');
    }
    var gallery = weui.gallery(url, {
        className: 'custom-name',
        onDelete: function(){
            weui.confirm('确定删除该图片？', function(){
                --uploadCount;
                uploadCountDom.innerHTML = uploadCount;


                for (var i = 0, len = uploadList.length; i < len; ++i) {
                    var file = uploadList[i];
                    if(file.id == id){
                        file.stop();
                        break;
                    }
                }
                target.remove();
                gallery.hide();
            });
        }
    });
});


/* 图片手动上传 */
var uploadCustomFileList = [];

// 这里是简单的调用，其余api请参考文档
weui.uploader('#uploaderCustom', {
    url: 'http://localhost:8002/upload',
    auto: false,
    onQueued: function() {
        uploadCustomFileList.push(this);
    }
});

// 手动上传按钮
document.getElementById("uploaderCustomBtn").addEventListener('click', function(){
    uploadCustomFileList.forEach(function(file){
        file.upload();
    });
});

// 缩略图预览
document.querySelector('#uploaderCustomFiles').addEventListener('click', function(e){
    var target = e.target;

    while(!target.classList.contains('weui-uploader__file') && target){
        target = target.parentNode;
    }
    if(!target) return;

    var url = target.getAttribute('style') || '';
    var id = target.getAttribute('data-id');

    if(url){
        url = url.match(/url\((.*?)\)/)[1].replace(/"/g, '');
    }
    var gallery = weui.gallery(url, {
        onDelete: function(){
            weui.confirm('确定删除该图片？', function(){
                var index;
                for (var i = 0, len = uploadCustomFileList.length; i < len; ++i) {
                    var file = uploadCustomFileList[i];
                    if(file.id == id){
                        index = i;
                        break;
                    }
                }
                if(index !== undefined) uploadCustomFileList.splice(index, 1);

                target.remove();
                gallery.hide();
            });
        }
    });
});