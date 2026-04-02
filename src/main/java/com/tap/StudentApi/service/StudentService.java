package com.tap.StudentApi.service;

import com.tap.StudentApi.Repository.StudentRepository;
import com.tap.StudentApi.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService
{
    @Autowired
    StudentRepository repo;


    // insert the data
    public Student saveStudent(Student s)
    {
         return repo.save(s);
    }

    // get all students data

    public List<Student> getallStudent()
    {
        return repo.findAll();
    }

    // by using id we can get data
    public Student getStudentById(int id)
    {
        Optional<Student>s=  repo.findById(id);

        if(s.isPresent())
        {
           return s.get();
        }
        return null;
    }


    public   String deleteStudent(int id)
    {
          repo.deleteById(id);
          return "Deleted Successfull";
    }


}
