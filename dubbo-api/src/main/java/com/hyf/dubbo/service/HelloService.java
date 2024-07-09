package com.hyf.dubbo.service;

import com.hyf.dubbo.pojo.Hello;

import java.util.List;

/**
 * @author baB_hyf
 * @date 2022/04/15
 */
public interface HelloService {

    Hello find(Integer id);

    List<Hello> list();

    int add(Hello hello);
}
