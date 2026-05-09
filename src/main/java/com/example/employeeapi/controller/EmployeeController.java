package com.example.employeeapi.controller;

import com.example.employeeapi.entity.Employee;
import com.example.employeeapi.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController
{
    @Autowired
     private EmployeeRepository employeeRepository;

     // to get any specific row we need to use the get mapping
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id)
    {
        return employeeRepository.findById(id).orElse(null);
    }
  // to delete any specific row by using delete mapping we can delete by using  the fields
    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable int id)
    {
        employeeRepository.deleteById(id);
        return "Employee has been Deleted Successfully";
    }


    // to get all row we need to use the get mapping to get all data in the database
    @GetMapping
    public List<Employee> getallEmployeesById()
    {
        return employeeRepository.findAll();
    }


    // put mapping if we want to change any data in specific row that time we need to give all filed  to change the data
    @PutMapping("/{id}")
    public Employee updateEmployeeById(@PathVariable int id ,@RequestBody Employee updatedemployee)
    {
         Employee employee = employeeRepository.findById(id).orElse(null);

                 if(employee!=null)
                 {
                     employee.setEmpName(updatedemployee.getEmpName());
                     employee.setEmpRole(updatedemployee.getEmpRole());
                     employee.setEmpSalary(updatedemployee.getEmpSalary());

                     return employeeRepository.save(employee);

                 }
                 return null;
    }


    // patch mapping use for changing the specific data only we do not give the full body

@PatchMapping("/{id}")
    public Employee updateEmployeeBypatch(@PathVariable int id , @RequestBody Employee employee)
    {
       Employee employeebypatch= employeeRepository.findById(id).orElse(null);

       if(employee.getEmpName()!=null)
       {
           employeebypatch.setEmpName(employee.getEmpName());
       }
       if(employee.getEmpRole()!=null)
       {
           employeebypatch.setEmpRole((employee.getEmpRole()));
       }
       if (employee.getEmpSalary()!=0)
       {
           employeebypatch.setEmpSalary(employee.getEmpSalary());
       }

       return employeeRepository.save(employeebypatch);
    }


    @PostMapping
    public Employee addEmployee(@Valid @RequestBody Employee employee) {

        return employeeRepository.save(employee);
    }


}
