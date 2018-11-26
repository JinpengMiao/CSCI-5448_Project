package com.Magazine.Controller;

/**
 * @author jinpeng
 * bookmark(extends abstract class Decorators) is a decorator, and override the price() method
 */
public class Bookmark extends Decorators {
	public AbstractMagazine magazine;
	
	/**
	 * @param magazine interface AbstractMagazine to achieve decorator pattern
	 */
	public Bookmark(AbstractMagazine magazine) {
		this.magazine = magazine;
	}

	/* (non-Javadoc)
	 * @see com.Magazine.Controller.Decorators#price(): price for bookmark
	 */
	@Override
	public double price() {
		return magazine.price() + 8;
	}

}

