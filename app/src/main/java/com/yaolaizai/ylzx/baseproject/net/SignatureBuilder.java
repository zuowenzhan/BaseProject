package com.yaolaizai.ylzx.baseproject.net;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zwq1 on 2016/7/24.
 */
public final class SignatureBuilder {


    private String signatureKey;

    private SignatureType signatureType;


    private HashMap<String, String> data;


    private static final String DEFAULT_ENCODING = "utf-8";

    public SignatureBuilder() {
    }

    public void SignatureBuilder(String signatureKey, SignatureType signatureType, HashMap<String, String> data) throws Exception {

        try {
            if (null == data) {

            }
            if (null == signatureKey) {

            }
            this.data=data;
            this.signatureType=signatureType;
            this.signatureKey=signatureKey;
        } catch (Exception ex) {
          throw  ex;
        }
    }


    /// <summary>
    /// Builds the signature.
    /// </summary>
    /// <returns></returns>
    public String BuildSignature() throws Exception {

        String returnStr = new String();

        try {
            switch (signatureType) {

                case MD5:

                    returnStr = SignDataByMD5(data, signatureKey);

                    break;

                default:
            }
        } catch (Exception ex) {
            throw new SignatureException(ex.getMessage());
        }
        return returnStr;
    }


    /// <summary>
    /// Signs the data by M d5.
    /// </summary>
    /// <param name="data">The parameter.</param>
    /// <param name="signatureKey">The signature key.</param>
    /// <returns></returns>

    private static String SignDataByMD5(HashMap<String, String> data, String signatureKey) {

        byte[] bytes = null;

        String signStr = signatureKey.concat(PopulateSignData(data)).concat(signatureKey);

        signStr  = MD5Util.md5(signStr);

        return signStr;

    }


    /// <summary>
    /// Populates the sign data.
    /// </summary>
    /// <param name="data">The parameter.</param>
    /// <returns></returns>
    private static String PopulateSignData(HashMap<String, String> data) {

        HashMap<String, String> sortedParams = new HashMap<String, String>();

        for (Map.Entry<String, String> entry : data.entrySet()) {
            String key = entry.getKey();
            String keyValue = entry.getValue();

                sortedParams.put(key, keyValue);
        }

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> entry : MapUtil.sortMapByKey(sortedParams).entrySet()) {
            String key = entry.getKey();
            String keyValue = entry.getValue();
            if (!(key == null || key.length() <= 0) && !(keyValue == null || keyValue.length() <= 0)) {

                sb.append(key).append(keyValue);
            }
        }

        return sb.toString();
    }
}
