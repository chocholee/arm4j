package com.arm4j.weixin.request.customservice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arm4j.core.DefaultURLParam;
import com.arm4j.weixin.WeiXinCoreManagement;
import com.arm4j.weixin.WeiXinToken;
import com.arm4j.weixin.exception.WeiXinRequestException;
import com.arm4j.weixin.request.customservice.entity.KFAccountEntity;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by liwenhe on 16/11/16.
 */
@SuppressWarnings("unchecked")
public class WeiXinCustomServiceGetKFListRequest {

    public static List<KFAccountEntity> request(String accessToken) throws WeiXinRequestException {
        // 发送请求
        String result = WeiXinCoreManagement.getInstance().get(WeiXinToken.CUSTOM_SERVICE_GET_KF_LIST)
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
                return JSON.parseArray(result, KFAccountEntity.class);
            } else {
                throw new WeiXinRequestException(result);
            }
        }
        throw new WeiXinRequestException("请求失败,原因[未知]");
    }

}
