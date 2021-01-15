package com.waiwing.Shop.service.Spu;

import com.waiwing.Shop.model.Spu;
import org.springframework.data.domain.Page;

public interface SpuService {
    public Spu getSpu(Long id);
    public Page<Spu> getLatestPagingSpu(Integer pageNum, Integer size);
   public   Page<Spu> getByCategory(long cid, Boolean isRoot, Integer pageNum , Integer size);
    }
