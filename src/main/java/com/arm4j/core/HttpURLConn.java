package com.arm4j.core;

/**
 * 该类用于传递http请求参数
 * 重载connect方法，通过 {@code HttpURLConnRequestAdapter} 适配器使用相应的http请求
 *
 * @author liwenhe
 */
public class HttpURLConn {

    private String url;

    private String charset;

    private Class<?> delegate;

    private DefaultURLParam urlParam;

    private DefaultEntityParam entityParam;

    public HttpURLConn(String url, String charset) {
        this(url, charset, null, null, null);
    }

    public HttpURLConn(String url, String charset, Class<?> delegate) {
        this(url, charset, delegate, null, null);
    }

    /**
     * 初始化相应参数
     *
     * @param url 请求地址
     * @param charset 字符编码
     * @param delegate 委托类
     * @param urlParam url参数
     * @param entityParam entity参数
     */
    public HttpURLConn(String url, String charset, Class<?> delegate, DefaultURLParam urlParam, DefaultEntityParam entityParam) {
        this.url = url;
        this.charset = charset;
        this.delegate = delegate;
        this.urlParam = urlParam;
        this.entityParam = entityParam;
    }

    /**
     * 执行适配器{@code HttpURLConnRequestAdapter}方法
     * 此方法没有url参数、entity参数
     *
     * @return HttpURLConnRequest
     */
    public HttpURLConnRequest connect() {
        return new HttpURLConnRequestAdapter(delegate).onExecute(url, charset, null, null);
    }

    /**
     * 执行适配器{@code HttpURLConnRequestAdapter}方法
     * 此方法没有entity参数
     *
     * @param urlParam url参数
     * @return HttpURLConnRequest
     */
    public HttpURLConnRequest connect(DefaultURLParam urlParam) {
        return new HttpURLConnRequestAdapter(delegate).onExecute(url, charset, urlParam, null);
    }

    /**
     * 执行适配器{@code HttpURLConnRequestAdapter}方法
     * 此方法没有url参数
     *
     * @param entityParam entity参数
     * @return HttpURLConnRequest
     */
    public HttpURLConnRequest connect(DefaultEntityParam entityParam) {
        return new HttpURLConnRequestAdapter(delegate).onExecute(url, charset, null, entityParam);
    }

    /**
     * 执行适配器{@code HttpURLConnRequestAdapter}方法
     *
     * @param urlParam url参数
     * @param entityParam entity参数
     * @return HttpURLConnRequest
     */
    public HttpURLConnRequest connect(DefaultURLParam urlParam, DefaultEntityParam entityParam) {
        return new HttpURLConnRequestAdapter(delegate).onExecute(url, charset, urlParam, entityParam);
    }

}
