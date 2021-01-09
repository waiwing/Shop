package com.waiwing.Shop.core.hack;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * 重写路由
 */
public class AutoPrefixUrlMapping extends RequestMappingHandlerMapping {
    @Value("${api-package}")
    private String apiPackagePath;

    /**
     * 改写路由
     * @param method
     * @param handlerType
     * @return
     */
    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo requestMappingInfo = super.getMappingForMethod(method, handlerType);
        if (requestMappingInfo != null) {
            String preFiex = getPreFix(handlerType);
            //返回一个新的mapping
            return RequestMappingInfo.paths(preFiex).build().combine(requestMappingInfo);
        }
        return requestMappingInfo;
    }

    /**
     * 获取前缀
     * @param handlerType
     * @return
     */
    private String getPreFix(Class<?> handlerType) {
        String packageName = handlerType.getPackage().getName();
        String dotPath = packageName.replaceAll(this.apiPackagePath, "").replace(".", "/");
        return dotPath;
    }
}
