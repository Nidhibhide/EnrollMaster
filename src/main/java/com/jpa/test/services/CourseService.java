package com.jpa.test.services;

import java.util.List;
import java.util.Optional;

import com.jpa.test.Entities.Course;

public interface CourseService{
	
	public List<Course> getCourses();
	
	public Optional<Course> getCourse(long couseid);
	
	public Course addCourse(Course course);
	
	public void DeleteCourse(long courseid);
	
	public Course update(long courseid,Course course);

}
