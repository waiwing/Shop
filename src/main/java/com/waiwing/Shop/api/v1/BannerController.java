package com.waiwing.Shop.api.v1;

import com.waiwing.Shop.core.configuration.ExceptionCodeConfiguration;
import com.waiwing.Shop.dto.PersonDTO;
import com.waiwing.Shop.exception.http.ForbiddenException;
import com.waiwing.Shop.service.BannerService;
import com.waiwing.Shop.test.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

@RestController
@RequestMapping("/banner")
@Validated //开启验证
public class BannerController {
    @Autowired
    private BannerService bannerService;
    @Autowired
    private Hero hero;

    @Autowired
    private ExceptionCodeConfiguration exceptionCodeConfiguration;

    @RequestMapping("/test/{id1}")
    public String test(@PathVariable("id1") Integer id, @RequestParam String name) throws Exception {
        hero.oneSkill();
        System.out.println("id = " + id + " name = " + name);
        if (1 == 1)
            throw new ForbiddenException(10001);
        return "hello 邓炜 333   66333323423433336  ff 12312312 +-77777  荣";
    }

    @PostMapping("/bodyParam")
    public PersonDTO bodyParam(@RequestBody @Validated PersonDTO personDTO) throws Exception {
        int a = 10;
//        PersonDTO personDTO1 = new PersonDTO("deng",12);

        PersonDTO personDTO1 = PersonDTO.builder().age(18).name("deng").build();
        return personDTO1;
    }

    @PostMapping("/TestParam/{id}")
    public String TestParam(
            @PathVariable @Max(value = 10, message = "不能太长了") Integer id
    ) throws Exception {
        int i = 10;
        return "success";
    }
}
