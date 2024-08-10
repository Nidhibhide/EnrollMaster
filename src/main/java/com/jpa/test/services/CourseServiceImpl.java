package com.jpa.test.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.test.Entities.Course;
import com.jpa.test.Repo.CourseRepo;

import ch.qos.logback.classic.net.server.HardenedLoggingEventInputStream;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepo Repo;
	List<Course> list;
	
	public CourseServiceImpl() {
	
		/*list=new ArrayList<>();
		list.add(new Course(145,"Java Core Course","This Course contains basics of java"));
		list.add(new Course(146,"Spring boot Course","This Course contains spring boot "));*/
		
	}


	@Override
	public List<Course> getCourses() {
		
		return Repo.findAll();
	}


	@Override
	public Optional<Course> getCourse(long couseid) {
	
		/*Course c=null;
		for(Course course:list)
		{
			if(course.getId()==couseid)
			{
				c=course;
				break;
			}
		}*/
		System.out.println(Repo.findById(couseid));
		return Repo.findById(couseid);
	}
	@Override
	public Course addCourse(Course course) {
		/*list.add(course);*/
		Repo.save(course);
		return course;
	}
	@Override
	public void DeleteCourse(long courseid) {
	//Course c=null;
		/*for(Course course:list)
		{
		if(course.getId()==courseid)
		{
			c=course;
			list.remove(c);
			break;
		}
		}*/
		
		 Repo.deleteById(courseid);
	}


	@Override
	public Course update(long courseid, Course course) 
	{
		Optional<Course> optional=Repo.findById(courseid);
		Course c=optional.get();
		//c.setId(course.getId());
		c.setTitle(course.getTitle());
		c.setDescription(course.getDescription());
		
		return Repo.save(c);
		
	}

}
