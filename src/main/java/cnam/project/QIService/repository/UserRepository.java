package cnam.project.QIService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cnam.project.QIService.entities.User;

public interface UserRepository extends JpaRepository<User, String>{
		 

}

