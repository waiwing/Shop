package com.waiwing.Shop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class SpuDetailImg extends BaseEntity{
    @Id
    private Long id;
    private String img;
    private Long spuId;
    private Integer index;
   }
