package com.yaolaizai.ylzx.baseproject.model;

/**
 * Created by Administrator on 2016/11/4.
 * 员工所有信息
 * 里面包含许多参数
 * 目前之用到了店铺id
 */
public class Employee {

    //店铺id
    private String shopsysno;
    //用户昵称
    private String name;
    //头像地址
    private String headImageurl;
    //店鋪名
    private String storeName;
    //职务
    private String departmentname;
    //员工id
    private String sysno;
    //商户id
    private String vendorsysno;

    public String getSysno() {
        return sysno;
    }

    public void setSysno(String sysno) {
        this.sysno = sysno;
    }

    public String getVendorsysno() {
        return vendorsysno;
    }

    public void setVendorsysno(String vendorsysno) {
        this.vendorsysno = vendorsysno;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getShopsysno() {
        return shopsysno;
    }

    public void setShopsysno(String shopsysno) {
        this.shopsysno = shopsysno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadImageurl() {
        return headImageurl;
    }

    public void setHeadImageurl(String headImageurl) {
        this.headImageurl = headImageurl;
    }
}
