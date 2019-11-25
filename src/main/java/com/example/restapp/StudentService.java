package com.example.restapp;

import com.example.restapp.db.StudentRepository;
import com.example.restapp.db.StudentRow;
import io.vavr.collection.List;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class StudentService {
	private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }


    List<Student> getStudents() {
        return List.ofAll(this.repository.findAll())
                .map(StudentRow::toStudent);
    }
    Student addStudent(final NewStudent newStudent) {
        return this.repository.save(new StudentRow(
                newStudent.name,
                newStudent.numer,
                newStudent.grupa)).toStudent();
    }
}
