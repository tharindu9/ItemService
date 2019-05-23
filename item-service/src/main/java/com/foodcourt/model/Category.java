package com.foodcourt.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	@Column(unique = true)
	@NonNull
	String name;
	@OneToMany(mappedBy ="category", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonIgnore
	List<ItemType> types;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ItemType> getTypes() {
		return types;
	}
	public void setTypes(List<ItemType> types) {
		this.types = types;
	}
	
	public Category(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
		
	}
	public Category() {
		
	}

}
