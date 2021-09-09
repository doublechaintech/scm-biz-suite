package com.doublechaintech.retailscm.services;

import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.iamservice.BaseIamService;
import com.doublechaintech.retailscm.keypairidentity.KeyPairIdentity;
import com.doublechaintech.retailscm.keypairidentity.KeyPairIdentityTokens;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userapp.UserApp;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
public class IamService extends BaseIamService{


    @Override
    public Map<String, Object> getCachedLoginInfo(RetailscmUserContextImpl userContext) {
        String kpid = userContext.getRequestHeader("kpid");
        if (kpid != null) {
            userContext.setTokenId(kpid);
        }
        checkKPToken(userContext);
        Map<String, Object> cachedLoginInfo = super.getCachedLoginInfo(userContext);
        if (cachedLoginInfo != null){
            return cachedLoginInfo;
        }

        if (kpid == null) {
            return null;
        }

        try {
            KeyPairIdentity identity = loadKeyPairIdentity(userContext, kpid, KeyPairIdentityTokens.start().withSecUser().done());
            SecUser secUser = identity.getSecUser();

            String appId = userContext.getRequestHeader("kpapp");

            UserApp app = null;
            if (appId != null){
                app = userContext.getDAOGroup().getUserAppDAO().load(appId, EO);
                if (!app.getSecUser().getId().equals(secUser.getId())){
                    throwExceptionWithMessage("user :" + secUser.getId() + " selected some other user's app: " + appId);
                }
            }

            if (app == null) {
                SmartList<UserApp> apps = userContext.getDAOGroup().getUserAppDAO().findUserAppBySecUser(secUser.getId(), EO);
                app = apps.first();
                if ( apps.size() == 1) {
                    appId = app.getId();
                }else {
                    throwExceptionWithMessage("user:" + secUser.getId() + " has not select one app");
                }
            }

            HashMap<String, Object> loginInfo = new HashMap<>();
            loginInfo.put("secUser", secUser.getId());
            loginInfo.put("userApp", appId);
            userContext.putToCache(getLoginInfoCacheKey(userContext), loginInfo, getUserTtlInSecond());

            userContext.putToCache(this.getUserKey(userContext), secUser, getUserTtlInSecond());
            userContext.putToCache(this.getCurrentAppKey(userContext), app, getUserTtlInSecond());
            return loginInfo;
        } catch (Exception pE) {
            pE.printStackTrace();
            return EO;
        }
    }

    @Override
    public void onCheckAccessWhenAnonymousFound(RetailscmUserContextImpl userContext, Map<String, Object> loginInfo) {
        String kpid = userContext.getRequestHeader("kpid");
        if (kpid == null){
            super.onCheckAccessWhenAnonymousFound(userContext, loginInfo);
        }
    }

    public String getKPToken(RetailscmUserContext userContext){
        String kpid = userContext.getRequestHeader("kpid");
        if (kpid == null) {
            return null;
        }

        String kptoken = getKPTokenById(userContext, kpid);
        userContext.setResponseHeader("kptoken", kptoken);
        userContext.forceRenderingAsJson();
        return kptoken;
    }

    private String getKPTokenById(RetailscmUserContext userContext, String pKpid) {
        try {
            loadKeyPairIdentity(userContext, pKpid, EO);
        } catch (Exception pE) {
            throwExceptionWithMessage(pE.getMessage());
        }
        String kptoken = userContext.getCachedObject(getKPTokenKey(pKpid), String.class);

        if (kptoken == null) {
            kptoken = UUID.randomUUID().toString();
            userContext.putToCache(getKPTokenKey(pKpid), kptoken, -1);
        }
        return kptoken;
    }

    public String getKPTokenKey(String pKpid) {
        return "kptoken:" + pKpid;
    }

