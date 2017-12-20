package com.example.springDemo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springDemo.model.Schools;
import com.example.springDemo.model.Teachers;


 
public interface TeachersRepository extends JpaRepository<Teachers, Long> {

	List<Teachers> findBySchools(Schools schools);
	
}
