package com.cg.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.rest.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Integer>{
}
