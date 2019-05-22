package com.foodcourt.model;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String name;
	private BigDecimal salesPrice;
	private BigDecimal unitPrice;
	
	private Brand brand;
	private UOM uom;
	private StoreType storeType;
	private Batch batch;
	

}
