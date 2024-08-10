package com.jpa.test.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.test.Entities.Course;

public interface CourseRepo extends JpaRepository<Course,Long> {

}
