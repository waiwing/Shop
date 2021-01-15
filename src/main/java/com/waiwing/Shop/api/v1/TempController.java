package com.waiwing.Shop.api.v1;

import com.waiwing.Shop.model.Temp;
import com.waiwing.Shop.service.temp.TempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@ResponseBody
@RestController
@RequestMapping("temp")
public class TempController {

    @Autowired
    private TempService tempService;

    @GetMapping("id/{id}")
    public Temp getAll(@PathVariable Long id) {
       return tempService.getById(id);

    }
}
