package com.jpa.test.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.test.Entities.Course;
import com.jpa.test.Repo.CourseRepo;
import com.jpa.test.services.CourseService;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CourseRepo repo;
	
	@GetMapping("/home")
	public String home()
	{
		return "This is home page";
	}
	
	//get the courses correct
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return this.courseService.getCourses();
	}
	
	//correct
	@GetMapping("/courses/{courseid}")
	public Optional<Course> getUserById(@PathVariable String courseid)
	{
		//return this.courseService.getCourse(Long.parseLong(courseid));
		return courseService.getCourse(Long.parseLong(courseid));
	}
	
	//correct
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course)
	{
		System.out.println(course);
		return this.courseService.addCourse(course);
	}
	
	//correct
	@DeleteMapping("/courses/{courseid}")
	public void DeleteCourse(@PathVariable String courseid)
	{
		//System.out.println(course);
		//return this.courseService.DeleteCourse(Long.parseLong(courseid));
		courseService.DeleteCourse(Long.parseLong(courseid));
		
	}
	
	@PutMapping("/courses/{courseid}")
	public void UpdateCourse(@PathVariable String courseid,
			@RequestBody Course course) 
	{
	courseService.update(Long.parseLong(courseid), course);	
	System.out.println(course);
	}
	
	
	
	
	
	
}
