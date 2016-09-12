package com.arm4j.weixin.request.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arm4j.core.DefaultURLParam;
import com.arm4j.weixin.WeiXinCoreManagement;
import com.arm4j.weixin.WeiXinToken;
import com.arm4j.weixin.exception.WeiXinRequestException;
import com.arm4j.weixin.request.user.response.UserListResponse;
import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("unchecked")
public class WeiXinUserListGetRequest {

    public static UserListResponse request(String accessToken) throws WeiXinRequestException {
        // 发送请求
        String result = WeiXinCoreManagement.getInstance().get(WeiXinToken.USER_LIST_GET)
                .createConn()
                .connect(
                        new DefaultURLParam.Builder()
                                .add("access_token", accessToken)
                                .build()
                ).doGet();

        // 处理返回结果
        if (!StringUtils.isEmpty(result)) {
            JSONObject resultJSON = JSON.parseObject(result);
            if (!resultJSON.containsKey("errcode")) {
                return JSON.parseObject(result, UserListResponse.class);
            } else {
                throw new WeiXinRequestException(result);
            }
        }
        throw new WeiXinRequestException("请求失败,原因[未知]");
    }

    public static UserListResponse request(String accessToken, String nextOpenId) throws WeiXinRequestException {
        // 发送请求
        String result = WeiXinCoreManagement.getInstance().get(WeiXinToken.USER_LIST_GET)
                .createConn()
                .connect(
                        new DefaultURLParam.Builder()
                                .add("access_token", accessToken)
                                .add("next_openid", nextOpenId)
                                .build()
                ).doGet();

        // 处理返回结果
        if (!StringUtils.isEmpty(result)) {
            JSONObject resultJSON = JSON.parseObject(result);
            if (!resultJSON.containsKey("errcode")) {
                return JSON.parseObject(result, UserListResponse.class);
            } else {
                throw new WeiXinRequestException(result);
            }
        }
        throw new WeiXinRequestException("请求失败,原因[未知]");
    }

}
