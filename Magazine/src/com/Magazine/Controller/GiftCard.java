package com.Magazine.Controller;

/**
 * @author jinpeng
 * gift card(extends abstract class Decorators) is a decorator, and override the price() method
 */
public class GiftCard extends Decorators {
	public AbstractMagazine magazine;
	/**
	 * @param magazine interface AbstractMagazine to achieve decorator pattern
	 */
	public GiftCard(AbstractMagazine magazine) {
		this.magazine = magazine;
	}
	/* (non-Javadoc)
	 * @see com.Magazine.Controller.Decorators#price(): price for gift card
	 */
	@Override
	public double price() {
		return magazine.price() + 25;
	}

}
