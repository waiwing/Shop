package com.waiwing.Shop.service.ThemeService;

import com.waiwing.Shop.model.Temp;
import com.waiwing.Shop.model.Theme;
import com.waiwing.Shop.repository.TempRepository;
import com.waiwing.Shop.repository.ThemeRepository;
import com.waiwing.Shop.service.temp.TempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeServiceImpl implements ThemeService {

    @Autowired
    private ThemeRepository themeRepository;

    public List<Theme> findByNames(List<String> names){
        return themeRepository.findByNames(names);
    }

    public Optional<Theme> findByName(String name) {
        return  themeRepository.findByName(name);
    }
}
