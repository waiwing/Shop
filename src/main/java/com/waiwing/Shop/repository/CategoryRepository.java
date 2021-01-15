package com.waiwing.Shop.repository;

import com.waiwing.Shop.model.Category;
import com.waiwing.Shop.model.Temp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Temp findOneById(Long id);
    List<Category> findAllByIsRootOrderByIndexAsc(Boolean isRoot);
}
