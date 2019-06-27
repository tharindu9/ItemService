package com.foodcourt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity

public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;


	@NotNull(message = "manufacture date should not be null")
	private Date manufactureDate;

	@NotNull(message = "expire date should not be null")
	private Date expireDate;


	@NotNull(message = "enter date should not be null")
	private  Date enterDate;

	@NotNull(message=" Quantity should not be null ")
	private Long quantity;

	@OneToMany(mappedBy = "batch")
	@JsonIgnore
	private List<Item> items;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}


	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}




}
