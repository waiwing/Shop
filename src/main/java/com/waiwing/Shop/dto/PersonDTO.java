package com.waiwing.Shop.dto;


import com.waiwing.Shop.dto.validators.PasswordEqual;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
//@Setter
@Builder
@PasswordEqual(min=4,max = 10,message = "密码不一样")
//@AllArgsConstructor
public class PersonDTO {
    @NonNull
    @Length(min = 2,max = 10,message = "傻逼嘛哈哈")
    private String name;
    private Integer age;

    private String password1;
    private String password2;
}
