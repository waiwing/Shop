package com.waiwing.Shop.vo;

import com.waiwing.Shop.core.enumeration.LoginType;
import com.waiwing.Shop.dto.validators.TokenPassword;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TokenGetDTO {
    @NotBlank(message = "accounrt不能为空")
    private  String account;
    @TokenPassword(max = 32,message = "{token.password}")
    private  String password;
    //登录类型
    private LoginType type;
}
