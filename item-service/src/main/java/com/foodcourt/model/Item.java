package com.foodcourt.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String name;
	private BigDecimal salesPrice;
	private BigDecimal unitPrice;
	private Integer quantity;
	private BigDecimal discount;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private ItemType itemType;
	
	@ManyToOne
	@JoinColumn
	private UOM uom;
	
	@ManyToOne
	@JoinColumn
	private StoreType storeType;
	
	@ManyToOne
	@JoinColumn
	private Batch batch;
	
	public Integer getQuentity() {
		return quantity;
	}
	public void setQuentity(Integer quentity) {
		if(quentity!=0) {
			this.quantity = quentity;
		}
		else {
			//exception
		}
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(BigDecimal salesPrice) {
		if(salesPrice!= BigDecimal.valueOf(0)) {
			this.salesPrice = salesPrice;
		}
		else {
			//throw new value not match
		}
		
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		if(unitPrice!= BigDecimal.valueOf(0)) {
			this.unitPrice = salesPrice;
		}
		else {
			//throw new value not match
		}

	}
	
	public UOM getUom() {
		return uom;
	}
	public void setUom(UOM uom) {
		this.uom = uom;
	}
	public StoreType getStoreType() {
		return storeType;
	}
	public void setStoreType(StoreType storeType) {
		this.storeType = storeType;
	}
	public Batch getBatch() {
		return batch;
	}
	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public ItemType getItemType() {
		return itemType;
	}
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	

}
