package com.arm4j.weixin.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arm4j.core.DefaultURLParam;
import com.arm4j.weixin.WeiXinCoreManagement;
import com.arm4j.weixin.WeiXinToken;
import com.arm4j.weixin.exception.WeiXinRequestException;
import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("unchecked")
public class WeiXinGetCallbackIpRequest {

    public static String[] request(String accessToken) throws WeiXinRequestException {
        // 发送请求
        String result = WeiXinCoreManagement.getInstance().get(WeiXinToken.GET_CALLBACK_IP)
                .createConn()
                .connect(
                        new DefaultURLParam.Builder()
                                .add("access_token", accessToken)
                                .build()
                ).doGet();

        // 处理返回结果
        if (!StringUtils.isEmpty(result)) {
            JSONObject resultJSON = JSON.parseObject(result);
            if (resultJSON.containsKey("ip_list")) {
                String[] ips = new String[resultJSON.getJSONArray("ip_list").size()];
                return resultJSON.getJSONArray("ip_list").toArray(ips);
            } else {
                throw new WeiXinRequestException(result);
            }
        }
        throw new WeiXinRequestException("请求失败,原因[未知]");
    }

}
