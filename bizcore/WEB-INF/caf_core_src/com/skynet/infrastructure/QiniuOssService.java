package com.skynet.infrastructure;

import com.qiniu.storage.Region;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.terapico.utils.DateTimeUtil;
import com.terapico.utils.MapUtil;

import java.util.Date;
import java.util.Map;

public class QiniuOssService implements StorageService {

    private QiniuConfiguration mQiniuConfiguration;

    public QiniuConfiguration getQiniuConfiguration() {
        return mQiniuConfiguration;
    }

    public void setQiniuConfiguration(QiniuConfiguration pQiniuConfiguration) {
        mQiniuConfiguration = pQiniuConfiguration;
    }

    @Override
    public Map<String, Object> genToken(Object context) {
        if (context instanceof String) {
            return this.ossHome((String) context);
        }

        return null;


    }

    private Map<String, Object> ossHome(String home) {
        String accessKey = mQiniuConfiguration.accessKey;
        String secretKey = mQiniuConfiguration.secretKey;
        String bucket = mQiniuConfiguration.bucket;
        Auth auth = Auth.create(accessKey, secretKey);

        StringMap policy = new StringMap().put("isPrefixalScope", 1);

        String upToken = auth.uploadToken(bucket, home, 120, policy);

        Date expirationTime = DateTimeUtil.addMS(new Date(), 1000 * mQiniuConfiguration.timeout);

        return  MapUtil.put("securityToken", upToken)
                .put("userHome", home)
                .put("bucket", bucket)
                .put("uploadPrefix", mQiniuConfiguration.uploadPrefix)
                .put("prefix", mQiniuConfiguration.downloadPrefix)
                .put("type", "qiniu")
                .put("expiration", DateTimeUtil.formatDate(expirationTime, "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"))
                .into_map();
    }


    @Override
    public String upload(String objName, byte[] content) {
        return null;
    }

}
