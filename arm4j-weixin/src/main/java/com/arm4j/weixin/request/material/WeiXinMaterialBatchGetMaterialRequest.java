package com.arm4j.weixin.request.material;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arm4j.core.DefaultEntityParam;
import com.arm4j.core.DefaultURLParam;
import com.arm4j.weixin.WeiXinCoreManagement;
import com.arm4j.weixin.WeiXinToken;
import com.arm4j.weixin.exception.WeiXinRequestException;
import com.arm4j.weixin.request.material.entity.MediaType;
import com.arm4j.weixin.request.material.response.batchget.BatchGetResponse;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class WeiXinMaterialBatchGetMaterialRequest {

    /**
     *
     * @param accessToken
     * @param type MediaType.THUMB不可用，其它的都可以使用
     * @param offset 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
     * @param count 返回素材的数量，取值在1到20之间
     * @return BatchGetResponse
     * @throws WeiXinRequestException
     */
    public static BatchGetResponse request(String accessToken, MediaType type, int offset, int count) throws WeiXinRequestException {
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("type", type.getName());
        bodyMap.put("offset", offset);
        bodyMap.put("count", count);

        // 发送请求
        String result = WeiXinCoreManagement.getInstance().get(WeiXinToken.MATERIAL_BATCH_GET_MATERIAL)
                .createConn()
                .connect(
                        new DefaultURLParam.Builder()
                                .add("access_token", accessToken)
                                .build(),
                        new DefaultEntityParam(JSON.toJSONString(bodyMap))
                ).doPost();

        // 处理返回结果
        if (!StringUtils.isEmpty(result)) {
            JSONObject resultJSON = JSON.parseObject(result);
            if (!resultJSON.containsKey("errcode")) {
                return JSON.parseObject(result, BatchGetResponse.class);
            } else {
                throw new WeiXinRequestException(result);
            }
        }
        throw new WeiXinRequestException("请求失败,原因[未知]");
    }

}
