package com.waiwing.Shop.service.temp;

import com.waiwing.Shop.model.Banner;
import com.waiwing.Shop.model.Temp;
import com.waiwing.Shop.repository.BannerRepository;
import com.waiwing.Shop.repository.TempRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TempServiceImpl implements TempService {

    @Autowired
    private TempRepository tempRepository;

    public Temp getById(Long  id) {
        return   tempRepository.findOneById(id);
    }
}
