package com.Magazine.Model;

/**
 * @author jinpeng
 * This class contains all the magazine information in the shopping cart
 */
public class ShoppingCart {
    private String type;
    private String name;
    private String date;
    private String decorator;
	private double price;
    
	/**
     * @param type String value magazine type
     * @param name String value magazine name
     * @param date String value magazine release date
     * @param decorator String value magazine decorators 
     * @param price Double value magazine price
     */
    public ShoppingCart(String type, String name, String date, String decorator, Double price) {
    	this.type=type;
    	this.name=name;
    	this.date=date;
    	this.decorator=decorator;
    	this.price=price;
    }
    /**
	 * @return returning String value magazine type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param setting String value magazine type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return returning String value magazine name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param setting String value magazine name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return returning String value magazine release date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param setting String value magazine release date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return returning String value magazine decorators
	 */
	public String getDecorator() {
		return decorator;
	}
	/**
	 * @param setting String value magazine decorators
	 */
	public void setDecorator(String decorator) {
		this.decorator = decorator;
	}
	/**
	 * @return returning Double value magazine price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param setting Double value magazine price
	 */
	public void setPrice(double price) {
		this.price = price;
	}  
}
