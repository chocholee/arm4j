package com.arm4j.weixin.request.material;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arm4j.core.DefaultURLParam;
import com.arm4j.weixin.WeiXinCoreManagement;
import com.arm4j.weixin.WeiXinToken;
import com.arm4j.weixin.exception.WeiXinRequestException;
import com.arm4j.weixin.request.material.entity.MediaEntity;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class WeiXinMediaUploadImgToUrlRequest {

    public static String request(String accessToken, MediaEntity entity) throws WeiXinRequestException {
        Map<String, Object> formParamMap = new HashMap<>();
        formParamMap.put(entity.getName(), entity.getFile());

        // 发送请求
        String result = WeiXinCoreManagement.getInstance().get(WeiXinToken.MEDIA_UPLOAD_IMG_TO_URL)
                .createConn()
                .connect(
                        new DefaultURLParam.Builder()
                                .add("access_token", accessToken)
                                .build()
                ).upload(formParamMap);

        // 处理返回结果
        if (!StringUtils.isEmpty(result)) {
            JSONObject resultJSON = JSON.parseObject(result);
            if (!resultJSON.containsKey("errcode")) {
                return resultJSON.getString("url");
            } else {
                throw new WeiXinRequestException(result);
            }
        }
        throw new WeiXinRequestException("请求失败,原因[未知]");
    }

}
