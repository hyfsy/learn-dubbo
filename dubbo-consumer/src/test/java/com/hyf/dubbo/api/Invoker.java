package com.hyf.dubbo.api;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author baB_hyf
 * @date 2022/04/17
 */
@SPI("a") // must
public interface Invoker {

    void invoke();

    @Adaptive
    String dynamicUseWhichDefault(URL url);

    @Adaptive(value = {"url-param-a", "url-param-b"})
    String dynamicUseWhich(String placeholder, URL url);
}
