package com.waiwing.Shop.vo;

import com.waiwing.Shop.model.Sku;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TempVO {
    private Long id;
    private String title;
    private String subtitle;
    private String img;
    private String price;
    private String discountPrice;
    private String description;
    private String tags;
    private String sketchSpecId;
    private Sku sku;
}
