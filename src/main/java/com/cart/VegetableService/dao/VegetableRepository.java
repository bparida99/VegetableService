package com.cart.VegetableService.dao;

import com.cart.VegetableService.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VegetableRepository extends JpaRepository<Vegetable,Long> {
}
