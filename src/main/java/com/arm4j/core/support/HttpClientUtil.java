package com.arm4j.core.support;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * HttpClient工具类，主要用于get、post、download及下载图片请求
 *
 * @author liwenhe
 */
public class HttpClientUtil {

    private static final Charset DEFAULT_CHARSET = Consts.UTF_8;

    public static final RequestConfig DEFAULT_REQUEST_CONFIG = RequestConfig.custom()
            .setExpectContinueEnabled(true)
            .setSocketTimeout(30000)
            .setConnectTimeout(30000)
            .setConnectionRequestTimeout(30000)
            .build();

    /**
     * 单例调用，并得到CloseableHttpClient
     *
     * @return CloseableHttpClient
     */
    public static CloseableHttpClient getHttpClient() {
        return CustomHttpClient.getInstance().getHttpClient();
    }

    public static String get(String url) throws IOException {
        return get(url, null, null, null);
    }

    public static String get(String url, Charset charset) throws IOException {
        return get(url, charset, null, null);
    }

    public static String get(String url, Charset charset, Map<String, String> headers) throws IOException {
        return get(url, charset, headers, null);
    }

    /**
     * http get请求
     *
     * @param url 请求地址
     * @param charset 字符编码
     * @param headers header配置
     * @param context http上下文
     * @return String
     * @throws IOException
     */
    public static String get(String url, Charset charset, Map<String, String> headers, HttpContext context) throws IOException {
        CloseableHttpClient httpClient = getHttpClient();
        HttpGet get = new HttpGet(url);

        if (null == charset)
            charset = DEFAULT_CHARSET;

        if (null != headers)
            for (String key : headers.keySet())
                get.setHeader(key, headers.get(key));

        CloseableHttpResponse response = httpClient.execute(get, context);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null)
                return EntityUtils.toString(entity, charset);
            else
                return null;
        } finally {
            HttpClientUtils.closeQuietly(response);
        }
    }

    public static InputStream getAsStream(String url) throws IOException {
        CloseableHttpClient httpClient = getHttpClient();
        HttpGet get = new HttpGet(url);

        CloseableHttpResponse response = httpClient.execute(get);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                for (int b; (b = entity.getContent().read()) != -1;) {
                    baos.write(b);
                }

                try {
                    return new ByteArrayInputStream(baos.toByteArray());
                } finally {
                    baos.flush();
                    baos.close();
                }
            } else
                return null;
        } finally {
            HttpClientUtils.closeQuietly(response);
        }
    }

    public static String post(String url, Charset charset, String requestBody) throws IOException {
        return post(url, charset, null, null, null, requestBody, null);
    }

    public static String post(String url, Charset charset, Map<String, String> headers, String requestBody) throws IOException {
        return post(url, charset, headers, null, null, requestBody, null);
    }

    public static String post(String url, Charset charset, Map<String, String> headers, RequestConfig requestConfig,
                              String requestBody) throws IOException {
        return post(url, charset, headers, requestConfig, null, requestBody, null);
    }

    public static String post(String url, Charset charset, Map<String, String> headers, RequestConfig requestConfig,
                              HttpContext context, String requestBody) throws IOException {
        return post(url, charset, headers, requestConfig, context, requestBody, null);
    }

    public static String post(String url, Charset charset, NameValuePair... params) throws IOException {
        return post(url, charset, null, null, null, null, params);
    }

    public static String post(String url, Charset charset, Map<String, String> headers, NameValuePair... params) throws IOException {
        return post(url, charset, headers, null, null, null, params);
    }

    public static String post(String url, Charset charset, Map<String, String> headers, RequestConfig requestConfig,
                              NameValuePair... params) throws IOException {
        return post(url, charset, headers, requestConfig, null, null, params);
    }

    public static String post(String url, Charset charset, Map<String, String> headers, RequestConfig requestConfig,
                              HttpContext context, NameValuePair... params) throws IOException {
        return post(url, charset, headers, requestConfig, context, null, params);
    }

    /**
     * http post请求
     *
     * @param url 请求地址
     * @param charset 字符编码
     * @param headers header配置
     * @param requestConfig 请求配置信息
     * @param context http上下文
     * @param requestBody 请求的文本内容
     * @param params 请求的url表单参数
     * @return String
     * @throws IOException
     */
    public static String post(String url, Charset charset, Map<String, String> headers, RequestConfig requestConfig,
                              HttpContext context, String requestBody, NameValuePair... params) throws IOException {
        if (charset == null)
            charset = DEFAULT_CHARSET;

        if (requestConfig == null)
            requestConfig = DEFAULT_REQUEST_CONFIG;

        StringEntity entity;
        if (StringUtils.isEmpty(requestBody) && null != params) {
            List<NameValuePair> formParams = new ArrayList<NameValuePair>();
            for (NameValuePair p : params) {
                formParams.add(p);
            }
            entity = new UrlEncodedFormEntity(formParams, charset);
        } else {
            entity = new StringEntity(StringUtils.isEmpty(requestBody) ? "" : requestBody, ContentType.create("text/plain", charset));
        }

        HttpPost post = new HttpPost(url);
        post.setEntity(entity);
        post.setConfig(requestConfig);
        if (null != headers)
            for (String key : headers.keySet())
                post.setHeader(key, headers.get(key));

        CloseableHttpClient httpClient = getHttpClient();
        CloseableHttpResponse response = httpClient.execute(post, context);
        try {
            if (response.getStatusLine().getStatusCode() == 302 || response.getStatusLine().getStatusCode() == 301)
                return response.getFirstHeader("Location").toString();
            else {
                HttpEntity resEntity = response.getEntity();
                return EntityUtils.toString(resEntity, charset);
            }
        } finally {
            HttpClientUtils.closeQuietly(response);
        }
    }

    public static InputStream postAsStream(String url, String charset, String requestBody, NameValuePair... params) throws IOException {
        StringEntity entity;
        if (StringUtils.isEmpty(requestBody) && null != params) {
            List<NameValuePair> formParams = new ArrayList<NameValuePair>();
            for (NameValuePair p : params) {
                formParams.add(p);
            }
            entity = new UrlEncodedFormEntity(formParams, charset);
        } else {
            entity = new StringEntity(StringUtils.isEmpty(requestBody) ? "" : requestBody, ContentType.create("text/plain", charset));
        }

        HttpPost post = new HttpPost(url);
        post.setEntity(entity);

        CloseableHttpClient httpClient = getHttpClient();
        CloseableHttpResponse response = httpClient.execute(post);
        try {
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                for (int b; (b = entity.getContent().read()) != -1;) {
                    baos.write(b);
                }

                try {
                    return new ByteArrayInputStream(baos.toByteArray());
                } finally {
                    baos.flush();
                    baos.close();
                }
            } else
                return null;
        } finally {
            HttpClientUtils.closeQuietly(response);
        }
    }
}