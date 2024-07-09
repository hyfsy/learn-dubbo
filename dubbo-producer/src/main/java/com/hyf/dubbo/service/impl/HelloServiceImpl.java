package com.hyf.dubbo.service.impl;

import com.hyf.dubbo.pojo.Hello;
import com.hyf.dubbo.service.HelloService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Arrays;
import java.util.List;

/**
 * @author baB_hyf
 * @date 2022/04/15
 */
@DubboService(version = "1.0.0")
public class HelloServiceImpl implements HelloService {

    @Override
    public Hello find(Integer id) {
        return new Hello(1, "zs");
    }

    @Override
    public List<Hello> list() {
        return Arrays.asList(new Hello(1, "zs"), new Hello(2, "ls"));
    }

    @Override
    public int add(Hello hello) {
        System.out.println("add hello: " + hello);
        return 1;
    }
}
