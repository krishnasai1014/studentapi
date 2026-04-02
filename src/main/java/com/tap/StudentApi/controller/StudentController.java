package com.tap.StudentApi.controller;


import com.tap.StudentApi.entity.Student;
import com.tap.StudentApi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController
{
    @Autowired
    StudentService ss;

    @PostMapping
    public Student saveStudent(@RequestBody Student s)
    {
         return ss.saveStudent(s);
    }

    @GetMapping
    public List<Student> getAllStudent()
    {
        return ss.getallStudent();
    }

    @GetMapping("/{id}")
    public  Student getStudentById(@PathVariable int id)
    {
        return  ss.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public  String  deleteStudent(@PathVariable int id)
    {
        return ss.deleteStudent(id);
    }

}
