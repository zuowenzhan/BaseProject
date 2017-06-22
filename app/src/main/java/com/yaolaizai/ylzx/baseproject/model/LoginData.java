package com.yaolaizai.ylzx.baseproject.model;

import java.util.List;
import java.util.Map;

/**
 * Created by ylzx on 2017/3/1.
 */
public class LoginData {
    private Employee employee;
    private String imPassword;
    private String imUsername;
    private String isAdmin;
    private String sysno;
    private StoreData store;
    private Map<String,String> menuMap;
    private String[] topicIdStrList;
    private String loginSign;

    public String getLoginSign() {
        return loginSign;
    }

    public void setLoginSign(String loginSign) {
        this.loginSign = loginSign;
    }

    private Vendor vendor;
    private List<SelectShopData> employeeStoreRealtionList;

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public List<SelectShopData> getEmployeeStoreRealtionList() {
        return employeeStoreRealtionList;
    }

    public void setEmployeeStoreRealtionList(List<SelectShopData> employeeStoreRealtionList) {
        this.employeeStoreRealtionList = employeeStoreRealtionList;
    }

    public String[] getTopicIdStrList() {
        return topicIdStrList;
    }

    public void setTopicIdStrList(String[] topicIdStrList) {
        this.topicIdStrList = topicIdStrList;
    }

    public Map<String, String> getMenuMap() {
        return menuMap;
    }

    public void setMenuMap(Map<String, String> menuMap) {
        this.menuMap = menuMap;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getImPassword() {
        return imPassword;
    }

    public void setImPassword(String imPassword) {
        this.imPassword = imPassword;
    }

    public String getImUsername() {
        return imUsername;
    }

    public void setImUsername(String imUsername) {
        this.imUsername = imUsername;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getSysno() {
        return sysno;
    }

    public void setSysno(String sysno) {
        this.sysno = sysno;
    }

    public StoreData getStore() {
        return store;
    }

    public void setStore(StoreData store) {
        this.store = store;
    }
}
