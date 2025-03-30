package com.elearn.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.elearn.portal.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // Custom query to find all students for a given courseId
    // @Query("SELECT s FROM Student s WHERE s.courseId = :courseId")
    // List<Student> findStudentsByCourseId(@Param("courseId") Long courseId);
    Student findByEmailAndCourse(String email, String course);
}
