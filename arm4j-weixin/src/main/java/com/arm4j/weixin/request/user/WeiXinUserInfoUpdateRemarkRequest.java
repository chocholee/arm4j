package com.arm4j.weixin.request.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arm4j.core.DefaultEntityParam;
import com.arm4j.core.DefaultURLParam;
import com.arm4j.weixin.WeiXinCoreManagement;
import com.arm4j.weixin.WeiXinToken;
import com.arm4j.weixin.exception.WeiXinRequestException;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class WeiXinUserInfoUpdateRemarkRequest {

    public static boolean request(String accessToken, String openid, String remark) throws WeiXinRequestException {
        Map<String, Object> userInfoMap = new HashMap<>();
        userInfoMap.put("openid", openid);
        userInfoMap.put("remark", remark);

        // 发送请求
        String result = WeiXinCoreManagement.getInstance().get(WeiXinToken.USER_INFO_UPDATE_REMARK)
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
            int errCode = resultJSON.getInteger("errcode");
            return 0 == errCode;
        }
        throw new WeiXinRequestException("请求失败,原因[未知]");
    }

}
