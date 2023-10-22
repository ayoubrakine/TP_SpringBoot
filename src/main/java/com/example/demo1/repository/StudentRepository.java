package com.example.demo1.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo1.entity.Student; 
public interface StudentRepository extends JpaRepository<Student, Integer> { 
	// type de id de l'entity student est Integer
	Student findById(int id); 
	//  requête SQL
	@Query("select year(s.dateNaissance) as annee, count(*) as nbr from Student s group by year(s.dateNaissance) order by year(s.dateNaissance)") 
	Collection<?> findNbrStudentByYear(); 
	
}