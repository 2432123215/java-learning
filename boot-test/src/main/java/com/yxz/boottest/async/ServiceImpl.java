package com.yxz.boottest.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ServiceImpl implements ApplicationRunner {

    @Autowired
    private ServicetestImpl servicetest;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        for ( int i = 0; i <= 5; i++) {
            servicetest.putCodeToCash("eat" + i);
        }
    }
}
