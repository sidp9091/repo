package com.example.springDemo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springDemo.model.Classes;
import com.example.springDemo.model.Schools;
import com.example.springDemo.model.Teachers;


 
public interface ClassesRepository extends JpaRepository<Classes, Long> {

	List<Classes> findByTeachers(Teachers teachers);
	
}
