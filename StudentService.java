package com.elearn.portal.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.elearn.portal.entity.Student;
import com.elearn.portal.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
     public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }
    
        // Method to check if a student is already enrolled in a course
        public String checkIfStudentEnrolled(String email, String course) {
            Student existingStudent = studentRepository.findByEmailAndCourse(email, course);
    
            if (existingStudent != null) {
                return "Student is already enrolled in this course.";
            }
    
            return "Student is not enrolled in this course.";
        }
    
        // Method to enroll a student if not already enrolled
        public String enrollStudent(String name, String email, String course) {
            // First, check if the student is already enrolled
            Student existingStudent = studentRepository.findByEmailAndCourse(email, course);
    
            if (existingStudent != null) {
                return "Student is already enrolled in this course.";
            }
    
            // If not enrolled, create a new student and enroll
            Student newStudent = new Student();
            newStudent.setName(name);
            newStudent.setEmail(email);
            newStudent.setCourse(course);
    
            // Save the student to the repository
            studentRepository.save(newStudent);
    
            return "Student enrolled successfully.";
        }
        public List<Student> getAllStudent() {
       return studentRepository.findAll();
    }
    }
