package com.example.springDemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springDemo.model.Schools;


 
public interface SchoolRepository extends JpaRepository<Schools, Long> {

}
