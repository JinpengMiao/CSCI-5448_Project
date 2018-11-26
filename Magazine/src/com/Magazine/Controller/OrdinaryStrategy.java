package com.Magazine.Controller;

/**
 * @author jinpeng
 * a strategy implements an interface to achieve strategy pattern
 */
public class OrdinaryStrategy implements MembershipStrategy {

	/* (non-Javadoc)
	 * @see com.Magazine.Controller.MembershipStrategy#discount(double): ordinary membership: no dicount here
	 */
	@Override
	public double discount(double money) {
		return money;				
	}

}
