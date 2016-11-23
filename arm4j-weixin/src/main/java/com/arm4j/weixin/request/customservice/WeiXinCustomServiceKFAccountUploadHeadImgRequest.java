package com.arm4j.weixin.request.customservice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arm4j.core.DefaultEntityParam;
import com.arm4j.core.DefaultURLParam;
import com.arm4j.weixin.WeiXinCoreManagement;
import com.arm4j.weixin.WeiXinToken;
import com.arm4j.weixin.exception.WeiXinRequestException;
import com.arm4j.weixin.request.customservice.entity.KFAccountEntity;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liwenhe on 16/11/16.
 */
@SuppressWarnings("unchecked")
public class WeiXinCustomServiceKFAccountUploadHeadImgRequest {

    public static void request(String accessToken, KFAccountEntity entity) throws WeiXinRequestException {

        Map<String, Object> formParamMap = new HashMap<>();
        formParamMap.put(entity.getMedia().getName(), entity.getMedia());

        // 发送请求
        String result = WeiXinCoreManagement.getInstance().get(WeiXinToken.CUSTOM_SERVICE_KF_ACCOUNT_UPLOAD_HEADIMG)
                .createConn()
                .connect(
                        new DefaultURLParam.Builder()
                                .add("access_token", accessToken)
                                .add("kf_account", entity.getKfAccount())
                                .build(),
                        new DefaultEntityParam(JSON.toJSONString(entity))
                ).upload(formParamMap);

        // 处理返回结果
        if (!StringUtils.isEmpty(result)) {
            JSONObject resultJSON = JSON.parseObject(result);
            int errCode = resultJSON.getInteger("errcode");
            if (0 != errCode) {
                throw new WeiXinRequestException(result);
            }
        } else {
            throw new WeiXinRequestException("请求失败,原因[未知]");
        }
    }

}
