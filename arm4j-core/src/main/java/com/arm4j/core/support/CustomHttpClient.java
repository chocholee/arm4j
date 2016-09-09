package com.arm4j.core.support;

import org.apache.http.Consts;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.security.KeyStore;

/**
 * 这是一个单例类，自定义HttpClient配置信息
 * 自定义ssl配置
 * 自定义socket配置
 * 自定义Connection配置
 *
 * @author liwenhe
 */
public class CustomHttpClient {

    private static final Logger logger = LoggerFactory.getLogger(CustomHttpClient.class);

    private static CustomHttpClient instance;

    private CloseableHttpClient httpClient;

    /**
     * 初始化配置信息
     *
     */
    private CustomHttpClient() {
        this(null);
    }

    /**
     * 初始化配置信息
     *
     * @param keyStore 加密证书
     */
    private CustomHttpClient(KeyStore keyStore) {
        try {
            SSLContext sslContext = null;
            if (null != keyStore)
                sslContext = SSLContexts.custom()
                        .loadTrustMaterial(keyStore, new TrustSelfSignedStrategy())
                        .build();

            // ssl连接处理,有证书加载证书,无证书加载默认
            SSLConnectionSocketFactory sslConnectionSocketFactory;
            if (null != sslContext)
                sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext);
            else
                sslConnectionSocketFactory = SSLConnectionSocketFactory.getSocketFactory();

            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.getSocketFactory())
                    .register("https", sslConnectionSocketFactory)
                    .build();

            // Create socket configuration
            SocketConfig socketConfig = SocketConfig.custom()
                    .setSoTimeout(30000)
                    .setTcpNoDelay(true)
                    .build();

            // Create connection configuration
            ConnectionConfig connectionConfig = ConnectionConfig.custom()
                    .setCharset(Consts.UTF_8)
                    .build();

            PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);
            cm.setMaxTotal(200);
            cm.setDefaultMaxPerRoute(20);
            cm.setDefaultSocketConfig(socketConfig);
            cm.setDefaultConnectionConfig(connectionConfig);

            this.httpClient = HttpClients.custom()
                    .setConnectionManager(cm)
                    .build();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("ssl加载失败", e);
        }
    }

    /**
     * 实例化后获取httpClient
     *
     * @return CloseableHttpClient
     */
    public CloseableHttpClient getHttpClient() {
        return httpClient;
    }

    /**
     * 单例调用
     *
     * @return CustomHttpClient
     */
    public static CustomHttpClient getInstance() {
        if (null == instance) {
            synchronized (CustomHttpClient.class) {
                if (null == instance) {
                    instance = new CustomHttpClient();
                }
            }
        }
        return instance;
    }

    /**
     * 单例调用
     *
     * @return CustomHttpClient
     */
    public static CustomHttpClient getInstance(KeyStore keyStore) {
        if (null != instance) {
            synchronized (CustomHttpClient.class) {
                if (null == instance) {
                    instance = new CustomHttpClient(keyStore);
                }
            }
        }
        return instance;
    }
}
