package com.Magazine.Controller;

/**
 * @author jinpeng
 * a strategy implements an interface to achieve strategy pattern
 */
public class GoldStrategy implements MembershipStrategy{
	private double moneyRebate = 1d;
	
	/**
	 * @param moneyRebate double value discount for gold membership
	 */
	public GoldStrategy(double moneyRebate) {
		this.moneyRebate = moneyRebate;
	}
	
	/* (non-Javadoc)
	 * @see com.Magazine.Controller.MembershipStrategy#discount(double): final total price for gold membership
	 */
	@Override
	public double discount(double money) {
		return money * moneyRebate;	
	}

}
