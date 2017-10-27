package com.dm.test;

import com.dm.domain.Info;
import com.dm.RestClientUtil;
import org.springframework.http.HttpMethod;

public class Boostrap {

    public static void main(String[] args)
    {
        //System.out.println("000");
        //ClassPathXmlApplicationContext cpac = new ClassPathXmlApplicationContext("jdk-rest.xml");
        //cpac.getBean("simpleRestTemplate");
        Info info = RestClientUtil.exchange("http://localhost:8080/demo/get/{id}", HttpMethod.GET, Info.class, new String[]{"1"});
        System.out.println(info);
        //Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
//        StackTraceElement[] stackElements = new Throwable().getStackTrace();
//        if(stackElements != null)
//        {
//            for(int i = 0; i < stackElements.length; i++)
//            {
//                System.out.println(""+ stackElements[i]);
//            }
//        }
        //StackTraceElement[] eles = Thread.currentThread().getStackTrace();
        //Thread.dumpStack();
        //System.out.println(map);
    }
}
