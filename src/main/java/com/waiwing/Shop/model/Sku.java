package com.waiwing.Shop.model;

import com.waiwing.Shop.util.GenericAndJson;
import com.waiwing.Shop.util.MapAndJson;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;

@Entity
@Getter
@Setter
public class Sku extends BaseEntity {
    @Id
    private Long id;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private Boolean online;
    private String img;
    private String title;
    private Long spuId;


    //    @Convert(converter = ListAndJson.class)
//    private List<Spec> specs;
    private String specs;

    private String code;
    private BigDecimal stock;
    private Long categoryId;
    private Long rootCategoryId;

//    @Convert(converter = MapAndJson.class)
//    private Map<String, Object> test;


    public List<Spec> getSpecs() {
        if (this.specs == null) {
            return Collections.emptyList();
        }
        return GenericAndJson.jsonToObject(this.specs,new TypeReference<List<Spec>>(){} );
    }

    public void setSpecs(List<Spec> specs) {
        if (specs.isEmpty()) {
            return;
        }
        this.specs = GenericAndJson.objectToJson(specs);
    }
}
