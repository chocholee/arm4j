package com.arm4j.weixin.request.accesstoken;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arm4j.core.DefaultURLParam;
import com.arm4j.weixin.WeiXinCoreManagement;
import com.arm4j.weixin.WeiXinToken;
import com.arm4j.weixin.exception.WeiXinRequestException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liwenhe on 2016/9/30.
 *
 * @author 李文禾
 */
@SuppressWarnings("unchecked")
public class WeiXinJsApiTicketAccessTokenRequest {

    private static Logger LOGGER = LoggerFactory.getLogger(WeiXinAccessTokenRequest.class);

    public static String request(String accessToken, String type) throws WeiXinRequestException {
        // 发送请求
        String result = WeiXinCoreManagement.getInstance().get(WeiXinToken.JS_API_TICKET_ACCESS_TOKEN)
                .createConn()
                .connect(
                        new DefaultURLParam.Builder()
                                .add("access_token", accessToken)
                                .add("type", type)
                                .build()
                ).doGet();

        // 处理返回结果
        if (!StringUtils.isEmpty(result)) {
            JSONObject resultJSON = JSON.parseObject(result);
            if (resultJSON.containsKey("ticket"))
                return resultJSON.getString("ticket");
            else {
                throw new WeiXinRequestException(result);
            }
        }
        throw new WeiXinRequestException("请求失败,原因[未知]");
    }

}
