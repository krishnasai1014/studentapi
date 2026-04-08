package com.tap.StudentApi.Repository;

import com.tap.StudentApi.dto.DepartmentCountDTO;
import com.tap.StudentApi.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer>
{

List<Student> findByDepartment(String department );

    List<Student> findByCollegeaddress(String collegeaddress);

    @Query(value="SELECT COUNT(*) FROM student WHERE department=:dept",nativeQuery = true)
   Long countStudentsByDepartment(String dept);

    List<Student> findByName(String name);
    @Query("SELECT new com.tap.StudentApi.dto.DepartmentCountDTO(s.department, COUNT(s)) FROM Student s GROUP BY s.department")
    List<DepartmentCountDTO> countStudentsGroupByDepartment();


    @Override
    Page<Student> findAll(Pageable pageable);

    Page<Student> findByDepartment(String department,Pageable pageable);


 List<Student>   findByDepartmentIgnoreCaseAndCollegeNameIgnoreCase(String dep,String collegeName);
}
