package com.example.springDemo.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springDemo.model.Classes;
import com.example.springDemo.model.Schools;
import com.example.springDemo.model.Student;
import com.example.springDemo.model.Teachers;
import com.example.springDemo.repository.ClassesRepository;
import com.example.springDemo.repository.SchoolRepository;
import com.example.springDemo.repository.StudentRepository;
import com.example.springDemo.repository.TeachersRepository;

@Service
@Transactional
public class SchoolsService  {
	
	@Inject
	SchoolRepository schoolRepository;
	
	@Inject
	TeachersRepository teachersRepository;

	@Inject
	ClassesRepository classesRepository;

	@Inject
	StudentRepository studentRepository;

	public Student createStudentDtls(Student sts) {
		
		return studentRepository.save(sts);
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public List<Student> getAllStudentByClasse(Classes classeId) {
		return studentRepository.findByClasses(classeId);
	}

	public List<Classes> getAllClassesByTeachers(Teachers teacherId) {
		return classesRepository.findByTeachers(teacherId);
	}

	public List<Classes> getAllClasses() {
		return classesRepository.findAll();
	}

	public Classes createClassDtls(Classes cls) {
		return classesRepository.save(cls);
	}

	public List<Teachers> getAllTeachersBySchool(Schools schoolId) {
		return teachersRepository.findBySchools(schoolId);
	}

	public List<Teachers> getAllTeachers() {
		return teachersRepository.findAll();
	}

	public Teachers createTeacherDtls(Teachers trch) {
		return teachersRepository.save(trch);
	}

}
