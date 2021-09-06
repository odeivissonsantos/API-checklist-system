package com.odeivissonsantos.checklistapp.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.odeivissonsantos.checklistapp.models.Categoria;
import com.odeivissonsantos.checklistapp.repositorys.CategoriaRepository;
import com.odeivissonsantos.checklistapp.repositorys.CheckListItemRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
		categoriaAtualizado.setGuid(guid);
		return this.categoriaRepository.save(categoriaAtualizado);
	}
	
}
