package com.yaolaizai.ylzx.baseproject.net;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/9/9.
 */
public class SignUtils {

    public static String sign(String serviceKey, HashMap<String, String> sortedParams) throws Exception {

        SignatureBuilder checkSign = new SignatureBuilder();
        checkSign.SignatureBuilder(serviceKey, SignatureType.MD5, sortedParams);//验签
        return checkSign.BuildSignature();
    }
}
