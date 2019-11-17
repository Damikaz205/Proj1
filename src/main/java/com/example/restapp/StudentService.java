package com.example.restapp;

import com.example.restapp.db.StudentRepository;
import com.example.restapp.db.StudentRow;
import io.vavr.collection.List;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class StudentService {
    //List<Student> students = List.empty();

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

//    List<Student> getStudents() {
////        return this.students;
//        throw new UnsupportedOperationException();
//    }

    List<Student> getStudents() {
        return List.ofAll(this.repository.findAll())
                .map(getStudentRowStudentFunction());
    }

    private Function<StudentRow, Student> getStudentRowStudentFunction() {
        return dbObj ->
                new Student(
                        dbObj.getId(),
                        dbObj.getName(),
                        dbObj.getNumber(),
                        dbObj.getGroup1());
    }

//    Student addStudent(NewStudent newStudent) {
//        Student created = new Student(students.size()+1, newStudent.name, newStudent.numer, newStudent.grupa);
//        students = students.prepend(created);
//        return created;
//    }

    Student addStudent(final NewStudent newStudent) {
        //throw new UnsupportedOperationException();
        StudentRow created = this.repository.save(new StudentRow(
                newStudent.name,
                newStudent.numer,
                newStudent.grupa));
        return getStudentRowStudentFunction().apply(created);
    }
}
