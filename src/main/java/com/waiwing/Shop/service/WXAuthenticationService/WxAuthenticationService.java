package com.waiwing.Shop.service.WXAuthenticationService;


import java.util.Map;

public interface WxAuthenticationService {
    public String code2Session(String code);

    public Boolean verfity(String token);

}
