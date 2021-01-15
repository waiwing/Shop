package com.waiwing.Shop.vo;

import com.waiwing.Shop.model.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
public class CategoryPureVO {
    private Long id;
    private String name;
    private String description;
    private Boolean isRoot;
    private String img;
    private Integer index;

    public CategoryPureVO(Category category) {
        BeanUtils.copyProperties(category, this);
    }
}
