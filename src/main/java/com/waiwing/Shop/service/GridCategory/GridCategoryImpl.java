package com.waiwing.Shop.service.GridCategory;

import com.waiwing.Shop.model.GridCategory;
import com.waiwing.Shop.model.Temp;
import com.waiwing.Shop.repository.GridCategoryRepository;
import com.waiwing.Shop.repository.TempRepository;
import com.waiwing.Shop.service.temp.TempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GridCategoryImpl implements GridCategoryService {

    @Autowired
    private GridCategoryRepository gridCategoryRepository;

    public List<GridCategory> getGridCategoryLIst() {
        return gridCategoryRepository.findAll();
    }
}
