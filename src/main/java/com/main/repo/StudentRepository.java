package com.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
