package com.arm4j.weixin.request.material;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arm4j.core.DefaultURLParam;
import com.arm4j.weixin.WeiXinCoreManagement;
import com.arm4j.weixin.WeiXinToken;
import com.arm4j.weixin.exception.WeiXinRequestException;
import com.arm4j.weixin.request.material.entity.MediaEntity;
import com.arm4j.weixin.request.material.entity.MediaType;
import com.arm4j.weixin.request.material.response.MediaResponse;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class WeiXinMaterialAddMaterialRequest {

    public static MediaResponse request(String accessToken, MediaType type, MediaEntity entity) throws WeiXinRequestException {
        Map<String, Object> formParamMap = new HashMap<>();
        formParamMap.put(entity.getName(), entity.getFile());

        if (type == MediaType.VIDEO) {
            formParamMap.put("description", JSON.toJSONString(entity));
        }

        // 发送请求
        String result = WeiXinCoreManagement.getInstance().get(WeiXinToken.MATERIAL_ADD_MATERIAL)
                .createConn()
                .connect(
                        new DefaultURLParam.Builder()
                                .add("access_token", accessToken)
                                .add("type", type.getName())
                                .build()
                ).upload(formParamMap);

        // 处理返回结果
        if (!StringUtils.isEmpty(result)) {
            JSONObject resultJSON = JSON.parseObject(result);
            if (!resultJSON.containsKey("errcode")) {
                MediaResponse response = JSON.parseObject(result, MediaResponse.class);
                response.setType(MediaType.valueOfBy(resultJSON.getString("type")));
                return response;
            } else {
                throw new WeiXinRequestException(result);
            }
        }
        throw new WeiXinRequestException("请求失败,原因[未知]");
    }

}
