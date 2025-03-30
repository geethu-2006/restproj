package com.elearn.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.elearn.portal.entity.Course;

import com.elearn.portal.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }
 @GetMapping
    public List<Course> getAllUsers()
    {
        return courseService.getAllCourses();
    }
    @GetMapping("/{id}")
    public Course getCourse(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
        // Check if the course exists
        Course existingCourse = courseService.getCourseById(id);
        if (existingCourse == null) {
            // Handle course not found scenario (404 response)
            return null; // or throw a custom exception with a meaningful message
        }

        // Update the existing course with new data
        existingCourse.setTitle(updatedCourse.getTitle());
        existingCourse.setDescription(updatedCourse.getDescription());
        existingCourse.setInstructor(updatedCourse.getInstructor());

        // Save the updated course and return it
        return courseService.createCourse(existingCourse); // You can reuse createCourse method for saving
    }
    //JPQL Methods
      
    @GetMapping("/get/find-by/{title}")
    public List<Course> findCoursesByTitle(@PathVariable String title)
    {
        return courseService.findCoursesByTitle(title);
    }
}
