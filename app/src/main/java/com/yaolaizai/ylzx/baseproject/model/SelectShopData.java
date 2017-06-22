package com.yaolaizai.ylzx.baseproject.model;

import java.io.Serializable;

/**
 * Created by ylzx on 2017/1/24.
 */
public class SelectShopData implements Serializable {

    private String storeLogoImage;
    private String shopStoreName;
    private String shopStoreSysno;

    public String getShopStoreSysno() {
        return shopStoreSysno;
    }

    public void setShopStoreSysno(String shopStoreSysno) {
        this.shopStoreSysno = shopStoreSysno;
    }

    public String getStoreLogoImage() {
        return storeLogoImage;
    }

    public void setStoreLogoImage(String storeLogoImage) {
        this.storeLogoImage = storeLogoImage;
    }

    public String getShopStoreName() {
        return shopStoreName;
    }

    public void setShopStoreName(String shopStoreName) {
        this.shopStoreName = shopStoreName;
    }
}
