package com.arm4j.core;

/**
 * 该类主要用于生成 {@code HttpURLConn}
 *
 * @author liwenhe
 */
public class HttpURLConnFactory {

    private final static String DEFAULT_CHARSET = "UTF-8";

    private String url;

    private String charset;

    /**
     * 初始化所需参数
     * 其中charset默认为UTF-8 {@code DEFAULT_CHARSET}
     *
     * @param url http请求地址
     */
    public HttpURLConnFactory(String url) {
        this(url, DEFAULT_CHARSET);
    }

    /**
     * 初始化所需参数
     *
     * @param url http请求地址
     * @param charset 字符编码
     */
    public HttpURLConnFactory(String url, String charset) {
        this.url = url;
        this.charset = charset;
    }

    /**
     * 生成{@code HttpURLConn}
     *
     * @return HttpURLConn
     */
    public HttpURLConn createConn() {
        return new HttpURLConn(url, charset);
    }

    /**
     * 生成{@code HttpURLConn}
     *
     * @param delegate 自定义http请求委托类，如果该值为{null}，则使用默认http请求
     * @return HttpURLConn
     */
    public HttpURLConn createConn(Class<?> delegate) {
        return new HttpURLConn(url, charset, delegate);
    }

}
