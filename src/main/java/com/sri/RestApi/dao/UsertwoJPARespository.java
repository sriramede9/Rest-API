package com.sri.RestApi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sri.RestApi.model.Usertwo;

@Repository
public interface UsertwoJPARespository extends JpaRepository<Usertwo, Integer> {

}
