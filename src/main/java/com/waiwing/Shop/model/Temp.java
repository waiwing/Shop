package com.waiwing.Shop.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
 public class Temp extends  BaseEntity {
    @Id
    private Long id;
}

