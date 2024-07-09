package com.hyf.dubbo.controller;

import com.hyf.dubbo.pojo.Hello;
import com.hyf.dubbo.service.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baB_hyf
 * @date 2022/04/15
 */
@RestController
public class HelloController {

    @DubboReference(version = "1.0.0")
    private HelloService helloService;

    @RequestMapping("hello/{id}")
    public Hello hello(@PathVariable Integer id) {
        return helloService.find(id);
    }
}
