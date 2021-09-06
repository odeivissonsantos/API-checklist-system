package com.odeivissonsantos.checklistapp.repositorys;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.odeivissonsantos.checklistapp.models.CheckListItem;

@Repository
public interface CheckListItemRepository extends PagingAndSortingRepository<CheckListItem, Long> {
	
	Optional<CheckListItem> findByGuid(String guid);
	
	List<CheckListItem> findByCategoriaGuid(String guid);
	

}
