package com.waiwing.Shop.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import  java.util.List;
@NoArgsConstructor
@Getter
@Setter
public class Paging<T> {

    //总数
    private Long total;

    private  Integer count;
    //页码
    private  Integer page;
    //总页码
    private Integer totalPage;
    private  List<T> items;

    public Paging(Page<T> pageT){
        this.initPageParamters(pageT);
        this.items = pageT.getContent();
    }

    void initPageParamters(Page<T> page){
        this.total = page.getTotalElements();
        this.count = page.getSize();
        this.page = page.getNumber();
        this.totalPage = page.getTotalPages();
    }
}
