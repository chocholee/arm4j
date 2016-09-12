package com.arm4j.weixin.request.accesstoken;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arm4j.core.DefaultURLParam;
import com.arm4j.weixin.WeiXinToken;
import com.arm4j.weixin.WeiXinCoreManagement;
import com.arm4j.weixin.exception.WeiXinRequestException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unchecked")
public class WeiXinAccessTokenRequest {

    private static Logger LOGGER = LoggerFactory.getLogger(WeiXinAccessTokenRequest.class);

    public static String request(String grantType, String appid, String secret) throws WeiXinRequestException {
        // 发送请求
        String result = WeiXinCoreManagement.getInstance().get(WeiXinToken.ACCESS_TOKEN)
                .createConn()
                .connect(
                        new DefaultURLParam.Builder()
                                .add("grant_type", grantType)
                                .add("appid", appid)
                                .add("secret", secret)
                                .build()
                ).doGet();

        // 处理返回结果
        if (!StringUtils.isEmpty(result)) {
            JSONObject resultJSON = JSON.parseObject(result);
            if (resultJSON.containsKey("access_token"))
                return resultJSON.getString("access_token");
            else {
                throw new WeiXinRequestException(result);
            }
        }
        throw new WeiXinRequestException("请求失败,原因[未知]");
    }

}
