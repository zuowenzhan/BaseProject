package com.yaolaizai.ylzx.baseproject.model;

/**
 * Created by ylzx on 2017/3/1.
 */
public class StoreData {

    private String storename;
    private String address;
    private String storelogoimage;


    public String getStorelogoimage() {
        return storelogoimage;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStorelogoimage(String storelogoimage) {
        this.storelogoimage = storelogoimage;
    }
}
