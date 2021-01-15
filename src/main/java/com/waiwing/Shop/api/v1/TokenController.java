package com.waiwing.Shop.api.v1;

import com.waiwing.Shop.dto.TokenDto;
import com.waiwing.Shop.service.WXAuthenticationService.WxAuthenticationService;
import com.waiwing.Shop.vo.TokenGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private WxAuthenticationService wxAuthenticationService;

    @PostMapping("")
    public Map<String, String> getToken(@RequestBody @Validated TokenGetDTO userData) {

        Map<String, String> map = new HashMap<String, String>();
        String token = null;
        switch (userData.getType()) {
            case USER_WX:
                token = wxAuthenticationService.code2Session(userData.getAccount());
                break;
            case USER_EMAI:
                break;
        }

        map.put("token", token);
        return map;
    }

    @PostMapping("/verify")
    public Map<String, Boolean> verify(@RequestBody @NotBlank TokenDto tokenDto) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("is_verfity", wxAuthenticationService.verfity(tokenDto.getToken()));
        return map;
    }

}
