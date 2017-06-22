package com.yaolaizai.ylzx.baseproject.rx;

import com.yaolaizai.ylzx.baseproject.net.DES3Util;
import com.yaolaizai.ylzx.baseproject.net.SignUtils;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/5.
 */
public class HttpUtils {


    public static  Map<String, String> gethttpMap(HashMap<String, String> sortedParams) {

        Map<String, String> params = null;

        try {
            sortedParams.put("access_token", "63f98ceb50374558b0b2f9b54cc8e613");//固定传参
            String sign = null;
            sign = SignUtils.sign("2ef6cb136bdf4e54b3b64347adf7069f", sortedParams);

            params = new HashMap<String, String>();
            params.put("appid", "600000");
            params.put("sign_type", "APP");
            params.put("sign", sign);

            for (Map.Entry<String, String> entry : sortedParams.entrySet()) {

                params.put(entry.getKey(), URLEncoder.encode(DES3Util.encode(entry.getValue(), "2ef6cb136bdf4e54b3b64347adf7069f")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return params;

    }
}
