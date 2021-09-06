package com.odeivissonsantos.checklistapp.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
public class CheckListItem extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long checkListItemId;
	
	@Column
	private String descricao;
	
	@Column
	private Boolean completo;
	
	@Column
	@JsonFormat(pattern = "yy/MM/aaaa")
	private LocalDate dataAbertura;
	
	@Column
	@JsonFormat(pattern = "yy/MM/aaaa")
	private LocalDate dataFechamento;
	
	@JsonBackReference
	@ManyToOne
	private Categoria categoria;
}
