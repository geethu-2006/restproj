package com.elearn.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.elearn.portal.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c FROM Course c WHERE c.title = :title")
    List<Course> findCoursesByTitle(@Param("title") String title);

    // @Query("SELECT c FROM Course c WHERE c.instructor NOT LIKE :instructor")
    // List<Course> findCoursesNotTaughtByInstructor(@Param("instructor") String instructor);
    // @Query("SELECT c.id, c.title, COUNT(s.id) FROM Course c LEFT JOIN Student s ON c.id = s.courseId GROUP BY c.id")
    // List<Object[]> countStudentsInEachCourse();
    //   @Query("SELECT c FROM Course c JOIN Student s ON c.id = s.courseId GROUP BY c.id HAVING COUNT(s.id) > 0")
    // List<Course> findCoursesWithStudents();
}
