package com.waiwing.Shop.repository;

import com.waiwing.Shop.model.GridCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GridCategoryRepository extends JpaRepository<GridCategory,Long> {
 }
