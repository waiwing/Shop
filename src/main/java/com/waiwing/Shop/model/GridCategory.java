package com.waiwing.Shop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Getter
@Setter
public class GridCategory extends BaseEntity {
    @Id
    private Long id;
    private String title;
    private String img;
    private String name;

    private Long categoryId;
    private Long rootCategoryId;
}
