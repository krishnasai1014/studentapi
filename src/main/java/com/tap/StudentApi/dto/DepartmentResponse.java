package com.tap.StudentApi.dto;

import com.tap.StudentApi.entity.Student;

import java.util.List;

public class DepartmentResponse {

    private long count;
    private List<Student> students;

    public DepartmentResponse(long count, List<Student> students) {
        this.count = count;
        this.students = students;
    }

    public long getCount() {
        return count;
    }

    public List<Student> getStudents() {
        return students;
    }
}
