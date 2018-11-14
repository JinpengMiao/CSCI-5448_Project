package com.Magazine.Model;

public class Magazine {
    public String type;
    public String name;
    public String date;
    public double price;
    
    public Magazine(String type, String name, String date, Double price) {
    	this.type=type;
    	this.name=name;
    	this.date=date;
    	this.price=price;
    }

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}   
}