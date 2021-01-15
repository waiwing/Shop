package com.waiwing.Shop.api.v1;

import com.waiwing.Shop.exception.http.NotFoundException;
import com.waiwing.Shop.model.Category;
import com.waiwing.Shop.model.GridCategory;
import com.waiwing.Shop.service.GridCategory.GridCategoryService;
import com.waiwing.Shop.service.category.CategoryService;
import com.waiwing.Shop.vo.CategoryAllVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@ResponseBody
@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GridCategoryService gridCategoryService;

    @GetMapping("/all")
    public CategoryAllVO getAll() {
        Map<Integer, List<Category>> list = categoryService.getAll();
        return new CategoryAllVO(list);
    }

    @GetMapping("/grid/all")
    public List<GridCategory> getGridCategoryLIst() {

        List<GridCategory> list = gridCategoryService.getGridCategoryLIst();
        if(list.isEmpty()){
            throw  new NotFoundException(30009);
        }
        return list;
    }
}
