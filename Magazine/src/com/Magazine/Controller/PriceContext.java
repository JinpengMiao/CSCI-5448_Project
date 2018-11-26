package com.Magazine.Controller;

/**
 * @author jinpeng
 * a client to get the discounted price.
 */
public class PriceContext {
	private MembershipStrategy membershipStrategy;	
	private String level;
	/**
	 * @param level String value pionts to different membership level and corresponding discounts
	 */
	public PriceContext(String level){
		this.level = level;
		switch(level){
			case "Gold":
				membershipStrategy = new GoldStrategy(0.8);
				break;
			case "Silver":
				membershipStrategy = new SilverStrategy(0.9);
				break;
			case "Ordinary":
				membershipStrategy = new OrdinaryStrategy();
				break;
		}
	}	
	/**
	 * @param money double value the original price
	 * @return return the discounted price
	 */
	public double getReslt(double money){
		return membershipStrategy.discount(money);
	} 
}
