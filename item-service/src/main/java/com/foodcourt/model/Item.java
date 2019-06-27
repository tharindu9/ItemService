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
import javax.persistence.OneToMany;
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
	
	@NotNull(message = "name should not be null")
	private String name;
	
	@NotNull(message = "Sales price can not be null")
	@Min(1)
	private BigDecimal salesPrice;
	
	@NotNull(message = "Unit price can not be null")
	@Min(1)
	private BigDecimal unitPrice;

	private BigDecimal discount;

	@NotNull(message = " re-order level can not be null")
	@Min(1)
	private Integer reOrederLever;
	@NotNull(message = "max-order level can not be null")
	@Min(1)
	private Integer maxOrder;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn
	private Batch batch;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn

	private ItemType itemType;
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn
	private UOM uom;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn
	private StoreType storeType;
	
	@ManyToOne
	@JoinColumn
	private Brand brand;
	
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	private Integer criticalLevel;
	

	public Integer getCriticalLevel() {
		return criticalLevel;
	}
	public void setCriticalLevel(Integer criticalLevel) {
		this.criticalLevel = criticalLevel;
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
//		if(discount == BigDecimal.valueOf(0)) {
//			this.salesPrice = salesPrice;
//		}
//		else {
//			BigDecimal dis = new BigDecimal("100");
//			this.salesPrice= salesPrice.multiply(discount).divide(dis);
//		}
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
	public Integer getReOrederLever() {
		return reOrederLever;
	}

	public void setReOrederLever(Integer reOrederLever) {
		this.reOrederLever = reOrederLever;
	}

	public Integer getMaxOrder() {
		return maxOrder;
	}

	public void setMaxOrder(Integer maxOrder) {
		this.maxOrder = maxOrder;
	}


}
