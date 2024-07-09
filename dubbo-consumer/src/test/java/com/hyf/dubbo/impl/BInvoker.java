package com.hyf.dubbo.impl;

import com.hyf.dubbo.api.Invoker;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Activate;

/**
 * @author baB_hyf
 * @date 2022/04/17
 */
@Activate
public class BInvoker implements Invoker {
    @Override
    public void invoke() {
        System.out.println("B");
    }

    @Override
    public String dynamicUseWhichDefault(URL url) {
        return null;
    }

    @Override
    public String dynamicUseWhich(String placeholder, URL url) {
        return "B";
    }
}
