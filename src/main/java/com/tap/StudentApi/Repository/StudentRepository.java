package com.tap.StudentApi.Repository;

import com.tap.StudentApi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>
{


}
