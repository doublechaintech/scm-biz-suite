import Base64Util from './base64-util';
import { Base64 } from 'crypto-es/lib/enc-base64';
import { HmacSHA1 } from 'crypto-es/lib/sha1';

export type OssTokenDTO = {
  type: 'qiniu' | 'aliyun';
  expiration: string;
  userHome: string;
  prefix: string;
  uploadPrefix: string;
  accessKeyId: string;
  accessKeySecret: string;
  securityToken: string;
  bucket: string;
};

function getAliyunConfig(ossToken: OssTokenDTO) {
  const { accessKeyId, accessKeySecret, securityToken } = ossToken || {};

  const policyText = {
    // "expiration": ossConfig.expiration,
    expiration: new Date(Date.now() + 60000).toISOString(),
    conditions: [
      ['content-length-range', 0, 20 * 1024 * 1024], // 设置上传文件的大小限制,5mb
      { bucket: ossToken.bucket },
    ],
  };
  const policy = Base64Util.encode(JSON.stringify(policyText));
  const signature = Base64.stringify(HmacSHA1(policy, accessKeySecret));
  console.log('policypolicy', policy, signature);
  return {
    policy,
    Signature: signature,
    signature,
    OSSAccessKeyId: accessKeyId,
    'x-oss-security-token': securityToken,
    success_action_status: '200',
  };
}

export default getAliyunConfig;
