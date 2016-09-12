package com.arm4j.weixin.request.user.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class UserInfoEntity {

    @JSONField(name = "subscribe")
    private Integer subscribe;

    @JSONField(name = "sex")
    private Integer sex;

    @JSONField(name = "groupid")
    private Integer groupId;

    @JSONField(name = "openid")
    private String  openId;

    @JSONField(name = "nickname")
    private String  nickname;

    @JSONField(name = "language")
    private String  language;

    @JSONField(name = "city")
    private String  city;

    @JSONField(name = "province")
    private String  province;

    @JSONField(name = "country")
    private String  country;

    @JSONField(name = "headimgurl")
    private String  headImgUrl;

    @JSONField(name = "unionid")
    private String  unionId;

    @JSONField(name = "remark")
    private String  remark;

    @JSONField(name = "subscribe_time")
    private Long    subscribeTime;

    @JSONField(name = "tagid_list")
    private List<Integer> tagIdList;

    public Integer getSubscribe() {
        return subscribe;
    }

    public Integer getSex() {
        return sex;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public String getOpenId() {
        return openId;
    }

    public String getNickname() {
        return nickname;
    }

    public String getLanguage() {
        return language;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public String getUnionId() {
        return unionId;
    }

    public String getRemark() {
        return remark;
    }

    public Long getSubscribeTime() {
        return subscribeTime;
    }

    public List<Integer> getTagIdList() {
        return tagIdList;
    }

    public void setSubscribe(Integer subscribe) {
        this.subscribe = subscribe;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setSubscribeTime(Long subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public void setTagIdList(List<Integer> tagIdList) {
        this.tagIdList = tagIdList;
    }
}
