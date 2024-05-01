package com.sidebar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sidebar.model.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {

}
