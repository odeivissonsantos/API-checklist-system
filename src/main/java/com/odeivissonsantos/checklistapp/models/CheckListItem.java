package com.odeivissonsantos.checklistapp.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(indexes = {@Index(name = "IDX_GUID_CK_IT", columnList = "guid")})
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
	
	@ManyToOne
	private Categoria categoria;
}
