package com.arm4j.weixin.request.menu.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class MenuMatchRuleEntity {

    @JSONField(name = "group_id")
    private String groupId;

    @JSONField(name = "sex")
    private String sex;

    @JSONField(name = "country")
    private String country;

    @JSONField(name = "province")
    private String province;

    @JSONField(name = "city")
    private String city;

    @JSONField(name = "client_platform_type")
    private String clientPlatformType;

    @JSONField(name = "language")
    private String language;

    public String getGroupId() {
        return groupId;
    }

    public String getSex() {
        return sex;
    }

    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getClientPlatformType() {
        return clientPlatformType;
    }

    public String getLanguage() {
        return language;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setClientPlatformType(String clientPlatformType) {
        this.clientPlatformType = clientPlatformType;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
