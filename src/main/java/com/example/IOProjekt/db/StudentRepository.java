package com.example.restapp.db;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentRow, Long> {

}

