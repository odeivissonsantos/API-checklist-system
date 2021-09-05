package com.odeivissonsantos.checklistapp.repositorys;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.odeivissonsantos.checklistapp.models.Categoria;
import com.odeivissonsantos.checklistapp.models.CheckListItem;

public interface CategoriaRepository extends PagingAndSortingRepository<Categoria, Long>{
	
	Optional<CheckListItem> findByGuid(String guid);

}
