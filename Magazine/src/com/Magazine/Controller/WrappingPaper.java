package com.Magazine.Controller;

/**
 * @author jinpeng
 * wrapping paper(extends abstract class Decorators) is a decorator, and override the price() method
 */
public class WrappingPaper extends Decorators {
	public AbstractMagazine magazine;
	/**
	 * @param magazine interface AbstractMagazine to achieve decorator pattern
	 */
	public WrappingPaper(AbstractMagazine magazine) {
		this.magazine = magazine;
	}
	/* (non-Javadoc)
	 * @see com.Magazine.Controller.Decorators#price(): price for wrapping paper
	 */
	@Override
	public double price() {
		return magazine.price() + 5;
	}

}
