package com.dm.controller;

import com.dm.domain.Info;
import com.dm.RestClientUtil;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping(value="/test")
@RestController
public class TestController {

    @RequestMapping(value="/get/{id}", produces="application/json;charset=UTF-8")
    public Info testDefaultClient(@PathVariable int id) {
        Info info = RestClientUtil.exchange("http://localhost:9000/test/get0/{id}",
                HttpMethod.GET, Info.class, new String[]{String.valueOf(id)});
        return info;
    }

    @RequestMapping(value = "/get/post/{id}",produces ="application/json;charset=UTF-8" )
    public String testPostForEntity(@PathVariable int id){
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<String> responseEntity=restTemplate.postForEntity("http://localhost:9000/test/get01/{id}",null,String.class,id);
        String info=responseEntity.getBody();
        return info;
    }



    @RequestMapping(value="/httpclient-get/{id}", produces="application/json;charset=UTF-8")
    public Info testHttpClient(@PathVariable int id) {
        RestClientUtil.setClientFlag(RestClientUtil.HTTP_CLIENT);
        Info info = RestClientUtil.exchange("http://localhost:9000/test/get0/{id}",
                HttpMethod.GET, Info.class, new String[]{String.valueOf(id)});
        return info;
    }

    @RequestMapping(value="/okhttpclient-get/{id}", produces="application/json;charset=UTF-8")
    public Info testOkHttpClient(@PathVariable int id) {
        RestClientUtil.setClientFlag(RestClientUtil.OKHTTP_CLIENT);
        Info info = RestClientUtil.exchange("http://localhost:9000/test/get0/{id}",
                HttpMethod.GET, Info.class, new String[]{String.valueOf(id)});
        return info;
    }

    @RequestMapping(value="/netty4httpclient-get/{id}", produces="application/json;charset=UTF-8")
    public Info testNetty4HttpClient(@PathVariable int id) {
        RestClientUtil.setClientFlag(RestClientUtil.NETTY4_CLIENT);
        Info info = RestClientUtil.exchange("http://localhost:9000/test/get0/{id}",
                HttpMethod.GET, Info.class, new String[]{String.valueOf(id)});
        return info;
    }

    @RequestMapping(value="/jersey-get/{id}", produces="application/json;charset=UTF-8")
    public Info testJersey(@PathVariable int id){
        RestClientUtil.setClientFlag(RestClientUtil.JERSEY);
        Info info = RestClientUtil.exchange("http://localhost:9000/test/get0/{id}",
                HttpMethod.GET, Info.class, new String[]{String.valueOf(id)});
        return info;
    }

    /**
     * 被调用的接口
     * @param id
     * @return
     */
    @RequestMapping(value="/get0/{id}")
    public Info get(@PathVariable int id) {
        Info info = new Info();
        info.setId(id);
        return info;
    }
    @RequestMapping(value="/get01/{id}")
    public String  get1(@PathVariable int id) {
        Info info = new Info();
        info.setId(id);
        return info.toString();
    }

}
