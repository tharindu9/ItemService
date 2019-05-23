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
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.boot.archive.spi.ArchiveException;
import org.springframework.http.HttpStatus;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String name;
	@NotNull(message = "Sales price can not be null")
	@Min(1)
	private BigDecimal salesPrice;
	@NotNull(message = "Unit price can not be null")
	@Min(1)
	private BigDecimal unitPrice;
	@NotNull(message = "Sales price can not be null")
	@Min(1)
	private Integer quentity;
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
	
	private Integer criticalLevel;
	

	public Integer getCriticalLevel() {
		return criticalLevel;
	}
	public void setCriticalLevel(Integer criticalLevel) {
		this.criticalLevel = criticalLevel;
	}
	public Integer getQuentity() {
		return quentity;
	}
	public void setQuentity(Integer quentity) {
			this.quentity = quentity;
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
			this.salesPrice = salesPrice;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
			this.unitPrice = unitPrice;
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
