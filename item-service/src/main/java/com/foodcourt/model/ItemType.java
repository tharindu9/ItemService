package com.foodcourt.model;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	
	@NotNull(message = "Name should not be null")
	String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn
	@JsonIgnore
	private Category category;
	
	@OneToMany(mappedBy = "itemType")
	@JsonIgnore
	private Set<Item> items;
	
	public ItemType() {
		
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public ItemType(Integer id, String name, Integer cid) {
		super();
		this.id = id;
		this.name = name;
		this.category = new Category(cid,"");
	}

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
