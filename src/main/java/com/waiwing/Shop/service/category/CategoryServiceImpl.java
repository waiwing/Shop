package com.waiwing.Shop.service.category;

import com.waiwing.Shop.model.Category;
import com.waiwing.Shop.model.Temp;
import com.waiwing.Shop.repository.CategoryRepository;
import com.waiwing.Shop.repository.TempRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public  Map<Integer, List<Category>> getAll() {
        List<Category> roots = categoryRepository.findAllByIsRootOrderByIndexAsc(true);
        List<Category> subs = categoryRepository.findAllByIsRootOrderByIndexAsc(false);
        Map<Integer, List<Category>> map = new HashMap<Integer, List<Category>>();
        map.put(1,roots);
        map.put(2,subs);
        return map;
    }
}
