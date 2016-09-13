package com.arm4j.core;

import com.arm4j.core.exception.HttpURLConnRequestException;
import com.arm4j.core.support.HttpClientUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * 默认实现{@code HttpURLConnRequest}
 * 依赖于HttpClient第三方包
 *
 * @author liwenhe
 */
public class DefaultHttpURLConnRequest implements HttpURLConnRequest {

    private String url;

    private String charset;

    private DefaultURLParam urlParam;

    private DefaultEntityParam entityParam;

    public DefaultHttpURLConnRequest(String url,
                                     String charset,
                                     DefaultURLParam urlParam,
                                     DefaultEntityParam entityParam) {
        this.charset = charset;
        this.urlParam = urlParam;
        this.entityParam = entityParam;
        this.url = (null != this.urlParam && !StringUtils.isEmpty(this.urlParam.getParam()))
                ? url.concat("?").concat(this.urlParam.getParam())
                : url;
    }

    public String doGet() {
        try {
            return HttpClientUtil.get(url, Charset.forName(charset));
        } catch (IOException e) {
            throw new HttpURLConnRequestException("send an get request failed, url \'" + url + "\'" , e);
        }
    }

    public InputStream doGetAsStream() {
        try {
            return HttpClientUtil.getAsStream(url);
        } catch (IOException e) {
            throw new HttpURLConnRequestException("send an get request failed, url \'" + url + "\'", e);
        }
    }

    public String doPost() {
        try {
            return HttpClientUtil.post(url, Charset.forName(charset), (null != entityParam) ? entityParam.getParam() : null);
        } catch (IOException e) {
            throw new HttpURLConnRequestException("send an post request failed, url \'" + url + "\'" , e);
        }
    }

    public InputStream doPostAsStream() {
        try {
            return HttpClientUtil.postAsStream(url, charset, (null != entityParam) ? entityParam.getParam() : null);
        } catch (IOException e) {
            throw new HttpURLConnRequestException("send an post request failed, url \'" + url + "\'", e);
        }
    }

    public String upload(String name, File file) {
        try {
            return HttpClientUtil.upload(url, charset, name, file);
        } catch (IOException e) {
            throw new HttpURLConnRequestException("send an post request failed, url \'" + url + "\'" , e);
        }
    }
}
