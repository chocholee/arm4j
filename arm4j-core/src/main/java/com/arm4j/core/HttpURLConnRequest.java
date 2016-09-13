package com.arm4j.core;

import java.io.InputStream;
import java.util.Map;

/**
 * 此类为真实地http请求处理类
 *
 * @author liwenhe
 */
public interface HttpURLConnRequest {

    /**
     * http get方法
     *
     * @return String
     */
    String doGet();

    /**
     * http get方法
     *
     * @return InputStream
     */
    InputStream doGetAsStream();

    /**
     * http post方法
     *
     * @return String
     */
    String doPost();

    /**
     * http post方法
     *
     * @return InputStream
     */
    InputStream doPostAsStream();

    /**
     * http 表单上传
     *
     * @param forms 表单参数(Object可以使用如下类型：File、byte[]、InputStream、String)
     * @return String
     */
    String upload(Map<String, Object> forms);

}
