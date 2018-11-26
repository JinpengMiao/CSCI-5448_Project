package com.Magazine.Controller;

/**
 * @author jinpeng
 * abstract class Decorators implements interface AbstractMagazine and extended by other concrete decorators
 */
public abstract class Decorators implements AbstractMagazine{

	/* (non-Javadoc)
	 * @see com.Magazine.Controller.AbstractMagazine#price(): abstract method overrided by concreted methods
	 */
	@Override
	public abstract double price();

}
