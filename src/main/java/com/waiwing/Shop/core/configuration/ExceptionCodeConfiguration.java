package com.waiwing.Shop.core.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 异常代码，关联配置文件和类
 */
@Component
@ConfigurationProperties(prefix = "lin")
@PropertySource(value="classpath:config/exception-code.properties")
public class ExceptionCodeConfiguration {
    private Map<Integer, String> codes = new HashMap<Integer, String>();

    public Map<Integer, String> getCodes() {
        return codes;
    }

    public void setCodes(Map<Integer, String> codes) {
        this.codes = codes;
    }

    public String getMessage(int code){
        String message = codes.get(code);
        return message;
    }
}
