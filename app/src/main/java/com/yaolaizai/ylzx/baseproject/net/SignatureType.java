package com.yaolaizai.ylzx.baseproject.net;

/**
 * Created by zwq1 on 2016/7/24.
 */
public enum SignatureType {

    Unknown(-1),
    MD5(0) ,
    RSA(1) ,
    DSA(2) ;
    private int index;

    SignatureType(int idx) {
        this.index = idx;
    }

    public int getIndex() {
        return index;
    }
}
