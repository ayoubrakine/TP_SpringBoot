package com.example.demo1.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo1.entity.*;
import com.example.demo1.repository.*;

@RestController
@RequestMapping("students")

//un préfixe pour toutes les URL  /students/save

public class StudentController {
	
	//@Autowired : Cette annotation indique que la classe StudentRepository doit être injectée automatiquement par Spring dans la variable studentRepository. Cela permet au contrôleur d'accéder à la couche de données pour les étudiants.
	
	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping("/save")
	//@RequestBody Student student, cela signifie que la méthode save du contrôleur (StudentController) attend un objet de type Student comme paramètre, et ce paramètre sera extrait des données du corps de la requête HTTP.
	public void save(@RequestBody Student student) {
		studentRepository.save(student); 
	}
			
	//(@PathVariable) qui correspond à l'ID de l'étudiant à supprimer. La méthode recherche d'abord l'étudiant par son ID, puis le supprime en utilisant le studentRepository.
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(required = true) String id) {
		Student s = studentRepository.findById(Integer.parseInt(id));
		studentRepository.delete(s);
	}

	@GetMapping("/all")
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@GetMapping(value = "/count")
	public long countStudent() {
		return studentRepository.count();
	}

	@GetMapping(value = "/byYear")
	public Collection<?> findByYear() {
		return studentRepository.findNbrStudentByYear();
	}
}