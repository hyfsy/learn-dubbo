package com.hyf.dubbo;

import com.hyf.dubbo.api.Invoker;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

/**
 * @author baB_hyf
 * @date 2022/04/17
 */
public class SPITests {

    @Test
    public void testA() {

        // singleton

        ExtensionLoader<Invoker> extensionLoader = ExtensionLoader.getExtensionLoader(Invoker.class);

        Invoker invoker = extensionLoader.getDefaultExtension();

        Invoker a = extensionLoader.getExtension("a");

        Invoker adaptiveInvoker = extensionLoader.getAdaptiveExtension();
        URL url = URL.valueOf("dubbo://localhost/a");
        adaptiveInvoker.dynamicUseWhichDefault(url); // use a
        url = URL.valueOf("dubbo://localhost?url-param-b=a");
        adaptiveInvoker.dynamicUseWhich("xxx", url); // use a

        url = URL.valueOf("dubbo://localhost?ac=p1,p2");
        extensionLoader.getActivateExtension(url, "ac");
        extensionLoader.getActivateExtension(url, new String[]{"a", "b", "c"});

        List<Invoker> loadedExtensionInstances = extensionLoader.getLoadedExtensionInstances();
        Set<Invoker> supportedExtensionInstances = extensionLoader.getSupportedExtensionInstances();

    }
}
