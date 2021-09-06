package com.odeivissonsantos.checklistapp.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.odeivissonsantos.checklistapp.models.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long>{
	
	Optional<Categoria> findByGuid(String guid);

}
