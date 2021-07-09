package com.yxz.boottest.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class DemoCotroller {

    @Autowired
    private ServicetestImpl servicetest;

    @Async
    @RequestMapping(value = "/demon", method = RequestMethod.GET)
    public void testdemon() throws Exception {

        for (int i = 0; i <= 5; i++) {
            servicetest.putCash("eat" + i);
//            CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
//                try {
//                    putCodeToCash("eat" + finalI);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                return "";
//
//            });
        }
    }

}


