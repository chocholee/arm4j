package com.arm4j.core;

import java.io.File;
import java.io.InputStream;

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
     * @param name 名称(用于后台接收的参数名称)
     * @param file 上传文件
     * @return
     */
    String upload(String name, File file);

}
