package cnam.project.QIService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cnam.project.QIService.entities.Student;

public interface StudentRepository extends JpaRepository<Student, String>{

}
