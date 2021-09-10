var appServer = 'http://localhost:8080/naf/secUserManager/testoss/';
var bucket = 'bbt-img';
var region = 'oss-cn-shanghai';
var urllib = OSS.urllib;
var OSS = OSS.Wrapper;
var STS = OSS.STS;
var applyTokenDo = function (func) {
  var url = appServer;
  return urllib.request(url, {
    method: 'GET'
  }).then(function (result) {
    var creds = JSON.parse(result.data);
    console.log(creds);
    var client = new OSS({
      endpoint:"https://oss-cn-shanghai.aliyuncs.com/",
      region: region,
      accessKeyId: creds.accessKeyId,
      accessKeySecret: creds.accessKeySecret,
      stsToken: creds.securityToken,
      bucket: bucket
    });
    return func(client);
  });
};
var progress = function (p) {
  return function (done) {
    var bar = document.getElementById('progress-bar');
    bar.style.width = Math.floor(p * 100) + '%';
    bar.innerHTML = Math.floor(p * 100) + '%';
    done();
  }
};
var uploadFile = function (client) {
  var file = document.getElementById('file').files[0];
  var key = document.getElementById('object-key-file').value.trim() || 'object';
  console.log(file.name + ' => ' + key);
  return client.multipartUpload(key, file, {
    progress: progress
  }).then(function (res) {
    console.log('upload success: %j', res);
    return listFiles(client);
  });
};
window.onload = function () {
  document.getElementById('file-button').onclick = function () {
    applyTokenDo(uploadFile);
  }
};