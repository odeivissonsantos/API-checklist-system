package com.odeivissonsantos.checklistapp.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@Entity
@Table(indexes = {@Index(name = "IDX_GUID_CAT", columnList = "guid")})
public class Categoria extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoriaId;
	
	@Column(unique = true)
	private String nome;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	private List<CheckListItem> checkListItem;

}
