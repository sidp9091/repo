package com.example.springDemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springDemo.model.Classes;
import com.example.springDemo.model.Schools;
import com.example.springDemo.model.Student;
import com.example.springDemo.model.Teachers;
import com.example.springDemo.repository.ClassesRepository;
import com.example.springDemo.repository.SchoolRepository;
import com.example.springDemo.repository.StudentRepository;
import com.example.springDemo.repository.TeachersRepository;
import com.example.springDemo.service.SchoolsService;

@RestController
@RequestMapping("/api")
public class SchoolsMainController {

	@Autowired
	SchoolRepository schoolRepository;
	@Autowired
	SchoolsService schoolsService;
	@GetMapping("/schools")
	public List<Schools> getAllSchools() {
		return schoolRepository.findAll();
	}

	@GetMapping("/schools/{id}")
	public ResponseEntity<Schools> getNoteById(@PathVariable(value = "id") Long schoolId) {
		Schools note = schoolRepository.findOne(schoolId);
		if(note == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(note);
	}

	@PostMapping("/schools")
	public Schools createSchoolDtls(@Valid @RequestBody Schools schl) {
		return schoolRepository.save(schl);
	}

	@PutMapping("/schools/{id}")
	public ResponseEntity<Schools> updateNote(@PathVariable(value = "id") Long schoolId,
			@Valid @RequestBody Schools schoolDetails) {
		Schools note = schoolRepository.findOne(schoolId);
		if(note == null) {
			return ResponseEntity.notFound().build();
		}
		note.setSchoolNm(schoolDetails.getSchoolNm());
		note.setLocation(schoolDetails.getLocation());


		Schools updatedNote = schoolRepository.save(note);
		return ResponseEntity.ok(updatedNote);
	}

	@DeleteMapping("/schools/{id}")
	public ResponseEntity<Schools> deleteNote(@PathVariable(value = "id") Long noteId) {
		Schools note = schoolRepository.findOne(noteId);
		if(note == null) {
			return ResponseEntity.notFound().build();
		}
		schoolRepository.delete(note);
		return ResponseEntity.ok().build();
	}



	@PostMapping("/teachers")
	public Teachers createTeacherDtls(@Valid @RequestBody Teachers trch) {
		return schoolsService.createTeacherDtls(trch);
	}

	@GetMapping("/teachers")
	public List<Teachers> getAllTeachers() {
		return schoolsService.getAllTeachers();
	}

	@GetMapping("/teachers/{id}")
	public List<Teachers> getAllTeachersBySchool(@PathVariable(value = "id") Schools schoolId) {
		return schoolsService.getAllTeachersBySchool(schoolId);
	}

	@PostMapping("/classes")
	public Classes createClassDtls(@Valid @RequestBody Classes cls) {
		return schoolsService.createClassDtls(cls);
	}

	@GetMapping("/classes")
	public List<Classes> getAllClasses() {
		return schoolsService.getAllClasses();
	}

	@GetMapping("/classes/{id}")
	public List<Classes> getAllClassesByTeachers(@PathVariable(value = "id") Teachers teacherId) {
		return schoolsService.getAllClassesByTeachers(teacherId);
	}


	@PostMapping("/student")
	public Student createStudentDtls(@Valid @RequestBody Student sts) {
		return schoolsService.createStudentDtls(sts);
	}

	@GetMapping("/student")
	public List<Student> getAllStudents() {
		return schoolsService.getAllStudents();
	}

	@GetMapping("/student/{id}")
	public List<Student> getAllStudentByClasse(@PathVariable(value = "id") Classes classeId) {
		return schoolsService.getAllStudentByClasse(classeId);
	}



}
