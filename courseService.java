package com.elearn.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearn.portal.entity.Course;

import com.elearn.portal.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
 public List<Course> getAllCourses() {
       return courseRepository.findAll();
    }
     public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }
    //JPQL Methods
    public List<Course> findCoursesByTitle(String title)
   {
        return courseRepository.findCoursesByTitle(title);
   }
 
}
