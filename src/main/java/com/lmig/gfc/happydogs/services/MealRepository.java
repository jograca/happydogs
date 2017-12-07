package com.lmig.gfc.happydogs.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lmig.gfc.happydogs.model.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

}
