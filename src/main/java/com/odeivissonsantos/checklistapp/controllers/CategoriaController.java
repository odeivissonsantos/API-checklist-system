package com.odeivissonsantos.checklistapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odeivissonsantos.checklistapp.models.Categoria;
import com.odeivissonsantos.checklistapp.services.CategoriaService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	
	@PostMapping
	public ResponseEntity<Categoria> create(@RequestBody Categoria categoria) {
		return ResponseEntity.created(null).body(categoriaService.create(categoria));
	}
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAllCategoria() {
		return ResponseEntity.ok().body(categoriaService.findAllCategorias());
	}
	
	@GetMapping(value = "/{guid}")
	public ResponseEntity<Categoria> findByGuid(@PathVariable String guid) {
		return ResponseEntity.ok().body(categoriaService.findByCategoriaGuid(guid));
	}
	
	@DeleteMapping(value = "/{guid}")
	public ResponseEntity<Void> deleteByGuid(@PathVariable String guid) {
		categoriaService.deleteByGuid(guid);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{guid}")
	public ResponseEntity<Void> update (@PathVariable String guid, @RequestBody Categoria categoriaAtualizado){
		categoriaService.update(guid, categoriaAtualizado);
		return ResponseEntity.noContent().build();
	}
}







