package com.odeivissonsantos.checklistapp.models;

import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@MappedSuperclass
public class BaseEntity {
	
	private String guid;

}
