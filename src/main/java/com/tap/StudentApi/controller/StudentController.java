package com.tap.StudentApi.controller;


import com.tap.StudentApi.dto.DepartmentCountDTO;
import com.tap.StudentApi.dto.DepartmentResponse;
import com.tap.StudentApi.entity.Student;
import com.tap.StudentApi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping("/department/{department}")
    public DepartmentResponse getStudentDep(@PathVariable String department)
    {
      return  ss.getStudentDep(department);
    }

    @GetMapping("/address/{collegeaddress}")
    public List<Student> getaddress(@PathVariable String collegeaddress)
    {
        return ss.getaddressbaseddetails(collegeaddress);
    }
/*
    @GetMapping("/departmetcount/{dep}")
    public void getDepCount(@PathVariable String dep)
    {
       // return "dep count:"+ss.getDepCount(dep);
    }*/

    @PutMapping("/{id}")
    public Student updateStudentdeatils(@PathVariable Integer id, @RequestBody Student s)
    {

     return   ss.updateStudentdeatils(id,s);
    }

    @PatchMapping("/{id}")
    public Student updateStudentPartial(@PathVariable Integer id, @RequestBody Student s)
    {

      return  ss.updateStudentPartial(id,s);

    }

    @GetMapping("/name/{name}")
    public List<Student> getStudentsByName(@PathVariable String name)
    {
        return ss.getStudentsByName(name);
    }

@GetMapping("/getDepartmentCount")
   public List<DepartmentCountDTO> getDepartmentCount()
    {
  return ss.getDepartmentCount();
    }


    //@GetMapping("/page/{page}/{size}")=api call:/student/page/0/3  [path variable style]
    @GetMapping("/page")//api call:GET http://localhost:8080/student/page?page=0&size=3
    public Page<Student> getStudentsPage(@RequestParam int page, @RequestParam int size)

    {
         return ss.getStudentsPage(page,size);
    }

    @GetMapping("/pages")
    public Page<Student> getStudentsPageSortingBasedUponName(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortField,
            @RequestParam String sortDir
    )
    {
    return  ss.getStudentsPageSortingBasedUponName(page,size,sortField,sortDir);
    }



   /* GET /student/page?page=0&size=2&sortField=name&sortDir=asc

    Meaning:

    page = 0 → first page
    size = 2 → 2 records per page
        sortField = name → sort using name column
    sortDir = asc → ascending order*/

@GetMapping("/particulardep/{dep}")
public Page<Student> getparticularDepartemntDetails(
        @PathVariable String dep,
        @RequestParam int page,
        @RequestParam int size
)
{
  return ss.getparticularDepartemntDetails(dep,page,size);
}


@GetMapping("/sortedparticlardep/{dep}")
    public Page<Student> getSortedParticlarDepartementDetails(
            @PathVariable String dep,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortField,
            @RequestParam String sortDir
)
{
  return   ss.getSortedParticlarDepartementDetails(dep,page,size,sortField,sortDir);

}


@GetMapping("/search")
public List<Student> getStudentsByDepartmentAndCollegeName(
        @RequestParam String dep,
        @RequestParam String collegeName
)
{
  return  ss.getStudentsByDepartmentAndCollegeName(dep,collegeName);
}
}
