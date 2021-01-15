package com.waiwing.Shop.service.BannerService;

import com.waiwing.Shop.model.Banner;
import com.waiwing.Shop.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    public Banner getByName(String name) {
        return   bannerRepository.findOneByName(name);


    }
}
