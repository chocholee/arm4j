package com.arm4j.weixin.request.customservice.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.File;

/**
 * Created by liwenhe on 16/11/16.
 */
public class KFAccountEntity {

    @JSONField(name = "kf_account")
    private String kfAccount;

    @JSONField(name = "kf_nick")
    private String kfNick;

    @JSONField(name = "kf_id")
    private String kfId;

    @JSONField(name = "nickname")
    private String nickname;

    @JSONField(name = "password")
    private String password;

    @JSONField(serialize = false, name = "media")
    private File media;

    public String getKfAccount() {
        return kfAccount;
    }

    public String getKfNick() {
        return kfNick;
    }

    public String getKfId() {
        return kfId;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public File getMedia() {
        return media;
    }

    public void setKfAccount(String kfAccount) {
        this.kfAccount = kfAccount;
    }

    public void setKfNick(String kfNick) {
        this.kfNick = kfNick;
    }

    public void setKfId(String kfId) {
        this.kfId = kfId;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMedia(File media) {
        this.media = media;
    }
}
