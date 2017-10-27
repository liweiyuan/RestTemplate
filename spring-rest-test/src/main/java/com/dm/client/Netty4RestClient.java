package com.dm.client;

import org.springframework.http.client.Netty4ClientHttpRequestFactory;
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
public class Netty4RestClient {

    private static RestTemplate restTemplate;

    static
    {
        Netty4ClientHttpRequestFactory netty4ClientHttpRequestFactory = new Netty4ClientHttpRequestFactory();
        netty4ClientHttpRequestFactory.setConnectTimeout(5000);
        netty4ClientHttpRequestFactory.setReadTimeout(5000);

        // 添加转换器
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        messageConverters.add(new FormHttpMessageConverter());
        messageConverters.add(new MappingJackson2XmlHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());

        restTemplate = new RestTemplate(messageConverters);
        restTemplate.setRequestFactory(netty4ClientHttpRequestFactory);
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());

        System.out.println("Netty4RestClient初始化完成");
    }

    public Netty4RestClient(){}

    public static RestTemplate getClient() {
        return restTemplate;
    }
}
