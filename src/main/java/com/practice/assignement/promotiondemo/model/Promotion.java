package com.practice.assignement.promotiondemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Promotion {
	@Id
	@GeneratedValue
	int id;
	int type; // 1=Single Type , 2= Hybrid type
	String sku;
	int quantity;
	String sku1;
	int discount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSku1() {
		return sku1;
	}

	public void setSku1(String sku1) {
		this.sku1 = sku1;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Promotion(int type, String sku, int quantity, int discount) {
		super();
		this.type = type;
		this.sku = sku;
		this.quantity = quantity;
		this.discount = discount;
	}

	public Promotion(int type, String sku, String sku1, int discount) {
		super();
		this.type = type;
		this.sku = sku;
		this.sku1 = sku1;
		this.discount = discount;
	}

	protected Promotion() {
		super();	
	}
}