    public void checkKPToken(RetailscmUserContext userContext)  {
        String kpid = userContext.getRequestHeader("kpid");
        if (kpid == null) {
            return;
        }

        String keyToken = getKPTokenById(userContext, kpid);
        String kptoken = userContext.getRequestHeader("kptoken");
        if (kptoken != null && !kptoken.equals(keyToken)) {
            userContext.setResponseHeader("kptoken", keyToken);
            throwExceptionWithMessage("the kptoken was updated, please resubmit request with new kptoken");
        }

        String kpsign = userContext.getRequestHeader("kpsign");
        if (kpsign == null) {
            userContext.setResponseHeader("kptoken", keyToken);
            throwExceptionWithMessage("the kpsign is not submitted, please resubmit request with kpsign");
        }

        //consume the token and prepare next token
        userContext.removeFromCache(getKPTokenKey(kpid));
        getKPToken(userContext);

        boolean verified = false;
        try {
            KeyPairIdentity keyPairIdentity = loadKeyPairIdentity(userContext, kpid,
                    KeyPairIdentityTokens.start()
                            .withKeyType()
                            .done());
            String publicKey = keyPairIdentity.getPublicKey();
            X509EncodedKeySpec spec = new X509EncodedKeySpec(Base64.getMimeDecoder().decode(publicKey));
            String keyType = keyPairIdentity.getKeyType().getKeyAlg();
            KeyFactory keyFactory = KeyFactory.getInstance(keyType);
            PublicKey pub = keyFactory.generatePublic(spec);

            Signature sig = Signature.getInstance(keyPairIdentity.getKeyType().getSignAlg());
            sig.initVerify(pub);
            sig.update(keyToken.getBytes());
            verified = sig.verify(Base64.getDecoder().decode(kpsign));
        }catch (Exception e){
            throwExceptionWithMessage(e.getMessage());
        }

        if (!verified) {
            throwExceptionWithMessage("request signature is invalid");
        }
    }

    public KeyPairIdentity loadKeyPairIdentity(RetailscmUserContext userContext, String pKpid, Map<String, Object> options) throws Exception {
        return userContext.getDAOGroup().getKeyPairIdentityDAO().load(pKpid, options);
    }

    public void throwExceptionWithMessage(String value) {
        throw new RuntimeException(value);
    }

    public static void main(String[] args) throws Exception{
        String priKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMDojDwHngzYuZeo\n" +
                "xJArIbRElL9zWL6oP6XqwHxqkvyUVd/E4i/kjsy+hUfWVyNjpHGLyi+gJ9jpeHCL\n" +
                "mtqKdsp6Ypw2jSX8V35n7wBgGI82+bQLc8+f+BtQZ0D9TkxMlVd9//WrPZtcNur4\n" +
                "glpM6aKQDtDBr1yNropgdrXUC955AgMBAAECgYBUX2G2f75o8AF8i5wtUjAToEtO\n" +
                "0Sxndz8fWmWGBTb0sgw9Kuei+txaQJoaqWzDVbl+0B1GZ04GWVcMIoNAQn9hnWNU\n" +
                "L1c1kBivC7zj7e0a3pBNA1tcNCEcf6SkTANZrY2cGJFOg7LId4KaA99UXLZuJy0N\n" +
                "hAJEyrx/3ORx25CsYQJBAON5suT4OGaUlY28+2w2P2hJ9Cg+0FjozyMa3bPA1I7O\n" +
                "huUfsUKDditmFeCbf9wEnN+jzMRuovc4rpUivceEPpcCQQDZGTJQsa2SxrQ6C0wX\n" +
                "GVHrBfS6DKH4az8GEB8enX4p4nNfhq3Sh+E5AULHy8WvUM/7MiwP+WmFTRwV4bvj\n" +
                "o31vAkEAnavTNiZfYasH5pDhbOZFGRJ5rBOt8pKcUObkWR4Ft16r3dET2tioZfiC\n" +
                "nYbrHyQLYHB3FIjjaJzfVfwYs1yUzQJBANMJTkLo5TzH0cyWzMmrgFlBeesdepm8\n" +
                "zw/6vfWJzWmzyslyZyg/lC1Qz3Te3fUVTof19qU0o2HEWmfe/kFD3RsCQBYh6lou\n" +
                "0uDFZl+icuKrskBLPnJYD4JR7Ns60qcR4rnWR7IUA2S4X/eV3tLT+RqMrhV4//nh\n" +
                "1w3QRrXAEHPqUxk=";
        String text = "1a9d507f-befb-4813-9dd2-145658a26a17";
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(Base64.getMimeDecoder().decode(priKey));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(spec);

        Signature sig = Signature.getInstance("SHA256WithRSA");
        sig.initSign(privateKey);
        sig.update(text.getBytes());

        byte[] sign = sig.sign();
        System.out.println(Base64.getEncoder().encodeToString(sign));
    }
}


















