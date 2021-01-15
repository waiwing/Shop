package com.waiwing.Shop.service.category;

import com.waiwing.Shop.model.Category;
import com.waiwing.Shop.model.Temp;

import java.util.List;
import java.util.Map;


public interface CategoryService {
    public Map<Integer, List<Category>> getAll();

}
