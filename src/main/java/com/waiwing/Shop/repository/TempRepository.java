package com.waiwing.Shop.repository;

import com.waiwing.Shop.model.Temp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempRepository extends JpaRepository<Temp,Long> {
    Temp findOneById(Long id);
}
