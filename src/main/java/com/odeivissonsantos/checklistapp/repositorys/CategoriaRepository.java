package com.odeivissonsantos.checklistapp.repositorys;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.odeivissonsantos.checklistapp.models.Categoria;

@Repository
public interface CategoriaRepository extends PagingAndSortingRepository<Categoria, Long>{
	
	Optional<Categoria> findByGuid(String guid);
	Optional<Categoria> deleteByGuid(String guid);

}
