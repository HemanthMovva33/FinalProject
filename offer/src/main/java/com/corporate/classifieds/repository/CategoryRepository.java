package com.corporate.classifieds.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corporate.classifieds.entity.Category;


public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
