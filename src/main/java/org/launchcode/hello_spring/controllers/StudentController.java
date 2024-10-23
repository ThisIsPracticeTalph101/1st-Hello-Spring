package org.launchcode.hello_spring.controllers;

import org.launchcode.hello_spring.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


//Coding practice from Udemy course: Spring Boot 3 & React JS: Full-Stack Java Development [2024]
@RestController
//@RequestMapping for base URL ex: ("students)
public class StudentController {

//    @GetMapping("student")
//    public Student getStudent(){
//        Student student = new Student(1, "Tiffany", "Hill");
//        return student;
//    }

    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1, "Tiffany", "Hill");
//        return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok(student);
    }


    @GetMapping("students")
    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Tiffany", "Hill"));
        students.add(new Student(2, "Beyonce", "Knowles"));
        students.add(new Student(3, "Jay Z", "Carter"));
        students.add(new Student(4, "Kelly", "Rowland"));
        return students;
    }

    //Spring Boot REST API with path variable
    //{id} IRI template variable
    @GetMapping("students/{id}/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable int id, @PathVariable String firstName, @PathVariable String lastName){
        return new Student(id, firstName, lastName);
    }

    //Spring boot REST API with Request Param
    //http://localhost:8080/students/query?id=1&firstName=Laila&lastName=Johns
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }

    //Spring Boot REST API that handles HTTP POST Request - creating new resource
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED) // can add for status
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return student;
    }

    //Spring Boot REST API that handles HTTP PUT Request -updating existing resource
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable int id){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    //Spring Boot REST API that handles HTTP DELETE Request -deleting the existing resource
    @DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable int id){
        System.out.println(id);
        return "Student deleted successfully!";
    }

}
