package com.dm.client;

import org.springframework.http.client.OkHttpClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * ljx
 */
public class OkHttpRestClient {

    private static RestTemplate restTemplate;

    static
    {
        OkHttpClientHttpRequestFactory okHttpClientHttpRequestFactory = new OkHttpClientHttpRequestFactory();
        okHttpClientHttpRequestFactory.setReadTimeout(5000);
        okHttpClientHttpRequestFactory.setConnectTimeout(5000);

        // 添加转换器
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        messageConverters.add(new FormHttpMessageConverter());
        messageConverters.add(new MappingJackson2XmlHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());

        restTemplate = new RestTemplate(messageConverters);
        restTemplate.setRequestFactory(okHttpClientHttpRequestFactory);
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());

        System.out.println("OkHttpRestClient初始化完成");
    }

    public static RestTemplate getClient() {
        return restTemplate;
    }
}
