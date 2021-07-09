package com.yxz.boottest.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ServicetestImpl {
    //这个是异步，不是什么多线程
    @Async
    public void putCodeToCash(String type) throws Exception {

        if ("eat0".equals(type)) {
            Thread.sleep(5000);
        }
        if ("eat1".equals(type)) {
            Thread.sleep(20000);
        }
        System.out.println("eat".equals(type)?"":"");
        System.out.println(type);

    }

    public void putCash(String type) throws Exception {

        if ("eat0".equals(type)) {
            Thread.sleep(5000);
        }
        if ("eat1".equals(type)) {
            Thread.sleep(20000);
        }
        System.out.println(type);

    }
}
