package com.tap.StudentApi.service;

import com.tap.StudentApi.Repository.StudentRepository;
import com.tap.StudentApi.dto.DepartmentResponse;
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

    public DepartmentResponse getStudentDep(String department)
    {

      /*  List<Student> allstudents = repo.findAll();
        ArrayList<Student>  students= new ArrayList<>();

        for(Student s:allstudents)
        {
            if(s.getDepartment().equals(dep))
            {
                students.add(s);
            }
        }

        return students;*/
        List<Student> students = repo.findByDepartment(department);

        Long count = repo.countStudentsByDepartment(department);

        return new DepartmentResponse(count,students);

    }

    public List<Student> getaddressbaseddetails(String collegeaddress)
    {
        return repo.findByCollegeaddress(collegeaddress);

    }

    /*public Long countStudentsByDepartment(String dep)
    {
        *//*List<Student> list = repo.findByDepartment(dep);
        System.out.println("list size:"+list.size());
        return list.size();*//*
        return 0;
    }*/

    public Student updateStudentdeatils(Integer id,Student s)
    {
        Optional<Student> existing = repo.findById(id);

        if(existing.isPresent())
        {
            Student student = existing.get();
          //  student.setId(id);
            student.setName(s.getName());
            student.setDepartment(s.getDepartment());
            student.setCollegeaddress(s.getCollegeaddress());
            return repo.save(student);
        }
        else {
            return null;
        }


    }

    public Student updateStudentPartial(Integer id, Student s)
    {

        Optional<Student> existing = repo.findById(id);

        if(existing.isPresent())
        {
            Student student = existing.get();
            if(s.getName()!=null)
            {
                student.setName(s.getName());
            }
            if(s.getDepartment()!=null)
            {
                student.setDepartment(s.getDepartment());
            }
            if(s.getCollegeaddress()!=null)
            {
                student.setCollegeaddress(s.getCollegeaddress());
            }
          return  repo.save(student);

        }
        else {
            return null;
        }
    }

    public List<Student> getStudentsByName(String name)
    {
        return repo.findByName(name);
    }

}
