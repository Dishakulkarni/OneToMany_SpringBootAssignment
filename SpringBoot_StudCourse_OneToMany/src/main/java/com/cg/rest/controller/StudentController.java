package com.cg.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rest.entity.Student;
import com.cg.rest.exception.NoSuchStudentFoundException;
import com.cg.rest.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService service;
	
	
	@PostMapping("/addstud")
	public ResponseEntity<Student> add(@RequestBody Student student){
		try {
			Student stud = service.createStudent(student);
			return new ResponseEntity<>(stud,HttpStatus.CREATED);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().build();	
		}
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Student>> getAll(){
		try {
			return ResponseEntity.ok(service.findAllStudent());
			
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().build();	
		}
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Student> getById(@PathVariable("id") int id){
		try {
			return ResponseEntity.ok(service.findStudentById(id));
		}
		catch(NoSuchStudentFoundException ex) {
			return ResponseEntity.notFound().build();
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().build();		
		}
	}
	
	@GetMapping("/getbyroll/{roll}")
	public ResponseEntity<Student> getByRoll(@PathVariable("roll")int roll){
		try {
			return ResponseEntity.ok(service.findByRoll(roll));
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().build();	
		}
	}
	
	@GetMapping("/getbycoursename/{name}")
	public ResponseEntity<List<Student>> getByCourseName(@PathVariable("cname")String courseName){
		try {
			return ResponseEntity.ok(service.findByCourseName(courseName));
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().build();	
		}
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> update(@RequestBody Student student,@PathVariable("id") int id){
		try {
			return ResponseEntity.accepted().body(service.updateStudent(id, student));	
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().build();	
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity delete(@PathVariable("id")int id) {
		try {
			return new ResponseEntity(service.deleteStudent(id), HttpStatus.ACCEPTED);
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().build();	
		}
	}
}
