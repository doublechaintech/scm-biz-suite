import NavigationService from '@/nice-router/navigation-service';
import { isNotEmpty } from '@/nice-router/nice-router-util';
import { ApiConfig } from '@/utils/config';
import { formatTime } from '@/utils/index';
import Taro from '@tarojs/taro';
import getAliyunConfig, { OssTokenDTO } from './aliyun-oss-helper';

export type FileUploadTask = {
  url: string;
};
export type FileUploadProps = {
  todoList: FileUploadTask[];
  onProgress: any;
  onStart?: Function;
  onComplete?: Function;
  onSuccess?: (sourceFile: string, remoteFile: string) => void;
  onFail?: (err: Taro.General.CallbackResult) => void;
};

let ossToken: OssTokenDTO;

function isValidateToken(): boolean {
  if (isNotEmpty(ossToken) && isNotEmpty(ossToken.expiration)) {
    const expr = new Date(ossToken.expiration);
    // 5分钟提前量
    return expr.valueOf() < Date.now() - 1000 * 300;
  }
  return false;
}

function getFileName(filePath = '') {
  const startPos = filePath.lastIndexOf('.');
  const enPos = filePath.length;
  const suffix = filePath.substring(startPos + 1, enPos);
  const randomFileName = formatTime(Date.now(), 'yyyyMMddhhmmss_') + (Math.random() * 1000000 + 100000).toFixed();
  return `${randomFileName}.${suffix}`;
}

function uploadFiles(params: FileUploadProps) {
  const { todoList = [] } = params || {};
  if (todoList.length === 0) {
    console.warn('nothing to upload!');
    return;
  }
  if (isValidateToken()) {
    console.log('validatae...token');
    uploadFiles2OSS(params);
  } else {
    console.log('need-new token');
    NavigationService.ajax(
      ApiConfig.OSSToken,
      {},
      {
        onSuccess: (resp) => {
          console.log('need-new resp', resp);
          ossToken = resp;
          uploadFiles2OSS(params);
        },
      }
    );
  }
}

function uploadFiles2OSS(params: FileUploadProps) {
  const { todoList, onProgress, onStart, onComplete, onSuccess, onFail } = params || {};
  const { type = 'qiniu', uploadPrefix = '', prefix = '', userHome = '' } = ossToken;

  let formParam: any = { token: ossToken.securityToken };
  if (type === 'aliyun') {
    formParam = getAliyunConfig(ossToken);
  }

  todoList.map(async (it) => {
    if (onStart) {
      onStart(it);
    }

    const fileName = getFileName(it.url);
    const key = `${userHome}/${fileName}`;
    await Taro.showLoading({ title: '上传凭证中' });

    const uploadTask = Taro.uploadFile({
      url: uploadPrefix || prefix,
      filePath: it.url,
      name: 'file',
      formData: {
        key,
        ...formParam,
      },
      // @ts-ignore
      headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
      success: (resp) => {
        console.log('upload file result', resp);
        const remoteFile = prefix + '/' + key;
        if (onSuccess) {
          onSuccess(it.url, remoteFile);
        }
      },
      fail: (err) => {
        Taro.showToast({
          title: `上传失败: ${JSON.stringify(err)}`,
          icon: 'none',
          duration: 2 * 1000,
        });
        if (onFail) {
          onFail(err);
        }
      },
      complete: (res) => {
        console.log('complete', res);
        Taro.hideLoading();
        if (onComplete) {
          onComplete();
        }
      },
    });
    if (onProgress) {
      uploadTask.progress(onProgress);
    }
  });
}

export default uploadFiles;
