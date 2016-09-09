package com.arm4j.core;

import com.arm4j.core.exception.HttpURLConnRequestException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * http请求适配器
 * 该类主要用于执行继承{@code HttpURLConnRequest}接口的相应的类
 * 默认的{@code HttpURLConnRequest}接口的子类为{@code DefaultHttpURLConnRequest}
 *
 * @author liwenhe
 */
public class HttpURLConnRequestAdapter {

    private static final String DEFAULT_CHARSET = "UTF-8";

    private Class<?> delegate;

    /**
     * 初始化委托类
     *
     * @param delegate 该值可以为{null}
     */
    public HttpURLConnRequestAdapter(Class<?> delegate) {
        this.delegate = delegate;
    }

    public HttpURLConnRequest onExecute(String url) {
        return this.onExecute(url, DEFAULT_CHARSET, null, null);
    }

    public HttpURLConnRequest onExecute(String url, String charset, DefaultURLParam urlParam) {
        return this.onExecute(url, charset, urlParam, null);
    }

    public HttpURLConnRequest onExecute(String url, String charset, DefaultEntityParam entityParam) {
        return this.onExecute(url, charset, null, entityParam);
    }

    /**
     * 此方法用于生成相应的{@code HttpURLConnRequest}类
     *
     * @param url 请求地址
     * @param charset 字符编码
     * @param urlParam url参数
     * @param entityParam entity参数
     * @return HttpURLConnRequest
     */
    public HttpURLConnRequest onExecute(String url, String charset, DefaultURLParam urlParam, DefaultEntityParam entityParam) {
        if (delegate != null) {
            // acquire parameter
            Object[] arguments = new Object[]{url, charset, urlParam, entityParam};
            // invoke mehtod
            return (HttpURLConnRequest) this.invoke(arguments);
        } else {
            return new DefaultHttpURLConnRequest(url, charset, urlParam, entityParam);
        }
    }

    /**
     * 通过反射找到构造函数并实例化
     *
     * @param arguments 实例化时所需参数
     * @return Object
     */
    protected Object invoke(Object[] arguments) {
        try {
            // determine if delegate is an sub class of HttpURLConnRequest
            if (HttpURLConnRequest.class.isAssignableFrom(delegate)) {
                Class<?>[] parameterTypes = new Class<?>[0];
                for (Constructor c : delegate.getConstructors()) {
                    if (arguments.length == c.getParameterTypes().length) {
                        parameterTypes = c.getParameterTypes();
                        break;
                    }
                }
                // get constructor by delegate's field
                Constructor targetConstructor = delegate.getConstructor(parameterTypes);
                targetConstructor.setAccessible(true);
                // get instance
                return targetConstructor.newInstance(arguments);
            }
            throw new HttpURLConnRequestException("delegate field is \'" + delegate.getSimpleName() + "\' and it is not an sub class of HttpURLConnRequest");
        } catch (NoSuchMethodException e) {
            throw new HttpURLConnRequestException("a matching method is not found", e);
        } catch (InstantiationException e) {
            throw new HttpURLConnRequestException("constructor represents an abstract class", e);
        } catch (IllegalAccessException e) {
            throw new HttpURLConnRequestException("constructor object is enforcing Java language access control and the underlying constructor is inaccessible", e);
        } catch (InvocationTargetException e) {
            throw new HttpURLConnRequestException("invoke constructor failed", e);
        }
    }
}
