package com.Magazine.Controller;

/**
 * @author jinpeng
 * Strategy pattern: interface implemented by concrete strateies
 */
public interface MembershipStrategy {
	/**
	 * @param money double value the original total price
	 * @return abstract method overrided by concrete methods, return discounted price
	 */
	public abstract double discount(double money);
}
