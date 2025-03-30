package com.elearn.portal.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.elearn.portal.entity.Student;
import com.elearn.portal.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
 @GetMapping
    public List<Student> getAllUsers()
    {
        return studentService.getAllStudent();
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        // Check if the student exists
        Student existingStudent = studentService.getStudentById(id);
        if (existingStudent == null) {
            // Handle student not found scenario (404 response)
            return null; // or throw a custom exception with a meaningful message
        }

        // Update the existing student with new data
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setCourse(updatedStudent.getCourse()); // Use the course ID as reference

        // Save the updated student and return it
        return studentService.createStudent(existingStudent); // You can reuse createStudent method for saving
    }
   // Endpoint to check if a student is enrolled in a course
    @GetMapping("/check-enrollment")
    public ResponseEntity<String> checkEnrollment(
            @RequestParam String email,
            @RequestParam String course) {

        String message = studentService.checkIfStudentEnrolled(email, course);
        return ResponseEntity.ok(message);
    }

    // Endpoint to enroll a student in a course
    @PostMapping("/enroll")
    public ResponseEntity<String> enrollStudent(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String course) {

        String message = studentService.enrollStudent(name, email, course);
        return ResponseEntity.ok(message);
    }
}
