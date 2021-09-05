package com.odeivissonsantos.checklistapp.repositorys;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.odeivissonsantos.checklistapp.models.CheckListItem;

public interface CheckListItemRepository extends PagingAndSortingRepository<CheckListItem, Long> {
	
	Optional<CheckListItem> findByGuid(String guid);

}
