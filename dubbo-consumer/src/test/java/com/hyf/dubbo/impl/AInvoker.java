package com.hyf.dubbo.impl;

import com.hyf.dubbo.api.Invoker;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.extension.DisableInject;
import org.apache.dubbo.common.extension.Wrapper;

/**
 * @author baB_hyf
 * @date 2022/04/17
 */
@DisableInject // IOC -> SPI or Spring
@Wrapper(matches = "b", mismatches = "c") // AOP
@Activate
public class AInvoker implements Invoker {

    private Invoker self;
    private Invoker delegate;

    public AInvoker(Invoker delegate) {
        this.delegate = delegate;
    }

    @DisableInject
    public void setNone(Invoker self) {
        this.self = self;
    }

    @Activate(group = {"invoker-wrapper-group"}, value = {"ac:p1", "ac:p2"}, order = -1)
    @Override
    public void invoke() {
        System.out.println("A");
        delegate.invoke();
    }

    @Override
    public String dynamicUseWhichDefault(URL url) {
        System.out.println("A");
        return delegate.dynamicUseWhichDefault(url);
    }

    @Override
    public String dynamicUseWhich(String placeholder, URL url) {
        System.out.println("A");
        return delegate.dynamicUseWhich(placeholder, url);
    }

}
