package com.arm4j.weixin.request.menu.entity.menu;

import com.alibaba.fastjson.annotation.JSONField;

public class MenuMatchRuleEntity {

    @JSONField(name = "tag_id")
    private String tagId;

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

    public String getTagId() {
        return tagId;
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

    public void setTagId(String tagId) {
        this.tagId = tagId;
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
