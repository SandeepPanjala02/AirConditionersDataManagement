package com.edubridge.airconditionersmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AirConditioner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String brand;
	private String model;
	private Double price;
	private Double powerRating;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Double getPowerRating() {
		return powerRating;
	}
	public void setPowerRating(Double poweRating) {
		this.powerRating = poweRating;
	}
	@Override
	public String toString() {
		return "AirConditioner [id=" + id + ", brand=" + brand + ", model=" + model + ", price=" + price
				+ ", powerRating=" + powerRating + "]";
	}
	
	
	
	

}
