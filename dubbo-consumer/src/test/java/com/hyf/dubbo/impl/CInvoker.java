package com.hyf.dubbo.impl;

import com.hyf.dubbo.api.Invoker;
import org.apache.dubbo.common.URL;

/**
 * @author baB_hyf
 * @date 2022/04/17
 */
public class CInvoker implements Invoker {
    @Override
    public void invoke() {
        System.out.println("C");
    }

    @Override
    public String dynamicUseWhichDefault(URL url) {
        return null;
    }

    @Override
    public String dynamicUseWhich(String placeholder, URL url) {
        return "C";
    }
}
