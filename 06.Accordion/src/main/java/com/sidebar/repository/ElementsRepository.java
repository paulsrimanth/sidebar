package com.sidebar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sidebar.model.Elements;

@Repository
public interface ElementsRepository extends JpaRepository<Elements, Integer> {

}
