package com.Magazine.Controller;

/**
 * @author jinpeng
 * create an interface for decorator pattern
 */
public interface AbstractMagazine {

	/**
	 * @return double value return the price of plain magazines or decorators
	 */
	public abstract double price();
}
