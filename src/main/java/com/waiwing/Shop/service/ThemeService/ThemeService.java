package com.waiwing.Shop.service.ThemeService;

import com.waiwing.Shop.model.Temp;
import com.waiwing.Shop.model.Theme;

import java.util.List;
import java.util.Optional;


public interface ThemeService {

    List<Theme> findByNames(List<String> names);

    Optional<Theme> findByName(String name);

}
