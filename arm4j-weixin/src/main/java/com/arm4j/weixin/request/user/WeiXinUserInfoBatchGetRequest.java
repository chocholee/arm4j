package com.arm4j.weixin.request.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arm4j.core.DefaultEntityParam;
import com.arm4j.core.DefaultURLParam;
import com.arm4j.weixin.WeiXinCoreManagement;
import com.arm4j.weixin.WeiXinToken;
import com.arm4j.weixin.exception.WeiXinRequestException;
import com.arm4j.weixin.request.user.entity.UserInfoBatchGetEntity;
import com.arm4j.weixin.request.user.entity.UserInfoEntity;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class WeiXinUserInfoBatchGetRequest {

    public static List<UserInfoEntity> request(String accessToken, List<UserInfoBatchGetEntity> entities) throws WeiXinRequestException {
        Map<String, List<UserInfoBatchGetEntity>> userInfoMap = new HashMap<>();
        userInfoMap.put("user_list", entities);

        // 发送请求
        String result = WeiXinCoreManagement.getInstance().get(WeiXinToken.USER_INFO_BATCH_GET)
                .createConn()
                .connect(
                        new DefaultURLParam.Builder()
                                .add("access_token", accessToken)
                                .build(),
                        new DefaultEntityParam(JSON.toJSONString(userInfoMap))
                ).doPost();

        // 处理返回结果
        if (!StringUtils.isEmpty(result)) {
            JSONObject resultJSON = JSON.parseObject(result);
            if (!resultJSON.containsKey("errcode")) {
                return JSON.parseArray(resultJSON.getString("user_info_list"), UserInfoEntity.class);
            } else {
                throw new WeiXinRequestException(result);
            }
        }
        throw new WeiXinRequestException("请求失败,原因[未知]");
    }

    public static UserInfoEntity request(String accessToken, String openid) throws WeiXinRequestException {
        // 发送请求
        String result = WeiXinCoreManagement.getInstance().get(WeiXinToken.USER_INFO_GET)
                .createConn()
                .connect(
                        new DefaultURLParam.Builder()
                                .add("access_token", accessToken)
                                .add("openid", openid)
                                .build()
                ).doGet();

        // 处理返回结果
        if (!StringUtils.isEmpty(result)) {
            JSONObject resultJSON = JSON.parseObject(result);
            if (!resultJSON.containsKey("errcode")) {
                return JSON.parseObject(result, UserInfoEntity.class);
            } else {
                throw new WeiXinRequestException(result);
            }
        }
        throw new WeiXinRequestException("请求失败,原因[未知]");
    }

}
