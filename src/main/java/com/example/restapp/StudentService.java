package com.example.restapp;

import io.vavr.collection.List;

public class StudentService {
    List<Student> students = List.empty();

    List <Student> getStudents(){
        return this.students;
    }

    Student addStudent(NewStudent newStudent) {
        Student created = new Student(students.size()+1, newStudent.name, newStudent.numer, newStudent.grupa);
        students = students.prepend(created);
        return created;
    }
}
