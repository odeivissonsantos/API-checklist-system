package com.odeivissonsantos.checklistapp.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.odeivissonsantos.checklistapp.exceptions.CategoriaServiceException;
import com.odeivissonsantos.checklistapp.exceptions.ResourceNotFoundException;
import com.odeivissonsantos.checklistapp.models.Categoria;
import com.odeivissonsantos.checklistapp.models.CheckListItem;
import com.odeivissonsantos.checklistapp.repositorys.CategoriaRepository;
import com.odeivissonsantos.checklistapp.repositorys.CheckListItemRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CategoriaService {
	
	private CheckListItemRepository checkListItemRepository;
	private CategoriaRepository categoriaRepository;
	
	public Categoria create(Categoria categoria) {
		categoria.setGuid(UUID.randomUUID().toString());
		return this.categoriaRepository.save(categoria);
	}
	
	public Categoria update(String guid, Categoria categoriaAtualizado) {
		categoriaRepository.findByGuid(guid).orElseThrow(
											() -> new ResourceNotFoundException("Categoria não encontrada!"));
		//categoriaAtualizado.setGuid(guid);
		return this.categoriaRepository.save(categoriaAtualizado);
	}
	
	public void deleteById(String guid) {
		 Categoria categoria = this.categoriaRepository.findByGuid(guid).orElseThrow(
				() -> new ResourceNotFoundException("Categoria não encontrada"));
		 
		 List<CheckListItem> checkListItens = this.checkListItemRepository.findByCategoriaGuid(guid);
		 if(!CollectionUtils.isEmpty(checkListItens)) {
			 throw new CategoriaServiceException ("Não é possível deletar, ainda há itens na categoria!");
		 }
		 
		this.categoriaRepository.delete(categoria);
	}
	
	public Categoria findByCategoriaGuid(String guid) {
		return this.categoriaRepository.findByGuid(guid).orElseThrow(
				() -> new ResourceNotFoundException("Categoria não encontrada"));
	}
	
	public Iterable<Categoria> findAllCategorias() {
		return this.categoriaRepository.findAll();
	}
	
	
}














