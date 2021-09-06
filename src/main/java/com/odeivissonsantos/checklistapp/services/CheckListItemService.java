package com.odeivissonsantos.checklistapp.services;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.odeivissonsantos.checklistapp.exceptions.ResourceNotFoundException;
import com.odeivissonsantos.checklistapp.models.CheckListItem;
import com.odeivissonsantos.checklistapp.repositorys.CheckListItemRepository;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class CheckListItemService {
	
	private CheckListItemRepository checkListItemRepository;
	//private CategoriaRepository categoriaRepository;
	
	public CheckListItem create(CheckListItem checkListItem) {
		checkListItem.setGuid(UUID.randomUUID().toString());
		checkListItem.setDataAbertura(LocalDate.now());
		return this.checkListItemRepository.save(checkListItem);
	}
	
	public CheckListItem update(String guid, CheckListItem checkListItemAtualizado) {
		checkListItemRepository.findByGuid(guid).orElseThrow(
											() -> new ResourceNotFoundException("Check List não encontrada!"));
		//categoriaAtualizado.setGuid(guid);
		return this.checkListItemRepository.save(checkListItemAtualizado);
	}
	
	public void deleteByGuid(String guid) {
		CheckListItem checkListItem = this.checkListItemRepository.findByGuid(guid).orElseThrow(
				() -> new ResourceNotFoundException("Check List não encontrada!"));
		 
		this.checkListItemRepository.delete(checkListItem);
	}
	
	public CheckListItem findByCheckListItemGuid(String guid) {
		return this.checkListItemRepository.findByGuid(guid).orElseThrow(
				() -> new ResourceNotFoundException("Check List não encontrada"));
	}
	
	public Iterable<CheckListItem> findAllCheckListItens() {
		return this.checkListItemRepository.findAll();
	}
	
	
}
