package com.tap.StudentApi.entity;


import jakarta.annotation.Generated;
import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")

      private  Integer id;
    @Column(name="name")
      private  String name;
    @Column(name="department")
      private  String department;
    @Column(name="collegeaddress")
      private  String collegeaddress;


    public Student()
    {

    }

    public Student(Integer id, String name, String department, String collegeaddress) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.collegeaddress = collegeaddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCollegeaddress() {
        return collegeaddress;
    }

    public void setCollegeaddress(String collegeaddress) {
        this.collegeaddress = collegeaddress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", depaetment='" + department + '\'' +
                ", collegeaddress='" + collegeaddress + '\'' +
                '}';
    }
}
